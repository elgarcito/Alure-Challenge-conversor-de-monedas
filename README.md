# Alure Challenge: Conversor de monedas

### ¡¡¡Hola!!!, Bienvenido a este repositorio

Aquí encontrarás la respuesta al desafío planteado en la segunda parte del curso
**Formaciones en programación** de
[Oracle Next Education](https://www.oracle.com/ar/education/oracle-next-education/).

### Acerca del desafío
El objetivo de este proyecto es poder aplicar cada uno de los módulos aprendidos
en el curso en un proyecto complejo:

### Un conversor de monedas

A continuación, presentaremos cómo se aplicó cada uno de los cursos en la resolución de
este desafío. El orden en que aparecerán a continuación fue en el cual se
resolvió el problema (no el orden propio de la plataforma).
Los pasos son los siguientes:

## Paso 1 diseño de los modelos
Se utilizaron los cursos:
1. Java: creando tu primera aplicación
2. Java: aplicando la Orientación a Objetos

Se crearon los objetos que representan nuestro modelo. 
Estos son las clases Menú y ConversionMoneda.
Se decidio tomar como objeto no a la moneda en sí, sino a la transacción


## Paso 2 leyendo opciones de un archivo
Se utilizaron los cursos:
1. Java: creando tu primera aplicación
2. Java: aplicando la Orientación a Objetos
3. Java: trabajar con listas y colecciones de datos


Se utilizo la lectura de un [json](opciones.json) precargado con las posibles opciones de conversión.
A partir de la función definirConversionyMonto utilizamos la opción elegida del usuario.
Este método se encuentra en la clase Menu.
```bash
 public void mostrarOpciones() {
        // Leer el archivo JSON
        FileReader reader = null;
        try {
            reader = new FileReader("opciones.json");
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = fileElement.getAsJsonArray();

            // Iterar a través del array
            int opcion = 1;
            for (JsonElement element : jsonArray) {
                JsonObject objeto = element.getAsJsonObject();
                String opciones = objeto.get("Opciones_de_conversion").getAsString();
                System.out.println(" Opción: " + opcion + "-----> " + opciones);
                opcion++;
            }
            //System.out.println("**********************************************");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
```

## Paso 3
Se utilizo el curso:
Java: consumir API, escribir archivos y manejar errores

Aquí se utilizó el siguiente codigo:

```bash
 public void realizarConversion(){

        //Leo la API Key desde un archivo
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("apiKey.txt"));
            String apiKeyValue = br.readLine();
            br.close();

            String finalUrl="https://v6.exchangerate-api.com/v6/"+apiKeyValue+"/pair/"+"/"+getNombreMonedaElegida()+"/"
                    +getNombreMonedaObjetivo();

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(finalUrl))
                    .build();

            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json=response.body();
            MonedaRecord monedaRecord=gson.fromJson(json, MonedaRecord.class);
            setValorMonedaObjetivo(Double.valueOf(monedaRecord.conversion_rate()));
            setMontoFinalMonedaObjetivo(getValorMonedaObjetivo()*getCantidadACambiar());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
```

Para conectarse a una API mediante HTTP. Se guardo la API key en un archivo separado para
mantener la seguridad

### Resumen final

Para copiar este repositorio en caso de necesitarlo:
1. Asegúrate de tener instalado Git en tu computadora. Si no lo tienes, puedes descargarlo desde [este link](https://git-scm.com/downloads).
2. Abre una terminal o ventana de comandos y navega hasta la carpeta raíz de tu repositorio local.
2. Ejecuta el siguiente comando para agregar todos los archivos modificados al área de preparación de Git:

```bash
  git clone this-repo-url
```

Tal como se indica en el desafío el proyecto no se deployo.

Como conclusión y a titulo personal, el desafío presento una complejidad acorde a la dificultad de los cursos.
Los contenidos de cada curso fueron aplicados directamente en el proyecto final, lo que indica una gran posibilidad
de aplicación de cada tema. 
La conexión con una API es un abre un gran abanico de posibilidades por lo cual el autor se encuentra muy satisfecho
con lo aprendido


### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.


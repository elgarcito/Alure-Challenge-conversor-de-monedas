# Alure Challenge: Conversor de monedas

### ¡¡¡Hola!!!, Bienvenido a este repositorio

Aquí encontrarás la respuesta al desafío planteado en la segunda parte del curso
**Formaciones en programacion** de
[Oracle Next Education](https://www.oracle.com/ar/education/oracle-next-education/).

### Acerca del desafio
El objetivo de este proyecto es poder aplicar cada uno de los módulos aprendidos
en el curso en un proyecto complejo:

### Un conversor de monedas

A continuación, presentaremos cómo se aplicó cada uno de los cursos en la resolución de
este desafío. El orden en que aparecerán a continuación fue en el cual se
resolvió el problema (no el orden propio de la plataforma).
Los pasos son los siguientes:


Aqui se aplicaron los conceptos de los cursos:
1. ChatGPT: optimizando la calidad de los resultados

Se utilizo la lectura de un [json](opciones.json) precargado con las posibles opciones de conversion.
A partir de la funcion definirConversionyMonto utilizamos la opcion elegida del usuario
```bash
 public void definirConversionyMonto(int eleccion, double cantidadACambiar) {
        // Leer el archivo JSON
        FileReader reader = null;
        setCantidadACambiar(cantidadACambiar);
        try {
            reader = new FileReader("opciones.json");
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = fileElement.getAsJsonArray();

            // Iterar a través del array
            for (JsonElement element : jsonArray) {
                JsonObject objeto = element.getAsJsonObject();
                int opcion = objeto.get("Opcion").getAsInt();
                if(opcion==eleccion){
                    setNombreMonedaElegida(objeto.get("monedaElegida").getAsString());
                    setNombreMonedaObjetivo(objeto.get("monedaDestino").getAsString());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
```


### Resumen final

Para copiar este repositorio en caso de necesitarlo:
1. Asegúrate de tener instalado Git en tu computadora. Si no lo tienes, puedes descargarlo desde [este link](https://git-scm.com/downloads).
2. Abre una terminal o ventana de comandos y navega hasta la carpeta raíz de tu repositorio local.
2. Ejecuta el siguiente comando para agregar todos los archivos modificados al área de preparación de Git:

```bash
  git clone this-repo-url
```

Tal como se indica en el desafio el proyecto no se deployo.

Como conclusion y a titulo personal, el desafio presento una complejidad acorde a la dificultad de los cursos.
Los contenidos de cada curso fueron aplicados directamente en el proyecto final, lo que indica una gran posibilidad
de aplicacion de cada tema. Otro aspecto importante es que el resultado final tiene un acabado muy prolijo y armonioso
lo que, luego de tantas horas invertidas en este proyecto, dejan al autor del mismo muy satisfecho.


### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.
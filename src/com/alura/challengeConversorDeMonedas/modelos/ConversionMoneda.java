package com.alura.challengeConversorDeMonedas.modelos;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//API KEY: c096090b482a281a51695afe
public class ConversionMoneda {
    private double cantidadACambiar;
    private double valorMonedaObjetivo;
    private double montoFinalMonedaObjetivo;
    private String nombreMonedaElegida;
    private String nombreMonedaObjetivo;

//    public ConversionMoneda(double valorMonedaElegida, double valorMonedaObjetivo, String nombreMonedaElegida, String nombreMonedaObjetivo) {
//        this.valorMonedaElegida = valorMonedaElegida;
//        this.valorMonedaObjetivo = valorMonedaObjetivo;
//        this.nombreMonedaElegida = nombreMonedaElegida;
//        this.nombreMonedaObjetivo = nombreMonedaObjetivo;
//    }


    public ConversionMoneda() {
    }

    public double getMontoFinalMonedaObjetivo() {
        return montoFinalMonedaObjetivo;
    }

    private void setMontoFinalMonedaObjetivo(double montoFinalMonedaObjetivo) {
        this.montoFinalMonedaObjetivo = montoFinalMonedaObjetivo;
    }

    private double getCantidadACambiar() {
        return cantidadACambiar;
    }

    private void setCantidadACambiar(double cantidadACambiar) {
        this.cantidadACambiar = cantidadACambiar;
    }

    private double getValorMonedaObjetivo() {
        return valorMonedaObjetivo;
    }

    private void setValorMonedaObjetivo(double valorMonedaObjetivo) {
        this.valorMonedaObjetivo = valorMonedaObjetivo;
    }

    private String getNombreMonedaElegida() {
        return nombreMonedaElegida;
    }

    private void setNombreMonedaElegida(String nombreMonedaElegida) {
        this.nombreMonedaElegida = nombreMonedaElegida;
    }

    private String getNombreMonedaObjetivo() {
        return nombreMonedaObjetivo;
    }

    private void setNombreMonedaObjetivo(String nombreMonedaObjetivo) {
        this.nombreMonedaObjetivo = nombreMonedaObjetivo;
    }

    public void definirConversionyMonto(int eleccion, double cantidadACambiar) {
        // Leer el archivo JSON
        FileReader reader = null;
        setCantidadACambiar(cantidadACambiar);
        try {
            reader = new FileReader("opciones.json");
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = fileElement.getAsJsonArray();
            reader.close();

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarOpciones() {
        // Leer el archivo JSON
        FileReader reader = null;
        try {
            reader = new FileReader("opciones.json");
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = fileElement.getAsJsonArray();

            // Iterar a través del array
            int opcion=0;
            for (JsonElement element : jsonArray) {
                JsonObject objeto = element.getAsJsonObject();
                String opciones = objeto.get("Opciones_de_conversion").getAsString();
                System.out.println(" Opción: "+opcion+"-----> "+opciones);
                opcion++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void realizarConversion(String apiKeyValue){
        String finalUrl="https://v6.exchangerate-api.com/v6/"+apiKeyValue+"/pair/"+"/"+getNombreMonedaElegida()+"/"
                +getNombreMonedaObjetivo();
        try {
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
            //System.out.println(json);
            MonedaRecord monedaRecord=gson.fromJson(json, MonedaRecord.class);
            setValorMonedaObjetivo(Double.valueOf(monedaRecord.conversion_rate()));
            setMontoFinalMonedaObjetivo(getValorMonedaObjetivo()*getCantidadACambiar());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "La conversion del monto: "+getCantidadACambiar()+" "+getNombreMonedaElegida()+" a la moneda: "
                +getNombreMonedaObjetivo()+" es: "+ getCantidadACambiar()+" "+getNombreMonedaElegida()
                +"---> "+getMontoFinalMonedaObjetivo()+" "+getNombreMonedaObjetivo();
    }
}

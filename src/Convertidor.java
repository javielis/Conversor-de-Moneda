package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Convertidor {
    public static void main(String[] args) {
        double moneda;
        double tipoDeCambio;
        int opcion = 0;

        try {
            JsonObject exchangeRates = HttpCliente.getExchangeRates();
            Scanner teclado = new Scanner(System.in);

            String menu = """
               * Escriba el número para el tipo de cambio * 
                 1 - ARS-Peso argentino
                 2 - BOB-Boliviano boliviano
                 3 - BRL-Real brasileño
                 4 - USD-Dólar estadounidense
                 5 - Salir
                """;

            while (opcion != 5) {
                System.out.printf(menu);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        tipoDeCambio = exchangeRates.get("ARS").getAsDouble();
                        System.out.println("Tipo de cambio ARS-Peso argentino: " + String.format("%.3f", tipoDeCambio));
                        System.out.println("Ingresar monto ARS-Peso argentino:");
                        moneda = teclado.nextDouble();
                        System.out.println("Convertido a USD: " + String.format("%.3f", (moneda / tipoDeCambio)));
                        break;
                    case 2:
                        tipoDeCambio = exchangeRates.get("BOB").getAsDouble();
                        System.out.println("Tipo de cambio BOB-Boliviano boliviano: " + String.format("%.3f", tipoDeCambio));
                        System.out.println("Ingresar monto BOB-Boliviano boliviano:");
                        moneda = teclado.nextDouble();
                        System.out.println("Convertido a USD: " + String.format("%.3f", (moneda / tipoDeCambio)));
                        break;
                    case 3:
                        tipoDeCambio = exchangeRates.get("BRL").getAsDouble();
                        System.out.println("Tipo de cambio BRL-Real brasileño: " + String.format("%.3f", tipoDeCambio));
                        System.out.println("Ingresar monto BRL-Real brasileño:");
                        moneda = teclado.nextDouble();
                        System.out.println("Convertido a USD: " + String.format("%.3f", (moneda / tipoDeCambio)));
                        break;
                    case 4:
                        tipoDeCambio = exchangeRates.get("USD").getAsDouble();
                        System.out.println("Tipo de cambio USD-Dólar estadounidense: " + String.format("%.3f", tipoDeCambio));
                        System.out.println("Ingresar monto USD-Dólar estadounidense:");
                        moneda = teclado.nextDouble();
                        System.out.println("Convertido a USD: " + String.format("%.3f", (moneda / tipoDeCambio)));
                        break;
                    case 5:
                        System.out.println("Gracias.");
                        break;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                        break;
                }
            }

            teclado.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

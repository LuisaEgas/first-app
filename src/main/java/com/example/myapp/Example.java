package com.example.myapp;

import java.io.IOException;
import java.util.Scanner;


public class Example {

    public static void main(String[] args) throws IOException {

        UploadFile uploadFile = new UploadFile();
        Scanner scanner = new Scanner(System.in);

        int opt = Option();
        while (opt != 2) {
            if (opt == 1) {
                System.out.println();
                System.out.print("Nombre del archivo: ");
                String nameFile = scanner.nextLine();
                if (nameFile.endsWith(".csv")) {
                    uploadFile.UploadFile(nameFile);
                }
                else {
                    System.out.println("El archivo debe ser .csv");
                }
            } else {
                System.out.println("Opción inválida");
            }
            opt = Option();
        }
    }

    private static int Option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("########################");
        System.out.println("Menú");
        System.out.println("1. Subir archivo");
        System.out.println("2. Salir");
        System.out.println("########################");
        System.out.println();

        System.out.print("Ingresar opción: ");
        String option = scanner.nextLine();
        try {
            return Integer.valueOf(option);
        } catch(NumberFormatException e) {
            return 0;
        }
    }
}
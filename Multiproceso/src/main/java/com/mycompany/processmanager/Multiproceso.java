/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.processmanager;

/**
 *
 * @author Daniel M
 */
//improtamos las librerias  necesarias
import java.util.Scanner;
//Creamos la clase peoccesManager haciendo la implementacion en Runneable
public class Multiproceso implements Runnable {
//definimos variables
    private Thread thread;
    private boolean running;
    private boolean paused;

    public Multiproceso() {
        thread = new Thread(this);
        running = false;
        paused = false;
    }
    //creamos los metodos necesarios
    public void start() {
        running = true;
        thread.start();
    }

    public void stop() {
        running = false;
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }
//creamos el proceso usando run
    public void run() {
        while (running) {
            if (paused) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Corre el proceso
                System.out.println("Proceso ejecutando");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//Creamos el metodo general
    public static void main(String[] args) {
        Multiproceso Multiproceso = new Multiproceso();
        Scanner scanner = new Scanner(System.in);

        // Iniciamos el primer proceso
        System.out.println("Escriba una letra cualquiera para iniciar el proceso");
        String input = scanner.nextLine();
        Multiproceso.start();

        //asignamos que puede hacer el usuario
        while (true) {
            System.out.println("Use los comandos(p = pausar, i = iniciar, r = resumen, s = salir):");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("p")) {
                Multiproceso.pause();
            } else if (input.equalsIgnoreCase("i")) {
                Multiproceso.resume();
            } else if (input.equalsIgnoreCase("r")) {
                Multiproceso.resume();
            } else if (input.equalsIgnoreCase("s")) {
                Multiproceso.stop();
                break;
            } else { //esto en caso de usar un comando no especificado
                System.out.println("comando invalido!");
            }
        }
    }
}




    



package org.example;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Contador {
    private int tempo;
    private AtomicBoolean running = new AtomicBoolean(false);
    private AtomicBoolean paused = new AtomicBoolean(false);
    private Thread contadorThread;

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getTempo() {
        return this.tempo;
    }

    public void iniciarOuContinuar() {
        if (contadorThread != null && contadorThread.isAlive()) {
            // Se a thread já existe, apenas tira da pausa
            if (paused.get()) {
                paused.set(false);
                System.out.println("Contador continuando...");
            } else {
                System.out.println("Contador já está rodando!");
            }
            return;
        }

        // Se não existe thread, cria uma nova
        running.set(true);
        paused.set(false);

        contadorThread = new Thread(() -> {
            while (running.get()) {
                if (!paused.get()) {
                    tempo++;
                    System.out.println("Tempo: " + tempo);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        contadorThread.start();
        System.out.println("Contador iniciado!");
    }

    public void pausar() {
        if (contadorThread == null || !contadorThread.isAlive()) {
            System.out.println("Contador não está rodando!");
            return;
        }
        if (paused.get()) {
            System.out.println("Contador já está pausado!");
            return;
        }
        paused.set(true);
        System.out.println("Contador pausado em: " + getTempo());
    }

    public void parar() {
        running.set(false);
        paused.set(false);

        if (contadorThread != null && contadorThread.isAlive()) {
            contadorThread.interrupt();
            try {
                contadorThread.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Contador finalizado em: " + getTempo());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contador contador = new Contador();
        contador.setTempo(0);

        System.out.println("=== CONTADOR COM PAUSA ===");
        System.out.println("Comandos:");
        System.out.println("'i' - Iniciar/Continuar");
        System.out.println("'p' - Pausar");
        System.out.println("'z' - Parar e Sair");
        System.out.println("--------------------------");

        boolean programaAtivo = true;

        while (programaAtivo) {
            System.out.print("Digite comando: ");
            String comando = sc.nextLine().trim().toLowerCase();

            switch (comando) {
                case "i":
                    contador.iniciarOuContinuar();
                    break;
                case "p":
                    contador.pausar();
                    break;
                case "z":
                    contador.parar();
                    programaAtivo = false;
                    break;
                default:
                    System.out.println("Comando inválido! Use: i, p, z");
            }
        }

        sc.close();
    }
}
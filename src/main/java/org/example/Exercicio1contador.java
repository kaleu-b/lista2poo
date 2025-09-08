package org.example;
import java.util.Scanner;
public class Exercicio1contador {

    private int tempoSegundos;
    //esse método vai ser usado para zerar o contador recebendo um número inteiro como parâmetro. Qualquer valor pode ser passado para esse método, mas iremos só passor 0 como parâmetro no main.
    public void setTempoSegundos(int tempoSegundos) {
        this.tempoSegundos = tempoSegundos;
    }
    //retorna o valor do contador
    public int getTempoSegundos() {
        return tempoSegundos;
    }
    //incrementa o contador em 1, pausa por 1 segundo, imprime o valor, até o contador chegar a 10
    public void incrementar( Scanner in ) {

        while( tempoSegundos < 1000 ) {

            do {
                tempoSegundos++;
                pausa(1000);
                System.out.println(tempoSegundos);
                in.nextLine();
            }while(this.tempoSegundos < 11);

        }

    }
    public static void pausa(int tempoPausa) {
        try {
            Thread.sleep(tempoPausa); // Suspende a execução da thread atual
        } catch (InterruptedException e) {
            // Log da exceção caso a thread seja interrompida durante a pausa
            e.printStackTrace();
        }

}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Exercicio1contador contador = new Exercicio1contador();
        Exercicio1contador contador2 = new Exercicio1contador();
        contador.incrementar(input);
        System.out.println("Contador parado!");
        System.out.println("Tempo em segundos: " + contador.getTempoSegundos());
        contador.setTempoSegundos(0);

        contador2.incrementar(input);
        System.out.println("Contador parado!");
        System.out.println("Tempo em segundos: " + contador2.getTempoSegundos());
        contador2.setTempoSegundos(0);
        input.close();
    }

}




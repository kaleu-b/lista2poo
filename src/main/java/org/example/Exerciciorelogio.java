package org.example;

public class Exerciciorelogio {
    private int horas;
    private int minutos;
    private int segundos;
    private int tempoTotalEmSegundos;

    public Exerciciorelogio() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.tempoTotalEmSegundos = 0;
    }

    public void setTempoTotalEmSegundos() {
        this.tempoTotalEmSegundos = (this.horas * 3600) + (this.minutos * 60) + (this.segundos);
    }

    public int getTempoTotalEmSegundos() {
        return this.tempoTotalEmSegundos;
    }

    public void compararTempoTotal(Exerciciorelogio outroRelogio) {
        int diferencaEmSegundos = Math.abs(this.tempoTotalEmSegundos - outroRelogio.getTempoTotalEmSegundos());

        if (this.tempoTotalEmSegundos > outroRelogio.getTempoTotalEmSegundos()) {
            System.out.println("O primeiro relógio está adiantado em relação ao segundo em " + diferencaEmSegundos + " segundos.");
        } else if (this.tempoTotalEmSegundos < outroRelogio.getTempoTotalEmSegundos()) {
            System.out.println("O primeiro relógio está atrasado em relação ao segundo em " + diferencaEmSegundos + " segundos.");
        } else {
            System.out.println("Os dois relógios estão sincronizados.");
        }
    }

    public void setHoras(int horas) {
        this.horas = horas % 24;
        if (this.horas < 0) {
            this.horas += 24;
        }
    }

    public int getHoras() {
        return this.horas;
    }

    public void setMinutos(int minutos) {
        int horasExtras = minutos / 60;
        this.minutos = minutos % 60;

        if (this.minutos < 0) {
            this.minutos += 60;
            horasExtras--;
        }

        this.setHoras(this.horas + horasExtras);
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setSegundos(int segundos) {
        int minutosExtras = segundos / 60;
        this.segundos = segundos % 60;

        if (this.segundos < 0) {
            this.segundos += 60;
            minutosExtras--;
        }

        this.setMinutos(this.minutos + minutosExtras);
    }

    public int getSegundos() {
        return this.segundos;
    }

    public void incrementarsegundos(int valorIncrementoSegundos) {
        this.setSegundos(this.segundos + valorIncrementoSegundos);
    }

    public void incrementarhoras(int valorIncrementoHoras) {
        this.setHoras(this.horas + valorIncrementoHoras);
    }

    public void incrementarMinutos(int valorIncrementoMinutos) {
        this.setMinutos(this.minutos + valorIncrementoMinutos);
    }

    public void sincronizar(Exerciciorelogio outroRelogio) {
        this.setHoras(outroRelogio.getHoras());
        this.setMinutos(outroRelogio.getMinutos());
        this.setSegundos(outroRelogio.getSegundos());
    }

    public void mostrarHora() {
        System.out.printf("%02d:%02d:%02d\n", this.horas, this.minutos, this.segundos);
    }

    public static void main(String[] args) {
        Exerciciorelogio relogio1 = new Exerciciorelogio();
        Exerciciorelogio relogio2 = new Exerciciorelogio();

        // Configurando o primeiro relógio
        relogio1.setHoras(10);
        relogio1.setMinutos(45);
        relogio1.setSegundos(30);

        // Configurando o segundo relógio
        relogio2.setHoras(12);
        relogio2.setMinutos(15);
        relogio2.setSegundos(50);

        // Incrementando tempo no primeiro relógio
        relogio1.incrementarhoras(2);
        relogio1.incrementarMinutos(30);
        relogio1.incrementarsegundos(40);

        // Incrementando tempo no segundo relógio
        relogio2.incrementarhoras(1);
        relogio2.incrementarMinutos(50);
        relogio2.incrementarsegundos(20);

        // Calculando tempo total em segundos para ambos os relógios
        relogio1.setTempoTotalEmSegundos();
        relogio2.setTempoTotalEmSegundos();

        // Comparando os dois relógios
        relogio1.compararTempoTotal(relogio2);

        // Sincronizando o primeiro relógio com o segundo
        relogio1.sincronizar(relogio2);

        // Exibindo o tempo do primeiro relógio após a sincronização
        System.out.print("Relógio 1 sincronizado: ");
        relogio1.mostrarHora();
    }
}
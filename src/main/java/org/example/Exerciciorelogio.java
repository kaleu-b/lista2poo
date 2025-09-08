package org.example;

public class Exerciciorelogio {
    private int horas;
    private int minutos;
    private int segundos;
    private int tempoTotalEmSegundos;

    public void setTempoTotalEmSegundos(){
        this.tempoTotalEmSegundos = (this.horas * 3600) + (this.minutos * 60) + (this.segundos);
    }

    public int getTempoTotalEmSegundos(){
        return this.tempoTotalEmSegundos;
    }

    public void compararTempoTotal(Exerciciorelogio outroRelogio) {
        int diferençaEmSegundos;
        if (this.tempoTotalEmSegundos > outroRelogio.getTempoTotalEmSegundos()) {
            System.out.println("O primeiro relógio está adiantado em relação ao segundo em " + (this.tempoTotalEmSegundos - outroRelogio.getTempoTotalEmSegundos()) + " segundos.");
        } else if (this.tempoTotalEmSegundos < outroRelogio.getTempoTotalEmSegundos()) {
            System.out.println("O primeiro relógio está atrasado em relação ao segundo em " + (outroRelogio.getTempoTotalEmSegundos() - this.tempoTotalEmSegundos) + " segundos.");
        } else {
            System.out.println("Os dois relógios estão sincronizados.");
        }

    }

    public void setHoras(int horas) {
        this.horas = horas % 24;
        // Nota: Para valores negativos, % pode retornar negativo
        // Mais tarde isso vai ser tratado não deixando o usuário entrar com valores negativos
    }

    public int getHoras() {
        return this.horas;
    }

    public void setMinutos(int minutos) {
        // Calcula horas extras e ajusta minutos
        int horasExtras = minutos / 60;
        this.minutos = minutos % 60;

        // Adiciona horas extras às horas atuais
        this.setHoras(this.horas + horasExtras);
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setSegundos(int segundos) {
        // Calcula minutos extras e ajusta segundos
        int minutosExtras = segundos / 60;
        this.segundos = segundos % 60;

        // Adiciona minutos extras aos minutos atuais
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
        this.setSegundos(outroRelogio.getSegundos());
        this.setMinutos(outroRelogio.getMinutos());
        this.setHoras(outroRelogio.getHoras());
    }
}
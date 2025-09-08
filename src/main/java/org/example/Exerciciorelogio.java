package org.example;

public class Exerciciorelogio {
    private int horas;
    private int minutos;
    private int segundos;

    // métodos getters e setters de cada atributo. não vou explicar 1 a 1.
    public void setHoras(int horas) {
        this.horas = horas;
        if (this.horas >= 24) {
            this.horas += this.horas % 24;
        }
    }

    public int getHoras() {
        return this.horas;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
        if (this.minutos >= 60) {
           // this.horas += this.minutos / 60;
            this.setHoras(this.minutos / 60);
            this.minutos = this.minutos % 60;
        }
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
        if (this.segundos >= 60) {
           // this.minutos += this.segundos / 60;
            this.setHoras(this.segundos / 60);
            this.segundos = this.segundos % 60;
        }

        if (this.minutos >= 60) {
            this.setHoras(this.getHoras() + this.minutos / 60);
        }
    }

    public int getSegundos() {
        return this.segundos;
    }

    public void incrementarsegundos(int valorIncrementoSegundos) {
        this.setSegundos(this.getSegundos() + valorIncrementoSegundos);
    }

    public void incrementarhoras(int valorIncrementoHoras) {
    this.setHoras(this.getHoras() + valorIncrementoHoras);

    }

    public void incrementarMinutos(int valorIncrementoMinutos) {
        this.setMinutos(this.getMinutos() + valorIncrementoMinutos);
    }

    public void sincronizar(Exerciciorelogio relogio1, Exerciciorelogio relogio2) {
        relogio1.setHoras(relogio2.getHoras());
        relogio1.setMinutos(relogio2.getMinutos());
        relogio1.setSegundos(relogio2.getSegundos());
    }
}

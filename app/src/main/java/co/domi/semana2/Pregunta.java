package co.domi.semana2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Pregunta {

    private String preguntas;
    private int respuesta;
    private String respuestaa;
    private String signo;
    private int numeroUno;
    private int numeroDos;
    private int preguntasRandom;

    public void Pregunta(String simbolos, String pregunta){
        Random numerosRandom = new Random();
        numeroUno = numerosRandom.nextInt(100);
        numeroDos = numerosRandom.nextInt(50);
        preguntasRandom = numerosRandom.nextInt(4);
        preguntas = simbolos;
    }

    public void generadorPregunta(){

        switch(preguntasRandom){
            case 0:
                this.respuesta = numeroUno + numeroDos;
                this.signo = "+";
                break;
            case 1:
                this.respuesta = numeroUno + numeroDos;
                this.signo = "-";
                break;
            case 2:
                this.respuesta = numeroUno * numeroDos;
                this.signo = "*";
                break;
            case 3:
                this.respuesta =  numeroUno / numeroDos;
                this.signo = "/";
                break;
        }

        this.respuestaa = AtomicInteger;
        this.preguntas = numeroUno + " " + signo + " " + numeroDos;


    }

    

}

package co.domi.semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {

    private TextView Pregunta;
    private EditText Respuesta;
    private Button Aceptar;
    private Button Intentarlo;
    private TextView Puntos;
    private TextView Tiempo;
    private int punticos;
    private Pregunta preguntas;
    private Random random;
    private int a;
    private Boolean PrenderContador;
    private int tiempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pregunta = findViewById(R.id.Pregunta);
        Respuesta = findViewById(R.id.Respuesta);
        Aceptar = findViewById(R.id.Aceptar);
        Intentarlo = findViewById(R.id.Intentar);
        Puntos = findViewById(R.id.Puntos);
        Tiempo = findViewById(R.id.Tiempo);
        PrenderContador = true;
        random = new Random();
        tiempo = 20;

        PreguntasSiguiente();
        Temporizador();

        Respuesta.setOnClickListener(
                (v) -> {
                    String MiRespuesta = Respuesta.getText().toString();
                        if (MiRespuesta.equals(Integer.toString(preguntas.getRespuesta()))) {
                            punticos += 15;
                            PreguntasSiguiente();
                            Respuesta.setText("");
                        } else {
                            punticos -= 10;
                        }
                    Puntos.setText("puntajes:"+punticos);
                }
        );

        Intentarlo.setOnClickListener(
                (v) -> {
                    PrenderContador = true;

                    punticos = 0;
                    Puntos.setText("puntajes:"+punticos);
                    Tiempo.setText(" " + tiempo);
                    Intentarlo.setVisibility(View.GONE);
                }
        );
    }

    public void PreguntasSiguiente(){
        int numeroRandomUno = (int) Math.floor((Math.random() * 10 + 1));
        int numeroRandomDos = (int) Math.floor((Math.random() * 10 + 1));
        int operacion = (int) Math.floor(Math.random() * 4 + 1);
        preguntas = new Pregunta(numeroRandomUno,numeroRandomDos,operacion);
        preguntas.generadorPregunta();
        Pregunta.setText(preguntas.devolverPregunta()+" ");

    }

    public void Temporizador(){
        new Thread(
                () -> {
                    while(PrenderContador){
                        tiempo--;
                        runOnUiThread(() ->Tiempo.setText(" " + tiempo));
                        if(tiempo <= 0){
                            PrenderContador = false;
                            tiempo = 20;
                            runOnUiThread(() ->Intentarlo.setVisibility(View.VISIBLE));
                        }
                        try {
                           Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }



}

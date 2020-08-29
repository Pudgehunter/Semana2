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

        Aceptar.setOnClickListener(
                (v) -> {
                    String MiRespuesta = Respuesta.getText().toString();
                        if (MiRespuesta.equals(Integer.toString(preguntas.getRespuesta())) && PrenderContador == true) {
                            punticos += 15;
                            PreguntasSiguiente();
                            Respuesta.setText("");
                        } else {
                            punticos -= 10;
                        }

                }
        );



        Intentarlo.setOnClickListener(
                (v) -> {
                    PrenderContador = true;
                    PreguntasSiguiente();
                    punticos = 0;
                    tiempo = 20;
                    Temporizador();
                    Intentarlo.setVisibility(View.GONE);
                }
        );
        Puntos.setText("puntajes:"+punticos);
    }

    public void PreguntasSiguiente(){
        int numeroRandomUno = random.nextInt(11);
        int numeroRandomDos = random.nextInt(11);
        int operacion = random.nextInt(4);
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

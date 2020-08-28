package co.domi.semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView Pregunta;
    private EditText Respuesta;
    private Button Aceptar;
    private int Puntos = 0;
    private ArrayList<Pregunta> preguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pregunta = findViewById(R.id.Pregunta);
        Respuesta = findViewById(R.id.Respuesta);
        Aceptar = findViewById(R.id.Aceptar);
        preguntas = new ArrayList<Pregunta>;

        Aceptar.setOnClickListener(
                (v) -> {
                    String respuesta = Respuesta.getText().toString();
                    Puntos = Puntos + 15;
                }
                );

    }
}
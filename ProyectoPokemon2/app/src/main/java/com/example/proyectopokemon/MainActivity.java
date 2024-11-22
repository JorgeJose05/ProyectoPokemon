package com.example.proyectopokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

/*
        //Giffs
        WebView webView2 = findViewById(R.id.webview2);
        webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/mewtwo.gif");
// Arceus webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/arceus.gif");

        WebView webView = findViewById(R.id.webview);
        //webView.getSettings().setJavaScriptEnabled(true); // Antes tenia esta linia en los dos para activar javascript ahhora no me hace falta
        webView.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/caterpie.gif");


        // Referencias a los EditText
        EditText editTextHP = findViewById(R.id.editTextTextHP);
        EditText editTextATQ = findViewById(R.id.editTextTextTQ);
        EditText editTextATQES = findViewById(R.id.editTextTextATQES);
        EditText editTextDEF = findViewById(R.id.editTextTextDEF);
        EditText editTextDEFES = findViewById(R.id.editTextTextDEFES);

        EditText editTextHP2 = findViewById(R.id.editTextTextHP2);
        EditText editTextATQ2 = findViewById(R.id.editTextTextTQ2);
        EditText editTextATQES2 = findViewById(R.id.editTextTextATQES2);
        EditText editTextDEF2 = findViewById(R.id.editTextTextDEF2);
        EditText editTextDEFES2 = findViewById(R.id.editTextTextDEFES2);



        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recuperar los valores de los EditText
                String hp1 = editTextHP.getText().toString();
                String atq1 = editTextATQ.getText().toString();
                String atqes1 = editTextATQES.getText().toString();
                String def1 = editTextDEF.getText().toString();
                String defes1 = editTextDEFES.getText().toString();

                String hp2 = editTextHP2.getText().toString();
                String atq2 = editTextATQ2.getText().toString();
                String atqes2 = editTextATQES2.getText().toString();
                String def2 = editTextDEF2.getText().toString();
                String defes2 = editTextDEFES2.getText().toString();

                // Validación básica
                if (hp1.isEmpty() || atq1.isEmpty() || atqes1.isEmpty() ||
                        def1.isEmpty() || defes1.isEmpty() ||
                        hp2.isEmpty() || atq2.isEmpty() || atqes2.isEmpty() ||
                        def2.isEmpty() || defes2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí puedes guardar los datos o usarlos para la lógica
                    Toast.makeText(MainActivity.this, "Datos guardados y listos para pelear", Toast.LENGTH_SHORT).show();


                    startActivity(new Intent(MainActivity.this, combate.class));
                    // Ejemplo: imprimir los valores
                    System.out.println("Caterpie - HP: " + hp1 + ", Ataque: " + atq1 + ", Ataque Especial: " + atqes1 + ", Defensa: " + def1 + ", Defensa Especial: " + defes1);
                    System.out.println("Mewtwo - HP: " + hp2 + ", Ataque: " + atq2 + ", Ataque Especial: " + atqes2 + ", Defensa: " + def2 + ", Defensa Especial: " + defes2);
                }
            }

        });
*/

    }
}
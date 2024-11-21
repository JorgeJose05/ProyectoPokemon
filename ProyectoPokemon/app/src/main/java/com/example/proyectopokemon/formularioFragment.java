package com.example.proyectopokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.proyectopokemon.databinding.FragmentFormularioBinding;

public class formularioFragment extends Fragment {

    private FragmentFormularioBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormularioBinding.inflate(inflater,container,false);

        //Giffs
        WebView webView2 = binding.webview2;
        webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/mewtwo.gif");
// Arceus webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/arceus.gif");

        WebView webView = binding.webview;
        //webView.getSettings().setJavaScriptEnabled(true); // Antes tenia esta linia en los dos para activar javascript ahhora no me hace falta
        webView.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/caterpie.gif");

        return binding.getRoot();

         }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(v -> {
            // Obtener los valores de los campos
            String hp1 = binding.editTextTextHP.getText().toString();
            String atq1 = binding.editTextTextTQ.getText().toString();
            String def1 = binding.editTextTextDEF.getText().toString();

            String atqesp1 = binding.editTextTextATQES.getText().toString();
            String defesp1 = binding.editTextTextDEFES.getText().toString();

            String hp2 = binding.editTextTextHP2.getText().toString();
            String atq2 = binding.editTextTextTQ2.getText().toString();
            String def2 = binding.editTextTextDEF2.getText().toString();
            String atqesp2 = binding.editTextTextATQES2.getText().toString();
            String defesp2 = binding.editTextTextDEFES2.getText().toString();

            // Validar los datos
            if (TextUtils.isEmpty(hp1) || TextUtils.isEmpty(atq1) || TextUtils.isEmpty(def1) ||
                    TextUtils.isEmpty(hp2) || TextUtils.isEmpty(atq2) || TextUtils.isEmpty(def2)) {
                Toast.makeText(getContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Crear un Bundle con los datos y navegar a CombateFragment
            Bundle bundle = new Bundle();
            bundle.putInt("hp1", Integer.parseInt(hp1));
            bundle.putInt("atq1", Integer.parseInt(atq1));
            bundle.putInt("def1", Integer.parseInt(def1));
            bundle.putInt("atqESP1", Integer.parseInt(atqesp1));
            bundle.putInt("defESP1", Integer.parseInt(defesp1));

            bundle.putInt("hp2", Integer.parseInt(hp2));
            bundle.putInt("atq2", Integer.parseInt(atq2));
            bundle.putInt("def2", Integer.parseInt(def2));
            bundle.putInt("atqESP2", Integer.parseInt(atqesp2));
            bundle.putInt("defESP2", Integer.parseInt(defesp2));

            Navigation.findNavController(view).navigate(R.id.action_formulario_to_combate, bundle);
        });


}
}
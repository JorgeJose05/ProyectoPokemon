package com.example.proyectopokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.proyectopokemon.databinding.FragmentCombateBinding;

public class CombateFragment extends Fragment {
    private FragmentCombateBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return (binding = FragmentCombateBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            int hp1 = bundle.getInt("hp1");
            int atq1 = bundle.getInt("atq1");
            int def1 = bundle.getInt("def1");

            int atqesp1 = bundle.getInt("atqESP1");
            int defesp1 = bundle.getInt("defESP1");

            int hp2 = bundle.getInt("hp2");
            int atq2 = bundle.getInt("atq2");
            int def2 = bundle.getInt("def2");
            int atqesp2 = bundle.getInt("atqESP2");
            int defesp2 = bundle.getInt("defESP2");

            // Asignar los valores a los TextView
            binding.hp1.setText(String.valueOf(hp1));
            binding.ataque1.setText(String.valueOf(atq1));
            binding.def1.setText(String.valueOf(def1));
            binding.ataqueESP1.setText(String.valueOf(atqesp1));
            binding.defESP1.setText(String.valueOf(defesp1));

            binding.hp2.setText(String.valueOf(hp2));
            binding.ataque2.setText(String.valueOf(atq2));
            binding.def2.setText(String.valueOf(def2));
            binding.ataqueESP2.setText(String.valueOf(atqesp2));
            binding.defESP2.setText(String.valueOf(defesp2));
        }


        //Giffs
        WebView webView2 = binding.webview2;
        webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/mewtwo.gif");
// webView2.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/arceus.gif");

        WebView webView = binding.webview1;
        //webView.getSettings().setJavaScriptEnabled(true); // Antes tenia esta linia en los dos para activar javascript ahhora no me hace falta
        webView.loadUrl("https://img.pokemondb.net/sprites/black-white/anim/normal/caterpie.gif");
//        webView.loadUrl("https://i.seadn.io/gae/FcW5mVrL3DjSxmcytn_3dzNs7ZjodxN4uxIIh89Zz5sVEoh6J26KsZmgAZmnAtUaC0sCQbQtF4rh3yAGEL1rcEzb1r4wp4FQkhHqdA?auto=format&dpr=1&w=1000");

        final CombateViewModel miCombateViewModel = new ViewModelProvider(this).get(CombateViewModel.class);

        //pokemon 1
        binding.atacar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hp1 = Integer.parseInt(binding.hp1.getText().toString()) ;
                int atq1 = Integer.parseInt(binding.ataque1.getText().toString()) ;
                int def1 = Integer.parseInt(binding.def1.getText().toString()) ;
                int atqesp1 = Integer.parseInt(binding.ataqueESP1.getText().toString()) ;
                int defesp1 = Integer.parseInt(binding.defESP1.getText().toString()) ;


                int hp2 = Integer.parseInt(binding.hp2.getText().toString()) ;
                int atq2 = Integer.parseInt(binding.ataque2.getText().toString()) ;
                int def2 = Integer.parseInt(binding.def2.getText().toString()) ;
                int atqesp2 = Integer.parseInt(binding.ataqueESP2.getText().toString()) ;
                int defesp2 = Integer.parseInt(binding.defESP2.getText().toString()) ;

                if (hp2 <= 0){
                    CharSequence message = "No puede atacar esta completamente debilitado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }else{
                    miCombateViewModel.atacar1(hp1,atq1,def1,atqesp1, defesp1, hp2, atq2, def2, atqesp2, defesp2);
                }

            }
        });

        miCombateViewModel.dañoAl2.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer <= 0 && Integer.parseInt(binding.hp2.getText().toString()) == 0 ){
                    CharSequence message = "No puede atacar esta completamente debilitado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }else if(integer <= 0){
                    CharSequence message = "El pokemon Mewtwo a sido derrotado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                }else if(integer < bundle.getInt("hp2")/2){
                    CharSequence message = "!VIDA CRITICA! El pokemon Mewtwo ya esta a menos de la mitad de la vida";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();

                }
                binding.hp2.setText("" + integer);
                binding.atacar1.setEnabled(true);
            }
        });

        miCombateViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    //yo no hago nada mientras esta calculando o no
                }
            }
        });

        //pokemon 2

        binding.atacar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hp1 = Integer.parseInt(binding.hp1.getText().toString()) ;
                int atq1 = Integer.parseInt(binding.ataque1.getText().toString()) ;
                int def1 = Integer.parseInt(binding.def1.getText().toString()) ;
                int atqesp1 = Integer.parseInt(binding.ataqueESP1.getText().toString()) ;
                int defesp1 = Integer.parseInt(binding.defESP1.getText().toString()) ;


                int hp2 = Integer.parseInt(binding.hp2.getText().toString()) ;
                int atq2 = Integer.parseInt(binding.ataque2.getText().toString()) ;
                int def2 = Integer.parseInt(binding.def2.getText().toString()) ;
                int atqesp2 = Integer.parseInt(binding.ataqueESP2.getText().toString()) ;
                int defesp2 = Integer.parseInt(binding.defESP2.getText().toString()) ;

                if (hp2 <= 0){
                    CharSequence message = "No puede atacar esta completamente debilitado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }else{
                    miCombateViewModel.atacar2(hp1,atq1,def1,atqesp1, defesp1, hp2, atq2, def2, atqesp2, defesp2);
                }


            }
        });

        miCombateViewModel.dañoAl1.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer <= 0 && Integer.parseInt(binding.hp1.getText().toString()) == 0 ){
                    CharSequence message = "No puede atacar esta completamente debilitado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }else if(integer <= 0){
                    CharSequence message = "El pokemon Caterpie a sido derrotado";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                }else if(integer < bundle.getInt("hp1")/2){
                    CharSequence message = "!VIDA CRITICA! El pokemon Caterpie ya esta a menos de la mitad de la vida";
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();

                }
                binding.hp1.setText("" + integer);
                binding.atacar2.setEnabled(true);
            }
        });

        miCombateViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    binding.atacar1.setEnabled(true);
                    binding.atacar2.setEnabled(true);
                }
            }
        });










    }
}
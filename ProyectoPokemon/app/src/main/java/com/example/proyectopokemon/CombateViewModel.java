package com.example.proyectopokemon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CombateViewModel extends AndroidViewModel {

        Executor executor;
        MutableLiveData<Boolean> calculando = new MutableLiveData<>();
        SimuladorCombate simulador;

        MutableLiveData<Integer> dañoAl2 = new MutableLiveData<>();
        MutableLiveData<Integer> dañoAl1 = new MutableLiveData<>();

        public  CombateViewModel(@NonNull Application application){
                super(application);

                executor = Executors.newSingleThreadExecutor();
                simulador = new SimuladorCombate();

        }

        //pokemon 1
        public void atacar1(int hp1, int atq1,int def1, int atqesp1, int defesp1, int hp2, int atq2, int def2, int atqesp2, int defesp2 ){

                final SimuladorCombate.Solicitud solicitud = new SimuladorCombate.Solicitud(hp1,atq1,def1, atqesp1, defesp1 ,hp2, atq2, def2, atqesp2, defesp2);

                executor.execute(new Runnable() {
                        @Override
                        public void run() {
                                simulador.calcular(solicitud, new SimuladorCombate.Callback() {
                                        @Override
                                        public void CuandoEsteCalculandoELGolpe(int vidaRes) {
                                                dañoAl2.postValue(vidaRes);
                                        }

                                        @Override
                                        public void cuandoEmpieceElCalculo() {
                                                calculando.postValue(true);
                                        }

                                        @Override
                                        public void cuandoFinaliceElCalculo() {
                                                calculando.postValue(false);
                                        }
                                });
                        }
                });



        }

        //pokemon 2

        public void atacar2(int hp1, int atq1,int def1, int atqesp1, int defesp1, int hp2, int atq2, int def2, int atqesp2, int defesp2 ){

                final SimuladorCombate.Solicitud solicitud = new SimuladorCombate.Solicitud(hp1,atq1,def1, atqesp1, defesp1 ,hp2, atq2, def2, atqesp2, defesp2);

                executor.execute(new Runnable() {
                        @Override
                        public void run() {
                                simulador.calcular2(solicitud, new SimuladorCombate.Callback() {
                                        @Override
                                        public void CuandoEsteCalculandoELGolpe(int vidaRes) {
                                                dañoAl1.postValue(vidaRes);
                                        }

                                        @Override
                                        public void cuandoEmpieceElCalculo() {
                                                calculando.postValue(true);
                                        }

                                        @Override
                                        public void cuandoFinaliceElCalculo() {
                                                calculando.postValue(false);
                                        }
                                });
                        }
                });



        }


}

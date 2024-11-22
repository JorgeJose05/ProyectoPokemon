package com.example.proyectopokemon;

public class SimuladorCombate {

    public static class Solicitud{
        public int hp1, atq1, def1, atqesp1, defesp1;
        public int hp2, atq2, def2, atqesp2, defesp2;

        public Solicitud(int hp1, int atq1,int def1, int atqesp1, int defesp1, int hp2, int atq2, int def2, int atqesp2, int defesp2){
            this.hp1 = hp1;
            this.atq1 = atq1;
            this.def1 =def1;;
            this.atqesp1 = atqesp1;
            this.defesp1 =defesp2;

            this.hp2 = hp2;
            this.atq2 = atq2;
            this.def2 =def2;
            this.atqesp2 = atqesp2;
            this.defesp2 =defesp2;
        }
    }

    interface Callback {
        void CuandoEsteCalculandoELGolpe(int vidaRes);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    //pokemon1
    public void calcular(Solicitud solicitud, Callback callback){

        callback.cuandoEmpieceElCalculo();
        try {
            Thread.sleep(200);

        }catch (InterruptedException e){}

        if ((solicitud.hp2 - (solicitud.atq1 - solicitud.def2)) - (solicitud.atqesp1 -solicitud.defesp2) >=0){//todos estos ifs son para que cuando la defensa mayo que el ataque no cure

            if (solicitud.defesp2 > solicitud.atqesp1){
                if (solicitud.def2 > solicitud.atq1){
                    callback.CuandoEsteCalculandoELGolpe(solicitud.hp2);

                }else{
                    callback.CuandoEsteCalculandoELGolpe((solicitud.hp2 - (solicitud.atq1 - solicitud.def2)));

                }
            }else if (solicitud.def2 > solicitud.atq1){
                callback.CuandoEsteCalculandoELGolpe((solicitud.hp2 - (solicitud.atqesp1 -solicitud.defesp2)));
            }else{
                callback.CuandoEsteCalculandoELGolpe((solicitud.hp2 - (solicitud.atq1 - solicitud.def2)) - (solicitud.atqesp1 -solicitud.defesp2));
            }

             }else{
            callback.CuandoEsteCalculandoELGolpe(0);
        }



        callback.cuandoFinaliceElCalculo();
    }

    //pokemon 2

    //pokemon1
    public void calcular2(Solicitud solicitud, Callback callback){

        callback.cuandoEmpieceElCalculo();
        try {
            Thread.sleep(200);

        }catch (InterruptedException e){}
        //comienza
        //todos estos ifs son para que cuando la defensa mayo que el ataque no cure
        if ((solicitud.hp1 - (solicitud.atq2 - solicitud.def1)) - (solicitud.atqesp2 -solicitud.defesp1) >=0){

            if (solicitud.defesp1 > solicitud.atqesp2){
                if (solicitud.def1 > solicitud.atq2){
                    callback.CuandoEsteCalculandoELGolpe(solicitud.hp1);

                }else{
                    callback.CuandoEsteCalculandoELGolpe((solicitud.hp1 - (solicitud.atq2 - solicitud.def1)));

                }
            }else if (solicitud.def1 > solicitud.atq2){
                callback.CuandoEsteCalculandoELGolpe((solicitud.hp1 - (solicitud.atqesp2 -solicitud.defesp1)));
            }else{
                callback.CuandoEsteCalculandoELGolpe((solicitud.hp1 - (solicitud.atq2 - solicitud.def1)) - (solicitud.atqesp2 -solicitud.defesp1));
            }

        }else{
            callback.CuandoEsteCalculandoELGolpe(0);
        }



        callback.cuandoFinaliceElCalculo();
        //termina

    }

}

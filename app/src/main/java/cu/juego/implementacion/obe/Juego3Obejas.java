package cu.juego.implementacion.obe;


import cu.juego.implementacion.Pantalla;
import cu.juego.implementacion.android.AndroidJuego;

import android.app.Activity;

public class Juego3Obejas extends AndroidJuego {

    @Override
    public Pantalla getStartScreen() {
        // TODO Auto-generated method stub
        return new LoadingScreen(this);
    }


}


























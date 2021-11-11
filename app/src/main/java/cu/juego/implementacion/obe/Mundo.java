package cu.juego.implementacion.obe;

import java.util.Random;

//import android.util.Log;
//import android.widget.Toast;

public class Mundo {
    static final int MUNDO_ANCHO = 7;
    static final int MUNDO_ALTO = 7;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.5f;
    static final float TICK_DECREMENTO = 0.05f;

    public boolean enMov;

    public Granja granja;
    // public Locomotora locomotora;
    // public Bagon bagon;
    public static boolean finalJuego = false;
    // public int puntuacion = 0;

    // boolean[][] campo = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    // Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;

    public Mundo() {
        enMov = false;
        granja = new Granja();
        finalJuego = false;
        // locomotora = new Locomotora();
        tiempoTick = 0;
        tick = TICK_INICIAL;

    }

    public void enMov(boolean b, int xMouse, int yMouse) {
        if (b) {
            enMov = b;
            int fil = (yMouse - 50) / 60;
            int col = (xMouse + 50) / 60;
            if (granja.columnaPerro != col || granja.filaPerro != fil) {
                enMov = false;
            }
        } else {
            enMov = b;
        }

        //Log.d("Entro", "Entro " + b);
    }

    public boolean moverPerro(int xMouse, int yMouse) {
        int fil = (yMouse - 50) / 60;
        int col = (xMouse + 50) / 60;
        if (enMov) {
            if ((Math.abs(granja.columnaPerro - col) + Math
                    .abs(granja.filaPerro - fil)) > 1) {
                enMov = false;
            } else {

                //Log.d("Entro", "Entro " + fil + "-" + col);
                if (granja.columnaPerro == col && granja.filaPerro == fil) {
                    enMov = true;
                }
                if (granja.columnaPerro - col == -1 && granja.filaPerro == fil) {
                    enMov = granja.moverDerecha(fil);
                    //Log.d("Entro", "Izquierda");
                }
                if (granja.columnaPerro - col == 1 && granja.filaPerro == fil) {
                    enMov = granja.moverIzquierda(fil);
                    //Log.d("Entro", "Derecha");
                }
                if (granja.columnaPerro == col && granja.filaPerro - fil == -1) {
                    enMov = granja.moverAbajo(col);
                    //Log.d("Entro", "Abajo");
                }
                if (granja.columnaPerro == col && granja.filaPerro - fil == 1) {
                    enMov = granja.moverArriba(col);
                    //Log.d("Entro", "Arriba");
                }
            }
            return enMov;
        }
        return false;
    }

    public void update(float deltaTime) {
        if (finalJuego) {
            return;
        }

        tiempoTick += deltaTime;

        while (tiempoTick > tick) {

            tiempoTick -= tick;

            // locomotora.avance();
            // if (locomotora.comprobarChoque()) {
            // Log.d("Entro", "Choque BOOM");
            // finalJuego = true;
            // return;
            // }

            // Log.d("Entro", "BOT " + botin.x + " _ " + botin.y);

            // Tripulacion head = locomotora.partes.get(0);
            // if (head.x == bagon.x && head.y == bagon.y) {
            // Log.d("Entro", "Botin facho");
            // puntuacion += INCREMENTO_PUNTUACION;
            // locomotora.abordaje();
            // if (locomotora.partes.size() == MUNDO_ANCHO * MUNDO_ALTO) {
            // finalJuego = true;
            // return;
            // } else {
            // }

            // if (puntuacion % 100 == 0 && tick - TICK_DECREMENTO > 0) {
            // tick -= TICK_DECREMENTO;
            // }
            // }

        }

    }

}

package cu.juego.implementacion.obe;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.R.color;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;

import cu.juego.implementacion.Graficos;
import cu.juego.implementacion.Juego;
import cu.juego.implementacion.Pantalla;
import cu.juego.implementacion.Pixmap;
import cu.juego.implementacion.Input.TouchEvent;

public class PantallaJuego extends Pantalla {
    MediaPlayer mp;

    enum EstadoJuego {
        Preparado, Ejecutandose, Pausado, FinJuego
    }

    EstadoJuego estado = EstadoJuego.Ejecutandose;
    Mundo mundo;
    int antiguaPuntuacion = 0;
    String puntuacion = "0";

    public PantallaJuego(Juego juego) {
        super(juego);
        mundo = new Mundo();

        if(Configuraciones.soundEnabled){
            mp = MediaPlayer.create(juego.getContext(), R.raw.musica);
            mp.setLooping(true);
            mp.setVolume(Configuraciones.musicLevel, Configuraciones.musicLevel);
        }
    }

    public void updateReady(List<TouchEvent> touchEvents) {
        if (touchEvents.size() > 0) {
            estado = EstadoJuego.Ejecutandose;
        }
    }

    public void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        // Graficos g =juego.getGraficos();
        // List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        // juego.getInput().getkeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            // poner a falaso el enMov
            if (event.type == TouchEvent.TOUCH_UP) {
                // if (event.x < 64 && event.y < 64) {
                // juego.setScreen(new MainMenuScreen(juego));
                // if (Configuraciones.soundEnabled) {
                // Assets.pulsar.play(1);
                // }
                // estado = EstadoJuego.Pausado;
                // return;
                // }
                if (event.x > 260) {
                    if (event.y < 60) {
                        Assets.clic.play(Configuraciones.soundLevel);
                        mundo = new Mundo();
                    }
                }

                mundo.enMov(false, event.x, event.y);

            }

            // si sentido es o poner izq, der abaj o arrib
            // chequear posicion y mover si sentido ok y distancia con perro ok
            if (event.type == TouchEvent.TOUCH_DRAGGED) {
                if (event.x < 370 && event.x > -50) {
                    if (event.y > 50 && event.y < 470) {
                        mundo.moverPerro(event.x, event.y);
                    }
                }
            }
            // verificar que cailla es del perro y poner enMov = true
            if (event.type == TouchEvent.TOUCH_DOWN) {
                // if (event.x < 64 && event.y > 416) {
                if (event.x < 370 && event.x > -50) {
                    if (event.y > 50 && event.y < 470) {
                        mundo.enMov(true, event.x, event.y);
                    }
                }
                // if (event.x > 256 && event.y > 416) {
                // if (event.y > 100 && event.y < 380) {
                // // mundo.locomotora.girarDerecha();
                // }
            }
        }

        mundo.update(deltaTime);
        if (mundo.finalJuego) {
            Configuraciones.nuevoNivel = false;
            if (Configuraciones.descubierto == Control.nivel) {
                Configuraciones.descubierto++;
                Configuraciones.nuevoNivel = true;
            }
            // estado = EstadoJuego.FinJuego;
            // juego.nuevo();
            // }else{
            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    juego.nuevo(Configuraciones.nuevoNivel);
                }
            };

            // Simulate a long loading process on application startup.

            Timer timer = new Timer();
            timer.schedule(task, 1000);

        }
        mundo.finalJuego = false;
        // if (antiguaPuntuacion != mundo.puntuacion) {
        // antiguaPuntuacion = mundo.puntuacion;
        // puntuacion = "" + antiguaPuntuacion;
        // if (Configuraciones.soundEnabled) {
        // Assets.ataque.play(1);
        // }

        // }

    }

    public void updatePause(List<TouchEvent> touchEvents) {
        // Graficos g =juego.getGraficos();
        // List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        // juego.getInput().getkeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 80 && event.x <= 240) {
                    if (event.y > 100 && event.y <= 148) {
                        if (Configuraciones.soundEnabled) {
                            Assets.clic.play(Configuraciones.soundLevel);
                        }
                        estado = EstadoJuego.Ejecutandose;
                        return;
                    }

                    if (event.y > 148 && event.y <= 196) {
                        if (Configuraciones.soundEnabled) {
                            Assets.clic.play(Configuraciones.soundLevel);
                        }
                        juego.setScreen(new MainMenuScreen(juego));
                        return;
                    }

                }
            }
        }
    }

    public void updateGameOver(List<TouchEvent> touchEvents) {
        // Graficos g =juego.getGraficos();
        // List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        // juego.getInput().getkeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x >= 128 && event.x <= 192) {
                    if (event.y >= 200 && event.y <= 264) {
                        if (Configuraciones.soundEnabled) {
                            Assets.clic.play(Configuraciones.soundLevel);
                        }
                        juego.setScreen(new MainMenuScreen(juego));
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void update(float deltaTime) {
        // Graficos g =juego.getGraficos();
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getkeyEvents();

        if (Control.isback) {
            synchronized (this) {
                Control.isback = false;
            }
            juego.setScreen(new MainMenuScreen(juego));
            if (Configuraciones.soundEnabled) {
                Assets.clic.play(Configuraciones.soundLevel);
            }
        } else {

            if (estado == EstadoJuego.Preparado) {
                updateReady(touchEvents);
            }
            if (estado == EstadoJuego.Ejecutandose) {
                updateRunning(touchEvents, deltaTime);
            }
            if (estado == EstadoJuego.Pausado) {
                updatePause(touchEvents);
            }
            if (estado == EstadoJuego.FinJuego) {
                updateGameOver(touchEvents);
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        // TODO Auto-generated method stub
        Graficos g = juego.getGraficos();
        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.reset, 270, 10);
        //Log.d("texto ",(String)juego.getContext().getText(R.string.level));
        g.drawPixmap(Assets.level, 10, 10);
        if (Configuraciones.numeroNivel < 10) {
            g.drawPixmap(Assets.numero, 170, 10, 40 * Configuraciones.numeroNivel, 0, 40, 40);
        } else {
            g.drawPixmap(Assets.numero, 170, 10, 40, 0, 40, 40);
            g.drawPixmap(Assets.numero, 200, 10, 40 * (Configuraciones.numeroNivel - 10), 0, 40, 40);
        }

        drawWorld(mundo);
        if (estado == EstadoJuego.Preparado) {
            drawReadyUI();
        }
        if (estado == EstadoJuego.Ejecutandose) {
            drawRunningUI();
        }
        if (estado == EstadoJuego.Pausado) {
            drawPausedUI();
        }
        if (estado == EstadoJuego.FinJuego) {
            drawGameOverUI();
        }

        // drawText(g, puntuacion,
        // g.getWidth() / 2 - puntuacion.length() * 20 / 2,
        // g.getHeight() - 64);
    }

    private void drawWorld(Mundo mundo) {
        Graficos g = juego.getGraficos();
        Granja granja = mundo.granja;
        // Tripulacion head = jollyroger.partes.get(0);
        // Bagon bagon = mundo.bagon;

        Pixmap stainPixmap = null;
        // if (bagon.tipo == Bagon.TIPO_1) {
        // stainPixmap = Assets.bagon1;
        // }
        // if (bagon.tipo == Bagon.TIPO_2) {
        // stainPixmap = Assets.bagon2;
        // }
        // if (bagon.tipo == Bagon.TIPO_3) {
        // stainPixmap = Assets.bagon3;
        // }

        // int x = botin.x = 32;
        // int y = botin.y = 32;
        int x;
        int y;
        // g.drawPixmap(stainPixmap, x, y);

        int[][] tablero = granja.tablero;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                y = i * 60 + 50;
                x = j * 60 + -50;
                switch (granja.tablero[i][j]) {
                    // cerca
                    case -1:
                        g.drawPixmap(Assets.cerca, x, y);
                        break;
                    // libre
                    case 0:
                        g.drawPixmap(Assets.libre, x, y);

                        break;
                    // establo
                    case 5:
                        g.drawPixmap(Assets.establo, x, y);

                        break;
                    // obeja
                    case 2:
                        g.drawPixmap(Assets.obeja, x, y);

                        break;
                    // perro
                    case 1:
                        g.drawPixmap(Assets.perro, x, y);

                        break;
                    // arbol
                    case 8:
                        g.drawPixmap(Assets.arbol, x, y);

                        break;

                    default:
                        break;
                }

            }
        }

        Pixmap headPixmap = null;
        // if (jollyroger.direccion == Locomotora.ARRIBA) {
        // headPixmap = Assets.trenarriba;
        // }
        // if (jollyroger.direccion == Locomotora.DERECHA) {
        // headPixmap = Assets.trenderecha;
        // }
        // if (jollyroger.direccion == Locomotora.ABAJO) {
        // headPixmap = Assets.trenabajo;
        // }
        // if (jollyroger.direccion == Locomotora.IZQUIERDA) {
        // headPixmap = Assets.trenizquierda;
        // }
        // x = head.x * 32;// + 16;
        // y = head.y * 32;// + 16;
        // g.drawPixmap(headPixmap, x-headPixmap.getWidth()/2,
        // y-headPixmap.getHeight()/2);
        // g.drawPixmap(headPixmap, x, y);
    }

    private void drawReadyUI() {
        Graficos g = juego.getGraficos();

        // g.drawPixmap(Assets.preparado, 47, 100);
        // g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawRunningUI() {
        Graficos g = juego.getGraficos();

        // g.drawPixmap(Assets.botones, 0, 0, 64, 128, 64, 64);
        // g.drawLine(0, 416, 480, 416, Color.BLACK);
        // g.drawPixmap(Assets.botones, 0, 416, 0, 64, 64, 64);
        // g.drawPixmap(Assets.botones,256,416, 0, 128,64, 64);
        // g.drawPixmap(Assets.botones, 256, 416, 64, 64, 64, 64);
    }

    private void drawPausedUI() {
        Graficos g = juego.getGraficos();

        // g.drawPixmap(Assets.menupausa, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);

    }

    private void drawGameOverUI() {
        Graficos g = juego.getGraficos();

        // g.drawPixmap(Assets.finjuego, 62, 100);
        // g.drawPixmap(Assets.botones, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);

    }

    private void drawText(Graficos g, String line, int x, int y) {
        int len = line.length();

        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);
            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            // g.drawPixmap(Assets.numeros, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;

        }

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        if (estado == EstadoJuego.Ejecutandose) {
            // estado = EstadoJuego.Pausado;
        }

        if (mundo.finalJuego) {
            // Configuraciones.addScore(mundo.puntuacion);
            Configuraciones.saved(juego.getFileIO());
        }
        if(Configuraciones.soundEnabled){
            mp.stop();
        }

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        if(Configuraciones.soundEnabled){
            mp.start();
        }
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        if(Configuraciones.soundEnabled){
            mp.stop();
        }
    }

}

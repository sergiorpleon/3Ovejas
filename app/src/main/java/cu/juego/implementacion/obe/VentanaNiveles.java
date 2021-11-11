package cu.juego.implementacion.obe;

import cu.juego.implementacion.Audio;
import cu.juego.implementacion.Sonido;
import cu.juego.implementacion.android.AndroidAudio;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class VentanaNiveles extends Activity {
    Thread hilo;
    Sonido clic1;
    Audio audio;
    ImageButton[] b = new ImageButton[11];
    ImageButton bsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveles);

        int ww = (getWindowManager().getDefaultDisplay().getWidth() / 3);

        LinearLayout tablero = (LinearLayout) findViewById(R.id.tablero);
        LayoutParams lp = new LayoutParams(ww * 3, ww * 4);
        tablero.setLayoutParams(lp);
        tablero.setGravity(Gravity.CENTER);

        audio = new AndroidAudio(this);
        clic1 = audio.nuevoSonido("clic.ogg");

        String nombrePrefer = "Tren";
        SharedPreferences miPrefer = this.getSharedPreferences(nombrePrefer,
                MODE_PRIVATE);
        Configuraciones.miPrefer = miPrefer;

        b[0] = (ImageButton) findViewById(R.id.button0);
        b[1] = (ImageButton) findViewById(R.id.button1);
        b[2] = (ImageButton) findViewById(R.id.button2);
        b[3] = (ImageButton) findViewById(R.id.button3);
        b[4] = (ImageButton) findViewById(R.id.button4);
        b[5] = (ImageButton) findViewById(R.id.button5);
        b[6] = (ImageButton) findViewById(R.id.button6);
        b[7] = (ImageButton) findViewById(R.id.button7);
        b[8] = (ImageButton) findViewById(R.id.button8);
        b[9] = (ImageButton) findViewById(R.id.button9);
        b[10] = (ImageButton) findViewById(R.id.button10);

        bsound = (ImageButton) findViewById(R.id.buttonsound);

        Configuraciones.cargar();
        if (Configuraciones.virgen) {
            Intent i = new Intent().setClass(VentanaNiveles.this, VentanaHelp.class);
            // i.putExtra("variable1", texto);
            startActivity(i);
            // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } else {
            for (int i = 0; i < b.length; i++) {
                if (i <= Configuraciones.descubierto) {
                    switch (Configuraciones.niveles[i]) {
                        case 0:
                            b[i].setBackgroundResource(R.drawable.obejasimg0);
                            break;
                        case 1:
                            b[i].setBackgroundResource(R.drawable.obejasimg1);

                            break;
                        case 2:
                            b[i].setBackgroundResource(R.drawable.obejasimg2);

                            break;
                        case 3:
                            b[i].setBackgroundResource(R.drawable.obejasimg3);

                            break;

                        default:
                            break;
                    }
                } else {
                    b[i].setBackgroundResource(R.drawable.deshabilitado);
                }
            }
            if (Configuraciones.soundEnabled) {
                bsound.setBackgroundResource(R.drawable.volumeon);
            } else {
                bsound.setBackgroundResource(R.drawable.volumeoff);
            }
        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        dibujarNiveles();
    }

    private void dibujarNiveles() {
        // TODO Auto-generated method stub
        Configuraciones.cargar();
        for (int i = 0; i < b.length; i++) {
            if (i <= Configuraciones.descubierto) {
                switch (3 - Configuraciones.niveles[i]) {
                    case 0:
                        b[i].setBackgroundResource(R.drawable.obejasimg0);
                        break;
                    case 1:
                        b[i].setBackgroundResource(R.drawable.obejasimg1);

                        break;
                    case 2:
                        b[i].setBackgroundResource(R.drawable.obejasimg2);

                        break;
                    case 3:
                        b[i].setBackgroundResource(R.drawable.obejasimg3);

                        break;

                    default:
                        break;
                }
            } else {
                b[i].setBackgroundResource(R.drawable.deshabilitado);
            }
        }

        if (Configuraciones.soundEnabled) {
            bsound.setBackgroundResource(R.drawable.volumeon);
        } else {
            bsound.setBackgroundResource(R.drawable.volumeoff);
        }
    }

    public void precionado(View arg0) {
        // TODO Auto-generated method stub

        switch (arg0.getId()) {
            case R.id.numero0:
                Control.nivel = 0;
                Configuraciones.numeroNivel = 0;
                break;
            case R.id.numero1:
                Control.nivel = 1;
                Configuraciones.numeroNivel = 1;
                break;
            case R.id.numero2:
                Control.nivel = 2;
                Configuraciones.numeroNivel = 2;
                break;
            case R.id.numero3:
                Control.nivel = 3;
                Configuraciones.numeroNivel = 3;
                break;
            case R.id.numero4:
                Control.nivel = 4;
                Configuraciones.numeroNivel = 4;
                break;
            case R.id.numero5:
                Control.nivel = 5;
                Configuraciones.numeroNivel = 5;
                break;
            case R.id.numero6:
                Control.nivel = 6;
                Configuraciones.numeroNivel = 6;
                break;
            case R.id.numero7:
                Control.nivel = 7;
                Configuraciones.numeroNivel = 7;
                break;
            case R.id.numero8:
                Control.nivel = 8;
                Configuraciones.numeroNivel = 8;
                break;
            case R.id.numero9:
                Control.nivel = 9;
                Configuraciones.numeroNivel = 9;
                break;
            case R.id.numero10:
                Control.nivel = 10;
                Configuraciones.numeroNivel = 10;
                break;
            default:
                break;
        }
        if (Control.nivel <= Configuraciones.descubierto) {

            if (Configuraciones.soundEnabled) {
                clic1.play(Configuraciones.soundLevel);
            }
            Log.d("son", "ok");

            Intent i = new Intent(getBaseContext(), Juego3Obejas.class);
            // i.putExtra("variable1", texto);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    public void sonido(View arg0) {
        Configuraciones.soundEnabled = !Configuraciones.soundEnabled;
        if (Configuraciones.soundEnabled) {
            bsound.setBackgroundResource(R.drawable.volumeon);
        } else {
            bsound.setBackgroundResource(R.drawable.volumeoff);
        }
        Configuraciones.guardar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // ------MENU MENU MENU

        crearMenu(menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        selectItem(item);
        return true;
    }

    public void crearMenu(Menu menu) {
        MenuItem ayuda = menu.add(0, 0, 0, "RESET ALL");
        {
            ayuda.setAlphabeticShortcut('r');
            // ayuda.setIcon(R.drawable.logo);
        }

        MenuItem record = menu.add(0, 1, 1, "HELP");
        {
            record.setAlphabeticShortcut('h');
            // record.setIcon(R.drawable.logo);
        }

        // MenuItem informacion = menu.add(0, 2, 2, "ABOUT");
        // {
        // informacion.setAlphabeticShortcut('a');
        // informacion.setIcon(R.drawable.logo);
        // }

        // MenuItem reiniciar = menu.add(0, 3, 3, "BEGIN");
        // {
        // informacion.setAlphabeticShortcut('b');
        // informacion.setIcon(R.drawable.logo);
        // }

    }

    public boolean selectItem(MenuItem item) {
        switch (item.getItemId()) {

            case 0:
                SharedPreferences.Editor editor = Configuraciones.miPrefer.edit();
                // --- Guardado de los valores
                editor.putBoolean("sound", Configuraciones.soundEnabled);
                editor.putInt("descubierto", 0);
                for (int i = 0; i < 11; i++) {
                    // mov1 = lisP.get(i);
                    editor.putInt("nivel" + i, 3);
                }
                editor.commit();
                Configuraciones.cargar();
                dibujarNiveles();
                break;
            case 1:
                Intent i = new Intent(getBaseContext(), VentanaHelp.class);
                // i.putExtra("variable1", texto);
                startActivity(i);
                // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            default:
                break;
        }

        return true;
    }

}

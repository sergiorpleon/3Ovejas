package cu.juego.implementacion.obe;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashNew extends Activity {
    // Set the duration of the splash screen
    ImageView imgNivel;
    TextView msgtext;
    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_new);

        imgNivel = (ImageView) findViewById(R.id.numeroX);
        msgtext = (TextView) findViewById(R.id.mensaje);
        msgtext.setText(R.string.nuevo_nivel);
        switch (Configuraciones.descubierto) {
            case 0:
                imgNivel.setBackgroundResource(R.drawable.n0);
                break;
            case 1:
                imgNivel.setBackgroundResource(R.drawable.n1);
                break;
            case 2:
                imgNivel.setBackgroundResource(R.drawable.n2);
                break;
            case 3:
                imgNivel.setBackgroundResource(R.drawable.n3);
                break;
            case 4:
                imgNivel.setBackgroundResource(R.drawable.n4);
                break;
            case 5:
                imgNivel.setBackgroundResource(R.drawable.n5);
                break;
            case 6:
                imgNivel.setBackgroundResource(R.drawable.n6);
                break;
            case 7:
                imgNivel.setBackgroundResource(R.drawable.n7);
                break;
            case 8:
                imgNivel.setBackgroundResource(R.drawable.n8);
                break;
            case 9:
                imgNivel.setBackgroundResource(R.drawable.n9);
                break;
            case 10:
                imgNivel.setBackgroundResource(R.drawable.n10);
                break;
            case 11:
                imgNivel.setBackgroundResource(R.drawable.logo);
                msgtext.setText(R.string.ganador);
                break;
            default:
                break;
        }

        //int ww = (getWindowManager().getDefaultDisplay().getWidth()/2);
        //LinearLayout layoutlogo = (LinearLayout) findViewById(R.id.LayoutLogo1);
        //LayoutParams lp=new LayoutParams(ww, ww);
        //layoutlogo.setLayoutParams(lp);
        //layoutlogo.setGravity(Gravity.CENTER);


        if (Configuraciones.soundEnabled) {
            Assets.felicidades.play(Configuraciones.soundLevel);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(SplashNew.this,
                        VentanaNiveles.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //super.onBackPressed();
    }


}

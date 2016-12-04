package tw.chikuo.genderflip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by bjorgaas on 15/12/10.
 */
public class Splash extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 500; //延迟三秒

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //cloud log when app is start
        //------
//        Utility.getInstance(getApplicationContext()).CloudLog(
//                Utility.LogLevel.MAIN_PROCESS,
//                "Broadcast Receiver = startService");
//
//        Utility.getInstance(getApplicationContext()).CloudLog(
//                Utility.LogLevel.MAIN_PROCESS,
//                Utility.getInstance(getApplicationContext()).getAndroidID());
//
//        Utility.getInstance(getApplicationContext()).CloudLog(
//                Utility.LogLevel.MAIN_PROCESS,
//                Utility.getInstance(getApplicationContext()).getNetworkStatus());
//
//        Utility.getInstance(getApplicationContext()).CloudLog(
//                Utility.LogLevel.MAIN_PROCESS,
//                "Enable Telnet = " + Utility.getInstance(getApplicationContext()).EnableTelnet());
        //------

//        ImageView im = (ImageView)findViewById(R.id.splashlogo);
//        final Animation LeftAM = new RotateAnimation(10, -10, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                Splash.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);
    }
}
package net.laili.pasporbayi.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.auth.LoginActivity;
import net.laili.pasporbayi.utils.AppSessionManager;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_launcher);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                AppSessionManager appSessionManager = new AppSessionManager(getApplicationContext());
                Intent intent;
                if (appSessionManager.isUserLoggedIn()) {
                    intent = new Intent(LauncherActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(LauncherActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}

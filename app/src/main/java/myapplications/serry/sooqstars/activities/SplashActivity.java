package myapplications.serry.sooqstars.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import myapplications.serry.sooqstars.helpers.Constants;

/**
 * Created by awstreams on 8/21/17.
 */

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(Constants.MyPrefs, 0);
        if (sharedPreferences.getBoolean(Constants.isLoggedIn, true)) {
            intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            intent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.hr190027.salim_emirhan_ulusoy_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.util.SparseArray;

import com.hr190027.salim_emirhan_ulusoy_final.R;
import com.hr190027.salim_emirhan_ulusoy_final.util.AlertDialogUtil;
import com.hr190027.salim_emirhan_ulusoy_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init(){
            CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long l) {

                    Log.e("COUNTER", "TİCK");
                }

                @Override
                public void onFinish() {
                    if (!NetworkUtil.isOnline(SplashActivity.this)) {
                        AlertDialogUtil.alertDialogSplash(SplashActivity.this);
                    } else {
                        openNextScreenActivity();
                    }
                }
            };
            countDownTimer.start();
    }

    private void openNextScreenActivity(){

        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();

    }
}
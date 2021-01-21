package com.hr190027.salim_emirhan_ulusoy_final.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.hr190027.salim_emirhan_ulusoy_final.R;
import com.hr190027.salim_emirhan_ulusoy_final.activity.ListeActivity;
import com.hr190027.salim_emirhan_ulusoy_final.activity.SplashActivity;

public class AlertDialogUtil {

    public static void alertDialogSplash(Context context){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setTitle(context.getResources().getString(R.string.internetBaglantiTitle));
        alertbox.setMessage(context.getResources().getString(R.string.internetBaglantiMessage));
        alertbox.setNegativeButton(context.getResources().getString(R.string.internetBaglantiKapat), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                System.exit(0);
            }
        })
                .setPositiveButton(context.getResources().getString(R.string.internetBaglantiSettings), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                    }
                });
        alertbox.show();
    }

    public static void alertDialogListe(Context context){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setTitle(context.getResources().getString(R.string.uygulamaKapatTitle));
        alertbox.setPositiveButton(context.getResources().getString(R.string.uygulamaKapatPositive), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                System.exit(0);
            }
        })
                .setNegativeButton(context.getResources().getString(R.string.uygulamaKapatNegative), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }

}

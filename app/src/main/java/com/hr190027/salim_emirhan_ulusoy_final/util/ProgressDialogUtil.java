package com.hr190027.salim_emirhan_ulusoy_final.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.hr190027.salim_emirhan_ulusoy_final.R;

public class ProgressDialogUtil {

    public static void progressDialog(Context context) {

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage(context.getResources().getString(R.string.progressDialog));
        progressDialog.show();
        final int totalTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while (jumpTime < totalTime) {
                    try {
                        sleep(50);
                        jumpTime += 1;
                        progressDialog.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        };
        t.start();
    }
}

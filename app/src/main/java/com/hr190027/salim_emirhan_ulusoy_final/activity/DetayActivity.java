package com.hr190027.salim_emirhan_ulusoy_final.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190027.salim_emirhan_ulusoy_final.R;
import com.hr190027.salim_emirhan_ulusoy_final.model.OyunModel;
import com.hr190027.salim_emirhan_ulusoy_final.util.Constants;
import com.hr190027.salim_emirhan_ulusoy_final.util.GlideUtil;
import com.hr190027.salim_emirhan_ulusoy_final.util.ObjectUtil;

public class DetayActivity extends AppCompatActivity {

    ImageView imgDetayKapak;
    TextView txtBaslik;
    TextView txtDetay;
    TextView txtPlatformDetay;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init(getBaseContext());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void init(Context context) {
        String tasinanOyunString = getIntent().getStringExtra(Constants.TIKLANAN_OYUN_BASLIGI);
        OyunModel oyunModel = ObjectUtil.jsonStringToOyun(tasinanOyunString);

        imgDetayKapak = findViewById(R.id.imgDetayKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);
        txtPlatformDetay = findViewById(R.id.txtPlatformDetay);

        txtBaslik.setText(oyunModel.getOyunAdi()+ " " + context.getResources().getString(R.string.acKonu));
        txtDetay.setText(Html.fromHtml(oyunModel.getOyunKonu(), Html.FROM_HTML_MODE_COMPACT));
        txtPlatformDetay.setText(Html.fromHtml(oyunModel.getOyunPlatform(),Html.FROM_HTML_MODE_COMPACT));
        GlideUtil.resmiIndiripGoster(getApplicationContext(),oyunModel.getOyunKapakUrl(),imgDetayKapak);
    }
}
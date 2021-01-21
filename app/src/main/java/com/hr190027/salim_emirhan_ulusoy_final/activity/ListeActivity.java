package com.hr190027.salim_emirhan_ulusoy_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.hr190027.salim_emirhan_ulusoy_final.R;
import com.hr190027.salim_emirhan_ulusoy_final.adaptor.OyunAdaptor;
import com.hr190027.salim_emirhan_ulusoy_final.model.OyunModel;
import com.hr190027.salim_emirhan_ulusoy_final.network.Service;
import com.hr190027.salim_emirhan_ulusoy_final.util.AlertDialogUtil;
import com.hr190027.salim_emirhan_ulusoy_final.util.Constants;
import com.hr190027.salim_emirhan_ulusoy_final.util.ObjectUtil;
import com.hr190027.salim_emirhan_ulusoy_final.util.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ProgressDialogUtil.progressDialog(ListeActivity.this);

        init();

    }

    private  void  init()
    {
        oyunlariGetir();
    }


    void  oyunlariGetir()
    {

        new Service().getServiceApi().oyunlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<OyunModel>>() {

                    List<OyunModel> oyunlar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<OyunModel> oyunlarList) {
                        Log.e("RETROFIT","onNext : ");
                        oyunlar=oyunlarList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(oyunlar.size()>0) {
                            initRecycleView(oyunlar);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<OyunModel> oyunlarList)
    {
        recyclerView =findViewById(R.id.rcvOyunlar);
        OyunAdaptor oyunAdaptor =new OyunAdaptor(oyunlarList, getApplicationContext(), new OyunAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                OyunModel tiklananOyun = oyunlarList.get(position);
                Toast.makeText(getApplicationContext(), getApplicationContext().getResources().getString(R.string.tiklananOyunAdi) + tiklananOyun.getOyunAdi(), Toast.LENGTH_SHORT).show();

                openNextScreenActivity(tiklananOyun);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(oyunAdaptor);
    }
    private void openNextScreenActivity(OyunModel tiklananOyun){


        Intent secondActivityIntent=new Intent(getApplicationContext(), DetayActivity.class);
        String tiklananOyunString = ObjectUtil.oyunToJsonString(tiklananOyun);
        secondActivityIntent.putExtra(Constants.TIKLANAN_OYUN_BASLIGI,tiklananOyunString);
        startActivity(secondActivityIntent);


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        AlertDialogUtil.alertDialogListe(ListeActivity.this);
    }

}

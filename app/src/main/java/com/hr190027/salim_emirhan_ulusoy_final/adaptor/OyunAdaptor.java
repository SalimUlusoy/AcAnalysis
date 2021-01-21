package com.hr190027.salim_emirhan_ulusoy_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190027.salim_emirhan_ulusoy_final.model.OyunModel;
import com.hr190027.salim_emirhan_ulusoy_final.R;
import com.hr190027.salim_emirhan_ulusoy_final.util.GlideUtil;

import java.util.List;

public class OyunAdaptor extends RecyclerView.Adapter<OyunViewHolder> {


    List<OyunModel> oyunlar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClik(int position);
    }


    public OyunAdaptor(List<OyunModel> oyunlar, Context context, OnItemClickListener listener) {
        this.oyunlar = oyunlar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OyunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_oyun,parent,false);
        return new OyunViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull OyunViewHolder viewHolder, int position) {

        viewHolder.txtOyunTarih.setText(oyunlar.get(position).getOyunCikisTarihi());
        viewHolder.txtOyunAdi.setText(oyunlar.get(position).getOyunAdi());
        GlideUtil.resmiIndiripGoster(context,oyunlar.get(position).getOyunIconUrl(),viewHolder.imgOyunLogo);

    }

    @Override
    public int getItemCount() {
        return oyunlar.size();
    }
}

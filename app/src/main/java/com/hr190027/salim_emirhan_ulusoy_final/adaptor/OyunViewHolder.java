package com.hr190027.salim_emirhan_ulusoy_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190027.salim_emirhan_ulusoy_final.R;

public class OyunViewHolder extends RecyclerView.ViewHolder {

    ImageView imgOyunLogo;
    TextView txtOyunAdi;
    TextView txtOyunTarih;

    public OyunViewHolder(@NonNull View cardView, OyunAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgOyunLogo =cardView.findViewById(R.id.imgOyunLogo);
        txtOyunAdi =cardView.findViewById(R.id.txtOyunAdi);
        txtOyunTarih =cardView.findViewById(R.id.txtOyunTarih);

        cardView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}

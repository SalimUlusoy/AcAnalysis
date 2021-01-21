package com.hr190027.salim_emirhan_ulusoy_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr190027.salim_emirhan_ulusoy_final.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.creedbanner)
                .centerCrop()
                .into(img);
    }
}

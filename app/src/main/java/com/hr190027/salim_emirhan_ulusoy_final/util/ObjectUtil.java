package com.hr190027.salim_emirhan_ulusoy_final.util;

import com.google.gson.Gson;
import com.hr190027.salim_emirhan_ulusoy_final.model.OyunModel;

public class ObjectUtil {

    public  static String oyunToJsonString(OyunModel oyunModel)
    {
        Gson gson = new Gson();
        return gson.toJson(oyunModel);
    }

    public  static OyunModel jsonStringToOyun(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,OyunModel.class);
    }
}

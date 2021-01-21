package com.hr190027.salim_emirhan_ulusoy_final.network;

import com.hr190027.salim_emirhan_ulusoy_final.model.OyunModel;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("OyunSerisi.json")
    Observable<List<OyunModel>> oyunlariGetir();
}

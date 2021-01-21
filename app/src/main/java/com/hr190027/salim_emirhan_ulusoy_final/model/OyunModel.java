package com.hr190027.salim_emirhan_ulusoy_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OyunModel {

    @SerializedName("OyunAdi")
    @Expose
    private String oyunAdi;
    @SerializedName("OyunCikisTarihi")
    @Expose
    private String oyunCikisTarihi;
    @SerializedName("OyunIconUrl")
    @Expose
    private String oyunIconUrl;
    @SerializedName("OyunKapakUrl")
    @Expose
    private String oyunKapakUrl;
    @SerializedName("OyunKonu")
    @Expose
    private String oyunKonu;
    @SerializedName("OyunPlatform")
    @Expose
    private String oyunPlatform;

    public String getOyunAdi() {
        return oyunAdi;
    }

    public void setOyunAdi(String oyunAdi) {
        this.oyunAdi = oyunAdi;
    }

    public String getOyunCikisTarihi() {
        return oyunCikisTarihi;
    }

    public void setOyunCikisTarihi(String oyunCikisTarihi) {
        this.oyunCikisTarihi = oyunCikisTarihi;
    }

    public String getOyunIconUrl() {
        return oyunIconUrl;
    }

    public void setOyunIconUrl(String oyunIconUrl) {
        this.oyunIconUrl = oyunIconUrl;
    }

    public String getOyunKapakUrl() {
        return oyunKapakUrl;
    }

    public void setOyunKapakUrl(String oyunKapakUrl) {
        this.oyunKapakUrl = oyunKapakUrl;
    }

    public String getOyunKonu() {
        return oyunKonu;
    }

    public void setOyunKonu(String oyunKonu) {
        this.oyunKonu = oyunKonu;
    }

    public String getOyunPlatform() {
        return oyunPlatform;
    }

    public void setOyunPlatform(String oyunPlatform) {
        this.oyunPlatform = oyunPlatform;
    }

}
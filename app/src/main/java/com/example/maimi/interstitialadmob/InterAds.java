package com.example.maimi.interstitialadmob;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
/**
 * Created by minhtien on 8/6/2016.
 */
public class InterAds {
    InterstitialAd mInterstitialAd;
    private Context context;
    private CallBackAds mCallBackAds;
    private String idAds;
    public InterAds(Context context, String idAds) {
        this.context = context;
        this.idAds = idAds;
        init();
    }
    public void init() {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(idAds);
        requestNewInterstitial();
    }
    public void setListener(AdListener adListener){
        mInterstitialAd.setAdListener(adListener);
    }
    public void start() {
        mInterstitialAd.show();
    }
    public boolean loadedAds() {
        return mInterstitialAd.isLoaded();
    }
    public void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
    interface CallBackAds {
        public void beginAction();
    }
}

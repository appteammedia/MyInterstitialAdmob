package com.example.maimi.interstitialadmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    InterAds interAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interAds = new InterAds(this, "ca-app-pub-8634259134319673/1487586747");
        interAds.setListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                beginPlayingGame();
                interAds.requestNewInterstitial();
            }
        });
        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interAds.loadedAds())
                    interAds.start();
                else
                    beginPlayingGame();
            }
        });
    }

    private void beginPlayingGame() {
        Log.d("test","startActivity");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}

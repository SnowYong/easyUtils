package com.mcs.easyutils;

import android.content.Context;

@SuppressWarnings("unused")
public class EasyAdsMod
{
    private static String TAG = "EasyAdsMod";
    private Context context = null;
    private boolean ads = false;

    public EasyAdsMod(Context context) {
        this.context = context;
    }

    public boolean areAdsDisabled(String adCo){
        EasyAdsModListener easyAdsModListener = new EasyAdsModListener() {
            @Override
            public boolean onResult(boolean areAdsDisabled) {
                return ads = areAdsDisabled;
            }
        };
        EasyAdsModTask easyAdsModTask = new EasyAdsModTask(context, adCo, easyAdsModListener);
        easyAdsModTask.execute();

        return ads;
    }

}
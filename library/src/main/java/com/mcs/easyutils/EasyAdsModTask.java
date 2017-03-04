package com.mcs.easyutils;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyAdsModTask extends AsyncTask<Void, Void, Boolean> {

    private Context context = null;
    private String adcoName = null;
    private EasyAdsModListener listener;

    public EasyAdsModTask(Context context, String adCo, EasyAdsModListener listener) {
        this.context = context;
        this.adcoName = adCo;
        this.listener  = listener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        boolean result = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream("/etc/hosts")));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains(adcoName)) {
                    return result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result = false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (listener != null)
            listener.onResult(result);
    }
}
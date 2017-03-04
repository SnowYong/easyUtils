package com.mcs.easyutils;

public interface EasySocialModListener
{
    void onSuccess();
    void onFail(boolean isConnected, boolean isAppInstalled);
}
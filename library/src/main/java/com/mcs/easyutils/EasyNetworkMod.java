package com.mcs.easyutils;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.RequiresPermission;

import static com.mcs.easyutils.EasyLogMod.warn;

@SuppressWarnings("unused")
public class EasyNetworkMod
{
    private static String TAG = "EasyNetworkMod";
    private final Context context;

    public EasyNetworkMod(final Context context) {
        this.context = context;
    }

    public final boolean isWifiEnabled() {
        boolean wifiState = false;

        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            wifiState = wifiManager.isWifiEnabled();
        }
        return wifiState;
    }

    @RequiresPermission(Manifest.permission.BLUETOOTH)
    public static boolean isBluEnabled() {
        boolean blu = false;

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter != null && mBluetoothAdapter.isEnabled()) {
            return blu = true;
        }
        else {
            if(mBluetoothAdapter == null) {
                warn(TAG, "Device does not support Bluetooth");
            }
            else {
                warn(TAG, "Bluetooth is not enabled");
            }
            return blu = false;
        }
    }

    public final boolean isOnline() {
        if (hasPermission(Manifest.permission.INTERNET) &&
                hasPermission(Manifest.permission.ACCESS_NETWORK_STATE)) {
            ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
        warn(TAG, "Requires internet permissions");
        return false;
    }

    private boolean hasPermission(String permission){
        EasyPermissionMod easyPermissionMod = new EasyPermissionMod(context);
        return easyPermissionMod.hasPermission(permission);
    }
}
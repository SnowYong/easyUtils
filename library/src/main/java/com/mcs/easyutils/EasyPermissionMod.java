package com.mcs.easyutils;

import android.content.Context;
import android.content.pm.PackageManager;

@SuppressWarnings("unused")
public class EasyPermissionMod
{
    private static String TAG = "EasyPermissionMod";

    private final Context context;

    public EasyPermissionMod(final Context context) {
        this.context = context;
    }

    public final boolean hasPermission(final String permission) {
        return context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}
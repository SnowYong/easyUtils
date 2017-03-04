package com.mcs.easyutils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import static com.mcs.easyutils.EasyLogMod.warn;
import static com.mcs.easyutils.EasyParseMod.intToString;

@SuppressWarnings("unused")
public class EasyAppMod
{
    private static final String NAME_NOT_FOUND_EXCEPTION = "Name Not Found Exception";
    private static String TAG = "EasyAppMod";
    private final Context context;

    public EasyAppMod(final Context context) {
        this.context = context;
    }

    public final boolean ifAppIsInstalled(String pkg) {
        return IsAppInstalled(pkg) && isAppEnabled(pkg);
    }

    private boolean IsAppInstalled(String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            warn(TAG, "NameNotFoundException: " + e);
            return false;
        }
    }

    private boolean isAppEnabled(String pkg) {
        try {
            ApplicationInfo ai =  context.getPackageManager().getApplicationInfo(pkg, 0);
            return ai.enabled;
        } catch (PackageManager.NameNotFoundException e) {
            warn(TAG, "NameNotFoundException: " + e);
            return false;
        }
    }

    public final String appVersionName(String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            PackageInfo pinfo;
            try {
                pinfo = context.getPackageManager().getPackageInfo(pkg, 0);
                return pinfo.versionName;
            } catch (Exception e) {
                warn(TAG, "Exception: " + e);
                return NAME_NOT_FOUND_EXCEPTION;
            }
        } catch (PackageManager.NameNotFoundException e) {
            warn(TAG, "NameNotFoundException: " + e);
            return NAME_NOT_FOUND_EXCEPTION;
        }
    }

    public final String appVersionCode(String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            PackageInfo pinfo;
            try {
                pinfo = context.getPackageManager().getPackageInfo(pkg, 0);
                int version = pinfo.versionCode;
                return intToString(version);
            } catch (Exception e) {
                warn(TAG, "Exception: " + e);
                return NAME_NOT_FOUND_EXCEPTION;
            }
        } catch (PackageManager.NameNotFoundException e) {
            warn(TAG, "NameNotFoundException: " + e);
            return NAME_NOT_FOUND_EXCEPTION;
        }
    }

    public final String appPackageName(){
        return context.getPackageName();
    }
}
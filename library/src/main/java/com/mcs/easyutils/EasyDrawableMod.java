package com.mcs.easyutils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import static com.mcs.easyutils.EasyLogMod.warn;

@SuppressWarnings("unused")
public class EasyDrawableMod
{
    private static String TAG = "EasyDrawableMod";
    private final Context context;

    public EasyDrawableMod(final Context context) {
        this.context = context;
    }

    public final Drawable getAppIcon(String pkgID, Drawable FallBackDrawable){
        if(isAppInstalled(pkgID)){
            try {
                return context.getApplicationContext().getPackageManager().getApplicationIcon(pkgID);
            }catch (Exception e){
                warn(TAG, "Exception: " + e);
                return FallBackDrawable;
            }
        }
        else{
            return FallBackDrawable;
        }
    }

    private boolean isAppInstalled(String pkgID){
        EasyAppMod easyAppMod = new EasyAppMod(context);
        return easyAppMod.ifAppIsInstalled(pkgID);
    }

}
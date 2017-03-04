package com.mcs.easyutils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;

@SuppressWarnings("unused")
public class EasyActivityMod
{
    public static void restartApp(Context context){
        Intent i = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        flag_activity_clear_task(i);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
    @TargetApi(11)
    private static void flag_activity_clear_task(Intent i){
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }
}
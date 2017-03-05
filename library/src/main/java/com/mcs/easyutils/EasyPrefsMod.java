package com.mcs.easyutils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;
import java.util.Set;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@SuppressWarnings("unused")
public class EasyPrefsMod
{
    //modes
    public static final int MODE_PRIVATE = 0;
    public static final int MODE_WORLD_READABLE = 1;
    public static final int MODE_WORLD_WRITEABLE = 2;
    public static final int MODE_MULTI_PROCESS = 4;

    private static String TAG = "EasyPrefsMod";
    private final Context context;

    public EasyPrefsMod(final Context context) {
        this.context = context;
    }

    //SharedPrefs
    private SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    private SharedPreferences prefs(String Prefs, int mode) {
        return context.getSharedPreferences(Prefs, mode);
    }

    //SharedPreferences.Editor
    private SharedPreferences.Editor editor(){
        SharedPreferences defaultPrefs = prefs();
        return defaultPrefs.edit();
    }
    private SharedPreferences.Editor editor(String Prefs, int mode){
        SharedPreferences customPrefs = prefs(Prefs, mode);
        return customPrefs.edit();
    }

    //get stuff!
    //Strings
    public final String getString(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getString(key, "");
    }
    public final String getString(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getString(key, "");
    }

    //booleans
    public final boolean getBoolean(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getBoolean(key, false);
    }
    public final boolean getBoolean(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getBoolean(key, false);
    }

    //StringSet<String>
    @TargetApi(HONEYCOMB)
    public final Set<String> getStringSet(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getStringSet(key, null);
    }
    @TargetApi(HONEYCOMB)
    public final Set<String> getStringSet(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getStringSet(key, null);
    }

    //int
    public final int getInt(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getInt(key, 0);
    }
    public final int getInt(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getInt(key, 0);
    }

    //float
    public final Float getFloat(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getFloat(key, 0.0f);
    }
    public final Float getFloat(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getFloat(key, 0.0f);
    }

    //long
    public final Long getLong(String key) {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getLong(key, 0L);
    }
    public final Long getLong(String Prefs, int mode, String key) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getLong(key, 0L);
    }

    //all
    public final Map<String,?> getAll() {
        SharedPreferences getPrefs = prefs();
        return getPrefs.getAll();
    }
    public final Map<String,?> getAll(String Prefs, int mode) {
        SharedPreferences getPrefs = prefs(Prefs, mode);
        return getPrefs.getAll();
    }

    //put stuff
    //string
    public final void put(String key, String value) {
        SharedPreferences.Editor default0 = editor();
        default0.putString(key, value);
        default0.apply();
    }
    public final void put(String Prefs, int mode, String key, String value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putString(key, value);
        custom1.apply();
    }

    //boolean
    public final void put(String key, boolean value) {
        SharedPreferences.Editor default0 = editor();
        default0.putBoolean(key, value);
        default0.apply();
    }
    public final void put(String Prefs, int mode, String key, boolean value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putBoolean(key, value);
        custom1.apply();
    }

    // Set<String>
    @TargetApi(HONEYCOMB)
    public final void put(String key,  Set<String> value) {
        SharedPreferences.Editor default0 = editor();
        default0.putStringSet(key, value);
        default0.apply();
    }
    @TargetApi(HONEYCOMB)
    public final void put(String Prefs, int mode, String key,  Set<String> value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putStringSet(key, value);
        custom1.apply();
    }

    //int
    public final void put(String key, int value) {
        SharedPreferences.Editor default0 = editor();
        default0.putInt(key, value);
        default0.apply();
    }
    public final void put(String Prefs, int mode, String key, int value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putInt(key, value);
        custom1.apply();
    }

    //float
    public final void put(String key, float value) {
        SharedPreferences.Editor default0 = editor();
        default0.putFloat(key, value);
        default0.apply();
    }
    public final void put(String Prefs, int mode, String key, float value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putFloat(key, value);
        custom1.apply();
    }

    //long
    public final void put(String key, long value) {
        SharedPreferences.Editor default0 = editor();
        default0.putLong(key, value);
        default0.apply();
    }
    public final void put(String Prefs, int mode, String key, long value) {
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.putLong(key, value);
        custom1.apply();
    }

    public final void clearValue(String key){
        SharedPreferences.Editor default0 = editor();
        default0.remove(key);
        default0.apply();
    }
    public final void clearValue(String Prefs, int mode, String key){
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.remove(key);
        custom1.apply();
    }

    public final void clearAll(){
        SharedPreferences.Editor default0 = editor();
        default0.clear();
        default0.apply();
    }
    public final void clearAll(String Prefs, int mode){
        SharedPreferences.Editor custom1 = editor(Prefs, mode);
        custom1.clear();
        custom1.apply();
    }

}
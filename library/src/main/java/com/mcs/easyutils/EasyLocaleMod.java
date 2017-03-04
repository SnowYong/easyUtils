package com.mcs.easyutils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.mcs.easyutils.EasyPrefsMod;

import java.util.Locale;

@SuppressWarnings("unused")
public class EasyLocaleMod {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    private static String TAG = "EasyLocaleMod";
    private final Context context;

    public EasyLocaleMod(final Context context) {
        this.context = context;
    }

    //returns "en"
    public final String getLanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    public final void defaultLocale() {
        String lang = getPersistedData(Locale.getDefault().getLanguage());
        setLocale(lang);
    }

    public final void setLanguage(String defaultLanguage) {
        String lang = getPersistedData(defaultLanguage);
        setLocale(lang);
    }

    public final String getLanguage() {
        return getPersistedData(Locale.getDefault().getLanguage());
    }

    public final void setLocale(String language) {
        persist(language);
        updateResources(language);
    }

    private String getPersistedData(String defaultLanguage) {
        EasyPrefsMod easyPrefsMod = new EasyPrefsMod(context);
        return easyPrefsMod.getString(SELECTED_LANGUAGE);
    }

    private void persist( String language) {
        EasyPrefsMod easyPrefsMod = new EasyPrefsMod(context);
        easyPrefsMod.put(SELECTED_LANGUAGE, language);
    }


    @SuppressWarnings("deprecation")
    private void updateResources(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
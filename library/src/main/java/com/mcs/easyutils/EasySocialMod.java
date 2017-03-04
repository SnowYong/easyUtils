package com.mcs.easyutils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static com.mcs.easyutils.EasyLogMod.error;
import static com.mcs.easyutils.EasyLogMod.warn;
import static com.mcs.easyutils.EasyParseMod.containsDigit;
import static com.mcs.easyutils.EasyParseMod.stringToInt;


@SuppressWarnings("unused")
public class EasySocialMod
{
    private static String TAG = "EasySocialAppMod";
    private final Context context;
    private final EasySocialModListener listener;

    public EasySocialMod(final Context context, final EasySocialModListener listener) {
        this.context = context;
        this.listener  = listener;
    }

    private static final String LATEST_FB_PAGE_URL = "fb://facewebmodal/f?href=https://www.facebook.com/";
    private static final String LEGACY_FB_PAGE_URL = "fb://page/";
    private static final String LATEST_FB_PROFILE_URL = "fb://facewebmodal/f?href=https://www.facebook.com/profile.php?id=";
    private static final String LEGACY_FB_PROFILE_URL = "https://www.facebook.com/";
    private static final String FB_VERSION = "11.0.0.11.23";
    private static final String TWITTER_URL = "twitter://user?screen_name=";
    private static final String GOOGLE_PLUS_COMMUNITY_URL = "https://plus.google.com/communities/";
    private static final String GOOGLE_PLUS_PROFILE_URL = "https://plus.google.com/";
    private static final String YOUTUBE_URL = "vnd.youtube:";
    private static final String YOUTUBE_CHANNEL_URL = "https://www.youtube.com/channel/";

    public static final String FACEBOOK_APP = "com.facebook.katana";
    public static final String GOOGLE_PLUS_APP = "com.google.android.apps.plus";
    public static final String TWITTER_APP = "com.twitter.android";
    public static final String YOUTUBE_APP = "com.google.android.youtube";

    public static final String SOCIAL_PAGE = "page";
    public static final String SOCIAL_PROFILE = "profile";
    public static final String SOCIAL_COMMUNITY = "community";
    public static final String SOCIAL_VIDEO = "video";

    //social app
    public final void openSocialApp(String appID, String PPCV, String uri){

        switch (appID + "-" + PPCV) {
            case FACEBOOK_APP + "-" + SOCIAL_PAGE:
                socialApp(FACEBOOK_APP, fbPage(uri));
                break;
            case FACEBOOK_APP + "-" + SOCIAL_PROFILE:
                socialApp(FACEBOOK_APP, fbProfile(uri));
                break;
            case TWITTER_APP + "-" + SOCIAL_PROFILE:
                socialApp(TWITTER_APP, TWITTER_URL + uri);
                break;
            case GOOGLE_PLUS_APP + "-" + SOCIAL_PROFILE:
                socialApp(GOOGLE_PLUS_APP, GOOGLE_PLUS_PROFILE_URL + uri);
                break;
            case GOOGLE_PLUS_APP + "-" + SOCIAL_COMMUNITY:
                socialApp(GOOGLE_PLUS_APP, GOOGLE_PLUS_COMMUNITY_URL + uri);
                break;
            case YOUTUBE_APP + "-" + SOCIAL_PROFILE:
                socialApp(YOUTUBE_APP, YOUTUBE_CHANNEL_URL + uri);
                break;
            case YOUTUBE_APP + "-" + SOCIAL_VIDEO:
                socialApp(YOUTUBE_APP, YOUTUBE_URL + uri);
                break;
            default:
                warn(TAG, "error: app/intent not supported");
                break;
        }

    }
    public final void openSocialApp(String appID, String uri) {
        if(isAppinstalled(uri)) {
            socialApp(appID, uri);
        }
        else{
            warn(TAG, "error: app not installed");
        }
    }

    //fb uri util
    private String fbPage(String uri){
        String version = appVersionName(FACEBOOK_APP);
        String version2 = version.replaceAll("[.]", "");
        String fb = FB_VERSION.replaceAll("[.]", "");//11.0.0.11.23 to 11001123
        try {
            if (stringToInt(version2) >= stringToInt(fb))
            {
                return LATEST_FB_PAGE_URL + uri;
            } else {
                return LEGACY_FB_PAGE_URL + uri;
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return null;
        }
    }
    private String fbProfile(String uri){
        String version = appVersionName(FACEBOOK_APP);
        String version2 = version.replaceAll("[.]", "");
        String fb = FB_VERSION.replaceAll("[.]", "");//11.0.0.11.23 to 11001123
        try {

            if (stringToInt(version2) >= stringToInt(fb))//11.0.0.11.23 to 11001123
            {
                if(containsDigit(uri)) {
                    return LATEST_FB_PROFILE_URL + uri;
                }
                else{
                    return LATEST_FB_PAGE_URL + uri;
                }
            } else {
                return LEGACY_FB_PROFILE_URL + uri;
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return null;
        }
    }

    private void socialApp(String appID, String uri){
        switch (isNetWorkAvailable() + "-" + isAppinstalled(appID)) {
            case "false-false":
                onFail(false, false);
                break;
            case "false-true":
                onFail(false, true);
                break;
            case "true-false":
                onFail(true, false);
                break;
            case "true-true":
                try {
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage(appID);
                    context.startActivity(intent);
                    onSuccess();
                }catch (Exception e){
                    error(TAG, "error" + e);
                }
                break;
            default:
                onFail(false, false);
                break;
        }
    }

    //rating
    public final void rateApp(){
        rateApp(pkgName());
    }
    public final void rateApp(String appID){
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appID)));
        } catch (android.content.ActivityNotFoundException anfe) {
            warn(TAG, "ActivityNotFoundException: " + anfe);
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appID)));
        }
    }

    //app utils
    private boolean isAppinstalled(String name){
        EasyAppMod appMod = new EasyAppMod(context);
        return appMod.ifAppIsInstalled(name);
    }
    private String pkgName(){
        EasyAppMod appMod = new EasyAppMod(context);
        return appMod.appPackageName();
    }
    private String appVersionName(String pkgID){
        EasyAppMod appMod = new EasyAppMod(context);
        return appMod.appVersionName(pkgID);
    }

    //network util
    private boolean isNetWorkAvailable(){
        EasyNetworkMod easyNetworkMod = new EasyNetworkMod(context);
        return easyNetworkMod.isOnline();
    }

    //listener methods
    private void onSuccess(){
        listener.onSuccess();
    }
    private void onFail(boolean isConnected, boolean isAppInstalled){
        listener.onFail(isConnected, isAppInstalled);
    }
}
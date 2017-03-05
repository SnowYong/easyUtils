# easyUtils
Collection of utility classes!

[![](https://jitpack.io/v/Xstar97/easyUtils.svg)](https://jitpack.io/#Xstar97/easyUtils)

The best way to use the Easy easy = new Easy(context); is to throw it in a private void/string/boolean/drawable/etc & then use it exclusively in the activity or fragment with even less written code.

# EasyActivityMod
Restart your app "safely" and easily!

    EasyActivityMod.restartApp(context);

# EasyAdsMod
Return boolean if the device's host file contains the specific name of the ad company; returns boolean if device is blocking ads.

    EasyAdsMod easyAdsMod = new EasyAdsMod(context);
    easyAdsMod.areAdsDisabled("admob");
    
    //or
    
    EasyAdsModListener easyAdsModListener = new EasyAdsModListener() {
            @Override
            public boolean onResult(boolean areAdsDisabled) {
                return ads = areAdsDisabled;
            }
        };
        EasyAdsModTask easyAdsModTask = new EasyAdsModTask(context, adCo, easyAdsModListener);
        easyAdsModTask.execute();

# EasyAppMod
get app info of any app!

    EasyAppMod easyAppMod = new EasyAppMod(context);
    //Returns boolean of the app is installed & enabled
    easyAppMod.ifAppIsInstalled("com.example.app");
    //returns app version; ex: "1.0.0"
    easyAppMod.appVersionName("com.example.app");
    //returns app version; ex: 1
    easyAppMod.appVersionCode("com.example.app");
    //returns your own app's package name; ex: "com.example.app"
    easyAppMod.appPackageName();
    
# EasyAudioMod
play audio files from assets, raws, or any directory on the device storage(this is normally is only used for notification sounds...but)
    
    String assets = "filename.mp3";    
    int raw = R.raw.filename;
    File file = new File("/sdcard/filename.mp3");
    boolean loop = false;
    
    EasyAudioModListener easyAudioModListener = new EasyAudioModListener() {
                @Override
                public void isPlaying(String name) {
                    
                }

                @Override
                public void isStopped() {

                }
            };
    
    EasyAudioMod easyAudioMod = new EasyAudioMod(context, easyAudioModListener);//listener can be null
    //optionally set looping
    //easyAudioMod.setLooping(loop);
    //play sounds
    easyAudioMod.playSound(assets);
    easyAudioMod.playSound(raw);
    easyAudioMod.playSound(file);
    //stop playing currently 
    easyAudioMod.stopSound();
    
# EasyDeviceMod
Hate remembering ABI's? so do I!
      
    String: 
    X86 returns "x86"
    ARM returns "armeabi-v7a"
    ARM64 returns "arm64-v8a"
    
    DEVICE_SDK_INT();//returns int
    DEVICE_BASE_OS();//TargetApi = 23; returns string
    DEVICE_SDK_DEP();//deprecation; returns string
    DEVICE_SUPPORTED_ABIS();//TargetApi = 21; returns string
    DEVICE_SUPPORTED_64_BIT_ABIS();//TargetApi = 21; returns string
    DEVICE_SUPPORTED_32_BIT_ABIS();//TargetApi = 21; returns string
    DEVICE_CPU_ABI2();//deprecation; returns string
    DEVICE_CPU_ABI();//deprecation; returns string
    DEVICE_MANUFACTURER();//returns string
    DEVICE_MODEL();//returns string
    DEVICE_BOARD();//returns string
    DEVICE_BOOTLOADER();//returns string
    DEVICE_BRAND();//returns string
    DEVICE_DEVICE();//returns string
    DEVICE_DISPLAY();//returns string
    DEVICE_FINGERPRINT();//returns string
    DEVICE_RADIOVERSION();//TargetApi = 14; returns string
    DEVICE_RADIO_DEP();//deprecation; returns string
    DEVICE_HARDWARE();//returns string
    DEVICE_HOST();//returns string
    DEVICE_ID();//returns string
    DEVICE_PRODUCT();//returns string
    DEVICE_TAGS();//returns string
    DEVICE_TYPE();//returns string
    DEVICE_USER();//returns string
    DEVICE_TIME();//returns string
    
# EasyDrawableMod
Get an app's drawable the easy way!
    
    Drawable fallbackdrawable = null;//if the app is NOT installed then use a backup drawable instead!
    EasyDrawableMod easyDrawableMod = new EasyDrawableMod(context);
    easyDrawableMod.getAppIcon("pkgID", fallbackdrawable);//returns drawable
    
# EasyFileMod
Do fileIO sh!t
 
    //Move file
    File input = new File("");
    File output = new File("");
    EasyFileMod.moveFile(input, output);
    
    //delete file
    EasyFileMod.deleteFiles("path");
    
    //create file; returns boolean
    EasyFileMod.CreateDirs();
        
# EasyLocaleMod
 Change your app's default language easily!
 
     EasyLocaleMod easyLocaleMod = new EasyLocaleMod(context);
     easyLocaleMod.getLanguageCode();//returns "en"
     easyLocaleMod.defaultLocale();
     easyLocaleMod.setLanguage("english");
     easyLocaleMod.getLanguage();
     easyLocaleMod.setLocale("en");

# EasyLogMod
Easily log your app's sh!t

    EasyLogMod.verbose("TAG", "verbose");
    EasyLogMod.debug("TAG", "debug");
    EasyLogMod.info("TAG", "info");
    EasyLogMod.warn("TAG", "warn");
    EasyLogMod.error("TAG", "error");
    
# EasyNetworkMod
Easily get network info in your app!(dont forget to add your internet permissions!)

    EasyNetworkMod easyNetworkMod = new EasyNetworkMod(context);
    easyNetworkMod.isWifiEnabled();//boolean to return if wifi is enabled....
    easyNetworkMod.isBluEnabled();//boolean to return if bluetooth is enabled....
    easyNetworkMod.isOnline();//boolean to return if connected to the internet....
    
# EasyParseMod
Easily parse your data....

    EasyParseMod.isEmpty(String string);//returns boolean
    EasyParseMod.intToString(int number);//returns string
    EasyParseMod.stringToInt(String string);//returns int
    EasyParseMod.longToString(Long long);//returns string
    EasyParseMod.stringToLong(String string);//returns long
    EasyParseMod.stringToFloat(String string);//returns float
    EasyParseMod.floatToString(Float flot);//returns string
    EasyParseMod.longToInt(Long long);//returns int
    EasyParseMod.intToLong(int log);//returns long
    EasyParseMod.containsDigit(String string);//returns boolean
    EasyParseMod.arrayToString(String[] array);//returns string
    EasyParseMod.lastIndexOf("string", "i");//returns substring
    EasyParseMod.lastIndexOf("string", 4);//returns substring
    EasyParseMod.fileToString(File file);//returns string
    EasyParseMod.getFileName(File file);//returns string
    EasyParseMod.LongSize(Long fileSize);//returns string
    EasyParseMod.getSize(File file);//returns string
    
# EasyPermissionMod
Easily check if permissions were granted(does not ask user!)

    EasyPermissionMod easyPermissionMod = new EasyPermissionMod(context);
    easyPermissionMod.hasPermission(String permission);
    
# EasyPrefsMod
Easily create & use the sharedpreference

    EasyPrefsMod easyPrefsMod = new EasyPrefsMod(context);
    //get values
    easyPrefsMod.getString(String key);//returns string
    easyPrefsMod.getString(String Prefs, int mode, String key);//returns string
    easyPrefsMod.getBoolean(String key);//returns boolean
    easyPrefsMod.getBoolean(String Prefs, int mode, String key);//returns boolean
    easyPrefsMod.getStringSet(String key);//returns Set<String>
    easyPrefsMod.getStringSet(String Prefs, int mode, String key);//returns Set<String>
    easyPrefsMod.getInt(String key);//returns int
    easyPrefsMod.getInt(String Prefs, int mode, String key);//returns int
    easyPrefsMod.getFloat(String key);//returns float
    easyPrefsMod.getFloat(String Prefs, int mode, String key);//returns float
    easyPrefsMod.getLong(String key);//returns long
    easyPrefsMod.getLong(String Prefs, int mode, String key);//returns long
    easyPrefsMod.getAll();//returns map<String,?>
    easyPrefsMod.getAll(String Prefs, int mode);//returns map<String,?>
    //put values
    easyPrefsMod.put(String key, String value);
    easyPrefsMod.put(String Prefs, int mode, String key, String value);
    easyPrefsMod.put(String key, boolean value);
    easyPrefsMod.put(String Prefs, int mode, String key, boolean value);
    easyPrefsMod.put(String key, Set<String> value);
    easyPrefsMod.put(String Prefs, int mode, String key, Set<String> value);
    easyPrefsMod.put(String key, int value);
    easyPrefsMod.put(String Prefs, int mode, String key, int value);
    easyPrefsMod.put(String key, float value);
    easyPrefsMod.put(String Prefs, int mode, String key, float value);
    easyPrefsMod.put(String key, long value);
    easyPrefsMod.put(String Prefs, int mode, String key, long value);
    easyPrefsMod.clearValue(String key);
    easyPrefsMod.clearValue(String Prefs, int mode, String key);
    easyPrefsMod.clearAll();
    easyPrefsMod.clearAll(String Prefs, int mode);
    
# EasySocialMod
Easily launch "any" social app with your profile, page, etc...

    PPCV = PAGE/PROFILE/COMMUNITY/VIDEO
    
    FACEBOOK_APP = "com.facebook.katana";
    GOOGLE_PLUS_APP = "com.google.android.apps.plus";
    TWITTER_APP = "com.twitter.android";
    YOUTUBE_APP = "com.google.android.youtube";
    
    SOCIAL_PAGE = "page";
    SOCIAL_PROFILE = "profile";
    SOCIAL_COMMUNITY = "community";
    SOCIAL_VIDEO = "video";
    
    EasySocialModListener easySocialModListener = new EasySocialModListener() {
            @Override
            public void onSuccess() {
                
            }

            @Override
            public void onFail(boolean isConnected, boolean isAppInstalled) {

            }
        };
    
    EasySocialMod easySocialMod = new EasySocialMod(context, easySocialModListener);//listener can bu null
    
    easySocialMod.openSocialApp(String appID, String PPCV, String uri);
    easySocialMod.openSocialApp(String appID, String uri);
    easySocialMod.rateApp();
    easySocialMod.rateApp(String appID);
    
#     

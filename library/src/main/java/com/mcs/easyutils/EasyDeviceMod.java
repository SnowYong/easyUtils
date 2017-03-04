package com.mcs.easyutils;

import android.annotation.TargetApi;
import android.os.Build;

import static com.mcs.easyutils.EasyParseMod.arrayToString;

@SuppressWarnings("unused")
public class EasyDeviceMod
{
    public final String X86 = "x86";
    public final String ARM = "armeabi-v7a";
    public final String ARM64 = "arm64-v8a";

    public static int DEVICE_SDK_INT() {
        return Build.VERSION.SDK_INT;
    }

    @TargetApi(23)
    public static String DEVICE_BASE_OS() {
        return Build.VERSION.BASE_OS;
    }

    @SuppressWarnings("deprecation")
    public static String DEVICE_SDK_DEP() {
        return Build.VERSION.SDK;
    }

    @TargetApi(21)
    public static String DEVICE_SUPPORTED_ABIS(){
        return arrayToString(Build.SUPPORTED_ABIS);
    }
    @TargetApi(21)
    public static String DEVICE_SUPPORTED_64_BIT_ABIS(){
        return arrayToString(Build.SUPPORTED_64_BIT_ABIS);
    }
    @TargetApi(21)
    public static String DEVICE_SUPPORTED_32_BIT_ABIS(){
        return arrayToString(Build.SUPPORTED_32_BIT_ABIS);
    }

    @SuppressWarnings("deprecation")
    public static String DEVICE_CPU_ABI2(){
        return Build.CPU_ABI2;
    }
    @SuppressWarnings("deprecation")
    public static String DEVICE_CPU_ABI(){
        return Build.CPU_ABI;
    }

    public static String DEVICE_MANUFACTURER() {
        return Build.MANUFACTURER;
    }

    public static String DEVICE_MODEL() {
        return Build.MODEL;
    }

    public static String DEVICE_BOARD(){
        return Build.BOARD;
    }

    public static String DEVICE_BOOTLOADER(){
        return Build.BOOTLOADER;
    }

    public static String DEVICE_BRAND(){
        return Build.BRAND;
    }

    public static String DEVICE_DEVICE(){
        return Build.DEVICE;
    }

    public static String DEVICE_DISPLAY(){
        return Build.DISPLAY;
    }

    public static String DEVICE_FINGERPRINT(){
        return Build.FINGERPRINT;
    }

    @TargetApi(14)
    public static String DEVICE_RADIOVERSION(){
        return Build.getRadioVersion();
    }

    @SuppressWarnings("deprecation")
    public static String DEVICE_RADIO_DEP(){
        return Build.RADIO;
    }

    public static String DEVICE_HARDWARE(){
        return Build.HARDWARE;
    }

    public static String DEVICE_HOST(){
        return Build.HOST;
    }

    public static String DEVICE_ID(){
        return Build.ID;
    }

    public static String DEVICE_PRODUCT(){
        return Build.PRODUCT;
    }

    public static String DEVICE_TAGS(){
        return Build.TAGS;
    }

    public static String DEVICE_TYPE(){
        return Build.TYPE;
    }

    public static String DEVICE_USER(){
        return Build.USER;
    }

    public static long DEVICE_TIME(){
        return Build.TIME;
    }
}
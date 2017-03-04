package com.mcs.easyutils;

import android.util.Log;

@SuppressWarnings("unused")
public class EasyLogMod
{
    private static String TAG = "EasyLogMod";

    public static void verbose(String tag, String text) {
        try {
            Log.v(tag, getFormattedLogLine() + text);
        }catch(OutOfMemoryError error) {
            error(TAG, "verbose OutOfMemoryError: " + error);
        }
    }

    public static void debug(String tag, String text) {
        try {
            Log.d(tag, getFormattedLogLine() + text);
        }catch(OutOfMemoryError error) {
            error(TAG, "debug OutOfMemoryError: " + error);
        }
    }

    public static void info(String tag, String text) {
        try {
            Log.i(tag, getFormattedLogLine() + text);
        }catch(OutOfMemoryError error) {
            error(TAG, "info OutOfMemoryError: " + error);
        }
    }

    public static void warn(String tag, String text) {
        try {
            Log.w(tag, getFormattedLogLine() + text);
        }catch(OutOfMemoryError error) {
            error(TAG, "warn OutOfMemoryError: " + error);
        }
    }

    public static void error(String tag, String text) {
        try {
            Log.e(tag, getFormattedLogLine() + text);
        }catch(OutOfMemoryError error) {
            error(TAG, "error OutOfMemoryError: " + error);
        }
    }

    private static String getFormattedLogLine () {
        String className = getCallerClassName (5);
        String methodName = getCallerMethodName (5);
        int lineNumber = getCallerLineNumber (5);
        return className + "." + methodName + "()" + lineNumber + ":";
    }

    private static String getCallerClassName(int stackTracePosition) {
        String fullClassName = Thread.currentThread().getStackTrace()[stackTracePosition].getClassName();
        return fullClassName.substring(fullClassName.lastIndexOf(".") +  1);
    }

    private static String getCallerMethodName(int stackTracePosition) {
        return Thread.currentThread().getStackTrace()[stackTracePosition].getMethodName();
    }

    private static int getCallerLineNumber(int stackTracePosition) {
        return Thread.currentThread().getStackTrace()[stackTracePosition].getLineNumber();
    }
}
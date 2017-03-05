package com.mcs.easyutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;

import static com.mcs.easyutils.EasyLogMod.error;
import static com.mcs.easyutils.EasyLogMod.warn;
import static java.lang.Long.parseLong;

@SuppressWarnings("unused")
public class EasyParseMod
{
    private static final String TAG = "EasyParseMod";
    private static final String EMPTY = "";
    private static final String NULL = "null";

    public static boolean isEmpty(String s) {
        return null == s || EMPTY.equals(s.trim());
    }

    public static String intToString(int number){
        return Integer.toString(number);
    }
    public static int stringToInt(String string){
        try{
            return Integer.parseInt(string);
        }catch (NumberFormatException e){
            warn(TAG, "could not parse value");
            return 0;
        }
    }

    public static String longToString(Long longNumber){
        return Long.toString(longNumber);
    }
    public static Long stringToLong(String string){
        try {
            return parseLong(string);
        }catch (NumberFormatException e){
            warn(TAG, "could not parse value");
            return null;
        }
    }

    public static String floatToString(Float floatValue){
        return Float.toString(floatValue);
    }
    public static Float stringToFloat(String string){
        try{
            return Float.parseFloat(string);
        }
        catch (NumberFormatException e){
            warn(TAG, "could not parse value");
            return null;
        }
    }

    //long
    public static int longToInt(long l) {
        int i = (int)l;
        if ((long)i != l) {
            throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
        }
        return i;
    }
    public static Long intToLong(int number){
        try {
            return parseLong(intToString(number));
        }catch (NumberFormatException e){
            warn(TAG, "could not parse value");
            return null;
        }
    }

    public static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    public static String arrayToString(String[] array){
        return Arrays.toString(array);
    }

    public static String lastIndexOf(String string, String indexOf){
        if (string != null && string.length() > 0 )
        {
            return string.substring(string.lastIndexOf(indexOf) + 1);
        }
        return NULL;
    }

    public static String lastIndexOf(String string, int indexOf){
        if (string != null && string.length() > 0 )
        {
            return string.substring(string.lastIndexOf(indexOf) + 1);
        }
        return NULL;
    }

    public static String fileToString(File file){
        StringBuilder Builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                Builder.append(line + '\n');
            }
            br.close();
        } catch (IOException e) {
            error(TAG, "Error: " + e);
            e.printStackTrace();
        }
        return Builder.toString();
    }

    public static String getFileName(File file){
        String path = file.getAbsolutePath();
        return path.substring(path.lastIndexOf("/") + 1);
    }


    private static long getFileFolderSize(File dir) {
        long size = 0;
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    size += file.length();
                } else
                    size += getFileFolderSize(file);
            }
        } else if (dir.isFile()) {
            size += dir.length();
        }
        return size;
    }
    public static String LongSize(long fileSize) {
        double sizeMB = (double) fileSize / 1024 / 1024;
        String s = " MB";
        if (sizeMB < 1) {
            sizeMB = (double) fileSize / 1024;
            s = " KB";
        }
        String datasize = NumberFormat.getInstance().format(sizeMB);
        String datasize2 = datasize.replaceAll("[^\\d.,]", "");
        if (datasize2.length() >= 4){
            datasize2 = datasize2.substring(0, 4) + "";
        }
        return datasize2 + s;
    }

    public static String getSize(File file){
        return LongSize(getFileFolderSize(file));
    }

}
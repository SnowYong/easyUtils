package com.mcs.easyutils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.File;

import static com.mcs.easyutils.EasyLogMod.warn;
import static com.mcs.easyutils.EasyParseMod.getFileName;
import static com.mcs.easyutils.EasyParseMod.lastIndexOf;

@SuppressWarnings("unused")
public class EasyAudioMod
{
    private static String TAG = "EasyAudioMod";

    private static MediaPlayer m = null;
    private final Context context;
    private EasyAudioModListener easyAudioModListener = null;
    private boolean setLoop = false;

    public EasyAudioMod(final Context context, EasyAudioModListener easyAudioModListener) {
        this.context = context;
        this.easyAudioModListener = easyAudioModListener;
    }

    public final void playSound(String assetName){
        try{
            //if sound is playing stop & release to to play a new sound file
            stopSound();
            //play new sound
            m = new MediaPlayer();
            AssetFileDescriptor afd = context.getAssets().openFd(assetName);
            m.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            m.prepare();
            m.setLooping(setLoop);
            m.start();
            listenerPlaying(assetName);
        }
        catch (Exception e){
            warn(TAG, "Exception: " + e);
        }
    }
    public final void playSound(int rawName){
        try{
            //if sound is playing stop & release to to play a new sound file
            stopSound();
            //play new sound
            m = new MediaPlayer();
            m = MediaPlayer.create(context, rawName);
            m.setLooping(setLoop);
            m.start();

            listenerPlaying(lastIndexOf(context.getResources().getResourceName(rawName),"/"));

        }
        catch (Exception e){
            warn(TAG, "Exception: " + e);
        }
    }
    public final void playSound(File fileName){
        try{
            stopSound();
            m = new MediaPlayer();

            Uri myUri = Uri.parse("file://" + fileName);
            m.setAudioStreamType(AudioManager.STREAM_MUSIC);

            m.setDataSource(context.getApplicationContext(), myUri);
            m.prepare();
            m.setLooping(setLoop);
            m.start();
            listenerPlaying(getFileName(fileName));

        }catch (Exception e){
            warn(TAG, "Exception: " + e);
        }
    }

    public final void stopSound(){
        //if sound is playing stop & release to to play a new sound file
        try {
            if (m != null) {
                if (m.isPlaying()) {
                    m.stop();
                    m.release();
                    listenerStop();
                }
            }
        }catch (Exception e){
            warn(TAG, e.toString());
        }
    }
    public final void setLooping(boolean setLooping){
        if(m != null){
            setLoop = setLooping;
            m.setLooping(setLoop);
        }
    }

    private void listenerStop(){
        try {
            if (easyAudioModListener != null) {
                easyAudioModListener.isStopped();
            }
        }catch (Exception e){
            warn(TAG, e.toString());
        }
    }
    private void listenerPlaying(String fileName) {
        try{
        if (easyAudioModListener != null){
            easyAudioModListener.isPlaying(fileName);
        }
        }catch (Exception e){
            warn(TAG, e.toString());
        }
    }
}
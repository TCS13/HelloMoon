package com.example.tcs.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by TCS on 2/5/15.
 */
public class VideoPlayer {
    private String TAG = "VideoPlayer";
    private MediaPlayer mPlayer;
    private SurfaceHolder mSurfaceHolder;

    public VideoPlayer(SurfaceHolder surfaceHolder)
    {
        mSurfaceHolder = surfaceHolder;
    }

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        Log.d(TAG, "Entered play");
            if (mPlayer == null) {
                Log.d(TAG, "mPlayer was null");
                stop();
                Log.d(TAG, "Stopped");
                Uri resourceUri = Uri.parse("android.resource://" + c.getPackageName() + "/raw/apollo_17_stroll");
//                Log.d(TAG, c.getPackageName());
//                Log.d(TAG, c.getPackageResourcePath());
//                ContentResolver cr = c.getContentResolver();
//                String[] projection = {MediaStore.MediaColumns.DATA};
//                Cursor cur = cr.query(resourceUri, projection, null, null, null);
//                if(cur != null)
//                {
//                    cur.moveToFirst();
//                    String filePath = cur.getString(0);
//                    if(new File(filePath).exists()){
//                        Log.d(TAG, "File exists");
//                    } else {
//                        Log.d(TAG, "File does not exist");
//                    }
//                } else {
//                    Log.d(TAG, "URI was invalid or other error occurred");
//                }
                //Log.d(TAG, resourceUri.getEncodedPath());
                //Log.d(TAG, resourceUri.getPath());
                //Log.d(TAG, resourceUri.toString());
                mPlayer = new MediaPlayer();
                mPlayer.setDisplay(mSurfaceHolder);
                //mPlayer = MediaPlayer.create(c, resourceUri, mSurfaceHolder);
                mPlayer = MediaPlayer.create(c, R.raw.apollo_17_stroll);
                //mPlayer = new MediaPlayer();
                Log.d(TAG, "mPlayer was created");
//                try {
//                    Log.d(TAG, "Entered try");
//                    mPlayer.setDataSource(c, resourceUri);
//                    mPlayer.prepare();
//                    Log.d(TAG, "No error in try");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "Error occurred: ");
//                    Log.d(TAG, e.getLocalizedMessage());
//                }
            }
//                Log.d(TAG, "mPlayer has a data source");
//                Canvas canvas = mSurfaceHolder.getSurface().lockCanvas(mSurfaceHolder.getSurfaceFrame());
//                mPlayer.setDisplay(mSurfaceHolder);
//                mSurfaceHolder.getSurface().unlockCanvasAndPost(canvas);
//                Log.d(TAG, "mPlayer display was set");
//                //mPlayer.setSurface(mSurfaceHolder.getSurface());
//                //Log.d(TAG, "mPlayer surface was set");
//                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    public void onCompletion(MediaPlayer mp) {
//                        stop();
//                    }
//                });
//                Log.d(TAG, "" + mPlayer.getVideoHeight());
//                Log.d(TAG, "mPlayer has a listener");
//            }
        mPlayer.start();
        Log.d(TAG, "Start called");
    }

    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }
}

package com.example.tcs.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by TCS on 2/5/15.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayAudioButton;
    private Button mPauseAudioButton;
    private Button mStopAudioButton;
    private Button mPlayVideoButton;
    private Button mPauseVideoButton;
    private Button mStopVideoButton;
    private AudioPlayer mAudioPlayer = new AudioPlayer();
    private VideoPlayer mVideoPlayer = new VideoPlayer(null);
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayAudioButton = (Button)v.findViewById(R.id.hellomoon_playAudioButton);
        mPlayAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAudioPlayer.play(getActivity());
            }
        });
        mPauseAudioButton = (Button)v.findViewById(R.id.hellomoon_pauseAudioButton);
        mPauseAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAudioPlayer.pause();
            }
        });
        mStopAudioButton = (Button)v.findViewById(R.id.hellomoon_stopAudioButton);
        mStopAudioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAudioPlayer.stop();
            }
        });

        //mSurfaceView = (SurfaceView)v.findViewById(R.id.hellomoon_surfaceView);
        //mSurfaceHolder = mSurfaceView.getHolder();
        //Canvas canvas = mSurfaceHolder.lockCanvas();
        //mVideoPlayer = new VideoPlayer(mSurfaceHolder);
        //mSurfaceView.draw(canvas);

        //mPlayVideoButton = (Button)v.findViewById(R.id.hellomoon_playVideoButton);
        //mPlayVideoButton.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {
        //        mVideoPlayer.play(getActivity());
        //    }
        //});
//        mPauseVideoButton = (Button)v.findViewById(R.id.hellomoon_pauseVideoButton);
//        mPauseVideoButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                mVideoPlayer.pause();
//            }
//        });
//        mStopVideoButton = (Button)v.findViewById(R.id.hellomoon_stopVideoButton);
//        mStopVideoButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                mVideoPlayer.stop();
//            }
//        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();
        mVideoPlayer.stop();
    }
}

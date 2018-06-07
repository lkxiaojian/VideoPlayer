package com.example.lk.testplayvideo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.lk.testplayvideo.bean.Video;
import com.lk.playvideolibrary.NiceVideoPlayer;
import com.lk.playvideolibrary.TxVideoPlayerController;



public class VideoViewHolder extends RecyclerView.ViewHolder {

    public TxVideoPlayerController mController;
    public NiceVideoPlayer mVideoPlayer;

    public VideoViewHolder(View itemView) {
        super(itemView);
        mVideoPlayer = (NiceVideoPlayer) itemView.findViewById(R.id.nice_video_player);
        // 将列表中的每个视频设置为默认16:9的比例
        ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
        params.width = itemView.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
        params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
        mVideoPlayer.setLayoutParams(params);
    }

    public void setController(TxVideoPlayerController controller) {
        mController = controller;
        mVideoPlayer.setController(mController);
    }

    public void bindData(Video video) {
        mController.setTitle(video.getTitle());
        mController.setLenght(video.getLength());
        Glide.with(itemView.getContext())
                .load(video.getImageUrl())
                .placeholder(R.drawable.videobag)
                .crossFade()
                .into(mController.imageView());
        mVideoPlayer.setUp(video.getVideoUrl(), null);
    }
}

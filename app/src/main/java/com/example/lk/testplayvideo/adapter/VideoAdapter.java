package com.example.lk.testplayvideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lk.testplayvideo.R;
import com.example.lk.testplayvideo.VideoViewHolder;
import com.example.lk.testplayvideo.bean.Video;
import com.lk.playvideolibrary.TxVideoPlayerController;

import java.util.List;

/**
 * Created by lk on 2018/6/7.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private Context mContext;
    private List<Video> data;

    public VideoAdapter(Context mContext, List data) {
        this.mContext = mContext;
        this.data = data;
    }



    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
        VideoViewHolder holder = new VideoViewHolder(itemView);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        holder.setController(controller);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        Video video = data.get(position);
        holder.bindData(video);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


}

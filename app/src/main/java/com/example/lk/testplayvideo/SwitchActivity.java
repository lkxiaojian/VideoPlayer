package com.example.lk.testplayvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.lk.playvideolibrary.Clarity;
import com.lk.playvideolibrary.NiceVideoPlayer;
import com.lk.playvideolibrary.NiceVideoPlayerManager;
import com.lk.playvideolibrary.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;

public class SwitchActivity extends AppCompatActivity {
    private NiceVideoPlayer niceVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        initView();
        initdata();
    }

    private void initdata() {

        niceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("Beautiful China...");
        controller.setLenght(117000);
        controller.setClarity(getClarites(), 0);
        Glide.with(this)
                .load("http://img.kaiyanapp.com/80b78dde7ca3964b4c3edb969f5b5e28.png?imageMogr2/quality/60/format/jpg")
                .placeholder(R.drawable.videobag)
                .crossFade()
                .into(controller.imageView());
        niceVideoPlayer.setController(controller);
    }

    public List<Clarity> getClarites() {
        List<Clarity> clarities = new ArrayList<>();
        clarities.add(new Clarity("标清","270dp","http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108016&resourceType=video&editionType=normal&source=qcloud"));
        clarities.add(new Clarity("高清","4800dp","http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108016&resourceType=video&editionType=high&source=aliyun"));

        return clarities;
    }

    private void initView() {
        niceVideoPlayer = findViewById(R.id.nice_video_player);
    }
    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}

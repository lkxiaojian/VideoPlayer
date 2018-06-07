package com.example.lk.testplayvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lk.playvideolibrary.NiceVideoPlayer;
import com.lk.playvideolibrary.NiceVideoPlayerManager;
import com.lk.playvideolibrary.TxVideoPlayerController;

public class SmallPlayerActivity extends AppCompatActivity implements View.OnClickListener, TxVideoPlayerController.OnShareClickListener {
    private Button bt_player;
    private NiceVideoPlayer mNiceVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_player);
        initview();
        initdata();
    }

    private void initdata() {
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        String videoUrl = "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108065&resourceType=video&editionType=default&source=aliyun";
        mNiceVideoPlayer.setUp(videoUrl, null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setShareClickListener(this);
        controller.setVisible(View.VISIBLE);
        controller.setTitle("哈哈，我是标题");
        controller.setLenght(98000);
        Glide.with(this)
                .load("http://img.kaiyanapp.com/1db100be73feffd81178b98fb124ed7d.jpeg?imageMogr2/quality/60/format/jpg")
                .placeholder(R.drawable.videobag)
                .crossFade()
                .into(controller.imageView());
        mNiceVideoPlayer.setController(controller);
    }

    private void initview() {
        bt_player = findViewById(R.id.bt_player);
        mNiceVideoPlayer = findViewById(R.id.nice_video_player);
        bt_player.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mNiceVideoPlayer.isIdle()) {
            Toast.makeText(this, "要点击播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        } else {
            mNiceVideoPlayer.enterTinyWindow();
        }

    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onShareClick() {
        Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
    }
}

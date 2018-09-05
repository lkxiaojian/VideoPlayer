# VideoPlayer
android 视频播放框架  支持小窗口  recycleview列表  缓存，全屏播放，切换清晰度等
## 一 引用


`  allprojects {

    repositories {
      ...
      maven { url 'https://jitpack.io'
      }
    }
}`

在你的moudle下得build.gradle引用

`dependencies {
implementation 'com.github.lkxiaojian:VideoPlayer:1.1.3'
}`

在对应的Activity视频界面的AndroidManifest.xml中添加

``android:configChanges="orientation|keyboardHidden|screenSize"``

`
如：      
  
     `  <activity
            android:name=".SmallPlayerActivity"
            android:configChanges="orientation|keyboardHidden|screenSize"
            android:screenOrientation="portrait" />``
## 二 使用
  
`  引用自定义布局</br>

       <com.lk.playvideolibrary.NiceVideoPlayer
        android:id="@+id/nice_video_player"
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:layout_marginBottom="8dp"
        android:layout_marginTop="16dp" />`
    ` 逻辑

        mNiceVideoPlayer.setUp(videoUrl, null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setShareClickListener(this);
        controller.setVisible(View.VISIBLE);
        controller.setTitle("哈哈，我是标题");
        controller.setLenght(98000);
        Glide.with(this)
                .load("封面图片地址")
                .placeholder(R.drawable.videobag)
                .crossFade()
                .into(controller.imageView());
        mNiceVideoPlayer.setController(controller);`
       按返回键的处理
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
    
    
        

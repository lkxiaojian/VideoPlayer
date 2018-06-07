# VideoPlayer
android 视频播放框架  支持小窗口  recycleview列表  缓存，全屏播放，切换清晰度等
## 一 引用

  allprojects {</br>
    repositories {</br>
      ...</br>
      maven { url 'https://jitpack.io'</br>
      }</br>
    }</br>
}</br>
</br>
在你的moudle下得build.gradle引用</br>
dependencies {</br>
implementation 'com.github.lkxiaojian:VideoPlayer:1.0'</br>
}</br>
在对应的Activity视频界面的AndroidManifest.xml中添加android:configChanges="orientation|keyboardHidden|screenSize"</br>
如：        <activity</br>
            android:name=".RecycleViewActivity"</br>
            android:configChanges="orientation|keyboardHidden|screenSize"</br>
            android:screenOrientation="portrait" /></br>
   ## 二 使用
  
  引用自定义布局</br>
      <com.lk.playvideolibrary.NiceVideoPlayer</br>
        android:id="@+id/nice_video_player"</br>
        android:layout_width="match_parent"</br>
        android:layout_height="180dp"</br>
        android:layout_marginBottom="8dp"</br>
        android:layout_marginTop="16dp" /></br>
     逻辑</br>
        mNiceVideoPlayer.setUp(videoUrl, null);</br>
        TxVideoPlayerController controller = new TxVideoPlayerController(this);</br>
        controller.setShareClickListener(this);</br>
        controller.setVisible(View.VISIBLE);</br>
        controller.setTitle("哈哈，我是标题");</br>
        controller.setLenght(98000);</br>
        Glide.with(this)</br>
                .load("封面图片地址")</br>
                .placeholder(R.drawable.videobag)</br>
                .crossFade()</br>
                .into(controller.imageView());</br>
        mNiceVideoPlayer.setController(controller);</br>
       按返回键的处理</br>
         @Override</br>
    public void onBackPressed() {</br>
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;</br>
        super.onBackPressed();</br>
    }</br>

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
    
        

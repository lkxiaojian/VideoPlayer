package com.example.lk.testplayvideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        Button bt_small_player = findViewById(R.id.bt_small_player);
        Button bt_recycle_player = findViewById(R.id.bt_recycle_player);
        Button bt_switch_player = findViewById(R.id.bt_switch_player);
        bt_small_player.setOnClickListener(this);
        bt_recycle_player.setOnClickListener(this);
        bt_switch_player.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_small_player:
                startActivity(SmallPlayerActivity.class);
                break;
            case R.id.bt_recycle_player:
                startActivity(RecycleViewActivity.class);
                break;
            case R.id.bt_switch_player:
                startActivity(SwitchActivity.class);
                break;
        }

    }

    private void startActivity(Class activity){
        Intent intent=new Intent(MainActivity.this,activity);
        startActivity(intent);
    }
}

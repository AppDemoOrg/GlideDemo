package com.abt.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.abt.glide.transform.GlideCircleTransform;
import com.abt.glide.transform.GlideRoundTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @描述： @MainActivity
 * @作者： @黄卫旗
 * @创建时间： @2018-04-25
 */
public class MainActivity extends AppCompatActivity {

    private RequestManager glideRequest;
    private String mURI = "https://www.baidu.com/img/bdlogo.png";

    @BindView(R.id.imageView) ImageView imageView;

    @OnClick(R.id.button1) void but1() {
        glideRequest.load(mURI).into(imageView);
    }

    @OnClick(R.id.button2) void but2() {
        glideRequest.load(mURI).transform(new GlideRoundTransform(this)).into(imageView);
    }

    @OnClick(R.id.button3) void but3() {
        glideRequest.load(mURI).transform(new GlideRoundTransform(this, 10)).into(imageView);
    }

    @OnClick(R.id.button4) void but4() {
        glideRequest.load(mURI).transform(new GlideCircleTransform(this)).into(imageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        glideRequest = Glide.with(this);
    }

}

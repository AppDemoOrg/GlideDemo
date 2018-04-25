package com.abt.glide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * @描述：      @MainActivity
 * @作者：      @黄卫旗
 * @创建时间：  @2018-04-25
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {

    private ImageView imageView;
    private RequestManager glideRequest;
    private Context context = this;
    private String mURI = "https://www.baidu.com/img/bdlogo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        glideRequest = Glide.with(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                glideRequest.load(mURI).into(imageView);
                break;
            case R.id.button2:
                glideRequest.load(mURI).transform(new GlideRoundTransform(context)).into(imageView);
                break;
            case R.id.button3:
                glideRequest.load(mURI).transform(new GlideRoundTransform(context, 10)).into(imageView);
                break;
            case R.id.button4:
                glideRequest.load(mURI).transform(new GlideCircleTransform(context)).into(imageView);
                break;
        }
    }
}

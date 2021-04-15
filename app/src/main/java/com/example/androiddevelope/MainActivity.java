package com.example.androiddevelope;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button property_btn, animation_btn;
    private ImageView animationl_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        property_btn = findViewById(R.id.property_btn);
        animation_btn = findViewById(R.id.animation_btn);
        animationl_iv = findViewById(R.id.animationl_iv);
        property_btn.setOnClickListener(this);
        animation_btn.setOnClickListener(this);
        animationl_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.property_btn:
                //属性动画 TODO 未成功运行
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_animator);
                set.setTarget(property_btn);
                set.start();
                break;
            case R.id.animation_btn:
                //补间动画
                Animation hyperspaceJump = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hyperspace_jump);
                animation_btn.startAnimation(hyperspaceJump);
                break;
            case R.id.animationl_iv:
                animationl_iv.setBackgroundResource(R.drawable.cat_animation);
                Drawable catAnimation = animationl_iv.getBackground();
                if (catAnimation instanceof Animatable) {
                    ((Animatable) catAnimation).start();
                }
                break;
            default:
                break;
        }
    }
}
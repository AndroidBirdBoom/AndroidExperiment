package com.example.androiddevelope;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button property_btn, animation_btn;
    private ImageView animationl_iv, clip_iv;
    private ImageButton transition_ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        property_btn = findViewById(R.id.property_btn);
        animation_btn = findViewById(R.id.animation_btn);
        animationl_iv = findViewById(R.id.animationl_iv);
        transition_ib = findViewById(R.id.transition_btn);
        clip_iv = findViewById(R.id.clip_iv);
        property_btn.setOnClickListener(this);
        animation_btn.setOnClickListener(this);
        animationl_iv.setOnClickListener(this);
        transition_ib.setOnClickListener(this);
        clip_iv.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    //在menu中定义的onCLick方法要实现，不然会报错
    public void onGroupItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.group_item1:
                Toast.makeText(MainActivity.this, "group_item1", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void onItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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
            case R.id.transition_btn:
                Drawable drawable = transition_ib.getDrawable();
                if (drawable instanceof TransitionDrawable) {
                    ((TransitionDrawable) drawable).startTransition(500);
                }
                break;
            case R.id.clip_iv:
                Drawable drawable1 = clip_iv.getBackground();
                if (drawable1 instanceof ClipDrawable) {
                    drawable1.setLevel(drawable1.getLevel() + 1000);
                } else {
                    Toast.makeText(MainActivity.this, "clip error!", Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }
}
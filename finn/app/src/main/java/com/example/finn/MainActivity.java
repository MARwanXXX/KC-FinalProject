package com.example.finn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.finn.Fragments.Add;
import com.example.finn.Fragments.Expo;
import com.example.finn.Fragments.Fav;
import com.example.finn.Fragments.Home;
import com.example.finn.Fragments.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        imageView.setAlpha(0f);
        imageView.setVisibility(View.VISIBLE);
        imageView.animate()
                .alpha(1f)
                .setDuration(1500)
                .setListener(null);

        textView.setAlpha(0f);
        textView.setVisibility(View.VISIBLE);
        textView.animate()
                .alpha(1f)
                .setDuration(3000)
                .setListener(null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent( MainActivity.this,MainActivity2.class));
                finish();
            }
        },3500);

    }

}
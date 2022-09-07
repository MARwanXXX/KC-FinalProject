package com.example.finn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.finn.Fragments.Add;
import com.example.finn.Fragments.Expo;
import com.example.finn.Fragments.Fav;
import com.example.finn.Fragments.Home;
import com.example.finn.Fragments.User;

public class MainActivity2 extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNav);
        FrameLayout vp = findViewById(R.id.vp);
        ToggleButton dark = findViewById(R.id.dark);
        TextView textView = findViewById(R.id.textView2);

        dark.setText(null);
        dark.setTextOn(null);
        dark.setTextOff(null);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_compass));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_heart));
        // bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_user));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                //initialize fragment according to its id

                if (item.getId() == 5) {
                    fragment = new User();
                    textView.setText("المستخدم");

                }else if (item.getId() == 4) {
                    fragment = new Fav();
                    textView.setText("المفضلة");

                } else if (item.getId() == 3) {
                    fragment = new Add();
                    textView.setText("اضافة القتراح");

                } else if (item.getId() == 2) {
                    fragment = new Expo();
                    textView.setText("اكتشف");

                } else if (item.getId() == 1){
                    fragment = new Home();
                    textView.setText("الصفحة الرئيسية");
                }

                loadFragment(fragment);
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

                if (item.getId() == 5) {
                    fragment = new User();
                    textView.setText("المستخدم");

                }else if (item.getId() == 4) {
                    fragment = new Fav();
                    textView.setText("المفضلة");

                } else if (item.getId() == 3) {
                    fragment = new Add();
                    textView.setText("اضافة القتراح");

                } else if (item.getId() == 2) {
                    fragment = new Expo();
                    textView.setText("اكتشف");

                } else if (item.getId() == 1){
                    fragment = new Home();
                    textView.setText("الصفحة الرئيسية");
                }

                loadFragment(fragment);
            }
        });


        bottomNavigation.show(1, true);


        dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    bottomNavigation.setBackgroundBottomColor(Integer.parseInt("000000"));

                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.vp, fragment, null)
                .commit();
    }

}
package com.example.finn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity2 extends AppCompatActivity {

    TextView name, place, des;
    ImageView img;
    Button link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        Bundle bundle =getIntent().getExtras();
        FavItem item = (FavItem) bundle.getSerializable("fav");


        name = findViewById(R.id.name);
        place = findViewById(R.id.place);

        des = findViewById(R.id.des);
        img = findViewById(R.id.item_image);
        link = findViewById(R.id.loca);

        name.setText(item.getItem_title());
        place.setText(item.getItem_place());
        des.setText(item.getItem_des());
        img.setImageResource(item.getItem_image());

        des.setMovementMethod(new ScrollingMovementMethod());

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goLink(item.getItem_link());

            }
        });


    }

    private void goLink(String s){

        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
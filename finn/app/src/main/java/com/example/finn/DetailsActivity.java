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

public class DetailsActivity extends AppCompatActivity {

    TextView name, place, des;
    ImageView img;
    Button link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle =getIntent().getExtras();
        PlaceItem item = (PlaceItem) bundle.getSerializable("product");

        name = findViewById(R.id.name);
        place = findViewById(R.id.place);
        des = findViewById(R.id.des);
        img = findViewById(R.id.item_image);
        link = findViewById(R.id.loca);

        name.setText(item.getTitle());
        place.setText(item.getPlace());
        des.setText(item.getDes());
        img.setImageResource(item.getImageRes());

        des.setMovementMethod(new ScrollingMovementMethod());

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goLink(item.getLink());

            }
        });


    }

    private void goLink(String s){

        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
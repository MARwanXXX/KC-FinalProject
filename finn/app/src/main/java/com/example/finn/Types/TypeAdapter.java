package com.example.finn.Types;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finn.R;

import java.util.List;

public class TypeAdapter  extends ArrayAdapter {

    List<Types> typeList;

    public TypeAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        typeList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(R.layout.type_row, parent, false);




        Types currentItem = typeList.get(position);

        TextView itemNameTxt = view.findViewById(R.id.typeName);
        ImageView itemImage = view.findViewById(R.id.typeImage);

        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.animate()
                .alpha(1f)
                .setDuration(800)
                .setListener(null);

        itemNameTxt.setText(currentItem.getTypeName());
        itemImage.setImageResource(currentItem.getTypeImg());
        //view.setAnimation(animation);



        return view;
    }
}

package com.example.finn.Fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finn.FavAdapter;
import com.example.finn.FavDB;
import com.example.finn.FavItem;
import com.example.finn.R;

import java.util.ArrayList;
import java.util.List;


public class Fav extends Fragment {

    private RecyclerView recyclerView;
    private FavDB favDB;
    private List<FavItem> favItemList = new ArrayList<>();
    private FavAdapter favAdapter;


    public Fav() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);

        favDB = new FavDB(getActivity());
        recyclerView= view.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView); // set swipe to recyclerview

        loadData();

        return view;
    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.select_all_favorite_list();
        try {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
                String id = cursor.getString(cursor.getColumnIndex(FavDB.KEY_ID));
                String place = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_PLACE));
                String link = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_LINK));
                String des = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_DES));
                int image = Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE)));

                FavItem favItem = new FavItem(title, place, link, des, id, image);
                favItemList.add(favItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        favAdapter = new FavAdapter(getActivity(), favItemList);
        recyclerView.setAdapter(favAdapter);
    }

    // remove item after swipe
    private ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition(); // get position which is swipe
            final FavItem favItem = favItemList.get(position);
            if (direction == ItemTouchHelper.LEFT) { //if swipe left
                favAdapter.notifyItemRemoved(position); // item removed from recyclerview
                favItemList.remove(position); //then remove item
                favDB.remove_fav(favItem.getKey_id()); // remove item from database
            }
        }
    };
}
package com.example.finn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;

import com.example.finn.PlaceItem;
import com.example.finn.FavDB;
import com.example.finn.R;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{

    public ArrayList<PlaceItem> placeItems;
    private Context context;
    private FavDB favDB;

    public void setFilter (ArrayList<PlaceItem> newList) {
        placeItems.clear();
        placeItems.addAll(newList);
        notifyDataSetChanged();
    }


    public PlaceAdapter(ArrayList<PlaceItem> placeItems, Context context) {
        this.placeItems = placeItems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);
        // create table on first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if(firstStart) {
            createTableOnFirstStart();
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place,
                parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final PlaceItem placeItem = placeItems.get(position);

        readCursorData(placeItem, holder);
        holder.imageView.setImageResource(placeItem.getImageRes());
        holder.titleTextView.setText(placeItem.getTitle());
        holder.placeTextView.setText(placeItem.getPlace());
        holder.desTextView.setText(placeItem.getDes());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,DetailsActivity.class);
                i.putExtra("product",placeItems.get(position));
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return placeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, favBtn;
        TextView titleTextView, placeTextView, desTextView, likeCountTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView. findViewById(R.id.itemImage);
            titleTextView= itemView.findViewById(R.id.itemName);
            placeTextView= itemView.findViewById(R.id.itemPlace);
            desTextView= itemView.findViewById(R.id.itemDes);
            favBtn = itemView. findViewById(R.id.favBTN);
            likeCountTextView = itemView.findViewById(R.id.likeCountTextView);

            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    PlaceItem placeItem = placeItems.get(position);

                    likeClick(placeItem, favBtn, likeCountTextView);


                }
            });
        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();
        SharedPreferences prefs = context.getSharedPreferences( "prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(PlaceItem placeItem, ViewHolder viewHolder) {

        Cursor cursor= favDB. read_all_data(placeItem.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try{
            while (cursor.moveToNext()){
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                placeItem.setFavStatus(item_fav_status);

                // check fav status
                if(item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.favBtn.setImageResource(R.drawable.ic_heart);
                }else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.favBtn.setImageResource(R.drawable.ic_empty_heart);
                }
            }
        }finally{
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }

    // like click
    private void likeClick (PlaceItem placeItem, ImageView favBtn, final TextView textLike) {
        DatabaseReference refLike = FirebaseDatabase.getInstance().getReference().child("likes");
        final DatabaseReference upVotesRefLike = refLike.child(placeItem.getKey_id());

        if (placeItem.getFavStatus().equals("0")) {

            placeItem.setFavStatus("1");
            favDB.insertIntoTheDatabase(placeItem.getTitle(), placeItem.getImageRes(),
                    placeItem.getPlace(), placeItem.getLink(), placeItem.getDes(), placeItem.getKey_id(), placeItem.getFavStatus());
            favBtn.setImageResource(R.drawable.ic_heart);
            favBtn.setSelected(true);

            upVotesRefLike.runTransaction(new Transaction.Handler() {
                @NonNull
                @Override
                public Transaction.Result doTransaction(@NonNull final MutableData mutableData) {
                    try {
                        Integer currentValue = mutableData.getValue(Integer.class);
                        if (currentValue == null) {
                            mutableData.setValue(1);
                        } else {
                            mutableData.setValue(currentValue + 1);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    textLike.setText(mutableData.getValue().toString());
                                }
                            });
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    return Transaction.success(mutableData);
                }

                @Override
                public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                    System.out.println("Transaction completed");
                }
            });



        } else if (placeItem.getFavStatus().equals("1")) {
            placeItem.setFavStatus("0");
            favDB.remove_fav(placeItem.getKey_id());
            favBtn.setImageResource(R.drawable.ic_empty_heart);
            favBtn.setSelected(false);

            upVotesRefLike.runTransaction(new Transaction.Handler() {
                @NonNull
                @Override
                public Transaction.Result doTransaction(@NonNull final MutableData mutableData) {
                    try {
                        Integer currentValue = mutableData.getValue(Integer.class);
                        if (currentValue == null) {
                            mutableData.setValue(1);
                        } else {
                            mutableData.setValue(currentValue - 1);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    textLike.setText(mutableData.getValue().toString());
                                }
                            });
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    return Transaction.success(mutableData);
                }

                @Override
                public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                    System.out.println("Transaction completed");
                }
            });
        }









    }
}

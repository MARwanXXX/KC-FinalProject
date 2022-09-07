package com.example.finn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder>{

    private Context context;
    private List<FavItem> favItemList;
    private FavDB favDB;
    private DatabaseReference refLike;

    public FavAdapter(Context context, List<FavItem> favItemList) {
        this.context = context;
        this.favItemList = favItemList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()). inflate(R.layout.fav_place,
                parent, false);
        favDB = new FavDB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.favNameTextView.setText(favItemList.get(position).getItem_title());
        holder.favImageView.setImageResource(favItemList.get(position).getItem_image());
        holder.favPlaceTextView.setText(favItemList.get(position).getItem_place());
        holder.favDesTextView.setText(favItemList.get(position).getItem_des());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,DetailsActivity2.class);
                i.putExtra("fav",favItemList.get(position));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView favNameTextView, favPlaceTextView, favDesTextView;
        ImageView favImageView, favBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            favNameTextView = itemView.findViewById(R.id.favItemName);
            favPlaceTextView= itemView.findViewById(R.id.favItemPlace);
            favDesTextView= itemView.findViewById(R.id.favItemDes);
            favImageView = itemView. findViewById(R.id.favItemImage);
            favBtn = itemView. findViewById(R.id.favBTN);

            refLike = FirebaseDatabase.getInstance().getReference().child("likes");

            // remove from fav after click
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final FavItem favItem = favItemList.get(position);
                    final DatabaseReference upVotesRefLike = refLike.child(favItemList.get(position).getKey_id());
                    favDB.remove_fav(favItem.getKey_id());
                    removeItem(position);

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
            });
        }
    }

    private void removeItem(int position) {
        favItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, favItemList.size());
    }
}

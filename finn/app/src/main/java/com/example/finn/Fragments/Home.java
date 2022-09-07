package com.example.finn.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finn.R;
import com.example.finn.Types.Family;
import com.example.finn.Types.Indoor;
import com.example.finn.Types.Kids;
import com.example.finn.Types.Sug;
import com.example.finn.Types.Teens;
import com.example.finn.Types.TypeAdapter;
import com.example.finn.Types.Types;

import java.util.ArrayList;


public class Home extends Fragment {

    private final ArrayList<Types> types = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView listView = view.findViewById(R.id.listView);

        Types type = new Types("عائلات", R.drawable.family);
        Types type1 = new Types("شباب", R.drawable.teen);
        Types type2 = new Types("أطفال", R.drawable.children);
        Types type3 = new Types("فعاليات داخلية", R.drawable.indoor);
        Types type4 = new Types("اقتراحات المستخدمين", R.drawable.users);


        types.add(type);
        types.add(type1);
        types.add(type2);
        types.add(type3);
        types.add(type4);


        TypeAdapter typeAdapter = new TypeAdapter(getContext(), 0, types);

        listView.setAdapter(typeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;

                if (types.get(position) == type){
                    fragment = new Family();

                } else if (types.get(position) == type1){
                    fragment = new Teens();

                } else if (types.get(position) == type2){
                fragment = new Kids();

                } else if (types.get(position) == type3){
                    fragment = new Indoor();

                } else if (types.get(position) == type4){
                    fragment = new Sug();

                }

                loadFragment(fragment);

            }
        });

        return view;


    }

    private void loadFragment(Fragment fragment) {

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.vp, fragment, null)
                .commit();
    }
}
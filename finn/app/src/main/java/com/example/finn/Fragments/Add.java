package com.example.finn.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finn.PlaceItem;
import com.example.finn.R;
import com.example.finn.Types.Sug;


public class Add extends Fragment {

    EditText name, des, place, link;
    ImageView addImg;
    Button done;

    int SELECT_PICTURE = 200;
    int id = 30;
    Uri uri1;

    ActivityResultLauncher<String> galleryLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add, container, false);

        name = view.findViewById(R.id.nameEditText);
        des = view.findViewById(R.id.desEditText);
        place = view.findViewById(R.id.placeEditText);
        link = view.findViewById(R.id.linkEditText);
        addImg = view.findViewById(R.id.addImage);
        done = view.findViewById(R.id.done);

        name.clearFocus();
        place.clearFocus();
        link.clearFocus();
        des.clearFocus();

        des.setMovementMethod(new ScrollingMovementMethod());

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {

                addImg.setImageURI(uri);
                uri1=uri;

            }

        });

        addImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryLauncher.launch("image/*");
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id++;

                if (name.getText().toString().isEmpty() || des.getText().toString().isEmpty()
                        || place.getText().toString().isEmpty() || link.getText().toString().isEmpty()) {


                    if (name.getText().toString().isEmpty()) {
                        name.setError("أدخل الإسم!");
                    }

                    if (des.getText().toString().isEmpty()) {
                        des.setError("أضف الوصف");
                    }

                    if (place.getText().toString().isEmpty()) {
                        place.setError("أدخل الموقع!");
                    }

                    if (link.getText().toString().isEmpty()) {
                        link.setError("أدخل رابط الموقع");
                    }



                }
                    else {



                        final PlaceItem newItem = new PlaceItem(R.drawable.farwaniya, name.getText().toString(),
                                String.valueOf(id), "0", place.getText().toString(), link.getText().toString(), des.getText().toString());


                        Bundle bundle = new Bundle();
                        bundle.putSerializable("newItem", (PlaceItem) newItem);

//                        bundle.putString("uri",uri1);
//                        bundle.putString("name",name.getText().toString());
//                        bundle.putString("place",place.getText().toString());
//                        bundle.putString("link",link.getText().toString());
//                        bundle.putString("des",des.getText().toString());
//                        bundle.putString("id",String.valueOf(id));



                        Sug fragment = new Sug();
                        User fragment2 = new User();

                        fragment.setArguments (bundle);
                        fragment2.setArguments (bundle);
                        assert getFragmentManager() != null;
                        getFragmentManager() .beginTransaction() .replace(R.id.vp, fragment) .commit() ;

                        Toast.makeText(getContext(), "تمت اضافة الاقراح!", Toast.LENGTH_SHORT).show();




                   }


               // }
            }
        });



        return view;
    }

//    void imageChooser() {
//
//        // create an instance of the
//        // intent of the type image
//        Intent i = new Intent();
//        i.setType("image/*");
//        i.setAction(Intent.ACTION_GET_CONTENT);
//
//        // pass the constant to compare it
//        // with the returned requestCode
//        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
//    }
//
//    // this function is triggered when user
//    // selects the image from the imageChooser
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK) {
//
//            // compare the resultCode with the
//            // SELECT_PICTURE constant
//            if (requestCode == SELECT_PICTURE) {
//                // Get the url of the image from data
//                Uri selectedImageUri = data.getData();
//                if (null != selectedImageUri) {
//                    // update the preview image in the layout
//                    addImg.setImageURI(selectedImageUri);
//                }
//            }
//        }
//    }


}
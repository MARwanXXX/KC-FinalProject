package com.example.finn.Types;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.finn.PlaceAdapter;
import com.example.finn.PlaceItem;
import com.example.finn.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sug#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sug extends Fragment {

    private final ArrayList<PlaceItem> placeItems = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sug() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sug.
     */
    // TODO: Rename and change types and number of parameters
    public static Sug newInstance(String param1, String param2) {
        Sug fragment = new Sug();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sug, container, false);


        Bundle bundle = this.getArguments();





        placeItems.add(new PlaceItem(R.drawable.tech,
                "تك زون", "25", "0",
                "الري",
                "https://g.page/tekzoneme?share",
                "تستطيع الاستمتاع بالعديد من الأنشطة المميزة في ملاهي تك زون، فهي تُعتبر افضل مدينة العاب في الكويت ومن أكثرها جذباً حيث يعثُر مُرتادوها على باقة مُتنوّعة من الألعاب الكهربائية، فيما يُمضي فيها الأطفال أوقاتاً مُسليّة مستمتعين بالألعاب التي خُصصت لهم ولهذا فإن هذه الملاهي تُعد مكان مثالي للجميع لما توفره من أنشطة متنوّعة تُمتع كل الزوّار من مختلف الفئات العُمرية.\n" +
                "\n" +
                "احرص خلال زيارتك لهذه الملاهي على أن تقوم بجولة مميزة في افنيوز مول حيث توجد هذه الملاهي بداخله ."));

        placeItems.add(new PlaceItem(R.drawable.magic,
                "كويت ماجك", "26", "0",
                "المنقف",
                "https://goo.gl/maps/hJeevmTNkLhbmMSs5",
                "مكان مفتوح بجانب. مجمع كويت ماجيك يوجد الكثير من الألعاب للكبار خطره وسريعه ويوجد أيضا الألعاب للصغار قريبه من بعضها. وكما يؤجر صالات. مغلقه تحتوي على الكثر من ألعاب للصغار من عمر سنه الي ٤ سنوات. وصاله أخرى فيها ألعاب للكبار ليست خطيرة ولكنها مسليه."));

        placeItems.add(new PlaceItem(R.drawable.sky,
                "Sky Zone", "27", "0",
                "مدينة الكويت",
                "https://goo.gl/maps/U9xxHkccZTg1gPFTA",
                "متنزه سكاي زون ترامبولين SkyZone Trampoline Park من اهم اماكن السياحة في الكويت فهو أول مدينة ترفيهية مغلقة تضم العديد من الأنشطة البدنية في الكويت\n" +
                        "\n" +
                        "وقد تم افتتاح المتنزه في عام 2015م، ويتضمن عدة ملاعب للقفز، وكرة السلة، وحلبات مصارعة، والتسلق، وغيرها من الأنشطة الرياضية.\n" +
                        "\n" +
                        "ويقع المتنزه في منطقة الرابية من مدينة الكويت وتم تخصيص عدة أجزاء منه تتناسب مع الأطفال من عمر 3 سنوات.\n" +
                        "\n" +
                        "كما يتضمن متنزه سكاي زون ترامبولين حديقة تزلج، وألعاب القفز والهبوط المتطرفة، وحفرة الرغوة، والطوق والكرة، والعديد من أنواع السباقات."));


        if (bundle != null){
            Serializable newItem = bundle.getSerializable("newItem");
            placeItems.add((PlaceItem) newItem);
        }

        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PlaceAdapter(placeItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return v;
    }
}
package com.example.finn.Types;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finn.PlaceAdapter;
import com.example.finn.PlaceItem;
import com.example.finn.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Indoor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Indoor extends Fragment {

    private final ArrayList<PlaceItem> placeItems = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Indoor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Indoor.
     */
    // TODO: Rename and change types and number of parameters
    public static Indoor newInstance(String param1, String param2) {
        Indoor fragment = new Indoor();
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
        View v = inflater.inflate(R.layout.fragment_indoor, container, false);



        placeItems.add(new PlaceItem(R.drawable.chair,
                "الكراسي الموسيقية", "24", "0",
                "اي مكان",
                "https://translate.google.com/?sl=ar&tl=en&text=%D9%81%D9%8A%20%D8%A7%D9%84%D8%AD%D9%88%D8%B4%20%F0%9F%98%81&op=translate",
                "هذه اللعبة تناسب الأطفال والصغار أيضا وبها الكثير من المتعة، والكثير من النوستالجيا أيضا. فقد كانت لعبتنا المُفضلة قديما. فكرة اللعبة هى وضع مجموعة من الكراسي في شكل دائري، بحيث يكون عدد الكراسي أقل من عدد الأفراد. وتبدأ الموسيقى ويبدأ الأشخاص والأطفال في الدوران سريعا حول الكراسي وعندما تتوقف الموسيقى يجب أن يجلس كل طفل أو شخص على كرسي، ومن يتبقى ولم يجد كرسي ليجلس عليه يخسر. ويُعاد الأمر مرة أخرى وفي كل مرة يتم خروج شخص من اللعبة والاستغناء عن كرسي."));

        placeItems.add(new PlaceItem(R.drawable.maze,
                "لعبة المتاهة", "18", "0",
                "اي مكان",
                "https://toytheater.com/maze/",
                "لعبة مسلسة لقداء وقت ممتع!"));

        placeItems.add(new PlaceItem(R.drawable.chart,
                "Stop Complete", "19", "0",
                "اي مكان",
                "https://translate.google.com/?sl=ar&tl=en&text=%D8%A7%D9%8A%20%D9%88%D8%B1%D9%82%D8%A9%20%D9%88%D9%82%D9%84%D9%85%20%D9%85%D9%86%20%D8%B9%D9%86%D8%AF%D9%83%20%F0%9F%98%84&op=translate",
                "هل تعرفين هذه اللعبة؟ إنها لعبة أوتوبيس كومبليت الشهيرة التي كنا دائما نلعبها ونحن صغار. ومن الواضح أننا لم نعي اسمها جيدا فالجملة بالإنجليزي تقول Stop, It's Complete أو توقف فقد انتهيت. وهذا الاسم هو الفكرة الرئيسية للعبة، فكل لاعب يحتاج لورقة وقلم ويقوم برسم جدول به عدة خانات، ويكتب البيانات التالية، اسم ولد واسم بنت وجماد وحيوان وبلد وأكلة ومشهور. وتختار المجموعة حرف ليقوم الجميع بملىء كل هذه البيانات بكلمات تبدأ بهذا الحرف. ومن ينتهي أولا يقول Stop, It's Complete. ويتم حساب النقاط كالآتي، الاسم الفريد لأي بيان يأخذ 10 والمتكرر 5 والفارغ صفر، ثُم يتم جمع النقاط في كل مرة لكل لاعب وهكذا."));





        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PlaceAdapter(placeItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return v;
    }
}
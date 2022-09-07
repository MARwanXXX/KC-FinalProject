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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Kids#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Kids extends Fragment {

    private final ArrayList<PlaceItem> placeItems = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Kids() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Kids.
     */
    // TODO: Rename and change types and number of parameters
    public static Kids newInstance(String param1, String param2) {
        Kids fragment = new Kids();
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
        View v = inflater.inflate(R.layout.fragment_kids, container, false);

        placeItems.add(new PlaceItem(R.drawable.kigs,
                "كيدزانيا", "12", "0",
                "الري",
                "https://g.page/KidZaniaKuwait?share",
                "مركزا ترفيهيا يقوم بتوفير بيئة تعليمية واقعية آمنة وفريدة تسمح للأطفال التي تتراوح أعمارهم ما بين 4 إلى 14 عام أن يفعلوا ما يتوارد إلى ذهنهم بالفطرة تمثيل أدوار حياتية من خلال محاكاة الأنشطة المعتادة للبالغين كما هو الحال في العالم الواقعي، يقوم الأطفال بتأدية أعمال مهنية التي تعجبهم أو التي يطمحون في أن يعملوها في المستقبل ويتم الدفع مقابل عملهم كرجل إطفاء حريق، طبيب، ضابط شرطة، صحفي، تاجر.\n" +
                "\n" +
                "طريقة عمل كيدزانيا\n" +
                "تعد كيدزانيا مدينة متكاملة للأطفال حيث تحتوي على المباني والشوارع، والمحال وأنظمة الانتقال التي تستوعب 60 نشاط ووظيفة. هذا وتضم كيدزانيا أكثر المباني شهرة في أي مدينة، هذا بالإضافة إلى اقتصادها المميز المعتمد على الكيدزوس وهو عملة متعاقد عليها في كيدزانيا أي يمكن لأي طفل استخدامها في شراء أي شيء يريده بمجرد وصول الطفل إلى كيدزانيا، يتسلم شيك بقيمة 50 كيدزوس يتم صرفه حينها في بنك كيدزانيا ليتمكن الأطفال من شراء منتجات وخدمات كيدزانيا هذا وتستضيف المدينة عدد من المرافق المهنية مثل محطة الإذاعة، والمستشفى، وأجهزة محاكاة الطيران، وخدمات البريد السريع التي «يعمل» الأطفال بها، ويحصلون على راتبهم بعملة الكيدزوس بعد انتهاء النشاط"));

        placeItems.add(new PlaceItem(R.drawable.acu,
                "الأكواريوم", "13", "0",
                "السالمية",
                "https://goo.gl/maps/RGAidfwJRx3arY2x6",
                "هو جزء من المركز العلمي الكويت، ويقع في منطقة السالمية بالكويت، وتم افتتاحه من قبل الشيخ جابر الأحمد الصباح في 17 أبريل سنة 2000، يأخذك اكواريوم الكويت عبر ثلاث بيئات فريدة في شبه الجزيرة العربية: البحر والساحل والصحراء، كل واحدة منها مليئة بأنواع مختلفة من الحيوانات المحلية والنباتات والحياة البحرية التي يمكنك رؤيتها أثناء القيام بجولة، كما يحتوي على مجموعة من أحواض السمك ويبلغ سعة الحوض الرئيسي 1.5 مليون لتر ماء، تحتوي الأحواض على مجموعة متنوعة من الكائنات البحرية المختلفة  مثل القروش واللخم و الأسماك، ويعد اكواريوم الكويت أحد أفضل اماكن سياحية في الكويت للاطفال."));

        placeItems.add(new PlaceItem(R.drawable.acuap,
                "أكوابارك", "14", "0",
                "مدينة الكويت",
                "https://goo.gl/maps/H9PvNaVi28wU1iBh7",
                "أكبر حديقة مائية في الخليج العربي بمساحة 60 ألف متر مربع ، تقع اكوا بارك الكويت على شارع الخليج العربي بجوار أبراج الكويت، وهي واحدة من أشهر ملاهي الكويت، وتعد من أفضل أماكن ترفيهية في الكويت للاطفال، تمتلك مدينة أكوا بارك الكويت مجموعة متنوعة من عوامل الجذب التي تناسب جميع الفئات العمرية اطفال شباب ، وخاصة الأطفال، مثل المنزلقات ومطاعم في متناول الأطفال الصغار، فضلاً عن مجموعة متنوعة من حمامات السباحة التي توفر العديد من الأنشطة المائية لجميع الفئات العمرية، كما أن لديها ملاعب للكرة الطائرة."));


        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PlaceAdapter(placeItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return v;
    }
}
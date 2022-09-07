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
 * Use the {@link Teens#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Teens extends Fragment {

    private final ArrayList<PlaceItem> placeItems = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Teens() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Teens.
     */
    // TODO: Rename and change types and number of parameters
    public static Teens newInstance(String param1, String param2) {
        Teens fragment = new Teens();
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
        View v = inflater.inflate(R.layout.fragment_teens, container, false);


        placeItems.add(new PlaceItem(R.drawable.code,
                "الكويت تبرمج", "6", "0",
                "CODED",
                "https://code.kw/",
                "الحق سجل المقاعد محدودة!😉"+ "\n" + "\n" +"من خلال هذه المبادرة، يتعلم الطالب برمجة تطبيقات الأيفون، تطبيقات الأندرويد، مواقع الانترنت أو برمجة ألعاب الفيديو شباب، وذلك من خلال دروس مزيجة بين الفيديوهات المسجلة، والمحاضرات التي تتطلب الحضور الشخصي على مدار عدد محدد من اللقاءات."));


        placeItems.add(new PlaceItem(R.drawable.cars,
                "متحف السيارات", "7", "0",
                "الشويخ الصناعية", "https://goo.gl/maps/mppdQDsr4dN8L4sQ7",
                "متحف السيارات الكويت تم افتتاحه في 10 أكتوبر 2010، ويقع في منطقة الشويخ الصناعية بالكويت شباب، ويعرض المتحف مجموعة من السيارات الكلاسيكية و الفاخرة والقديمة، ويتكون من منطقتين، منطقة لعرض السيارات حيث يمكنك مشاهدة سيارات مختلفة، وأخرى مخصصة للأطفال لتجربة قيادة السيارات، ويعد من أكثر متاحف الكويت متعة."));

        placeItems.add(new PlaceItem(R.drawable.acuap,
                "أكوابارك", "14", "0",
                "مدينة الكويت",
                "https://goo.gl/maps/H9PvNaVi28wU1iBh7",
                "أكبر حديقة مائية في الخليج العربي بمساحة 60 ألف متر مربع ، تقع اكوا بارك الكويت على شارع الخليج العربي بجوار أبراج الكويت، وهي واحدة من أشهر ملاهي الكويت، وتعد من أفضل أماكن ترفيهية في الكويت للاطفال، تمتلك مدينة أكوا بارك الكويت مجموعة متنوعة من عوامل الجذب التي تناسب جميع الفئات العمرية اطفال شباب ، وخاصة الأطفال، مثل المنزلقات ومطاعم في متناول الأطفال الصغار، فضلاً عن مجموعة متنوعة من حمامات السباحة التي توفر العديد من الأنشطة المائية لجميع الفئات العمرية، كما أن لديها ملاعب للكرة الطائرة."));


        placeItems.add(new PlaceItem(R.drawable.mall,
                "مارينا مول", "8", "0",
                "السالمية",
                "",
                "من المعالم البارزة في دولة الكويت يقع على ضفاف الخليج العربي في منطقة السالمية، بالقرب من ماركس أند سبنسير. يضم المشروع: مجمع تجاري، فندق، إذاعة، جسر معلق للمشاة ومرسى سفن."+"يقع المجمع التجاري (مارينا مول) في منطقة السالمية على الجهة البرية الموازية لشارع الخليج العربي، يضم المجمع العديد من المحلات للمركات العالمية والمطاعم الفاخرة. منها :\n" +
                        "\n" +
                        "المتاجر الضخمة:\n" +
                        "ذ ون\n" +
                        "شوبارد\n" +
                        "ديكاثلون\n" +
                        "زارا\n" +
                        "ريفر ايلاند\n" +
                        "فكتوريا سيكريت\n" +
                        "إتش أند أم\n" +
                        "إمريكان إيجل أوتفترز\n" +
                        "المطاعم:\n" +
                        "لي نوتر\n" +
                        "ماكدونالدز\n" +
                        "برجر كنج\n" +
                        "صب واي\n" +
                        "دجاج كنتاكي\n" +
                        "مغل محل\n" +
                        "جوليبي\n" +
                        "شباب\n" +
                        "أبو جاسم\n" +
                        "كوردو\n" +
                        "باستامانيا\n" +
                        "يم يم تري\n" +
                        "دومينوز بيتزا\n" +
                        "المقاهي:\n" +
                        "ستاربكس\n" +
                        "بول\n" +
                        "سينابون\n" +
                        "كما يحتوى المجمع على ثلاث قاعات سينمائية تابعة لشركة السينما الكويتية الوطنية (سينسكيب)."));



        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PlaceAdapter(placeItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return v;
    }
}
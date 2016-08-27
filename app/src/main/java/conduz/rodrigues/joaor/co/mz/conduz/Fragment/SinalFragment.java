package conduz.rodrigues.joaor.co.mz.conduz.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.Utility;
import conduz.rodrigues.joaor.co.mz.conduz.activity.SinalChooser;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.SinalAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;
import conduz.rodrigues.joaor.co.mz.conduz.model.Sinal;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SinalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinalFragment extends Fragment {

    private RecyclerView sinalList;
    private List<Sinal> dataset;
    private SinalAdapter sinalAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button sinalChapter;
    private Button sinalSection;
    private Button.OnClickListener chapterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chapterClick();
        }
    };

    private Button.OnClickListener sectionClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sectionClick();
        }
    };

    public SinalFragment() {

    }


    public static SinalFragment newInstance(String param1, String param2) {
        SinalFragment fragment = new SinalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sinal, container, false);
        sinalChapter = (Button) view.findViewById(R.id.bt_sinal_chapter);
        sinalSection = (Button) view.findViewById(R.id.bt_sinal_section);
        sinalChapter.setOnClickListener(chapterClickListener);
        sinalSection.setOnClickListener(sectionClickListener);

        if(SinalChooser.capitulo!=null)
            sinalChapter.setText(SinalChooser.capitulo);
        if(SinalChooser.seccao!=null)
            sinalSection.setText(SinalChooser.seccao);

        int noColumns = Utility.calculateNoOfColumns(getContext(),130);
        mLayoutManager = new GridLayoutManager(view.getContext(),noColumns);
        sinalList = (RecyclerView) view.findViewById(R.id.rv_sinais);
        sinalList.setLayoutManager(mLayoutManager);
        SampleModel sampleModel = new SampleModel();
        dataset = sampleModel.SampleSinal();
        sinalAdapter = new SinalAdapter(dataset);
        sinalList.setAdapter(sinalAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(SinalChooser.capitulo!=null)
            sinalChapter.setText(SinalChooser.capitulo);
        if(SinalChooser.seccao!=null)
            sinalSection.setText(SinalChooser.seccao);
    }

    private void chapterClick(){
        Intent intent = new Intent(getContext(), SinalChooser.class);
        startActivity(intent);
    }

    private void sectionClick (){
        Intent intent = new Intent(getContext(), SinalChooser.class);
        startActivity(intent);
    }
}

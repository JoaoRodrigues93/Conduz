package conduz.rodrigues.joaor.co.mz.conduz.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.adapter.SimpleAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.TeoriaAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Capitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.ModelFactory;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeoriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeoriaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Capitulo> dataSet;
    private int [] colors;


    public TeoriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeoriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeoriaFragment newInstance(String param1, String param2) {
        TeoriaFragment fragment = new TeoriaFragment();
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
        View teoriaView = inflater.inflate(R.layout.fragment_teoria, container, false);
        /*List<String> dataset = new ArrayList<String>();
        for (int i = 0; i <50 ; i++) {
            dataset.add("Simple Text Item "+(i));
        }*/

        mRecyclerView = (RecyclerView) teoriaView.findViewById(R.id.rv_teoria);
        mLayoutManager = new LinearLayoutManager(teoriaView.getContext());
//        SimpleAdapter simpleAdapter = new SimpleAdapter(dataset);
        mRecyclerView.setLayoutManager(mLayoutManager);
        colors = getResources().getIntArray(R.array.material_color);
        fetchDataset();
        mAdapter = new TeoriaAdapter(dataSet,colors);
        mRecyclerView.setAdapter(mAdapter);

        return teoriaView;
    }

    private void fetchDataset (){

        ModelFactory sampleModel = new ModelFactory(getContext());
        dataSet = sampleModel.SampleCapitulo();
    }

}

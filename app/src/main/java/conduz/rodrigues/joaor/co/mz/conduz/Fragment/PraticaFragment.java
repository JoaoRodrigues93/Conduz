package conduz.rodrigues.joaor.co.mz.conduz.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.adapter.ExameAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PraticaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PraticaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView praticaList;
    private List<String> mDataset;
    private ExameAdapter exameAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public PraticaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PraticaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PraticaFragment newInstance(String param1, String param2) {
        PraticaFragment fragment = new PraticaFragment();
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
        View view = inflater.inflate(R.layout.fragment_pratica, container, false);
        mLayoutManager = new GridLayoutManager(view.getContext(),4);
        praticaList = (RecyclerView) view.findViewById(R.id.rv_pratica);
        praticaList.setLayoutManager(mLayoutManager);
        mDataset = new ArrayList<String>();

        for (int i = 0; i <30; i++) {

            mDataset.add(""+(i+1));
        }

        exameAdapter = new ExameAdapter(mDataset);
        praticaList.setAdapter(exameAdapter);
        return view;
    }

}

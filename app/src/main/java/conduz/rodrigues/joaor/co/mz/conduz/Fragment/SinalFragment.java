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

import conduz.rodrigues.joaor.co.mz.conduz.adapter.SinalAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SinalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView sinalList;
    private List<String> mDataset;
    private SinalAdapter sinalAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public SinalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SinalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SinalFragment newInstance(String param1, String param2) {
        SinalFragment fragment = new SinalFragment();
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
        View view = inflater.inflate(R.layout.fragment_sinal, container, false);
        mLayoutManager = new GridLayoutManager(view.getContext(),2);
        sinalList = (RecyclerView) view.findViewById(R.id.rv_sinais);
        sinalList.setLayoutManager(mLayoutManager);
        mDataset = new ArrayList<String>();
        mDataset.add("Item1");
        mDataset.add("item2");
        mDataset.add("item3");
        mDataset.add("item4");
        mDataset.add("Item5");
        mDataset.add("item6");
        mDataset.add("item7");
        mDataset.add("item8");
        sinalAdapter = new SinalAdapter(mDataset);
        sinalList.setAdapter(sinalAdapter);
        return view;
    }

}

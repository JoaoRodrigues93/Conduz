package conduz.rodrigues.joaor.co.mz.conduz.fragment;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.LeituraActivity;
import conduz.rodrigues.joaor.co.mz.conduz.activity.SinalDetailActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SinalDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinalDetailFragment extends Fragment {
    private static final String SINAL_IMAGE_RESOURCE = "sinal_image_resource";
    private static final String SINAL_TITLE = "sinal_title";
    private static final String SINAL_DESCRIPTION = "sinal_description";
    private static final String SINAL_CODE = "sinal_code";


    private String sinalTitle;
    private String sinalDescription;
    private String sinalCode;
    private int imageResource;

    public SinalDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment SinalDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SinalDetailFragment newInstance(String sinalTitle, String sinalDescription, String sinalCode, int imageResource) {
        SinalDetailFragment fragment = new SinalDetailFragment();
        Bundle args = new Bundle();
        args.putInt(SINAL_IMAGE_RESOURCE, imageResource);
        args.putString(SINAL_TITLE,sinalTitle);
        args.putString(SINAL_DESCRIPTION, sinalDescription);
        args.putString(SINAL_CODE, sinalCode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           imageResource = getArguments().getInt(SINAL_IMAGE_RESOURCE);
           sinalTitle = getArguments().getString(SINAL_TITLE);
           sinalDescription = getArguments().getString(SINAL_DESCRIPTION);
           sinalCode = getArguments().getString(SINAL_CODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sinal_detail2, container, false);
        ImageView sinalImage = (ImageView) view.findViewById(R.id.iv_sinal_image);
        TextView sinalCode = (TextView) view.findViewById(R.id.tv_sinal_code);
        TextView sinalDescription = (TextView) view.findViewById(R.id.tv_sinal_description);

        sinalImage.setImageResource(this.imageResource);
        sinalDescription.setText(this.sinalDescription);
        sinalCode.setText(this.sinalCode);

        return view;
    }

}

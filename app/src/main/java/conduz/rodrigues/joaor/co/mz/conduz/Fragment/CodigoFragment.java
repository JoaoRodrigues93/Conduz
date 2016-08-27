package conduz.rodrigues.joaor.co.mz.conduz.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.activity.ArticleChooser;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.ArtigoAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Artigo;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodigoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CodigoFragment extends Fragment {

    private RecyclerView artigoList;
    private List<Artigo> mDataset;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager mLayoutManager;

    public static final String TITULO_ID = "titulo_id";
    public static final String SUBTITULO_ID = "subtitulo_id";
    public static final String SECCAO_ID = "seccao_id";
    public static final String TITULO = "titulo";
    public static final String SUBTITULO = "subtitulo";
    public static final String SECCAO = "seccao";

    private int tituloId;
    private int subtituloId;
    private int seccaoId;
    private String titulo;
    private String subtitulo;
    private String seccao;

    
    private AppCompatButton buttonChapterChooser;
    private AppCompatButton buttonThemeChooser;
    private AppCompatButton.OnClickListener chapterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showChapterChooseDialog();
        }
    };

    

    private  AppCompatButton.OnClickListener themeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showThemeChooserDialog();
        }
    };



    public CodigoFragment() {
        // Required empty public constructor
    }
    
    public static CodigoFragment newInstance(String param1, String param2) {
        CodigoFragment fragment = new CodigoFragment();
        Bundle args = new Bundle();
        args.putInt(TITULO_ID,ArticleChooser.tituloId);
        args.putInt(SUBTITULO_ID,ArticleChooser.subtituloId);
        args.putInt(SECCAO_ID,ArticleChooser.seccaoId);
        args.putString(TITULO,ArticleChooser.titulo);
        args.putString(SUBTITULO,ArticleChooser.subtitulo);
        args.putString(SECCAO, ArticleChooser.seccao);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        tituloId = bundle.getInt(TITULO_ID);
        subtituloId = bundle.getInt(SUBTITULO_ID);
        seccaoId = bundle.getInt(SECCAO_ID);
        titulo = bundle.getString(TITULO);
        subtitulo= bundle.getString(SUBTITULO);
        seccao = bundle.getString(SECCAO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_codigo, container, false);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        buttonChapterChooser = (AppCompatButton)view.findViewById(R.id.bt_article_chapter);
        buttonThemeChooser = (AppCompatButton) view.findViewById(R.id.bt_article_theme);
        if(seccao!=null)
        buttonThemeChooser.setText(seccao);
        if(subtitulo!=null)
        buttonChapterChooser.setText(subtitulo);

        buttonChapterChooser.setOnClickListener(chapterOnClickListener);
        buttonThemeChooser.setOnClickListener(themeOnClickListener);
        artigoList = (RecyclerView) view.findViewById(R.id.rv_artigos);
        artigoList.setLayoutManager(mLayoutManager);
        SampleModel sampleModel = new SampleModel();
        mDataset = sampleModel.SampleArtigo(Integer.valueOf(""+subtituloId+""+seccaoId));

        ArtigoAdapter artigoAdapter = new ArtigoAdapter(mDataset);
        artigoList.setAdapter(artigoAdapter);

        return view;
    }

    private void showChapterChooseDialog() {
        Intent intent = new Intent(getContext(), ArticleChooser.class);
        startActivity(intent);
    }

    private void showThemeChooserDialog() {
        Intent intent = new Intent(getContext(), ArticleChooser.class);
        startActivity(intent);
    }
}

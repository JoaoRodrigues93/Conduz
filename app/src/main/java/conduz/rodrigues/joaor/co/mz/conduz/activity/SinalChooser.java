package conduz.rodrigues.joaor.co.mz.conduz.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.ClickListener;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.RecyclerTouchListener;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.SinalChooserAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.model.CapituloSinal;
import conduz.rodrigues.joaor.co.mz.conduz.model.Quadro;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;
import conduz.rodrigues.joaor.co.mz.conduz.model.Titulo;


public class SinalChooser extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    public static int capituloId = 1;
    public static int seccaoId = 1;
    public static String capitulo;
    public static String seccao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinal_chooser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sinal_chooser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private List<CapituloSinal> capitulos;
        private List<Quadro> quadros;
        private  List mDataset;
        private static ViewPager mViewPager;
        private static final String ARG_SECTION_NUMBER = "section_number";
        TextView capituloAnterior;
        TextView quadroAnterior;

        public PlaceholderFragment() {
            capitulos = new ArrayList<CapituloSinal>();
            quadros = new ArrayList<Quadro>();


            SampleModel sampleModel = new SampleModel();

            capitulos = sampleModel.SampleCapituloSinal();
            quadros = sampleModel.SampleQuadro();
        }

        public static PlaceholderFragment newInstance(int sectionNumber, ViewPager viewPager) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            mViewPager = viewPager;
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sinal_chooser, container, false);
            RecyclerView sinal_title_list = (RecyclerView) rootView.findViewById(R.id.sinal_chooser);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
            String type = null;

            final int sectioNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            if (sectioNumber == 1) {
                mDataset = capitulos;
                type = "capitulo";
            }

            else if(sectioNumber==2) {
                mDataset = quadros;
                type = "seccao";
            }

            SinalChooserAdapter sinalChooserAdapter = new SinalChooserAdapter(mDataset,type);
            sinalChooserAdapter.setmViewPager(mViewPager);
            sinal_title_list.setLayoutManager(layoutManager);
            sinal_title_list.setAdapter(sinalChooserAdapter);

            final String finalType = type;
            sinal_title_list.addOnItemTouchListener(new RecyclerTouchListener(getContext(), sinal_title_list, new ClickListener(){

                @Override
                public void onClick(View view, int position) {
                    if(finalType =="capitulo") {

                        if (capituloAnterior != null) {
                            capituloAnterior.setTextColor(view.getResources().getColor(R.color.body));
                            capituloAnterior.setTypeface(null, Typeface.NORMAL);
                        }

                        TextView textView = (TextView) ((LinearLayout) view).getChildAt(0);
                        textView.setTextColor(view.getResources().getColor(R.color.colorPrimary));
                        textView.setTypeface(null, Typeface.BOLD);
                        capituloAnterior = textView;
                        CapituloSinal capituloSinal = capitulos.get(position);
                        capituloId = capituloSinal.getId();
                        capitulo = capituloSinal.getNome();
                        mViewPager.setCurrentItem(1);
                    }

                    else  if (finalType == "seccao"){
                        if (quadroAnterior != null) {
                            quadroAnterior.setTextColor(view.getResources().getColor(R.color.body));
                            quadroAnterior.setTypeface(null, Typeface.NORMAL);
                        }

                        TextView textView = (TextView) ((LinearLayout) view).getChildAt(0);
                        textView.setTextColor(view.getResources().getColor(R.color.colorPrimary));
                        textView.setTypeface(null, Typeface.BOLD);
                        quadroAnterior = textView;
                        Quadro quadro = quadros.get(position);
                        seccaoId = quadro.getId();
                        seccao = quadro.getNome();
                        getActivity().finish();
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1,mViewPager);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CAPÍTULO";
                case 1:
                    return "SECÇÃO";
            }
            return null;
        }
    }
}

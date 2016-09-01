package conduz.rodrigues.joaor.co.mz.conduz.activity;

import android.content.Context;
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


import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.ClickListener;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.RecyclerTouchListener;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.ArticleChooserAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.model.ModelFactory;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;
import conduz.rodrigues.joaor.co.mz.conduz.model.Seccao;
import conduz.rodrigues.joaor.co.mz.conduz.model.Subtitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.Titulo;

public class ArticleChooser extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public static int tituloId = 0;
    public static int subtituloId = 0;
    public static int seccaoId = 0;
    public static String titulo;
    public static String subtitulo;
    public static String seccao;
    public Context context;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_chooser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        context = getApplicationContext();
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_chooser, menu);
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
        else if (id == android.R.id.home) {
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private List<Titulo> titulo;
        private List<Subtitulo> capitulo;
        private List<Seccao> seccao;
        private List mDataset;
        private static ViewPager mViewPager;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
            titulo = new ArrayList<>();
            capitulo = new ArrayList<>();
            seccao = new ArrayList<>();


        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,ViewPager viewPager) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            mViewPager = viewPager;
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_article_chooser, container, false);

            SampleModel sampleModel = new SampleModel();
            ModelFactory modelFactory = new ModelFactory(getContext());
            titulo = modelFactory.SampleTitulo();
            capitulo = modelFactory.SampleSubtitulo(tituloId);
            seccao = modelFactory.SampleSeccao(subtituloId,tituloId);


            RecyclerView article_title_list = (RecyclerView) rootView.findViewById(R.id.article_chooser);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
            String type = null;
            final int sectioNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            if (sectioNumber == 1) {
                mDataset = titulo;
                type = "titulo";
            }
            else if (sectioNumber==2) {
                mDataset = capitulo;
                type = "capitulo";
            }
            else if(sectioNumber==3) {
                mDataset = seccao;
                type = "seccao";
            }
            ArticleChooserAdapter articleChooserAdapter = new ArticleChooserAdapter(mDataset,type);
            articleChooserAdapter.setMainViewPager(mViewPager);
            article_title_list.setLayoutManager(layoutManager);
            article_title_list.setAdapter(articleChooserAdapter);
            final String finalType = type;
            article_title_list.addOnItemTouchListener(new RecyclerTouchListener(getContext(), article_title_list, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (finalType == "titulo")
                    {
                       ArticleChooser.tituloId = titulo.get(position).getId();
                       ArticleChooser.titulo  = titulo.get(position).getNome();
                    }
                    else if(finalType =="capitulo")
                    {
                        ArticleChooser.subtituloId =  capitulo.get(position).getId();
                        ArticleChooser.subtitulo = capitulo.get(position).getNome();
                    }
                    else if (finalType == "seccao")
                    {
                        ArticleChooser.seccaoId = seccao.get(position).getId();
                        ArticleChooser.seccao = seccao.get(position).getNome();
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1,mViewPager);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "TÍTULO";
                case 1:
                    return "CAPÍTULO";
                case 2:
                    return "SECÇÃO";
            }
            return null;
        }
    }
}

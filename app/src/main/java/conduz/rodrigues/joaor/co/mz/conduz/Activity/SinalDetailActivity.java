package conduz.rodrigues.joaor.co.mz.conduz.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.fragment.SinalDetailFragment;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.CapituloSinal;
import conduz.rodrigues.joaor.co.mz.conduz.model.ModelFactory;
import conduz.rodrigues.joaor.co.mz.conduz.model.Quadro;
import conduz.rodrigues.joaor.co.mz.conduz.model.Sinal;

public class SinalDetailActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Toolbar toolbar;

    private List<CapituloSinal> capitulos;
    private List<Quadro> quadros;
    private List<Sinal> dataset;

    public static  String ID_SINAL_ESCOLHIDO = "idSinalEscolhido";
    private int idDoSinalEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinal_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ModelFactory modelFactory = new ModelFactory(getApplicationContext());

        capitulos = modelFactory.SampleCapituloSinal();
        quadros = modelFactory.SampleQuadro(SinalChooser.capituloId);
        dataset = modelFactory.SampleSinal(SinalChooser.seccaoId,SinalChooser.capituloId);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        idDoSinalEscolhido = getIntent().getIntExtra(ID_SINAL_ESCOLHIDO,0);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Sinal sinal = dataset.get(position);
                toolbar.setTitle(sinal.getNome());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setCurrentFragment();
    }

    private void setCurrentFragment() {
        Sinal sinal;
        for (int i=0; i<dataset.size();i++){
            sinal = dataset.get(i);
            if(sinal.getId()==idDoSinalEscolhido)
                mViewPager.setCurrentItem(i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sinal_detail, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     *

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
            Sinal sinal = dataset.get(position);
            toolbar.setTitle(sinal.getNome());
            return SinalDetailFragment.newInstance(sinal.getNome(),
                    sinal.getDescricao(),sinal.getCodigo(),sinal.getIconeResource());
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return dataset.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "SECTION "+(position+1);
        }
    }
}

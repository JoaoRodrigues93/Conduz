package conduz.rodrigues.joaor.co.mz.conduz.activity;


import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.ClickListener;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.RecyclerTouchListener;
import conduz.rodrigues.joaor.co.mz.conduz.adapter.QuestionNumberAdapter;
import conduz.rodrigues.joaor.co.mz.conduz.fragment.ExercicioActivityFragment;
import conduz.rodrigues.joaor.co.mz.conduz.model.Questao;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;


public class ExameActivity extends AppCompatActivity {

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
    private RecyclerView questionNumber;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> dataset;
    private QuestionNumberAdapter adapter;
    private List<Questao> questoes;
    private List<Integer> choosenOption;
    private List<String>  valuesOfChoosenOptions;
    private boolean showCorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        questionNumber = (RecyclerView) findViewById(R.id.rv_numero_perguntas);
        layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        dataset = new ArrayList<>();
        choosenOption = new ArrayList<>();
        valuesOfChoosenOptions = new ArrayList<String>(25);
        questoes = new SampleModel().SampleQuestao();
        fillDataset();

        adapter = new QuestionNumberAdapter(dataset);
        questionNumber.setLayoutManager(layoutManager);
        questionNumber.setAdapter(adapter);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        initialize();
    }

    private void changeStyleOfSelectedQuestion (int position){
        /*Button button = (Button) layoutManager.getChildAt(position);
        if(button!=null){
        button.setTextColor(this.getResources().getColor(R.color.colorPrimary));
        button.setTypeface(null, Typeface.BOLD);
        }*/
    }

    private void initialize() {
        questionNumber.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), questionNumber, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mViewPager.setCurrentItem(position);
                changeStyleOfSelectedQuestion(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                layoutManager.scrollToPosition(position);
                changeStyleOfSelectedQuestion(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void fillDataset (){
        for (int i = 0; i <25 ; i++) {
            dataset.add(""+(i+1));
            choosenOption.add(-1);
            valuesOfChoosenOptions.add("");
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exame, menu);
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
     */

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
            ExercicioActivityFragment exercicioActivityFragment = new ExercicioActivityFragment();
            Questao questao = questoes.get(position);
            Bundle bundle = new Bundle();
            bundle.putString(ExercicioActivityFragment.PERGUNTA,questao.getPergunta());
            bundle.putString(ExercicioActivityFragment.RESPOSTA1,questao.getOpcao1());
            bundle.putString(ExercicioActivityFragment.RESPOSTA2,questao.getOpcao2());
            bundle.putString(ExercicioActivityFragment.RESPOSTA3,questao.getOpcao3());
            bundle.putString(ExercicioActivityFragment.RESPOSTA4,questao.getOpcao4());
            bundle.putString(ExercicioActivityFragment.RESPOSTA_CERTA,questao.getOpcaoCorrecta());
            bundle.putInt(ExercicioActivityFragment.IMAGE_RESOURCE,questao.getImagemResource());
            bundle.putInt(ExercicioActivityFragment.INDICE_PERGUNTA,position);

            exercicioActivityFragment.setArguments(bundle);
            return exercicioActivityFragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 25;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Pergunta "+(position+1);
        }
    }

    public void setChoosenOption (int index,int option, String value){
        choosenOption.set(index,option);
        valuesOfChoosenOptions.set(index,value);
    }

    public  int getChoosenOption (int index){
        if(choosenOption.size()>index)
        return  choosenOption.get(index);
        else
            return -1;
    }

    public  String getChoosenOptionValue (int index){
        if(valuesOfChoosenOptions.size()>index)
        return  valuesOfChoosenOptions.get(index);
        else
            return null;
    }
    
    public boolean allQuestionFilled (){
        boolean filled = true;

        for (Integer option:choosenOption
             ) {
            if (option<0)
                filled =false;
        }

        return filled;
    }

    public void sendAnswer (){
        showCorrectAnswers = true;
        if(allQuestionFilled())
            Toast.makeText(ExameActivity.this, "Todas perguntas foram preenchidas e "+numberOfCorrectAnswers()+" questões foram respondidas correctamente", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(ExameActivity.this, "Tem de responder todas as perguntas e até agora "+numberOfCorrectAnswers()+" questões foram respondidas correctamente", Toast.LENGTH_SHORT).show();
    }

    private int numberOfCorrectAnswers (){
        String answer;
        Questao questao;
        int correctAnswers=0;
        for (int i = 0; i < 25; i++) {
            answer = valuesOfChoosenOptions.get(i);
            questao = questoes.get(i);
            if(questao.getOpcaoCorrecta().equalsIgnoreCase(answer))
                correctAnswers++;
        }

        return correctAnswers;
    }

    public boolean showCorrectAnswers (){
        return  showCorrectAnswers;
    }
}

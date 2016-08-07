package conduz.rodrigues.joaor.co.mz.conduz.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import conduz.rodrigues.joaor.co.mz.conduz.R;

public class LeituraActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String SUBTITLE = "subtitle";
    public static final String CONTENT = "content";
    public static final String IMAGE_RESOURCE = "imageResource";
    public static final String COLOR = "color";

    private TextView subtitle;
    private ImageView headerImage;
    private TextView content;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leitura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        init();
        Intent intent = getIntent();
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle(intent.getStringExtra(TITLE));
        subtitle.setText(intent.getStringExtra(SUBTITLE));
        headerImage.setImageResource(intent.getIntExtra(IMAGE_RESOURCE,0));
        Drawable drawable = headerImage.getDrawable();
        drawable.setColorFilter(getResources().getColor(R.color.soft_grey), PorterDuff.Mode.MULTIPLY);
        appBarLayout.setBackgroundColor(intent.getIntExtra(COLOR,0));

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void init (){
        subtitle = (TextView) findViewById(R.id.tv_subtitile);
        headerImage = (ImageView) findViewById(R.id.iv_header_image);
        content = (TextView) findViewById(R.id.tv_content);
        appBarLayout = (AppBarLayout)findViewById(R.id.app_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leitura, menu);
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

    @Override
    protected void onResume() {
        super.onResume();
        Drawable drawable = headerImage.getDrawable();
        drawable.setColorFilter(getResources().getColor(R.color.soft_grey), PorterDuff.Mode.MULTIPLY);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Drawable drawable = headerImage.getDrawable();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
    }
}

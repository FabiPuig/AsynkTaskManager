package com.example.fabian.asynktaskmanager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btWow;
    private Button btLol;
    private Button btCsgo;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btWow = (Button) findViewById( R.id.bt_wow );
        btLol = (Button) findViewById( R.id.bt_lol );
        btCsgo = (Button) findViewById( R.id.bt_csgo );

        imageView = (ImageView) findViewById( R.id.imageView );

        btWow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEB", "btwow");
                new AsyncManager.AsyncOne( MainActivity.this, new AsyncManager.AsyncOne.AsyncResponse() {
                    @Override
                    public void processFinish( Bitmap bitmap ) {
                        imageView.setImageBitmap( bitmap );
                    }
                }).execute();
            }
        });

        btLol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEB", "btlol");
                new AsyncManager.AsyncTwo( MainActivity.this, new AsyncManager.AsyncTwo.AsyncResponse() {
                    @Override
                    public void processFinish(Bitmap bitmap) {
                        imageView.setImageBitmap( bitmap );
                    }
                }).execute();
            }
        });

        btCsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEB", "btcsgo");
                new AsyncManager.AsyncThree( MainActivity.this, new AsyncManager.AsyncThree.AsyncResponse() {
                    @Override
                    public void processFinish(Bitmap bitmap) {
                        imageView.setImageBitmap( bitmap );
                    }
                }).execute();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

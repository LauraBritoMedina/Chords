package com.example.lbrito.airguitar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class GuitarActivity extends AppCompatActivity {
    // Ref: https://www.androidtutorialpoint.com/basics/android-seekbar-tutorial/
    private SeekBar E_cord;
    private TextView ProgressTextView;
    private TextView tvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        E_cord=findViewById(R.id.e_cord);
        ProgressTextView= findViewById(R.id.progresstextview);
        tvNote= findViewById(R.id.textView2);
        E_cord.setMax(150);
        E_cord.setProgress(20);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Perform SeekBar (E_cord) change listener event used for getting the progress value i.e. Notify the client that the progress level has been updated on the seekbar
        E_cord.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ // Notify the user changes/actions in the seekBar
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { //This notifies that the progress level has changed on the seekbar. The parameter fromUser distinguishes user-initiated from programatic changes
                    // Log the progress
                    Log.d("DEBUG", "Progress is: "+progress);
                    //set textView's text
                    ProgressTextView.setText("Your current progress is " + progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) { // This is a notification that the user has finished the touch gesture
               /* ProgressTextView.setText("Your current progress is "+progressChangedValue);


                Toast.makeText(GuitarActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();*/
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void GoHome(View view){
        Intent intentMain = new Intent(GuitarActivity.this ,
                MainActivity.class);
        GuitarActivity.this.startActivity(intentMain);
        Log.i("Content "," Main layout ");
    }

    private void write_note(int progress){
        if (progress>=100){
            tvNote.setText(progress);
        }
    }
}

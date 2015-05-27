package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InitialActivity extends Activity {


    public final static String TAG = "C4QTAG";
    public SharedPreferences preferences = null;

    public int counter = 0;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonTileActivity;

    TextView tvCounter;

    public void loadState(){
        Log.d(TAG, "loadState()");
        counter = preferences.getInt("counter", 0);
        Log.d(TAG, "loadState(): counter=="+counter);
    }

    public void saveState(){
        Log.d(TAG, "saveState()");
        Log.d(TAG, "saveState(): counter=="+counter);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("counter", counter);
        editor.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        preferences = getPreferences(Context.MODE_PRIVATE);

        loadState();
        tvCounter = (TextView) findViewById(R.id.tvCounter);
        tvCounter.setText(Integer.toString(counter));

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                tvCounter.setText(Integer.toString(counter));
                saveState();
            }
        });

        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter - 1;
                tvCounter.setText(Integer.toString(counter));
                saveState();
            }
        });


        buttonTileActivity = (Button) findViewById(R.id.buttonTileActivity);
        buttonTileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TileActivity.class);
                startActivity(intent);
            }
        });

    }
}

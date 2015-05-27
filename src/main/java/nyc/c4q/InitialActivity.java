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

    public int counter = 0;
    public SharedPreferences preferences = null;
    public final static String TAG = "C4QTAG";

    public void loadState() {
        Log.d(TAG, "loadState()");
        counter = preferences.getInt("counter", 0);
        Log.d(TAG, "loadState(): counter==" + counter);
    }

    public void saveState() {
        Log.d(TAG, "saveState()");
        Log.d(TAG, "saveState(): counter==" + counter);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("counter", counter);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        preferences = getPreferences(Context.MODE_PRIVATE);
        this.loadState();
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        final TextView tvCounter = (TextView) findViewById(R.id.tvCounter);
        tvCounter.setText("" + counter);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                tvCounter.setText("" + counter);
            }
        });
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                tvCounter.setText("" + counter);
            }
        });
        Button buttonTileActivity = (Button) findViewById(R.id.buttonTileActivity);
        buttonTileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TileActivity.class);
                startActivity(intent);
            }
        });
        Button buttonEmpty = (Button) findViewById(R.id.buttonEmpty);
        buttonEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                tvCounter.setText("" + counter);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.saveState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.saveState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.saveState();
    }
}



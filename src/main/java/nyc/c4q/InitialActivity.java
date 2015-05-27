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
    protected void onResume() {
        super.onResume();
        loadState();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }

    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_initial);
    preferences = getPreferences(Context.MODE_PRIVATE);

    Button plus = (Button) findViewById(R.id.buttonPlus);
      plus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              TextView tvCounter = (TextView) findViewById(R.id.tvCounter);
              counter += 1;
              tvCounter.setText(String.valueOf(counter));
          }
    });
    Button minus = (Button) findViewById(R.id.buttonMinus);
      minus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              TextView tvCounter = (TextView) findViewById(R.id.tvCounter);
              counter -= 1;
              tvCounter.setText(String.valueOf(counter));
          }
    });
    Button tileActivity = (Button) findViewById(R.id.buttonTileActivity);
        tileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ta = new Intent(getBaseContext(), TileActivity.class);
                startActivity(ta);
            }
        });
  }

}

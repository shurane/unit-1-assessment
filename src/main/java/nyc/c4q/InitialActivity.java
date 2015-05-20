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
  Button buttonPlus;
  TextView tvCounter;
  Button buttonMinus;
  Button buttonTileActivity;

  public void loadState(){
    Log.d(TAG, "loadState()");

    counter = preferences.getInt("counter",0);

    Log.d(TAG, "loadState(): counter==" + counter);
  }

  public void saveState(){
    Log.d(TAG, "saveState()");
    Log.d(TAG, "saveState(): counter=="+counter);

    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("counter", counter);
    editor.commit();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    int save = Integer.parseInt(tvCounter.getText().toString());
    outState.putInt("tvcount", save);

  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    int load = savedInstanceState.getInt("tvcount");
    tvCounter.setText(load+"");

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_initial);
    preferences = getPreferences(Context.MODE_PRIVATE);

    tvCounter =  (TextView) findViewById(R.id.tvCounter);

    buttonTileActivity = (Button) findViewById(R.id.buttonTileActivity);
    buttonTileActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent=new Intent(v.getContext(),TileActivity.class);
        startActivity(intent);
      }
    });

    buttonPlus = (Button) findViewById(R.id.buttonPlus);
    buttonPlus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int oldnum = Integer.parseInt(tvCounter.getText().toString());
        int newnum = oldnum +1;
        counter = counter +1;
        tvCounter.setText(""+newnum);
        saveState();
      }
    });

    buttonMinus = (Button) findViewById(R.id.buttonMinus);
    buttonMinus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int oldnum = Integer.parseInt(tvCounter.getText().toString());
        int newnum = oldnum -1;
        counter = counter -1;
        tvCounter.setText(""+newnum);
        saveState();
      }
    });

  }
}

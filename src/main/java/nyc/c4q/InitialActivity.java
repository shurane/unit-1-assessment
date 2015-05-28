package nyc.c4q;

import android.app.Activity;
import android.content.Context;
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

    final Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
    final TextView tvCounter = (TextView) findViewById(R.id.tvCounter);

    buttonPlus.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        counter=+1;
        tvCounter.setText(counter+"");
      }
    });

  }
}


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

  public void loadState(){
    Log.d("C4Q", "loadState()");
    counter = preferences.getInt("counter", 0);
    Log.d("C4Q", "loadState(): counter=="+counter);
  }

  public void saveState(){
    Log.d("C4Q", "saveState()");
    Log.d("C4Q", "saveState(): counter=="+counter);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("counter", counter);
    editor.commit();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_initial);
    preferences = getPreferences(Context.MODE_PRIVATE);
  }
}

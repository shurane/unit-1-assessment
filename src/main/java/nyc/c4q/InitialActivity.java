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

public class InitialActivity extends Activity implements View.OnClickListener{

  public int counter = 0;
  public SharedPreferences preferences = null;
  public final static String TAG = "C4QTAG";
  private Button buttonPlus, buttonMinus, buttonTileActivity;
  private TextView tvCounter;


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
      buttonPlus = (Button) findViewById(R.id.buttonPlus);
      buttonMinus = (Button) findViewById(R.id.buttonMinus);
      buttonTileActivity = (Button) findViewById(R.id.buttonTileActivity);
      tvCounter = (TextView) findViewById(R.id.tvCounter);

      buttonPlus.setOnClickListener(this);
      buttonMinus.setOnClickListener(this);
      buttonTileActivity.setOnClickListener(this);



      tvCounter.setText(String.valueOf(counter));

  }

    @Override
    public void onClick(View view) {
        if(view == buttonPlus){
            counter = Integer.parseInt(tvCounter.getText().toString());
            counter++;
            saveState();
            tvCounter.setText(String.valueOf(counter));

        }
        else if(view == buttonMinus){
            counter = Integer.parseInt(tvCounter.getText().toString());
            counter--;
            saveState();
            tvCounter.setText(String.valueOf(counter));

        }
        else if(view == buttonTileActivity){
            Intent nextStartedActivity = new Intent(getApplicationContext(), TileActivity.class);
            startActivity(nextStartedActivity);
        }
    }

}

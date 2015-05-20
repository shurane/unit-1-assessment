package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InitialActivity extends Activity {
    int numCounter = 0;

    public int counter = 0;
    public SharedPreferences preferences = null;
    public final static String TAG = "C4QTAG";

    public void loadState() {
        Log.d(TAG, "loadState()");
        counter = preferences.getInt("counter", 0);
        Log.d(TAG, "loadState(): counter==" + counter);
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Integer counter = sharedPref.getInt("counter", numCounter);
    }

    public void saveState() {
        Log.d(TAG, "saveState()");
        Log.d(TAG, "saveState(): counter==" + counter);
        //SharedPreferences.Editor editor = preferences.edit();
        //editor.putInt("counter", counter);
        //editor.commit();
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putInt("counter", numCounter);
        editor.commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        preferences = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Integer counter = sharedPref.getInt("counter", numCounter);
        numCounter = counter;


        Log.d(TAG, "onCreate()");
        Button plus = (Button) findViewById(R.id.buttonPlus);
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numCounter++;
                Log.d(TAG, "plus.onClick(): counter==" + numCounter);
                TextView counter = (TextView) findViewById(R.id.tvCounter);
                counter.setText(Integer.toString(numCounter));
            }
        });

        Button minus = (Button) findViewById(R.id.buttonMinus);
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numCounter--;
                Log.d(TAG, "minus.onClick(): counter==" + numCounter);
                TextView counter = (TextView) findViewById(R.id.tvCounter);
                counter.setText(Integer.toString(numCounter));
            }
        });
    }

}

package nyc.c4q;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile);

        TextView redView = (TextView) findViewById(R.id.redView);
        TextView greenView = (TextView) findViewById(R.id.greenView);
        TextView yellowView = (TextView) findViewById(R.id.yellowView);
        TextView whiteView = (TextView) findViewById(R.id.whiteView);
        TextView blueView = (TextView) findViewById(R.id.blueView);

        ColorDrawable redViewBackground = new ColorDrawable(0xffff0000);
        ColorDrawable greenViewBackground = new ColorDrawable(0xff00ff00);
        ColorDrawable yellowViewBackground = new ColorDrawable(0xffffff00);
        ColorDrawable whiteViewBackground = new ColorDrawable(0xffffffff);
        ColorDrawable blueViewBackground = new ColorDrawable(0xff0000ff);

        redView.setBackground(redViewBackground);
        greenView.setBackground(greenViewBackground);
        yellowView.setBackground(yellowViewBackground);
        whiteView.setBackground(whiteViewBackground);
        blueView.setBackground(blueViewBackground);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tiles, menu);
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

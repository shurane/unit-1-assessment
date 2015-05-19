package nyc.c4q;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1AssessmentTests {

    // ===================================== HELPERS START

    public static String getResourceId(View v){
        // http://stackoverflow.com/a/17583380/198348
        int id = v.getId();
        String idString = "no id";
        if(id != View.NO_ID) {
            Resources res = v.getResources();
            if(res != null)
                idString = res.getResourceEntryName(id);
        }
        return idString;
    }

    public static View findViewByIdString(Activity a, String s){
        return a.findViewById(a.getResources().getIdentifier(s, "id", a.getPackageName()));
    }

    // ===================================== HELPERS END

    @Test
    public void test01FixInitialActivityLayout() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).create().get();
        LinearLayout layout = (LinearLayout) activity.findViewById(R.id.activity_initial);

        // TODO only need the last assertTrue() method per view
        assertTrue("LinearLayout(@+id/activity_initial)[0] should be a LinearLayout", layout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterLayout = (LinearLayout) layout.getChildAt(0);
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have R.id.counterLayout", getResourceId(counterLayout).equals("counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should be equal to LinearLayout(@+id/counterLayout)", counterLayout == findViewByIdString(activity, "counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have a horizontal orientation", counterLayout.getOrientation() == LinearLayout.HORIZONTAL);

        assertTrue("LinearLayout(@+id/counterLayout)[0] should be a LinearLayout", counterLayout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterButtonsLayout = (LinearLayout) counterLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have R.id.counterButtonsLayout", getResourceId(counterButtonsLayout).equals("counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should be equal to LinearLayout(@+id/counterButtonsLayout)", counterButtonsLayout == findViewByIdString(activity, "counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have a vertical orientation", counterButtonsLayout.getOrientation() == LinearLayout.VERTICAL);

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be a Button", counterButtonsLayout.getChildAt(0) instanceof Button);
        Button buttonPlus = (Button) counterButtonsLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should have R.id.buttonPlus", getResourceId(buttonPlus).equals("buttonPlus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be equal to Button(@+id/buttonPlus)", buttonPlus == findViewByIdString(activity, "buttonPlus"));
        assertEquals("+", buttonPlus.getText());

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be a Button", counterButtonsLayout.getChildAt(1) instanceof Button);
        Button buttonMinus = (Button) counterButtonsLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should have R.id.buttonMinus", getResourceId(buttonMinus).equals("buttonMinus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be equal to Button(@+id/buttonMinus)", buttonMinus == findViewByIdString(activity, "buttonMinus"));
        assertEquals("-", buttonMinus.getText());

        View tvCounter = counterLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[0][1] should be equal to TextView(@+id/tvCounter)",
                tvCounter instanceof TextView && getResourceId(tvCounter).equals("tvCounter"));
        assertEquals("0", ((TextView) tvCounter).getText());

        View buttonTileActivity = layout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonTileActivity)",
                buttonTileActivity instanceof Button && getResourceId(buttonTileActivity).equals("buttonTileActivity"));
        assertEquals("TileActivity", ((Button) buttonTileActivity).getText());

        View buttonNewsReaderActivity = layout.getChildAt(2);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonNewsReaderActivity)",
                buttonNewsReaderActivity instanceof Button && getResourceId(buttonNewsReaderActivity).equals("buttonNewsReaderActivity"));
        assertEquals("NewsReaderActivity", ((Button) buttonNewsReaderActivity).getText());

        View buttonBigTextActivity = layout.getChildAt(3);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonBigTextActivity)",
                buttonBigTextActivity instanceof Button && getResourceId(buttonBigTextActivity).equals("buttonBigTextActivity"));
        assertEquals("BigTextActivity", ((Button) buttonBigTextActivity).getText());

        assertEquals("LinearLayout(@+id/counterLayout) should have layout_weight='2'", 2, ((LinearLayout.LayoutParams) counterLayout.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonTileActivity) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonTileActivity.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonNewsReaderActivity) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonNewsReaderActivity.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonBigTextActivity) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonBigTextActivity.getLayoutParams()).weight, 0.01);
        assertEquals("LinearLayout(@+id/counterButtonsLayout) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) counterButtonsLayout.getLayoutParams()).weight, 0.01);
        assertEquals("TextView    (@+id/tvCounter) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) tvCounter.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonPlus) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonPlus.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonMinus) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonMinus.getLayoutParams()).weight, 0.01);


        assertEquals("LinearLayout(@+id/counterLayout) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) counterLayout.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonTileActivity) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonTileActivity.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonNewsReaderActivity) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonNewsReaderActivity.getLayoutParams()).height);
        assertEquals("Button      (@+ilayout_weightd/buttonBigTextActivity) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonBigTextActivity.getLayoutParams()).height);
        assertEquals("LinearLayout(@+id/counterButtonsLayout) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) counterButtonsLayout.getLayoutParams()).width);
        assertEquals("TextView    (@+id/tvCounter) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) tvCounter.getLayoutParams()).width);
        assertEquals("Button      (@+id/buttonPlus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonPlus.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonMinus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonMinus.getLayoutParams()).height);

    }

    @Test
    public void test11FixTileActivityLayout() throws Exception {
        TileActivity ta = Robolectric.buildActivity(TileActivity.class).create().get();
        LinearLayout taLayout = (LinearLayout) ta.findViewById(R.id.activity_tile);

        assertTrue("LinearLayout(@+id/activity_tile) should have a vertical orientation",
                taLayout.getOrientation() == LinearLayout.VERTICAL);

        int leftSideId = ta.getResources().getIdentifier("leftSide", "id", ta.getPackageName());
        int rightSideId = ta.getResources().getIdentifier("rightSide", "id", ta.getPackageName());
        assertTrue("LinearLayout(@+id/leftSide) not found", leftSideId > 0);
        assertTrue("LinearLayout(@+id/rightSide) not found", rightSideId > 0);
        View leftSideById = ta.findViewById(leftSideId);
        View rightSideById = ta.findViewById(rightSideId);

        View leftSide = taLayout.getChildAt(0);
        View rightSide = taLayout.getChildAt(1);
        assertTrue("leftSide is not a LinearLayout", leftSide instanceof LinearLayout);
        assertTrue("rightSide is not a LinearLayout", rightSide instanceof LinearLayout);

        assertTrue("LinearLayout(@+id/activity_tile)[0] should be equal to LinearLayout(@+id/leftSide)",
                leftSide == leftSideById);
        assertTrue("LinearLayout(@+id/activity_tile)[1] should be equal to LinearLayout(@+id/rightSide)",
                rightSide == rightSideById);

        LinearLayout leftSideLayout = (LinearLayout) leftSide;
        LinearLayout rightSideLayout = (LinearLayout) rightSide;


        View red = leftSideLayout.getChildAt(0);
        View green = leftSideLayout.getChildAt(1);

        View yellow = rightSideLayout.getChildAt(0);
        View white = rightSideLayout.getChildAt(1);
        View blue = rightSideLayout.getChildAt(2);

        assertTrue("LinearLayout(@+id/leftSide).getOrientation() should be vertical",
                leftSideLayout.getOrientation() == LinearLayout.VERTICAL);
        assertTrue("LinearLayout(@+id/rightSide).getOrientation() should be vertical",
                leftSideLayout.getOrientation() == LinearLayout.VERTICAL);

        Log.d("Unit1Assessment", String.format("red:%d, green: %d, yellow: %d, white: %d, blue: %d",
                ((LinearLayout.LayoutParams) red.getLayoutParams()).weight,
                ((LinearLayout.LayoutParams) green.getLayoutParams()).weight,
                ((LinearLayout.LayoutParams) yellow.getLayoutParams()).weight,
                ((LinearLayout.LayoutParams) white.getLayoutParams()).weight,
                ((LinearLayout.LayoutParams) blue.getLayoutParams()).weight));
        // TODO test on dp, padding, padding around the views

    }
}

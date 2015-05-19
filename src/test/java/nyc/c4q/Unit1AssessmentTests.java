package nyc.c4q;

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
import org.robolectric.util.ActivityController;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1AssessmentTests {

    @Test
    public void test01FixInitialActivityLayout() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).create().get();
        LinearLayout layout = (LinearLayout) activity.findViewById(R.id.activity_initial);

        assertTrue("LinearLayout(@+id/activity_initial)[0] should be a LinearLayout", layout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterLayout = (LinearLayout) layout.getChildAt(0);
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have R.id.counterLayout", Helpers.getResourceId(counterLayout).equals("counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should be equal to LinearLayout(@+id/counterLayout)", counterLayout == Helpers.findViewByIdString(activity, "counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have a horizontal orientation", counterLayout.getOrientation() == LinearLayout.HORIZONTAL);

        assertTrue("LinearLayout(@+id/counterLayout)[0] should be a LinearLayout", counterLayout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterButtonsLayout = (LinearLayout) counterLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have R.id.counterButtonsLayout", Helpers.getResourceId(counterButtonsLayout).equals("counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should be equal to LinearLayout(@+id/counterButtonsLayout)", counterButtonsLayout == Helpers.findViewByIdString(activity, "counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have a vertical orientation", counterButtonsLayout.getOrientation() == LinearLayout.VERTICAL);

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be a Button", counterButtonsLayout.getChildAt(0) instanceof Button);
        Button buttonPlus = (Button) counterButtonsLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should have R.id.buttonPlus", Helpers.getResourceId(buttonPlus).equals("buttonPlus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be equal to Button(@+id/buttonPlus)", buttonPlus == Helpers.findViewByIdString(activity, "buttonPlus"));
        assertEquals("+", buttonPlus.getText());

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be a Button", counterButtonsLayout.getChildAt(1) instanceof Button);
        Button buttonMinus = (Button) counterButtonsLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should have R.id.buttonMinus", Helpers.getResourceId(buttonMinus).equals("buttonMinus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be equal to Button(@+id/buttonMinus)", buttonMinus == Helpers.findViewByIdString(activity, "buttonMinus"));
        assertEquals("-", buttonMinus.getText());

        View tvCounter = counterLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[0][1] should be equal to TextView(@+id/tvCounter)",
                tvCounter instanceof TextView && Helpers.getResourceId(tvCounter).equals("tvCounter"));
        assertEquals("0", ((TextView) tvCounter).getText());

        View buttonTileActivity = layout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonTileActivity)",
                buttonTileActivity instanceof Button && Helpers.getResourceId(buttonTileActivity).equals("buttonTileActivity"));
        assertEquals("TileActivity", ((Button) buttonTileActivity).getText());

        View buttonNewsReaderActivity = layout.getChildAt(2);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonNewsReaderActivity)",
                buttonNewsReaderActivity instanceof Button && Helpers.getResourceId(buttonNewsReaderActivity).equals("buttonNewsReaderActivity"));
        assertEquals("NewsReaderActivity", ((Button) buttonNewsReaderActivity).getText());

        View buttonBigTextActivity = layout.getChildAt(3);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonBigTextActivity)",
                buttonBigTextActivity instanceof Button && Helpers.getResourceId(buttonBigTextActivity).equals("buttonBigTextActivity"));
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
        assertEquals("Button      (@+i/buttonBigTextActivity) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonBigTextActivity.getLayoutParams()).height);
        assertEquals("LinearLayout(@+id/counterButtonsLayout) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) counterButtonsLayout.getLayoutParams()).width);
        assertEquals("TextView    (@+id/tvCounter) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) tvCounter.getLayoutParams()).width);
        assertEquals("Button      (@+id/buttonPlus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonPlus.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonMinus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonMinus.getLayoutParams()).height);

    }

    @Test
    public void test02ButtonPlusShouldIncreaseTvCounter() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).create().get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        for (int i=1; i<10; i++){
            buttonPlus.callOnClick();
            assertEquals(i, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test03ButtonMinusShouldDecreaseTvCounter() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).create().get();
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        for (int i=-1; i>-10; i--){
            buttonMinus.callOnClick();
            assertEquals(i, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test04ButtonPlusAndButtonMinusShouldWork() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).create().get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        Random r = new Random(0);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        int internalCount = 0;
        for (int i=0; i<10000; i++){
            if (r.nextBoolean()){
                internalCount++;
                buttonPlus.callOnClick();
            }
            else {
                internalCount--;
                buttonMinus.callOnClick();
            }
            assertEquals(internalCount, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test05TvCounterStateShouldBeSavedThroughActivityLifeCycle(){
        ActivityController<InitialActivity> controller = Robolectric.buildActivity(InitialActivity.class).setup();
        InitialActivity activity = controller.get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        buttonPlus.callOnClick();
        assertEquals(1, Integer.parseInt((String) tvCounter.getText()));

        controller.pause().stop().destroy();
        controller = Robolectric.buildActivity(InitialActivity.class).setup();
        activity = controller.get();
        tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertEquals(1, Integer.parseInt((String) tvCounter.getText()));
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

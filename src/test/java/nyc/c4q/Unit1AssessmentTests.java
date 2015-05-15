package nyc.c4q;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1AssessmentTests {

    @Test
    public void testSomething() throws Exception {
        assertTrue(Robolectric.buildActivity(InitialActivity.class).create().get() != null);
    }

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

        assertTrue("LinearLayout(@+id/activity_tile)[0] == LinearLayout(@+id/leftSide)", leftSide == leftSideById);
        assertTrue("LinearLayout(@+id/activity_tile)[1] == LinearLayout(@+id/rightSide)", rightSide == rightSideById);

        LinearLayout leftSideLayout = (LinearLayout) leftSide;
        LinearLayout rightSideLayout = (LinearLayout) rightSide;


        View red = leftSideLayout.getChildAt(0);
        View green = leftSideLayout.getChildAt(1);

        View yellow = rightSideLayout.getChildAt(0);
        View white = rightSideLayout.getChildAt(1);
        View blue = rightSideLayout.getChildAt(2);

        // TODO figure out how to get weights of the views -- worst case is to calculate related to screen width/height

        // TODO test on dp, padding, padding around the views

    }
}

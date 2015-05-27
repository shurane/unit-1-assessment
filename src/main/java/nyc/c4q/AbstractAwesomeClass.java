package nyc.c4q;

import java.util.ArrayList;

/**
 * Created by amyquispe on 5/19/15.
 */
public abstract class AbstractAwesomeClass extends ArrayList implements AwesomeInterface {

    int data;

    @Override
    public int getData() {
        return data;
    }

    @Override
    public void setData(int someData) {
        data=someData;
    }
}

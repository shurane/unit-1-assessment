package nyc.c4q;

/**
 * Created by amyquispe on 5/19/15.
 */
public abstract class AbstractAwesomeClass implements AwesomeInterface{

    private int someData = 4;

    @Override
    public void setData(int someData) {
         this.someData = someData;

    }

    @Override
    public int getData() {
        return someData;
    }
}

package nyc.c4q;

/**
 * Created by amyquispe on 5/19/15.
 */
public class SubFunClass extends SuperFunClass implements AwesomeInterface{
    @Override
    public int getData() {
        return 0;
    }

    @Override
    public void setData(int someData) {

    }

    public SubFunClass(String someName) {
        super(someName);
    }

    public SubFunClass(){


    }
}

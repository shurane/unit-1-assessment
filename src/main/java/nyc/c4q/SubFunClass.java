package nyc.c4q;

/**
 * Created by amyquispe on 5/19/15.
 */
public class SubFunClass extends SuperFunClass implements AwesomeInterface {

    private int data;

    public SubFunClass(){
        super();
    }

    public SubFunClass (String name) {
        super(name);
    }

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public void setData(int someData) {
        this.data = someData;
    }
}

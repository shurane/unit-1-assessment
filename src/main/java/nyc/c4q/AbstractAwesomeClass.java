package nyc.c4q;

/**
 * Created by amyquispe on 5/19/15.
 */
public abstract class AbstractAwesomeClass implements AwesomeInterface {

    int someData;

    @Override
    public int getData() {

        return 4;//has to return 4 or 5;
    }

    @Override
    public void setData(int someData) {

        int someData1= this.someData;
    }

public static void main (){
    AbstractAwesomeClass awesomeObject = new ConcreteAwesomeClass();
    awesomeObject.getData();
    awesomeObject.setData(5);
    awesomeObject.getData();


}




}

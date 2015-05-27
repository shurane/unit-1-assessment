package nyc.c4q;

/**
 * Created by amyquispe on 5/19/15.
 */
public class ConcreteAwesomeClass extends AbstractAwesomeClass {

    public ConcreteAwesomeClass(){
    }
    public ConcreteAwesomeClass(int startData){
        this.someData = 4;
    }

    @Override
    public int getData() {

        int getData=this.someData;
        return getData;
    }

    @Override
    public void setData(int someData) {

        int someData1= this.someData;
    }

}

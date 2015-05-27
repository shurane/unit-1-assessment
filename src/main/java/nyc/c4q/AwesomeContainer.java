package nyc.c4q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by amyquispe on 5/19/15.
 */
public class AwesomeContainer {

    public static ArrayList cray;


    public static Collection createAwesomeContainer(){
        cray=new ArrayList();
        return cray;
    }

    public static void addAwesomeObject(Collection awesomeContainer){
        ConcreteAwesomeClass con = new ConcreteAwesomeClass();
        awesomeContainer.add(con);
        return;
    }
}

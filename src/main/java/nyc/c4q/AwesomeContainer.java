package nyc.c4q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by amyquispe on 5/19/15.
 */
public class AwesomeContainer {

    public static Collection createAwesomeContainer(){
        return new ArrayList();
    }

    public static void addAwesomeObject(Collection awesomeContainer){
        awesomeContainer.add(new ConcreteAwesomeClass());
    }
}

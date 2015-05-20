package nyc.c4q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by amyquispe on 5/19/15.
 */
public class AwesomeContainer {
    static ArrayList arr;
    public static Collection createAwesomeContainer(){
         arr = new ArrayList();
        return arr;
    }

    public static void addAwesomeObject(Collection awesomeContainer){
        arr.add(awesomeContainer);
        return;
    }
}

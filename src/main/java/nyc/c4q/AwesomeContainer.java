package nyc.c4q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by amyquispe on 5/19/15.
 */
public class AwesomeContainer {

    public static Collection createAwesomeContainer(){
        Collection<ConcreteAwesomeClass> awesomeContainer = new Collection<ConcreteAwesomeClass>() {
            @Override
            public boolean add(ConcreteAwesomeClass object) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ConcreteAwesomeClass> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator<ConcreteAwesomeClass> iterator() {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        return null;
    }

    public static void addAwesomeObject(Collection awesomeContainer){
        return;
    }
}

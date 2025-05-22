import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SetCollection {
    public static void main(String[] args) {
        LinkedHashSet<String> hs = new LinkedHashSet<String>();
        hs.add("apple");
        hs.add("apple");
        hs.add("orange");
        hs.add("apple");
        hs.add("banana");

        // Passing HashLinkedSet to ArrayList for conversion 
        // ArrayList<String> al = new ArrayList<>(hs);

        // System.out.println(al);
        // Iterating collection object using foreach
        // for(String item: hs){
        //     System.out.println(item);
        //     if (item.equals("apple")) {
        //         System.out.println(true);
        //     }
        // }

        // Iterating collection object using Iterator object
        Iterator<String> i = hs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        
    }
}

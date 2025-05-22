import java.util.HashSet;
import java.util.Iterator;

public class UniqueHashSet {
    public static void main(String[] args) {
        String[] array = {"apple", "apple", "banana", "orange", "Orange"};
        HashSet<String> hs = new HashSet<>();

        for (String string : array) {
            System.out.println(string);
            hs.add(string);
        }

        Iterator<String> i = hs.iterator();
        System.out.println("------------ Unique --------------");
        System.out.println("Total elements: " + hs.size());
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

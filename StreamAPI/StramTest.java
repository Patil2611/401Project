package StreamAPI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class StramTest {
    public static void main(String[] args) {
        Integer[] i = {1,2,3,4,5,6,7};
        List<Integer> al = new ArrayList<>(Arrays.asList(i));

        System.out.println(Stream.of("apple", "Banana", "apple").collect(Collectors.toSet()));

        
        // Iterator<Integer> iterator = al.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }
    }
}

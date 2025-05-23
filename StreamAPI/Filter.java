package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        Integer[] i = {1,3,4,5,6,7};

        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(i));
        List<Integer> result = al.stream().filter(x->x>4).collect(Collectors.toList());

        for (int object : result) {
            System.out.println(object);
        }
    }
}

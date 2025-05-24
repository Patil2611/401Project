package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MultipleStream {
    public static void main(String[] args) {
        Integer[] i = {1,4,5,6,7,8,9,2,3,4,0,4,3,2,1};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(i));
        
        System.out.println(al.stream().collect(Collectors.toSet())
        .stream().sorted().collect(Collectors.toList())
        .stream().map(x -> x * 2).collect(Collectors.toSet())
        .stream().sorted().collect(Collectors.toList()));
        // .stream().reduce(0, (x,y) -> x + y));
    }
}

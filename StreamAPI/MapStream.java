package StreamAPI;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MapStream {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(1);
        al.add(5);

        System.out.println(al.stream().map(x -> x * 2).collect(Collectors.toList()));
        System.out.println(al.stream().collect(Collectors.toSet()));
    }
}

package StreamAPI;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SortedStream {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(4);
        s.add(2);
        s.add(3);

        System.out.println(s.stream().sorted().collect(Collectors.toSet()));

        s.stream().forEach(System.out::println);

    }
}

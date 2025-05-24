import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperation {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8));

        Set<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        System.out.println(union);

    }
}

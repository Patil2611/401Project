import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    
}

public class ComparableApplication {
    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
        l.add(new Student(1, "Patil"));
        l.add(new  Student(2, "Jadhav"));
        l.add(new Student(0, null));
        
        Integer arr[] = {1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> integer = new ArrayList<>(Arrays.asList(arr));
    
        Collections.reverse(integer);

        Iterator<Integer> i = integer.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        for(Student s: l){
            System.out.println(s);
        }
    }
}

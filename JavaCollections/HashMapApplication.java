import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class HashMapApplication {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("id", 10);
        hm.put("name", 11);
        // System.out.println("Return Value: " + hm.put("id", 10) + " Map Values: " + hm);

        // System.out.println(hm.keySet());

        // Iterate Map with Jugaad by converting keys into Set and iterate with Values 
        // Iterator<String> i = hm.keySet().iterator();

        // while (i.hasNext()) {
        //     System.out.println(hm.get(i.next()));
        // }

        for(Map.Entry<String, Integer> m: hm.entrySet()){
            System.out.println(m.getKey() + ": " + m.getValue());
        }
    }
}
public class cons {
    String name;
    int age;
    cons(String name,int age){
        this.name=name;
        this.age=age;
    }

    public static void main(String[] agrs){
      cons obj1=new cons("nikhil",101);
      cons obj2=new cons("appu",123);
      System.out.println("emp1: "+obj1.name+", "+obj1.age);
      System.out.println("emp2: "+obj2.name+", "+ obj2.age);
    
    }
}

  
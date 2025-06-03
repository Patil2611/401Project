public class demo1 {
    public void eat(){
        System.out.println("i am eating");
    }
    public static void main(String[] args) {
        System.out.println("1");
        demo1 d=new demo1();
        d.eat();
        d.run();
        demo2 c=new demo2();
        c.body();
    }
    public void run()
    {
        System.out.println("i am running");
    }
}
class demo2{
    void body(){
           System.out.println("I am joging");
    }
}
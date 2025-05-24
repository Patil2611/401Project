class Person{
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class CloneableExample {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Patil");

        System.out.println(p1.toString());
        Person p2 = (Person) p1.clone();
        System.out.println(p2.toString());
    }
}

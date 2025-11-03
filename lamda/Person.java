package lamda;

public class Person {

    private String name;
    private int age;
    private final String id;
    public static int counter = 0;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = createUniqueId();
    }

    public String createUniqueId() {
        return java.util.UUID.randomUUID().toString();
    }


    public void sayHello() {
        System.out.println("Hello " + this.name);
    }

    public void showAge() {
        System.out.println("your id is: " + this.id + " and I am " + this.age + " years old.");
    }

    public String getGender() {
        return "male";
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

}


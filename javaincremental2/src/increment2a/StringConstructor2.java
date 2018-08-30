package increment2a;

/**
 * creating objects to attach to the array of references
 */
public class StringConstructor2 {
    String name;

    public StringConstructor2(String name) {
        this.name = name;
        System.out.println(name);
    }

    public static void main(String[] args) {
        StringConstructor2[] sc = new StringConstructor2[]{
                new StringConstructor2("Divy"), new StringConstructor2("Kavya"),
                new StringConstructor2("Kartikay")};
    }
}

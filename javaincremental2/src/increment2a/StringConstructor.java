package increment2a;

/**
 * Create a class with a constructor that takes a String argument. During construction, print the argument.
 * Create an array of object references to this class, but don’t actually create objects to assign into
 * the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.
 */

public class StringConstructor {
    String name;

    public StringConstructor(String name) {
        this.name = name;
        System.out.println(name);
    }

    public static void main(String[] args) {
        StringConstructor[] sc = new StringConstructor[3];
        for (StringConstructor s : sc) {
            System.out.println(s);
        }
    }
}

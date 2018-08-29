package increment2a;

/**
 * Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */

public class ConstructorOverloading {

    private static int x;

    public ConstructorOverloading() {
        this(1);
    }

    public ConstructorOverloading(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        ConstructorOverloading c = new ConstructorOverloading(3);
        System.out.println(x);
    }
}
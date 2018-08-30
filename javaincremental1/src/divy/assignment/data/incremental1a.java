package divy.assignment.data;

/**
 * Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized,
 * add a method to print these variables. Add another method in the same class with two local variables and print their values without initializing them.
 */
public class incremental1a {
    private int a;
    private char b;

    public void display1() {
        System.out.println(a);
        System.out.println(b);

    }

    public void display2() {
        int c;
        char d;
        //System.out.println(c);
        //System.out.println(d);
        //The above part of the code gives an initialization error
    }

    public static void main(String[] args) {
        incremental1a p = new incremental1a();
        p.display1();
        p.display2();

    }

}

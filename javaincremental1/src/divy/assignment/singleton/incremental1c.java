package divy.assignment.singleton;

/**
 * Create another class in package yourname.assignment.singleton containing a non static String member variable.
 * Add a static method that takes String as parameter and initialize the member variable and then return object of that class.
 * Add a non static method to print the String.
 */
public class incremental1c {
    private String s;

    public incremental1c(String s) {
        this.s = "divy";
    }

    static incremental1c objret(String l) {
        //this.s=l;
        //cannot be referenced from a static context
        return new incremental1c(l);
    }

    public void display() {

        System.out.println(s);
    }

    public static void main(String[] args) {
        incremental1c a = objret("hola");
        a.display();
    }
}

package divy.assignment.main;

import divy.assignment.data.incremental1a;
import divy.assignment.singleton.incremental1c;

/**
 * Create main class in package yourname.assignment.main, create
 * object of first class and call both the methods to print the values. Create object of second class using static method and then call the other method
 * to print the String.
 */

public class incremental1b {
    static incremental1c objoftwo(String s) {
        return new incremental1c(s);
    }

    public static void main(String[] args) {
        incremental1a obj = new incremental1a();
        incremental1b obj2 = new incremental1b();

        obj.display1();
        obj.display2();
        objoftwo("hola").display();
    }
}
package increment3;

/**
 * Create a class with an inner class that has a non-default
 * constructor (one that takes arguments). Create a second class with an inner class that inherits
 * from the first inner class.
 */
class class1 {
    public void Display() {
    }

    static class Innerclass1 {
        private int n;

        public Innerclass1(int n) {
            this.n = n;
        }

        public void Display() {
            System.out.println(n);
        }

    }
}

class class2 extends class1 {
    class Innerclass2 extends Innerclass1 {

        public Innerclass2() {
            super(1);
        }
    }
}


public class incement3e {
    public static void main(String[] args) {
        class2 obj = new class2();
        obj.Display();

    }
}

package increment3;

/**
 * Create three interfaces, each with two methods. Inherit a new interface that combines the three, adding a new method.
 * Create a class by implementing the new interface and also inheriting from a concrete class. Now write four methods,
 * each of which takes one of the four interfaces as an argument. In main( ), create an object of your class and pass it
 * to each of the methods.
 */

interface A {
    void u();
    void v();
}

interface B {
    void w();
    void x();
}

interface C {
    void y();
    void z();
}

interface E extends A, B, C {
    void zz();
}

class D {
    private int i = 0;
    public void d() {}
}

class F extends D implements E {
    private int j = 0;
    public void u() {}
    public void v() {}
    public void w() {}
    public void x() {}
    public void y() {}
    public void z() {}
    public void zz() {}
}

public class increment3c {
    public static void m1(A a) { a.v(); }
    public static void m2(B b) { b.w(); }
    public static void m3(C c) { c.y(); }
    public static void m4(E e) { e.zz(); }
    public static void main(String[] args) {
        F anes = new F();
        m1(anes);
        m2(anes);
        m3(anes);
        m4(anes);
    }
}

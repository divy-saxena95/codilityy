package increment3;

/**
 * Create a Cycle interface, with
 * implementations Unicycle, Bicycle and Tricycle. Create factories for each type of Cycle,
 * and code that uses these factories.
 */

interface Cycle1{
        void ride();
        }
interface CycleFactory1{
    Cycle1 getCycle();
}

class Unicycle1 implements Cycle1{
    public void ride(){
        System.out.println("Riding Uni");
    }
}
class UniFactory1 implements CycleFactory1{
    public Cycle1 getCycle(){
        return new Unicycle1();
    }
}

class Bicycle1 implements Cycle1{
    public void ride(){
        System.out.println("Riding Bi");
    }
}
class BiFactory1 implements CycleFactory1{
    public Cycle1 getCycle(){
        return new Bicycle1();
    }
}

class Tricycle1 implements Cycle1{
    public void ride(){
        System.out.println("Riding Tri");
    }
}
class TriFactory1 implements CycleFactory1{
    public Cycle1 getCycle(){
        return new Tricycle1();
    }
}

public class increment3d {
    public static void rideCycle(CycleFactory1 factory){
        Cycle1 c = factory.getCycle();
        c.ride();
    }
    public static void main(String[] args) {
        rideCycle(new UniFactory1());
        rideCycle(new BiFactory1());
        rideCycle(new TriFactory1());
    }
}

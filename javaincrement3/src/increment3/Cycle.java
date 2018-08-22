package increment3;

/**
 *  Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle,
 *  but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try
 *  to call balance( ) on each element of the array and observe the results. Downcast and call balance( )
 *  and observe what happens.
 */

class cycle {
}
class Unicycle extends cycle{
    public void balance() {
        System.out.println("Balancing on " + this);
    }
}
    class Bicycle extends cycle{
public void balance() {
        System.out.println("Balancing on " + this);
        }
        }
        class Tricycle extends cycle{

        }
        public class Cycle{
        public static void main(String[] args)
        {
            //upcasting
            cycle[] cycles = {new Unicycle(),new Bicycle(),new Tricycle()};
            for (cycle cycle1 : cycles) {
               // cycle1.balance();
                //parent class is not able to access the functions of child class
            }

            //downcasting
            Unicycle a= (Unicycle) cycles[1];
            a.balance();
            Bicycle b=(Bicycle) cycles[2];
            b.balance();
            Tricycle c=(Tricycle) cycles[3];
            //c.balance(); //balance function not present in tricycle and hence cannot be accessed
        }


        }

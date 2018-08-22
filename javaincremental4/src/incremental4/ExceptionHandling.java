package incremental4;

/**
 * Create three new types of exceptions. Write a class with a method that throws all three. In main( ),
 * call the method but only use a single catch clause that will catch all three types of exceptions.
 * Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 */
public class ExceptionHandling {
    public void ThrowExceptions(String a, String b, String c) throws Exception {

        if(!a.equalsIgnoreCase("Divy"))
            throw new Exception1("Incorrect name");
        if(!b.equalsIgnoreCase("Hyderabad"))
            throw new Exception2("Incorrect source");
        if(!c.equalsIgnoreCase("Pune"))
            throw new Exception3("Incorrect Destination");
    }
    public static void main(String[] args) {

        ExceptionHandling exceptionHandling = new ExceptionHandling();
        try {
            exceptionHandling.ThrowExceptions("Divy", "Hyderabad", "Pune");
            exceptionHandling.ThrowExceptions("Divy", "Delhi", "Bengaluru");
            exceptionHandling.ThrowExceptions("Kartikay", "Bengaluru", "Hyderabad");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("finally clause has been executed.");    //execution of finally clause
        }
    }
}

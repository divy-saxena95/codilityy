package incremental6;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class increment6{
    public static void main(String[] args) {
        // First, show some use cases for SListIterator
        System.out.println("Demonstrating SListIterator...");
        SList<String> sl = new SList<String>();
        System.out.println(sl);
        SListIterator<String> slit = sl.iterator();
        slit.add("One");
        slit.add("Two");
        slit.add("Three");
        System.out.println(slit.hasNext());
        System.out.println(sl);
        slit = sl.iterator();
        slit.add("Four");
        for(; slit.hasNext();)
            System.out.println(slit.next());
        System.out.println(sl);
        slit = sl.iterator();
        System.out.println(slit.next());
        slit.remove();
        System.out.println(slit.next());
        System.out.println(sl);
        // Now, show the same use cases for ListIterator, too
        System.out.println("\nDemonstrating ListIterator...");
        List<String> l = new ArrayList<String>();
        System.out.println(l);
        ListIterator<String> lit = l.listIterator();
        lit.add("One");
        lit.add("Two");
        lit.add("Three");
        System.out.println(lit.hasNext());
        System.out.println(l);
        lit = l.listIterator();
        lit.add("Four");
        for(; lit.hasNext();)
            System.out.println(lit.next());
        System.out.println(l);
        lit = l.listIterator();
        System.out.println(lit.next());
        lit.remove();
        System.out.println(lit.next());
        System.out.println(l);
    }
}

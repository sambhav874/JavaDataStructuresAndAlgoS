package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collections_1 {

    public interface Collections<E>{
    //Generics enable types (classes and interfaces) to be parameters while defining classes, interfaces and methods.

    }

    //The <E> here is a type parameter.
    // Like formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs.
    public static void main(String[] args){
        //The following example explains the use of generic and type parameter.
        Collection<String> list5 = new ArrayList<String>();
        list5.add("hello");



            //The following example is the formal parameter type which is used to build interface as the regular way.
        List list1 = new ArrayList();
        list1.add("hello");
        String s = (String) list1.get(0);


            //The following example explains the advantage of using generics in the code where we don't have to type the type every time we use a function.
        List<String> list2 = new ArrayList<String>();
        list2.add("hello");
        String b = list2.get(0); // no typecast required
    }
}
//Code that uses generics have many advantages over the non generic code:

//-Stronger type checks at compile time.
//--A Java compiler applies strong type checking to generic code and gives errors if the code violates type safety. This helps in  fixing errors much earlier as they are caught during compile time.

//-Elimination of casts

//-Enabling programmers to implement generic algorithms.
//--By using generics, programmers can implement a single algorithm for a task that works on collections of different types instead of creating algorithms for each type.
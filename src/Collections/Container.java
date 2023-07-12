package Collections;

public class Container {
    private Object object;

    public void set(Object object){
        this.object=object;
    }
    public Object get(){
        return object;
    }
    //The non generic type contains Object of any data type.
    //Since its methods accept or return an Object, you can pass whatever you want but there is no way to verify at compile time, how the class is being used. Someone may place an Integer in the container and expect to get Integers out of it, while someone else may pass in a String resulting in a runtime error.

}

//A typical generic code looks like:class name<T1, T2, ..., Tn> { /* ... */ }
//The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ... and Tn.


class Contain<T>{
    //here T is any datatype
    private T t;

    void setT(T t){
        this.t=t;
    }

    T getT(){
        return t;
    }

//all occurrences of Objects are replaced by T.
//
//A type variable can be any non-primitive type you specify, any class type, any interface type, any array type or even another type variable.
//
//This same technique can be applied to create generic interfaces as well.

    public static void main(String[] args){
        //To reference the generic Container class from within your code, you must perform a generic type invocation, which replaces T with some concrete value, such as Integer:
        //Generic type invocation can be considered as being similar to an ordinary method invocation but instead of passing an argument to a method, you are passing a type argument to the Container class itself — Integer in this case.
        Contain<Integer> integerContainer;

        //To initialize the class, you can use the new keyword as usual, but you need to place <Integer> between the class name and the parenthesis:
        Contain<Integer> intContainer=new Contain<Integer>();

        //In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a generic class with an empty set of type arguments (<>).
        //you can create an instance of Container<Integer> with the following statement:
        Contain<String> stringContainer=new Contain<>();

    }
}

class ContainTesting{
    public static void main(String[] args){
        Contain<String> samContainer=new Contain<>();
        samContainer.setT("Hello");
        System.out.println("Inside the samContainer: "+samContainer.getT());

        Contain<Integer> samContainer1=new Contain<>();
        samContainer1.setT(30706);
        System.out.println("Inside the samContainer1: "+samContainer1.getT());
    }
}
//Type parameter naming conventions:
///By convention, type parameter names are single, uppercase letters.

///The most commonly used type parameter names are:
/////Element (used extensively by the Java Collections Framework)
/////Key
/////Number
/////Type

class tester{
    static <E> void method() {

        }
    }
//In addition to generic types, type parameters can also be used to define generic methods.
//
//Generic methods are methods that introduce their own type parameters.
//
//This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared. You can create static and non-static generic methods and generic constructors.
//
//The syntax for a generic method includes a list of type parameters inside angle brackets which appears before the method's return type.

class GenericDemo{

    //Generic Method
    public static <E> void display(E[] arr) {
        for (E element : arr) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        String[] names= { "Luke", "Mia", "Mathew" };
        display(names);

        System.out.println();

        Integer[] numbers = { 1, 2, 3, 4, 5 };
        display(numbers);

    }

}
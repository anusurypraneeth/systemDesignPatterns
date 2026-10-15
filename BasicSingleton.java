class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("This is Constructor");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // lazy init
        }
        return instance;
    }
}

public class BasicSingleton {

    public static void main(String[] args) {

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2); // true
    }
}
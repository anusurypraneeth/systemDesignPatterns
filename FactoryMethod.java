// Product Interface
interface Burger {
    void prepare();
}

// ================== McDonald's Burgers ==================

class McVegBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing McDonald's Veg Burger");
    }
}

class McChickenBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing McDonald's Chicken Burger");
    }
}

// ================== KFC Burgers ==================

class KFCVegBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing KFC Veg Burger");
    }
}

class KFCChickenBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing KFC Chicken Burger");
    }
}

// ================== Abstract Creator ==================

abstract class BurgerStore {

    // Factory Method
    abstract Burger createBurger(String type);

    // Common workflow (Template Method)
    public Burger orderBurger(String type) {
        Burger burger = createBurger(type);

        if (burger != null) {
            burger.prepare();
        } else {
            System.out.println("Invalid burger type");
        }

        return burger;
    }
}

// ================== Concrete Factory 1 ==================

class McDonaldsStore extends BurgerStore {

    public Burger createBurger(String type) {

        if (type.equalsIgnoreCase("veg")) {
            return new McVegBurger();
        } 
        else if (type.equalsIgnoreCase("chicken")) {
            return new McChickenBurger();
        } 
        else {
            return null;
        }
    }
}

// ================== Concrete Factory 2 ==================

class KFCStore extends BurgerStore {

    public Burger createBurger(String type) {

        if (type.equalsIgnoreCase("veg")) {
            return new KFCVegBurger();
        } 
        else if (type.equalsIgnoreCase("chicken")) {
            return new KFCChickenBurger();
        } 
        else {
            return null;
        }
    }
}

// ================== Main Class ==================

public class FactoryMethod {
    public static void main(String[] args) {

        BurgerStore mcStore = new McDonaldsStore();
        BurgerStore kfcStore = new KFCStore();

        System.out.println("=== McDonald's Order ===");
        mcStore.orderBurger("veg");
        mcStore.orderBurger("chicken");

        System.out.println("\n=== KFC Order ===");
        kfcStore.orderBurger("veg");
        kfcStore.orderBurger("chicken");
    }
}

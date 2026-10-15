// ================== Product Interfaces ==================

interface Burger {
    void prepare();
}

interface Drink {
    void serve();
}

// ================== McDonald's Products ==================

class McVegBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Mc Veg Burger");
    }
}

class McChickenBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Mc Chicken Burger");
    }
}

class McCoke implements Drink {
    public void serve() {
        System.out.println("Serving Mc Coke");
    }
}

// ================== KFC Products ==================

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

class KFCPepsi implements Drink {
    public void serve() {
        System.out.println("Serving KFC Pepsi");
    }
}

// ================== Abstract Factory ==================

interface MealFactory {
    Burger createBurger(String type);
    Drink createDrink();
}

// ================== Concrete Factory: McDonald's ==================

class McDonaldsFactory implements MealFactory {

    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("veg")) {
            return new McVegBurger();
        } 
        else {
            return new McChickenBurger();
        }
    }

    public Drink createDrink() {
        return new McCoke();
    }
}

// ================== Concrete Factory: KFC ==================

class KFCFactory implements MealFactory {

    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("veg")) {
            return new KFCVegBurger();
        } 
        else {
            return new KFCChickenBurger();
        }
    }

    public Drink createDrink() {
        return new KFCPepsi();
    }
}

// ================== Client ==================

class MealOrder {

    private Burger burger;
    private Drink drink;

    public MealOrder(MealFactory factory, String type) {
        burger = factory.createBurger(type);
        drink = factory.createDrink();
    }

    public void serveMeal() {
        burger.prepare();
        drink.serve();
    }
}

// ================== Main ==================

public class AbstractFactory {
    public static void main(String[] args) {

        System.out.println("=== McDonald's Meal ===");
        MealFactory mcFactory = new McDonaldsFactory();
        MealOrder mcMeal = new MealOrder(mcFactory, "veg");
        mcMeal.serveMeal();

        System.out.println("\n=== KFC Meal ===");
        MealFactory kfcFactory = new KFCFactory();
        MealOrder kfcMeal = new MealOrder(kfcFactory, "chicken");
        kfcMeal.serveMeal();
    }
}

interface Burger{
    void prepare();
}

class VegBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Veg Burger");
    }
}

class ChickenBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Chicken Burger");
    }
}

class CheeseBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Cheese Burger");
    }
}

class BurgerFactory{
    public static Burger getBurger(String type){
        if(type.equalsIgnoreCase("veg")){
            return new VegBurger();
        }else if(type.equalsIgnoreCase("chicken")){
            return new ChickenBurger();
        }else if(type.equalsIgnoreCase("cheese")){
            return new CheeseBurger();
        }else{
            throw new RuntimeException("Invalid burger type");
        }
    }
}
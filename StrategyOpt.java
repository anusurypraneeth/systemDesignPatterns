interface  Walkable{
    void walk();
}

interface Flyable{
    void fly();
}

interface Talkable{
    void talk();
}

interface Projectable{
    void project();
}


class NormalWalk implements Walkable{
    @Override
    public void walk(){
        System.out.println("Walking normally");
    }
}

class NoWalk implements Walkable{
    @Override
    public void walk(){
        System.out.println("Cannot walk");
    }
}


class FlyWithWings implements Flyable{
    @Override
    public void fly(){
        System.out.println("Flying with wings");
    }
}

class NoFly implements Flyable{
    @Override
    public void fly(){
        System.out.println("Cannot fly");
    }
}

class Speak implements Talkable{
    @Override
    public void talk(){
        System.out.println("Talking...");
    }
}

class NoTalk implements Talkable{
    @Override
    public void talk(){
        System.out.println("Cannot talk");
    }
}

class HologramProject implements Projectable{
    @Override
    
    public void project(){
        System.out.println("Projecting hologram");
    }
}

class NoProject implements Projectable{
    @Override
    public void project(){
        System.out.println("No projection capability");
    }
}


class Robot{
    private Walkable walkable;
    private Flyable flyable;
    private Talkable talkable;
    private Projectable projectable;

    public Robot(Walkable w,Flyable f,Talkable t,Projectable p){
        this.walkable=w;
        this.flyable=f;
        this.talkable=t;
        this.projectable=p;
    }

    public void performWalk(){
        walkable.walk();
    }
    public void performFly(){
        flyable.fly();
    }
    public void performTalk(){
        talkable.talk();
    }
    public void performProject(){
        projectable.project();
    }

}

public class StrategyOpt{
    public static void main(String[] args) {
        Robot drone=new Robot(
            new NoWalk(),
            new FlyWithWings(),
            new NoTalk(),
            new NoProject()
            );
        drone.performWalk();
        drone.performFly();
        drone.performTalk();
        drone.performProject();


        Robot assistant=new Robot(
            new NormalWalk(),
            new NoFly(),
             new Speak(),
            new HologramProject());
        
        assistant.performWalk();
        assistant.performFly();
        assistant.performTalk();
        assistant.performProject();
    }
}
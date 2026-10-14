class StrategyBad{
    String type;

    public StrategyBad(String type){
        this.type=type;
    }

    public void walk(){
        System.out.println(type+ " is walking");
    }
    public void talk(){
        System.out.println(type+ " is talking");
    }
    public void fly(){
        if(type.equals("drone")){
            System.out.println("Drone flying");
        }else {
            throw new UnsupportedOperationException("This robot can't fly");
        }
    }
    public void project(){
        if(type.equals("assistant")){
            System.out.println("Assistant project hologram");
        }else{
            throw new UnsupportedOperationException("No projection feature");
        }
    }
}

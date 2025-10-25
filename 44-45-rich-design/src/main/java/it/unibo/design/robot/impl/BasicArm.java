package it.unibo.design.robot.impl;

public class BasicArm {
    private double liftConsumption;
    private double dropConsumption;
    private boolean busy;
    private String name;

    private static final double DEFAULT_LIFT_CONSUMPTION = 0.2;
    private static final double DEFAULT_DROP_CONSUMPTION = 0.1;

    public BasicArm(final String name){
        this.name = name;
        this.liftConsumption = DEFAULT_LIFT_CONSUMPTION;
        this.dropConsumption = DEFAULT_DROP_CONSUMPTION;
    }
    
    public BasicArm(final String name, final double liftConsumption, final double dropConsumption){
        this.name = name;
        this.liftConsumption = liftConsumption;
        this.dropConsumption = dropConsumption;
    }

    /**
     * lifts an obj
     * turns busy true
     * @return true if the action is successful
     */
    public boolean lift(){
        if(isBusy()){
            return false;
        }
        setBusy(true);
        return true;
    }

    /**
     * lifts the obj
     * turns busy false
     * @return true if the action is successful
     */
    public boolean drop(){
        if(!isBusy()){
            return false;
        }
        setBusy(false);
        return true;
    }

    public boolean isBusy(){
        return busy;
    }

    private void setBusy(boolean b){
        busy = b;
    }

    public double getLiftConsumption(){
        return this.liftConsumption;
    }

    public double getDropConsumption(){
        return this.dropConsumption;
    }

    public String getName(){
        return this.name;
    }
}

package it.unibo.design.robot.impl;

public class BasicArm {
    private double liftConsumption;
    private double dropConsumption;
    private boolean busy;

    public BasicArm(final double liftConsumption, final double dropConsumption){
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
        if(isBusy()){
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
}

package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
    private BasicArm arm1;
    private BasicArm arm2;
    private int carriedItemsCount;

    public RobotWithTwoArms(final String robotName){
        super(robotName);
        arm1 = new BasicArm("left");
        arm2 = new BasicArm("right");
    }

    public RobotWithTwoArms(final String robotName, final double liftConsumption, double dropConsumption){
        super(robotName);
        arm1 = new BasicArm("left", liftConsumption, dropConsumption);
        arm2 = new BasicArm("right", liftConsumption, dropConsumption);
    }

    /**
     * picks an object
     * arm1 has priority
     * @return returns true if the action is successful
     */
    public boolean pickUp(){
        if (isToobusy()){
            log("Can not pick up, i have all my arms busy");
            return false;
        }
        if (!arm1.isBusy()){
            return doLift(arm1);
        }
        if (!arm2.isBusy()){
            return doLift(arm2);
        }
        return false;
    }
    /**
     * drops an object
     * arm1 has priority
     * @return returns true if the action is successful
     */
    public boolean dropDown(){
        if (arm1.isBusy()){
            return doDropDown(arm1);
        } 
        if (arm2.isBusy()){
            return doDropDown(arm2);
        }
        log("I have nothing to drop");
        return false;
    }

    /**
     * 
     * @return carried items count
     */
    public int getCarriedItemsCount(){
        return carriedItemsCount;
    }

    private boolean isToobusy(){
        return arm1.isBusy() && arm2.isBusy();
    }

    private boolean doLift(BasicArm arm){
        if (!isBatteryEnough(arm.getLiftConsumption())){
            log("can not lift this, i'm starving (no battery)");
            return false;
        }
        carriedItemsCount ++;
        return arm.lift();
    }

    private boolean doDropDown(BasicArm arm){
        if (!isBatteryEnough(arm.getLiftConsumption())){
            log("can not drop this, i'm starving (no battery)");
            return false;
        }
        carriedItemsCount --;
        return arm.drop();
    }
}

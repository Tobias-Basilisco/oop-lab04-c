package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot {

    /**
     * picks an object
     * 
     * @return returns true if the action is successful
     */
    boolean pickUp();

    /**
     * drops down an object
     * 
     * @return true if the action is successful
     */
    boolean DropDown();

    /**
     * 
     * @return the number of objects this robot is currently transporting
     */
    int getCarriedItemsCount();

}

package players;

import enums.ActivityType;

/**
 *
 * @author Zsolt
 */
public class Decision {
    
    private Integer raiseAmount;
    private ActivityType type;

    public Decision() {
//        default constructor
    }

    /**
     * The constructor creates a Decision object with the given ActivityType
     * 
     * @param type 
     */
    public Decision(ActivityType type) {
        this.type = type;
    }

    public Integer getRaiseAmount() {
        return raiseAmount;
    }

    public void setRaiseAmount(Integer raiseAmount) {
        this.raiseAmount = raiseAmount;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

}

package players;

import enums.ActivityType;

/**
 *
 * @author Zsolt
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, Double token) {
        super(name, token);
    }

    @Override
    public Decision preFlop() {
//        TODO
        return new Decision(ActivityType.PASS);
    }

    @Override
    public Decision flop() {
//        TODO
        return new Decision(ActivityType.PASS);
    }

    @Override
    public Decision turn() {
//        TODO
        return new Decision(ActivityType.PASS);
    }
}

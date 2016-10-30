package exceptions;

/**
 *
 * @author Zsolt
 */
public class PlayerIsOutOfMoneyException extends RuntimeException {

    public PlayerIsOutOfMoneyException() {
//        default constructor
    }

    public PlayerIsOutOfMoneyException(String message) {
        super(message);
    }

}

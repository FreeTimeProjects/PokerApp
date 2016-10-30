package exceptions;

/**
 *
 * @author Zsolt
 */
public class TooFewPlayersException extends Exception {

    public TooFewPlayersException() {
//        default constructor
    }

    public TooFewPlayersException(String message) {
        super(message);
    }

}

package exceptions;

/**
 *
 * @author Zsolt
 */
public class NoRoleFoundAtPlayersException extends RuntimeException {

    public NoRoleFoundAtPlayersException() {
//        default constructor
    }

    public NoRoleFoundAtPlayersException(String message) {
        super(message);
    }

}

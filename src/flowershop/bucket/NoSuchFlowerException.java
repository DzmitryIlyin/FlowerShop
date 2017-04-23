package flowershop.bucket;

public class NoSuchFlowerException extends Exception {

    public static final String NO_SUCH_FLOWER_MSG="NO SUCH FLOWER";

    public NoSuchFlowerException() {
        super(NO_SUCH_FLOWER_MSG);
    }

    public NoSuchFlowerException(Throwable cause) {
        super(NO_SUCH_FLOWER_MSG, cause);
    }
}

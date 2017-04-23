package flowershop.bucket;

public class WrongFlowerIndexException extends Exception {

    public static final String WRONG_FLOWER_INDEX_MSG="NO SLOTS AVAILABLE";

    public WrongFlowerIndexException() {
        super(WRONG_FLOWER_INDEX_MSG);
    }

    public WrongFlowerIndexException(Throwable cause) {
        super(WRONG_FLOWER_INDEX_MSG, cause);

    }
}

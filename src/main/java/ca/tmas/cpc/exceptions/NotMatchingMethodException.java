package ca.tmas.cpc.exceptions;

public class NotMatchingMethodException extends NoSuchMethodException {

    public NotMatchingMethodException(String msg) {
        super(msg);
    }
}

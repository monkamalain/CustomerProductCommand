package ca.tmas.cpc.exceptions;

import java.util.NoSuchElementException;

public class NotFoundEntityException extends NoSuchElementException {

    public NotFoundEntityException(String msg) {
        super(msg);
    }
}

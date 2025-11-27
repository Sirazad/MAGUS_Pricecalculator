package hu.magus.pricecalculator.exception;

public class NoMaterialFoundException extends RuntimeException {
    public NoMaterialFoundException(String message) {
        super(message);
    }
}

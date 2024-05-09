package model.exceptions;

public class NotEnoughBalanceException extends Exception{
    public NotEnoughBalanceException(String message) {
        super(message);
    }
    public NotEnoughBalanceException() {
        super("Not Enough Balance");
    }
}

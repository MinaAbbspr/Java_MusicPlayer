package exceptions;

public class NotEnoughBalanceException extends Exception{
    public NotEnoughBalanceException() {
        super("Not Enough Balance");
    }
}

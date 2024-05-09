package model;

public enum Subscription {
    Package30Days(5,30), Package60Days(9,60),Package180Days(14,180);

    private final int fee;
    private final int days;
    Subscription(int fee, int days){
        this.fee = fee;
        this.days = days;
    }
    public int getFee() {
        return fee;
    }
    public int getDays() {
        return days;
    }
}

package models;

public abstract class Conversion {
    protected double amount;
    protected String original_value;
    protected String target_value;

    public abstract double cover(double amount, String original_value, String target_value);


}

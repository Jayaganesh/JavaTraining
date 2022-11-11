package chapter4;

public class Pricing {

    public double price(double amount, Size size) {
        if (size == Size.SMALL) {
            return amount * 1.2;
        } else if(size == Size.MEDIUM) {
            return amount;
        } else {
            return amount * 0.8;
        }
    }
}

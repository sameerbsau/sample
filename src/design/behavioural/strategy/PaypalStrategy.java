package design.behavioural.strategy;

public class PaypalStrategy implements PaymentStrategy{

    private String userId;
    private String password;

    public PaypalStrategy(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("payment is done using payment for amount"+ amount);
    }
}
package design.strategy;

public class Test {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("12345",50);
        Item item2 = new Item("54321",25);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by credit card
        cart.pay(new CreditCardStrategy("sameer","999999999","123","12/03/25"));

        //pay using paypal
        cart.pay(new PaypalStrategy("sameer","sameer123"));
    }
}

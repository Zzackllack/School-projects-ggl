// Suggested code may be subject to a license. Learn more: ~LicenseLog:256002193.
public class Pizzatest {
    public static void main (String[] args){

        Pizza pizza1 = new Pizza();
        pizza1.name = "Margherita";
        System.out.println(pizza1.getName());

        Pizza pizza2 = new Pizza();
        pizza2.setName("Pepperoni");
        System.out.println(pizza2.getName());
    }
}
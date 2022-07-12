import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void CreateCartTest(){
      ShoppingCart shoppingCart = new ShoppingCart();
        int newCartCount = shoppingCart.getItemCount();
        System.out.println("Create Cart Test");
        System.out.printf("Item Count: " + newCartCount);
        System.out.println();
        System.out.println("-----");
        assertEquals("When created, the cart has 0 items", 0, newCartCount);
    }

    @Test
    public void addItemsTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Product p1 = new Product("Pineapple", 1.99);
        Product p2 = new Product("Strawberries", 2.99);
        Product p3 = new Product("Blackberries", 3.99);

        shoppingCart.addItem(p1);
        System.out.println("Add Items Test 1");
        System.out.printf("Item Count " + shoppingCart.getItemCount());
        System.out.println();

        shoppingCart.addItem(p2);
        System.out.println("Add Items Test 2");
        System.out.printf("Item Count " + shoppingCart.getItemCount());
        System.out.println();

        shoppingCart.addItem(p3);
        System.out.println("Add Items Test 3");
        System.out.printf("Item Count " + shoppingCart.getItemCount());
        System.out.println();

        int cartCount = shoppingCart.getItemCount();
        System.out.println("-----");
        assertEquals("Items added: ", 3, cartCount);
    }

    @Test
    public void removeItemsTest() throws ProductNotFoundException {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product p1 = new Product("Pineapple", 1.99);
        Product p2 = new Product("Strawberries", 2.99);
        Product p3 = new Product("Blackberries", 3.99);

        shoppingCart.addItem(p1);
        shoppingCart.addItem(p2);
        shoppingCart.addItem(p3);

        int ogCount = shoppingCart.getItemCount();
        shoppingCart.removeItem(p1);
        System.out.println("Remove Items Test 1");
        System.out.printf("Item Count: " + shoppingCart.getItemCount());
        System.out.println();
        assertEquals("Items removed ", ogCount-1, shoppingCart.getItemCount());

        shoppingCart.removeItem(p2);
        assertEquals("Items removed ", ogCount-2, shoppingCart.getItemCount());
        System.out.println("Remove Items Test 2");
        System.out.printf("Item Count: " + shoppingCart.getItemCount());
        System.out.println();


        shoppingCart.removeItem(p3);
        assertEquals("Items removed ", ogCount-3, shoppingCart.getItemCount());
        System.out.println("Remove Items Test 3");
        System.out.printf("Item Count: " + shoppingCart.getItemCount());
        System.out.println();

        System.out.println("-----");
    }

    @Test
    public void emptyCartTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Product p1 = new Product("Pineapple", 1.99);
        Product p2 = new Product("Strawberries", 2.99);
        Product p3 = new Product("Blackberries", 3.99);

        shoppingCart.addItem(p1);
        shoppingCart.addItem(p2);
        shoppingCart.addItem(p3);

        shoppingCart.empty();
        System.out.println("Empty Cart Test 1");
        System.out.printf("Item Count: " + shoppingCart.getItemCount());
        System.out.println();
        assertEquals("Empty Cart", 0, shoppingCart.getItemCount());


        shoppingCart.empty();
        System.out.println("Empty Cart Test 2");
        System.out.printf("Item Count: " + shoppingCart.getItemCount());
        System.out.println();
        assertEquals("Empty Cart again", 0, shoppingCart.getItemCount());
        System.out.println("-----");
    }
}

public class Main {

    public static void main(String[] args) {
        Product product = new Product();
        product.name = "product";
        product.price = 10;

        ProductManager manager = new ProductManager();
        manager.add(product);

        
    }
}

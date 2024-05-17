import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Book", 251));
        products.add(new Product("Book", 150));
        products.add(new Product("Toy", 300));
        products.add(new Product("Book", 400));
        products.add(new Product("Toy", 335));
        products.add(new Product("Car", 400));
        Thread.sleep(5600);
        products.add(new Product("Book", 555, true));
        Thread.sleep(1300);
        products.add(new Product("Book", 44, false));
        Thread.sleep(2200);
        products.add(new Product("Book", 250, true));
        Thread.sleep(4400);
        products.add(new Product("Book", 33, false));
        Thread.sleep(3300);
        //Task #1
        expensiveBooks(products);
        //Task #2
        discountBook(products);
        //Task #3
        cheapestBook(products);
        //Task #4
        latestAddedProducts(products);
        //Task #5
        totalCostProducts(products);
    }

    public static void expensiveBooks(ArrayList<Product> products) {
        ArrayList<Product> expensiveBooks = products.stream()
                .filter(product -> (product.getProductType().equals("Book") && product.getProductPrice() > 250.0))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Books price more than 250.0: ");
        expensiveBooks.forEach(System.out::println);
    }


    public static void discountBook(ArrayList<Product> products) {
        ArrayList<Product> discountBooks = products.stream()
                .filter( product -> product.getProductType().equals("Book") && product.hasDiscount())
                .map(product -> new Product(product.getProductType(),
                                            product.getProductPrice() * 0.9,
                                            product.hasDiscount()))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Books with discount");
        discountBooks.forEach(System.out::println);
    }

    public static void cheapestBook(ArrayList<Product> products) {
        Product cheapestBook = products.stream()
                .filter(product -> product.getProductType().equals("Book"))
                .min(Comparator.comparing(Product::getProductPrice))
                .orElseThrow(() -> new NoSuchElementException("Category [Book] not found"));

        System.out.println("Cheapest Book");
        System.out.println(cheapestBook);
    }

    public static void latestAddedProducts(ArrayList<Product> products) {
        ArrayList<Product> latestProducts = products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Latest three added products");
        latestProducts.forEach(System.out::println);
    }

    public static void totalCostProducts(ArrayList<Product> products) {
        double totalPrice = products.stream()
                .filter(product -> product.getDateAdded().getYear() == Year.now().getValue()
                        && product.getProductType().equals("Book") && product.getProductPrice() <= 75)
                .mapToDouble(Product::getProductPrice).sum();
        System.out.println("Total cost of book with price cheaper then 75:" + totalPrice);

    }
}
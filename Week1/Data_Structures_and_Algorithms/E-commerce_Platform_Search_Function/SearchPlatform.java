import java.util.Arrays;

public class SearchPlatform {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; 
            }
        }
        return null; 
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductId() == targetId) {
                return midProduct; 
            }
            
            if (midProduct.getProductId() < targetId) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        Product[] catalog = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Running Shoes", "Apparel"),
            new Product(108, "Coffee Maker", "Home Appliances"),
            new Product(102, "Mechanical Keyboard", "Electronics"),
            new Product(104, "Yoga Mat", "Fitness")
        };

        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(catalog, 108);
        System.out.println("Result for ID 108: " + (foundLinear != null ? foundLinear : "Not found"));

        Arrays.sort(catalog); 

        System.out.println("\n--- Binary Search ---");
        Product foundBinary = binarySearch(catalog, 104);
        System.out.println("Result for ID 104: " + (foundBinary != null ? foundBinary : "Not found"));
    }
}
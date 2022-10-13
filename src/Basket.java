import java.io.*;
import java.util.Scanner;

public class Basket {
    protected String[] products;
    protected int[] prices;
    protected int[] basket = new int[3];
    protected File file = new File("basket.txt");

    public Basket() {
        this.products = new String[]{"Хлеб", "Молоко", "Масло"};
        this.prices = new int[]{49, 89, 129};
    }

    public Basket(String[] products, int[] prices, int[] basket) {
        this.products = products;
        this.prices = prices;
        this.basket = basket;
    }

    public void addToCart(int productNum, int amount) {
        basket[productNum - 1] += amount;
    }

    public void printCart() {
        int sumProducts = 0;
        System.out.println("Ваша корзина:");
        System.out.println();
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] <= 0) {
                continue;
            }
            int priceProduct = basket[i] * prices[i];
            sumProducts += priceProduct;
            System.out.println(products[i] + ": " + basket[i] + "шт " + prices[i] + " шт/руб; " + "Итого: " + priceProduct + "руб.");
        }
        System.out.println("Сумма корзины: " + sumProducts + "руб.");
    }

    public File getFile() {
        return file;
    }

    public void saveTxt(File textFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(textFile)) {
            for (String product : products) {
                writer.print(product + " ");
            }
            writer.print("\n");
            for (int price : prices) {
                writer.print(price + " ");
            }
            writer.print("\n");
            for (int i : basket) {
                writer.print(i + " ");
            }
        }
    }

    public static Basket loadFromTxtFile(File textFile) throws Exception {
        try (InputStream ins = new FileInputStream(textFile)) {
            Scanner scanner = new Scanner(ins);
            String[] products = scanner.nextLine().trim().split(" ");
            String[] pricesS = scanner.nextLine().trim().split(" ");
            int[] prices = new int[pricesS.length];
            for (int i = 0; i < pricesS.length; i++) {
                prices[i] = Integer.parseInt(pricesS[i]);
            }
            String[] basketS = scanner.nextLine().trim().split(" ");
            int[] basket = new int[basketS.length];
            for (int i = 0; i < basketS.length; i++)
                basket[i] = Integer.parseInt(basketS[i]);
            return new Basket(products, prices, basket);
        }
    }

    @Override
    public String toString() {
        System.out.println("Список товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println("Товар:" + " " + products[i] + " " + prices[i] + "руб.");
        }
        return "";

    }
}

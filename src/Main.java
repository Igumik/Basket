public class Main {
    public static void main(String[] args) throws Exception {

        Basket basket = new Basket();
        System.out.println(basket);
        if (basket.getFile().exists()) {
            basket = Basket.loadFromBinFile(basket.getFile());
            basket.printCart();
        } else {
            basket.addToCart(1, 20);
            basket.saveBin(basket.getFile());
            basket.addToCart(2, 3);
            basket.saveBin(basket.getFile());
            basket.addToCart(3, 2);
            basket.saveBin(basket.getFile());
            basket.printCart();
        }
    }
}
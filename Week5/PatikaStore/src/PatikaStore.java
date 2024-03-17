import java.util.Scanner;

public class PatikaStore {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli");

            System.out.println("1 - Notebook ");
            System.out.println("2 - Mobile Phone");
            System.out.println("3 - Markaları Listele");
            System.out.println("0 - Exit");

            System.out.print("Seçiminiz: ");
            int select = scanner.nextInt();

            String[] brands = { "Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster" };

            int index = 0;
            for (String brand : brands) {
                Brands.addBrand(brand, index++);
            }

            boolean isExit = false;
            switch (select) {
                case 1:
                    System.out.println("1 is chosen");
                    Product.menu(1);
                    break;

                case 2:
                    System.out.println("2 is chosen");
                    Product.menu(2);
                    break;

                case 3:
                    Brands.printBrands();
                case 0:
                    isExit = true;
                default:
                    System.out.println();
                    System.out.println();
                    System.out.println();

            }

            if (isExit) {
                System.out.println();
                System.out.println("Mağazadan ayrıldınız tekrar görüşürüz.");
                return;
            }
        }

    }
}
import java.util.LinkedHashMap;

public class Brands implements Comparable{
    private int id;
    private String brandName;
    private static String[] brands = new String[9];
    private static LinkedHashMap<String, Integer> nameId = new LinkedHashMap<>();
    private Product product;

    public Brands(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public static void printBrands() {
        compare(brands);

        System.out.println();
        System.out.println("MARKALAR");
        System.out.println("----------------------------");
        for (String brand : brands) {
            System.out.println("- " + brand);
        }
        System.out.println();

    }

    private static void compare(String[] brands) {
        for (int i = 0; i < brands.length; i++) {
            String first = brands[i];
            int index = i;
            for (int j = i + 1; j < brands.length; j++) {
                int result = first.compareTo(brands[j]);
                if (result > 0) {
                    first = brands[j];
                    index = j;
                }
            }
            String temp = brands[i];
            brands[i] = first;
            brands[index] = temp;

        }
    }

    @Override
    public int compareTo(Object o) {
        return getBrandName().compareTo(brandName);
    }

    public String getBrandName() {
        return brandName;
    }

    public static void addBrand(String brand, int index) {
        brands[index] = brand;
        nameId.put(brand, (index + 1));

    }
}
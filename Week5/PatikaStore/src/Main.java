import java.util.*;


public class Main {

    public static void main(String[] args) {

        // Sadece marka listelemeleri için ana değişkenler
        String brandName = "";
        String pcBrandName = "";

        Scanner scanner = new Scanner(System.in);

        // Telefon marka listesi
        Map<Integer, String> phoneBrand = new TreeMap<>();

        // Notebook marka listesi
        Map<Integer, String> bookBrand = new TreeMap<>();

        // Telefon Listesi
        TreeMap<Integer, Phone> phone = new TreeMap<>();

        // Notebook listesi
        TreeMap<Integer, Notebook> notebook = new TreeMap<>();

        int choice;

        System.out.println("PATİKA STORE ÜRÜN YÖNETİM PANELİ");

        // İşlem menüsü döngüsü
        while (true) {
            System.out.println(
                    "1 - Notebook İşlemleri\n" +
                            "2 - Cep Telefonu İşlemleri\n" +
                            "3 - Telefon Markaları Listele\n" +
                            "4 - Notebook Markaları Listele\n" +
                            "5 - Silme İşlemleri\n" +
                            "0 - Çıkış");

            // Menü seçim sorgusu
            try {
                choice = scanner.nextInt();

                // Menü seçim koşulları
                if (choice <= 5 && choice >= 0) {

                    // Notebook ekleme bloğu
                    if (choice == 1) {
                        System.out.print("ID : ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tür : ");
                        String name = scanner.nextLine().toUpperCase();
                        System.out.print("Marka : ");
                        pcBrandName = scanner.nextLine().toUpperCase();
                        System.out.print("Renk : ");
                        String color = scanner.nextLine().toUpperCase();
                        System.out.print("Fiyat : ");
                        int price = scanner.nextInt();
                        System.out.print("İndirim Oranı : ");
                        int sales = scanner.nextInt();
                        System.out.print("Adet : ");
                        int stock = scanner.nextInt();
                        System.out.print("Hafıza : ");
                        int memory = scanner.nextInt();
                        System.out.print("Ekran Boyutu : ");
                        int screen = scanner.nextInt();
                        System.out.print("Ram : ");
                        int ram = scanner.nextInt();

                        notebook.put(id, new Notebook(name, pcBrandName, color, price, sales, stock, memory, screen, ram));
                        bookBrand.put(id, pcBrandName);

                        System.out.println("ÜRÜN BAŞARIYLA EKLENDİ. ÜRÜN VE EKLENEN MARKALARIN LİSTELEMELERİ İÇİN MENÜDEN NOTEBOOK MARKALARI LİSTELE SEKMESİNİ SEÇİNİZ");
                        continue;
                    }
                    // Telefon ekleme bloğu
                    if (choice == 2) {

                        System.out.print("ID : ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tür : ");
                        String name = scanner.nextLine().toUpperCase();
                        System.out.print("Marka : ");
                        brandName = scanner.nextLine().toUpperCase();
                        System.out.print("Renk : ");
                        String color = scanner.nextLine().toUpperCase();
                        System.out.print("Fiyat : ");
                        int price = scanner.nextInt();
                        System.out.print("İndirim Oranı : ");
                        int sales = scanner.nextInt();
                        System.out.print("Adet : ");
                        int stock = scanner.nextInt();
                        System.out.print("Hafıza : ");
                        int memory = scanner.nextInt();
                        System.out.print("Ekran Boyutu : ");
                        int screen = scanner.nextInt();
                        System.out.print("Batarya : ");
                        int battery = scanner.nextInt();
                        System.out.print("Ram : ");
                        int ram = scanner.nextInt();

                        phone.put(id, new Phone(name, brandName, color, price, sales, stock, memory, screen, battery, ram));
                        phoneBrand.put(id, brandName);

                        System.out.println("ÜRÜN BAŞARIYLA EKLENDİ. ÜRÜN VE EKLENEN MARKALARIN LİSTELEMELERİ İÇİN MENÜDEN TELEFON MARKALARI LİSTELE SEKMESİNİ SEÇİNİZ");
                        continue;
                    }

                    // Marka listeleme bloğu - Phone
                    if (choice == 3) {
                        System.out.println("TELEFON MARKALARI\n--------------");
                        for (Map.Entry<Integer, String> entry : phoneBrand.entrySet()) {
                            System.out.println("- " + entry.getValue());
                        }

                        System.out.println();
                        // Tablo çıktısı - Phone
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| KATEGORİ       | MARKA      | RENK   | FİYAT      | İNDİRİM   | STOK | HAFIZA | EKRAN | BATARYA | RAM |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        // Phone listesi toString
                        for (Map.Entry<Integer, Phone> entry : phone.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());

                        }
                        System.out.println();
                        System.out.println("MENÜYE YÖNLENDİRİLİYOR...\n");
                        continue;
                    }

                    // Marka listeleme bloğu - Notebook
                    if (choice == 4) {
                        System.out.println("NOTEBOOK MARKALARI\n--------------");
                        for (Map.Entry<Integer, String> entry : bookBrand.entrySet()) {
                            System.out.println("- " + entry.getValue());
                        }
                        System.out.println();

                        // Tablo çıktısı - Notebook
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| KATEGORİ       | MARKA      | RENK   | FİYAT      | İNDİRİM   | STOK | HAFIZA | EKRAN | BATARYA | RAM |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        // Notebook listesi toString
                        for (Map.Entry<Integer, Notebook> entry : notebook.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());
                        }
                        System.out.println();
                        System.out.println("MENÜYE YÖNLENDİRİLİYOR...\n");
                        continue;
                    }
                    // Silme işlemleri bloğu
                    if (choice == 5) {
                        System.out.println("SİLMEK İSTEDİĞİNİZ KATEGORİYİ SEÇİN\n1 - TELEFON\n2 - NOTEBOOK");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            System.out.println("SİLMEK İSTEDİĞİNİZ ID SEÇİN");
                            System.out.println("ID LİSTESİ :" + phone.keySet());
                            int deletedId = scanner.nextInt();
                            phone.remove(deletedId);
                            phoneBrand.remove(deletedId);
                            continue;
                        }
                        if (choice == 2) {
                            System.out.println("SİLMEK İSTEDİĞİNİZ ID SEÇİN");
                            System.out.println("ID LİSTESİ :" + notebook.keySet());
                            int deletedId = scanner.nextInt();
                            notebook.remove(deletedId);
                            bookBrand.remove(deletedId);
                            continue;
                        }
                    }

                    if (choice == 0) {
                        System.out.println("ÇIKIŞ YAPILIYOR.. BİZİ TERCİH ETTİĞİNİZ İÇİN TEŞEKKÜR EDERİZ");
                        System.exit(0);
                    }
                    break;
                    // Koşul dışı değer sorgu bloğu
                } else {
                    System.out.println("MENÜ 0-5 ARASINDA OLMALIDIR");
                }
            } catch (InputMismatchException e) {
                System.out.println("SAYISAL DEĞER GİRİNİZ");
                scanner.next();
            }
        }
    }
}
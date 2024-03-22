import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
    static Scanner scanner = new Scanner(System.in);
    private static int id;
    private static int idTelefon;
    private static int idNotebook;
    private static double fiyat;
    private static double indirimOrani;
    private static int stok;
    private static String isim;
    private static String marka;
    private static double hafiza;
    private static double ekranBoyutu;
    private static double batarya;
    private static double ram;
    private static String renk;
    private String urunAdi;

    public void setUrunAdi(String urunAdi) {

        this.urunAdi = urunAdi;
    }

    private static HashMap<String, ArrayList<Product>> urunler = new HashMap<>() {
        {
            put("Notebook", new ArrayList<Product>());
            put("MobilTelefon", new ArrayList<Product>());
        }
    };

    public Product(int idTelefon, int idNotebook, double fiyat, double indirimOrani, int stok, String isim, String marka,
                   double hafiza, double ekranBoyutu, double batarya, double ram, String renk) {
        this.idTelefon = idTelefon;
        this.idNotebook = idNotebook;
        this.fiyat = fiyat;
        this.indirimOrani = indirimOrani;
        this.stok = stok;
        this.isim = isim;
        this.marka = marka;
        this.hafiza = hafiza;
        this.ekranBoyutu = ekranBoyutu;
        this.batarya = batarya;
        this.ram = ram;
        this.renk = renk;
    }

    public Product(int idTelefon, int idNotebook, double fiyat, double indirimOrani, int stok, String isim, String marka,
                   double hafiza, double ekranBoyutu, double batarya, double ram) {
        this.idTelefon = idTelefon;
        this.idNotebook = idNotebook;
        this.fiyat = fiyat;
        this.indirimOrani = indirimOrani;
        this.stok = stok;
        this.isim = isim;
        this.marka = marka;
        this.hafiza = hafiza;
        this.ekranBoyutu = ekranBoyutu;
        this.batarya = batarya;
        this.ram = ram;
    }

    public static void menu(int numara) {
        if (numara == 1) {
            System.out.println("Notebook");
        } else {
            System.out.println("Mobil Telefon");
        }
        System.out.println("...................");
        System.out.println("1- Ürünleri Listele");
        System.out.println("2- Ürün Ekle");
        System.out.println("3- Ürün Sil");
        System.out.println("4- Ürünleri Filtrele");
        System.out.println("Seçim yapın");
        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                urunleriListele(numara);
                break;
            case 2:
                urunEkle(numara);
                break;
            case 3:
                urunSil(numara);
                break;
            case 4:
                urunleriFiltrele(numara);
                break;
            default: {
                System.out.println();
                System.out.println("Böyle bir seçenek yok. Lütfen seçiminizi tekrar yapın.");
                menu(numara);
            }
        }
    }

    public static void urunleriListele(int numara) {
        if (numara % 2 != 0) {
            // Notebook
            ArrayList<Product> urunListesi = urunler.get("Notebook");


            if (!urunListesi.isEmpty()) {
                for (Product urun : urunListesi) {
                    String urunAdi = urun.getIsim();
                    urun.setIsim(urunAdi);

                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            urun.getId(), urun.getIsim(), urun.getFiyat(), urun.getIsim(),
                            urun.getHafiza(), urun.getEkranBoyutu(), urun.getRam());
                }
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------");
            }
            System.out.println();

        } else {
            // Mobil telefon


            ArrayList<Product> urunListesi = urunler.get("MobilTelefon");

            if (!urunListesi.isEmpty()) {
                for (Product urun : urunListesi) {
                    String urunAdi = urun.getIsim();
                    urun.setUrunAdi(urunAdi);

                    System.out.printf(
                            "| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n",
                            urun.getId(), urun.getIsim(), urun.getFiyat(), urun.getIsim(),
                            urun.getHafiza(), urun.getEkranBoyutu(), urun.getBatarya(), urun.getRam(),
                            urun.getRenk());
                }
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }

    public static void urunEkle(int numara) {
        System.out.print("Birim Fiyat: ");
        double birimFiyat = scanner.nextDouble();
        System.out.print("İndirim Oranı: ");
        double indirimOrani = scanner.nextDouble();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        System.out.print("Marka: ");
        String marka = scanner.next();
        scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Depolama: ");
        int depolama = scanner.nextInt();
        System.out.print("Ekran Boyutu: ");
        double ekranBoyutu = scanner.nextDouble();
        System.out.print("RAM: ");
        int RAM = scanner.nextInt();

        if (numara % 2 != 0) {
            // Notebook
            idNotebook += 1;
            int id = idNotebook;

            Product yeniNotebook = new Product(idTelefon, idNotebook, fiyat, indirimOrani, stok, isim, marka, hafiza,
                    ekranBoyutu, batarya, ram);
            urunler.get("Notebook").add(yeniNotebook);

        } else {
            // Mobil Telefon
            idTelefon += 1;
            int id = idTelefon;
            System.out.print("Kamera: ");
            int kamera = scanner.nextInt();
            System.out.print("Batarya Kapasitesi: ");
            int bataryaKapasitesi = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Renk: ");
            String renk = scanner.nextLine();

            Product yeniMobilTelefon = new Product(idTelefon, idNotebook, fiyat, indirimOrani, stok, isim, marka, hafiza,
                    ekranBoyutu, batarya, ram, renk);
            urunler.get("MobilTelefon").add(yeniMobilTelefon);

        }
    }

    public static void urunSil(int numara) {
        System.out.print("Silmek için bir ID değeri girin: ");
        int idUrun = scanner.nextInt();
        boolean bulunamadi = true;
        if (numara % 2 != 0) {
            for (Product urun : urunler.get("Notebook")) {
                if (urun.getId() == idUrun) {
                    urunler.get("Notebook").remove(urun);
                    bulunamadi = false;
                    System.out.println("ID'si " + idUrun + " olan ürün sisteme başarıyla silindi.");
                    break;
                }
            }

        } else {
            for (Product urun : urunler.get("MobilTelefon")) {
                if (urun.getId() == idUrun) {
                    urunler.get("MobilTelefon").remove(urun);
                    bulunamadi = false;
                    System.out.println("ID'si " + idUrun + " olan ürün sisteme başarıyla silindi.");
                    break;
                }
            }

        }
        if (bulunamadi) {
            System.out.println("Sistemde belirtilen ID değeri bulunamadı. Lütfen ID'nizi kontrol edip tekrar deneyin...");
        }
    }

    public static void urunleriFiltrele(int numara) {
        System.out.print("Ürünleri filtrelemek için bir ID girin veya bir ID girmek istemiyorsanız '0' girin: ");
        int idUrun = scanner.nextInt();
        boolean idVar = idUrun != 0;

        System.out.print("Ürünleri filtrelemek için bir marka girin veya bir marka girmek istemiyorsanız 'none' girin: ");
        String markaUrun = scanner.next();
        boolean markaVar = !markaUrun.equals("none");

        ArrayList<Product> filtrelenmisUrunler = new ArrayList<>();

        if (numara % 2 != 0) {
            if (idVar && markaVar) {
                for (Product urun : urunler.get("Notebook")) {
                    if (markaUrun.equals(urun.getIsim()) && urun.getId() == idUrun) {
                        filtrelenmisUrunler.add(urun);
                        filtrelenmisUrunleriListele(numara, filtrelenmisUrunler);
                        break;
                    } else {
                        System.out.println(
                                "Belirtilen ID veya marka sistemde bulunamadı. Lütfen ID'nizi veya markanızı kontrol edin ve tekrar deneyin...");
                        urunleriFiltrele(numara);
                    }
                }
            } else {
                if (markaVar) {
                    for (Product urun : urunler.get("Notebook")) {
                        if (markaUrun.equals(urun.getIsim())) {
                            filtrelenmisUrunler.add(urun);
                        }
                    }
                    filtrelenmisUrunleriListele(numara, filtrelenmisUrunler);
                } else {
                    System.out.println(
                            "Marka sistemde bulunamadı. Lütfen markanızı kontrol edin ve tekrar deneyin...\nUYARI: **ID ile birlikte bir marka girmeniz gerekmektedir.**");
                    urunleriFiltrele(numara);
                }
            }

        } else {
            if (idVar && markaVar) {
                for (Product urun : urunler.get("MobilTelefon")) {
                    if (markaUrun.equals(urun.getIsim()) && urun.getId() == idUrun) {
                        filtrelenmisUrunler.add(urun);
                        filtrelenmisUrunleriListele(numara, filtrelenmisUrunler);
                        break;
                    } else {
                        System.out.println(
                                "Belirtilen ID veya marka sistemde bulunamadı. Lütfen ID'nizi veya markanızı kontrol edin ve tekrar deneyin...");
                        urunleriFiltrele(numara);
                    }
                }
            } else {
                if (markaVar) {
                    for (Product urun : urunler.get("MobilTelefon")) {
                        if (markaUrun.equals(urun.getIsim())) {
                            filtrelenmisUrunler.add(urun);
                        }
                    }
                    filtrelenmisUrunleriListele(numara, filtrelenmisUrunler);
                } else {
                    System.out.println(
                            "Marka sistemde bulunamadı. Lütfen markanızı kontrol edin ve tekrar deneyin...\nUYARI: **ID ile birlikte bir marka girmeniz gerekmektedir.**");
                    urunleriFiltrele(numara);
                }
            }
        }
    }

    private static void filtrelenmisUrunleriListele(int numara, ArrayList<Product> filtrelenmisUrunListesi) {
        if (numara % 2 != 0) {
            // Notebook
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Ürün Adı                       | Fiyat              | Marka      | Depolama   | Ekran Boyutu| RAM        |");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------");

            if (!filtrelenmisUrunListesi.isEmpty()) {
                for (Product urun : filtrelenmisUrunListesi) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            urun.getId(), urun.getIsim(), urun.getFiyat(), urun.getIsim(),
                            urun.getHafiza(), urun.getEkranBoyutu(), urun.getRam());
                }
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------");
            }
            System.out.println();

        } else {
            // Mobil telefon
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID | Ürün Adı                       | Fiyat              | Marka      | Depolama   | Ekran Boyutu| Kamera     | Batarya    | RAM        | RENK       |");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (!filtrelenmisUrunListesi.isEmpty()) {
                for (Product urun : filtrelenmisUrunListesi) {
                    System.out.printf(
                            "| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-10s | %-12s | %-10s | %-10s | %-10s |\n",
                            urun.getId(), urun.getIsim(), urun.getFiyat(), urun.getIsim(),
                            urun.getHafiza(), urun.getEkranBoyutu(), urun.getBatarya(), urun.getRam(),
                            urun.getRenk());
                }
                System.out.println(
                        "------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }

    public static double getFiyat() {
        return fiyat;
    }


    public static String getIsim() {
        return isim;
    }

    public static void setIsim(String isim) {
        Product.isim = isim;
    }

    public static double getHafiza() {
        return hafiza;
    }

    public static double getEkranBoyutu() {
        return ekranBoyutu;
    }

    public static double getBatarya() {
        return batarya;
    }

    public static double getRam() {
        return ram;
    }

    public String getRenk() {
        return renk;
    }

    public static int getId() {
        return id;
    }

}
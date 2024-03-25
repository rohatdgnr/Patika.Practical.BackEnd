import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dosyaAdi = "notepadDosyasi.txt";

        String oncekiMetin = dosyadanOku(dosyaAdi);
        System.out.println("Önceki kaydedilen metin: " + oncekiMetin);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Yeni metin giriniz: ");
        String yeniMetin = scanner.nextLine();


        dosyayaKaydet(dosyaAdi, yeniMetin);
        System.out.println("Yeni metin dosyaya kaydedildi.");


        String enSonKayitliMetin = dosyadanOku(dosyaAdi);
        System.out.println("En son kaydedilen metin: " + enSonKayitliMetin);
    }

    private static void dosyayaKaydet(String dosyaAdi, String metin) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(dosyaAdi)))) {
            writer.println(metin);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    private static String dosyadanOku(String dosyaAdi) {
        StringBuilder metinBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                metinBuilder.append(satir).append("\n");
            }
        } catch (IOException e) {

        }
        return metinBuilder.toString();
    }
}
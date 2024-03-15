import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnCokGecenKelime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen Metin Giriniz: ");
        String metin = scanner.nextLine();
        String enCokGecenKelime = enCokGecenKelimeyiBul(metin);
        System.out.println("En Çok Tekrar Eden Kelime: " + enCokGecenKelime);
    }

    public static String enCokGecenKelimeyiBul(String metin) {
        String[] kelimeler = metin.split("\\s+");
        Map<String, Integer> kelimeSayilari = new HashMap<>();

        for (String kelime : kelimeler) {
            String kucukHarfKelime = kelime.toLowerCase();
            if (kelimeSayilari.containsKey(kucukHarfKelime)) {
                kelimeSayilari.put(kucukHarfKelime, kelimeSayilari.get(kucukHarfKelime) + 1);
            } else {
                kelimeSayilari.put(kucukHarfKelime, 1);
            }
        }

        String enCokGecenKelime = null;
        int enYuksekSayi = 0;
        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() > enYuksekSayi) {
                enYuksekSayi = entry.getValue();
                enCokGecenKelime = entry.getKey();
            }
        }

        return enCokGecenKelime;
    }
}
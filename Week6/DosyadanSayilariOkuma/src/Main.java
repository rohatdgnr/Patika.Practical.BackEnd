import java.io.*;

public class Main {

    public static void main(String[] args) {
        String dosyaAdi = "metinDosyasi.txt";
        try {

            FileWriter fileWriter = new FileWriter(dosyaAdi);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("5\n");
            bufferedWriter.write("10\n");
            bufferedWriter.write("20\n");
            bufferedWriter.write("12\n");
            bufferedWriter.write("33\n");

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Dosya başarıyla oluşturuldu ve veriler yazıldı.");


            int toplam = toplamiHesapla(dosyaAdi);
            System.out.println("Dosyadaki sayıların toplamı: " + toplam);



        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    private static int toplamiHesapla(String dosyaAdi) throws IOException {

        FileReader fileReader = new FileReader(dosyaAdi);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int toplam = 0;
        String satir;


        while ((satir = bufferedReader.readLine()) != null) {

            toplam += Integer.parseInt(satir.trim());
        }

        bufferedReader.close();
        fileReader.close();

        return toplam;
    }
}
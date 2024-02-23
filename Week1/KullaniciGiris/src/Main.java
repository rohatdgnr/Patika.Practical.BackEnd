import java.util.Scanner;

 class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcının kayıtlı şifresi
        String Sifre = "123456";
        // Giriş yapılmış kullanıcı şifresi
        String YeniSifre;
        // Kullanıcı adı
       String KullaniciAdi ;

        System.out.println(" Kullanıcı Adınızı Giriniz :");
        KullaniciAdi = scanner.nextLine();
        System.out.println("Şifrenizi Giriniz:");
        YeniSifre = scanner.nextLine();

        // Şifre kontrolü
        if (!YeniSifre.equals(Sifre)) {
            System.out.println("Girdiğiniz şifre yanlış.");
            System.out.println("Şifrenizi sıfırlamak ister misiniz? (Evet/Hayır)");
            String resetChoice = scanner.nextLine();

            if (resetChoice.equalsIgnoreCase("Evet")) {
                System.out.println("Yeni şifrenizi giriniz:");
                String newPassword  = scanner.nextLine();

                // Yeni şifrenin eskiyle aynı olmaması kontrolü
                if (!newPassword.equals(Sifre)) {
                    Sifre = newPassword;
                    System.out.println("Şifre oluşturuldu.");
                } else {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                }
            } else {
                System.out.println("Şifre sıfırlama işlemi iptal edildi.");
            }
        } else {
            System.out.println("Giriş başarılı.");
        }
    }
}
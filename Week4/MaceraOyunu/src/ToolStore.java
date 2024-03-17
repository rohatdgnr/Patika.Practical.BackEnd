import java.util.Scanner;

// ToolStore sınıfı, oyuncunun silah ve zırh satın alabileceği mağaza işlevlerini içerir.
public class ToolStore extends NormalLoc {

    // ToolStore sınıfının yapıcı metodudur. Üst sınıfın yapıcısını çağırır ve mağazanın adını belirler.
    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    // Mağazadaki işlevleri gerçekleştiren getLocation metodudur.
    public boolean getLocation() {
        // Oyuncunun parasını ve satın alma seçeneklerini göster.
        System.out.println("Para : " + player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.print("Seçiminiz : ");
        // Kullanıcının seçimini al.
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu(); // Silah menüsünü gösterir ve kullanıcının seçimini alır.
                buyWeapon(selItemID); // Seçilen silahı satın alır.
                break;
            case 2:
                selItemID = armorMenu(); // Zırh menüsünü gösterir ve kullanıcının seçimini alır.
                buyArmor(selItemID); // Seçilen zırhı satın alır.
                break;
            default:
                break;
        }
        return true;
    }

    // Zırh menüsünü gösterir ve kullanıcının seçimini alır.
    public int armorMenu() {
        System.out.println("1. Hafif \t <Para : 15 - Engellenen Hasar : 1>");
        System.out.println("2. Orta \t <Para : 25 - Engellenen Hasar : 3>");
        System.out.println("3. Ağır \t <Para : 40 - Engellenen Hasar : 5>");
        System.out.println("4. Çıkış");
        System.out.print("Zırh Seçiniz : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    // Seçilen zırhı satın alır.
    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor.");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }
        // Zırhı satın almak için yeterli para varsa, zırhı satın alır.
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " satın aldınız, Engellenen Hasar : " + player.getInv().getArmor());
                System.out.println("Kalan Para :" + player.getMoney());
            } else {
                System.out.println("Para yetersiz. !");
            }
        }
    }

    // Silah menüsünü gösterir ve kullanıcının seçimini alır.
    public int weaponMenu() {
        System.out.println("1. Tabanca\t<Para : 25 - Hasar : 2>");
        System.out.println("2. Kılıç\t<Para : 35 - Hasar : 3>");
        System.out.println("3. Tüfek\t<Para : 45 - Hasar : 7>");
        System.out.println("4. Çıkış");
        System.out.print("Silah Seçiniz : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    // Seçilen silahı satın alır.
    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor.");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }
        // Silahı satın almak için yeterli para varsa, silahı satın alır.
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " satın aldınız, Önceki Hasar :" + player.getDamage() + ", Yeni Hasar : "
                        + player.getTotalDamage());
                System.out.println("Kalan Para :" + player.getMoney());
            } else {
                System.out.println("Para yetersiz. !");
            }
        }
    }
}
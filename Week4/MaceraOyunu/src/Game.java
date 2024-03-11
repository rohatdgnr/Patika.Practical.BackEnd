import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Oyuna başlamadan önce isminizi giriniz : ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start(scan);
    }

    public void start(Scanner scan) {
        while (true) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
            System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düşman yok !");
            System.out.println("2. Mağara --> Karşınıza belki zombi çıkabilir !");
            System.out.println("3. Orman --> Karşınıza belki vampir çıkabilir !");
            System.out.println("4. Nehir --> Karşınıza belki ayı çıkabilir !");
            System.out.println("5. Maden --> Karşınıza belki yılan çıkabilir !");
            System.out.println("6. Mağaza --> Silah veya Zırh alabilirsiniz!");
            System.out.print("Gitmek istediğiniz yer : ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 6) {
                System.out.print("Lütfen geçerli bir yer seçiniz : ");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    if(player.getInv().isFood()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    location = new Cave(player);
                    break;
                case 3:
                    if(player.getInv().isFirewood()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    location = new Forest(player);
                    break;
                case 4:
                    if(player.getInv().isWater()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    location = new River(player);
                    break;
                case 5:
                    location = new Mine(player);
                    break;
                case 6:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandınız !");
                    if(scan != null) scan.close();
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Oyun Bitti !");
                if(scan != null) scan.close();
                break;
            }

        }
    }
}
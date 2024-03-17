import java.util.Random;

// BattleLoc sınıfı, dövüş alanlarının temel özelliklerini içerir.
public abstract class BattleLoc extends Location {
    // Engeli temsil eden değişken.
    protected Obstacle obstacle;
    // Bölgeden alınacak ödül.
    protected String award;

    // Rastgele sayı üretmek için Random sınıfından bir örnek.
    private static Random random = new Random();

    // BattleLoc sınıfından türetilen alt sınıfların constructor'ı.
    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    // Bölgenin işlevini gerçekleştiren metot.
    public boolean getLocation() {
        // Engelin sayısını al.
        int obsCount = obstacle.count();
        // Kullanıcıya bölge hakkında bilgi ver.
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç :");
        // Kullanıcının seçimini al.
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        // Kullanıcının seçimine göre işlem yap.
        if (selCase.equals("S")) {
            // Dövüş metodunu çağır ve dövüş sonucunu kontrol et.
            if (combat(obsCount)) {
                // Düşmanları yendiyse, ödülü kazan.
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !");
                // Kazanılan ödüle göre oyuncunun envanterini güncelle.
                if (this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            // Oyuncu öldüyse, oyunu kaybet.
            if (player.getHealthy() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }
        }
        // Kullanıcı savaşmayı seçmediyse, bölgeden kaçabilir.
        return true;
    }

    // Dövüş metodunu gerçekleştiren metot.
    public boolean combat(int obsCount) {
        // Bölgedeki düşman sayısı kadar dövüş yapılır.
        for (int i = 0; i < obsCount; i++) {
            // Engelin başlangıç sağlığını saklar.
            int defObsHealth = obstacle.getHealth();
            // Oyuncu ve düşman istatistiklerini yazdır.
            playerStats();
            enemyStats();
            // Oyuncu ve düşman sağlıkları sıfırdan büyük olduğu sürece dövüş devam eder.
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
                // Sıranın kimde olduğunu belirlemek için rastgele bir sayı üret.
                int randomSira = random.nextInt(10) + 1;
                System.out.print("<V>ur veya <K>aç :");
                // Kullanıcının seçimini al ve büyük harfe dönüştür.
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                // Kullanıcının seçimine göre işlem yap.
                if (selCase.equals("V")) {
                    // Vurmayı seçtiyse:
                    if (randomSira > 5) {
                        // Oyuncunun sırasıysa:
                        System.out.println("Siz vurdunuz !");
                        // Düşmanın sağlığına hasar ver.
                        obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                        // Vuruş sonrası durumu göster.
                        afterHit();
                        // Düşman hala hayattaysa, düşmanın oyuncuya vurmasını sağla.
                        if (obstacle.getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                            afterHit();
                        }
                    } else {
                        // Düşmanın sırasıysa:
                        System.out.println("Canavar size vurdu !");
                        // Oyuncunun sağlığına düşmanın hasarı kadar zarar ver.
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        // Vuruş sonrası durumu göster.
                        afterHit();
                        // Oyuncu hala hayattaysa, oyuncunun düşmana vurmasını sağla.
                        if (player.getHealthy() > 0) {
                            System.out.println();
                            System.out.println("Siz vurdunuz !");
                            obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    // Kullanıcı savaşmayı seçmediyse, dövüşü sonlandır.
                    return false;
                }
            }

            // Dövüş sonucunu kontrol et.
            if (obstacle.getHealth() < player.getHealthy()) {
                // Düşmanı yendiyse:
                System.out.println("Düşmanı yendiniz !");
                // Düşmandan alınan ödülü kontrol et.
                if (!obstacle.getName().equals("Yılan")) {
                    // Yılan değilse, para ödülü kazan.
                    player.setMoney(player.getMoney() + obstacle.getAward());
                } else {
                    // Yılan ise, özel ödüller kazan.
                    int randomNum = random.nextInt(100) + 1;
                    if (randomNum <= 15) {
                        // Silah ödülü kazan.
                        // Rastgele silah seçimi yap.
                        int randomSilah = random.nextInt(100) + 1;
                        if (randomSilah <= 20) {
                            // Tüfek ödülü kazan.
                            System.out.println("Tebrikler Tüfek kazandınız.");
                            player.getInv().setDamage(7);
                            player.getInv().setwName("Tüfek");
                        } else if (randomSilah <= 50) {
                            // Kılıç ödülü kazan.
                            System.out.println("Tebrikler Kılıç kazandınız.");
                            player.getInv().setDamage(3);
                            player.getInv().setwName("Kılıç");
                        } else {
                            // Tabanca ödülü kazan.
                            System.out.println("Tebrikler Tabanca kazandınız.");
                            player.getInv().setDamage(2);
                            player.getInv().setwName("Tabanca");
                        }
                    } else if (randomNum <= 30) {
                        // Zırh ödülü kazan.
                        // Rastgele zırh seçimi yap.
                        int randomZırh = random.nextInt(100) + 1;
                        if (randomZırh <= 20) {
                            // Ağır zırh ödülü kazan.
                            System.out.println("Tebrikler Ağır Zırh kazandınız.");
                            player.getInv().setArmor(5);
                            player.getInv().setaName("Ağır Zırh");
                        } else if (randomZırh <= 50) {
                            // Orta zırh ödülü kazan.
                            System.out.println("Tebrikler Orta Zırh kazandınız.");
                            player.getInv().setArmor(3);
                            player.getInv().setaName("Orta Zırh");
                        } else {
                            // Hafif zırh ödülü kazan.
                            System.out.println("Tebrikler Hafif Zırh kazandınız.");
                            player.getInv().setArmor(1);
                            player.getInv().setaName("Hafif Zırh");
                        }
                    } else if (randomNum <= 55) {
                        // Para ödülü kazan.
                        // Rastgele para miktarı seçimi yap.
                        int randomPara = random.nextInt(100) + 1;
                        if (randomPara <= 20) {
                            // 10 para ödülü kazan.
                            System.out.println("Tebrikler 10 Para kazandınız.");
                            player.setMoney(player.getMoney() + 10);
                        } else if (randomPara <= 50) {
                            // 5 para ödülü kazan.
                            System.out.println("Tebrikler 5 Para kazandınız.");
                            player.setMoney(player.getMoney() + 5);
                        } else {
                            // 1 para ödülü kazan.
                            System.out.println("Tebrikler 1 Para kazandınız.");
                            player.setMoney(player.getMoney() + 1);
                        }
                    } else {
                        // Hiçbir ödül kazanılmadı.
                        System.out.println("Maalesef hiçbir ödül kazanamadınız!");
                    }
                }
                // Güncel para miktarını yazdır.
                System.out.println("Güncel Paranız : " + player.getMoney());
                // Engelin sağlığını resetle.
                obstacle.setHealth(defObsHealth);
            } else {
                // Oyuncu kaybetti.
                return false;
            }
            System.out.println("-------------------");
        }
        // Dövüşü tamamladı.
        return true;
    }

    // Oyuncu istatistiklerini yazdıran metot.
    public void playerStats() {
        System.out.println("Oyuncu Değerleri\n--------------");
        System.out.println("Can:" + player.getHealthy());
        System.out.println("Hasar:" + player.getTotalDamage());
        System.out.println("Para:" + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah:" + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Zırh:" + player.getInv().getaName());
        }
    }

    // Düşman istatistiklerini yazdıran metot.
    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Değerleri\n--------------");
        System.out.println("Can:" + obstacle.getHealth());
        System.out.println("Hasar:" + obstacle.getDamage());
        if (!obstacle.getName().equals("Yılan")) {
            System.out.println("Ödül:" + obstacle.getAward());
        } else {
            System.out.println("Ödül: Para, Silah veya Zırh");
        }
    }

    // Vuruş sonrası durumu yazdıran metot.
    public void afterHit() {
        System.out.println("Oyuncu Canı:" + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı:" + obstacle.getHealth());
        System.out.println();
    }
}
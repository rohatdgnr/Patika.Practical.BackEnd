import java.util.Random;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    private static Random random = new Random();

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç :");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !");
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

            if(player.getHealthy() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }

        }
        return true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
                int randomSira = random.nextInt(10) + 1;
                System.out.print("<V>ur veya <K>aç :");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    if(randomSira > 5) {
                        System.out.println("Siz vurdunuz !");
                        obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                        afterHit();
                        if (obstacle.getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                            afterHit();
                        }
                    } else {
                        System.out.println("Canavar size vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                        if(player.getHealthy() > 0) {
                            System.out.println();
                            System.out.println("Siz vurdunuz !");
                            obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }

            if (obstacle.getHealth() < player.getHealthy()) {
                System.out.println("Düşmanı yendiniz !");
                if(!obstacle.getName().equals("Yılan"))
                    player.setMoney(player.getMoney() + obstacle.getAward());
                else {

                    int randomNum = random.nextInt(100) + 1;
                    if(randomNum <= 15) {
                        // Silah
                        int randomSilah = random.nextInt(100) + 1;
                        if(randomSilah <= 20) {
                            // Tüfek
                            System.out.println("Tebrikler Tüfek kazandınız.");
                            player.getInv().setDamage(7);
                            player.getInv().setwName("Tüfek");
                        }else if(randomSilah <= 50) {
                            // Kýlýç
                            System.out.println("Tebrikler Kılıç kazandınız.");
                            player.getInv().setDamage(3);
                            player.getInv().setwName("Kılıç");
                        }else {
                            // Tabanca
                            System.out.println("Tebrikler Tabanca kazandýnýz.");
                            player.getInv().setDamage(2);
                            player.getInv().setwName("Tabanca");
                        }

                    }else if(randomNum <= 30) {
                        // Zýrh
                        int randomZýrh = random.nextInt(100) + 1;
                        if(randomZýrh <= 20) {
                            // Aðýr
                            System.out.println("Tebrikler Ağır Zırh kazandınız.");
                            player.getInv().setArmor(5);
                            player.getInv().setaName("Ağır Zırh");
                        }else if(randomZýrh <= 50) {
                            // Orta
                            System.out.println("Tebrikler Orta Zırh kazandınız.");
                            player.getInv().setArmor(3);
                            player.getInv().setaName("Orta Zırh");
                        }else {
                            // Hafif
                            System.out.println("Tebrikler Hafif Zırh kazandınız.");
                            player.getInv().setArmor(1);
                            player.getInv().setaName("Hafif Zırh");
                        }

                    }else if(randomNum <= 55) {
                        // Para
                        int randomPara = random.nextInt(100) + 1;
                        if(randomPara <= 20) {
                            // 10 Para
                            System.out.println("Tebrikler 10 Para kazandınız.");
                            player.setMoney(player.getMoney() + 10);
                        }else if(randomPara <= 50) {
                            // 5 Para
                            System.out.println("Tebrikler 5 Para kazandınız.");
                            player.setMoney(player.getMoney() + 5);
                        }else {
                            // 1 Para
                            System.out.println("Tebrikler 1 Para kazandınız.");
                            player.setMoney(player.getMoney() + 1);
                        }

                    }else {
                        // Hiçbirþey
                        System.out.println("Maalesef hiçbir ödül kazanamadınız!");
                    }
                }
                System.out.println("Güncel Paranız : " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

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

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Değerleri\n--------------");
        System.out.println("Can:" + obstacle.getHealth());
        System.out.println("Hasar:" + obstacle.getDamage());
        if(!obstacle.getName().equals("Yılan"))
            System.out.println("Ödül:" + obstacle.getAward());
        else
            System.out.println("Ödül: Para, Silah veya Zırh");
    }

    public void afterHit() {
        System.out.println("Oyuncu Canı:" + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı:" + obstacle.getHealth());
        System.out.println();
    }

}

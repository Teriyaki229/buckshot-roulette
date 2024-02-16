import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

public class Service {
    Bullets bullets = new Bullets();

    private final Bullets.Bullet LIVE_BULLET = Bullets.Bullet.LIVE_BULLET;
    private final Bullets.Bullet DEAD_BULLET = Bullets.Bullet.DEAD_BULLET;

    public void startGame(Player player1, Player player2) {
        player1.setHealth(4);
        player2.setHealth(4);
    }

    public Bullets.Bullet shoot(Player player) {
        Bullets.Bullet bullet = bullets.removeBullet();
        if (bullet == LIVE_BULLET) {
            player.setHealth(player.getHealth() - 1);
            System.out.println("Shot with live bullet BOOM! \n Remaining health " + player.getHealth());
        } else {
            System.out.println("Dead bullet. Lucky day for " + player.getName());
        }
        return bullet;
    }

    public int getBulletCount() {
        return bullets.getBulletCount();
    }

    public String generateBullets() {
        SecureRandom random = new SecureRandom();
        int magazineSize = random.nextInt(8) + 1;
        for (int i = 0; i <= magazineSize; i++) {
            Bullets.Bullet bullet = random.nextBoolean() ? LIVE_BULLET : DEAD_BULLET;
            bullets.addBullet(bullet);
        }

        
        for (int i = 0; i < bullets.getBulletCount(); i++) {
			int randomIndexToSwap = random.nextInt(bullets.getBulletCount());
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}

        return magazine;
    }

    int turn = 0;
    boolean Player1Turn;

    public void playTurn(Player player1, Player player2) {

        Player1Turn = turn % 2 == 0 ? true : false;
        String self = Player1Turn ? player1.getName() : player2.getName();
        System.out.println(self + "'s turn");
        System.out.println("Choose " + self + " hand. 1: Shotgun 2: Powerups");
        Scanner scanner = new Scanner(System.in);
        Utility util = new Utility();
        int firstChoice = scanner.nextInt();
        switch (firstChoice) {
            case 1:
                System.out.println("1. Shoot " + player1.getName() + " 2: Shoot " + player2.getName());
                int shootChoice = scanner.nextInt();
                switch (shootChoice) {
                    case 1:
                        Bullets.Bullet shotPlayer1Bullet = shoot(player1);
                        util.printShotStatus(self, player1.getName(), player1.getHealth(), shotPlayer1Bullet);
                        if (!(shotPlayer1Bullet == Bullets.Bullet.DEAD_BULLET) && self.equals(player1.getName())) {
                            turn++;
                        }
                        break;
                    case 2:
                        Bullets.Bullet shotPlayer2Bullet = shoot(player2);
                        util.printShotStatus(self, player2.getName(), player2.getHealth(), shotPlayer2Bullet);
                        if (!(shotPlayer2Bullet == Bullets.Bullet.DEAD_BULLET) && self.equals(player1.getName())) {
                            turn++;
                        }
                        break;
                }
                break;
            case 2:
                System.out.println("TODO");
                break;

            default:
                break;
        }
    }
}
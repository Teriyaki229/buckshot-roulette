import java.security.SecureRandom;

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

    public void generateBullets(int roundNumber) {
        switch (roundNumber) {
            case 1:
                if (new SecureRandom().nextInt(2) == 1) {
                    bullets.addBullet(LIVE_BULLET);
                    bullets.addBullet(DEAD_BULLET);
                } else {
                    bullets.addBullet(DEAD_BULLET);
                    bullets.addBullet(LIVE_BULLET);
                }
                break;

            case 2:
                for (int i = 0; i < 5; i++) {
                    int bullet = new SecureRandom().nextInt(2);
                    bullets.addBullet(bullet == 1 ? LIVE_BULLET : DEAD_BULLET);
                }
                break;

            case 3:
                for (int i = 0; i < 7; i++) {
                    int bullet = new SecureRandom().nextInt(2);
                    bullets.addBullet(bullet == 1 ? LIVE_BULLET : DEAD_BULLET);
                }
                break;

            default:
                System.out.println("Invalid round number");
                break;
        }
    }
}
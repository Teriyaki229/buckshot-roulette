import java.security.SecureRandom;
import java.util.Stack;

public class Bullets {

    public enum Bullet {
        LIVE_BULLET, DEAD_BULLET
    }

    private Stack<Bullet> bullets = new Stack<Bullet>();

    // This returns the amount of bullets that the magazine contains
    public int getBulletCount() {
        return this.bullets.size();
    }

    // This will reset the amount of bullets
    public void resetBullets() {
        this.bullets.clear();
    }

    // Generate random bullet and add it
    public void generateAndAddBullet() {
        SecureRandom random = new SecureRandom();
        addBullet(random.nextInt(2) == 1 ? Bullet.LIVE_BULLET : Bullet.DEAD_BULLET);
    }

    // This will add provided bullet to the magazine
    public void addBullet(Bullet bullet) {
        // Push that bullet into the stack
        this.bullets.push(bullet);
    }

    // Pop the bullet from the stack.
    public Bullet removeBullet() {
        return this.bullets.pop();
    }

}

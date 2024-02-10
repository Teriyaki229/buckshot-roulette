public class Utility {
    public void printShotStatus(String self, String playerName, int health, Bullets.Bullet bullet) {
        System.out
                .println(self + " shot " + playerName + " with a " + bullet + " and he has " + health + " health left");
    }
}

public class Player {
    // This is the player's health property
    private int Health;

    private String name;

    // This is the function to get the player's health
    public int getHealth() {
        return Health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // This is the function to set the player's health
    public void setHealth(int Health) {
        this.Health = Health;
    }

    // This function will add health
    public void incrementHealth() {
        this.Health += 1;
    }

}

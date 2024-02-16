import java.util.Scanner;

public class BuckshotRoulette {

    public static void main(String[] args) {

        Utility util = new Utility();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Buckshot Roulette in terminal!");
        System.out.println("Start the game? Y? N?");
        String startGameResponse = scanner.nextLine();
        if (!startGameResponse.toUpperCase().equals("Y")) {
            System.out.println("You forfeited...");
            scanner.close();
        }

        Service service = new Service();
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Enter Player 1's name:");
        String player1Name = scanner.nextLine();
        player1.setName(player1Name);

        System.out.println("Enter Player 2's name:");
        String player2Name = scanner.nextLine();
        player2.setName(player2Name);

        service.startGame(player1, player2);

        // 1st Round
        String magazine = service.generateBullets();
        System.out.println("Round 1 \n");
        while (service.getBulletCount() != 0) {
            service.playTurn(player1, player2);
        }

        // 2nd Round
        service.generateBullets(2);
        System.out.println("Round 2 \n");

        while (service.getBulletCount() != 0) {
            service.playTurn(player1, player2);
        }

        // 2nd Round
        service.generateBullets(3);
        System.out.println("Round 3 \n");
        while (service.getBulletCount() != 0) {
            service.playTurn(player1, player2);
        }
    }
}

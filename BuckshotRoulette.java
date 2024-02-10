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

        int turn = 0;
        boolean Player1Turn;

        // 1st Round
        service.generateBullets(1);
        System.out.println("Round 1 \n");
        while (service.getBulletCount() != 0) {
            Player1Turn = turn % 2 == 0 ? true : false;
            String self = Player1Turn ? player1.getName() : player2.getName();
            System.out.println(self + "'s turn");
            System.out.println("Choose " + self + " hand. 1: Shotgun 2: Powerups");
            int firstChoice = scanner.nextInt();
            switch (firstChoice) {
                case 1:
                    System.out.println("1. Shoot " + player1.getName() + " 2: Shoot " + player2.getName());
                    int shootChoice = scanner.nextInt();
                    switch (shootChoice) {
                        case 1:
                            Bullets.Bullet shotPlayer1Bullet = service.shoot(player1);
                            util.printShotStatus(self, player1.getName(), player1.getHealth(), shotPlayer1Bullet);
                            break;
                        case 2:
                            Bullets.Bullet shotPlayer2Bullet = service.shoot(player2);
                            util.printShotStatus(self, player2.getName(), player2.getHealth(), shotPlayer2Bullet);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("TODO");
                    break;

                default:
                    break;
            }
            turn++;
        }

        // 2nd Round
        service.generateBullets(2);
        System.out.println("Round 2 \n");

        while (service.getBulletCount() != 0) {
            Player1Turn = turn % 2 == 0 ? true : false;
            String self = Player1Turn ? player1.getName() : player2.getName();
            System.out.println(self + "'s turn");
            System.out.println("Choose " + self + " hand. 1: Shotgun 2: Powerups");
            int firstChoice = scanner.nextInt();
            switch (firstChoice) {
                case 1:
                    System.out.println("1. Shoot " + player1.getName() + " 2: Shoot " + player2.getName());
                    int shootChoice = scanner.nextInt();
                    switch (shootChoice) {
                        case 1:
                            Bullets.Bullet shotPlayer1Bullet = service.shoot(player1);
                            util.printShotStatus(self, player1.getName(), player1.getHealth(), shotPlayer1Bullet);
                            break;
                        case 2:
                            Bullets.Bullet shotPlayer2Bullet = service.shoot(player2);
                            util.printShotStatus(self, player2.getName(), player2.getHealth(), shotPlayer2Bullet);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("TODO");
                    break;

                default:
                    break;
            }
            turn++;
        }

        // 2nd Round
        service.generateBullets(3);
        System.out.println("Round 3 \n");
        while (service.getBulletCount() != 0) {
            Player1Turn = turn % 2 == 0 ? true : false;
            String self = Player1Turn ? player1.getName() : player2.getName();
            System.out.println(self + "'s turn");
            System.out.println("Choose " + self + " hand. 1: Shotgun 2: Powerups");
            int firstChoice = scanner.nextInt();
            switch (firstChoice) {
                case 1:
                    System.out.println("1. Shoot " + player1.getName() + " 2: Shoot " + player2.getName());
                    int shootChoice = scanner.nextInt();
                    switch (shootChoice) {
                        case 1:
                            Bullets.Bullet shotPlayer1Bullet = service.shoot(player1);
                            util.printShotStatus(self, player1.getName(), player1.getHealth(), shotPlayer1Bullet);
                            break;
                        case 2:
                            Bullets.Bullet shotPlayer2Bullet = service.shoot(player2);
                            util.printShotStatus(self, player2.getName(), player2.getHealth(), shotPlayer2Bullet);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("TODO");
                    break;

                default:
                    break;
            }
            turn++;
        }
    }
}

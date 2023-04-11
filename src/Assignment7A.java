import java.util.Scanner;

public class Assignment7A {
    public static void main(String[] args) {
        RoshamboPlayer p1 = new RoshamboPlayer("Sargent Pepper", 30, 60);
        RoshamboPlayer p2 = new RoshamboPlayer("Colonel Sanders", 40, 85);
        int choice;
        String attack;
        System.out.println("[Ro-Sham-Bo Player]");
        do {
            printMainMenu(p1,p2);
            choice = getChoice();
            printOpponentSelection(p1, p2, choice);
            do {
                switch (choice) {
                    case 1:
                        printMenu2();
                        choice = getChoice();
                        if (choice == 1) {
                            attack = getUserAttack();
                            printResults(p1, attack);
                        }
                        break;
                    case 2:
                        printMenu2();
                        choice = getChoice();
                        if (choice == 1) {
                            attack = getUserAttack();
                            printResults(p2, attack);
                        }
                        break;
                }
            }while (choice != 2);

        } while (choice != 2);
        System.out.println("\nGame Over");
    }

    private static void printOpponentSelection(RoshamboPlayer p1, RoshamboPlayer p2, int choice) {
        if(choice == 1) {
            System.out.println("\nYour opponent is " + p1.getName() + "!");
        }
        else {
            System.out.println("\nYour opponent is " + p2.getName() + "!");
        }
    }

    public static void printResults(RoshamboPlayer x, String y) {
        if (x.playRound(y)) {
            System.out.println(x.getName() + " chose " + x.choice + "! You win!\n");
        }
        else { //rules of this game state that a tie is considered a win for the obj, so in all other cases, the player loses.
            System.out.println(x.getName() + " chose " + x.choice + "! You lose...\n");
        }
    }
    public static int getChoice(){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void printMainMenu(RoshamboPlayer x, RoshamboPlayer y) {
        System.out.print("""
                Who do you want to face?
                1) """ + x.getName() + """
                
                2) """ + y.getName() + """
                
                Opponent: """);
    }
    public static String getUserAttack() {
        Scanner sc = new Scanner(System.in);
        String attack;
        do {
            System.out.print("Enter an attack: ");
            attack = sc.nextLine();
            if (!(attack.equalsIgnoreCase("ro") || attack.equalsIgnoreCase("sham") || attack.equalsIgnoreCase("bo"))) {
                System.out.println("Invalid attack!");
            }
        }while (!(attack.equalsIgnoreCase("ro") || attack.equalsIgnoreCase("sham") || attack.equalsIgnoreCase("bo")));
        return attack;
    }
    public static void printMenu2() {
        System.out.print("""
                1) Play a round?
                2) Quit?
                Choice: """);
    }
}
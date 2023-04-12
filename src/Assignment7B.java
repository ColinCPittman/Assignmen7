import java.util.Scanner;

public class Assignment7B {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] userArrayPBM;
    public static String direction;
    public static int width, height, color, length, menuChoice, rowIndex, columnIndex, newColor;

    public static void main(String[] args) {
        System.out.println("[KSU Image Manipulation Program]");
        getInitialSizes();
        Pixel primArr = new Pixel();
        getInitialColors(primArr);
        generateInitialUserArray(primArr);
        do {
            printMainMenu();
            getUserMenuChoice();
            switch (menuChoice) {
                case 1 -> { //If user chose to fill a pixel
                    getRowFromUser();
                    getColumnFromUser();
                    getNewColorFromUser(primArr);
                    fillNewIndexPositionWithNewColor(primArr);
                }
                case 2 -> { //If user chose to fill a line
                    getRowFromUser();
                    getColumnFromUser();
                    getNewColorFromUser(primArr);
                    getLengthFromUser();
                    getDirectionFromUser();
                    drawLineUsingStoredInput(primArr);
                }
                case 3 -> { //If user chose to print the image
                    displayCurrentUserArray();
                }
                case 4 -> { //If user chose to quit the program
                    System.out.println("[Exiting KSU Image Manipulation Program]");
                }
                default -> { //If user entered invalid response
                    System.out.println("Please enter an integer 1 through 4.");
                }
            }
        } while (menuChoice != 4);
        sc.close();
    }

    private static void displayCurrentUserArray() {
        System.out.println("PGM Image Contents\n" + "P3\n" + width + " " + height + "\n255");
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < userArrayPBM[i].length; j++) {
                System.out.print(userArrayPBM[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void drawLineUsingStoredInput(Pixel x) {
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < userArrayPBM[i].length; j += 3) {
                if (direction.equalsIgnoreCase("left")) {
                    if (i == rowIndex && (j <= (columnIndex*3) && j > ((columnIndex*3) - length))) {
                        userArrayPBM[i][j] = x.getRed();
                        userArrayPBM[i][j+1] = x.getGreen();
                        userArrayPBM[i][j+2] = x.getBlue();
                    }
                } else if (direction.equalsIgnoreCase("right")) {
                    if (i == rowIndex && (j >= (columnIndex*3) && j < ((columnIndex*3) + length))) {
                        userArrayPBM[i][j] = x.getRed();
                        userArrayPBM[i][j+1] = x.getGreen();
                        userArrayPBM[i][j+2] = x.getBlue();
                    }
                } else if (direction.equalsIgnoreCase("up")) {
                    if ((i <= rowIndex && i > (rowIndex - (length/3))) && j == (columnIndex*3)) {
                        userArrayPBM[i][j] = x.getRed();
                        userArrayPBM[i][j+1] = x.getGreen();
                        userArrayPBM[i][j+2] = x.getBlue();
                    }
                } else if (direction.equalsIgnoreCase("down")) {
                    if ((i >= rowIndex && i < (rowIndex + (length/3))) && j == (columnIndex*3)) {
                        userArrayPBM[i][j] = x.getRed();
                        userArrayPBM[i][j+1] = x.getGreen();
                        userArrayPBM[i][j+2] = x.getBlue();
                    }
                }
            }
        }
    }

    private static void getLengthFromUser() {
        System.out.print("Length: ");
        length = sc.nextInt()*3;
    }

    private static void getDirectionFromUser() {
        sc.nextLine(); //To skip the leftover escape sequence from previous nextInt() method.
        boolean stayInLoop = true;
        do {
            System.out.print("Direction: ");
            direction = sc.nextLine();
            if (direction.equalsIgnoreCase("up") || direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")) {
                stayInLoop = false;
            } else {
                System.out.println("Please enter up, down, left, or right.");
            }
        } while (stayInLoop);
    }

    private static void fillNewIndexPositionWithNewColor(Pixel x) {
        userArrayPBM[rowIndex][columnIndex*3] = x.getRed();
        userArrayPBM[rowIndex][columnIndex*3+1] = x.getBlue();
        userArrayPBM[rowIndex][columnIndex*3+2] = x.getGreen();
    }

    private static void generateInitialUserArray(Pixel x) {
        userArrayPBM = new int[height][width * 3];
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j <= userArrayPBM[i].length - 3; j += 3) {
                userArrayPBM[i][j] = x.getRed();
                userArrayPBM[i][j+1] = x.getGreen();
                userArrayPBM[i][j+2] = x.getBlue();
            }
        }
    }

    private static void getColumnFromUser() {
        boolean stayInLoop = true;
        do {
            System.out.print("Column: ");
            columnIndex = sc.nextInt();
            if (!(columnIndex >= width || columnIndex < 0)) {
                stayInLoop = false;
            } else {
                System.out.println("Value is outside the bounds of the array.");
            }
        } while (stayInLoop);
    }


    private static void getNewColorFromUser(Pixel x) {
        boolean stayInLoop = true;
        do {
            System.out.print("New Red Color: ");
            int red = sc.nextInt();
            if (red >= 0 && red < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setRed(red);
        } while (stayInLoop);
        stayInLoop = true;
        do {
            System.out.print("New Blue Color: "); //the instructed output here is to ask for blue second, however it would be more consistent with the established order (that we were asked to implement in another part of this program) to ask for green here and blue last, but them's the breaks.
            int blue = sc.nextInt();
            if (blue >= 0 && blue < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setGreen(blue);
        } while (stayInLoop);
        stayInLoop = true;
        do {
            System.out.print("New Green Color: ");
            int green = sc.nextInt();
            if (green >= 0 && green < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setBlue(green);
        } while (stayInLoop);
    }

    private static void getRowFromUser() {
        boolean stayInLoop = true;
        do {
            System.out.print("Row: ");
            rowIndex = sc.nextInt();
            if (!(rowIndex >= height || rowIndex < 0)) {
                stayInLoop = false;
            } else {
                System.out.println("Value is outside the bounds of the array.");
            }
        } while (stayInLoop);
    }

    private static void getUserMenuChoice() {
        System.out.print("Choice? ");
        menuChoice = sc.nextInt();
        System.out.println();
    }

    private static void printMainMenu() {
        System.out.println("\nWhat will you do?\n" +
                "1) Fill in a pixel\n" +
                "2) Fill in a line\n" +
                "3) Print the image\n" +
                "4) Quit");
    }

    private static void getInitialSizes() {
        System.out.print("Enter an image width: ");
        width = sc.nextInt();
        System.out.print("Enter an image height: ");
        height = sc.nextInt();
        System.out.println();
    }
    private static void getInitialColors(Pixel x) {
        boolean stayInLoop = true;
        do {
            System.out.print("Enter the fill color's red value: ");
            int red = sc.nextInt();
            if (red >= 0 && red < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setRed(red);
        } while (stayInLoop);
        stayInLoop = true;
        do {
            System.out.print("Enter the fill color: ");
            int green = sc.nextInt();
            if (green >= 0 && green < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setGreen(green);
        } while (stayInLoop);
        stayInLoop = true;
        do {
            System.out.print("Enter the fill color: ");
            int blue = sc.nextInt();
            if (blue >= 0 && blue < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
            x.setBlue(blue);
        } while (stayInLoop);
    }

}
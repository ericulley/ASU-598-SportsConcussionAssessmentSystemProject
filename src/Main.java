import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<int[]> gameRecords = new ArrayList<>();

    public static void main(String[] args) {
        String currentUserRole = null;
        boolean running = true;
        while (running) {
            if (currentUserRole == null) {
                displayUserRoleMenu();
                int roleChoice = readInt("Select your role: ");
                switch (roleChoice) {
                    case 1 -> currentUserRole = "athlete";
                    case 2 -> currentUserRole = "medical";
                    case 3 -> running = false;
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
            if ("athlete".equals(currentUserRole)) {
                displayAthleteMenu();
                int athleteChoice = readInt("Select an option: ");
                switch (athleteChoice) {
                    case 1 -> addGameRecord();
                    case 2 -> viewGameRecords();
                    case 3 -> running = false;
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
            if ("medical".equals(currentUserRole)) {
                displayMedicalMenu();
                int medicalChoice = readInt("Select an option: ");
                switch (medicalChoice) {
                    case 1 -> addGameRecord();
                    case 2 -> viewGameRecords();
                    case 3 -> running = false;
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        }
        System.out.println("Goodbye.");
        scanner.close();
    }

    private static void displayUserRoleMenu() {
        System.out.println();
        System.out.println("========== USER ROLE MENU ===========");
        System.out.println("====== Please select your role ======");
        System.out.println("1. Athlete");
        System.out.println("2. Medical Practitioner");
        System.out.println("3. Exit");
    }

    private static void displayAthleteMenu() {
        System.out.println();
        System.out.println("===== ATHLETE MENU =====");
        System.out.println("1. Add game record");
        System.out.println("2. View game records");
        System.out.println("3. Back to role selection");
    }

    private static void displayMedicalMenu() {
        System.out.println();
        System.out.println("===== MEDICAL MENU =====");
        System.out.println("1. View game records");
        System.out.println("2. View game records");
        System.out.println("3. Back to role selection");
    }

    private static void addGameRecord() {
        int size = readInt("How many symptoms to record? ");
        int[] record = new int[size];
        for (int i = 0; i < size; i++) {
            record[i] = readInt("Enter severity for symptom " + (i + 1) + " (0-6): ");
        }
        gameRecords.add(record);
        if (gameRecords.size() > 5) {
            gameRecords.remove(0);
        }
        System.out.println("Record stored (game #" + gameRecords.size() + ").");
    }

    private static void viewGameRecords() {
        if (gameRecords.isEmpty()) {
            System.out.println("No records yet.");
            return;
        }
        for (int i = 0; i < gameRecords.size(); i++) {
            int[] record = gameRecords.get(i);
            System.out.print("Game " + (i + 1) + ": ");
            for (int severity : record) {
                System.out.print(severity + " ");
            }
            System.out.println();
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
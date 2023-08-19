import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }
}

public class OIBSIP_1 {
    private static User currentUser;
    private static String[][] reservations = new String[10][8];
    // Increased the column size for storing classType and seatNumber
    private static boolean[] seats = new boolean[20];

    public static void main(String[] args) {
        // Create some sample users (you can use a database for real implementation)
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        // Create Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Login Form
        System.out.println("=== Login Form ===");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (user1.authenticate(username, password)) {
                currentUser = user1;
                isLoggedIn = true;
            } else if (user2.authenticate(username, password)) {
                currentUser = user2;
                isLoggedIn = true;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
        // User is now logged in
        System.out.println("Welcome, " + currentUser.getUsername() + "!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reservation");
            System.out.println("3. Cancellation");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viewSeatMap();
                    break;
                case 2:
                    showReservationForm(scanner);
                    break;
                case 3:
                    showCancellationForm(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Online Reservation System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map :");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("*  ");
            } else {
                System.out.print(i + 1 + "  ");
            }
        }
        System.out.println();
    }

    private static void showReservationForm(Scanner scanner) {
        System.out.println("\n=== Reservation Form ===");
        System.out.print("Enter your basic details name: ");
        String basicDetails = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        String trainName = "Express Train"; // For simplicity
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (yyyy-MM-dd): "); // Use the specified format
        String dateOfJourneyString = scanner.nextLine();
        LocalDate dateOfJourney = LocalDate.parse(dateOfJourneyString, DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        dateOfJourneyString = dateOfJourney.format(dateFormatter);
        System.out.print("Enter from (place): ");
        String from = scanner.nextLine();
        System.out.print("Enter to (destination): ");
        String to = scanner.nextLine();
        System.out.print("Enter the number of seats you want to reserve: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        int[] seatNumbers = new int[numberOfSeats];
        for (int i = 0; i < numberOfSeats; i++) {
            System.out.print("Enter seat number " + (i + 1) + " (1 to 20): ");
            int seatNumber = Integer.parseInt(scanner.nextLine());
            if (seatNumber < 1 || seatNumber > 21) {
                System.out.println("Invalid seat number. Reservation failed.");
                return;
            } else if (seats[seatNumber - 1]) {
                System.out.println("Seat already reserved. Reservation failed.");
                return;
            } else {
                seatNumbers[i] = seatNumber;
            }
        }
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i][0] == null) {
                for (int j = 0; j < numberOfSeats; j++) {
                    int seatNumber = seatNumbers[j];
                    seats[seatNumber - 1] = true;
                    reservations[i] = new String[] { currentUser.getUsername(), basicDetails,
                            trainNumber, trainName, classType, dateOfJourneyString, from, to };
                    reservations[i][7] = Integer.toString(seatNumber);
                    System.out.println("Seat " + seatNumber + " reserved successfully!");
                    i++; // Move to the next row in the reservations array
                }
                System.out.println("Reservation successful!");
                return;
            }
        }

        System.out.println("Sorry, no more reservations available. Try again later.");
    }

    private static void showCancellationForm(Scanner scanner) {
        System.out.println("\n=== Cancellation Form ===");
        System.out.print("Enter PNR number: ");
        String pnrNumber = scanner.nextLine();

        // Search for the reservation based on the PNR number (in a real implementation,
        // use a database)
        boolean canceled = false; // Variable to track if any reservation is canceled
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i][0] != null && reservations[i][0].equals(currentUser.getUsername())
                    && reservations[i][2].equals(pnrNumber)) {
                System.out.println("Reservation details:");
                System.out.println("Basic Details: " + reservations[i][1]);
                System.out.println("Train Number: " + reservations[i][2]);
                System.out.println("Train Name: " + reservations[i][3]);
                System.out.println("Class Type: " + reservations[i][4]);
                System.out.println("Date of Journey: " + reservations[i][5]);
                System.out.println("From: " + reservations[i][6]);
                System.out.println("Cancelled seat number: " + reservations[i][7]);

                System.out.print("Do you want to confirm cancellation? (Type 'OK' to cancel): ");
                // here type ok
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("OK")) {
                    int seatNumber = Integer.parseInt(reservations[i][7]);
                    seats[seatNumber - 1] = false;
                    reservations[i] = null;
                    System.out.println("Reservation cancelled successfully!");
                    canceled = true;
                } else {
                    System.out.println("Cancellation not confirmed. Reservation is intact.");
                }
            }
        }
        if (!canceled) {
            System.out.println("No reservation found with the given PNR number.");
        }
    }
}

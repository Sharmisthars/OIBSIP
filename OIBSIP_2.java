import java.util.*;

public class OIBSIP_2 {
    private String username;
    private String password;
    private boolean isLoggedIn;
    private int timeRemaining;
    private int questionCount;
    private int[] userAnswers;
    private int[] correctAnswers;
    private Timer timer;
    public Onlineexam(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("You are Successfully registered.");
        this.isLoggedIn = false;
        this.timeRemaining = 2; // in minutes (We can change the time limit as per our own wish )
        this.questionCount = 10; // (We can change the number of quesions as per our own wish )
        this.userAnswers = new int[questionCount];
        this.correctAnswers = new int[questionCount];
        for (int i = 0; i < questionCount; i++) {
            correctAnswers[i] = (int) Math.round(Math.random());}
    }
    public void login() {
        System.out.println("Please Log in to give the Exam.");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();
        System.out.println(" ");
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            isLoggedIn = true;
            System.out.println("Login successful. Best of Luck For your exam " + username + " !");
        } else {
            System.out.println("Login failed. Please try again.");  }
    }
    public void logout() {
        isLoggedIn = false;
        if (timer != null) {
            timer.cancel();
        }
        System.out.println("Logout successful."); }
    public void startExam() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Do you want to start the timer? \n1: Yes \n2: No ");
        int startTimerChoice = scanner.nextInt();

        if (startTimerChoice == 1) {
            startTimer();
        }

        System.out.println("You have " + timeRemaining + " minutes to complete the exam.");
        System.out.println(" ");

        for (int i = 0; i < questionCount; i++) {
            System.out.println(" ");
            System.out.println("Question " + (i + 1) + ":");
            System.out.println("1. Option A");
            System.out.println("2. Option B");
            System.out.print("Your answer (1 or 2): ");
            int answer = scanner.nextInt();
            userAnswers[i] = answer;
        }
        System.out.println(" ");
        System.out.println("Would you like to submit? \n1: Yes \n2: No ");
        int n = scanner.nextInt();
        if (n == 1) {
            submitExam();
        } else {
            submitExam();
        }
    }

    public void submitExam() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        int score = 0;
        for (int i = 0; i < questionCount; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }
        System.out.println("Your score is " + score + " out of " + questionCount + ".");
        logout();
    }

    public void startTimer() {
        System.out.println("Timer started.");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Automatically submitting exam...");
                submitExam();
            }
        }, timeRemaining * 60 * 1000); // Convert minutes to milliseconds
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("     =======Student Registration details========      ");
        System.out.println(" ");
        System.out.print("Enter username :");
        String uName = sc.nextLine();
        System.out.print("Enter a password for registration :");
        String pWord = sc.nextLine();
        System.out.println(" ");
        Onlineexam examSystem = new Onlineexam(uName, pWord);
        examSystem.login();
        examSystem.startExam();
    }
}

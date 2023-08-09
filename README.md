# OIBSIP_JAVA_INTERN
This respiratory is created to do the projects which will be done for Oasis Infobyte.  

Task 1: Online Reservation System
------- Explanation of the code furnished below:
1. User Class: Represents a user with a username and password. It has methods to authenticate the user's credentials.
2. OnReserveSys Class:
It has a main method where the program execution starts.
It creates two sample user objects for demonstration purposes.
It presents a login form to the user, asking for username and password to log in.
3.Once the user is logged in, they can choose from the following options:
i)View Seat Map: Displays the current seat map with reserved seats marked. We can increase or decrease the seat numbers as per our own choice.
ii)Reservation: Allows the user to make a reservation by providing basic details, train number, class type, date of journey, from and to stations, and the number of seats to reserve.
iii)Cancellation: Allows the user to cancel a reservation by entering the PNR number. It displays the reservation details and asks for confirmation before canceling. We can cancelled the reservation seat by seat.
iv)Exit: Terminates the program and thanks the user for using the system.
It uses a two-dimensional array reservations to store reservation details and a boolean array seats to track seat availability.
The viewSeatMap() method displays the current seat map by iterating over the seats array.
The showReservationForm(Scanner scanner) method allows the user to make a reservation. It takes input from the user for various details, checks for seat availability, and reserves the seats if available. If no seats are available, it displays an appropriate message.
The showCancellationForm(Scanner scanner) method allows the user to cancel a reservation based on the PNR number. It searches for the reservation with the given PNR number and cancels it if found. It updates the seat availability and displays a cancellation confirmation.




Task 2: Online MCQ Examination System
------- Explanation of the code furnished below:
1. Class Definition: The Onlineexam class is defined, encapsulating the entire online exam system.
2. Instance Variables: The class includes various instance variables to store user data and exam-related information, including the username, password, login status (isLoggedIn), remaining exam time (timeRemaining), number of questions (questionCount), user answers (userAnswers), correct answers (correctAnswers), and a Timer instance (timer).
3. Constructor: The constructor initializes the class instance with the provided username and password. It also sets default values for login status, time remaining, number of questions, user answers, and generates random correct answers.
4. Login Method: The login() method prompts the user to input their username and password. If the input matches the stored credentials, the user is logged in, and a success message is displayed. Otherwise, a login failure message is shown.
5. Logout Method: The logout() method logs out the user, cancels any active timer, and displays a logout success message.
6. Start Exam Method: The startExam() method allows a logged-in user to start the exam. It checks if the user is logged in and prompts whether they want to start the timer. Then, it presents questions and options to the user, storing their answers in userAnswers array.
7. Submit Exam Method: The submitExam() method calculates the user's score by comparing their answers with correct answers and displays the score out of the total number of questions. It then calls the logout() method.
8. Start Timer Method: The startTimer() method initiates a countdown timer using the Timer class. When the timer expires, it automatically submits the exam using the submitExam() method.
9. Main Method: The main() method serves as the entry point of the program. It takes user input for username and password, creates an instance of Onlineexam, calls the login() method, and starts the exam using the startExam() method.
10. User Interaction: The code interacts with the user through console input and output. It provides registration prompts, login prompts, question prompts, timer prompts, and exam results.
Random Correct Answers: The code generates random correct answers for questions, simulating the exam's correct answers.
11. Time Management: The code implements a timer that can be activated by the user during the exam. If the time limit is reached, the exam is automatically submitted.
12. Customization: The code provides flexibility to change the time limit and number of questions to suit specific exam requirements.

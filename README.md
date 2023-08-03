# OIBSIPJAVAINTERN
This respiratory is created to do the projects which will be done for Oasis Infobyte.  

Task 1: Online Reservation System
Explanation of the code furnished below:
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

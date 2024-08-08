# Movie Ticket Booking GUI

This Java application is a simple GUI-based movie ticket booking system. It allows users to select one of two movies and book seats from a 3x3 grid for the selected movie.

## Features

- **Movie Selection:** Users can choose between two movies: "Leo" and "Vikram."
- **Seat Selection:** Once a movie is selected, users are presented with a 3x3 grid of seats. They can book available seats, which will then be marked as unavailable.
- **Booking Confirmation:** Users receive a confirmation dialog when they attempt to book a seat. The seat is marked as booked and becomes unclickable.
- **Back Navigation:** Users can navigate back to the movie selection screen from the seat selection screen.

## Project Structure

- **MovieTicketBookingGUI.java**: The main Java class containing the entire application logic. It includes:
  - `MovieTicketBookingGUI`: The main class that initializes the GUI.
  - `MovieButtonListener`: Inner class to handle movie selection.
  - `SeatButtonListener`: Inner class to handle seat booking actions.

## How to Run

1. **Requirements:**
   - Java Development Kit (JDK) installed (version 8 or higher recommended).
   
2. **Compile and Run:**
   - Compile the program:
     ```bash
     javac MovieTicketBookingGUI.java
     ```
   - Run the compiled program:
     ```bash
     java MovieTicketBookingGUI
     ```

3. **Usage:**
   - Upon running the program, a window will appear with buttons for "Leo" and "Vikram."
   - Click on a movie to open the seat selection screen.
   - Click on a seat to book it. Confirm the booking in the dialog that appears.
   - Use the "Back to Movie Selection" button to return to the main screen.

## Customization

- **Available Seats Per Movie:**
  - Modify the `availableSeatsPerMovie` variable to change the number of seats available per movie. Note that the grid layout is set to 3x3 by default.
  
- **Movies:**
  - Update the `movie1Button` and `movie2Button` text in the `MovieTicketBookingGUI` constructor to change the movie names.

## Acknowledgments

This project was created as a basic demonstration of using Java Swing for GUI applications.

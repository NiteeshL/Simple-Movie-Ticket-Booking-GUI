import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class MovieTicketBookingGUI {
    private JFrame mainFrame;
    private JFrame movie1Frame;
    private JFrame movie2Frame;
    private JButton movie1Button;
    private JButton movie2Button;
    private JButton[][] movie1Seats;
    private JButton[][] movie2Seats;
    private int availableSeatsPerMovie = 9; // 3x3 grid

    private Set<Integer> bookedSeatsMovie1 = new HashSet<>();
    private Set<Integer> bookedSeatsMovie2 = new HashSet<>();

    public MovieTicketBookingGUI() {
        mainFrame = new JFrame("Movie Selection");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        movie1Button = new JButton("Leo");
        movie2Button = new JButton("Vikram");

        movie1Button.addActionListener(new MovieButtonListener(1));
        movie2Button.addActionListener(new MovieButtonListener(2));

        mainFrame.add(movie1Button);
        mainFrame.add(movie2Button);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private class MovieButtonListener implements ActionListener {
        private int movieNumber;

        public MovieButtonListener(int movieNumber) {
            this.movieNumber = movieNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(false);

            if (movieNumber == 1) {
                movie1Frame = createMovieFrame("Leo", 1, bookedSeatsMovie1);
            } else if (movieNumber == 2) {
                movie2Frame = createMovieFrame("Vikram", 2, bookedSeatsMovie2);
            }
        }

        private JFrame createMovieFrame(String movieName, int movieNumber, Set<Integer> bookedSeats) {
            JFrame frame = new JFrame(movieName + " - Ticket Booking");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 3)); // 3x3 grid layout

            JButton[][] seats = new JButton[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int seatNumber = row * 3 + col + 1;
                    seats[row][col] = new JButton("Seat " + seatNumber);
                    if (bookedSeats.contains(seatNumber)) {
                        seats[row][col].setEnabled(false);
                    }
                    seats[row][col].addActionListener(new SeatButtonListener(movieNumber, seatNumber, seats[row][col], bookedSeats, frame));
                    frame.add(seats[row][col]);
                }
            }

            JButton backButton = new JButton("Back to Movie Selection");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    mainFrame.setVisible(true);
                }
            });

            frame.add(backButton);
            frame.pack();
            frame.setVisible(true);

            return frame;
        }
    }

    private class SeatButtonListener implements ActionListener {
        private int movieNumber;
        private int seatNumber;
        private JButton seatButton;
        private Set<Integer> bookedSeats;
        private JFrame movieFrame;

        public SeatButtonListener(int movieNumber, int seatNumber, JButton seatButton, Set<Integer> bookedSeats, JFrame movieFrame) {
            this.movieNumber = movieNumber;
            this.seatNumber = seatNumber;
            this.seatButton = seatButton;
            this.bookedSeats = bookedSeats;
            this.movieFrame = movieFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!bookedSeats.contains(seatNumber)) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to book " + seatButton.getText() + " for Movie " + movieNumber + "?", "Confirm Booking", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    bookedSeats.add(seatNumber);
                    seatButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null,
                            seatButton.getText() + " booked for Movie " + movieNumber + "!");
                }
            } else {
                JOptionPane.showMessageDialog(null, seatButton.getText() + " is already booked for Movie " + movieNumber + "!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketBookingGUI());
    }
}

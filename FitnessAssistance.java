import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessAssistance extends JFrame {
    private JTextField stepsField;
    private JTextField distanceField;
    private JButton trackButton;
    private JLabel resultLabel;
    private JLabel messageLabel;

    public FitnessAssistance() {
        ImageIcon icon = new ImageIcon("fitaa.png");
        setIconImage(icon.getImage());
        setTitle("FitnessAssistance");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);

        stepsField = new JTextField(10);
        distanceField = new JTextField(10);
        trackButton = new JButton("Track Activity");
        resultLabel = new JLabel();
        messageLabel = new JLabel();

        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int steps = Integer.parseInt(stepsField.getText());
                double distance = Double.parseDouble(distanceField.getText());

                // Perform calculations to estimate calories burned
                double caloriesBurned = calculateCaloriesBurned(steps, distance);

                // Display the results to the user
                resultLabel.setText("Calories Burned: " + caloriesBurned);

                // Determine the message based on calories burned
                if (caloriesBurned >= 0 && caloriesBurned <= 100) {
                    messageLabel.setText("Great start! You've kicked off your fitness journey with some activity. Keep it up!");
                } else if (caloriesBurned > 100 && caloriesBurned <= 300) {
                    messageLabel.setText("Well done! You're making progress and staying active. Keep moving towards your goals!");
                } else {
                    messageLabel.setText("Impressive effort! You've burned a significant number of calories. Keep pushing yourself and maintain this healthy lifestyle!");
                }
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Steps taken:"));
        inputPanel.add(stepsField);
        inputPanel.add(new JLabel("Distance (km):"));
        inputPanel.add(distanceField);
        inputPanel.add(new JLabel());
        inputPanel.add(trackButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);
        
        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel);

        add(inputPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.NORTH);
        add(messagePanel, BorderLayout.SOUTH);
    }

    // Method to calculate estimated calories burned
    private double calculateCaloriesBurned(int steps, double distance) {
        double caloriesPerStep = 0.04;
        double caloriesPerDistance = 0.1;

        return (steps * caloriesPerStep) + (distance * caloriesPerDistance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FitnessAssistance().setVisible(true);
            }
        });
    }
}

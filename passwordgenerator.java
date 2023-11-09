package javaPractice;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordGeneratorGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel lengthLabel = new JLabel("Password Length:");
        JTextField lengthField = new JTextField();
        JCheckBox lowercaseBox = new JCheckBox("Include Lowercase");
        JCheckBox uppercaseBox = new JCheckBox("Include Uppercase");
        JCheckBox digitsBox = new JCheckBox("Include Digits");
        JCheckBox specialCharsBox = new JCheckBox("Include Special Characters");
        JButton generateButton = new JButton("Generate Password");
        JTextArea resultArea = new JTextArea();

        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(lowercaseBox);
        frame.add(uppercaseBox);
        frame.add(digitsBox);
        frame.add(specialCharsBox);
        frame.add(generateButton);
        frame.add(resultArea);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length;
                try {
                    length = Integer.parseInt(lengthField.getText());
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid password length.");
                    return;
                }

                boolean useLowercase = lowercaseBox.isSelected();
                boolean useUppercase = uppercaseBox.isSelected();
                boolean useDigits = digitsBox.isSelected();
                boolean useSpecialChars = specialCharsBox.isSelected();

                String generatedPassword = PasswordGenerator.generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialChars);
                resultArea.setText("Generated Password: " + generatedPassword);
            }
        });

        frame.setVisible(true);
    }
}

	








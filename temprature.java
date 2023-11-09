package javaPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> fromUnitSelector;
    private JComboBox<String> toUnitSelector;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        resultLabel = new JLabel("Result: ");
        fromUnitSelector = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        toUnitSelector = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        add(new JLabel("Enter temperature: "));
        add(inputField);
        add(fromUnitSelector);
        add(new JLabel("to"));
        add(toUnitSelector);
        add(convertButton);
        add(resultLabel);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String fromUnit = (String) fromUnitSelector.getSelectedItem();
            String toUnit = (String) toUnitSelector.getSelectedItem();

            double result = 0.0;

            if (fromUnit.equals("Celsius")) {
                if (toUnit.equals("Fahrenheit")) {
                    result = (temperature * 9/5) + 32;
                } else if (toUnit.equals("Kelvin")) {
                    result = temperature + 273.15;
                } else {
                    result = temperature;
                }
            } else if (fromUnit.equals("Fahrenheit")) {
                if (toUnit.equals("Celsius")) {
                    result = (temperature - 32) * 5/9;
                } else if (toUnit.equals("Kelvin")) {
                    result = (temperature + 459.67) * 5/9;
                } else {
                    result = temperature;
                }
            } else if (fromUnit.equals("Kelvin")) {
                if (toUnit.equals("Celsius")) {
                    result = temperature - 273.15;
                } else if (toUnit.equals("Fahrenheit")) {
                    result = (temperature * 9/5) - 459.67;
                } else {
                    result = temperature;
                }
            }

            resultLabel.setText("Result: " + result + " " + toUnit);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}

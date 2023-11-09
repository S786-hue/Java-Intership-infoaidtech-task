package javaPractice;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentRecordManagementSystem {
    private List<Student> students = new ArrayList<>();
    private JFrame frame;
    private JTextField nameField;
    private JTextField rollNumberField;
    private DefaultListModel<Student> studentListModel;
    private JList<Student> studentList;

    public StudentRecordManagementSystem() {
        // Initialize the main frame
        frame = new JFrame("Student Record Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Roll Number:"));
        rollNumberField = new JTextField();
        inputPanel.add(rollNumberField);

        // Create button for adding students
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // Create student list panel
        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane listScrollPane = new JScrollPane(studentList);

        // Add components to the main frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(addButton, BorderLayout.CENTER);
        frame.add(listScrollPane, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        int rollNumber = Integer.parseInt(rollNumberField.getText());

        Student student = new Student(name, rollNumber);
        students.add(student);
        studentListModel.addElement(student);

        nameField.setText("");
        rollNumberField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRecordManagementSystem();
            }
        });
    }
}

class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name;
    }
}

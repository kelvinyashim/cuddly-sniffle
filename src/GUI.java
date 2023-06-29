import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends Validation {

    JFrame frame = new JFrame("Laptop");
    JFrame frame4 = new JFrame("Laptop");
    JFrame regFrame = new JFrame("SignUp");
    JLabel bingham = new JLabel("Welcome");
    JLabel bingham5 = new JLabel("Select");
    JLabel bingham3 = new JLabel("Hello");
    JLabel bingham2 = new JLabel("If it's stolen, be sure we'll find it");
    JLabel bingham6 = new JLabel("Provide detailed info: ");
    JLabel bingham1 = new JLabel("<html>Click on the button below to register<br>or click on log in if you already have an account</html>");
    JButton lgbtn = new JButton("Register");
    JButton lgbtn1 = new JButton("Sign in");
    JButton search = new JButton("Search");
    JButton lgbtn2 = new JButton("Log in");
    JButton regBtn = new JButton("Register");
    JButton report = new JButton("File a report");
    JButton find = new JButton("Check");
    JButton report2 = new JButton("Submit");

    JTextField studentName = new JTextField("Full-Name");
    JTextField serial = new JTextField("Serial Number");
    JTextField matNum = new JTextField("Matric Num");
    JTextField lapNum = new JTextField("Laptop Num");
    JTextField faculty = new JTextField("Faculty");
    JTextField dept = new JTextField("Department");
    JPasswordField passwordField = new JPasswordField("Password");
    JPasswordField passwordField1 = new JPasswordField("Password");
    JLabel psw = new JLabel("Confirm Password");
    JLabel Location = new JLabel("Confirm Password");
    JLabel label = new JLabel("Serial No: ");
     JFrame frame1 = new JFrame();
     JFrame frame3 = new JFrame();
     JFrame frame2 = new JFrame("Pick");
     JTextArea report1 = new JTextArea();




    public void mainUI() {
        // Set background color for buttons
        lgbtn.setBackground(Color.LIGHT_GRAY);
        lgbtn1.setBackground(Color.LIGHT_GRAY);
        search.setBackground(Color.LIGHT_GRAY);
        lgbtn2.setBackground(Color.LIGHT_GRAY);
        regBtn.setBackground(Color.LIGHT_GRAY);
        report.setBackground(Color.LIGHT_GRAY);
        find.setBackground(Color.LIGHT_GRAY);
        report2.setBackground(Color.LIGHT_GRAY);

// Set background color for labels
        bingham.setBackground(Color.WHITE);
        bingham1.setBackground(Color.WHITE);
        bingham2.setBackground(Color.WHITE);
        bingham3.setBackground(Color.WHITE);
        bingham5.setBackground(Color.WHITE);
        bingham6.setBackground(Color.WHITE);
        psw.setBackground(Color.WHITE);
        Location.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);

        bingham.setBounds(66,90, 250, 100);
        bingham.setForeground(Color.BLACK);
        bingham.setFont(bingham.getFont().deriveFont(Font.BOLD, 25));


        bingham1.setBounds(66,90, 250, 100);
        bingham1.setForeground(Color.BLACK);
        bingham1.setFont(bingham1.getFont().deriveFont(Font.BOLD, 25));

        bingham2.setBounds(66,90, 250, 100);
        bingham2.setForeground(Color.BLACK);
        bingham2.setFont(bingham2.getFont().deriveFont(Font.BOLD, 25));

        bingham3.setBounds(66,90, 250, 100);
        bingham3.setForeground(Color.BLACK);
        bingham3.setFont(bingham3.getFont().deriveFont(Font.BOLD, 25));

        bingham5.setBounds(66,90, 250, 100);
        bingham5.setForeground(Color.BLACK);
        bingham5.setFont(bingham5.getFont().deriveFont(Font.BOLD, 25));

        label.setBounds(66,90, 250, 100);
        label.setForeground(Color.BLACK);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 25));

        frame.getContentPane().add(bingham);
        frame.getContentPane().add(bingham1);
        frame.add(lgbtn);
        frame.add(lgbtn1);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(5, 1));
        register();
    }

    public void register() {
        addPlaceholderBehavior(studentName, "Full Name");
        addPlaceholderBehavior(serial, "Serial Number");
        addPlaceholderBehavior(matNum, "Matric Num");
        addPlaceholderBehavior(lapNum, "Laptop Num");
        addPlaceholderBehavior(faculty, "Faculty");
        addPlaceholderBehavior(dept, "Department");
        addPlaceholderBehavior(passwordField, "Password");
        addPlaceholderBehavior(passwordField1, "Confirm Password");

        lgbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regFrame.setTitle("SignUp");
                regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                regFrame.setLayout(new GridLayout(10, 1));
                regFrame.getContentPane().add(bingham2);
                regFrame.getContentPane().add(studentName);
                regFrame.getContentPane().add(faculty);
                regFrame.getContentPane().add(dept);
                regFrame.getContentPane().add(matNum);
                regFrame.add(serial);
                regFrame.add(passwordField1);
                regFrame.getContentPane().add(psw);
                regFrame.add(passwordField);
                regFrame.getContentPane().add(regBtn);
                regFrame.setSize(300, 300);
                regFrame.setVisible(true);

                regBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = studentName.getText();
                        String mat = matNum.getText();
                        String lNum = serial.getText();
                        String fac = faculty.getText();
                        String dep = dept.getText();
                        String password = String.valueOf(passwordField.getPassword());

                        Validation valid = new Validation();
                        boolean isValid = true;
                        Credentials file = new Credentials();
                        try {
                            file.writeToFile(name, mat, fac, dep, password, lNum);

                            if (!valid.isValidName(name)) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid name");
                                isValid = false;
                            } else if (!valid.isValidMat(mat)) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid matriculation number");
                                isValid = false;
                            } else if (!valid.isValidPassword(password)) {
                                JOptionPane.showMessageDialog(null, "Invalid password");
                                isValid = false;
                            }

                            if (isValid) {
                                // Proceed with the registration process and store the data in the database
                                JOptionPane.showMessageDialog(null, "SignUp Complete");
                            }
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "Please enter the required details");
                        }
                    }
                });
            }
        });

        lgbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.getContentPane().add(bingham3);
                frame1.add(matNum);
                frame1.add(passwordField);
                frame1.add(lgbtn2);
                frame1.setSize(500,500);
                frame1.setLayout(new GridLayout(5,1));
                frame1.setVisible(true);
            }
        });
        lgbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            String mat = matNum.getText();
                            String password = String.valueOf(passwordField.getPassword());

                            // Implement your login logic here
                            Credentials file = new Credentials();
                            boolean isValid = file.checkCredentials(mat, password);

                            if (isValid) {
                                // Proceed with the login process
                                JOptionPane.showMessageDialog(null, "Login successful");
                                frame4.getContentPane().add(bingham5);
                                frame4.add(report);
                                frame4.add(search);
                                frame4.setSize(400,400);
                                frame4.setLayout(new GridLayout(5,1));
                                frame4.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                            }
                        }
            });
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.getContentPane().add(bingham6);
                frame2.add(report1);
                frame2.add(report2);
                frame2.setSize(400,400);
                frame2.setLayout(new GridLayout(3,1));
                frame2.setVisible(true);
                report2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,"Sent");

                    }
                });

            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.getContentPane().add(label);
                frame3.add(serial);
                frame3.add(find);
                frame3.setSize(400, 400);
                frame3.setLayout(new GridLayout(3, 1));
                frame3.setVisible(true);

                find.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String serialNumber = serial.getText();

                        Credentials file = new Credentials();
                        String ownerCredentials = file.getOwnerCredentials(serialNumber) ;
                            file.searchBySerialNumber(serialNumber);
                        if (!ownerCredentials.equals("Owner credentials not found.")) {
                            JOptionPane.showMessageDialog(null, ownerCredentials);
                        } else {
                            JOptionPane.showMessageDialog(null, "Serial number not found.");
                        }
                    }
                });
            }
        });

    }



    private void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setForeground(Color.GRAY);
        textField.setText(placeholder);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }

}

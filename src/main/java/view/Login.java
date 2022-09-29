package view;

import repository.RepoProductDetail;
import repository.RepoStaff;

import javax.swing.*;

public class Login extends JFrame {
    private JTextField staff_user;
    private JPasswordField staff_password;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel content;
    private JButton customerButton;

    public Login() {
        this.setContentPane(content);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
    }

    public boolean login(String user, String password) {
        return new RepoStaff().login(staff_user.getText().trim(), new String(staff_password.getPassword()));
    }
}

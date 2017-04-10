import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Dialog to accept user credentials
 *
 * This code snippet is adapted from the project IoTHouse of course
 * 17-654 Analysis of Software Systems at Carnegie Mellon University.
 * @author Yuchao Zhou
 */
public class LoginWindow extends JDialog  {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    UserManagementBusinessLogic userBL;
    
    /**
     * The constructor of LoginWindow
     * @param parent The applications that contains a reference of Login Window
     */
    public LoginWindow(Frame parent) {
        super(parent, "Login", true);

        String sqlServerIp = "localhost";
        userBL = new UserManagementBusinessLogic(sqlServerIp);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = userBL.login(getUsername(), getPassword());
                if (response.equals("true")) {
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            response,
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                        
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    /**
     * The getter method of username
     * @return username
     */
    public String getUsername() {
        return tfUsername.getText().trim();
    }

    /**
     * The getter method of password 
     * @return password
     */
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    /**
     * The getter method of succeeded
     * @return If the user successfully logged in
     */
    public boolean isSucceeded() {
        return succeeded;
    }
}
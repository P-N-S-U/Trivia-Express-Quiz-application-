
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// public class LoginApp {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(LoginFrame::new);
//     }
// }

class LoginFrame2 extends JFrame implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;
    JButton loginButton = new JButton("Login");

    public LoginFrame2() {
        setTitle("Login Page");                             //Jframe here
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Create a gradient background
                GradientPaint gradientPaint = new GradientPaint(
                        0, 0, new Color(52, 152, 219),
                        getWidth(), getHeight(), new Color(52,218,201));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new GridBagLayout());
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();                      
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login Page");                           //Jlable of login page
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);

        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        usernameField.setBackground(new Color(52, 152, 219));
        usernameField.setForeground(Color.WHITE);
        //usernameField.setPreferredSize(new Dimension(90, 40));

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setBackground(new Color(52, 152, 219));
        passwordField.setForeground(Color.WHITE);
        //passwordField.setPreferredSize(new Dimension(90, 40));

        
        loginButton.setBackground(new Color(52, 73, 94));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 10;
        contentPane.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 10;
        contentPane.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPane.add(loginButton, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loginButton){
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
                    
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                new title();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
            }
        }
    }
}

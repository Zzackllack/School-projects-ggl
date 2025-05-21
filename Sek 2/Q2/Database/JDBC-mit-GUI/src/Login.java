/**
 *
 * @author zacklack
 * @version 1.0
 * @since 2025-19-05
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login implements ActionListener{

    //declare instance variables
    private JFrame frame;
    Container pane;
    JPanel Master, centerInfo, buttonInfo;
    JLabel jlb_username, jlb_password, jlb_email;
    JTextField jtf_username,jtf_email;
    JPasswordField jtf_password;
    JButton jb_login, jb_signup;
    Connection conn;
    private String username, password;


    public void init_connection(){
        try {
            // Lade Derby Client-Treiber
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Verbinde mit Derby Network Server auf Port 1527, erstelle DB "world" falls nicht vorhanden
            String url = "jdbc:derby://localhost:1527/world;create=true";
            conn = DriverManager.getConnection(url);
            // Sicherstellen, dass Tabelle LOGIN_INFO existiert
            try (Statement st = conn.createStatement()) {
                st.executeUpdate(
                    "CREATE TABLE LOGIN_INFO (" +
                    "USERNAME VARCHAR(50) PRIMARY KEY, " +
                    "PASSWORD VARCHAR(50) NOT NULL)"
                );
            } catch (SQLException e) {
                // Tabelle existiert möglicherweise schon
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC-Driver nicht gefunden: " + e);
        } catch (SQLException ex) {
            System.err.println("Verbindungsfehler: " + ex);
        }
    }


    public void start_gui(){
        //setup frame, pane, and panels. put panels into pane
        frame = new JFrame("Login to Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new Container();
        pane = frame.getContentPane();
        Master = new JPanel();
        centerInfo = new JPanel(new GridBagLayout());
        buttonInfo = new JPanel(new FlowLayout(FlowLayout.LEADING,10,5));
        Master.add(centerInfo, BorderLayout.CENTER);
        Master.add(buttonInfo, BorderLayout.SOUTH);
        pane.add(Master);
        laycomponents();
        frame.setSize(300, 150);
        frame.setVisible(true);
    }


    private void laycomponents(){
        //put components in panels: two labels, two textfields, two buttons
        //create constraints
        GridBagConstraints topComponents = new GridBagConstraints();
        GridBagConstraints centerComponents = new GridBagConstraints();

        //initialize
        jlb_username = new JLabel("Username");
        jlb_password = new JLabel("Password");
        jtf_username = new JTextField(15);
        jtf_password = new JPasswordField(15);
        jb_login     = new JButton("Login");
        jb_signup    = new JButton("Sign up");

        //insert into panels
        topComponents.insets = new Insets(50,5,5,5);    //username components
        topComponents.gridx = 0;
        topComponents.gridy = 2;
        centerInfo.add(jlb_username, centerComponents);
        topComponents.gridx = 1;
        topComponents.gridy = 2;
        centerInfo.add(jtf_username, centerComponents);
        centerComponents.insets = new Insets(10,10,10,10);  //password components
        centerComponents.gridx = 0;
        centerComponents.gridy = 3;
        centerInfo.add(jlb_password, centerComponents);
        centerComponents.gridx = 1;
        centerComponents.gridy = 3;
        centerInfo.add(jtf_password, centerComponents);
        buttonInfo.add(jb_login);
        buttonInfo.add(jb_signup);

        //add action listener

        jb_login.addActionListener(this);
        jb_signup.addActionListener(this);
        jtf_username.addActionListener(this);
        jtf_password.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        username = jtf_username.getText();
        password = new String(jtf_password.getPassword());
        if(e.getSource() == jb_login)
        {
            checkforLogin();
        }
        else if(e.getSource() == jb_signup)
        {
            //
        }


    }

    private void checkforLogin()
    {
        try
        {
            String instr = "SELECT *FROM login_info WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(instr);
            ps.setString(1, username);
            ps.setString(2, password);
            System.out.println(username + " " + password);
            ResultSet rset = ps.executeQuery();
            if(!rset.next()) JOptionPane.showMessageDialog(frame, "Incorrect username or password, please try again","Access Error",JOptionPane.ERROR_MESSAGE);
            else startAddressBook();

        }catch(Exception e) { System.err.println("checking for login "+ e);}
    }

    private void startAddressBook() throws SQLException
    {
        //close previous gui db connection
        conn.close();
        frame.dispose();
        AddressBook a = new AddressBook();
        a.init_connection();
        a.start_gui();
    }

}

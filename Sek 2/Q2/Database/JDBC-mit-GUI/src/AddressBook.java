/*
 * Address book gui has CRUD operations and mysql database access
 * use interface for gui's? 
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class AddressBook implements ActionListener{


    JFrame frame;
    JPanel Master, centerInfo, buttonInfo;
    GridBagConstraints constraints;
    GridBagConstraints topconstraint;
    JLabel jlb_firstName, jlb_lastName, jlb_phoneNum, jlb_searchInfo;
    JTextField jtf_firstName, jtf_lastName, jtf_phoneNum;
    JTextArea jta_searchInfo;
    JButton jb_add, jb_search, jb_share, jb_delete;
    Container pane;

    Connection conn;
    String firstName, lastName, phoneNum;



    public void init_connection(){
        try {
            // Lade Derby Client-Treiber
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Verbinde mit Derby Network Server, erstelle DB "addressbook" falls nicht vorhanden
            String url = "jdbc:derby://localhost:1527/addressbook;create=true";
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void start_gui()
    {   
        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = new Container();
        pane = frame.getContentPane();
        layComponents(pane);
        //frame.setSize(400, 400);
        frame.setSize(400,400);
        frame.setVisible(true);

    }

    private void layComponents(Container contentPane)
    {
        //PANELS,CONTENTPANE,CONSTRAINTS
        JPanel Master = new JPanel();
        JPanel centerInfo = new JPanel(new GridBagLayout());
        JPanel buttonInfo = new JPanel(new FlowLayout(FlowLayout.LEADING,10,5));
        Master.add(centerInfo, BorderLayout.CENTER);
        Master.add(buttonInfo, BorderLayout.SOUTH);
        contentPane.add(Master);                        //set style of layout for GUI
        GridBagConstraints constraints = new GridBagConstraints();      //layout constraints
        GridBagConstraints topconstraint = new GridBagConstraints();    //constraint against top of GUI

        constraints.insets = new Insets(5,5,10,10);
        //components: firstName, lastName, phoneNum, info, Add, Search(need to add oracle sql db)

        //LABELS
        jlb_firstName = new JLabel("First Name");
        topconstraint.gridx =1;
        topconstraint.gridy =0;
        topconstraint.insets = new Insets(20,5,10,10);                  //Insets(top,left,right,down)
        centerInfo.add(jlb_firstName, topconstraint);
        jlb_lastName = new JLabel("Last Name");
        constraints.gridx =1;
        constraints.gridy =2;
        centerInfo.add(jlb_lastName,constraints);
        jlb_phoneNum = new JLabel("Phone Number");
        constraints.gridx =1;
        constraints.gridy =4;
        centerInfo.add(jlb_phoneNum,constraints);
        jlb_searchInfo = new JLabel("Search Info");
        constraints.gridx =1;
        constraints.gridy =6;
        centerInfo.add(jlb_searchInfo, constraints);

        //TEXTFIELDS
        jtf_firstName = new JTextField("Enter New First Name");     //to clear textfield when clicked need actionlisteners
        topconstraint.gridx =3;
        topconstraint.gridy =0;
        centerInfo.add(jtf_firstName,topconstraint);
        jtf_lastName = new JTextField("Enter New Last Name");
        constraints.gridx =3;
        constraints.gridy =2;
        centerInfo.add(jtf_lastName, constraints);
        jtf_phoneNum = new JTextField("Enter in ###-###-#### format");
        constraints.gridx =3;
        constraints.gridy =4;
        centerInfo.add(jtf_phoneNum, constraints);

        //TEXTAREA
        Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        jta_searchInfo = new JTextArea(10,20);
        jta_searchInfo.append("click me");
        jta_searchInfo.setEditable(true);

        jta_searchInfo.setBorder(loweredetched);
        constraints.gridx =3;
        constraints.gridy =6;
        centerInfo.add(jta_searchInfo, constraints);

        //buttons will use flowlayout
        //BUTTONS
        jb_add = new JButton("Add");
        buttonInfo.add(jb_add);
        jb_search = new JButton("Search");
        buttonInfo.add(jb_search);
        jb_share = new JButton("Share");
        buttonInfo.add(jb_share);                               //share info with ppl. need a new share gui
        jb_delete = new JButton("delete");
        buttonInfo.add(jb_delete);

        //Listen for any component actions performed
        jb_add.addActionListener(this);
        jb_delete.addActionListener(this);
        jb_search.addActionListener(this);
        jb_share.addActionListener(this);   
    }



    public void actionPerformed(ActionEvent e) {

        firstName = jtf_firstName.getText().toLowerCase();
        lastName = jtf_lastName.getText().toLowerCase();
        phoneNum = jtf_phoneNum.getText();

        if(e.getSource() == jb_add)
        {
            AddtoRecord();
        }
        else if(e.getSource() == jb_delete)
        {
            deletefromRecord(); 
        }
        else if(e.getSource() == jb_search)
        {

        }
        else if(e.getSource() == jb_share)
        {

        }
    }


    private void AddtoRecord()
    {   
        try
        {
            System.out.println(firstName + " " + lastName + " " + phoneNum);

            String instruction = "Insert into address (firstName, lastName, phonNum)" + "VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(instruction);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNum);
            preparedStatement.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            firstName = "";
            lastName = "";
            phoneNum = "";
        }

    }


    private void deletefromRecord()
    {
        //find then remove. require at least first name
        if(firstName.equals(null) || lastName.equals(null))
        {
            System.out.println("Enter first or last Name");
        }
        else
        {
        try
        {

            String instr = "DELETE FROM address WHERE firstName=? OR lastName=?";
            PreparedStatement ps = conn.prepareStatement(instr);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeUpdate();

        }catch(Exception e){ System.err.println(e + "delete");}
        }
    }


    private void searchfromRecord()
    {
        try
        {
            String instr = "SELECT firstName, lastName, phonNum WHERE firstName='%" +firstName+"%'";
            Statement s = conn.createStatement();
            ResultSet rset = s.executeQuery(instr);
            while(rset.next())
            {
                jta_searchInfo.setText(rset.getString("firstName"));
                jta_searchInfo.setText(rset.getString("lastName"));
                jta_searchInfo.setText(rset.getString("phonNum"));
            }
        } catch(Exception e){System.err.println(e + "search");}

    }

}
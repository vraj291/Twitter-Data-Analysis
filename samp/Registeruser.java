package samp;

import java.awt.BorderLayout;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Registeruser extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField uname;
	private JTextField email;
	private JPasswordField pass;
	private JPasswordField conpass;


	public Registeruser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(510, 200, 500, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register as a new user");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 23, 466, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name : ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 93, 119, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 138, 119, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 228, 119, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 183, 119, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 273, 119, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 318, 119, 35);
		contentPane.add(lblNewLabel_6);
		
		fname = new JTextField();
		fname.setBounds(139, 97, 337, 27);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(139, 142, 337, 27);
		contentPane.add(lname);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(139, 187, 337, 27);
		contentPane.add(uname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(139, 232, 337, 27);
		contentPane.add(email);
		
		JButton btnNewButton = new JButton(" Confirm");
		btnNewButton.setBounds(190, 390, 85, 27);
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setBounds(139, 324, 337, 26);
		contentPane.add(pass);
		
		conpass = new JPasswordField();
		conpass.setEchoChar('*');
		conpass.setBounds(139, 279, 337, 26);
		contentPane.add(conpass);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fname.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"The first name field is a compulsary field.");
				return;
				}
				if(lname.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"The last name field is a compulsary field.");
				return;
				}
				if(uname.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"The username field is a compulsary field.");
				return;
				}
				if(pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"The password field is a compulsary field.");
				return;
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://127.0.0.1:3306/login","root","buntee29");
			    if(conpass.getText().equals(pass.getText())) {
			    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			    if(email.getText().matches(regex)){
			    Statement st=con.createStatement();
			    ResultSet r=st.executeQuery("select * from passwords where USERNAME='"+uname.getText()+"'");
			    if(r.next()) {
			    	uname.setText(null);
			    	pass.setText(null);
			    	conpass.setText(null);
			    	JOptionPane.showMessageDialog(null,"The username you entered is already taken.");
			    }else {
			    	JOptionPane.showMessageDialog(null,"You have succesfully registered.");
			    	st.execute("insert into passwords values('"+fname.getText()+"','"+lname.getText()+"','"+uname.getText()+"','"+email.getText()+"','"+pass.getText()+"')");
			    	setVisible(false);
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					Mainmenu frame = new Mainmenu("Main menu",Mainmenu.mm);
            					frame.setVisible(true);
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		});
			    }
			    }else {
			    	email.setText(null);
			    	uname.setText(null);
			    	pass.setText(null);
			    	conpass.setText(null);
			    	JOptionPane.showMessageDialog(null,"The entered email address is invalid.");
			    }
			   }else {
				   pass.setText(null);
			       conpass.setText(null);
				   JOptionPane.showMessageDialog(null,"The password and confirm password fields do not match.");
			   }
			 } catch (Exception e1) {
					System.out.println("Could not access Database.");
					e1.printStackTrace();
				} 
			}
		});
	}
}

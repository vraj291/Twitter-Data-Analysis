package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.*;
import javax.swing.JPasswordField;
public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pass;

	
	public LoginPage() {
		setBackground(new Color(153, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 451, 418);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("LOGIN IN TO YOUR ACCOUNT");
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lb1.setBounds(36, 21, 391, 34);
		contentPane.add(lb1);
		
		JLabel lblNewLabel = new JLabel("Enter Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(36, 83, 147, 34);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(36, 138, 391, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(36, 190, 391, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("")) {
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
			    Statement st=con.createStatement();
			    ResultSet r=st.executeQuery("select * from passwords where USERNAME='"+name.getText()+"' and PASSWORD='"+pass.getText()+"'");
			    if(r.next()) {
			    	JOptionPane.showMessageDialog(null,"Login Successful.");
                    setVisible(false);
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					Mainmenu frame = new Mainmenu("Main Menu",Mainmenu.mm);
            					frame.setVisible(true);
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		});
			    }else {
			        name.setText(null);
			        pass.setText(null);
			    	JOptionPane.showMessageDialog(null,"The entered username or password are incorrect.");
			    }
			 } catch (Exception e1) {
					System.out.println("Could not access Database.");
					e1.printStackTrace();
				} 
			}
		});
		loginbtn.setBounds(174, 317, 110, 24);
		contentPane.add(loginbtn);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setBounds(36, 236, 391, 19);
		contentPane.add(pass);
	}
}

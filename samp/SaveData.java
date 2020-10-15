package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SaveData extends JFrame {

	private JPanel contentPane;
	private JTextField us;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveData frame = new SaveData(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String user,label,title;
	int n;
	boolean isrun=true;
	public SaveData(int i) {
		switch(i) {
		case 0:
			label="User : ";
			title="Save Tweets to Database";
	    break;
		case 1:
			label="Phrase : ";
			title="Save Tweets to Database";
		break;
		case 2:
			label="Phrase : ";
            title="Stream live tweets";
		break;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setBounds(30, 10, 396, 28);
		contentPane.add(lblNewLabel);
		
		us = new JTextField();
		us.setBounds(195, 93, 180, 28);
		contentPane.add(us);
		us.setColumns(10);
		
		num = new JTextField();
		num.setColumns(10);
		num.setBounds(195, 149, 180, 28);
		if(i!=2)
		contentPane.add(num);
		
		JLabel lblNewLabel_1 = new JLabel(label);
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(30, 89, 81, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number of tweets : ");
		lblNewLabel_1_1.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 146, 154, 28);
		if(i!=2)
		contentPane.add(lblNewLabel_1_1);
		
		JButton con = new JButton("Continue");
		con.setFont(new Font("Tahoma", Font.PLAIN, 12));
		con.setBounds(166, 218, 92, 28);
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 if(i==2)
				 num.setText("0");
		     if(num.getText().equals("")||us.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"A compulsary field was left empty.");
						return;
		     }
		     user=us.getText();
		     n=Integer.valueOf(num.getText());
		     isrun=false;
		     setVisible(false);
		    }	
		});
		contentPane.add(con);
	}

}

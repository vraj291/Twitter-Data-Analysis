package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Selectcolumn extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField text;
	private JTextField loc;
	private JLabel lblNewLabel_4;
	private JTextField time;
	private JButton btn;

	public static void main(String[] args) {
		Selectcolumn nw=new Selectcolumn();
		nw.setVisible(true);
	}
	String query;
	private JTextField lan;
	private JLabel lblNewLabel_5;
	private JTextField retw;
	private JLabel lblNewLabel_6;
	public Selectcolumn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 220, 450, 300);
		setSize(500,453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select the specific fields for the tweets ");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 10, 416, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 62, 105, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TEXT : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 118, 105, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LOCATION : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 173, 105, 32);
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(101, 62, 358, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		text = new JTextField();
		text.setBounds(101, 119, 358, 32);
		contentPane.add(text);
		text.setColumns(10);
		
		loc = new JTextField();
		loc.setBounds(101, 174, 358, 32);
		contentPane.add(loc);
		loc.setColumns(10);
		
		lblNewLabel_4 = new JLabel("TIME :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 223, 105, 32);
		contentPane.add(lblNewLabel_4);
		
		time = new JTextField();
		time.setBounds(101, 224, 358, 32);
		contentPane.add(time);
		time.setColumns(10);

		lan = new JTextField();
		lan.setColumns(10);
		lan.setBounds(101, 278, 358, 32);
		contentPane.add(lan);
		
		lblNewLabel_5 = new JLabel("LANGUAGE :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 278, 105, 32);
		contentPane.add(lblNewLabel_5);
		
		retw = new JTextField();
		retw.setColumns(10);
		retw.setBounds(101, 332, 358, 32);
		contentPane.add(retw);
		
		lblNewLabel_6 = new JLabel("RETWEET :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 332, 105, 32);
		contentPane.add(lblNewLabel_6);
		
		btn = new JButton("Continue");
		btn.setBounds(200, 385, 96, 21);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Continue"))
		        {   
		    		if(retw.getText().equals("yes")) {
		    			retw.setText("true");
		    		}
		    		else if(retw.getText().equals("no")) {
		    			retw.setText("false");
		    		}
		            query= "where NAME like '%"+name.getText()+"%' and TEXT like '%"+text.getText()+"%' and LOCATION like '%"+loc.getText()+"%' and DATE like '%"+time.getText()
		            		+"%' and LANGUAGE like '%"+lan.getText()+"%' and isRETWEET like '%"+retw.getText()+"%' ";
		            setVisible(false);
		        }
			}
		});
		contentPane.add(btn);
		
	}
}

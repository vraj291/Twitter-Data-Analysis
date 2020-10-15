package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Displaydata extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String[] names= {"Id","Name","Text","Location","Created at","Is Retweet","Number of Favourites","Number of Retweets","Language"};
	boolean isrun=true;
	public Displaydata(String[][] args) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Query Results");
		setBounds(20, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selected Tweets");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setBounds(520, 20, 396, 28);
		contentPane.add(lblNewLabel);
		
		table = new JTable(args,names);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(120, 60, 1200, 600);
		contentPane.add(scroll);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(675,700 , 92, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 isrun=false;
		     setVisible(false);
			}});
		contentPane.add(btnNewButton);
	}
}

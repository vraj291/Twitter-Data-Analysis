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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GetTrends extends JFrame {

	private JPanel contentPane;
	private JTextField no;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetTrends frame = new GetTrends();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int num=0;
	public GetTrends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the number of trends to compare ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 21, 346, 45);
		contentPane.add(lblNewLabel);
		
		no = new JTextField();
		no.setFont(new Font("Tahoma", Font.PLAIN, 16));
		no.setText("2");
		no.setBounds(149, 128, 131, 26);
		contentPane.add(no);
		no.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  ( A value between 2 and 6 )");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(47, 63, 346, 26);
		contentPane.add(lblNewLabel_1);

		JButton con = new JButton("Continue");
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(no.getText())<2 || Integer.valueOf(no.getText())>6){
					JOptionPane.showMessageDialog(null,"A invalid value was entered.");
				return;
				}
				num=Integer.valueOf(no.getText());
				setVisible(false);
			}});
		con.setBounds(166, 213, 97, 26);
		contentPane.add(con);
	}
}

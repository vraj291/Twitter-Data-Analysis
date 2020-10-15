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

import javax.swing.JButton;

public class Conorexit extends JFrame {

	private JPanel contentPane;
    int des=-1;
	public Conorexit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(570, 270, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Would you like to continue or exit ?");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 117);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(60, 198, 114, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Continue"))
		        {
		            des=0;
		            setVisible(false);
		        }
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.setBounds(255, 198, 114, 30);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Exit"))
		        {
		            des=1;
		            setVisible(false);
		        }
			}
		});
		contentPane.add(btnExit);
	}

}

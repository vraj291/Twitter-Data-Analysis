package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ThankYou extends JFrame {

	private JPanel contentPane;
    String label;
	public ThankYou(int i) {
		switch(i) {
		case 0:
		    label="Thank You for using Twitter Analytics.";
		break;
		case 1:
			label="The selected tweets were stored succesfully.";
		break;	
		case 2:
			label="The selected tweets were deleted succesfully.";
		break;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(label);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 34, 416, 192);
		contentPane.add(lblNewLabel);
	}

}

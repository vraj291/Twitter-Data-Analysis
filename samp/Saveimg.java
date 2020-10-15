package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Saveimg extends JFrame {

	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saveimg frame = new Saveimg(1);
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
	String img;
	boolean save=false,isrun=true;
	String label,type,exten;
	public Saveimg(int i) {
		switch(i) {
		case 0:
			label="Would you like to save the image?";
			type="image";
			exten=".png";
	    break;
		case 1:
			label="Enter a name for the excel file.";
			type="image";
			exten=".xlsx";
			break;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(570, 270, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(label);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 416, 37);
		contentPane.add(lblNewLabel);
		

		JLabel lab = new JLabel("The "+type+" will stored as D:/sample"+exten);
		lab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setBounds(65, 148, 306, 37);
		contentPane.add(lab);
		
		name = new JTextField();
		name.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		name.setText("sample");
		name.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				lab.setText("The "+type+" will stored as D:/"+name.getText()+exten);
			}
		    public void insertUpdate(DocumentEvent e) {
				lab.setText("The "+type+" will stored as D:/"+name.getText()+exten);
		    }
			public void changedUpdate(DocumentEvent e) {
				lab.setText("The "+type+" will stored as D:/"+name.getText()+exten);
			}
		});;
		name.setBounds(65, 95, 306, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		
		JButton yes = new JButton("Yes");
		yes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		yes.setBounds(65, 217, 85, 26);
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"A invalid value was entered.");
					return;
				}
				img="D:/"+name.getText()+exten;
				save=true;
				isrun=false;
				setVisible(false);
			}});
		contentPane.add(yes);
		
		JButton no = new JButton("No");
		no.setFont(new Font("Tahoma", Font.PLAIN, 12));
		no.setBounds(286, 217, 85, 26);
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save=false;
				isrun=false;
				setVisible(false);
			}});
		contentPane.add(no);
	}

}

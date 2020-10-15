package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GetUsers extends JFrame {

	private JPanel contentPane;
	private JTextField u1;
	private JTextField u2;
   public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
		    GetUsers frame = new GetUsers();
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
   }

	String u[]=new String[6],user[];
	boolean isrun=true;
	private JTextField u3;
	private JTextField u4;
	private JTextField u5;
	private JTextField u6;
	public GetUsers() {
		setTitle("Twitter Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 475, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the usernames or screennames");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 426, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First user :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 83, 128, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Second User : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 126, 128, 33);
		contentPane.add(lblNewLabel_2);
		
		u1 = new JTextField();
		u1.setBounds(114, 88, 312, 25);
		contentPane.add(u1);
		u1.setColumns(10);
		
		u2 = new JTextField();
		u2.setColumns(10);
		u2.setBounds(114, 128, 312, 25);
		contentPane.add(u2);
		
		JButton btn = new JButton("Continue");
		btn.setBounds(165, 353, 100, 21);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Continue"))
		        {
		            int c=0;
		    		u[0]=u1.getText();
		            u[1]=u2.getText();
		            u[2]=u3.getText();
		            u[3]=u4.getText();
		            u[4]=u5.getText();
		           	u[5]=u6.getText();
		           	for(int i=0;i<6;i++) {
		           		if(!(u[i].equals("")))
		           			c++;
		           	}
		           	if(c<2) {
						JOptionPane.showMessageDialog(null,"The minimum requirements are not met.");
					return;
					}
		           	user=new String[c];
		           	c=0;
		           	for(int i=0;i<6;i++) {
		           		if(!(u[i].equals(""))) {
		           			user[c]=u[i];
		           		    c++;
		           		}
		           	}
		           	isrun=false;
		            setVisible(false);
		        }
			}
		});
		contentPane.add(btn);
		
		u3 = new JTextField();
		u3.setBounds(114, 174, 312, 25);
		contentPane.add(u3);
		u3.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Third User : ");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 169, 128, 33);
		contentPane.add(lblNewLabel_2_1);
		
		u4 = new JTextField();
		u4.setColumns(10);
		u4.setBounds(114, 219, 312, 25);
		contentPane.add(u4);
		
		u5 = new JTextField();
		u5.setColumns(10);
		u5.setBounds(114, 259, 312, 25);
		contentPane.add(u5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Fourth User : ");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 214, 128, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Fifth User : ");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(10, 254, 128, 33);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Sixth User : ");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_3.setBounds(10, 294, 128, 33);
		contentPane.add(lblNewLabel_2_1_3);
		
		u6 = new JTextField();
		u6.setColumns(10);
		u6.setBounds(114, 297, 312, 25);
		contentPane.add(u6);
	}
}

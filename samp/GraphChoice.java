package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GraphChoice extends JFrame {
    String choice[]= {"Pie Chart","Bar Graph","Bubble Chart"};
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphChoice frame = new GraphChoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   int checks=0;
   boolean isrun=true;	
	public GraphChoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 230, 450, 313);
		contentPane = new JPanel();
		setTitle("Graph Choice");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox pie = new JCheckBox("Pie Chart");
		pie.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		pie.setBounds(63, 88, 111, 46);
		contentPane.add(pie);
		
		JCheckBox bar = new JCheckBox("Bar Graph");
		bar.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		bar.setBounds(254, 88, 111, 46);
		contentPane.add(bar);
		
		JCheckBox bub = new JCheckBox("Scatter Plot");
		bub.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		bub.setBounds(254, 136, 111, 46);
		contentPane.add(bub);
		
		JLabel lblNewLabel = new JLabel("Choose the type of visualization");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setBounds(41, 27, 362, 42);
		contentPane.add(lblNewLabel);
		

		JCheckBox line = new JCheckBox("Line Graph");
		line.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
		line.setBounds(63, 136, 111, 46);
		contentPane.add(line);
		
		JButton con = new JButton("Continue");
		con.setFont(new Font("Tahoma", Font.PLAIN, 12));
		con.setBounds(163, 234, 101, 32);
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Continue"))
		        {
		            if(bar.isSelected())
		            	checks++;
		            if(pie.isSelected())
		            	checks++;
		            if(bub.isSelected())
		            	checks++;
		            if(line.isSelected())
		            	checks++;
		            if(checks>1) {
		            	JOptionPane.showMessageDialog(null,"Only one field needs to be selected.");
		            	checks=0;
					return;
					}
		            if(bar.isSelected())
		            	checks=0;
		            if(pie.isSelected())
		            	checks=1;
		            if(bub.isSelected())
		            	checks=2;
		            if(line.isSelected())
		            	checks=3;
		            isrun=false;
		            setVisible(false);
		        }
			}
		});
		contentPane.add(con);
		
	}
}

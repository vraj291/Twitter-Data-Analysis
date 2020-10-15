package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class StreamingData extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StreamingData frame = new StreamingData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static String[] names= {"Id","Name","Text","Location","Created at","Is Retweet","Language"};
	boolean isrun=true,ispause=false;
	DefaultTableModel model=new DefaultTableModel(names,0);
	String add[]= {};
	public void add(String[] arr) {
       model.addRow(arr);
	}
	public StreamingData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Query Results");
		setBounds(20, 20, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Live Twitter Feed");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 17));
		lblNewLabel.setBounds(520, 20, 396, 28);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(model);

		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(120, 60, 1200, 600);
		contentPane.add(scroll);
		
		JButton btnNewButton = new JButton("Leave");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(800,700 , 92, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 isrun=false;
			 Streaming.isrun=false;
		     setVisible(false);
			}});
		contentPane.add(btnNewButton);
		
		JButton pause = new JButton("Pause");
		pause.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pause.setBounds(500,700 , 92, 28);
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     if(pause.getText().equals("Pause")) {		
			 ispause=true;
			 pause.setText("Play");
		     }
		     else {
		    	 ispause=false;
				 pause.setText("Pause");
		     }
			}});
		contentPane.add(pause);
		
		setVisible(true);
	}

}

package samp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.BasicConfigurator;
import org.jfree.ui.RefineryUtilities;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Mainmenu extends JFrame {
	
	private JPanel contentPane;
	static int in=-1;
	GetUsers frame;
    static String mm[]= {"Compare any two or more selected tweets from specific users.","Compare any two or more users.","Get the latest trends around the world."
    		,"Access the database.","Export tweet data in the form of an excel sheet.","Stream live tweets.","Exit the application."};
    static String usersm[]= {"Compare the number of their followers and friends.","Compare the number of their tweets posted and tweets favourited."};
    static String datasm[]= {"Add tweet data to the database.","Access tweet data from the database.","Delete existing tweet data from the database."};
    static String excelsm[]= {"Export data from the database.","Export specific tweets by users.","Export tweets with specific phrases."};
	public Mainmenu(String arg1,String arg2[]) {
		BasicConfigurator.configure();
	      ConfigurationBuilder cf=new ConfigurationBuilder();
	      cf.setDebugEnabled(true)
	      .setOAuthConsumerKey("kQAALCx9iTSNUy5W3rjM3v554")
	      .setOAuthConsumerSecret("N7DWsOGerqcFVwKMIjDfCNLlT6nTPs7OmyTGe45RR3OeMWkqv7")
	      .setOAuthAccessToken("1283736553781473282-ZOGfaJH9Y5MFsciCVAEbwXjnFY366Q")
	      .setOAuthAccessTokenSecret("ogzR33IYiAS8fbHA7zJAn04uATWpTyzR0P7zgYnNdjIjU");
		TwitterFactory tf=new TwitterFactory(cf.build());
		twitter4j.Twitter twitter=tf.getInstance();
      TwitterFunc t1=new TwitterFunc(twitter);
      TwitterFunc t2=new TwitterFunc(twitter);
      BoxWindow bw1=new BoxWindow();
      BoxWindow bw2=new BoxWindow();
  
		getContentPane().setLayout(null);
		
		setBounds(20,20,1500,800);
		JList<String> list = new JList<String>(arg2);
		list.setBounds(350, 175, 800, 500);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jsp=new JScrollPane(list);
	
		jsp.setPreferredSize(new Dimension(1000,700));
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(700, 700, 100, 25);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Select"))
		        {
		            int index = list.getSelectedIndex();
		            setVisible(false);
		            in=index;
		        }
		    }	
		});
		getContentPane().add(list);
		JLabel lblNewLabel = new JLabel(arg1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 40));
		lblNewLabel.setBounds(575, 40, 350, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose an option. Everything is functional.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(618, 121, 275, 25);
		getContentPane().add(lblNewLabel_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,800);
	}
}


package samp;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import twitter4j.*;
public class BoxWindow extends Thread {
    int in=-1;
	public void getChoiceWindow(String[] args,String r) {
		JFrame jf=new JFrame(r);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1500,800);
		JList<String> jl=new JList<String>(args);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jsp=new JScrollPane(jl);
		JButton sel=new JButton("Select");
		sel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if (e.getActionCommand().equals("Select"))
		        {
		            int index = jl.getSelectedIndex();
		            jf.setVisible(false);
		            in=index;
		        }
		    }	
		});
		jsp.setPreferredSize(new Dimension(1000,700));
		JLabel jlab=new JLabel("Choose an option.");
		jl.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				int index=jl.getSelectedIndex();
				if(index!=-1)
					jlab.setText("Selected option : " + args[index]);
				else
					jlab.setText("Choose a option.");
			}
		});
		jf.add(jsp);
		jf.add(jlab);
		jf.add(sel);
		jf.setVisible(true);
	}
	}


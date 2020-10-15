package samp;
import java.awt.EventQueue;
import java.io.File;
import java.util.Arrays;

import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.general.Dataset;
import org.jfree.ui.RefineryUtilities;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
public class MainAct {

 	public static void main(String[] args) throws Exception {
 		int i;
		BasicConfigurator.configure();
	      ConfigurationBuilder cf=new ConfigurationBuilder();
	      cf.setDebugEnabled(true)
	      .setOAuthConsumerKey("kQAALCx9iTSNUy5W3rjM3v554")
	      .setOAuthConsumerSecret("N7DWsOGerqcFVwKMIjDfCNLlT6nTPs7OmyTGe45RR3OeMWkqv7")
	      .setOAuthAccessToken("1283736553781473282-ZOGfaJH9Y5MFsciCVAEbwXjnFY366Q")
	      .setOAuthAccessTokenSecret("ogzR33IYiAS8fbHA7zJAn04uATWpTyzR0P7zgYnNdjIjU");
		TwitterFactory tf=new TwitterFactory(cf.build());
		twitter4j.Twitter twitter=tf.getInstance();
        TwitterFunc t[]=new TwitterFunc[6];
        BoxWindow bw[]=new BoxWindow[6];
        Graphs gr=new Graphs();
        Database db=new Database();
        for(i=0;i<6;i++) {
        	t[i]=new TwitterFunc(twitter);
        	bw[i]=new BoxWindow();
        }
        boolean loop=true;
        int check;
        EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				Welcome frame = new Welcome();
    				frame.setVisible(true);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
        while(loop) {
        while(Mainmenu.in<0) {
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        check=Mainmenu.in;
        switch(Mainmenu.in) {
        case 0:
        		    GetUsers frame= new GetUsers();
        		    frame.setVisible(true);
        		    while(frame.isrun || frame.user.length<2) 
        				Thread.sleep(100);
        		    Status[] st=new Status[frame.user.length];
        		    for(i=0;i<frame.user.length;i++) {
		            bw[i].getChoiceWindow(t[i].convertString(t[i].searchUser(frame.user[i],100),t[i].searchUser(frame.user[i],100).length),t[i].getUserId(frame.user[i])+"'s Tweets");
		            while(bw[i].in<0) 
		            	Thread.sleep(100);
		            st[i]=t[i].tweets.get(bw[i].in);
        		    }
        		    GraphChoice gra= new GraphChoice();
        		    gra.setVisible(true);
        		    while(gra.isrun )
        				Thread.sleep(100);
        		    gr= new Graphs(gra.checks,st);       
                    gr.setVisible( true );
        break;
        case 1:
        	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu frame_2 = new Mainmenu("Compare",Mainmenu.usersm);
					frame_2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		    });
        	Mainmenu.in=-1;
        	while(Mainmenu.in<0) {
            	try {
    				Thread.sleep(100);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
            } 
        	frame= new GetUsers();
		    frame.setVisible(true);
		    while(frame.isrun || frame.user.length<2)
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    User[] u=new User[frame.user.length];
		    for(i=0;i<u.length;i++) {
		    t[i].getUserId(frame.user[i]);
		    u[i]=t[i].user;	
		    }
		    gra= new GraphChoice();
		    gra.setVisible(true);
		    while(gra.isrun )
				Thread.sleep(100);
        	switch(Mainmenu.in) {
        	case 0:
        		gr= new Graphs(Mainmenu.in,gra.checks,u);       
                gr.setVisible( true );
        	break;
        	case 1:
        		gr= new Graphs(Mainmenu.in,gra.checks,u);       
                gr.setVisible( true );
        	break;
        	}
        break;
        case 2: 
        	GetTrends tr= new GetTrends();
		    tr.setVisible(true);
		    while(tr.num<2 || tr.num>6) 
				Thread.sleep(100);
		    String trends[]=new String[tr.num];
		    int vol[]=new int[tr.num];
		    for(i=0;i<tr.num;i++) {
        	t[i].getTrends();
        	bw[i].getChoiceWindow(t[i].getTrendsNames(),"Current Trends");
        	while(bw[i].in<=0) {
        		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
            vol[i]=t[i].getTrendsVolume()[bw[i].in];
	    	trends[i]=t[i].getTrendsNames()[bw[i].in];
		    }
		    System.out.println(t[1].trends.getTrends().length);
		    gra= new GraphChoice();
		    gra.setVisible(true);
		    while(gra.isrun )
				Thread.sleep(100);
		    gr= new Graphs(gra.checks,trends,vol);       
            gr.setVisible( true );
        break;
        case 3:
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Mainmenu frame_2 = new Mainmenu("Compare",Mainmenu.datasm);
    					frame_2.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		    });
            	Mainmenu.in=-1;
            	while(Mainmenu.in<0) {
                	try {
        				Thread.sleep(100);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
                }
            	switch(Mainmenu.in) {
            	case 0:
            		SaveData sd=new SaveData(0);
            		sd.setVisible(true);
            		while(sd.isrun) {
            			Thread.sleep(100);
            		}
            		db.addData(t[0].searchUser(sd.user, sd.n));
            	break;	
            	case 1:
            		db.getData();
                break;
            	case 2:
            		db.deleteData();
            	break;	
            	}
        break;
        case 4:
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Mainmenu frame_2 = new Mainmenu("Compare",Mainmenu.excelsm);
    					frame_2.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		    });
            	Mainmenu.in=-1;
            	while(Mainmenu.in<0) {
                	try {
        				Thread.sleep(100);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
                }
            	SaveData sd;
            	switch(Mainmenu.in) {
            	case 0:
            		db.excelfile(db.getData());
                break;
                case 1:
                	sd=new SaveData(0);
            		sd.setVisible(true);
            		while(sd.isrun) {
            			Thread.sleep(100);
            		}
            		db.excelfile(t[0].searchUser(sd.user, sd.n));
            	break;
                case 2:
                	sd=new SaveData(1);
            		sd.setVisible(true);
            		while(sd.isrun) {
            			Thread.sleep(100);
            		}
            		db.excelfile(t[0].searchPhrase(sd.user,sd.n));
            	}
        break;	
        case 5:
        	sd=new SaveData(2);
    		sd.setVisible(true);
    		while(sd.isrun) {
    			Thread.sleep(100);
    		}
            Streaming.Streamtweets(sd.user);
    		while(Streaming.isrun)
    			Thread.sleep(100);
    		Streaming.isrun=true;
        break; 	
        case 6:
        	loop=false;
        break;
      }
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        if(check!=3 && check!=4 && check!=5 && check!=6) {
        Saveimg sv=new Saveimg(0);
        sv.setVisible(true);
        while(sv.isrun) {
        	Thread.sleep(100);
        }
        if(sv.save)
        	ChartUtilities.saveChartAsPNG(new File(sv.img), gr.graph, 570, 360);
        }
       Conorexit frame=new Conorexit();
       frame.setVisible(true);
       while(frame.des<0) {
    	   try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       }
       if(frame.des==0) {
    	gr.setVisible(false);   
        Mainmenu.in=-1;
        for(i=0;i<bw.length;i++)
        	bw[i].in=-1;
        EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				Mainmenu frame = new Mainmenu("Main Menu",Mainmenu.mm);
    				frame.setVisible(true);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
   }
       else if(frame.des==1) {
    	   gr.setVisible(false); 
    	   loop=false;
       }
   }
 	ThankYou frame=new ThankYou(0);
 	frame.setVisible(true);
 	
 }
}
   


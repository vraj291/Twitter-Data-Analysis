package samp;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*; 
import java.util.*;
import twitter4j.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Database {
	Connection con;
	Statement stmt;
	Database(){
		try {
	Class.forName("com.mysql.cj.jdbc.Driver"); 
    con = DriverManager.getConnection(  
    "jdbc:mysql://127.0.0.1:3306/Tweets","root","buntee29");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
    public void excelfile(String arr[][])throws Exception {
    	      XSSFWorkbook workbook = new XSSFWorkbook();
    	      XSSFSheet spreadsheet = workbook.createSheet( "Tweets Information");
    	      XSSFRow row;
    	      Map < String, Object[] > tweets = new TreeMap < String, Object[] >();
    	      tweets.put( "1", Displaydata.names);
    	      int i;
    	      for(i=0;i<arr.length;i++) {
    	      tweets.put( Integer.toString(i+2), new Object[] {arr[i][0],arr[i][1] ,arr[i][2],arr[i][3],arr[i][4],arr[i][5],arr[i][6],arr[i][7],arr[i][8]});
    	      }
    	      Set < String > keyid = tweets.keySet();
    	      int rowid = 0;
    	      for (String key : keyid) {
    	         row = spreadsheet.createRow(rowid++);
    	         Object [] objectArr = tweets.get(key);
    	         int cellid = 0;
    	         for (Object obj : objectArr){
    	            Cell cell = row.createCell(cellid++);
    	            cell.setCellValue((String)obj);
    	         }
    	      }
    	      Saveimg sv=new Saveimg(1);
    	        sv.setVisible(true);
    	        while(sv.isrun) {
    	        	Thread.sleep(100);
    	        }
    	        if(sv.save) {
    	      FileOutputStream out= new FileOutputStream(new File(sv.img));
				  workbook.write(out);
	    	      out.close();
    	        }
    	        workbook.close();
    	   }

   public String[] addTweets(String args[][]) {
	   int i,j,k;
	   String query[]=new String[args.length];
	   for(i=0;i<args.length;i++) {
	    	for(j=0;j<9;j++) {
	    		for(k=0;k<args[i][j].length();k++) {
	    			if(args[i][j].charAt(k)=='\'') {
	    				args[i][j]=args[i][j].substring(0,k+1)+'\''+args[i][j].substring(k+1,args[i][j].length());
	    				k+=2;
	       			}
	    		}
	    	}
	    	query[i] = "INSERT INTO tweet " + "VALUES("+Long.valueOf(args[i][0])+",'"+args[i][1]+"','"+args[i][2]+"','"+args[i][3]+"','"+args[i][4]
	    			+"','"+args[i][5]+"',"+Long.valueOf(args[i][6])+","+Long.valueOf(args[i][7])+",'"+args[i][8]+"')";
	    }
	   return query;
   }
   
    public void addData(String args[][])throws Exception{  
    Displaydata dd=new Displaydata(args);
    dd.setVisible(true);
    while(dd.isrun) {
    	Thread.sleep(100);
    }
    stmt=con.createStatement();
    String query[]=addTweets(args);
    for(int j=0;j<args.length;j++)
        stmt.executeUpdate(query[j]);
    ThankYou frame=new ThankYou(1);
     	frame.setVisible(true);
    Thread.sleep(3000);
    frame.setVisible(false);
    }
    
    public String[][] getData()throws Exception {
    	Selectcolumn frame= new Selectcolumn();
		frame.setVisible(true);
	    while(frame.query==null) {
    	   Thread.sleep(100);
       }
	    int j=0,count=0;
	   stmt=con.createStatement();
	   stmt.execute("use tweets");
	   ResultSet result=stmt.executeQuery("select count(*) from tweet "+frame.query) ;
	   while(result.next()) {
		   count=result.getInt(1);
	   }
	   String output[][]=new String[count][9];
	   result=stmt.executeQuery("select * from tweet "+frame.query) ;
	   System.out.println("select * from tweet "+frame.query);
	   while(result.next()) {
		   output[j][0]=result.getString("ID");
		   output[j][1]=result.getString("NAME");
		   output[j][2]=result.getString("TEXT");
		   output[j][3]=result.getString("LOCATION");
		   output[j][4]=result.getString("DATE");
		   output[j][5]=result.getString("isRETWEET");
		   output[j][6]=result.getString("FAVORITES");
		   output[j][7]=result.getString("RETWEETS");
		   output[j][8]=result.getString("LANGUAGE");
		   j++;
	   }
	   Displaydata dd=new Displaydata(output);
	    dd.setVisible(true);
	    while(dd.isrun) {
	    	Thread.sleep(100);
	    }
	    return output;
    }
    
    public void deleteData()throws Exception {
    	Selectcolumn frame= new Selectcolumn();
		frame.setVisible(true);
	    while(frame.query==null) {
    	   Thread.sleep(100);
       }
	    int j=0;
	   stmt=con.createStatement();
	   stmt.execute("use tweets");
	   stmt.execute("delete from tweet "+frame.query);
	   ThankYou fram=new ThankYou(2);
    	fram.setVisible(true);
       Thread.sleep(3000);
        fram.setVisible(false);
    }
    
    
}






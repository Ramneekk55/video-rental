package video_rental;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
public class VideoLauncher implements ActionListener{
	VideoStore ob1=new VideoStore();
	JTextField tf1,tf2;
	JButton b1,b2,b3,b4,b5,b6;
	JTextArea area;
	JLabel l1,l2;
	VideoLauncher(){
		JFrame f=new JFrame();
	    l1=new JLabel("Enter Video Name");  
	    l1.setBounds(50,20,130,30);
	    l2=new JLabel("Enter rating for Video");  
	    l2.setBounds(220,20,150,30);
		tf1=new JTextField();
		tf1.setBounds(50,50,150,20);
		tf1.setEditable(true);
		tf2=new JTextField();
		tf2.setBounds(220,50,150,20);
		tf2.setEditable(true);
		b1=new JButton("Add videos");
		b1.setBounds(50,100,150,50);
		b1.addActionListener(this);
		b2=new JButton("Check Out Video");
		b2.setBounds(50,150,150,50);
		b2.addActionListener(this);
		b3=new JButton("Return Video");
		b3.setBounds(50,200,150,50);
		b3.addActionListener(this);
		b4=new JButton("Receive Rating");
		b4.setBounds(50,250,150,50);
		b4.addActionListener(this);
		b5=new JButton("List Inventory");
		b5.setBounds(50,300,150,50);
		b5.addActionListener(this);
		area=new JTextArea(); 
		area.setBounds(220,100,200,250); 
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(tf2);
		f.add(area);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.setSize(450,450);
		f.setLayout(null);
		f.setVisible(true);
	}
	 public void actionPerformed(ActionEvent e) {
		// Video ob;
		 String s1=tf1.getText();
		 if(e.getSource()==b1) {
			 int d=ob1.addVideo(s1);
			 if(d==1)
			   area.setText("Video "+s1+" added succuessfully");
			 else 
			   area.setText("Video name cannot be empty");
		 }
		 if(e.getSource()==b2) {
			int d=ob1.doCheckout(s1);
			if(d==1)
			 area.setText("Video "+s1+" checked out \nsuccuessfully");
			else
			 area.setText("Video "+s1+" does not exists");
		 }
		 if(e.getSource()==b3) {
			 int d=ob1.doReturn(s1);
			 if(d==1) {
				 area.setText("Video "+s1+" returned successfully");
			 }
			 else {
				 area.setText("Video "+s1+" cannot be returned");
			 }
		 }
		 if(e.getSource()==b4) {
			 String s2=tf2.getText();
			 if(s2.equals("")) {
				 area.setText("Rating cannot be null");
			 }
			 else {
			 int r=Integer.parseInt(s2);
			 int d=ob1.receiveRating(s1, r);
			 if(d==1)
				 area.setText("Rating has been mapped \nto the video "+s1);
			 else
				 area.setText("Rating could not be mapped \nto the video "+s1);
			 }
		 }
		 if(e.getSource()==b5) {
			 String s=ob1.listInventory();
			 area.setText(s);
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new VideoLauncher();
	}

}

package Programs2_java;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.sql.*;

public class RegisterForm implements ActionListener{
	 JFrame frame;
	 String data,data2;
	  String[] gender={"Male","Female"};
	  String dates[]= { "1", "2", "3", "4", "5","6", "7", "8", "9", "10",
			  			"11", "12", "13", "14", "15","16", "17", "18", "19", "20",
			  			"21", "22", "23", "24", "25","26", "27", "28", "29", "30",
		            	"31" };
	  String months[]= { "Jan", "Feb", "Mar", "Apr", "May","Jun", "Jul", "Aug", "Sep", "Oct",
	  			       "Nov", "Dec"};
	  String years[]= { "1995", "1996", "1997", "1998",
		            "1999", "2000", "2001", "2002",
		            "2003", "2004", "2005"};
	  JLabel l1=new JLabel("NAME");
	  JLabel l2=new JLabel("ROLL NUMBER:");
	  JLabel l3=new JLabel("EMAIL ID:");
	  JLabel l4=new JLabel("CONTACT NUMBER:");
	  JLabel l5=new JLabel("DOB");
	  JLabel l6=new JLabel("GENDER");
	  JLabel l7=new JLabel("PASSWORD:");
	  JLabel l8=new JLabel("CONFIRM PASSWORD:");
	  
	  JTextField f1 = new JTextField(15);
	  JTextField f2 = new JTextField(15);
	  JTextField f3 = new JTextField(40);
	  JTextField f4 = new JTextField(15);
	  JComboBox date = new JComboBox(dates);
	  JComboBox month=new JComboBox(months);
	  JComboBox year=new JComboBox(years);
	  JRadioButton rb1= new JRadioButton(" Male");
	  JRadioButton rb2= new JRadioButton(" Female");
	  ButtonGroup bg = new ButtonGroup();
	  JTextField f7 = new JTextField(15);
	  JTextField f8= new JTextField(15);
	  JButton registerButton=new JButton("REGISTER");
	  JButton resetButton=new JButton("RESET");
	  
	  RegisterForm()
	    {
	        createWindow();
	        setLocationAndSize();
	        addComponentsToFrame();
	        actionEvent();
	    }


	private void createWindow() {
		frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setSize(600, 300);
        frame.setBackground(Color.lightGray);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
		
	}
	 public void setLocationAndSize()
	 {
		 l1.setBounds(50, 50, 80, 20);
		 f1.setBounds(210, 50, 200, 20);
		 l2.setBounds(50, 90, 120, 20);
		 f2.setBounds(210, 90, 200, 20);
		 l3.setBounds(50, 130, 120, 20);
		 f3.setBounds(210, 130, 200, 20);
		 l4.setBounds(50, 170, 120, 20);
		 f4.setBounds(210, 170, 200, 20);
		 l5.setBounds(50, 210, 120, 20);
		 date.setBounds(210, 200, 60, 20);
		 month.setBounds(270, 200, 70, 20);
		 year.setBounds(340, 200, 100, 20);
		 l6.setBounds(50, 250, 120, 20);
		 rb1.setActionCommand("Male");
		 rb1.setBounds(210, 250, 100, 20);
		 rb2.setActionCommand("Female");
		 rb2.setBounds(310, 250, 100, 20);
		 rb1.setSelected(true);
		 l7.setBounds(50, 290, 120, 20);
		 f7.setBounds(210, 290, 100, 20);
		 l8.setBounds(50, 330, 150, 20);
		 f8.setBounds(210, 330, 100, 20);
		 registerButton.setBounds(50, 370, 100, 20);
	     resetButton.setBounds(150, 370, 100, 20);
	 }
	 public void addComponentsToFrame()
	    {
		 frame.add(l1);
		 frame.add(f1);
		 frame.add(l2);
		 frame.add(f2);
		 frame.add(l3);
		 frame.add(f3);
		 frame.add(l4);
		 frame.add(f4);
		 frame.add(l5);
		 frame.add(date);
		 frame.add(month);
		 frame.add(year);
		 frame.add(l6);
		 bg.add(rb1);
	     bg.add(rb2);
		 frame.add(rb1);
		 frame.add(rb2);
		 frame.add(l7);
		 frame.add(f7);
		 frame.add(l8);
		 frame.add(f8);
		 frame.add(registerButton);
	     frame.add(resetButton);
	    }
	 public void actionEvent()
	    {
	        registerButton.addActionListener(this);
	        resetButton.addActionListener(this);
	    }


	@Override
	public void actionPerformed(ActionEvent e) {if(e.getSource()==registerButton)
    {
        
		try {
			data=(String)date.getSelectedItem()
	        	      + "/" + (String)month.getSelectedItem()
	        	      + "/" + (String)year.getSelectedItem() ;
			data2=bg.getSelection().getActionCommand();
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerationdatabase","root","");
            PreparedStatement Pstatement=connection.prepareStatement("insert into Registeration values(?,?,?,?,?,?,?,?)");
            Pstatement.setString(1,f1.getText());
            Pstatement.setString(2,f2.getText());
            Pstatement.setString(3,f3.getText());
            Pstatement.setString(4,f4.getText());
            Pstatement.setString(5,data);
            Pstatement.setString(6,data2);
            
            Pstatement.setString(7,f7.getText());
            Pstatement.setString(8,f8.getText());
            if(f7.getText().equals(f8.getText()))
            {

                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"password did not match");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
     }
    if(e.getSource()==resetButton)
    {
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        date.setSelectedItem("1");
        month.setSelectedItem("Jan");
        year.setSelectedItem("1995");
        bg.clearSelection();
        f7.setText("");
        f8.setText("");
    }


		
	}

	
	
	
}
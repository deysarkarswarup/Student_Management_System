//package login;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class StdLogin {
	static JFrame frm;
	private JTextField textField;
	private JPasswordField passwordField;
	public StdLogin()
	{
		frm=new JFrame("Student Login");
		frm.setBounds(100, 100, 865, 494);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p=new JPanel();
		frm.getContentPane().add(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(165, 203, 136, 47);
		p.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBackground(Color.GREEN);
		lblPassword.setBounds(165, 282, 136, 47);
		p.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(335, 212, 168, 35);
		p.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(335, 293, 168, 31);
		p.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					Connection con=DB.getConnection();
					try {
						String uid=textField.getText();
						String pswd=String.valueOf(passwordField.getPassword());
						String pass = null,usr_id = null;
						
						PreparedStatement st=con.prepareStatement("select userid,pswd from StudentLog where userid=? and pswd=?");
						st.setString(1,uid);
						st.setString(2,pswd);
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
							usr_id=rs.getString(1);
							pass=rs.getString(2);
							
						}
						if(usr_id.equals(uid) && pass.equals(pswd))
						{
							@SuppressWarnings("unused")
							/* ekhane call korche student dashboard ke... uid ke pathache */
							//StudentDashboard sdb=new StudentDashboard(uid);	
							StudentDashboard sdb=new StudentDashboard();	
							sdb.main(null);
							System.out.println("Success");
							frm.dispose();
							
						}
							else
							{
								
							}
					} 
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(270, 392, 159, 31);
		p.add(btnNewButton);
		
		JLabel lbNewUser = new JLabel("New User? Sign Up First :");
		lbNewUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbNewUser.setBackground(Color.GREEN);
		lbNewUser.setBounds(530, 370, 200, 31);
		p.add(lbNewUser);
		
		
		JButton btnSignup = new JButton("Sign up here");
		btnSignup.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                        	try{
                        		StdSignUp.main(null);
                        	}
                        	catch(Exception e) {
                        		JOptionPane.showMessageDialog(null,e);
                        	}
                        }
		});
		
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignup.setBounds(500, 392, 200, 31);
		p.add(btnSignup);
	}
}
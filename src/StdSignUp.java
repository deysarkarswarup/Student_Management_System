

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class StdSignUp {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StdSignUp window = new StdSignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StdSignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 865, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(362, 47, 114, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUserid = new JLabel("USER NAME:");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserid.setBounds(223, 155, 134, 37);
		frame.getContentPane().add(lblUserid);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(223, 215, 134, 37);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(362, 215, 161, 37);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(362, 157, 161, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					Connection con=DB.getConnection();
					try {
						String uid=textField.getText();
						String pswd=String.valueOf(passwordField.getPassword());
						//String pass = null,usr_id = null;
						
						//PreparedStatement st=con.prepareStatement("select userid,pswd from StudentLog where userid=? and pswd=?");
						PreparedStatement st=con.prepareStatement("insert into studentlog values(?,?)");
						
						st.setString(1,uid);
						st.setString(2,pswd);
						st.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "user added!!");
						//rs.close();
						st.close();
						frame.dispose();
						/*while(rs.next())
						{
							usr_id=rs.getString(1);
							pass=rs.getString(2);
							
						}
						if(usr_id.equals(uid) && pass.equals(pswd))
						{
							@SuppressWarnings("unused")
							// ekhane call korche student dashboard ke... uid ke pathache 
							StudentDashboard sdb=new StudentDashboard(uid);	
							System.out.println("Success");
							frm.dispose();
							
						}
							else
							{
								
							}*/
					} 
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(374, 327, 125, 37);
		frame.getContentPane().add(btnNewButton);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class StudentDashboard {

	private JFrame frame;
	private JTextField textStudentID;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textDOB;
	private JTextField textBloodGroup;
	private JTextField textMobileNo;
	private JTextField textEmailID;
	private JTextField textQualification;
	private JTextField textGuardainName;
	private JTextField textGuardainMobileNo;
	private JTextField textGuardainProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
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
	public StudentDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("StudentID");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(71, 88, 98, 28);
		frame.getContentPane().add(label);
		
		textStudentID = new JTextField();
		textStudentID.setColumns(10);
		textStudentID.setBounds(183, 88, 153, 28);
		frame.getContentPane().add(textStudentID);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(71, 127, 98, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(71, 167, 98, 28);
		frame.getContentPane().add(label_2);
		
		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(183, 127, 153, 28);
		frame.getContentPane().add(textFirstName);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(183, 167, 153, 28);
		frame.getContentPane().add(textLastName);
		
		JButton btnSave = new JButton("Save");
		

		btnSave.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent ae) {
                            Connection con=null;
                            String url="jdbc:mysql://localhost:3306/MCA21";
                            String uname="root";
                            String pass="qwerty12345";
                            try{
                                 Class.forName("com.mysql.cj.jdbc.Driver");
                                con =DriverManager.getConnection(url,uname,pass);
                                String sid=textStudentID.getText();
                                String fs=textFirstName.getText();
                                String ls=textLastName.getText();

                                String dob=textDOB.getText();
                                String bloodGp=textBloodGroup.getText();
                                String mobNo=textMobileNo.getText();
                                String email=textEmailID.getText();
                                String Gname=textGuardainName.getText();
                                String GmobNo=textGuardainMobileNo.getText();
                                String Gprofile=textGuardainProfile.getText();
                                String PreviousQuali=textQualification.getText();
    
                                PreparedStatement st=con.prepareStatement("Insert into  STUDENTDashboard values(?,?,?,?,?,?,?,?,?,?,?)");
											
                                st.setString(1,sid);
                                st.setString(2,fs);
                                st.setString(3,ls);
                                
                                st.setString(4,dob);
                                st.setString(5,bloodGp);
                                st.setString(6,mobNo);
                                
                                st.setString(7,email);
                                st.setString(8,Gname);
                                st.setString(9,GmobNo);
                                
                                st.setString(10,Gprofile);
                                st.setString(11,PreviousQuali);
                                
                                st.executeUpdate();
                                JOptionPane.showMessageDialog(null,"Data inserted");
                            }catch(ClassNotFoundException | SQLException e)
                            {
                            	JOptionPane.showMessageDialog(null,e);
                                System.out.println(e);
                            }
					
			}
		});
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(154, 412, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel label_3 = new JLabel("Birth Date");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(71, 206, 117, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Blood Group");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(71, 245, 110, 28);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Mobile No:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(71, 284, 132, 28);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Email ID");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(71, 322, 98, 28);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Qualification");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(71, 361, 117, 28);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Guardain Name");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(406, 280, 132, 28);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Guardain Mobile No:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(406, 319, 172, 28);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Guardain Profile");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(406, 359, 154, 28);
		frame.getContentPane().add(label_10);
		
		textDOB = new JTextField();
		textDOB.setColumns(10);
		textDOB.setBounds(183, 206, 153, 28);
		frame.getContentPane().add(textDOB);
		
		textBloodGroup = new JTextField();
		textBloodGroup.setColumns(10);
		textBloodGroup.setBounds(183, 245, 153, 28);
		frame.getContentPane().add(textBloodGroup);
		
		textMobileNo = new JTextField();
		textMobileNo.setColumns(10);
		textMobileNo.setBounds(183, 286, 153, 28);
		frame.getContentPane().add(textMobileNo);
		
		textEmailID = new JTextField();
		textEmailID.setColumns(10);
		textEmailID.setBounds(183, 323, 153, 28);
		frame.getContentPane().add(textEmailID);
		
		textQualification = new JTextField();
		textQualification.setColumns(10);
		textQualification.setBounds(183, 361, 153, 28);
		frame.getContentPane().add(textQualification);
		
		textGuardainName = new JTextField();
		textGuardainName.setColumns(10);
		textGuardainName.setBounds(582, 282, 153, 28);
		frame.getContentPane().add(textGuardainName);
		
		textGuardainMobileNo = new JTextField();
		textGuardainMobileNo.setColumns(10);
		textGuardainMobileNo.setBounds(582, 321, 153, 28);
		frame.getContentPane().add(textGuardainMobileNo);
		
		textGuardainProfile = new JTextField();
		textGuardainProfile.setColumns(10);
		textGuardainProfile.setBounds(582, 361, 153, 28);
		frame.getContentPane().add(textGuardainProfile);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent arg0) {
	
            	textStudentID.setText(null);
            	textFirstName.setText(null);
            	textLastName.setText(null);
            	textDOB.setText(null);
            	textBloodGroup.setText(null);
            	textMobileNo.setText(null);
            	textEmailID.setText(null);
            	textQualification.setText(null);
            	textGuardainName.setText(null);
            	textGuardainMobileNo.setText(null);
            	textGuardainProfile.setText(null);
}
});
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(276, 414, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnViewStudentResult = new JButton("View Student Result");
		
		btnViewStudentResult.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent ae) {
            	try{
            		ResultView1stMidTerm.main(null);
            	}
            	catch(Exception e) {
            		JOptionPane.showMessageDialog(null,e);
            	}
            }
		});
		
		btnViewStudentResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewStudentResult.setBounds(390, 414, 200, 23);
		frame.getContentPane().add(btnViewStudentResult);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent arg0) {
	frame = new JFrame("Exit");
	if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Result System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
		System.exit(0);
}
});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(613, 414, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel label_11 = new JLabel("Student Details");
		label_11.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		label_11.setBounds(287, 11, 380, 59);
		frame.getContentPane().add(label_11);
	}

}

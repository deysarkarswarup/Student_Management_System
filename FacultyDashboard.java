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

public class FacultyDashboard {

	private JFrame frame;
	private JTextField textFacultyID;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textDOB;
	private JTextField textBloodGroup;
	private JTextField textMobileNo;
	private JTextField textEmailID;
	private JTextField textQualification;
	private JTextField textDesignation;
	private JTextField textExperience;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyDashboard window = new FacultyDashboard();
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
	public FacultyDashboard() {
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
		
		JLabel lblFacultyid = new JLabel("FacultyID");
		lblFacultyid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFacultyid.setBounds(77, 88, 98, 28);
		frame.getContentPane().add(lblFacultyid);
		
		textFacultyID = new JTextField();
		textFacultyID.setColumns(10);
		textFacultyID.setBounds(189, 88, 153, 28);
		frame.getContentPane().add(textFacultyID);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(77, 127, 98, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(77, 167, 98, 28);
		frame.getContentPane().add(label_2);
		
		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(189, 127, 153, 28);
		frame.getContentPane().add(textFirstName);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(189, 167, 153, 28);
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
                  
                	
                    String sid=textFacultyID.getText();
                    String fs=textFirstName.getText();
                    String ls=textLastName.getText();

                    String dob=textDOB.getText();
                    String bloodGp=textBloodGroup.getText();
                    String mobNo=textMobileNo.getText();
                    String email=textEmailID.getText();
                    String quali=textQualification.getText();
                    String desg=textDesignation.getText();
                    String exp=textExperience.getText();
                    

                    PreparedStatement st=con.prepareStatement("Insert into  FACULTYDashboard values(?,?,?,?,?,?,?,?,?,?)");
								
                    st.setString(1,sid);
                    st.setString(2,fs);
                    st.setString(3,ls);
                    
                    st.setString(4,dob);
                    st.setString(5,bloodGp);
                    st.setString(6,mobNo);
                    
                    st.setString(7,email);
                    st.setString(8,quali);
                    st.setString(9,desg);
                    
                    st.setString(10,exp);
                    
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
		btnSave.setBounds(160, 412, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel label_3 = new JLabel("Birth Date");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(77, 206, 117, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Blood Group");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(77, 245, 110, 28);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Mobile No:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(77, 284, 132, 28);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Email ID");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(77, 322, 98, 28);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Qualification");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(77, 361, 117, 28);
		frame.getContentPane().add(label_7);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesignation.setBounds(412, 280, 132, 28);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExperience.setBounds(412, 319, 172, 28);
		frame.getContentPane().add(lblExperience);
		
		textDOB = new JTextField();
		textDOB.setColumns(10);
		textDOB.setBounds(189, 206, 153, 28);
		frame.getContentPane().add(textDOB);
		
		textBloodGroup = new JTextField();
		textBloodGroup.setColumns(10);
		textBloodGroup.setBounds(189, 245, 153, 28);
		frame.getContentPane().add(textBloodGroup);
		
		textMobileNo = new JTextField();
		textMobileNo.setColumns(10);
		textMobileNo.setBounds(189, 286, 153, 28);
		frame.getContentPane().add(textMobileNo);
		
		textEmailID = new JTextField();
		textEmailID.setColumns(10);
		textEmailID.setBounds(189, 323, 153, 28);
		frame.getContentPane().add(textEmailID);
		
		textQualification = new JTextField();
		textQualification.setColumns(10);
		textQualification.setBounds(189, 361, 153, 28);
		frame.getContentPane().add(textQualification);
		
		textDesignation = new JTextField();
		textDesignation.setColumns(10);
		textDesignation.setBounds(588, 282, 153, 28);
		frame.getContentPane().add(textDesignation);
		
		textExperience = new JTextField();
		textExperience.setColumns(10);
		textExperience.setBounds(588, 321, 153, 28);
		frame.getContentPane().add(textExperience);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent arg0) {
            	
                textFacultyID.setText(null);
            	textFirstName.setText(null);
            	textLastName.setText(null);
            	textDOB.setText(null);
            	textBloodGroup.setText(null);
            	textMobileNo.setText(null);
            	textEmailID.setText(null);
            	textQualification.setText(null);
            	textDesignation.setText(null);
            	textExperience.setText(null);
 
}
});
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(282, 414, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnUpdateStudentResult = new JButton("Update Student Result");
		
		btnUpdateStudentResult.addActionListener(new ActionListener() {
            @Override
public void actionPerformed(ActionEvent ae) {
            	try{
            			StudentRecord.main(null);
            	}
            	catch(Exception e) {
            		JOptionPane.showMessageDialog(null,e);
            	}
            }
		});
	
		btnUpdateStudentResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateStudentResult.setBounds(396, 414, 224, 23);
		frame.getContentPane().add(btnUpdateStudentResult);
		
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
		btnExit.setBounds(652, 412, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblFacultyDetails = new JLabel("Faculty Details");
		lblFacultyDetails.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		lblFacultyDetails.setBounds(293, 11, 380, 59);
		frame.getContentPane().add(lblFacultyDetails);
	}
}

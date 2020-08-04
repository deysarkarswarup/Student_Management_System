


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Login {

	/**
	 * @param args
	 */
	static Login lin;
	static JFrame frm;
	JPanel p;
	JLabel /*lbladmin,*/lblfaculty,lblstudent;
	//JTextField t1,t2;
	JButton /*adminbut,*/facultybut,studentbut;
	Login()
	{
		p=new JPanel();
		frm.getContentPane().add(p);
		//lbladmin=new JLabel("");
		//lbladmin.setIcon(new ImageIcon("C:\\Users\\Swarup Dey Sarkar\\Downloads\\Compressed\\swing projects\\admin.jpg"));
		lblfaculty=new JLabel("");
		lblfaculty.setIcon(new ImageIcon("C:\\Users\\Swarup Dey Sarkar\\Downloads\\Compressed\\swing projects\\faculty.jpg"));
		lblstudent=new JLabel("");
		lblstudent.setIcon(new ImageIcon("C:\\Users\\Swarup Dey Sarkar\\Downloads\\Compressed\\swing projects\\student.jpg"));
		//adminbut=new JButton("admin");
		facultybut=new JButton("faculty");
		studentbut=new JButton("Student");
		p.setLayout(null);
		lblstudent.setBounds(80,100,225,225);
		p.add(lblstudent);
		studentbut.setBounds(135, 325, 100, 30);
		p.add(studentbut);
		/*lbladmin.setBounds(600,100,225,225);
		p.add(lbladmin);
		adminbut.setBounds(627, 325, 100, 30);
		p.add(adminbut);*/
		lblfaculty.setBounds(325,100,200,225);
		p.add(lblfaculty);
		facultybut.setBounds(374, 325, 100, 30);
		p.add(facultybut);
		p.setBackground(Color.PINK);
		Con c=new Con();
		studentbut.addActionListener(c);
		facultybut.addActionListener(c);
		//adminbut.addActionListener(c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frm=new JFrame("Login");
		frm.setBounds(100, 100, 865, 494);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lin=new Login();
	
	}
	class Con implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if(ae.getSource()==studentbut)
			{
				frm.dispose();
				@SuppressWarnings("unused")
				StdLogin slin=new StdLogin();
			}
			else if(ae.getSource()==facultybut)
			{
				@SuppressWarnings("unused")
				FactLogin flin=new FactLogin();
			}
			/*else if(ae.getSource()==adminbut)
			{
			//	AdminLogin alin=new AdminLogin();
			}
*/
		}
	}

}

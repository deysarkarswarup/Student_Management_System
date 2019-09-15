import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.text.MessageFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class StudentRecord {

	private JFrame frame;
	
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static DefaultTableModel model = new DefaultTableModel();
	
	
	private JTextField textStudentID;
	private JTextField textDBMSII;
	private JTextField textAlgorithm;
	private JTextField textOS;
	private JTextField textNetworking;
	private JTextField textEVS;
	private JTextField textTotalScore;
	private JTextField textAverage;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void UpdateTable() {
		//conn = DbConnection.dbConnector();
		if(conn !=null)
		{
			String sql="Select StudentID, DBMSII,Algorithm,OS,Networking,EVS,TotalScore,Average from MID_TERM_1";
			try {
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				Object[] columnData = new Object[9];
				
				while(rs.next()) {
					columnData[0]=rs.getString("StudentID");
					columnData[1]=rs.getString("DBMSII");
					columnData[2]=rs.getString("Algorithm");
					columnData[3]=rs.getString("OS");
					columnData[4]=rs.getString("Networking");
					columnData[5]=rs.getString("EVS");
					columnData[6]=rs.getString("TotalScore");
					columnData[7]=rs.getString("Average");
					
					model.addRow(columnData);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,e);
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					StudentRecord window = new StudentRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentRecord() {
		initialize();
		conn = DBConnection.dbConnector();
		Object col[]= {"StudentID","DBMSII","Algorithm","OS","Networking","EVS","TotalScore","Average"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
		UpdateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 128, 128), 12));
		panel.setBounds(48, 31, 855, 328);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentid.setBounds(45, 41, 101, 22);
		panel.add(lblStudentid);
		
		JLabel lblDbmsii = new JLabel("DBMSII");
		lblDbmsii.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDbmsii.setBounds(44, 96, 101, 22);
		panel.add(lblDbmsii);
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(44, 128, 101, 22);
		panel.add(lblAlgorithm);
		
		textStudentID = new JTextField();
		textStudentID.setBounds(167, 45, 132, 20);
		panel.add(textStudentID);
		textStudentID.setColumns(10);
		
		textDBMSII = new JTextField();
		textDBMSII.setColumns(10);
		textDBMSII.setBounds(167, 100, 132, 20);
		panel.add(textDBMSII);
		
		textAlgorithm = new JTextField();
		textAlgorithm.setColumns(10);
		textAlgorithm.setBounds(167, 132, 132, 20);
		panel.add(textAlgorithm);
		
		textOS = new JTextField();
		textOS.setColumns(10);
		textOS.setBounds(166, 163, 132, 20);
		panel.add(textOS);
		
		textNetworking = new JTextField();
		textNetworking.setColumns(10);
		textNetworking.setBounds(166, 194, 132, 20);
		panel.add(textNetworking);
		
		textEVS = new JTextField();
		textEVS.setColumns(10);
		textEVS.setBounds(166, 225, 132, 20);
		panel.add(textEVS);
		
		JLabel lblOs = new JLabel("OS");
		lblOs.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOs.setBounds(44, 161, 101, 22);
		panel.add(lblOs);
		
		JLabel lblNetworking = new JLabel("Networking");
		lblNetworking.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNetworking.setBounds(44, 194, 111, 22);
		panel.add(lblNetworking);
		
		JLabel lblEvs = new JLabel("EVS");
		lblEvs.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEvs.setBounds(44, 223, 101, 22);
		panel.add(lblEvs);
		
		JLabel lblMarksIn = new JLabel("Marks In:-");
		lblMarksIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMarksIn.setBounds(45, 74, 60, 14);
		panel.add(lblMarksIn);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAverage.setBounds(524, 223, 111, 22);
		panel.add(lblAverage);
		
		JLabel lblTotalScore = new JLabel("Total Score");
		lblTotalScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalScore.setBounds(524, 190, 101, 22);
		panel.add(lblTotalScore);
		
		textTotalScore = new JTextField();
		textTotalScore.setEditable(false);
		textTotalScore.setColumns(10);
		textTotalScore.setBounds(634, 192, 132, 20);
		panel.add(textTotalScore);
		
		textAverage = new JTextField();
		textAverage.setEditable(false);
		textAverage.setColumns(10);
		textAverage.setBounds(634, 223, 132, 20);
		panel.add(textAverage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 128, 128), 12));
		panel_1.setBounds(974, 31, 345, 328);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 25, 301, 275);
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 12));
		panel_2.setBounds(48, 388, 1271, 197);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 27, 1221, 148);
		panel_2.add(scrollPane);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 24, 1227, 150);
		panel_2.add(scrollPane);	


table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			/*new String[] {
				"StudentID","DBMSII","Algorithm","OS","Networking","EVS","TotalScore","Average","Ranking"
			}*/
			/*new String[] {
				"StudentID", "DBMSII", "Network", "Algorithm", "OS", "EVS", "Ranking"
			}
		));
		scrollPane.setRowHeaderView(table);*/
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StudentID", "DBMSII", "Algorithm", "OS", "Networking", "EVS", "Total Score", "Average"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
                        @Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Student Result");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double[] R=new double [15];
				R[0]=Double.parseDouble(textDBMSII.getText());
				R[1]=Double.parseDouble(textAlgorithm.getText());
				R[2]=Double.parseDouble(textOS.getText());
				R[3]=Double.parseDouble(textNetworking.getText());
				R[4]=Double.parseDouble(textEVS.getText());
						
				R[5]=(R[0]+R[1]+R[2]+R[3]+R[4])/5;
				R[6]=(R[0]+R[1]+R[2]+R[3]+R[4]);
			
				String average= String.format("%.0f", R[5]);
				textAverage.setText(average);
				
				String totalScore= String.format("%.0f", R[6]);
				textTotalScore.setText(totalScore);
				/*try {
					String query="select * from student";
					PreparedStatement pst =conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			*/
				String sql="INSERT INTO MID_TERM_1(StudentID, DBMSII,Algorithm,OS,Networking,EVS,TOTALSCORE,AVERAGE) VALUES(?,?,?,?,?,?,?,?)";
				//String sql="INSERT INTO MID_TERM_1(StudentID, DBMSII,Algorithm,OS,Networking,EVS) VALUES(1882029,19,14,17,25,29)";
				conn = DBConnection.dbConnector();
					
				try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, textStudentID.getText());

						pst.setInt(2, Integer.valueOf(textDBMSII.getText()));
						pst.setInt(3, Integer.valueOf(textAlgorithm.getText()));
						pst.setInt(4, Integer.valueOf(textOS.getText()));

						pst.setInt(5, Integer.valueOf(textNetworking.getText()));
						pst.setInt(6, Integer.valueOf(textEVS.getText()));
						pst.setInt(7, Integer.valueOf(textTotalScore.getText()));
						pst.setInt(8, Integer.valueOf(textAverage.getText()));
/*						pst.setString(2, textDBMSII.getText());
						pst.setString(3, textOS.getText());
						pst.setString(4, textNetworking.getText());
						pst.setString(5, textEVS.getText());
						pst.setString(6, textTotalScore.getText());
						pst.setString(7, textAverage.getText());*/
						//pst.setString(8, textRanking.getText());
						
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "update hoyeche!!");
						//rs.close();
						pst.close();
						
				}
				/*catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "System Update Failed");
				}*/
				
				catch(Exception ev) {
					ev.printStackTrace();
				}
				
				/* updating into table */
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
						textStudentID.getText(),
						textDBMSII.getText(),
						textAlgorithm.getText(),
						textOS.getText(),
						textNetworking.getText(),
						textEVS.getText(),
						textTotalScore.getText(),
						textAverage.getText(),
						
				});
				/* foreign constraints failed korle table e update hoya bondho korte hobe...  
				if(table.getSelectedRow()==-1) {
					if(table.getSelectedRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Membership Update Confirmed", "Student DataBase System", JOptionPane.OK_OPTION);
					}
				}
				*/
				
			}
		});
		btnNewButton.setBounds(110, 627, 204, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow()==-1) {
					if(table.getSelectedRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No data to delete", "Student Result System", JOptionPane.OK_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "Select a row to delete", "Student Result System", JOptionPane.OK_OPTION);
				}
				}
				else {
					model.removeRow(table.getSelectedRow());
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(350, 627, 138, 33);
		frame.getContentPane().add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField temp=null;
				for(Component c:panel.getComponents()) {
					if(c.getClass().toString().contains("javax.swing.JTextField")) {
						temp=(JTextField)c;
						temp.setText(null);
					}
				}
				textArea.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(519, 627, 154, 33);
		frame.getContentPane().add(btnReset);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea.append("Student Result Recording Systems\n"
						+"=========================================\n"
						+"StudentID:\t\t"+textStudentID.getText() 
						/*+"\nFirstName:\t\t"+text??.getText()
						+"\nLastName:\t\t"+text??.getText()*/
						+"\nDBMSII:\t\t"+textDBMSII.getText()
						+"\nAlgorithm:\t\t"+textAlgorithm.getText()
						+"\nOS:\t\t"+textOS.getText()
						+"\nNetworking:\t\t"+textNetworking.getText()
						+"\nEVS:\t\t"+textEVS.getText()
						+"\n=========================================\n"
						+"\nTotalScore:\t\t"+textTotalScore.getText()
						+"\nAverage:\t\t"+textAverage.getText()+"\n");
			}
		});
		btnTranscript.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTranscript.setBounds(719, 627, 166, 33);
		frame.getContentPane().add(btnTranscript);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("unused")
				MessageFormat header = new MessageFormat("Printing in progress");
				@SuppressWarnings("unused")
				MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				
				try
				{
					table.print();
				}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("No printer found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPrint.setBounds(934, 627, 138, 33);
		frame.getContentPane().add(btnPrint);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Result System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
					System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(1121, 627, 144, 33);
		frame.getContentPane().add(btnExit);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

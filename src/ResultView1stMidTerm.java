import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ResultView1stMidTerm {

	private JFrame frame;
	private JTable table;
	
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	
	
	public static void UpdateTable() {
		conn = DBConnection.dbConnector();
		if(conn !=null)
		{
			String sql="Select StudentID,DBMSII,Algorithm,OS,Networking,EVS,TotalScore,Average from MID_TERM_1";
			try {
				pst=conn.prepareStatement(sql);
				rs=pst.executeQuery();
				Object[] columnData = new Object[8];
				
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
			public void run() {
				try {
					ResultView1stMidTerm window = new ResultView1stMidTerm();
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
	public ResultView1stMidTerm() {
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
		frame.setBounds(100, 100, 865, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentResult = new JLabel("1st Mid Term Result");
		lblStudentResult.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		lblStudentResult.setBounds(198, 11, 436, 59);
		frame.getContentPane().add(lblStudentResult);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 81, 795, 349);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StudentID", "DBMSII", "Algorithm", "OS", "Networking", "EVS", "TotalScore", "Average"
			}
		));
		scrollPane.setViewportView(table);
	}
}

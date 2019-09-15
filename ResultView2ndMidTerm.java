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

public class ResultView2ndMidTerm {

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
			String sql="Select StudentID,DBMSII,Algorithm,OS,Networking,EVS,TotalScore,Average from MID_TERM_2";
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
					ResultView2ndMidTerm window = new ResultView2ndMidTerm();
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
	public ResultView2ndMidTerm() {
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
		frame.setBounds(100, 100, 868, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblndMidTerm = new JLabel("2nd Mid Term Result");
		lblndMidTerm.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		lblndMidTerm.setBounds(199, 11, 462, 59);
		frame.getContentPane().add(lblndMidTerm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 81, 804, 350);
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

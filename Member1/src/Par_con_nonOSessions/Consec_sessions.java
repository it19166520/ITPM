package Par_con_nonOSessions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConnection.DBConnection;
import Home.HomePage;
import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Consec_sessions extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel_1;
	private JLayeredPane SessionslayeredPane;
	private JPanel Consecutive;
	private JPanel Parallel;
	private JPanel NonOverlapping;
	private JButton btnConsec;
	private JButton btnParallel;
	private JButton btnNonOverlapping;
	private JButton btnBack;
	public static JTable sessionListTable;
	private JScrollPane scrollPane;
	private JButton btnAddcosecutivesessionbtn;
	public static JTable ViewConSessions;
	private JScrollPane scrollPaneViewConsec;
	private JScrollPane scrollPane1;
	private JButton btnAddParallelsessionbtn;
	private JButton btnViewParrallelSelected;
	private JScrollPane scrollPaneViewparallel;
	public static JTable ViewParSessions;
	private JTable sessionListTablePa;
	private JScrollPane scrollPane2;
	private JTable sessionListTableNo;

	private JButton btnAddNOsessionbtn;

	private JButton btnViewNoSessions;

	private JTable ViewNOSessions;

	private JScrollPane scrollPaneViewNo;
	private JButton btnView;
	public static JTable newTable;
	private JScrollPane scrollPaneNew;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable ViewSelectedParallel;
	private JScrollPane scrollPaneParallel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblParallelSessions;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNonOverlappingSessions;
	private JTable ViewSelectedNO;
	private JScrollPane scrollPane_4;
	private JButton btnDeleteConsecutiveSession;
	private JButton btnDeleteParallelSession;
	private JButton btnDeleteNonoverlappingSession;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consec_sessions frame = new Consec_sessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//swith panels
	public void SwitchPanels(JPanel panel)
	{
		SessionslayeredPane.removeAll();
		SessionslayeredPane.add(panel);
		SessionslayeredPane.repaint();
		SessionslayeredPane.revalidate();
	}
	
	public void RefreshConsecTable()
	{
		try {
			
			String refreshque="select * from ConsecutiveSession";
			PreparedStatement psat= connection.prepareStatement(refreshque);
			ResultSet rs=psat.executeQuery();
			
			ViewConSessions.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	
	public void RefreshParallelTable()
	{
		try {
			
			String refreshque="select * from ParallelSession";
			PreparedStatement psat= connection.prepareStatement(refreshque);
			ResultSet rs=psat.executeQuery();
			
			ViewParSessions.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	
	public void RefreshNOTable()
	{
		try {
			
			String refreshque="select * from NonOverlappingSession";
			PreparedStatement psat= connection.prepareStatement(refreshque);
			ResultSet rs=psat.executeQuery();
			
			ViewNOSessions.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public Consec_sessions() {
		
		connection = DBConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//header
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1365, 75);
		panel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(75, 119, 190));
		contentPane.add(panel_1);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setText("Timetable Management System");
		panel_1.add(txtrTimeTableManagement);
	//end of header
		
		
		SessionslayeredPane = new JLayeredPane();
		SessionslayeredPane.setBackground(SystemColor.inactiveCaption);
		SessionslayeredPane.setBounds(31, 131, 1292, 558);
		contentPane.add(SessionslayeredPane);
		SessionslayeredPane.setLayout(new CardLayout(0, 0));
		
		Consecutive = new JPanel();
		Consecutive.setBackground(new Color(228, 241, 254));
		SessionslayeredPane.add(Consecutive, "name_563722451982000");
		Consecutive.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 11, 1262, 197);
		Consecutive.add(scrollPane);
		
		
		sessionListTable = new JTable();
		sessionListTable.setBorder(new LineBorder(Color.BLUE));
		sessionListTable.setUpdateSelectionOnSort(false);
		sessionListTable.setSelectionForeground(Color.WHITE);
		sessionListTable.setGridColor(Color.LIGHT_GRAY);
		sessionListTable.setRowHeight(30);
		sessionListTable.setBackground(Color.WHITE);
		sessionListTable.setSelectionBackground(new Color(176, 224, 230));
		sessionListTable.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		sessionListTable.getTableHeader().setOpaque(false);
		sessionListTable.getTableHeader().setForeground(Color.WHITE);
		sessionListTable.getTableHeader().setBackground(new Color(34, 167, 240));
		sessionListTable.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		sessionListTable.setRowSelectionAllowed(true);
		scrollPane.setViewportView(sessionListTable);
		
		btnAddcosecutivesessionbtn = new JButton("Add Consecutive Session");
		btnAddcosecutivesessionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel = (DefaultTableModel)newTable.getModel();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = DBConnection.dbConnecter();
					
					    for (int i=0 ;i<tblModel.getRowCount();i++) {
					    	SessionIndex = tblModel.getValueAt(i, 0).toString();
					        LecturerNameSession =  tblModel.getValueAt(i, 1).toString();
					        SubjectCodeSession = tblModel.getValueAt(i, 2).toString();
					        SubjectNameSession = tblModel.getValueAt(i, 3).toString();
					        TagSession = tblModel.getValueAt(i, 4).toString();
					        GroupIDSession = tblModel.getValueAt(i, 5).toString();
					        StudentCountSession = tblModel.getValueAt(i, 6).toString();
					        SessionDuration = tblModel.getValueAt(i, 7).toString();
					        SessionId = tblModel.getValueAt(i, 8).toString();
					        
					        String query = "insert into ConsecutiveSession(SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId) values(?,?,?,?,?,?,?,?,?)"; 
						    PreparedStatement pst = connection.prepareStatement(query);
					        
					        
					        pst.setString(1, SessionIndex);
					        pst.setString(2, LecturerNameSession);
					        pst.setString(3, SubjectCodeSession);
					        pst.setString(4, SubjectNameSession);
					        pst.setString(5, TagSession);
					        pst.setString(6, GroupIDSession);
					        pst.setString(7, StudentCountSession);
					        pst.setString(8, SessionDuration);
					        pst.setString(9, SessionId);
					        pst.execute();
						
					    }
					    JOptionPane.showMessageDialog(null, "Consecutive sessions added successfully!");
					    tblModel.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshConsecTable();
				
			}
		});
		btnAddcosecutivesessionbtn.setForeground(Color.WHITE);
		btnAddcosecutivesessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddcosecutivesessionbtn.setFocusPainted(false);
		btnAddcosecutivesessionbtn.setBackground(new Color(58, 83, 155));
		btnAddcosecutivesessionbtn.setBounds(10, 328, 203, 26);
		Consecutive.add(btnAddcosecutivesessionbtn);
		
		scrollPaneViewConsec = new JScrollPane();
		scrollPaneViewConsec.setBackground(Color.WHITE);
		scrollPaneViewConsec.setBounds(38, 406, 1234, 152);
		Consecutive.add(scrollPaneViewConsec);
		
		ViewConSessions = new JTable();
		ViewConSessions.setRowHeight(30);
		ViewConSessions.setBackground(Color.WHITE);
		ViewConSessions.setSelectionBackground(new Color(176, 224, 230));
		ViewConSessions.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewConSessions.getTableHeader().setOpaque(false);
		ViewConSessions.getTableHeader().setForeground(Color.WHITE);
		ViewConSessions.getTableHeader().setBackground(new Color(34, 167, 240));
		ViewConSessions.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPaneViewConsec.setViewportView(ViewConSessions);
		
		btnView = new JButton("View Selected");
		btnView.setActionCommand("View selected ");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TableModel model= sessionListTable.getModel();
				int indexes[] = sessionListTable.getSelectedRows();
				
				Object[] row = new Object[9];
				DefaultTableModel model2= (DefaultTableModel) newTable.getModel();
				
				for(int i=0 ;i<indexes.length;i++)
				{
					row[0] = model.getValueAt(indexes[i], 0);
					row[1] = model.getValueAt(indexes[i], 1);
					row[2] = model.getValueAt(indexes[i], 2);
					row[3] = model.getValueAt(indexes[i], 3);
					row[4] = model.getValueAt(indexes[i], 4);
					row[5] = model.getValueAt(indexes[i], 5);
					row[6] = model.getValueAt(indexes[i], 6);
					row[7] = model.getValueAt(indexes[i], 7);
					row[8] = model.getValueAt(indexes[i], 8);
					
					model2.addRow(row);
				}
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnView.setFocusPainted(false);
		btnView.setBackground(new Color(58, 83, 155));
		btnView.setBounds(10, 259, 162, 26);
		Consecutive.add(btnView);
		
		scrollPaneNew = new JScrollPane();
		scrollPaneNew.setBounds(258, 228, 1014, 139);
		
		Consecutive.add(scrollPaneNew);
		
		newTable = new JTable();
		newTable.setRowHeight(30);
		newTable.setBorder(new LineBorder(Color.BLUE));
		newTable.setUpdateSelectionOnSort(false);
		newTable.setSelectionForeground(Color.WHITE);
		newTable.setGridColor(Color.LIGHT_GRAY);
		newTable.setRowHeight(30);
		newTable.setBackground(Color.WHITE);
		newTable.setSelectionBackground(new Color(176, 224, 230));
		newTable.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		newTable.getTableHeader().setOpaque(false);
		newTable.getTableHeader().setForeground(Color.WHITE);
		newTable.getTableHeader().setBackground(new Color(34, 167, 240));
		newTable.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPaneNew.setViewportView(newTable);
		
		lblNewLabel = new JLabel("Consecutive sessions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(418, 389, 183, 17);
		Consecutive.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CTRL+select rows to add as consecutive ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 212, 228, 14);
		Consecutive.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Press to view selected data");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 291, 215, 14);
		Consecutive.add(lblNewLabel_2);
		
		btnDeleteConsecutiveSession = new JButton("Delete Consecutive Session");
		btnDeleteConsecutiveSession.setForeground(Color.WHITE);
		btnDeleteConsecutiveSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnDeleteConsecutiveSession.setFocusPainted(false);
		btnDeleteConsecutiveSession.setBackground(new Color(210, 77, 87));
		btnDeleteConsecutiveSession.setBounds(10, 375, 203, 26);
		Consecutive.add(btnDeleteConsecutiveSession);
		
		//---------------------------------------------Parallel panel----------------------------------------------------------------------------//
		
		Parallel = new JPanel();
		Parallel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Parallel.setForeground(Color.BLACK);
		Parallel.setBackground(new Color(228, 241, 254));
		SessionslayeredPane.add(Parallel, "name_563722482429500");
		Parallel.setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBackground(Color.WHITE);
		scrollPane1.setBounds(10, 0, 1262, 188);
		Parallel.add(scrollPane1);
		
		
		sessionListTablePa = new JTable();
		sessionListTablePa.setBorder(new LineBorder(Color.BLUE));
		sessionListTablePa.setUpdateSelectionOnSort(false);
		sessionListTablePa.setSelectionForeground(Color.WHITE);
		sessionListTablePa.setGridColor(Color.LIGHT_GRAY);
		sessionListTablePa.setRowHeight(30);
		sessionListTablePa.setBackground(Color.WHITE);
		sessionListTablePa.setSelectionBackground(new Color(176, 224, 230));
		sessionListTablePa.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		sessionListTablePa.getTableHeader().setOpaque(false);
		sessionListTablePa.getTableHeader().setForeground(Color.WHITE);
		sessionListTablePa.getTableHeader().setBackground(new Color(34, 167, 240));
		sessionListTablePa.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPane1.setViewportView(sessionListTablePa);
		
		btnAddParallelsessionbtn = new JButton("Add Parallel Session");
		btnAddParallelsessionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel1 = (DefaultTableModel)ViewSelectedParallel.getModel();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = DBConnection.dbConnecter();
					
					    for (int i=0 ;i<tblModel1.getRowCount();i++) {
					    	SessionIndex = tblModel1.getValueAt(i, 0).toString();
					        LecturerNameSession =  tblModel1.getValueAt(i, 1).toString();
					        SubjectCodeSession = tblModel1.getValueAt(i, 2).toString();
					        SubjectNameSession = tblModel1.getValueAt(i, 3).toString();
					        TagSession = tblModel1.getValueAt(i, 4).toString();
					        GroupIDSession = tblModel1.getValueAt(i, 5).toString();
					        StudentCountSession = tblModel1.getValueAt(i, 6).toString();
					        SessionDuration = tblModel1.getValueAt(i, 7).toString();
					        SessionId = tblModel1.getValueAt(i, 8).toString();
					        
					        String query = "insert into ParallelSession(SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId) values(?,?,?,?,?,?,?,?,?)"; 
						    PreparedStatement pst = connection.prepareStatement(query);
					        
					        
					        pst.setString(1, SessionIndex);
					        pst.setString(2, LecturerNameSession);
					        pst.setString(3, SubjectCodeSession);
					        pst.setString(4, SubjectNameSession);
					        pst.setString(5, TagSession);
					        pst.setString(6, GroupIDSession);
					        pst.setString(7, StudentCountSession);
					        pst.setString(8, SessionDuration);
					        pst.setString(9, SessionId);
					        pst.execute();
						
					    }
					    JOptionPane.showMessageDialog(null, "Parallel sessions added successfully!");
					    tblModel1.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshParallelTable();
				
				
			}
		});
		btnAddParallelsessionbtn.setForeground(Color.WHITE);
		btnAddParallelsessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddParallelsessionbtn.setFocusPainted(false);
		btnAddParallelsessionbtn.setBackground(new Color(58, 83, 155));
		btnAddParallelsessionbtn.setBounds(10, 296, 187, 32);
		Parallel.add(btnAddParallelsessionbtn);
		
		btnViewParrallelSelected = new JButton("View Selected");
		btnViewParrallelSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel model1= sessionListTablePa.getModel();
				int indexes[] = sessionListTablePa.getSelectedRows();
				
				Object[] row = new Object[9];
				DefaultTableModel model2= (DefaultTableModel) ViewSelectedParallel.getModel();
				
				for(int i=0 ;i<indexes.length;i++)
				{
					row[0] = model1.getValueAt(indexes[i], 0);
					row[1] = model1.getValueAt(indexes[i], 1);
					row[2] = model1.getValueAt(indexes[i], 2);
					row[3] = model1.getValueAt(indexes[i], 3);
					row[4] = model1.getValueAt(indexes[i], 4);
					row[5] = model1.getValueAt(indexes[i], 5);
					row[6] = model1.getValueAt(indexes[i], 6);
					row[7] = model1.getValueAt(indexes[i], 7);
					row[8] = model1.getValueAt(indexes[i], 8);
					
					model2.addRow(row);
				}
			}
		});
		btnViewParrallelSelected.setForeground(Color.WHITE);
		btnViewParrallelSelected.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnViewParrallelSelected.setFocusPainted(false);
		btnViewParrallelSelected.setBackground(new Color(58, 83, 155));
		btnViewParrallelSelected.setBounds(10, 224, 187, 32);
		Parallel.add(btnViewParrallelSelected);
		
		scrollPaneViewparallel = new JScrollPane();
		scrollPaneViewparallel.setBackground(Color.WHITE);
		scrollPaneViewparallel.setBounds(21, 388, 1251, 170);
		Parallel.add(scrollPaneViewparallel);
		
		ViewParSessions = new JTable();
		ViewParSessions.setBorder(new LineBorder(Color.BLUE));
		ViewParSessions.setUpdateSelectionOnSort(false);
		ViewParSessions.setSelectionForeground(Color.WHITE);
		ViewParSessions.setGridColor(Color.LIGHT_GRAY);
		ViewParSessions.setRowHeight(30);
		ViewParSessions.setBackground(Color.WHITE);
		ViewParSessions.setSelectionBackground(new Color(176, 224, 230));
		ViewParSessions.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewParSessions.getTableHeader().setOpaque(false);
		ViewParSessions.getTableHeader().setForeground(Color.WHITE);
		ViewParSessions.getTableHeader().setBackground(new Color(34, 167, 240));
		ViewParSessions.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPaneViewparallel.setViewportView(ViewParSessions);
		
		scrollPaneParallel = new JScrollPane();
		scrollPaneParallel.setBounds(240, 224, 1032, 128);
		Parallel.add(scrollPaneParallel);
		
		ViewSelectedParallel = new JTable();
		ViewSelectedParallel.setBorder(new LineBorder(Color.BLUE));
		ViewSelectedParallel.setUpdateSelectionOnSort(false);
		ViewSelectedParallel.setSelectionForeground(Color.WHITE);
		ViewSelectedParallel.setGridColor(Color.LIGHT_GRAY);
		ViewSelectedParallel.setRowHeight(30);
		ViewSelectedParallel.setBackground(Color.WHITE);
		ViewSelectedParallel.setSelectionBackground(new Color(176, 224, 230));
		ViewSelectedParallel.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewSelectedParallel.getTableHeader().setOpaque(false);
		ViewSelectedParallel.getTableHeader().setForeground(Color.WHITE);
		ViewSelectedParallel.getTableHeader().setBackground(new Color(34, 167, 240));
		ViewSelectedParallel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPaneParallel.setViewportView(ViewSelectedParallel);
		
		lblNewLabel_3 = new JLabel("CTRL+select rows to add as Parallel");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 189, 228, 14);
		Parallel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Press to view selected data");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(10, 256, 215, 14);
		Parallel.add(lblNewLabel_4);
		
		lblParallelSessions = new JLabel("Parallel sessions");
		lblParallelSessions.setForeground(Color.BLACK);
		lblParallelSessions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParallelSessions.setBackground(Color.WHITE);
		lblParallelSessions.setBounds(484, 371, 183, 17);
		Parallel.add(lblParallelSessions);
		
		btnDeleteParallelSession = new JButton("Delete Parallel Session");
		btnDeleteParallelSession.setForeground(Color.WHITE);
		btnDeleteParallelSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnDeleteParallelSession.setFocusPainted(false);
		btnDeleteParallelSession.setBackground(new Color(210, 77, 87));
		btnDeleteParallelSession.setBounds(10, 351, 203, 26);
		Parallel.add(btnDeleteParallelSession);
		
		
		
		
		
		//--------------------------------------------------------------------------------------------
		NonOverlapping= new JPanel();
		NonOverlapping.setBackground(new Color(228, 241, 254));
		SessionslayeredPane.add(NonOverlapping, "name_563722506511600");
		NonOverlapping.setLayout(null);
		
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(null);
		scrollPane2.setBackground(Color.WHITE);
		scrollPane2.setBounds(10, 0, 1262, 193);
		NonOverlapping.add(scrollPane2);
		
		sessionListTableNo = new JTable();
		sessionListTableNo.setBorder(new LineBorder(Color.BLUE));
		sessionListTableNo.setUpdateSelectionOnSort(false);
		sessionListTableNo.setSelectionForeground(Color.WHITE);
		sessionListTableNo.setGridColor(Color.LIGHT_GRAY);
		sessionListTableNo.setRowHeight(30);
		sessionListTableNo.setBackground(Color.WHITE);
		sessionListTableNo.setSelectionBackground(new Color(176, 224, 230));
		sessionListTableNo.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		sessionListTableNo.getTableHeader().setOpaque(false);
		sessionListTableNo.getTableHeader().setForeground(Color.WHITE);
		sessionListTableNo.getTableHeader().setBackground(new Color(34, 167, 240));
		sessionListTableNo.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPane2.setViewportView(sessionListTableNo);
		
		btnAddNOsessionbtn = new JButton("Add NonOverlappingSession Session");
		btnAddNOsessionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel1 = (DefaultTableModel)ViewSelectedNO.getModel();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = DBConnection.dbConnecter();
					
					    for (int i=0 ;i<tblModel1.getRowCount();i++) {
					    	SessionIndex = tblModel1.getValueAt(i, 0).toString();
					        LecturerNameSession =  tblModel1.getValueAt(i, 1).toString();
					        SubjectCodeSession = tblModel1.getValueAt(i, 2).toString();
					        SubjectNameSession = tblModel1.getValueAt(i, 3).toString();
					        TagSession = tblModel1.getValueAt(i, 4).toString();
					        GroupIDSession = tblModel1.getValueAt(i, 5).toString();
					        StudentCountSession = tblModel1.getValueAt(i, 6).toString();
					        SessionDuration = tblModel1.getValueAt(i, 7).toString();
					        SessionId = tblModel1.getValueAt(i, 8).toString();
					        
					        String query = "insert into NonOverlappingSession(SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId) values(?,?,?,?,?,?,?,?,?)"; 
						    PreparedStatement pst = connection.prepareStatement(query);
					        
					        
					        pst.setString(1, SessionIndex);
					        pst.setString(2, LecturerNameSession);
					        pst.setString(3, SubjectCodeSession);
					        pst.setString(4, SubjectNameSession);
					        pst.setString(5, TagSession);
					        pst.setString(6, GroupIDSession);
					        pst.setString(7, StudentCountSession);
					        pst.setString(8, SessionDuration);
					        pst.setString(9, SessionId);
					        pst.execute();
						
					    }
					    JOptionPane.showMessageDialog(null, "NonOverlapping sessions added successfully!");
					    tblModel1.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshNOTable();
				
				
			}
		});
		btnAddNOsessionbtn.setForeground(Color.WHITE);
		btnAddNOsessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddNOsessionbtn.setFocusPainted(false);
		btnAddNOsessionbtn.setBackground(new Color(58, 83, 155));
		btnAddNOsessionbtn.setBounds(10, 298, 240, 31);
		NonOverlapping.add(btnAddNOsessionbtn);
		
		btnViewNoSessions = new JButton("View Selected");
		btnViewNoSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TableModel model1= sessionListTableNo.getModel();
				int indexes[] = sessionListTableNo.getSelectedRows();
				
				Object[] row = new Object[9];
				DefaultTableModel model2= (DefaultTableModel) ViewSelectedNO.getModel();
				
				for(int i=0 ;i<indexes.length;i++)
				{
					row[0] = model1.getValueAt(indexes[i], 0);
					row[1] = model1.getValueAt(indexes[i], 1);
					row[2] = model1.getValueAt(indexes[i], 2);
					row[3] = model1.getValueAt(indexes[i], 3);
					row[4] = model1.getValueAt(indexes[i], 4);
					row[5] = model1.getValueAt(indexes[i], 5);
					row[6] = model1.getValueAt(indexes[i], 6);
					row[7] = model1.getValueAt(indexes[i], 7);
					row[8] = model1.getValueAt(indexes[i], 8);
					
					model2.addRow(row);
				}
			}
		});
		btnViewNoSessions.setForeground(Color.WHITE);
		btnViewNoSessions.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnViewNoSessions.setFocusPainted(false);
		btnViewNoSessions.setBackground(new Color(58, 83, 155));
		btnViewNoSessions.setBounds(10, 242, 240, 31);
		NonOverlapping.add(btnViewNoSessions);
		
		scrollPaneViewNo = new JScrollPane();
		scrollPaneViewNo.setBorder(null);
		scrollPaneViewNo.setBackground(Color.WHITE);
		scrollPaneViewNo.setBounds(41, 391, 1231, 156);
		NonOverlapping.add(scrollPaneViewNo);
		
		ViewNOSessions = new JTable();
		ViewNOSessions.setBorder(new LineBorder(Color.BLUE));
		ViewNOSessions.setUpdateSelectionOnSort(false);
		ViewNOSessions.setSelectionForeground(Color.WHITE);
		ViewNOSessions.setGridColor(Color.LIGHT_GRAY);
		ViewNOSessions.setRowHeight(30);
		ViewNOSessions.setBackground(Color.WHITE);
		ViewNOSessions.setSelectionBackground(new Color(176, 224, 230));
		ViewNOSessions.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewNOSessions.getTableHeader().setOpaque(false);
		ViewNOSessions.getTableHeader().setForeground(Color.WHITE);
		ViewNOSessions.getTableHeader().setBackground(new Color(34, 167, 240));
		ViewNOSessions.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		scrollPaneViewNo.setViewportView(ViewNOSessions);
		
		lblNewLabel_5 = new JLabel("CTRL+select rows to add as Non overlapping");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(10, 197, 325, 14);
		NonOverlapping.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Press to view selected data");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(10, 273, 215, 14);
		NonOverlapping.add(lblNewLabel_6);
		
		lblNonOverlappingSessions = new JLabel("Non overlapping sessions");
		lblNonOverlappingSessions.setForeground(Color.BLACK);
		lblNonOverlappingSessions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNonOverlappingSessions.setBackground(Color.WHITE);
		lblNonOverlappingSessions.setBounds(456, 359, 209, 17);
		NonOverlapping.add(lblNonOverlappingSessions);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(306, 222, 966, 121);
		NonOverlapping.add(scrollPane_4);
		
		ViewSelectedNO = new JTable();
		ViewSelectedNO.setBorder(new LineBorder(Color.BLUE));
		ViewSelectedNO.setUpdateSelectionOnSort(false);
		ViewSelectedNO.setSelectionForeground(Color.WHITE);
		ViewSelectedNO.setGridColor(Color.LIGHT_GRAY);
		ViewSelectedNO.setRowHeight(30);
		ViewSelectedNO.setBackground(Color.WHITE);
		ViewSelectedNO.setSelectionBackground(new Color(176, 224, 230));
		ViewSelectedNO.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewSelectedNO.getTableHeader().setOpaque(false);
		ViewSelectedNO.getTableHeader().setForeground(Color.WHITE);
		ViewSelectedNO.getTableHeader().setBackground(new Color(34, 167, 240));
		scrollPane_4.setViewportView(ViewSelectedNO);
		
		btnDeleteNonoverlappingSession = new JButton("Delete NonOverlapping Session");
		btnDeleteNonoverlappingSession.setForeground(Color.WHITE);
		btnDeleteNonoverlappingSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnDeleteNonoverlappingSession.setFocusPainted(false);
		btnDeleteNonoverlappingSession.setBackground(new Color(210, 77, 87));
		btnDeleteNonoverlappingSession.setBounds(10, 354, 203, 26);
		NonOverlapping.add(btnDeleteNonoverlappingSession);
		
		
		
		//---------------------------------------------------------------------------------------------
		
		btnConsec = new JButton("Consecutive");
		btnConsec.setBounds(31, 86, 211, 38);
		contentPane.add(btnConsec);
		btnConsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(Consecutive);
				try {
					connection = DBConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select * from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					sessionListTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
			}
		});
		btnConsec.setForeground(Color.WHITE);
		btnConsec.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnConsec.setFocusPainted(false);
		btnConsec.setBackground(new Color(31, 58, 147));
		
		
		btnParallel = new JButton("Parallel");
		btnParallel.setBounds(252, 86, 211, 38);
		contentPane.add(btnParallel);
		btnParallel.setForeground(Color.WHITE);
		btnParallel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnParallel.setFocusPainted(false);
		btnParallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(Parallel);
				try {
					connection = DBConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select * from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					sessionListTablePa.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					String query2 = "select * from getSelected";
					PreparedStatement psat2 = connection.prepareStatement(query2);
					ResultSet rs2= psat2.executeQuery();
					
					ViewSelectedParallel.setModel(DbUtils.resultSetToTableModel(rs2));
					
					
					String query3 = "select * from ParallelSession";
					PreparedStatement psat3 = connection.prepareStatement(query3);
					ResultSet rs3= psat3.executeQuery();
					
					ViewParSessions.setModel(DbUtils.resultSetToTableModel(rs3));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
			}
		});
		btnParallel.setBackground(new Color(31, 58, 147));
		
		
		btnNonOverlapping = new JButton("Non Overlapping");
		btnNonOverlapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(NonOverlapping);
				try {
					connection = DBConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select * from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					sessionListTableNo.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					String query2 = "select * from getSelected";
					PreparedStatement psat2 = connection.prepareStatement(query2);
					ResultSet rs2= psat2.executeQuery();
					
					ViewSelectedNO.setModel(DbUtils.resultSetToTableModel(rs2));
					
					
					String query3 = "select * from NonOverlappingSession";
					PreparedStatement psat3 = connection.prepareStatement(query3);
					ResultSet rs3= psat3.executeQuery();
					
					ViewNOSessions.setModel(DbUtils.resultSetToTableModel(rs3));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
			}
		});
		btnNonOverlapping.setBounds(473, 86, 211, 38);
		contentPane.add(btnNonOverlapping);
		btnNonOverlapping.setForeground(Color.WHITE);
		btnNonOverlapping.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnNonOverlapping.setFocusPainted(false);
		btnNonOverlapping.setBackground(new Color(31, 58, 147));
		
		
		btnBack = new JButton("Back");
		btnBack.setBorder(new LineBorder(new Color(64, 64, 64)));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*StudentGroupManagement myhome = new StudentGroupManagement();
				myhome.Show();*/
				
				HomePage home = new HomePage();
				home.Show();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1146, 86, 177, 38);
		contentPane.add(btnBack);
		
		
	
	}
}

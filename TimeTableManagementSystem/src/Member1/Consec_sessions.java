package Member1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

import DBConnection.SqlServerConnection;
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
	private JScrollPane scrollPaneViewparallel;
	public static JTable ViewParSessions;
	private JTable sessionListTablePa;
	private JScrollPane scrollPane2;
	private JTable sessionListTableNo;

	private JButton btnAddNOsessionbtn;

	private JTable ViewNOSessions;

	private JScrollPane scrollPaneViewNo;
	private JButton btnView;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblParallelSessions;
	private JLabel lblNewLabel_5;
	private JLabel lblNonOverlappingSessions;

	private JButton btnDeleteNonoverlappingSession;

	private JButton btnDeleteParallelSession;

	private JButton btnDeleteConsecutiveSession;
	

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
		
		connection = SqlServerConnection.dbConnecter();
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
		scrollPane.setBounds(10, 49, 1262, 213);
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
				
				DefaultTableModel tblModel = (DefaultTableModel)sessionListTable.getModel();
				int indexes[] = sessionListTable.getSelectedRows();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = SqlServerConnection.dbConnecter();
					
				
					    for (int i=0 ;i<indexes.length;i++) {
					    	SessionIndex = tblModel.getValueAt(indexes[i], 0).toString();
					        LecturerNameSession =  tblModel.getValueAt(indexes[i], 1).toString();
					        SubjectCodeSession = tblModel.getValueAt(indexes[i], 2).toString();
					        SubjectNameSession = tblModel.getValueAt(indexes[i], 3).toString();
					        TagSession = tblModel.getValueAt(indexes[i], 4).toString();
					        GroupIDSession = tblModel.getValueAt(indexes[i], 5).toString();
					        StudentCountSession = tblModel.getValueAt(indexes[i], 6).toString();
					        SessionDuration = tblModel.getValueAt(indexes[i], 7).toString();
					        SessionId = tblModel.getValueAt(indexes[i], 8).toString();
					        
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
					    //tblModel.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshConsecTable();
				
			}
		});
		btnAddcosecutivesessionbtn.setForeground(Color.WHITE);
		btnAddcosecutivesessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddcosecutivesessionbtn.setFocusPainted(false);
		btnAddcosecutivesessionbtn.setBackground(new Color(31, 58, 147));
		btnAddcosecutivesessionbtn.setBounds(922, 273, 203, 26);
		Consecutive.add(btnAddcosecutivesessionbtn);
		
		scrollPaneViewConsec = new JScrollPane();
		scrollPaneViewConsec.setBackground(Color.WHITE);
		scrollPaneViewConsec.setBounds(10, 347, 1262, 164);
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
		
		lblNewLabel = new JLabel("Consecutive sessions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(41, 319, 183, 17);
		Consecutive.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CTRL+select rows to add as consecutive ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 24, 228, 14);
		Consecutive.add(lblNewLabel_1);
		
		btnDeleteConsecutiveSession = new JButton("Delete Consecutive Session");
		btnDeleteConsecutiveSession.setForeground(Color.WHITE);
		btnDeleteConsecutiveSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		//btnDeleteConsecutiveSession.setFocusPainted(false);
		btnDeleteConsecutiveSession.setBackground(new Color(210, 77, 87));
		btnDeleteConsecutiveSession.setBounds(922, 522, 203, 26);
		btnDeleteConsecutiveSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
					
					connection = SqlServerConnection.dbConnecter();
					
					int SelectedRowIndex = ViewConSessions.getSelectedRow();
					String ID2 = (ViewConSessions.getModel().getValueAt(SelectedRowIndex, 0)).toString();
					
					String deletequery="delete from ConsecutiveSession where CsessionID='"+ID2+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Concsecutive session removed Sucsessfully!");
					
					psat.close();
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshConsecTable();
			}}
		});
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
		scrollPane1.setBounds(10, 32, 1262, 218);
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
				
				DefaultTableModel tblModel1 = (DefaultTableModel)sessionListTablePa.getModel();
				int indexes[] = sessionListTablePa.getSelectedRows();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = SqlServerConnection.dbConnecter();
					
					    for (int i=0 ;i<indexes.length;i++) {
					    	SessionIndex = tblModel1.getValueAt(indexes[i], 0).toString();
					        LecturerNameSession =  tblModel1.getValueAt(indexes[i], 1).toString();
					        SubjectCodeSession = tblModel1.getValueAt(indexes[i], 2).toString();
					        SubjectNameSession = tblModel1.getValueAt(indexes[i], 3).toString();
					        TagSession = tblModel1.getValueAt(indexes[i], 4).toString();
					        GroupIDSession = tblModel1.getValueAt(indexes[i], 5).toString();
					        StudentCountSession = tblModel1.getValueAt(indexes[i], 6).toString();
					        SessionDuration = tblModel1.getValueAt(indexes[i], 7).toString();
					        SessionId = tblModel1.getValueAt(indexes[i], 8).toString();
					        
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
					    //tblModel1.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshParallelTable();
				
				
			}
		});
		btnAddParallelsessionbtn.setForeground(Color.WHITE);
		btnAddParallelsessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddParallelsessionbtn.setFocusPainted(false);
		btnAddParallelsessionbtn.setBackground(new Color(31, 58, 147));
		btnAddParallelsessionbtn.setBounds(1067, 261, 187, 32);
		Parallel.add(btnAddParallelsessionbtn);
		
		scrollPaneViewparallel = new JScrollPane();
		scrollPaneViewparallel.setBackground(Color.WHITE);
		scrollPaneViewparallel.setBounds(21, 334, 1251, 170);
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
		
		lblNewLabel_3 = new JLabel("CTRL+select rows to add as Parallel");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 11, 228, 14);
		Parallel.add(lblNewLabel_3);
		
		lblParallelSessions = new JLabel("Parallel sessions");
		lblParallelSessions.setForeground(Color.BLACK);
		lblParallelSessions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParallelSessions.setBackground(Color.WHITE);
		lblParallelSessions.setBounds(22, 306, 183, 17);
		Parallel.add(lblParallelSessions);
		
		btnDeleteParallelSession = new JButton("Delete Parallel Session");
		btnDeleteParallelSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure ?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
					
				try {
					
					connection = SqlServerConnection.dbConnecter();
					
					int SelectedRowIndex = ViewParSessions.getSelectedRow();
					String ID2 = (ViewParSessions.getModel().getValueAt(SelectedRowIndex, 0)).toString();
					
					
					String deletequery="delete from ParallelSession where PsessionID='"+ID2+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Parallel session removed Sucsessfully!");
					
					psat.close();
					
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshParallelTable();
				
			}
			}
		});
		btnDeleteParallelSession.setForeground(Color.WHITE);
		btnDeleteParallelSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		//btnDeleteParallelSession.setFocusPainted(false);
		btnDeleteParallelSession.setBackground(new Color(210, 77, 87));
		btnDeleteParallelSession.setBounds(1069, 515, 203, 26);
		Parallel.add(btnDeleteParallelSession);
		
		
		
		
		
		//--------------------------------------------------------------------------------------------
		NonOverlapping= new JPanel();
		NonOverlapping.setBackground(new Color(228, 241, 254));
		SessionslayeredPane.add(NonOverlapping, "name_563722506511600");
		NonOverlapping.setLayout(null);
		
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(null);
		scrollPane2.setBackground(Color.WHITE);
		scrollPane2.setBounds(10, 26, 1262, 205);
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
				
				DefaultTableModel tblModel1 = (DefaultTableModel)sessionListTableNo.getModel();
				int indexes[] = sessionListTableNo.getSelectedRows();
				
				String SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId;
				try {
					connection = SqlServerConnection.dbConnecter();
					
					    for (int i=0 ;i<indexes.length;i++) {
					    	SessionIndex = tblModel1.getValueAt(indexes[i], 0).toString();
					        LecturerNameSession =  tblModel1.getValueAt(indexes[i], 1).toString();
					        SubjectCodeSession = tblModel1.getValueAt(indexes[i], 2).toString();
					        SubjectNameSession = tblModel1.getValueAt(indexes[i], 3).toString();
					        TagSession = tblModel1.getValueAt(indexes[i], 4).toString();
					        GroupIDSession = tblModel1.getValueAt(indexes[i], 5).toString();
					        StudentCountSession = tblModel1.getValueAt(indexes[i], 6).toString();
					        SessionDuration = tblModel1.getValueAt(indexes[i], 7).toString();
					        SessionId = tblModel1.getValueAt(indexes[i], 8).toString();
					        
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
					    //tblModel1.setRowCount(0);
				   
				} catch (Exception e1) {
				    e1.printStackTrace();

				}
				
				RefreshNOTable();
				
				
			}
		});
		btnAddNOsessionbtn.setForeground(Color.WHITE);
		btnAddNOsessionbtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnAddNOsessionbtn.setFocusPainted(false);
		btnAddNOsessionbtn.setBackground(new Color(31, 58, 147));
		btnAddNOsessionbtn.setBounds(975, 242, 268, 31);
		NonOverlapping.add(btnAddNOsessionbtn);
		
		scrollPaneViewNo = new JScrollPane();
		scrollPaneViewNo.setBorder(null);
		scrollPaneViewNo.setBackground(Color.WHITE);
		scrollPaneViewNo.setBounds(10, 313, 1262, 173);
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
		lblNewLabel_5.setBounds(10, 11, 325, 14);
		NonOverlapping.add(lblNewLabel_5);
		
		lblNonOverlappingSessions = new JLabel("Non overlapping sessions");
		lblNonOverlappingSessions.setForeground(Color.BLACK);
		lblNonOverlappingSessions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNonOverlappingSessions.setBackground(Color.WHITE);
		lblNonOverlappingSessions.setBounds(10, 285, 209, 17);
		NonOverlapping.add(lblNonOverlappingSessions);
		
		btnDeleteNonoverlappingSession = new JButton("Delete NonOverlapping Session");
		btnDeleteNonoverlappingSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
					
					
				try {
					
					connection = SqlServerConnection.dbConnecter();
					
					int SelectedRowIndex = ViewNOSessions.getSelectedRow();
					String ID2 = (ViewNOSessions.getModel().getValueAt(SelectedRowIndex, 0)).toString();
					
					String deletequery="delete from NonOverlappingSession where NOSessionID='"+ID2+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Non overlapping session removed Sucsessfully!");
					
					psat.close();
					
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshNOTable();
				
			}
			}
		});
		btnDeleteNonoverlappingSession.setForeground(Color.WHITE);
		btnDeleteNonoverlappingSession.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		//btnDeleteNonoverlappingSession.setFocusPainted(false);
		btnDeleteNonoverlappingSession.setBackground(new Color(210, 77, 87));
		btnDeleteNonoverlappingSession.setBounds(1004, 497, 239, 26);
		NonOverlapping.add(btnDeleteNonoverlappingSession);
		
		
		
		//---------------------------------------------------------------------------------------------
		
		btnConsec = new JButton("Consecutive");
		btnConsec.setBounds(31, 86, 211, 38);
		contentPane.add(btnConsec);
		btnConsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(Consecutive);
				try {
					connection = SqlServerConnection.dbConnecter();
					
					
					
					//retrieve data to a table
					String query = "select SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId,startingTime,endTime from session";
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
					connection = SqlServerConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId,startingTime,endTime from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					sessionListTablePa.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					
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
					connection = SqlServerConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId,startingTime,endTime from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					sessionListTableNo.setModel(DbUtils.resultSetToTableModel(rs));
					
					
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
				
				dispose();
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
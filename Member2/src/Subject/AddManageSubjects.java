package Subject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddManageSubjects extends JFrame {

	private JPanel contentPane;
	private JPanel ManageSubPanel;
	private JPanel AddSubPanel;
	private JLayeredPane SublayeredPane;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtNumOfEvaH;
	private JTextField txtNumOfLabH;
	private JTextField txtSubOffYear;
	private JTextField txtSubOffSem;
	private JTextField txtSubName;
	private JTextField txtSubCode;
	private JTextField txtNumOfLecH;
	private JTextField txtNumOfTuteH;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnLoadTable;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageSubjects frame = new AddManageSubjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanel(JPanel panel) {
		
		SublayeredPane.removeAll();
		SublayeredPane.add(panel);
		SublayeredPane.repaint();
		SublayeredPane.revalidate();
	}
	
	Connection connection=null;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtSubID;
	private JTextField txtSubOffYear2;
	private JTextField txtSubOffSem2;
	private JTextField txtSubName2;
	private JTextField txtSubCode2;
	private JTextField txtNumOfLecH2;
	private JTextField txtNumOfTuteH2;
	private JTextField txtNumOfLabH2;
	private JTextField txtNumOfEvaH2;
	private JLabel lblNewLabel_18;
	
	/**
	 * Create the frame.
	 */
	public AddManageSubjects() {
		
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1303, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SublayeredPane = new JLayeredPane();
		SublayeredPane.setBounds(10, 46, 1269, 593);
		contentPane.add(SublayeredPane);
		SublayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSubPanel = new JPanel();
		SublayeredPane.add(AddSubPanel, "name_127330680826200");
		AddSubPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Offered Year  :");
		lblNewLabel.setBounds(365, 137, 194, 13);
		AddSubPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Offered Semester  :");
		lblNewLabel_2.setBounds(365, 175, 194, 13);
		AddSubPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Subject Name  :");
		lblNewLabel_3.setBounds(365, 214, 194, 13);
		AddSubPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Subject Code  :");
		lblNewLabel_4.setBounds(365, 250, 194, 13);
		AddSubPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Number Of Lecturer Hours  :");
		lblNewLabel_5.setBounds(365, 288, 194, 13);
		AddSubPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Number Of Tutorial Hours  :");
		lblNewLabel_6.setBounds(365, 321, 194, 13);
		AddSubPanel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Number of Lab Hours  :");
		lblNewLabel_7.setBounds(365, 354, 194, 13);
		AddSubPanel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Number of Evalution hours  :");
		lblNewLabel_8.setBounds(365, 390, 194, 13);
		AddSubPanel.add(lblNewLabel_8);
		
		txtNumOfEvaH = new JTextField();
		txtNumOfEvaH.setBounds(532, 387, 186, 19);
		AddSubPanel.add(txtNumOfEvaH);
		txtNumOfEvaH.setColumns(10);
		
		txtNumOfLabH = new JTextField();
		txtNumOfLabH.setBounds(532, 351, 186, 19);
		AddSubPanel.add(txtNumOfLabH);
		txtNumOfLabH.setColumns(10);
		
		txtSubOffYear = new JTextField();
		txtSubOffYear.setBounds(532, 134, 186, 19);
		AddSubPanel.add(txtSubOffYear);
		txtSubOffYear.setColumns(10);
		
		txtSubOffSem = new JTextField();
		txtSubOffSem.setBounds(532, 172, 186, 19);
		AddSubPanel.add(txtSubOffSem);
		txtSubOffSem.setColumns(10);
		
		txtSubName = new JTextField();
		txtSubName.setBounds(532, 211, 186, 19);
		AddSubPanel.add(txtSubName);
		txtSubName.setColumns(10);
		
		txtSubCode = new JTextField();
		txtSubCode.setBounds(532, 247, 186, 19);
		AddSubPanel.add(txtSubCode);
		txtSubCode.setColumns(10);
		
		txtNumOfLecH = new JTextField();
		txtNumOfLecH.setBounds(532, 285, 186, 19);
		AddSubPanel.add(txtNumOfLecH);
		txtNumOfLecH.setColumns(10);
		
		txtNumOfTuteH = new JTextField();
		txtNumOfTuteH.setBounds(532, 318, 186, 19);
		AddSubPanel.add(txtNumOfTuteH);
		txtNumOfTuteH.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Add Subjects :");
		lblNewLabel_9.setBounds(327, 75, 145, 13);
		AddSubPanel.add(lblNewLabel_9);
		
		btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//insert data into the database :
				
           try {
					
					String query="insert into subjects (OfferedYear,OfferedSem,SubjectName,SublectCode,NumOfLecHours,NumOfTuteHours,NumOfLabHours,NumOfEvaltionHours) values (?,?,?,?,?,?,?,?)";                      
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtSubOffYear.getText());
					pst.setString(2, txtSubOffSem.getText());
					pst.setString(3, txtSubName.getText());
					pst.setString(4, txtSubCode.getText());
					pst.setString(5, txtNumOfLecH.getText());
					pst.setString(6, txtNumOfTuteH.getText());
					pst.setString(7, txtNumOfLabH.getText());
					pst.setString(8, txtNumOfEvaH.getText());
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(365, 471, 150, 21);
		AddSubPanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(548, 471, 170, 21);
		AddSubPanel.add(btnNewButton_3);
		
		ManageSubPanel = new JPanel();
		SublayeredPane.add(ManageSubPanel, "name_127354460414000");
		ManageSubPanel.setLayout(null);
		
		btnLoadTable = new JButton("Load Details");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select * from subjects";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnLoadTable.setBounds(885, 52, 85, 21);
		ManageSubPanel.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(544, 104, 702, 380);
		ManageSubPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_4 = new JButton("Update Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_4.setBounds(689, 509, 191, 32);
		ManageSubPanel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Delete Details");
		btnNewButton_5.setBounds(910, 509, 205, 32);
		ManageSubPanel.add(btnNewButton_5);
		
		lblNewLabel_1 = new JLabel("ID  :");
		lblNewLabel_1.setBounds(39, 106, 65, 13);
		ManageSubPanel.add(lblNewLabel_1);
		
		lblNewLabel_10 = new JLabel("Offered Year  :");
		lblNewLabel_10.setBounds(39, 144, 106, 13);
		ManageSubPanel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Offered Semester  :");
		lblNewLabel_11.setBounds(39, 178, 106, 13);
		ManageSubPanel.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name  :");
		lblNewLabel_12.setBounds(39, 222, 106, 13);
		ManageSubPanel.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Subject Code  :");
		lblNewLabel_13.setBounds(39, 261, 106, 13);
		ManageSubPanel.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Number Of Lecture Hours  :");
		lblNewLabel_14.setBounds(39, 303, 106, 13);
		ManageSubPanel.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_15.setBounds(39, 343, 106, 13);
		ManageSubPanel.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Number Of Lab Hours  :");
		lblNewLabel_16.setBounds(39, 383, 106, 13);
		ManageSubPanel.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Number Of Evalution Hours  :");
		lblNewLabel_17.setBounds(39, 428, 106, 13);
		ManageSubPanel.add(lblNewLabel_17);
		
		txtSubID = new JTextField();
		txtSubID.setBounds(189, 103, 177, 19);
		ManageSubPanel.add(txtSubID);
		txtSubID.setColumns(10);
		
		txtSubOffYear2 = new JTextField();
		txtSubOffYear2.setBounds(189, 141, 177, 19);
		ManageSubPanel.add(txtSubOffYear2);
		txtSubOffYear2.setColumns(10);
		
		txtSubOffSem2 = new JTextField();
		txtSubOffSem2.setBounds(189, 175, 177, 19);
		ManageSubPanel.add(txtSubOffSem2);
		txtSubOffSem2.setColumns(10);
		
		txtSubName2 = new JTextField();
		txtSubName2.setBounds(189, 219, 177, 19);
		ManageSubPanel.add(txtSubName2);
		txtSubName2.setColumns(10);
		
		txtSubCode2 = new JTextField();
		txtSubCode2.setBounds(189, 258, 177, 19);
		ManageSubPanel.add(txtSubCode2);
		txtSubCode2.setColumns(10);
		
		txtNumOfLecH2 = new JTextField();
		txtNumOfLecH2.setBounds(189, 300, 177, 19);
		ManageSubPanel.add(txtNumOfLecH2);
		txtNumOfLecH2.setColumns(10);
		
		txtNumOfTuteH2 = new JTextField();
		txtNumOfTuteH2.setBounds(189, 340, 177, 19);
		ManageSubPanel.add(txtNumOfTuteH2);
		txtNumOfTuteH2.setColumns(10);
		
		txtNumOfLabH2 = new JTextField();
		txtNumOfLabH2.setBounds(189, 380, 177, 19);
		ManageSubPanel.add(txtNumOfLabH2);
		txtNumOfLabH2.setColumns(10);
		
		txtNumOfEvaH2 = new JTextField();
		txtNumOfEvaH2.setBounds(189, 425, 177, 19);
		ManageSubPanel.add(txtNumOfEvaH2);
		txtNumOfEvaH2.setColumns(10);
		
		lblNewLabel_18 = new JLabel("ManageDetails  :");
		lblNewLabel_18.setBounds(39, 52, 120, 17);
		ManageSubPanel.add(lblNewLabel_18);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(AddSubPanel);
				
			}
		});
		btnNewButton.setBounds(39, 10, 91, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View ALL & Manage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(ManageSubPanel);
			}
		});
		btnNewButton_1.setBounds(140, 10, 123, 32);
		contentPane.add(btnNewButton_1);
	}
}

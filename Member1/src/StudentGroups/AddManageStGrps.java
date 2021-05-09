package StudentGroups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.DBConnection;
import Home.HomePage;
import Home.StudentGroupManagement;
import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class AddManageStGrps extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JLayeredPane StudentGroupsLayeredPane_1;
	private JPanel AddStudentGrpPanel_1;
	private JPanel ManageStudentGrpPanel_1;
	private JPanel panel_1;
	private JLabel txtrTimeTableManagement;
	private JButton btnAddStGroup_1;
	private JButton btnManageStGroup_1;
	private JPanel AddFormPanel;
	private JLabel lblAcademicYrandsemester;
	private JLabel lblProgram;
	private JLabel lblGroupNumber;
	private JLabel lblSubGroupNumber;
	private JLabel lblGroupId;
	private JLabel lblSubGroupId;
	private JComboBox AcademicYrSemList;
	private JComboBox ProgramListCB;
	private JTextField txtAddNewStudent;
	private JSpinner GroupNoSpinner;
	private JSpinner SubGroupNoSpinner;
	private JTextField GrpID;
	private JTextField SubGrpID;
	private JButton btnClearAdd;
	private JButton btnSaveAdd;
	private JButton btnGenerateGID;
	private JButton btnGenerateSubGID;
	private JPanel ViewStudentGroupsPanel;
	private JPanel GetDetailsFormPanel;
	private JButton btnGenGID;
	private JButton btnGenSubGID;
	private JComboBox AcYrSemViewList;
	private JComboBox ProgramViewList;
	private JTextField ViewGrpID;
	private JTextField ViewSubGrpID;
	private JButton BtnClearView;
	private JButton BtnUpdate;
	private JLabel lblAcademicYearsemesterViewForm;
	private JLabel lblProgramViewForm;
	private JLabel lblGroupNumberViewForm;
	private JLabel lblSubGroupNumberViewForm;
	private JLabel lblGroupIdViewForm;
	private JLabel lblSubGroupIdViewForm;
	private JButton BtnDeleteStGView;
	private JTable ViewStGrpsTable;
	private JScrollPane scrollPane;
	private JLabel lblStGrpID;
	private JTextField textViewStGrpID;
	private JTextField ViewGrpNumbertxt;
	private JTextField ViewSubGrpNotxt;
	private JLabel lblemp_grpID;
	private JLabel lblemp_SubgrpID;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageStGrps frame = new AddManageStGrps();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//switching panels
		public void SwitchPanels(JPanel panel)
		{
			StudentGroupsLayeredPane_1.removeAll();
			StudentGroupsLayeredPane_1.add(panel);
			StudentGroupsLayeredPane_1.repaint();
			StudentGroupsLayeredPane_1.revalidate();
		}
		
		
	//clear form fields after inserting data and after clicking clear button
		public void ClearFields()
		{
			GrpID.setText(null);
			SubGrpID.setText(null);
			AcademicYrSemList.setSelectedIndex(-1);
			ProgramListCB.setSelectedIndex(-1);
			GroupNoSpinner.setValue(0);
			SubGroupNoSpinner.setValue(0);
			
			//clear fields of manage student groups panel form 
			AcYrSemViewList.setSelectedIndex(-1);
			ProgramViewList.setSelectedIndex(-1);
			ViewGrpID.setText(null);
			ViewSubGrpID.setText(null);
			ViewGrpNumbertxt.setText(null);
			ViewSubGrpNotxt.setText(null);
		}
		
		
	//refresh table after doing update and delete
		public void RefreshStGroupsTable()
		{
			try {
				
				String refreshque="select * from StudentGroups";
				PreparedStatement psat= connection.prepareStatement(refreshque);
				ResultSet rs=psat.executeQuery();
				
				ViewStGrpsTable.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception E2)
			{
				E2.printStackTrace();
			}
		}
		
		

	/**
	 * Create the frame.
	 */
	public AddManageStGrps() {
		
		connection = DBConnection.dbConnecter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	//layered panel which contains add students groups panel and manage student groups panel
		StudentGroupsLayeredPane_1 = new JLayeredPane();
		StudentGroupsLayeredPane_1.setBackground(Color.WHITE);
		StudentGroupsLayeredPane_1.setBounds(64, 163, 1223, 494);
		contentPane.add(StudentGroupsLayeredPane_1);
		StudentGroupsLayeredPane_1.setLayout(new CardLayout(0, 0));
		
		
	//add student groups panel
		AddStudentGrpPanel_1 = new JPanel();
		AddStudentGrpPanel_1.setBackground(Color.WHITE);
		StudentGroupsLayeredPane_1.add(AddStudentGrpPanel_1, "name_649734347273200");
		AddStudentGrpPanel_1.setLayout(null);
		
		AddFormPanel = new JPanel();
		AddFormPanel.setBackground(new Color(228, 241, 254));
		AddFormPanel.setBorder(null);
		AddFormPanel.setBounds(115, 11, 990, 472);
		AddStudentGrpPanel_1.add(AddFormPanel);
		AddFormPanel.setLayout(null);
		
		lblAcademicYrandsemester = new JLabel("Academic year and semester :");
		lblAcademicYrandsemester.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblAcademicYrandsemester.setBounds(61, 107, 209, 24);
		AddFormPanel.add(lblAcademicYrandsemester);
		
		lblProgram = new JLabel("Program :");
		lblProgram.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblProgram.setBounds(61, 168, 209, 24);
		AddFormPanel.add(lblProgram);
		
		lblGroupNumber = new JLabel("Group Number :");
		lblGroupNumber.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblGroupNumber.setBounds(61, 234, 209, 24);
		AddFormPanel.add(lblGroupNumber);
		
		lblSubGroupNumber = new JLabel("Sub Group Number :");
		lblSubGroupNumber.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblSubGroupNumber.setBounds(61, 295, 209, 24);
		AddFormPanel.add(lblSubGroupNumber);
		
		lblGroupId = new JLabel("Group ID :");
		lblGroupId.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblGroupId.setBounds(662, 134, 209, 24);
		AddFormPanel.add(lblGroupId);
		
		lblSubGroupId = new JLabel("Sub Group ID:");
		lblSubGroupId.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblSubGroupId.setBounds(662, 295, 209, 24);
		AddFormPanel.add(lblSubGroupId);
		
		String[] AYSList = {"Y1S1","Y1S2","Y2S1","Y2S2","Y3S1","Y3S2","Y4S1","Y4S2"};
		AcademicYrSemList = new JComboBox(AYSList);
		AcademicYrSemList.setSelectedIndex(-1);
		AcademicYrSemList.setBackground(Color.WHITE);
		AcademicYrSemList.setBounds(280, 107, 222, 29);
		AddFormPanel.add(AcademicYrSemList);
		
		
		String[] PRList = {"IT" , "SE" , "DS", "CSE","IE" ,"BM"};
		ProgramListCB = new JComboBox(PRList);
		ProgramListCB.setSelectedIndex(-1);
		ProgramListCB.setBackground(Color.WHITE);
		ProgramListCB.setBounds(280, 168, 222, 29);
		AddFormPanel.add(ProgramListCB);
		
		txtAddNewStudent = new JTextField();
		txtAddNewStudent.setBounds(349, 11, 279, 33);
		AddFormPanel.add(txtAddNewStudent);
		txtAddNewStudent.setBackground(new Color(228, 241, 254));
		txtAddNewStudent.setDisabledTextColor(Color.WHITE);
		txtAddNewStudent.setEditable(false);
		txtAddNewStudent.setBorder(null);
		txtAddNewStudent.setFocusTraversalKeysEnabled(false);
		txtAddNewStudent.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		txtAddNewStudent.setText("Add New Student Group");
		txtAddNewStudent.setColumns(10);
		
		GroupNoSpinner = new JSpinner();
		GroupNoSpinner.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		GroupNoSpinner.setBounds(280, 234, 222, 29);
		AddFormPanel.add(GroupNoSpinner);
		
		SubGroupNoSpinner = new JSpinner();
		SubGroupNoSpinner.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		SubGroupNoSpinner.setBounds(280, 295, 222, 29);
		AddFormPanel.add(SubGroupNoSpinner);
		
		GrpID = new JTextField();
		GrpID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		GrpID.setBounds(662, 168, 220, 29);
		AddFormPanel.add(GrpID);
		GrpID.setColumns(10);
		
		SubGrpID = new JTextField();
		SubGrpID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		SubGrpID.setColumns(10);
		SubGrpID.setBounds(662, 328, 220, 29);
		AddFormPanel.add(SubGrpID);
	
	//clear button of add student group form
		btnClearAdd = new JButton("Clear");
		btnClearAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClearFields();
				
			}
		});
		btnClearAdd.setForeground(Color.WHITE);
		btnClearAdd.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnClearAdd.setFocusPainted(false);
		btnClearAdd.setBackground(new Color(31, 58, 147));
		btnClearAdd.setBounds(529, 402, 132, 38);
		AddFormPanel.add(btnClearAdd);
	
		
	//clear button of add student group form	
		btnSaveAdd = new JButton("Save");
		btnSaveAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(GrpID.getText().trim().isEmpty() && SubGrpID.getText().trim().isEmpty())
				{
					lblemp_grpID.setText("Please generate the group ID");
					lblemp_SubgrpID.setText("Please generate the sub group ID");
				}
				
				else if(GrpID.getText().trim().isEmpty())
				{
					lblemp_grpID.setText("Please generate the group ID");
				}
				
				else if(SubGrpID.getText().trim().isEmpty())
				{
					lblemp_SubgrpID.setText("Please generate the sub group ID");
				}
			
				else {
					
						lblemp_grpID.setText("");
						lblemp_SubgrpID.setText("");
				
					try {
						
						//connection = DBConnection.dbConnecter();
						
						String query1 = "insert into StudentGroups(AcademicYrSem,Program,GroupNo,SubGroupNo,GroupID,SubGroupID) values(?,?,?,?,?,?)";
						PreparedStatement pstat=connection.prepareStatement(query1);
						
						String AcYrSem = AcademicYrSemList.getSelectedItem().toString();
						pstat.setString(1, AcYrSem);
						
						String prog = ProgramListCB.getSelectedItem().toString();
						pstat.setString(2, prog);
						
						String gpSpinner = GroupNoSpinner.getValue().toString();
						pstat.setString(3, gpSpinner);
						
						String subgpSpinner = SubGroupNoSpinner.getValue().toString();
						pstat.setString(4, subgpSpinner);
						
						//get generated group id and sub group id
						pstat.setString(5, GrpID.getText());
						pstat.setString(6, SubGrpID.getText());
						
						//data insertion success message
						pstat.execute();
						JOptionPane.showMessageDialog(null, "Data inserted successfully!");
						
						pstat.close();
						ClearFields();
						
						
					}
					catch(Exception e1)
					{
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "A Student Group with this ID already exists!!");
					}
				
				}
			}
				
			
		});
		btnSaveAdd.setForeground(Color.WHITE);
		btnSaveAdd.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnSaveAdd.setFocusPainted(false);
		btnSaveAdd.setBackground(new Color(27, 163, 156));
		btnSaveAdd.setBounds(719, 402, 132, 38);
		AddFormPanel.add(btnSaveAdd);
		
	//Generate Group id button of add student group form
		btnGenerateGID = new JButton("Generate GroupID");
		btnGenerateGID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					String AcYrSem = AcademicYrSemList.getSelectedItem().toString();	
					String prog = ProgramListCB.getSelectedItem().toString();
					String gpSpinner = GroupNoSpinner.getValue().toString();
					
					
				
					String generatedGrpId = AcYrSem+"."+prog+"."+ gpSpinner;
					GrpID.setText(generatedGrpId);
					
					
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				
			}
				
			
		});
		btnGenerateGID.setForeground(Color.WHITE);
		btnGenerateGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnGenerateGID.setFocusPainted(false);
		btnGenerateGID.setBackground(new Color(31, 58, 147));
		btnGenerateGID.setBounds(662, 85, 220, 38);
		AddFormPanel.add(btnGenerateGID);
	
		
	//Generate Sub Group id button of add student group form
		btnGenerateSubGID = new JButton("Generate Sub GroupID");
		btnGenerateSubGID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					String AcYrSem = AcademicYrSemList.getSelectedItem().toString();	
					String prog = ProgramListCB.getSelectedItem().toString();
					String gpSpinner = GroupNoSpinner.getValue().toString();
					String subgpSpinner = SubGroupNoSpinner.getValue().toString();
					
	
						
					String generatedSubGrpId = AcYrSem+"."+prog+"."+ gpSpinner+"."+subgpSpinner;
					SubGrpID.setText(generatedSubGrpId);
		
					
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
			}
		});
		btnGenerateSubGID.setActionCommand("Generate Sub GroupID");
		btnGenerateSubGID.setForeground(Color.WHITE);
		btnGenerateSubGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnGenerateSubGID.setFocusPainted(false);
		btnGenerateSubGID.setBackground(new Color(31, 58, 147));
		btnGenerateSubGID.setBounds(662, 248, 220, 38);
		AddFormPanel.add(btnGenerateSubGID);
		
		lblemp_grpID = new JLabel("");
		lblemp_grpID.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblemp_grpID.setForeground(Color.RED);
		lblemp_grpID.setBounds(662, 208, 220, 14);
		AddFormPanel.add(lblemp_grpID);
		
		lblemp_SubgrpID = new JLabel("");
		lblemp_SubgrpID.setForeground(Color.RED);
		lblemp_SubgrpID.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblemp_SubgrpID.setBounds(662, 364, 220, 14);
		AddFormPanel.add(lblemp_SubgrpID);
		
		
		
	//manage student groups panel
		ManageStudentGrpPanel_1 = new JPanel();
		ManageStudentGrpPanel_1.setBackground(Color.WHITE);
		StudentGroupsLayeredPane_1.add(ManageStudentGrpPanel_1, "name_649838542681000");
		ManageStudentGrpPanel_1.setLayout(null);
		
		ViewStudentGroupsPanel = new JPanel();
		ViewStudentGroupsPanel.setBounds(10, 0, 726, 483);
		ViewStudentGroupsPanel.setBackground(new Color(228, 241, 254));
		ViewStudentGroupsPanel.setBorder(null);
		ManageStudentGrpPanel_1.add(ViewStudentGroupsPanel);
		ViewStudentGroupsPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 21, 694, 451);
		ViewStudentGroupsPanel.add(scrollPane);
		
		ViewStGrpsTable = new JTable();
		ViewStGrpsTable.setRowHeight(30);
		ViewStGrpsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ViewStGrpsTable.setSelectionBackground(new Color(107,185,240));
		ViewStGrpsTable.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewStGrpsTable.getTableHeader().setOpaque(false);
		ViewStGrpsTable.getTableHeader().setForeground(new Color(255,255,255));
		ViewStGrpsTable.getTableHeader().setBackground(new Color(32,236,203));
		ViewStGrpsTable.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		
	//fetch data after selecting
		ViewStGrpsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					int row = ViewStGrpsTable.getSelectedRow();
					String ID2 = (ViewStGrpsTable.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from StudentGroups where StGrpID= '"+ID2+"'";
					
					PreparedStatement psat=connection.prepareStatement(query);
					
					ResultSet rs=psat.executeQuery();
					
					while(rs.next())
					{
						textViewStGrpID.setText(rs.getString("StGrpID"));
						AcYrSemViewList.setSelectedItem(rs.getString("AcademicYrSem"));
						ProgramViewList.setSelectedItem(rs.getString("Program"));
						
						ViewGrpNumbertxt.setText(rs.getString("GroupNo"));
						ViewSubGrpNotxt.setText(rs.getString("SubGroupNo"));
						ViewGrpID.setText(rs.getString("GroupID"));
						ViewSubGrpID.setText(rs.getString("SubGroupID"));
					}
					
					psat.close();
					
				}
				catch(Exception e2) {
					
					e2.printStackTrace();
				}
				
			}
			
		});
		
		
		scrollPane.setViewportView(ViewStGrpsTable);
		
		GetDetailsFormPanel = new JPanel();
		GetDetailsFormPanel.setBounds(770, 0, 443, 483);
		GetDetailsFormPanel.setBackground(new Color(228, 241, 254));
		GetDetailsFormPanel.setBorder(null);
		ManageStudentGrpPanel_1.add(GetDetailsFormPanel);
		GetDetailsFormPanel.setLayout(null);
		
	
	//generating sub group id of manage students Groups panel
		btnGenGID = new JButton("Generate GroupID");
		btnGenGID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					String yr = AcYrSemViewList.getSelectedItem().toString();
					String pr = ProgramViewList.getSelectedItem().toString();
					String Gno = ViewGrpNumbertxt.getText().toString();
					
					String gengrpID = yr+"."+pr+"."+Gno;
					ViewGrpID.setText(gengrpID);
					
					
					
				}catch(Exception e5) {
					
					e5.printStackTrace();
				}
				
				
			}
		});
		btnGenGID.setForeground(Color.WHITE);
		btnGenGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnGenGID.setFocusPainted(false);
		btnGenGID.setBackground(new Color(31, 58, 147));
		btnGenGID.setBounds(109, 213, 185, 30);
		GetDetailsFormPanel.add(btnGenGID);
		
	//generating sub group id of manage students Groups panel
		btnGenSubGID = new JButton("Generate SubGroupID");
		btnGenSubGID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					
					//connection = DBConnection.dbConnecter();
					
					String yr = AcYrSemViewList.getSelectedItem().toString();
					String pr = ProgramViewList.getSelectedItem().toString();
					String Gno = ViewGrpNumbertxt.getText().toString();
					String SubGNo = ViewSubGrpNotxt.getText().toString();
					
					String gensubgrpID = yr+"."+pr+"."+Gno+"."+SubGNo;
					ViewSubGrpID.setText(gensubgrpID);
					
					
					
				}catch(Exception e5) {
					
					e5.printStackTrace();
				}
				
			}
		});
		btnGenSubGID.setForeground(Color.WHITE);
		btnGenSubGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		btnGenSubGID.setFocusPainted(false);
		btnGenSubGID.setBackground(new Color(31, 58, 147));
		btnGenSubGID.setBounds(109, 310, 185, 30);
		GetDetailsFormPanel.add(btnGenSubGID);
		
		AcYrSemViewList = new JComboBox(AYSList);
		AcYrSemViewList.setSelectedIndex(-1);
		AcYrSemViewList.setBackground(Color.WHITE);
		AcYrSemViewList.setBounds(220, 57, 185, 24);
		GetDetailsFormPanel.add(AcYrSemViewList);
		
		ProgramViewList = new JComboBox(PRList);
		ProgramViewList.setSelectedIndex(-1);
		ProgramViewList.setBackground(Color.WHITE);
		ProgramViewList.setBounds(220, 92, 185, 24);
		GetDetailsFormPanel.add(ProgramViewList);
		
		ViewGrpID = new JTextField();
		ViewGrpID.setBounds(220, 254, 185, 24);
		GetDetailsFormPanel.add(ViewGrpID);
		ViewGrpID.setColumns(10);
		
		ViewSubGrpID = new JTextField();
		ViewSubGrpID.setColumns(10);
		ViewSubGrpID.setBounds(220, 351, 185, 24);
		GetDetailsFormPanel.add(ViewSubGrpID);
		
		BtnClearView = new JButton("Clear");
		BtnClearView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearFields();
			}
		});
		BtnClearView.setForeground(Color.WHITE);
		BtnClearView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		BtnClearView.setFocusPainted(false);
		BtnClearView.setBackground(new Color(31, 58, 147));
		BtnClearView.setBounds(73, 401, 123, 30);
		GetDetailsFormPanel.add(BtnClearView);
		
		BtnUpdate = new JButton("Update");
		BtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					String query="update StudentGroups set AcademicYrSem='"+AcYrSemViewList.getSelectedItem()+"' , Program='"+ProgramViewList.getSelectedItem()+"' ,GroupNo='"+ViewGrpNumbertxt.getText()+"',SubGroupNo='"+ViewSubGrpNotxt.getText()+"',GroupId='"+ViewGrpID.getText()+"',SubGroupID='"+ViewSubGrpID.getText()+"'  where StGrpID='"+textViewStGrpID.getText()+"' ";                    
					PreparedStatement psat=connection.prepareStatement(query);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Update Sucsessful!");
					
					psat.close();
					ClearFields();
					
				}
				catch(Exception e5)
				{
					e5.printStackTrace();
					JOptionPane.showMessageDialog(null, "ID with this number already in the system!!");
				}
				
				
				//to refresh the table after updating
				RefreshStGroupsTable();
				
			}
		});
		BtnUpdate.setForeground(Color.WHITE);
		BtnUpdate.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		BtnUpdate.setFocusPainted(false);
		BtnUpdate.setBackground(new Color(27, 163, 156));
		BtnUpdate.setBounds(253, 401, 123, 30);
		GetDetailsFormPanel.add(BtnUpdate);
		
		lblAcademicYearsemesterViewForm = new JLabel("Academic year &semester :");
		lblAcademicYearsemesterViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblAcademicYearsemesterViewForm.setBounds(10, 55, 209, 24);
		GetDetailsFormPanel.add(lblAcademicYearsemesterViewForm);
		
		lblProgramViewForm = new JLabel("Program :");
		lblProgramViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblProgramViewForm.setBounds(10, 90, 209, 24);
		GetDetailsFormPanel.add(lblProgramViewForm);
		
		lblGroupNumberViewForm = new JLabel("Group Number:");
		lblGroupNumberViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblGroupNumberViewForm.setBounds(10, 123, 209, 24);
		GetDetailsFormPanel.add(lblGroupNumberViewForm);
		
		lblSubGroupNumberViewForm = new JLabel("Sub Group Number :");
		lblSubGroupNumberViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblSubGroupNumberViewForm.setBounds(10, 167, 209, 24);
		GetDetailsFormPanel.add(lblSubGroupNumberViewForm);
		
		lblGroupIdViewForm = new JLabel("Group ID :");
		lblGroupIdViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblGroupIdViewForm.setBounds(10, 252, 209, 24);
		GetDetailsFormPanel.add(lblGroupIdViewForm);
		lblSubGroupIdViewForm = new JLabel("Sub Group ID :");
		lblSubGroupIdViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblSubGroupIdViewForm.setBounds(10, 349, 209, 24);
		GetDetailsFormPanel.add(lblSubGroupIdViewForm);
		
		BtnDeleteStGView = new JButton("Delete");
		BtnDeleteStGView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					String deletequery="delete from StudentGroups where StGrpID='"+textViewStGrpID.getText()+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					psat.close();
					ClearFields();
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshStGroupsTable();
				
			}
		});
		BtnDeleteStGView.setForeground(Color.WHITE);
		BtnDeleteStGView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		BtnDeleteStGView.setFocusPainted(false);
		BtnDeleteStGView.setBackground(new Color(210, 77, 87));
		BtnDeleteStGView.setBounds(171, 442, 123, 30);
		GetDetailsFormPanel.add(BtnDeleteStGView);
		
		lblStGrpID = new JLabel("Student GroupID :");
		lblStGrpID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		lblStGrpID.setBounds(10, 20, 209, 24);
		GetDetailsFormPanel.add(lblStGrpID);
		
		textViewStGrpID = new JTextField();
		textViewStGrpID.setEditable(false);
		textViewStGrpID.setColumns(10);
		textViewStGrpID.setBounds(220, 22, 185, 24);
		GetDetailsFormPanel.add(textViewStGrpID);
		
		ViewGrpNumbertxt = new JTextField();
		ViewGrpNumbertxt.setColumns(10);
		ViewGrpNumbertxt.setBounds(220, 127, 185, 24);
		GetDetailsFormPanel.add(ViewGrpNumbertxt);
		
		ViewSubGrpNotxt = new JTextField();
		ViewSubGrpNotxt.setColumns(10);
		ViewSubGrpNotxt.setBounds(220, 171, 185, 24);
		GetDetailsFormPanel.add(ViewSubGrpNotxt);
	
	//Header
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setBounds(0, 0, 1365, 75);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(75, 119, 190));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtrTimeTableManagement = new JLabel("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Lucida Bright", Font.BOLD, 26));
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		txtrTimeTableManagement.setBounds(370, 11, 481, 43);
		panel_1.add(txtrTimeTableManagement); //end of header
		
		
	//Add Student group main button--change panels	
		btnAddStGroup_1 = new JButton("Add Student Group");
		btnAddStGroup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPanels(AddStudentGrpPanel_1);
			}
		});
		btnAddStGroup_1.setFocusPainted(false);
		btnAddStGroup_1.setBackground(new Color(31, 58, 147));
		btnAddStGroup_1.setForeground(Color.WHITE);
		btnAddStGroup_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnAddStGroup_1.setBounds(64, 114, 294, 38);
		contentPane.add(btnAddStGroup_1);
		
		
	//Manage Student group main button-- change panels
		btnManageStGroup_1 = new JButton("Manage Student Groups");
		btnManageStGroup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPanels(ManageStudentGrpPanel_1);
				
				try {
					
					//connection = DBConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select * from StudentGroups";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					ViewStGrpsTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				
			}
		});
		btnManageStGroup_1.setFocusPainted(false);
		btnManageStGroup_1.setBackground(new Color(31, 58, 147));
		btnManageStGroup_1.setForeground(Color.WHITE);
		btnManageStGroup_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnManageStGroup_1.setBounds(453, 114, 294, 38);
		contentPane.add(btnManageStGroup_1);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*StudentGroupManagement myhome = new StudentGroupManagement();
				myhome.Show();*/
				
				HomePage home = new HomePage();
				home.Show();
			}
		});
		btnBack.setBorder(new LineBorder(new Color(64, 64, 64)));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1126, 86, 161, 38);
		contentPane.add(btnBack);
	
		
		
	}
}

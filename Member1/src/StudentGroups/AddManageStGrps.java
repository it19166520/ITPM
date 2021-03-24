package StudentGroups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.DBConnection;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;

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
		ProgramListCB = new JComboBox();
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
		btnClearAdd.setForeground(Color.WHITE);
		btnClearAdd.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnClearAdd.setFocusPainted(false);
		btnClearAdd.setBackground(new Color(31, 58, 147));
		btnClearAdd.setBounds(529, 402, 132, 38);
		AddFormPanel.add(btnClearAdd);
	
		
	//clear button of add student group form	
		btnSaveAdd = new JButton("Save");
		btnSaveAdd.setForeground(Color.WHITE);
		btnSaveAdd.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnSaveAdd.setFocusPainted(false);
		btnSaveAdd.setBackground(new Color(27, 163, 156));
		btnSaveAdd.setBounds(719, 402, 132, 38);
		AddFormPanel.add(btnSaveAdd);
		
	//Generate Group id button of add student group form
		btnGenerateGID = new JButton("Generate GroupID");
		btnGenerateGID.setForeground(Color.WHITE);
		btnGenerateGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnGenerateGID.setFocusPainted(false);
		btnGenerateGID.setBackground(new Color(31, 58, 147));
		btnGenerateGID.setBounds(662, 85, 220, 38);
		AddFormPanel.add(btnGenerateGID);
	
		
	//Generate Sub Group id button of add student group form
		btnGenerateSubGID = new JButton("Generate Sub GroupID");
		btnGenerateSubGID.setActionCommand("Generate Sub GroupID");
		btnGenerateSubGID.setForeground(Color.WHITE);
		btnGenerateSubGID.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnGenerateSubGID.setFocusPainted(false);
		btnGenerateSubGID.setBackground(new Color(31, 58, 147));
		btnGenerateSubGID.setBounds(662, 248, 220, 38);
		AddFormPanel.add(btnGenerateSubGID);
		
		
		
	//manage student groups panel
		ManageStudentGrpPanel_1 = new JPanel();
		ManageStudentGrpPanel_1.setBackground(Color.WHITE);
		StudentGroupsLayeredPane_1.add(ManageStudentGrpPanel_1, "name_649838542681000");
		ManageStudentGrpPanel_1.setLayout(null);
	
	//Header
		panel_1 = new JPanel();
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
		btnAddStGroup_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnAddStGroup_1.setBounds(64, 114, 294, 38);
		contentPane.add(btnAddStGroup_1);
		
		
	//Manage Student group main button-- change panels
		btnManageStGroup_1 = new JButton("Manage Student Group");
		btnManageStGroup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPanels(ManageStudentGrpPanel_1);
				
			}
		});
		btnManageStGroup_1.setFocusPainted(false);
		btnManageStGroup_1.setBackground(new Color(31, 58, 147));
		btnManageStGroup_1.setForeground(Color.WHITE);
		btnManageStGroup_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnManageStGroup_1.setBounds(453, 114, 294, 38);
		contentPane.add(btnManageStGroup_1);
	
		
		
	}
}

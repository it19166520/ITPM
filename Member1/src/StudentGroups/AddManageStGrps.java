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

package Lecturer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class AddManageLecturer extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JLayeredPane LeclayeredPane;
	private JPanel panel3;
	private JTextField txtLecturerName;
	private JTextField txtLecturerID;
	private JTextField txtRank;
	private JTextField txtMonday;
	private JTextField txtTuesday;
	private JTextField txtWednesday;
	private JTextField txtThursday;
	private JTextField txtFriday;
	private JTextField txtSatarday;
	private JTextField txtSunday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageLecturer frame = new AddManageLecturer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPannels(JPanel panel) {
		
		LeclayeredPane.removeAll();
		LeclayeredPane.add(panel);
		LeclayeredPane.repaint();
		LeclayeredPane.revalidate();
		
	}

	/**
	 * Create the frame.
	 */
	public AddManageLecturer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1277, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LeclayeredPane = new JLayeredPane();
		LeclayeredPane.setBounds(10, 72, 1243, 576);
		contentPane.add(LeclayeredPane);
		LeclayeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LeclayeredPane.add(panel1, "name_74284114373600");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(61, 45, 507, 488);
		panel1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setBounds(46, 94, 91, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setBounds(46, 137, 91, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(46, 179, 91, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setBounds(46, 218, 91, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setBounds(46, 255, 58, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setBounds(46, 302, 91, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setBounds(46, 342, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setBounds(46, 434, 45, 13);
		panel.add(lblNewLabel_9);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setBounds(147, 91, 96, 19);
		panel.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		JComboBox txtFaculty = new JComboBox();
		txtFaculty.setBounds(147, 133, 96, 21);
		panel.add(txtFaculty);
		
		JComboBox txtDepartment = new JComboBox();
		txtDepartment.setBounds(147, 175, 96, 21);
		panel.add(txtDepartment);
		
		JComboBox txtCampus = new JComboBox();
		txtCampus.setBounds(147, 214, 96, 21);
		panel.add(txtCampus);
		
		JComboBox txtBuilding = new JComboBox();
		txtBuilding.setBounds(147, 251, 96, 21);
		panel.add(txtBuilding);
		
		JComboBox txtLevel = new JComboBox();
		txtLevel.setBounds(147, 338, 96, 21);
		panel.add(txtLevel);
		
		txtLecturerID = new JTextField();
		txtLecturerID.setBounds(147, 299, 96, 19);
		panel.add(txtLecturerID);
		txtLecturerID.setColumns(10);
		
		txtRank = new JTextField();
		txtRank.setBounds(147, 431, 96, 19);
		panel.add(txtRank);
		txtRank.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Generate ID");
		btnNewButton_3.setBounds(101, 392, 85, 21);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(625, 45, 565, 406);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setBounds(41, 92, 92, 13);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setBounds(41, 133, 92, 13);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Wednessday  :");
		lblNewLabel_12.setBounds(41, 176, 92, 13);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setBounds(41, 215, 92, 13);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setBounds(41, 256, 92, 13);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setBounds(41, 300, 92, 13);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setBounds(41, 342, 92, 13);
		panel_1.add(lblNewLabel_16);
		
		txtMonday = new JTextField();
		txtMonday.setBounds(141, 89, 185, 19);
		panel_1.add(txtMonday);
		txtMonday.setColumns(10);
		
		txtTuesday = new JTextField();
		txtTuesday.setBounds(141, 130, 185, 19);
		panel_1.add(txtTuesday);
		txtTuesday.setColumns(10);
		
		txtWednesday = new JTextField();
		txtWednesday.setBounds(141, 173, 185, 19);
		panel_1.add(txtWednesday);
		txtWednesday.setColumns(10);
		
		txtThursday = new JTextField();
		txtThursday.setBounds(141, 212, 185, 19);
		panel_1.add(txtThursday);
		txtThursday.setColumns(10);
		
		txtFriday = new JTextField();
		txtFriday.setBounds(141, 253, 185, 19);
		panel_1.add(txtFriday);
		txtFriday.setColumns(10);
		
		txtSatarday = new JTextField();
		txtSatarday.setBounds(141, 297, 185, 19);
		panel_1.add(txtSatarday);
		txtSatarday.setColumns(10);
		
		txtSunday = new JTextField();
		txtSunday.setBounds(141, 342, 185, 19);
		panel_1.add(txtSunday);
		txtSunday.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Active days and Hours :");
		lblNewLabel_17.setBounds(24, 50, 194, 13);
		panel_1.add(lblNewLabel_17);
		
		JButton btnNewButton_4 = new JButton("Save Details  ");
		btnNewButton_4.setBounds(692, 494, 138, 21);
		panel1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear  ");
		btnNewButton_5.setBounds(912, 494, 85, 21);
		panel1.add(btnNewButton_5);
		
		panel2 = new JPanel();
		LeclayeredPane.add(panel2, "name_74288783095000");
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("pannel2");
		lblNewLabel_1.setBounds(208, 260, 45, 13);
		panel2.add(lblNewLabel_1);
		
		panel3 = new JPanel();
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("pannel 3");
		lblNewLabel_2.setBounds(199, 234, 45, 13);
		panel3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel1);
			}
		});
		btnNewButton.setBounds(10, 41, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Lecturer Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel2);
			}
		});
		btnNewButton_1.setBounds(105, 41, 143, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Active Hours");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel3);
			}
		});
		btnNewButton_2.setBounds(258, 41, 143, 21);
		contentPane.add(btnNewButton_2);
	}
}

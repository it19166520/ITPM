package locataion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class pie {

	private JFrame frmStatistics;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pie window = new pie();
					window.frmStatistics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	
	/**
	 * Initialize the contents of the frame.
	 * @param <DefaultPieDataset>
	 */
	
		
		private <DefaultPieDataset> void initialize() {
			frmStatistics = new JFrame();
			frmStatistics.setTitle("Statistics");
			frmStatistics.getContentPane().setForeground(new Color(0, 0, 128));
			frmStatistics.getContentPane().setBackground(Color.WHITE);
			frmStatistics.setBounds(0,0,1370,728);
			frmStatistics.getContentPane().setLayout(null);
			
			
			
			JTextPane txtpnTimtableManagement = new JTextPane();
			txtpnTimtableManagement.setBounds(0, 0, 1354, 76);
			txtpnTimtableManagement.setFont(new Font("Tahoma", Font.BOLD, 33));
			txtpnTimtableManagement.setText("Timtable Management");
			txtpnTimtableManagement.setBackground(Color.LIGHT_GRAY);
			frmStatistics.getContentPane().add(txtpnTimtableManagement);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 255, 240));
			panel.setBounds(0, 72, 1354, 606);
			frmStatistics.getContentPane().add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(672, 5, 10, 10);
			panel.add(panel_1);
			
			JLabel lblNewLabel = new JLabel("Registered Lectures");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(30, 147, 205, 65);
			panel.add(lblNewLabel);
			
			JLabel lblRegisteredStudents = new JLabel("Registered Students");
			lblRegisteredStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredStudents.setBounds(369, 147, 205, 65);
			panel.add(lblRegisteredStudents);
			
			JLabel lblRegisteredSubjects = new JLabel("Registered Subjects");
			lblRegisteredSubjects.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredSubjects.setBounds(725, 147, 205, 65);
			panel.add(lblRegisteredSubjects);
			
			JLabel lblRegisteredRooms = new JLabel("Registered Rooms");
			lblRegisteredRooms.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredRooms.setBounds(1061, 147, 205, 65);
			panel.add(lblRegisteredRooms);
			
			textField = new JTextField();
			textField.setBounds(30, 50, 172, 102);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(358, 50, 172, 102);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(721, 50, 172, 102);
			panel.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(1039, 50, 172, 102);
			panel.add(textField_3);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(30, 223, 500, 349);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Lastest News");
			lblNewLabel_1.setBackground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_1.setBounds(10, 0, 500, 56);
			panel_2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Registered Lectures");
			lblNewLabel_2.setBounds(61, 80, 117, 28);
			panel_2.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("Registered Students");
			lblNewLabel_2_1.setBounds(61, 139, 117, 28);
			panel_2.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2_2 = new JLabel("Registered Subjects");
			lblNewLabel_2_2.setBounds(61, 206, 117, 28);
			panel_2.add(lblNewLabel_2_2);
			
			JLabel lblNewLabel_2_3 = new JLabel("Registered Rooms");
			lblNewLabel_2_3.setBounds(61, 270, 117, 28);
			panel_2.add(lblNewLabel_2_3);
			
			textField_4 = new JTextField();
			textField_4.setBounds(223, 78, 182, 26);
			panel_2.add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(223, 139, 182, 30);
			panel_2.add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(223, 210, 182, 26);
			panel_2.add(textField_6);
			
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(223, 274, 182, 26);
			panel_2.add(textField_7);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(602, 223, 534, 349);
			panel.add(panel_3);
			
			
		
	}
}

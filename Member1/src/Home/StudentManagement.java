package Home;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Cursor;

public class StudentManagement {

	private JPanel contentPane;
	private JFrame frame;
	private JButton TagManagement;
	private JPanel panel_1;
	private JTextArea txtrTimeTableManagement;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement window = new StudentManagement();
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
	public StudentManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(0, 0, 1370, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton StudentGroupManagementBtn = new JButton("Student Group Management");
		StudentGroupManagementBtn.setFocusPainted(false);
		StudentGroupManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		StudentGroupManagementBtn.setBorderPainted(false);
		StudentGroupManagementBtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		StudentGroupManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//navigate to AddManageStGrps tab
				/*JFrame AddManageStGrps  = new AddManageStGrps();
				AddManageStGrps.show();*/
				
				
			}
		});
		StudentGroupManagementBtn.setBounds(410, 175, 335, 46);
		StudentGroupManagementBtn.setBackground(new Color(65, 131, 215));
		StudentGroupManagementBtn.setForeground(Color.WHITE);
		frame.getContentPane().add(StudentGroupManagementBtn);
		
		TagManagement = new JButton("Tags Management");
		TagManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*JFrame AddManageTags  = new AddManageTags();
				AddManageTags.show();*/
				
			}
		});
		
		TagManagement.setForeground(Color.WHITE);
		TagManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		TagManagement.setFocusPainted(false);
		TagManagement.setBorderPainted(false);
		TagManagement.setBackground(new Color(65, 131, 215));
		TagManagement.setBounds(410, 284, 335, 46);
		frame.getContentPane().add(TagManagement);
		
		panel_1 = new JPanel();
		panel_1.setBounds(58, 23, 229, 83);
		panel_1.setBounds(0, 0, 1365, 75);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(75, 119, 190));
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		contentPane.add(panel_1);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setBounds(407, 25, 395, 39);
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setText("Timetable Management System");
		panel_1.add(txtrTimeTableManagement);
		
		
		
		
	}
}

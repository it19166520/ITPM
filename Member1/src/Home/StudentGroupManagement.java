package Home;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import StudentGroups.AddManageStGrps;
import Tags.AddManageTags;

import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentGroupManagement {

	private JFrame frame;
	private JPanel panel_1;
	private JPanel panel;
	private JButton StudentGrpManagementBtn;
	private JButton TagsManagementBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGroupManagement window = new StudentGroupManagement();
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
	public StudentGroupManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(0, 0, 1365, 75);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(75, 119, 190));
		
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Timetable Management System");
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(463, 21, 407, 43);
		panel.add(lblNewLabel);
		
		StudentGrpManagementBtn = new JButton("Student Group Management");
		StudentGrpManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame AddManageStGrps = new AddManageStGrps();
				AddManageStGrps.show();
				
			}
		});
		StudentGrpManagementBtn.setBounds(534, 215, 300, 33);
		StudentGrpManagementBtn.setFocusPainted(false);
		StudentGrpManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		StudentGrpManagementBtn.setBorderPainted(false);
		StudentGrpManagementBtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		StudentGrpManagementBtn.setBounds(410, 175, 335, 46);
		StudentGrpManagementBtn.setBackground(new Color(65, 131, 215));
		StudentGrpManagementBtn.setForeground(Color.WHITE);
		
		
		frame.getContentPane().add(StudentGrpManagementBtn);
		
		TagsManagementBtn = new JButton("Tags Management");
		TagsManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame AddManageTags = new AddManageTags();
				AddManageTags.show();
				
			}
		});
		TagsManagementBtn.setForeground(Color.WHITE);
		TagsManagementBtn.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		TagsManagementBtn.setFocusPainted(false);
		TagsManagementBtn.setBorderPainted(false);
		TagsManagementBtn.setBackground(new Color(65, 131, 215));
		TagsManagementBtn.setBounds(410, 269, 335, 46);
		frame.getContentPane().add(TagsManagementBtn);
		frame.setBounds(0, 0, 1370, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}

	public void Show() {
		// TODO Auto-generated method stub
		JFrame ho = this.frame;
		ho.show();
	}

}

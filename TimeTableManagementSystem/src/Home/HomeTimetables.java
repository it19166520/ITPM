package Home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class HomeTimetables {

	JFrame timetableMenuframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTimetables window = new HomeTimetables();
					window.timetableMenuframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeTimetables() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		timetableMenuframe = new JFrame();
		timetableMenuframe.getContentPane().setBackground(Color.WHITE);
		timetableMenuframe.getContentPane().setForeground(Color.WHITE);
		timetableMenuframe.setBounds(0, 0, 1370, 728);
		timetableMenuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timetableMenuframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Timetable Of a Particular Lecturer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(640, 283, 435, 79);
		timetableMenuframe.getContentPane().add(lblNewLabel);
		
		JButton locationmng_1_1 = new JButton("View The Timetable");
		locationmng_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1.setForeground(Color.BLACK);
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setBounds(958, 294, 340, 52);
		timetableMenuframe.getContentPane().add(locationmng_1_1);
		
		JLabel lblTheTimetableOf = new JLabel("The Timetable Of a Particular Student Group");
		lblTheTimetableOf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheTimetableOf.setBounds(640, 380, 362, 79);
		timetableMenuframe.getContentPane().add(lblTheTimetableOf);
		
		JButton locationmng_1_1_1 = new JButton("View The Timetable");
		locationmng_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1_1.setForeground(Color.BLACK);
		locationmng_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1_1.setBounds(958, 391, 340, 52);
		timetableMenuframe.getContentPane().add(locationmng_1_1_1);
		
		JLabel lblTheTimetableOf_2 = new JLabel("The Timetable Of a Particular Room");
		lblTheTimetableOf_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheTimetableOf_2.setBounds(640, 487, 396, 79);
		timetableMenuframe.getContentPane().add(lblTheTimetableOf_2);
		
		JButton locationmng_1_1_1_1 = new JButton("View The Timetable");
		locationmng_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1_1_1.setForeground(Color.BLACK);
		locationmng_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1_1_1.setBounds(958, 512, 340, 52);
		timetableMenuframe.getContentPane().add(locationmng_1_1_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.Homeframe.setVisible(true);
				timetableMenuframe.dispose();
				
			}
		});
		btnNewButton.setBounds(1198, 90, 135, 58);
		timetableMenuframe.getContentPane().add(btnNewButton);
		
		JButton locationmng_1_1_2 = new JButton("Generate Timetable");
		locationmng_1_1_2.setForeground(new Color(255, 255, 255));
		locationmng_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1_2.setBackground(new Color(0, 0, 128));
		locationmng_1_1_2.setBounds(498, 120, 312, 58);
		timetableMenuframe.getContentPane().add(locationmng_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		timetableMenuframe.getContentPane().add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HomeTimetables.class.getResource("/Images/How-to-make-an-effective-timetable-for-CAT-preparation.png")));
		lblNewLabel_1.setBounds(0, 197, 614, 481);
		timetableMenuframe.getContentPane().add(lblNewLabel_1);
	}

	
}
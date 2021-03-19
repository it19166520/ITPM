package Member03;

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
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1366, 79);
		timetableMenuframe.getContentPane().add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.BLACK);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(txtrTimeTableManagement);
		
		JLabel lblNewLabel = new JLabel("The Timetable Of a Particular Lecturer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(322, 306, 273, 79);
		timetableMenuframe.getContentPane().add(lblNewLabel);
		
		JButton locationmng_1_1 = new JButton("View The Timetable");
		locationmng_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1.setForeground(Color.BLACK);
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setBounds(768, 319, 288, 52);
		timetableMenuframe.getContentPane().add(locationmng_1_1);
		
		JLabel lblTheTimetableOf = new JLabel("The Timetable Of a Particular Student Group");
		lblTheTimetableOf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheTimetableOf.setBounds(322, 403, 319, 79);
		timetableMenuframe.getContentPane().add(lblTheTimetableOf);
		
		JButton locationmng_1_1_1 = new JButton("View The Timetable");
		locationmng_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1_1.setForeground(Color.BLACK);
		locationmng_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1_1.setBounds(768, 416, 288, 52);
		timetableMenuframe.getContentPane().add(locationmng_1_1_1);
		
		JLabel lblTheTimetableOf_2 = new JLabel("The Timetable Of a Particular Room");
		lblTheTimetableOf_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheTimetableOf_2.setBounds(322, 510, 319, 79);
		timetableMenuframe.getContentPane().add(lblTheTimetableOf_2);
		
		JButton locationmng_1_1_1_1 = new JButton("View The Timetable");
		locationmng_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locationmng_1_1_1_1.setForeground(Color.BLACK);
		locationmng_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		locationmng_1_1_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1_1_1.setBounds(768, 537, 288, 52);
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
		locationmng_1_1_2.setBounds(527, 169, 312, 58);
		timetableMenuframe.getContentPane().add(locationmng_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 264, 825, 379);
		timetableMenuframe.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "View Timetable", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel_1);
	}

	
}

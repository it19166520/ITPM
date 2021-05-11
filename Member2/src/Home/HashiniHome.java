package Home;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Lecturer.AddManageLecturer;
import Subject.AddManageSubjects;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HashiniHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashiniHome window = new HashiniHome();
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
	public HashiniHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Lecturer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AddManageLecturer sub = new AddManageLecturer();
				sub.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setBounds(131, 164, 179, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Subjects");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				AddManageSubjects sub = new AddManageSubjects();
				sub.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(330, 164, 179, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sessions");
		btnNewButton_2.setBounds(208, 228, 194, 36);
		frame.getContentPane().add(btnNewButton_2);
	}

}
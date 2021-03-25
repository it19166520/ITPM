package Home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import locataion.Location;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShankiHome {

	private JFrame frame;
	private JPanel panelHeader;
	private JLabel txtrTimeTableManagement;
	private JButton btnLocatio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShankiHome window = new ShankiHome();
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
	public ShankiHome() {
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
	
	//header
		panelHeader = new JPanel();
		panelHeader.setForeground(Color.WHITE);
		panelHeader.setBackground(new Color(75, 119, 190));
		panelHeader.setBounds(0, 0, 1365, 75);
		frame.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		txtrTimeTableManagement = new JLabel("Time Table Management System");
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setBounds(401, 11, 510, 53);
		panelHeader.add(txtrTimeTableManagement); //end of header
		
		btnLocatio = new JButton("Location");
		btnLocatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Location = new Location();
				Location.show();
				
			}
		});
		btnLocatio.setForeground(Color.WHITE);
		btnLocatio.setFont(new Font("Segoe UI Semilight", Font.BOLD, 19));
		btnLocatio.setBackground(new Color(0, 0, 139));
		btnLocatio.setBounds(422, 251, 385, 46);
		frame.getContentPane().add(btnLocatio);
	}

}

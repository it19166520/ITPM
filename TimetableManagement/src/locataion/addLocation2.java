package locataion;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.SystemColor;
	import javax.swing.JSplitPane;
	import javax.swing.JDesktopPane;
	import javax.swing.JEditorPane;
	import javax.swing.JTextPane;
	import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import java.awt.CardLayout;
	import javax.swing.JTextField;
	import javax.swing.JSeparator;
	import java.awt.Font;
	import javax.swing.JRadioButton;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JList;
import javax.swing.ButtonGroup;

import DBConnection.DBConnection;

	public class addLocation2 {
		
		///connection DBConnection.dbConnector();

		JFrame frame;
		private JTextField textbuilding;
		private JTextField textroom;
		private JTextField textcapacity;
		protected Object model;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		String roomtype;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						addLocation2 window = new addLocation2();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public addLocation2() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setForeground(new Color(0, 0, 128));
			frame.getContentPane().setBackground(Color.WHITE);
			//frame.getContentPane().setBounds(0,0,1370,728);
			frame.getContentPane().setLayout(null);
			frame.setBounds(0,0,1370,728);
			
			
			
			JTextPane txtpnTimtableManagement = new JTextPane();
			txtpnTimtableManagement.setFont(new Font("Tahoma", Font.BOLD, 33));
			txtpnTimtableManagement.setText("Timtable Management");
			txtpnTimtableManagement.setBackground(Color.LIGHT_GRAY);
			txtpnTimtableManagement.setBounds(0, 0, 1354, 76);
			frame.getContentPane().add(txtpnTimtableManagement);
			
			JTextPane txtpnAddLocation = new JTextPane();
			txtpnAddLocation.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtpnAddLocation.setText("Add Location");
			txtpnAddLocation.setBounds(307, 118, 198, 32);
			frame.getContentPane().add(txtpnAddLocation);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(53, 139, 30, -75);
			frame.getContentPane().add(separator);
			
			JTextPane textPane_2 = new JTextPane();
			textPane_2.setBounds(113, 117, 7, 20);
			frame.getContentPane().add(textPane_2);
			
			JLabel lblNewLabel = new JLabel("Building Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(192, 182, 158, 40);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblRoomName = new JLabel("Room Name");
			lblRoomName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblRoomName.setBounds(192, 263, 158, 40);
			frame.getContentPane().add(lblRoomName);
			
			textbuilding = new JTextField();
			textbuilding.setBounds(349, 185, 479, 40);
			frame.getContentPane().add(textbuilding);
			textbuilding.setColumns(10);
			
			textroom = new JTextField();
			textroom.setColumns(10);
			textroom.setBounds(349, 254, 479, 40);
			frame.getContentPane().add(textroom);
			
			JLabel lblNewLabel_1 = new JLabel("Room Type");
			lblNewLabel_1.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent event) {
					
					
					
				}
				public void ancestorMoved(AncestorEvent event) {
				}
				public void ancestorRemoved(AncestorEvent event) {
				}
			});
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(192, 340, 135, 54);
			frame.getContentPane().add(lblNewLabel_1);
	
			
			JLabel lblNewLabel_1_1 = new JLabel("Capacity");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_1_1.setBounds(192, 456, 135, 54);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			textcapacity = new JTextField();
			textcapacity.setColumns(10);
			textcapacity.setBounds(349, 464, 479, 44);
			frame.getContentPane().add(textcapacity);
			
			JButton btnNewButton = new JButton("Clear");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(0, 0, 139));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
			btnNewButton.setBounds(785, 616, 115, 46);
			frame.getContentPane().add(btnNewButton);
			
			
			
			Object[] row=new Object[4];
			
			//ADD BUTTON
			JButton btnSave = new JButton("Add");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSave.setForeground(Color.WHITE);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*try {
						String 	query="insert into addLocation(Building Name,Room Name,Room Type,Capacity) value(?,?,?,?)";
						PreparedStatement pstst=Connection.prepareStatement(query);
						
						pstst.setString(1,textbuilding.getText());
						pstst.setString(2,textroom.getText());
						
						pstst.setString(3,roomtype);
						pstst.setString(4,textcapacity.getText());
						
						//data insertion success message;
						pstst.execute();
						JOptionPane.showMessageDialog(null,"Data Insertion sucessfully!...");
						
						
						
						pstst.close();
						ClearField();
						
					}catch(Exception e1){
						
						e1.printStackTrace();
						
						
					}*/
				
				
			}
			});
			btnSave.setBackground(new Color(0, 0, 128));
			btnSave.setBounds(1154, 616, 109, 46);
			frame.getContentPane().add(btnSave);
			
		
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Laboratories");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					roomtype="Laboratories";
				}
			});
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
			rdbtnNewRadioButton.setBackground(new Color(0, 0, 128));
			rdbtnNewRadioButton.setBounds(574, 350, 158, 41);
			frame.getContentPane().add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Lectures");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 roomtype = "Lecture";
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
			rdbtnNewRadioButton_1.setBackground(new Color(0, 0, 128));
			rdbtnNewRadioButton_1.setBounds(349, 350, 135, 40);
			frame.getContentPane().add(rdbtnNewRadioButton_1);
		}


		protected void ClearField() {
			// TODO Auto-generated method stub
			
		}
	}
		
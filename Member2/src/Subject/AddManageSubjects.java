package Subject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class AddManageSubjects extends JFrame {

	private JPanel contentPane;
	private JPanel ManageSubPanel;
	private JPanel AddSubPanel;
	private JLayeredPane SublayeredPane;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtSubName;
	private JTextField txtSubCode;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnLoadTable;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageSubjects frame = new AddManageSubjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanel(JPanel panel) {
		
		SublayeredPane.removeAll();
		SublayeredPane.add(panel);
		SublayeredPane.repaint();
		SublayeredPane.revalidate();
	}
	
	//Connection connection=null;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtSubID;
	private JTextField txtSubName2;
	private JTextField txtSubCode2;
	private JLabel lblNewLabel_18;
	private JComboBox SubjectComboBox;
	private JComboBox txtSubOffYear;
	private JComboBox txtSubOffSem;
	
	
	
	//Connection connection=null;
	Connection conn = SqlServerConnection.dbConnecter();
	private JComboBox NumOfLecHours;
	private JComboBox NumOfEvaltionHours;
	private JComboBox NumOfTuteHours;
	private JComboBox NumOfLabHours;
	private JComboBox txtSubOffYear2;
	private JComboBox txtSubOffSem2;
	private JComboBox txtNumOfLecH2;
	private JComboBox txtNumOfTuteH2;
	private JComboBox txtNumOfLabH2;
	private JComboBox txtNumOfEvaH2;
	private JPanel panel_1;
	private JButton btnNewButton_6;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblOfferedYear;
	private JLabel lblOfferedSem;
	private JLabel lblSubjectName;
	private JLabel lblSublectCode;
	private JLabel lblNumOfLecHours;
	private JLabel lblNumOfTuteHours;
	private JLabel lblNumOfLabHours;
	private JLabel lblNumOfEvaltionHours;
	private JPanel panel_7;
	private JLabel lblNewLabel_34;
	private JButton btnNewButton;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_8;
	private JPanel panel_9;
	private JTextField textField;
	
	
	public void refreshSubjectTable()
	{
		try {
			
			String query="select * from subjects";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void fillSubjectCobmoBox() {
		

		try {
			
			String query="select * from subjects";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				SubjectComboBox.addItem(rs.getString("SubjectName"));
			}
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public AddManageSubjects() {
		
		Connection conn = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1600,825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] offeredyear = {"1", "2", "3", "4"};
		String[] semester=  {"1", "2"};
		String[] noOflchrs = {"1", "2", "3", "4", "5"};
		
		SublayeredPane = new JLayeredPane();
		SublayeredPane.setBounds(22, 145, 1467, 621);
		contentPane.add(SublayeredPane);
		SublayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSubPanel = new JPanel();
		AddSubPanel.setBackground(new Color(255, 255, 255));
		SublayeredPane.add(AddSubPanel, "name_127330680826200");
		AddSubPanel.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_5.setBackground(new Color(228, 241, 254));
		panel_5.setBounds(161, 30, 1172, 557);
		AddSubPanel.add(panel_5);
		panel_5.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(142, 23, 907, 510);
		panel_5.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Subect Details :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Offered Semester  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(127, 85, 163, 24);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Subject Name  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(127, 130, 163, 26);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Subject Code  :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(127, 176, 163, 28);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Number Of Lecturer Hours  :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(127, 233, 244, 17);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Number Of Tutorial Hours  :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(127, 283, 244, 17);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Number of Lab Hours  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(127, 328, 163, 28);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Number of Evalution hours  :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(127, 379, 252, 27);
		panel_1.add(lblNewLabel_8);
		
		
		txtSubOffYear = new JComboBox(offeredyear);
		txtSubOffYear.setSelectedIndex(-1);
		txtSubOffYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				//To release the label after filling the field:
				lblOfferedYear.setText("");
				
			}
		});
		txtSubOffYear.setBackground(Color.WHITE);
		txtSubOffYear.setBounds(394, 44, 350, 21);
		panel_1.add(txtSubOffYear);
		
			
			
			txtSubOffSem = new JComboBox(semester);
			txtSubOffSem.setBackground(Color.WHITE);
			txtSubOffSem.setSelectedIndex(-1);
			txtSubOffSem.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					lblOfferedSem.setText("");
				}
			});
			txtSubOffSem.setBounds(394, 88, 350, 21);
			panel_1.add(txtSubOffSem);
			
			txtSubName = new JTextField();
			txtSubName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					//To release the label after filling the field:
					lblSubjectName.setText("");
				}
			});
			txtSubName.setBounds(394, 133, 350, 24);
			panel_1.add(txtSubName);
			txtSubName.setColumns(10);
			
			txtSubCode = new JTextField();
			txtSubCode.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					//To release the label after filling the field:
					lblSublectCode.setText("");
				}
			});
			txtSubCode.setBounds(394, 180, 350, 24);
			panel_1.add(txtSubCode);
			txtSubCode.setColumns(10);
			
			NumOfLecHours = new JComboBox(noOflchrs);
			NumOfLecHours.setBackground(Color.WHITE);
			NumOfLecHours.setSelectedIndex(-1);
			NumOfLecHours.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					//To release the label after filling the field:
					lblNumOfLecHours.setText("");
					
				}
			});
			NumOfLecHours.setBounds(394, 232, 350, 21);
			panel_1.add(NumOfLecHours);
			
			
			NumOfTuteHours = new JComboBox(noOflchrs);
			NumOfTuteHours.setBackground(Color.WHITE);
			NumOfTuteHours.setSelectedIndex(-1);
			NumOfTuteHours.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					//To release the label after filling the field:
					lblNumOfTuteHours.setText("");
				}
			});
			NumOfTuteHours.setBounds(394, 282, 350, 21);
			panel_1.add(NumOfTuteHours);
			
			
			NumOfLabHours = new JComboBox(noOflchrs);
			NumOfLabHours.setBackground(Color.WHITE);
			NumOfLabHours.setSelectedIndex(-1);
			NumOfLabHours.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					//To release the label after filling the field:
					lblNumOfLabHours.setText("");
				}
			});
			NumOfLabHours.setBounds(394, 333, 350, 21);
			panel_1.add(NumOfLabHours);
			
					
					NumOfEvaltionHours = new JComboBox(noOflchrs);
					NumOfEvaltionHours.setBackground(Color.WHITE);
					NumOfEvaltionHours.setSelectedIndex(-1);
					NumOfEvaltionHours.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							
							//To release the label after filling the field:
							lblNumOfEvaltionHours.setText("");
							
						}
					});
					NumOfEvaltionHours.setBounds(394, 383, 350, 21);
					panel_1.add(NumOfEvaltionHours);
					
						
						btnNewButton_2 = new JButton("SAVE");
						btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
						btnNewButton_2.setBounds(127, 446, 291, 41);
						panel_1.add(btnNewButton_2);
						btnNewButton_2.setForeground(Color.WHITE);
						btnNewButton_2.setBackground(new Color(27, 163, 156));
						
						btnNewButton_3 = new JButton("CLEAR");
						btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
						btnNewButton_3.setForeground(Color.WHITE);
						btnNewButton_3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								txtSubOffYear.setSelectedIndex(-1);
								txtSubOffSem.setSelectedIndex(-1);
								txtSubName.setText("  ");
								txtSubCode.setText("  ");
								NumOfLecHours.setSelectedIndex(-1);
								NumOfTuteHours.setSelectedIndex(-1);
								NumOfLabHours.setSelectedIndex(-1);
								NumOfEvaltionHours.setSelectedIndex(-1);
								
								
								
							}
						});
						btnNewButton_3.setBounds(465, 446, 279, 41);
						panel_1.add(btnNewButton_3);
						btnNewButton_3.setBackground(new Color(58, 83, 155));
						
						lblOfferedYear = new JLabel("");
						lblOfferedYear.setForeground(Color.RED);
						lblOfferedYear.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblOfferedYear.setBounds(551, 89, 79, 13);
						panel_1.add(lblOfferedYear);
						
						lblOfferedSem = new JLabel("");
						lblOfferedSem.setForeground(Color.RED);
						lblOfferedSem.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblOfferedSem.setBounds(551, 125, 79, 13);
						panel_1.add(lblOfferedSem);
						
						lblSubjectName = new JLabel("");
						lblSubjectName.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblSubjectName.setForeground(Color.RED);
						lblSubjectName.setBounds(551, 159, 79, 13);
						panel_1.add(lblSubjectName);
						
						lblSublectCode = new JLabel("");
						lblSublectCode.setForeground(Color.RED);
						lblSublectCode.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblSublectCode.setBounds(551, 195, 79, 13);
						panel_1.add(lblSublectCode);
						
						lblNumOfLecHours = new JLabel("");
						lblNumOfLecHours.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblNumOfLecHours.setForeground(Color.RED);
						lblNumOfLecHours.setBounds(551, 233, 79, 13);
						panel_1.add(lblNumOfLecHours);
						
						lblNumOfTuteHours = new JLabel("");
						lblNumOfTuteHours.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblNumOfTuteHours.setForeground(Color.RED);
						lblNumOfTuteHours.setBounds(551, 272, 79, 13);
						panel_1.add(lblNumOfTuteHours);
						
						lblNumOfLabHours = new JLabel("");
						lblNumOfLabHours.setForeground(Color.RED);
						lblNumOfLabHours.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblNumOfLabHours.setBounds(551, 306, 79, 13);
						panel_1.add(lblNumOfLabHours);
						
						lblNumOfEvaltionHours = new JLabel("");
						lblNumOfEvaltionHours.setForeground(Color.RED);
						lblNumOfEvaltionHours.setFont(new Font("Tahoma", Font.BOLD, 10));
						lblNumOfEvaltionHours.setBounds(551, 346, 79, 13);
						panel_1.add(lblNumOfEvaltionHours);
						
						panel_8 = new JPanel();
						panel_8.setBorder(new LineBorder(new Color(176, 224, 230)));
						panel_8.setBackground(new Color(255, 255, 255));
						panel_8.setBounds(51, 24, 799, 404);
						panel_1.add(panel_8);
						panel_8.setLayout(null);
						
						//create form to get subject details from user :
						lblNewLabel = new JLabel("Offered Year  :");
						lblNewLabel.setBounds(75, 20, 241, 30);
						panel_8.add(lblNewLabel);
						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
						
						textField = new JTextField();
						textField.setBounds(703, 20, 96, 19);
						panel_8.add(textField);
						textField.setColumns(10);
						
						panel_9 = new JPanel();
						panel_9.setBackground(new Color(255, 255, 255));
						panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						panel_9.setBounds(105, 10, 1284, 601);
						AddSubPanel.add(panel_9);
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								//To check weather the feilds are required or not:
								
								if(((String) txtSubOffYear.getSelectedItem()).trim().isEmpty() && ((String) txtSubOffSem.getSelectedItem()).trim().isEmpty() && txtSubName.getText().trim().isEmpty() && txtSubCode.getText().trim().isEmpty() && ((String) NumOfLecHours.getSelectedItem()).trim().isEmpty() && ((String) NumOfTuteHours.getSelectedItem()).trim().isEmpty() && ((String) NumOfLabHours.getSelectedItem()).trim().isEmpty() && ((String)NumOfEvaltionHours.getSelectedItem()).trim().isEmpty())
								{
									
									lblOfferedYear.setText("*required");
									lblOfferedSem.setText("*required");
									lblSubjectName.setText("*required");
									lblSublectCode.setText("*required");
									lblNumOfLecHours.setText("*required");
									lblNumOfTuteHours.setText("*required");
									lblNumOfLabHours.setText("*required");
									lblNumOfEvaltionHours.setText("*required");
								}
								else if(((String) txtSubOffYear.getSelectedItem()).trim().isEmpty())
								{
									lblOfferedYear.setText("*required");
								}
								else if(((String) txtSubOffSem.getSelectedItem()).trim().isEmpty()) {
									
									lblOfferedSem.setText("*required");
								}
								else if(txtSubName.getText().trim().isEmpty()) {
									
									lblSubjectName.setText("*required");
								}
								else if(txtSubCode.getText().trim().isEmpty())
								{
									lblSublectCode.setText("*required");
								}
								else if(((String) NumOfLecHours.getSelectedItem()).trim().isEmpty())
								{
									lblNumOfLecHours.setText("*required");
								}
								else if(((String) NumOfTuteHours.getSelectedItem()).trim().isEmpty()) 
								{
									lblNumOfTuteHours.setText("*required");
								}
								else if(((String) NumOfLabHours.getSelectedItem()).trim().isEmpty()) {
									
									lblNumOfLabHours.setText("*required");
								}
								else if(((String)NumOfEvaltionHours.getSelectedItem()).trim().isEmpty()) {
									
									lblNumOfEvaltionHours.setText("*required");
								}
								else
								  //Get Subject Details from the user and store the details in the database:
								
								 try {
										
										String query="insert into subjects (OfferedYear,OfferedSem,SubjectName,SublectCode,NumOfLecHours,NumOfTuteHours,NumOfLabHours,NumOfEvaltionHours) values (?,?,?,?,?,?,?,?)";                      
										PreparedStatement pst=conn.prepareStatement(query);
										
										//get year details from the user by using  JComboBox :
										String OffYear=txtSubOffYear.getSelectedItem().toString();
										pst.setString(1, OffYear);
										
										//get semester details from user by using JComboBox:
										String OffSem=txtSubOffSem.getSelectedItem().toString();
										pst.setString(2, OffSem);
										
										//get Subject name and subject code from text fields:
										pst.setString(3, txtSubName.getText());
										pst.setString(4, txtSubCode.getText());
										
										//get Number of lecturer hours from user by using JComboBox:
										String LecHours=NumOfLecHours.getSelectedItem().toString();
										pst.setString(5, LecHours);
										
										//get Number of Tutorial hours from user by using JComboBox:
										String TuteHours=NumOfTuteHours.getSelectedItem().toString();
										pst.setString(6, TuteHours);
										
										//get Number of lab hours from user by using JComboBox:
										String LabHours=NumOfLabHours.getSelectedItem().toString();
										pst.setString(7, LabHours);
										
										//get Number of Evalution Hours from by using JComboBox:
										String EvaHours=NumOfEvaltionHours.getSelectedItem().toString();
										pst.setString(8, EvaHours);
										
										
										//Display successful massage when data was inserted to the database successfully:
										pst.execute();
										JOptionPane.showMessageDialog(null, "Data inserted successfully!");
										
										pst.close();
										
										
									}catch(Exception e1)
									{
										e1.printStackTrace();
									}
								
								//call "refreshSubjectTable" method to refresh the table after doing any changes:
								 refreshSubjectTable();
								 
							}
						});
		
		ManageSubPanel = new JPanel();
		ManageSubPanel.setBackground(new Color(255, 255, 255));
		SublayeredPane.add(ManageSubPanel, "name_127354460414000");
		ManageSubPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(586, 99, 691, 346);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		ManageSubPanel.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(18);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//To pass the relevant details to the form after selecting the raw of the table:
				  try {
						int row = table.getSelectedRow();
						String ID_=(table.getModel().getValueAt(row, 0)).toString();
						
					   
						String query="select * from subjects where ID='"+ID_+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
					
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							txtSubID.setText(rs.getString("ID"));
							txtSubOffYear2.setSelectedItem(rs.getString("OfferedYear"));
							txtSubOffSem2.setSelectedItem(rs.getString("OfferedSem"));
							txtSubName2.setText(rs.getString("SubjectName"));
							txtSubCode2.setText(rs.getString("SublectCode"));
							txtNumOfLecH2.setSelectedItem(rs.getString("NumOfLecHours"));
							txtNumOfTuteH2.setSelectedItem(rs.getString("NumOfTuteHours"));
							txtNumOfLabH2.setSelectedItem(rs.getString("NumOfLabHours"));
							txtNumOfEvaH2.setSelectedItem(rs.getString("NumOfEvaltionHours"));
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
			}
		});
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBounds(29, 10, 495, 489);
		panel_2.setBackground(new Color(228,241,254));
		panel_2.setBorder(null);
		ManageSubPanel.add(panel_2);
		panel_2.setLayout(null);
		
		txtSubID = new JTextField();
		txtSubID.setBounds(207, 70, 252, 19);
		panel_2.add(txtSubID);
		txtSubID.setColumns(10);
		
		txtSubOffYear2 = new JComboBox(offeredyear);
		txtSubOffYear2.setBackground(Color.WHITE);
		txtSubOffYear2.setBounds(207, 99, 252, 21);
		panel_2.add(txtSubOffYear2);
		txtSubOffYear2.setSelectedIndex(-1);
		
		txtSubOffSem2 = new JComboBox(semester);
		txtSubOffSem2.setBackground(Color.WHITE);
		txtSubOffSem2.setBounds(207, 143, 252, 21);
		panel_2.add(txtSubOffSem2);
		txtSubOffSem2.setSelectedIndex(-1);
		
		lblNewLabel_1 = new JLabel("ID  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 72, 65, 13);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_10 = new JLabel("Offered Year  :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(10, 102, 106, 13);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Offered Semester  :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(10, 146, 130, 13);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name  :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(10, 187, 106, 13);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Subject Code  :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(10, 222, 106, 13);
		panel_2.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Number Of Lecture Hours  :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_14.setBounds(10, 270, 187, 13);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setBounds(10, 319, 187, 13);
		panel_2.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Number Of Lab Hours  :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_16.setBounds(10, 370, 151, 13);
		panel_2.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Number Of Evalution Hours :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_17.setBounds(10, 433, 198, 18);
		panel_2.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("ManageDetails  ");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_18.setBounds(183, 27, 163, 19);
		panel_2.add(lblNewLabel_18);
		
		txtSubName2 = new JTextField();
		txtSubName2.setBounds(207, 184, 252, 21);
		panel_2.add(txtSubName2);
		txtSubName2.setColumns(10);
		
		txtSubCode2 = new JTextField();
		txtSubCode2.setBounds(207, 216, 252, 26);
		panel_2.add(txtSubCode2);
		txtSubCode2.setColumns(10);
		
		txtNumOfLecH2 = new JComboBox(noOflchrs);
		txtNumOfLecH2.setBackground(Color.WHITE);
		txtNumOfLecH2.setBounds(207, 267, 252, 21);
		panel_2.add(txtNumOfLecH2);
		txtNumOfLecH2.setSelectedIndex(-1);
		
		txtNumOfTuteH2 = new JComboBox(noOflchrs);
		txtNumOfTuteH2.setBackground(Color.WHITE);
		txtNumOfTuteH2.setBounds(207, 316, 252, 21);
		txtNumOfTuteH2.setSelectedIndex(-1);
		panel_2.add(txtNumOfTuteH2);
		
		
		txtNumOfLabH2 = new JComboBox(noOflchrs);
		txtNumOfLabH2.setBackground(Color.WHITE);
		txtNumOfLabH2.setBounds(207, 367, 252, 21);
		txtNumOfLabH2.setSelectedIndex(-1);
		panel_2.add(txtNumOfLabH2);
		
		
		txtNumOfEvaH2 = new JComboBox(noOflchrs);
		txtNumOfEvaH2.setBackground(Color.WHITE);
		txtNumOfEvaH2.setBounds(208, 430, 251, 21);
		txtNumOfEvaH2.setSelectedIndex(-1);
		panel_2.add(txtNumOfEvaH2);
		
		
		panel_3 = new JPanel();
		panel_3.setBounds(556, 10, 750, 489);
		panel_3.setBackground(new Color(228, 241, 254));
		panel_3.setBorder(null);
		ManageSubPanel.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		
		
		SubjectComboBox = new JComboBox();
		SubjectComboBox.setBounds(26, 23, 233, 21);
		panel_3.add(SubjectComboBox);
		
		JLabel lblNewLabel_19 = new JLabel("Select Your Name In Here :");
		lblNewLabel_19.setBounds(26, 10, 163, 13);
		panel_3.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnLoadTable = new JButton("Load Details");
		btnLoadTable.setForeground(Color.WHITE);
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoadTable.setBackground(new Color(27,163,156));
		btnLoadTable.setBounds(565, 23, 153, 29);
		panel_3.add(btnLoadTable);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(26, 59, 700, 353);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 1323, 577);
		panel_4.setBorder(null);
		panel_4.setBackground(Color.WHITE);
		ManageSubPanel.add(panel_4);
		panel_4.setLayout(null);
		
		btnNewButton_6 = new JButton("Clear All ");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				txtSubID.setText("  ");
				txtSubOffYear2.setSelectedIndex(-1);
				txtSubOffSem2.setSelectedIndex(-1);
				txtSubName2.setText("  ");
				txtSubCode2.setText("  ");
				txtNumOfLecH2.setSelectedIndex(-1);
				txtNumOfTuteH2.setSelectedIndex(-1);
				txtNumOfLabH2.setSelectedIndex(-1);
				txtNumOfEvaH2.setSelectedIndex(-1);
				
				
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBackground(new Color(58, 83, 155));
		btnNewButton_6.setBounds(211, 525, 176, 42);
		panel_4.add(btnNewButton_6);
		
		btnNewButton_4 = new JButton("Update Details");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(529, 524, 191, 44);
		panel_4.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(27, 163, 156));
		
		btnNewButton_5 = new JButton("Delete Details");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(880, 523, 205, 44);
		panel_4.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBackground(new Color(210, 77, 87));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Delete
				try {
					
					String query="delete from subjects where ID='"+txtSubID.getText()+"'";                      
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			
				//To refresh the table after deleting details :
				refreshSubjectTable();	
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update details :

				  try {
						
						String query="update subjects set  OfferedYear='"+txtSubOffYear2.getSelectedItem()+"' , OfferedSem='"+txtSubOffSem2.getSelectedItem()+"' ,SubjectName='"+txtSubName2.getText()+"' ,SublectCode='"+txtSubCode2.getText()+"', NumOfLecHours='"+txtNumOfLecH2.getSelectedItem()+"',  NumOfTuteHours='"+txtNumOfTuteH2.getSelectedItem()+"' , NumOfLabHours='"+txtNumOfLabH2.getSelectedItem()+"' , NumOfEvaltionHours='"+txtNumOfEvaH2.getSelectedItem()+"' where ID='"+txtSubID.getText()+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Details Updated Sucsessfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				  
				//To refresh the table after updating details :
				  refreshSubjectTable();
				
			}
		});
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//To refresh the table after doing any changes:
				try {
					
						String query="select * from subjects";
						PreparedStatement pst=conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
			}
		});
		SubjectComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//To get the details to the form  according to the Subject name which user selected from the comboBox :
	                try {
						
						String query="select * from subjects where SubjectName=?";                      
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1, (String)SubjectComboBox.getSelectedItem());
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							txtSubID.setText(rs.getString("ID"));
							txtSubOffYear2.setSelectedItem(rs.getString("OfferedYear"));
							txtSubOffSem2.setSelectedItem(rs.getString("OfferedSem"));
							txtSubName2.setText(rs.getString("SubjectName"));
							txtSubCode2.setText(rs.getString("SublectCode"));
							txtNumOfLecH2.setSelectedItem(rs.getString("NumOfLecHours"));
							txtNumOfTuteH2.setSelectedItem(rs.getString("NumOfTuteHours"));
							txtNumOfLabH2.setSelectedItem(rs.getString("NumOfLabHours"));
							txtNumOfEvaH2.setSelectedItem(rs.getString("NumOfEvaltionHours"));
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
			}
		});
		
		btnNewButton = new JButton("Add Subjects");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(58, 83, 155));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(AddSubPanel);
				
			}
		});
		btnNewButton.setBounds(124, 95, 207, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View All & Manage");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(58, 83, 155));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(ManageSubPanel);
			}
		});
		btnNewButton_1.setBounds(382, 95, 207, 44);
		contentPane.add(btnNewButton_1);
		
		//Header :
		panel_7 = new JPanel();
		panel_7.setForeground(Color.WHITE);
		panel_7.setBackground(new Color(75, 119, 190));
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel_7.setBounds(10, 10, 1520, 75);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_34 = new JLabel("Timetable Management System");
		lblNewLabel_34.setForeground(Color.WHITE);
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_34.setBounds(516, 21, 660, 44);
		panel_7.add(lblNewLabel_34);
		refreshSubjectTable();
		fillSubjectCobmoBox();
		
		
	}
}

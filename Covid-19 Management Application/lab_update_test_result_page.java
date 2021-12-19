import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class lab_update_test_result_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField result_tf;
	private JTextField phno_tf;
	private JPasswordField passwordField;
	private static JTable testingtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_update_test_result_page frame = new lab_update_test_result_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lab_update_test_result_page() {
		
		String labid = lab_login_page.labid(); 

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Covid-19 Management Application");
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_loggedin_page llip = new lab_loggedin_page();
				llip.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Update Test Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setBounds(227, 11, 338, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Enter Phone Number:");
		lblNewLabel1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel1.setBounds(63, 143, 186, 19);
		contentPane.add(lblNewLabel1);
		
		phno_tf = new JTextField();
		phno_tf.setColumns(10);
		phno_tf.setBounds(63, 162, 186, 19);
		contentPane.add(phno_tf);
		
		JLabel lblNewLabel2 = new JLabel("Enter Result:");
		lblNewLabel2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel2.setBounds(63, 215, 145, 13);
		contentPane.add(lblNewLabel2);
	
		result_tf = new JTextField();
		result_tf.setColumns(10);
		result_tf.setBounds(63, 230, 186, 19);
		contentPane.add(result_tf);
		
		JButton updateTestResultUpdate_btn = new JButton("Update");
		updateTestResultUpdate_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						if(!(phno_tf.getText().equals("") || result_tf.getText().equals(""))){
							Class.forName("com.mysql.cj.jdbc.Driver");
						    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
						    PreparedStatement ps = conn.prepareStatement("update covid19_management_application.testing set result =?, labid =? where phno = ?;");
						    ps.setString(1, result_tf.getText());
						    ps.setString(2, labid);
						    ps.setString(3, phno_tf.getText());				
							ps.executeUpdate();		
							JOptionPane.showMessageDialog(null,"Result updated successfully");
						}
						else {
							JOptionPane.showMessageDialog(null,"Please enter all the fields.");
						}
					}
					catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null,"1) Duplicate entry or all the fields have not been entered.");
					}	
			}
		});
		updateTestResultUpdate_btn.setForeground(SystemColor.info);
		updateTestResultUpdate_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		updateTestResultUpdate_btn.setBackground(Color.BLACK);
		updateTestResultUpdate_btn.setBounds(63, 323, 186, 65);
		contentPane.add(updateTestResultUpdate_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 135, 500, 329);
		contentPane.add(scrollPane);
		
		testingtable = new JTable();
		scrollPane.setViewportView(testingtable);
		testingtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Phone No.", "Name", "Lab Area", "Result"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Pending Results:");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabel_1.setBounds(325, 110, 131, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Fetch pending results");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
				    String query = "SELECT phno,name,labarea,result FROM covid19_management_application.testing where result = 'tbd'";
				    PreparedStatement ps = conn.prepareStatement(query);
				    ResultSet rs = ps.executeQuery();
				    testingtable.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null,"Duplicate entry or all the fields have not been entered.");
				}
			}
		});
		btnNewButton_1.setForeground(SystemColor.info);
		btnNewButton_1.setBounds(470, 474, 222, 66);
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);
		contentPane.add(btnNewButton_1);
	}
}






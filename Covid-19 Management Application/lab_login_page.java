import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;

public class lab_login_page extends JFrame {

	private JPanel contentPane;
	private static JTextField labID_tf;
	private JPasswordField labPassword_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_login_page frame = new lab_login_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// method to send labid to other pages
	public static String labid(){
		String labid = labID_tf.getText();
		return labid;
	}
	/**
	 * Create the frame.
	 */	
	public lab_login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Covid-19 Management Application");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Covid19_management_application_main_page cmamp = new Covid19_management_application_main_page();
				cmamp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Lab Login Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 10, 566, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Enter lab ID:");
		lblNewLabel1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel1.setBounds(207, 130, 186, 19);
		contentPane.add(lblNewLabel1);
		
		labID_tf = new JTextField();
		labID_tf.setColumns(10);
		labID_tf.setBounds(207, 149, 186, 19);
		contentPane.add(labID_tf);
		
		JLabel lblNewLabel2 = new JLabel("Enter Password:");
		lblNewLabel2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel2.setBounds(207, 194, 145, 13);
		contentPane.add(lblNewLabel2);
		
		labPassword_tf = new JPasswordField();
		labPassword_tf.setBounds(207, 210, 186, 19);
		contentPane.add(labPassword_tf);
		
		JButton labPageLogin_btn = new JButton("Login");
		labPageLogin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(labID_tf.getText().equals("") && new String(labPassword_tf.getPassword()).equals(""))){
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
							PreparedStatement ps = conn.prepareStatement("select * from covid19_management_application.lablogin where labID =? and labpassword=?;");
							ps.setString(1, labID_tf.getText());
							ps.setString(2, new String(labPassword_tf.getPassword()));
							ResultSet rs = ps.executeQuery();
							if(rs.next()) {
								JOptionPane.showMessageDialog(null,"Login Successful!");
								lab_loggedin_page tlp = new lab_loggedin_page();
								tlp.setVisible(true);	
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null,"Login Unsuccessful, Please enter valid credentials to login!!");
							}
					} else {
						JOptionPane.showMessageDialog(null,"Please enter all the fields.");
					}
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Please enter all the fields.");
				}				
			}
		});
		labPageLogin_btn.setForeground(SystemColor.info);
		labPageLogin_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		labPageLogin_btn.setBackground(Color.BLACK);
		labPageLogin_btn.setBounds(207, 291, 186, 65);
		contentPane.add(labPageLogin_btn);
		

	}
}




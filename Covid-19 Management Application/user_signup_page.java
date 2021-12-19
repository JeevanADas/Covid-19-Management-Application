import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

public class user_signup_page extends JFrame {

	private JPanel contentPane;
	private JTextField phno_tf;
	private JPasswordField password_tf;
	private JTextField name_tf;
	private JTextField age_tf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_signup_page frame = new user_signup_page();
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
	
	public user_signup_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Covid-19 Management Application");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton1 = new JButton("<-");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_login_page ulp = new user_login_page();
				ulp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton1.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton1);
		
		JLabel lblNewLabel = new JLabel("User SignUp Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 10, 566, 66);
		contentPane.add(lblNewLabel);		
		
		JLabel lblNewLabel1 = new JLabel("Enter Phone Number:");
		lblNewLabel1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel1.setBounds(207, 140, 186, 19);
		contentPane.add(lblNewLabel1);
		
		phno_tf = new JTextField();
		phno_tf.setColumns(10);
		phno_tf.setBounds(207, 159, 186, 19);
		contentPane.add(phno_tf);
		
		JLabel lblNewLabel2 = new JLabel("Enter Name:");
		lblNewLabel2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel2.setBounds(207, 204, 145, 13);
		contentPane.add(lblNewLabel2);
		
		name_tf = new JTextField();
		name_tf.setColumns(10);
		name_tf.setBounds(207, 219, 186, 19);
		contentPane.add(name_tf);
		
		JLabel lblNewLabel3 = new JLabel("Enter Password:");
		lblNewLabel3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel3.setBounds(207, 329, 145, 13);
		contentPane.add(lblNewLabel3);
		
		password_tf = new JPasswordField();
		password_tf.setBounds(207, 345, 186, 19);
		contentPane.add(password_tf);
		// String pwd = new String(userSignupPagePassword_tf.getPassword());
		
		JLabel lblNewLabel4 = new JLabel("Enter Age:");
		lblNewLabel4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel4.setBounds(207, 265, 186, 19);
		contentPane.add(lblNewLabel4);
		
		age_tf = new JTextField();
		age_tf.setColumns(10);
		age_tf.setBounds(207, 282, 186, 19);
		contentPane.add(age_tf);
		
		JButton userSignupPageSignup_btn = new JButton("SignUp");
		userSignupPageSignup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(phno_tf.getText().equals("") && name_tf.getText().equals("") && age_tf.getText().equals("") && new String(password_tf.getPassword()).equals(null))){
						String phno = phno_tf.getText();
						if(phno.length()!=10)
							JOptionPane.showMessageDialog(null,"Invalid Phone number");
						int ageint;
						ageint = Integer.parseInt(age_tf.getText());
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
						if(ageint >= 18) {
							PreparedStatement ps = conn.prepareStatement("insert into covid19_management_application.signup(phno,name,age,password) values (?,?,?,?);");
							ps.setString(1, phno_tf.getText());
							ps.setString(2, name_tf.getText());
							ps.setString(3, age_tf.getText());
							ps.setString(4, new String(password_tf.getPassword()));
							int x = ps.executeUpdate();
							if(x>0) {
								JOptionPane.showMessageDialog(null,"SignUp sucessfull!!");
								user_login_page ulp = new user_login_page();
								ulp.setVisible(true);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null,"SignUp unsucessfull!!");
							}
						} else {
							JOptionPane.showMessageDialog(null,"SignUp requires age to be above 18.");
						}
					} else {
						JOptionPane.showMessageDialog(null,"Please enter all the fields.");
					}
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Duplicate entry or all the fields have not been entered.");
				}
			}
		});
		userSignupPageSignup_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		userSignupPageSignup_btn.setForeground(SystemColor.info);
		userSignupPageSignup_btn.setBackground(new Color(0, 0, 0));
		userSignupPageSignup_btn.setBounds(207, 403, 186, 65);
		contentPane.add(userSignupPageSignup_btn);
		
		
	}
}





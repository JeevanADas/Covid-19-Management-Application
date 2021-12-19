import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class user_login_page extends JFrame {

	private JPanel contentPane;
	public static JTextField phno_tf;
	private JPasswordField password_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_login_page frame = new user_login_page();
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
	public user_login_page() {
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
		
		JLabel lblNewLabel = new JLabel("User Login Page");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 566, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Enter Phone Number:");
		lblNewLabel1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel1.setBounds(207, 130, 186, 19);
		contentPane.add(lblNewLabel1);
		
		phno_tf = new JTextField();
		phno_tf.setBounds(207, 149, 186, 19);
		contentPane.add(phno_tf);
		phno_tf.setColumns(10);
		
		JLabel lblNewLabel2 = new JLabel("Enter Password:");
		lblNewLabel2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel2.setBounds(207, 194, 145, 13);
		contentPane.add(lblNewLabel2);
		
		password_tf = new JPasswordField();
		password_tf.setBounds(207, 210, 186, 19);
		contentPane.add(password_tf);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(phno_tf.getText().equals("") && new String(password_tf.getPassword()).equals(""))){
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
							PreparedStatement ps = conn.prepareStatement("select * from covid19_management_application.signup where phno =? and password=?;");
							ps.setString(1, phno_tf.getText());
							ps.setString(2, new String(password_tf.getPassword()));
							ResultSet rs = ps.executeQuery();
							if(rs.next()) {
								JOptionPane.showMessageDialog(null,"Login Successful!");
								user_loggedin_page ulp = new user_loggedin_page();
								ulp.setVisible(true);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null,"Login unsuccessful, Please enter valid credentials to login!!");
							}
					} else {
						JOptionPane.showMessageDialog(null,"Please enter all the fields.");
					}
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Please enter all the fields.");
				}
			}
		});
		loginbtn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		loginbtn.setForeground(SystemColor.info);
		loginbtn.setBackground(new Color(0, 0, 0));
		loginbtn.setBounds(207, 291, 186, 65);
		contentPane.add(loginbtn);
		
		JLabel lblNewLabel_1 = new JLabel("Do not have an account?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(207, 366, 186, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton clickhere_btn = new JButton("Click here");
		clickhere_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_signup_page usp = new user_signup_page();
				usp.setVisible(true);
				setVisible(false);
			}
		});
		clickhere_btn.setFont(new Font("Arial Narrow", Font.BOLD, 10));
		clickhere_btn.setForeground(SystemColor.info);
		clickhere_btn.setBackground(new Color(0, 0, 0));
		clickhere_btn.setBounds(253, 382, 95, 21);
		contentPane.add(clickhere_btn);
		
	}
	public static String phno(){
		String phno = phno_tf.getText();
		return phno;
	}
}



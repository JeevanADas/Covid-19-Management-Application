import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testing_change_appointment_page extends JFrame {

	private JPanel contentPane;
	private JTextField phno_tf;
	private JTextField currentdate_tf;
	private JTextField newdate_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing_change_appointment_page frame = new testing_change_appointment_page();
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
	public testing_change_appointment_page() {
		
		String phno = user_login_page.phno();
		
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
				user_loggedin_page ulp = new user_loggedin_page();
				ulp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton1.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton1);
		
		JLabel lblNewLabel = new JLabel("Change Appointment");
		lblNewLabel.setBounds(10, 11, 566, 66);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("Phone Number:");
		lblNewLabel2.setBounds(37, 127, 186, 19);
		lblNewLabel2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		contentPane.add(lblNewLabel2);
		
		phno_tf = new JTextField(phno);
		phno_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
			    {
				  String phoneno = phno_tf.getText();
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
			      PreparedStatement ps = conn.prepareStatement("SELECT * FROM covid19_management_application.testing where phno =?;");
			      ps.setString(1, phoneno);
			      ResultSet rs = ps.executeQuery();
			      if (rs.next()==true)
			      {
			        String date = rs.getString("date");
			        currentdate_tf.setText(date);
			      }
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1);
			    }
			}
		});
		phno_tf.setEditable(false);
		phno_tf.requestFocus();
		phno_tf.setBounds(37, 145, 186, 19);
		contentPane.add(phno_tf);
		phno_tf.setColumns(10);
		
		JLabel lblNewLabel3 = new JLabel("Current date of testing:");
		lblNewLabel3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel3.setBounds(342, 127, 186, 19);
		contentPane.add(lblNewLabel3);
		
		currentdate_tf = new JTextField();
		currentdate_tf.setColumns(10);
		currentdate_tf.setBounds(342, 145, 186, 19);
		currentdate_tf.setEditable(false);
		contentPane.add(currentdate_tf);
		
		JLabel lblNewDateOf = new JLabel("New Date of testing:");
		lblNewDateOf.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewDateOf.setBounds(207, 230, 186, 19);
		contentPane.add(lblNewDateOf);
		
		newdate_tf = new JTextField();
		newdate_tf.setColumns(10);
		newdate_tf.setBounds(207, 248, 186, 19);
		contentPane.add(newdate_tf);
		
		JButton confirmchange_btn = new JButton("Confirm change");
		confirmchange_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(newdate_tf.getText().equals(""))) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
					PreparedStatement ps = conn.prepareStatement("update covid19_management_application.testing set date =? where phno =?");
					ps.setString(1, newdate_tf.getText());
					ps.setString(2, phno);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Date successfully updated!");
					user_loggedin_page ulp = new user_loggedin_page();
					ulp.setVisible(true);
					setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter all the fields.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Please enter all the fields.");
				    }
			}
		});
		confirmchange_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		confirmchange_btn.setForeground(SystemColor.info);
		confirmchange_btn.setBackground(new Color(0, 0, 0));
		confirmchange_btn.setBounds(207, 306, 186, 65);
		contentPane.add(confirmchange_btn);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setBounds(260, 381, 85, 21);
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_loggedin_page ulp = new user_loggedin_page();
				ulp.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(cancel_btn);
				
	}
}




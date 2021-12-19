import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class testing_view_appointment_page extends JFrame {

	private JPanel contentPane;
	private JTextField phno_tf;
	private JTextField name_tf;
	private JTextField age_tf;
	private JTextField appointmentdate_tf;
	private JTextField city_tf;
	private JTextField lab_tf;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing_view_appointment_page frame = new testing_view_appointment_page();
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
	public testing_view_appointment_page() {
		
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
				user_loggedin_page ulgp = new user_loggedin_page();
				ulgp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton1.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton1);
		
		JLabel lblNewLabel = new JLabel("View Appointment");
		lblNewLabel.setBounds(0, 0, 586, 89);
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone Number:");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBounds(85, 99, 111, 19);
		contentPane.add(lblNewLabel_1);
		
		phno_tf = new JTextField(phno);
		phno_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
			    {
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
			      PreparedStatement ps = conn.prepareStatement("SELECT * FROM covid19_management_application.testing where phno =?;");
			      ps.setString(1, phno);
			      ResultSet rs = ps.executeQuery();
			      if (rs.next()==true)
			      {
			        String age = rs.getString("age");
			        String name = rs.getString("name");
			        String date = rs.getString("date");
			        String city = rs.getString("city");
			        String labarea = rs.getString("labarea");
			        age_tf.setText(age);
			        name_tf.setText(name);
			        appointmentdate_tf.setText(date);
			        city_tf.setText(city);
			        lab_tf.setText(labarea);	        
			      }
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1);
			    }
			}
		});

		phno_tf.setColumns(10);
		phno_tf.setEditable(false);
		phno_tf.setBounds(195, 99, 186, 19);
		contentPane.add(phno_tf);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setBounds(195, 178, 186, 19);
		contentPane.add(lblNewLabel_2);
		
		name_tf = new JTextField();
		name_tf.setEditable(false);
		name_tf.setHorizontalAlignment(SwingConstants.CENTER);
		name_tf.setColumns(10);
		name_tf.setBounds(195, 197, 186, 19);
		contentPane.add(name_tf);
		
		JLabel lblNewLabel_3 = new JLabel("Date of appointment:");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_3.setBounds(44, 257, 186, 19);
		contentPane.add(lblNewLabel_3);
		
		appointmentdate_tf = new JTextField();
		appointmentdate_tf.setEditable(false);
		appointmentdate_tf.setColumns(10);
		appointmentdate_tf.setBounds(44, 275, 186, 20);
		contentPane.add(appointmentdate_tf);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_4.setBounds(346, 257, 186, 19);
		contentPane.add(lblNewLabel_4);
		
		age_tf = new JTextField();
		age_tf.setEditable(false);
		age_tf.setColumns(10);
		age_tf.setBounds(346, 275, 186, 20);
		contentPane.add(age_tf);
		
		JLabel lblNewLabel_5 = new JLabel("City:");
		lblNewLabel_5.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_5.setBounds(44, 342, 186, 19);
		contentPane.add(lblNewLabel_5);
		
		city_tf = new JTextField();
		city_tf.setEditable(false);
		city_tf.setColumns(10);
		city_tf.setBounds(44, 360, 186, 20);
		contentPane.add(city_tf);
		
		lblNewLabel_6 = new JLabel("Lab location:");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_6.setBounds(346, 342, 186, 19);
		contentPane.add(lblNewLabel_6);
		
		lab_tf = new JTextField();
		lab_tf.setEditable(false);
		lab_tf.setColumns(10);
		lab_tf.setBounds(346, 360, 186, 20);
		contentPane.add(lab_tf);
		
		lblNewLabel_7 = new JLabel("Hit enter to view");
		lblNewLabel_7.setBounds(241, 122, 186, 13);
		contentPane.add(lblNewLabel_7);
		
	}
}





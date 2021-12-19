import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testing_view_result_page extends JFrame {

	private JPanel contentPane;
	private JTextField phno_tf;
	private JTextField name_tf;
	private JTextField age_tf;
	private JTextField result_tf;
	private JTextField labid_tf;
	private JTextField appointmentdate_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing_view_result_page frame = new testing_view_result_page();
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
	public testing_view_result_page() {
		
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
		
		JLabel lblNewLabel = new JLabel("View Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 586, 89);
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
				  String phoneno = phno_tf.getText();
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
			      PreparedStatement ps = conn.prepareStatement("SELECT * FROM covid19_management_application.testing where phno =?;");
			      ps.setString(1, phoneno);
			      ResultSet rs = ps.executeQuery();
			      if (rs.next()==true)
			      {
			        String age = rs.getString("age");
			        String name = rs.getString("name");
			        String date = rs.getString("date");
			        String labid = rs.getString("labid");
			        String result = rs.getString("result");
			        name_tf.setText(name);
			        age_tf.setText(age);
			        appointmentdate_tf.setText(date);
			        labid_tf.setText(labid);
			        result_tf.setText(result);	        
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
		phno_tf.setColumns(10);
		phno_tf.setBounds(195, 99, 186, 19);
		contentPane.add(phno_tf);
		
		JLabel lblNewLabel_7 = new JLabel("Hit enter to view");
		lblNewLabel_7.setBounds(241, 122, 186, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setBounds(195, 178, 186, 19);
		contentPane.add(lblNewLabel_2);
		
		name_tf = new JTextField();
		name_tf.setHorizontalAlignment(SwingConstants.CENTER);
		name_tf.setEditable(false);
		name_tf.setColumns(10);
		name_tf.setBounds(195, 197, 186, 19);
		contentPane.add(name_tf);
		
		JLabel lblNewLabel_2_1 = new JLabel("Age:");
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(195, 226, 186, 19);
		contentPane.add(lblNewLabel_2_1);
		
		age_tf = new JTextField();
		age_tf.setHorizontalAlignment(SwingConstants.CENTER);
		age_tf.setEditable(false);
		age_tf.setColumns(10);
		age_tf.setBounds(195, 245, 186, 19);
		contentPane.add(age_tf);
		
		result_tf = new JTextField();
		result_tf.setHorizontalAlignment(SwingConstants.CENTER);
		result_tf.setFont(new Font("Tahoma", Font.PLAIN, 40));
		result_tf.setEditable(false);
		result_tf.setColumns(10);
		result_tf.setBounds(142, 386, 284, 44);
		contentPane.add(result_tf);
		
		JLabel lblNewLabel_2_3 = new JLabel("Result:");
		lblNewLabel_2_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(142, 369, 186, 19);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Lab ID:");
		lblNewLabel_2_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(194, 319, 186, 19);
		contentPane.add(lblNewLabel_2_2);
		
		labid_tf = new JTextField();
		labid_tf.setHorizontalAlignment(SwingConstants.CENTER);
		labid_tf.setEditable(false);
		labid_tf.setColumns(10);
		labid_tf.setBounds(194, 338, 186, 19);
		contentPane.add(labid_tf);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Testing Date:");
		lblNewLabel_2_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(195, 274, 186, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		appointmentdate_tf = new JTextField();
		appointmentdate_tf.setHorizontalAlignment(SwingConstants.CENTER);
		appointmentdate_tf.setEditable(false);
		appointmentdate_tf.setColumns(10);
		appointmentdate_tf.setBounds(195, 293, 186, 19);
		contentPane.add(appointmentdate_tf);
		


	}

}



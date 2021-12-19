import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class vaccination_booking_appointment_page extends JFrame {

	private JPanel contentPane;
	private JTextField name_tf;
	private JTextField age_tf;
	private JTextField date_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vaccination_booking_appointment_page frame = new vaccination_booking_appointment_page();
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
	public vaccination_booking_appointment_page() {
		
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
		
		JLabel lblNewLabel = new JLabel("Book Appointment");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 566, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel3 = new JLabel("Enter name:");
		lblNewLabel3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel3.setBounds(36, 139, 186, 19);
		contentPane.add(lblNewLabel3);
		
		name_tf = new JTextField();
		name_tf.setColumns(10);
		name_tf.setBounds(36, 158, 186, 19);
		contentPane.add(name_tf);
		
		JLabel lblNewLabel4 = new JLabel("Enter age:");
		lblNewLabel4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel4.setBounds(338, 139, 186, 19);
		contentPane.add(lblNewLabel4);
		
		age_tf = new JTextField();
		age_tf.setHorizontalAlignment(SwingConstants.CENTER);
		age_tf.setColumns(10);
		age_tf.setBounds(338, 158, 186, 19);
		contentPane.add(age_tf);

		JLabel lblNewLabel6 = new JLabel("Date of vaccination:");
		lblNewLabel6.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel6.setBounds(338, 212, 186, 19);
		contentPane.add(lblNewLabel6);
		
		date_tf = new JTextField();
		date_tf.setBounds(338, 234, 186, 20);
		contentPane.add(date_tf);
		date_tf.setColumns(10);
		
		JLabel lblNewLabel5 = new JLabel("Select City:");
		lblNewLabel5.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel5.setBounds(36, 212, 186, 19);
		contentPane.add(lblNewLabel5);
		
		JComboBox<String> city_cb = new JComboBox<String>();
		city_cb.setBounds(36, 231, 186, 24);
		city_cb.addItem("Select");
		city_cb.addItem("Bangalore");
		city_cb.addItem("Delhi");
		city_cb.addItem("Mumbai");
		contentPane.add(city_cb);

		JLabel lblNewLabel61 = new JLabel("Select Lab Location");
		lblNewLabel61.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel61.setBounds(207, 361, 186, 19);
		contentPane.add(lblNewLabel61);
		
		JComboBox<String> location_cb = new JComboBox<String>();
		location_cb.setBounds(207, 380, 186, 24);
		contentPane.add(location_cb);
		
		JButton searchlabs_btn = new JButton("Search Labs");
		searchlabs_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try
			    {
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
			      String query = "SELECT * FROM covid19_management_application.lablocation;";
			      Statement st = conn.createStatement();
			      ResultSet rs = st.executeQuery(query);
			      String[] labs = new String[12];
			      int a = 0;
			      while (rs.next())
			      {
			        String labname = rs.getString("labname");
			        labs[a] = labname;
			        a = a+1;
			      }
			      st.close();
			      String location = (String)city_cb.getSelectedItem();
				  location_cb.addItem("Select");
			      switch(location){
			      	case "Bangalore": 
			      		location_cb.addItem(labs[0]);
			      		location_cb.addItem(labs[1]);
			      		location_cb.addItem(labs[2]);
			      		location_cb.addItem(labs[3]);
			      		break;
			      	case "Delhi": 
			      		location_cb.addItem(labs[4]);
			      		location_cb.addItem(labs[5]);
			      		location_cb.addItem(labs[6]);
			      		location_cb.addItem(labs[7]);
			      		break;
			      	case "Mumbai": 
			      		location_cb.addItem(labs[8]);
			      		location_cb.addItem(labs[9]);
			      		location_cb.addItem(labs[10]);
			      		location_cb.addItem(labs[11]);
			    	  }  
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			    }
			}
		});
		searchlabs_btn.setBounds(242, 290, 121, 39);
		contentPane.add(searchlabs_btn);
		
		JButton bookappointment_btn = new JButton("Book Appointment");
		bookappointment_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(name_tf.getText().equals("") && age_tf.getText().equals("") && city_cb.getSelectedItem().equals(null) && location_cb.getSelectedItem().equals(null))){
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
					PreparedStatement ps = conn.prepareStatement("insert into covid19_management_application.vaccination(phno,name,age,city,labarea,date,result,labid) values (?,?,?,?,?,?,?,?);");
					ps.setString(1, phno);
					ps.setString(2, name_tf.getText());
					ps.setString(3, age_tf.getText());
					ps.setString(4, (String) city_cb.getSelectedItem());
					ps.setString(5, (String) location_cb.getSelectedItem());
					ps.setString(6, date_tf.getText());
					ps.setString(7,"tbd");
					ps.setString(8,"tbd");
					int x = ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Vaccination appointment booked successfully");
					user_loggedin_page ulp = new user_loggedin_page();
					ulp.setVisible(true);
					setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter all the fields.");
					}
				}catch (Exception e1)
			    {
					JOptionPane.showMessageDialog(null,"Invalid credentials. Please enter all the fields correctly.");
				    }
			}
		});
		bookappointment_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		bookappointment_btn.setForeground(SystemColor.info);
		bookappointment_btn.setBackground(new Color(0, 0, 0));
		bookappointment_btn.setBounds(207, 435, 186, 65);
		contentPane.add(bookappointment_btn);
	}
}






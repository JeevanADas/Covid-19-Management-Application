import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class user_loggedin_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_loggedin_page frame = new user_loggedin_page();
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
	public user_loggedin_page() {
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
				user_login_page ulp = new user_login_page();
				ulp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Account");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 10, 416, 48);
		contentPane.add(lblNewLabel);
		
		
		// TESTING
		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 279, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Testing");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 259, 30);
		panel.add(lblNewLabel_1);
		
		//testing booking appointment
		JButton btnNewButton_1 = new JButton("Book Appointment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testing_booking_appointment_page tbap = new testing_booking_appointment_page();
				tbap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(20, 58, 229, 65);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_1.setForeground(SystemColor.info);
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		
		//testing appointment details
		JButton btnNewButton_2 = new JButton("Appointment Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testing_view_appointment_page tvap = new testing_view_appointment_page();
				tvap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(20, 140, 229, 65);
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_2.setForeground(SystemColor.info);
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		
		//testing change appointment
		JButton btnNewButton_3 = new JButton("Change Appointment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testing_change_appointment_page tcap1 = new testing_change_appointment_page();
				tcap1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(20, 220, 229, 65);
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_3.setForeground(SystemColor.info);
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		
		// testing cancel appointment
		JButton btnNewButton_4 = new JButton("Cancel Appointment");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testing_cancel_appointment_page tcap = new testing_cancel_appointment_page();
				tcap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(20, 299, 229, 65);
		panel.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_4.setForeground(SystemColor.info);
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		
		// testing check results
		JButton btnNewButton_5 = new JButton("Check Results");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testing_view_result_page tvrp = new testing_view_result_page();
				tvrp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5.setBounds(20, 380, 229, 65);
		panel.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_5.setForeground(SystemColor.info);
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		
		
		// VACCINATION
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(297, 68, 279, 472);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vaccination");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 9, 259, 30);
		panel_1.add(lblNewLabel_1_2);
		
		// vaccination book appointment
		JButton btnNewButton_1_1 = new JButton("Book Appointment");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccination_booking_appointment_page vbap = new vaccination_booking_appointment_page();
				vbap.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1_1.setForeground(SystemColor.info);
		btnNewButton_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.BLACK);
		btnNewButton_1_1.setBounds(22, 58, 229, 65);
		panel_1.add(btnNewButton_1_1);
		
		// vaccination appointment details
		JButton btnNewButton_2_1 = new JButton("Appointment Details");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccination_view_appointment_page vvap = new vaccination_view_appointment_page();
				vvap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2_1.setForeground(SystemColor.info);
		btnNewButton_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.BLACK);
		btnNewButton_2_1.setBounds(22, 140, 229, 65);
		panel_1.add(btnNewButton_2_1);
		
		// vaccination change appointment
		JButton btnNewButton_3_1 = new JButton("Change Appointment");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccination_change_appointment_page vcap = new vaccination_change_appointment_page();
				vcap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3_1.setForeground(SystemColor.info);
		btnNewButton_3_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_3_1.setBackground(Color.BLACK);
		btnNewButton_3_1.setBounds(22, 220, 229, 65);
		panel_1.add(btnNewButton_3_1);
		
		//vaccination cancel appointment
		JButton btnNewButton_4_1 = new JButton("Cancel Appointment");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccination_cancel_appointment_page vcap1 = new vaccination_cancel_appointment_page();
				vcap1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4_1.setForeground(SystemColor.info);
		btnNewButton_4_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_4_1.setBackground(Color.BLACK);
		btnNewButton_4_1.setBounds(22, 299, 229, 65);
		panel_1.add(btnNewButton_4_1);
		
		// vaccination get certificate
		JButton btnNewButton_5_1 = new JButton("Get Certificate");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccination_view_certificate_page vvcp = new vaccination_view_certificate_page();
				vvcp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5_1.setForeground(SystemColor.info);
		btnNewButton_5_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton_5_1.setBackground(Color.BLACK);
		btnNewButton_5_1.setBounds(22, 380, 229, 65);
		panel_1.add(btnNewButton_5_1);

	}
}




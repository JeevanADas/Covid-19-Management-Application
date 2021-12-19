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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class testing_cancel_appointment_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing_cancel_appointment_page frame = new testing_cancel_appointment_page();
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
	public testing_cancel_appointment_page() {		
		
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
		
		JLabel lblNewLabel = new JLabel("Cancel Appointment");
		lblNewLabel.setBounds(10, 11, 566, 66);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel4 = new JLabel("This action cannot be undone.");
		lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel4.setBounds(207, 263, 186, 19);
		contentPane.add(lblNewLabel4);
	
		JButton btnNewButton = new JButton("CONFIRM CANCELLATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_management_application","root","password@mysql");
				    PreparedStatement ps = conn.prepareStatement("DELETE FROM covid19_management_application.testing where phno = ? ;");
					ps.setString(1, phno);
					int x = ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Appointment cancelled successfully");
					user_loggedin_page ulp = new user_loggedin_page();
					ulp.setVisible(true);
					setVisible(false);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Appointment does not exist with this number.");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setForeground(SystemColor.info);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(171, 293, 257, 65);
		contentPane.add(btnNewButton);
		
	}
}




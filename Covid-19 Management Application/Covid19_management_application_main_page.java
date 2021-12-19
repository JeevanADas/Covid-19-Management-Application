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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Covid19_management_application_main_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Covid19_management_application_main_page frame = new Covid19_management_application_main_page();
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
	public Covid19_management_application_main_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Covid-19 Management Application");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Covid-19 Management");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 586, 89);
		contentPane.add(lblNewLabel);
		
		JButton userLogin_btn = new JButton("User Login");
		userLogin_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		userLogin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_login_page ulp = new user_login_page();
				ulp.setVisible(true);
				setVisible(false);
			}
		});
		userLogin_btn.setForeground(SystemColor.info);
		userLogin_btn.setBackground(new Color(0, 0, 0));
		userLogin_btn.setBounds(207, 166, 186, 65);
		contentPane.add(userLogin_btn);
		
		JButton labLogin_btn = new JButton("Lab Login");
		labLogin_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		labLogin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_login_page llp = new lab_login_page();
				llp.setVisible(true);
				setVisible(false);
			}
		});
		labLogin_btn.setForeground(SystemColor.info);
		labLogin_btn.setBackground(SystemColor.desktop);
		labLogin_btn.setBounds(207, 279, 186, 65);
		contentPane.add(labLogin_btn);
		
		JButton exit_btn = new JButton("Exit");
		exit_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		exit_btn.setForeground(SystemColor.info);
		exit_btn.setBackground(SystemColor.desktop);
		exit_btn.setBounds(207, 396, 186, 65);
		contentPane.add(exit_btn);	
	}

}




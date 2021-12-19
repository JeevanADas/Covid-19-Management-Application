import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class lab_loggedin_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab_loggedin_page frame = new lab_loggedin_page();
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
	public lab_loggedin_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Covid-19 Management Application");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lab Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 10, 566, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_login_page llp = new lab_login_page();
				llp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 51, 21);
		contentPane.add(btnNewButton);
		
		JButton updateTestResult_btn = new JButton("Update Test Result");
		updateTestResult_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_update_test_result_page lutrp = new lab_update_test_result_page();
				lutrp.setVisible(true);	
				setVisible(false);
			}
		});
		updateTestResult_btn.setForeground(SystemColor.info);
		updateTestResult_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		updateTestResult_btn.setBackground(Color.BLACK);
		updateTestResult_btn.setBounds(174, 187, 255, 65);
		contentPane.add(updateTestResult_btn);
		
		JButton updateVaccinationResult_btn = new JButton("Update Vaccination Result");
		updateVaccinationResult_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab_update_vaccination_result_page luvrp = new lab_update_vaccination_result_page();
				luvrp.setVisible(true);	
				setVisible(false);
			}
		});
		updateVaccinationResult_btn.setForeground(SystemColor.info);
		updateVaccinationResult_btn.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		updateVaccinationResult_btn.setBackground(Color.BLACK);
		updateVaccinationResult_btn.setBounds(174, 300, 255, 65);
		contentPane.add(updateVaccinationResult_btn);
	}
}



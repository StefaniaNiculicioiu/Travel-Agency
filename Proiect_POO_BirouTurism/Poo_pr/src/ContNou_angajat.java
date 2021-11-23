import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ContNou_angajat extends JFrame {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ContNou_angajat window = new ContNou_angajat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContNou_angajat() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setLayout(null);
		Image image = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();
		frame.setTitle("Cont nou");
		frame.setIconImage(image);
		
		ImageIcon bg = new ImageIcon(this.getClass().getResource("/travel-agency.jpg"));
		Image img = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();

		JPanel panelAngajat = new JPanel();
		panelAngajat.setBackground(new Color(135, 206, 250));
		panelAngajat.setBounds(271, 97, 308, 273);
		frame.getContentPane().add(panelAngajat);
		panelAngajat.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cont nou");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(100, 35, 100, 39);
		panelAngajat.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nume");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(67, 100, 46, 14);
		panelAngajat.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenume");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(67, 137, 84, 14);
		panelAngajat.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(67, 176, 67, 14);
		panelAngajat.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 99, 86, 20);
		panelAngajat.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 136, 86, 20);
		panelAngajat.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(161, 175, 86, 20);
		panelAngajat.add(textField_5);
		textField_5.setColumns(10);
		
		Calendar c = Calendar.getInstance();
		Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);
		
		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(67, 211, 45, 13);
		panelAngajat.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 209, 86, 19);
		panelAngajat.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		
		btnBack.setBounds(10, 421, 93, 23);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		
		frame.getContentPane().add(btnBack);
		JLabel backGround = new JLabel("",bg, JLabel.CENTER);
		backGround.setLocation(0, 0);
		backGround.setSize(912, 520);
		
			frame.getContentPane().add(backGround);

		frame.setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 924, 491);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
} 


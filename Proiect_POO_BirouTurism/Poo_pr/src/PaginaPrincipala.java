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

public class PaginaPrincipala extends JFrame {

	public Sejururi sj;
	public void initSejururi(){
		this.sj = new Sejururi(10);
		this.sj.addSejur(new Sejur("Jungfrau Region", "Grindelwald, Elvetia", "07-01-2021", "10-01-2021", 4));
		this.sj.addSejur(new Sejur("Boemia Centrala", "Praga, Cehia", "07-01-2021", "10-01-2021",4));
		this.sj.addSejur(new Sejur("Silver Mountain", "Poiana Brasov, Romania", "29-12-2020", "03-01-2021",6));

	}
	
	public Clienti cl;
	public void initClienti(){
		this.cl = new Clienti(10);
		this.cl.addClient(new Client("Popescu", "Maria", "0765456789", "popescumaria", "Silver Mountain", "07-01-2021", "10-01-2021", 4));
		this.cl.addClient(new Client("Ionescu", "Ana", "0786789432", "ionescuana", "Jungfrau Region", "07-01-2021", "10-01-2021",4));
		this.cl.addClient(new Client("Ene", "Alin", "0789234567", "enealin", "Silver Mountain", "29-12-2020", "03-01-2021",6));

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PaginaPrincipala window = new PaginaPrincipala();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaginaPrincipala() {
		initSejururi();
		initClienti();
		JFrame jf = this; 

		this.getContentPane().setBackground(new Color(173, 216, 230));
		this.getContentPane().setLayout(null);
		Image image = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();
		this.setTitle("PAGINA PRINCIPALA");
		this.setIconImage(image);
		
		ImageIcon bg = new ImageIcon(this.getClass().getResource("iStock-1001927840.jpg"));
		Image img = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();

		JPanel panelMeniu = new JPanel();
		panelMeniu.setBackground(new Color(176, 196, 222, 90));
		panelMeniu.setBounds(180, 101, 531, 297);
		this.getContentPane().add(panelMeniu);
		panelMeniu.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Lista statiunilor turistice");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaStatiuni ls = new ListaStatiuni(sj,jf);
				ls.setVisible(true);
				ls.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(36, 76, 204, 52);
		panelMeniu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adaugare sejur");
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugaSejur as = new AdaugaSejur(sj, jf);
				as.setVisible(true);
				as.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(36, 164, 204, 52);
		panelMeniu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Adaugare  perioada");
		btnNewButton_2.setBackground(new Color(255, 222, 173));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ModificarePerioada ls = new ModificarePerioada(sj,jf);
	                ls.setVisible(true);
	                ls.setLocationRelativeTo(null);
	                setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(290, 164, 204, 52);
		panelMeniu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lista clientilor");
		btnNewButton_3.setBackground(new Color(255, 222, 173));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaClientilor ls = new ListaClientilor(cl,jf);
				ls.setVisible(true);
                ls.setLocationRelativeTo(null);
                setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(290, 76, 204, 52);
		panelMeniu.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Meniu principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(185, 22, 148, 39);
		panelMeniu.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Client nou");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientNou as = new ClientNou(cl, jf);
				as.setVisible(true);
				as.setLocationRelativeTo(null);
				setVisible(false);

			}
		});
		btnNewButton_4.setBackground(new Color(255, 222, 173));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(160, 226, 204, 52);
		panelMeniu.add(btnNewButton_4);
		
		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		
		btnBack.setBounds(10, 421, 93, 23);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		
		this.getContentPane().add(btnBack);
		JLabel backGround = new JLabel("",bg, JLabel.CENTER);
		backGround.setSize(912, 520);
		
			this.getContentPane().add(backGround);

		this.setBackground(new Color(173, 216, 230));
		this.setBounds(100, 100, 924, 491);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
} 
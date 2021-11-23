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
import java.awt.Panel;
import java.awt.Component;
import javax.swing.Box;

public class ClientNou extends JFrame {

	
	public Clienti cl;	
	private JTextField NumeClient;
	private JTextField PrenumeClient;
	private JTextField TelefonClient;
	private JTextField EmailClient;
	private JTextField tfPerioada;
	private Date dataPlecare = null;
	private Date dataIntoarcere = null;
	long difference_In_Days;
	public JFrame jf ;
	private JTextField StatiuneClient;
	
	public JTextField getTfNumeClient() {
		return NumeClient;
	}

	public JTextField getTfPrenumeClient() {
		return PrenumeClient;
	}

	public JTextField getTfTelefon() {
		return TelefonClient;
	}

	public JTextField getEmailClient() {
		return EmailClient;
	}
	
	public Date getDataPlecare() {
		return dataPlecare;
	}

	public Date getDataIntoarcere() {
		return dataIntoarcere;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ClientNou window = new ClientNou();
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
	public ClientNou() {
		initClienti();
		initialize();
	}

	public ClientNou(Clienti cl) {
		this.cl = cl;
		initialize();
	}
	
	public ClientNou(Clienti cl, JFrame jf) {
		this.cl = cl;
		this.jf = jf;
		initialize();
	}
	
	public void initClienti(){
		this.cl = new Clienti(10);
		this.cl.addClient(new Client("Popescu", "Maria", "0765456789", "popescumaria", "Silver Mountain", "07-01-2021", "10-01-2021", 4));
		this.cl.addClient(new Client("Ionescu", "Ana", "0786789432", "ionescuana", "Jungfrau Region", "07-01-2021", "10-01-2021",4));
		this.cl.addClient(new Client("Ene", "Alin", "0789234567", "enealin", "Silver Mountain", "29-12-2020", "03-01-2021",6));

	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.getContentPane().setBackground(new Color(173, 216, 230));
		this.getContentPane().setLayout(null);
		Image image = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();
		this.setTitle("CLIENT NOU");
		this.setIconImage(image);
		
		ImageIcon bg = new ImageIcon(this.getClass().getResource("/travel-agency.jpg"));
		Image img = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();

		JPanel panelClient = new JPanel();
		panelClient.setBackground(new Color(135, 206, 235));
		panelClient.setBounds(119, 92, 721, 251);
		this.getContentPane().add(panelClient);
		panelClient.setLayout(null);

		JLabel lblNewContact = new JLabel("Creati un nou client");
		lblNewContact.setBackground(new Color(224, 255, 255));
		lblNewContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewContact.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewContact.setBounds(212, 10, 305, 24);
		panelClient.add(lblNewContact);

		JLabel lblNumeCl = new JLabel("Nume ");
		lblNumeCl.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeCl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeCl.setBounds(41, 62, 61, 13);
		panelClient.add(lblNumeCl);

		NumeClient = new JTextField();
		lblNumeCl.setLabelFor(NumeClient);
		NumeClient.setBounds(109, 60, 201, 19);
		panelClient.add(NumeClient);
		NumeClient.setColumns(10);
		Calendar c = Calendar.getInstance();

		Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);

		JLabel lblDataIntoarcere = new JLabel("Data intoarcere");
		lblDataIntoarcere.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataIntoarcere.setBounds(385, 150, 126, 13);
		panelClient.add(lblDataIntoarcere);

		JLabel lblDataPlecare = new JLabel("Data plecare");
		lblDataPlecare.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataPlecare.setBounds(41, 150, 95, 13);
		panelClient.add(lblDataPlecare);

		JLabel lblPrenumeCl = new JLabel("Prenume");
		lblPrenumeCl.setForeground(new Color(0, 0, 0));
		lblPrenumeCl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenumeCl.setBounds(385, 62, 82, 13);
		panelClient.add(lblPrenumeCl);

		PrenumeClient = new JTextField();
		PrenumeClient.setColumns(10);
		PrenumeClient.setBounds(484, 60, 201, 19);
		panelClient.add(PrenumeClient);
		
		JLabel lblPerioada = new JLabel("Perioada");
		lblPerioada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerioada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPerioada.setBounds(41, 180, 95, 13);
		panelClient.add(lblPerioada);
		
		JDateChooser dp = new JDateChooser();
		dp.setBounds(170, 144, 141, 19);
		panelClient.add(dp);
		
		JDateChooser di = new JDateChooser();
		di.setBounds(544, 150, 141, 19);
		panelClient.add(di);
		

		dp.setMinSelectableDate(c.getTime());
		dp.getDateEditor().addPropertyChangeListener( new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if("date".equals(e.getPropertyName())) {
				di.setMinSelectableDate((Date) e.getNewValue());
				}
			}
		});

		di.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					try {
						dataPlecare = sdf.parse(sdf.format(dp.getDate()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						dataIntoarcere = sdf.parse(sdf.format(di.getDate()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		      		  long difference_In_Time 
		                = dataIntoarcere.getTime() - dataPlecare.getTime(); 
		  	
				   difference_In_Days 
	                = TimeUnit 
	                      .MILLISECONDS 
	                      .toDays(difference_In_Time) 
	                  % 365; 

					
					tfPerioada.setText(String.valueOf(difference_In_Days) + " zile" );
				}

			}
		});

		tfPerioada = new JTextField();
		tfPerioada.setColumns(10);
		tfPerioada.setBounds(109, 178, 201, 19);
		panelClient.add(tfPerioada);
		
		JButton btnConfirmare = new JButton("Confirmare");
		btnConfirmare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tfPerioada.getText().isBlank() && !PrenumeClient.getText().isBlank() && !NumeClient.getText().isBlank() && !TelefonClient.getText().isBlank() && !EmailClient.getText().isBlank() && !dp.getDate().toString().isBlank() && !di.getDate().toString().isBlank())
					{
						JOptionPane.showMessageDialog(null,"Contact adaugat. ","Confirmare adaugare contact",JOptionPane.INFORMATION_MESSAGE);
						DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					
						String dP = sdf.format(dataPlecare);
						String dI = sdf.format(dataIntoarcere);

						
						cl.addClient(new Client(NumeClient.getText(), PrenumeClient.getText(), TelefonClient.getText(), EmailClient.getText(), StatiuneClient.getText(), dP, dI,(int)difference_In_Days));
						
						for(Client a : cl.clientiAgentie) {
							System.out.println(a.getNume() +" " + a.getPrenume()+ " " + a.getTelefon()+ " "+ a.getEmail()+ " "+ a.getStatiune()+ " " + a.getDataPlecare() + " "+ a.getDataIntoarcere() + " "+ String.valueOf(a.getPrioada()) + " zile");
						}
						
					}
				else 
					JOptionPane.showMessageDialog(null,"Va rugam, completati toate campurile! ","Eroare inregistrare contact",JOptionPane.ERROR_MESSAGE) ; 

					
			}
		});
		btnConfirmare.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmare.setBounds(308, 220, 107, 21);
		panelClient.add(btnConfirmare);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefon.setBounds(41, 110, 71, 13);
		panelClient.add(lblTelefon);
		
		TelefonClient = new JTextField();
		TelefonClient.setBounds(109, 108, 201, 19);
		panelClient.add(TelefonClient);
		TelefonClient.setColumns(10);
		
		JLabel EmailCl = new JLabel("Email");
		EmailCl.setForeground(new Color(0, 0, 0));
		EmailCl.setFont(new Font("Tahoma", Font.BOLD, 13));
		EmailCl.setBounds(385, 110, 45, 13);
		panelClient.add(EmailCl);
		
		EmailClient = new JTextField();
		EmailClient.setBounds(484, 108, 201, 19);
		panelClient.add(EmailClient);
		EmailClient.setColumns(10);
		
		JLabel lblStatiune = new JLabel("Statiunea");
		lblStatiune.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatiune.setBounds(385, 181, 82, 13);
		panelClient.add(lblStatiune);
		
		StatiuneClient = new JTextField();
		StatiuneClient.setBounds(484, 178, 201, 19);
		panelClient.add(StatiuneClient);
		StatiuneClient.setColumns(10);

		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PaginaPrincipala.main(null);
				if(jf != null) {
					jf.setVisible(true);
				}
				dispose();
			}
		});
		btnBack.setBounds(27, 477, 93, 23);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		this.getContentPane().add(btnBack);
		JLabel backGround = new JLabel("",bg, JLabel.CENTER);
		backGround.setSize(912, 520);
		
			this.getContentPane().add(backGround);

		this.setBackground(new Color(173, 216, 230));
		this.setBounds(100, 100, 924, 559);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
}
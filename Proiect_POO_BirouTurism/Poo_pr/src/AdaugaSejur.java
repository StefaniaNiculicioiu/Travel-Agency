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

public class AdaugaSejur extends JFrame {

	private JTextField tfNumeStatiune;
	public Sejururi sj;	
	private JTextField tfLocatia;
	private JTextField tfPerioada;
	private Date dataPlecare = null;
	private Date dataIntoarcere = null;
	long difference_In_Days;
	public JFrame jf ;

	public JTextField getTfNumeStatiune() {
		return tfNumeStatiune;
	}

	public JTextField getTfLocatia() {
		return tfLocatia;
	}

	public JTextField getTfPerioada() {
		return tfPerioada;
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
					AdaugaSejur window = new AdaugaSejur();
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
	public AdaugaSejur() {
		initSejururi();
		initialize();
	}

	public AdaugaSejur(Sejururi sj) {
		this.sj = sj;
		initialize();
	}
	
	public AdaugaSejur(Sejururi sj, JFrame jf) {
		this.sj = sj;
		this.jf = jf;
		initialize();
	}
	
	public void initSejururi(){
		this.sj = new Sejururi(10);
		this.sj.addSejur(new Sejur("Jungfrau Region", "Grindelwald, Elvetia", "07-01-2021", "10-01-2021", 4));
		this.sj.addSejur(new Sejur("Boemia Centrala", "Praga, Cehia", "07-01-2021", "10-01-2021",4));
		this.sj.addSejur(new Sejur("Silver Mountain", "Poiana Brasov, Romania", "29-12-2020", "03-01-2021",6));

	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.getContentPane().setBackground(new Color(173, 216, 230));
		this.getContentPane().setLayout(null);
		Image image = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();
		this.setTitle("SEJUR NOU");
		this.setIconImage(image);
		
		ImageIcon bg = new ImageIcon(this.getClass().getResource("/629_1.jpg"));
		
		JLabel lblLogoAdaugaSejur = new JLabel("<html><center> Adaugati un nou pachet de vacanta </center></html>");
		Image img = new ImageIcon(this.getClass().getResource("/Map-icon (1).png")).getImage();
		lblLogoAdaugaSejur.setIcon(new ImageIcon(img));
		lblLogoAdaugaSejur.setBackground(new Color(245, 245, 245));
		lblLogoAdaugaSejur.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogoAdaugaSejur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogoAdaugaSejur.setBounds(10, 20, 204, 72);
		this.getContentPane().add(lblLogoAdaugaSejur);

		JPanel panelSejur = new JPanel();
		panelSejur.setBackground(new Color(176, 196, 222, 90));
		panelSejur.setBounds(267, 92, 393, 251);
		this.getContentPane().add(panelSejur);
		panelSejur.setLayout(null);

		JLabel lblNewBooking = new JLabel("Creati un nou pachet de vacanta");
		lblNewBooking.setBackground(new Color(224, 255, 255));
		lblNewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewBooking.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewBooking.setBounds(55, 10, 305, 24);
		panelSejur.add(lblNewBooking);

		JLabel lblNumeStatiune = new JLabel("Nume statiune");
		lblNumeStatiune.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeStatiune.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeStatiune.setBounds(23, 62, 113, 13);
		panelSejur.add(lblNumeStatiune);

		tfNumeStatiune = new JTextField();
		lblNumeStatiune.setLabelFor(tfNumeStatiune);
		tfNumeStatiune.setBounds(159, 55, 201, 19);
		panelSejur.add(tfNumeStatiune);
		tfNumeStatiune.setColumns(10);
		Calendar c = Calendar.getInstance();

		Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);

		JLabel lblDataIntoarcere = new JLabel("Data intoarcere");
		lblDataIntoarcere.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataIntoarcere.setBounds(23, 150, 126, 13);
		panelSejur.add(lblDataIntoarcere);

		JLabel lblDataPlecare = new JLabel("Data plecare");
		lblDataPlecare.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataPlecare.setBounds(23, 120, 95, 13);
		panelSejur.add(lblDataPlecare);

		JLabel lblLocatie = new JLabel("Locatia");
		lblLocatie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocatie.setBounds(23, 88, 113, 13);
		panelSejur.add(lblLocatie);

		tfLocatia = new JTextField();
		tfLocatia.setColumns(10);
		tfLocatia.setBounds(159, 81, 201, 19);
		panelSejur.add(tfLocatia);
		
		JLabel lblPerioada = new JLabel("Perioada");
		lblPerioada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerioada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPerioada.setBounds(23, 176, 95, 13);
		panelSejur.add(lblPerioada);
		
		JDateChooser dp = new JDateChooser();
		dp.setBounds(159, 113, 141, 19);
		panelSejur.add(dp);
		
		JDateChooser di = new JDateChooser();
		di.setBounds(159, 144, 141, 19);
		panelSejur.add(di);
		

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
		tfPerioada.setBounds(159, 173, 201, 19);
		panelSejur.add(tfPerioada);
		
		JButton btnConfirmare = new JButton("Confirmare");
		btnConfirmare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tfPerioada.getText().isBlank() && !tfLocatia.getText().isBlank() && !tfNumeStatiune.getText().isBlank() && !dp.getDate().toString().isBlank() && !di.getDate().toString().isBlank())
					{
						JOptionPane.showMessageDialog(null,"Sejur adaugat. ","Confirmare adaugare sejur",JOptionPane.INFORMATION_MESSAGE);
						DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					
						String dP = sdf.format(dataPlecare);
						String dI = sdf.format(dataIntoarcere);

						
						sj.addSejur(new Sejur(tfNumeStatiune.getText(), tfLocatia.getText(),dP, dI,(int)difference_In_Days));
						
						for(Sejur s : sj.sejururiAgentie) {
							System.out.println(s.getNumeStatiune() +" " + s.getLocatie() + " "+ s.getDataPlecare() + " "+ s.getDataIntoarcere() + " "+ String.valueOf(s.getPrioada()) + " zile");
						}
						
					}
				else 
					JOptionPane.showMessageDialog(null,"Va rugam, completati toate campurile! ","Eroare inregistrare sejur",JOptionPane.ERROR_MESSAGE) ; 

					
			}
		});
		btnConfirmare.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmare.setBounds(147, 202, 107, 21);
		panelSejur.add(btnConfirmare);

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
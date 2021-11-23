import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListaClientilor extends JFrame{
	private JTable table;
	public Clienti cl;
	public JFrame jf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaClientilor window = new ListaClientilor();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initClienti(){
		this.cl = new Clienti(10);
		this.cl.addClient(new Client("Popescu", "Maria", "0765456789", "popescumaria", "Silver Mountain", "07-01-2021", "10-01-2021", 4));
		this.cl.addClient(new Client("Ionescu", "Ana", "0786789432", "ionescuana", "Jungfrau Region", "07-01-2021", "10-01-2021",4));
		this.cl.addClient(new Client("Ene", "Alin", "0789234567", "enealin", "Silver Mountain", "29-12-2020", "03-01-2021",6));

	}
	/**
	 * Create the application.
	 */
	public ListaClientilor() {
		initClienti();
		initialize();
	}
	public ListaClientilor(Clienti cl) {
		this.cl = cl;
		initialize();
		
	}
	public ListaClientilor(Clienti cl,JFrame jf) {
		this.jf = jf;
		this.cl = cl;
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image image = new ImageIcon(this.getClass().getResource("/Maps-Globe-Earth-icon.png")).getImage();

		this.setTitle("Lista clientilor in functie de statiune");
		this.setIconImage(image);
		this.setBounds(100, 100, 892, 564);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		ImageIcon bg = new ImageIcon(this.getClass().getResource("kisspng-travel-itinerary-computer-software-design-illustra-tripcreator-travel-itinerary-software-features-5d2c4e86315e99.8619362515631847742022.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 163, 542, 181);
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("LISTA CLIENTILOR INREGISTRATI");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(new Color(218, 165, 32));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 10, 542, 42);
		getContentPane().add(lblNewLabel);
		getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setForeground(new Color(255, 153, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><b> <center>Nume statiune</center></b></html>", "<html><b> <center>Nume client</center></b></html>", "<html><b> <center>Prenume client</center></b></html>", "<html><b> <center>Data plecare</center></b></html>", "<html><b> <center>Data intoarcere</center></b></html>", "<html><b> <center>Prioada <br> (zile)</center></b></html>"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.getColumnModel().getColumn(2).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		table.getColumnModel().getColumn(5).setPreferredWidth(54);
		table.setRowHeight(35);
		table.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel tModel = (DefaultTableModel)  table.getModel();
		
		for(Client a : this.cl.clientiAgentie) {
			tModel.addRow(new Object[] {a.getStatiune(), a.getNume(), a.getPrenume(), a.getDataPlecare(),a.getDataIntoarcere(),String.valueOf(a.getPrioada()) + " zile"});
		}
		
		
		table.setBackground(SystemColor.controlDkShadow);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.getTableHeader().setPreferredSize(
			     new Dimension(scrollPane.getWidth(),35));
		scrollPane.setViewportView(table);
		
        /*
         * table.getModel().addTableModelListener(new TableModelListener() {
         * 
         * public void tableChanged(TableModelEvent e) { int row =
         * table.getSelectedRow(); int col = table.getSelectedColumn(); Object o =
         * table.getValueAt(row, col); if(col == 2)
         * sj.sejururiAgentie.get(row).setDataPlecare(o.toString()); if(col == 3)
         * sj.sejururiAgentie.get(row).setDataIntoarcere(o.toString()); if(col == 4) {
         * String[] elements = o.toString().split(" ");
         * sj.sejururiAgentie.get(row).setPerioada((int) Integer.parseInt(elements[0]));
         * } for(Sejur s : sj.sejururiAgentie) { System.out.println(s.getNumeStatiune()
         * +" " + s.getLocatie() + " "+ s.getDataPlecare() + " "+ s.getDataIntoarcere()
         * + " "+ String.valueOf(s.getPrioada()) + " zile"); } }
         * 
         * });
         */
		
		
		JLabel backGround = new JLabel("",bg, JLabel.CENTER);
		backGround.setLocation(-18, 0);
		backGround.setSize(912, 520);
		this.getContentPane().add(backGround);
		Image img2=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(165, 42, 42));
		btnNewButton_1.setLocation(24, 481);
		btnNewButton_1.setSize(100, 25);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon(img2));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jf != null) {
					jf.setVisible(true);
				}
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jungfrau Region", "Silver Mountain", "Boemia Centrala"}));
		comboBox.setBounds(353, 97, 176, 21);
		comboBox.addActionListener(new ActionListener() {
           
			public void actionPerformed(ActionEvent e) {
            	String numeStatiune = (String) comboBox.getSelectedItem();
            	List<Client> c =new ArrayList<Client>(10);
            	for(int i =0; i<cl.getClientiDimensiune();i++) {
            		if(cl.getClientiAgentie().get(i).getStatiune().equals(numeStatiune))
            			c.add(cl.getClientiAgentie().get(i));
            	}
            	//for(Client client: c)
            		//System.out.println(client.getNume() + " " + client.getStatiune());
            	
            	int i = 0;
            	
            	for(i=0;i<table.getModel().getRowCount();i++) {
            		table.getModel().setValueAt(null, i, 0);
            		table.getModel().setValueAt(null,i, 1);
            		table.getModel().setValueAt(null,i, 2);
            		table.getModel().setValueAt(null,i, 3);
            		table.getModel().setValueAt(null,i, 4);
            		table.getModel().setValueAt(null,i, 5);
            		//i++;
            	}
            	
            	for(i=0;i<c.size();i++) {
            		table.getModel().setValueAt(c.get(i).getStatiune(), i, 0);
            		table.getModel().setValueAt(c.get(i).getNume(),i, 1);
            		table.getModel().setValueAt(c.get(i).getPrenume(),i, 2);
            		table.getModel().setValueAt(c.get(i).getDataPlecare(),i, 3);
            		table.getModel().setValueAt(c.get(i).getDataIntoarcere(),i, 4);
            		table.getModel().setValueAt(c.get(i).getPrioada(),i, 5);
            		//i++;
            	}
            	
            }
        });
		getContentPane().add(comboBox);
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
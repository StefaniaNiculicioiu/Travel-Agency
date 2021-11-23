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

 

public class ListaStatiuni extends JFrame{
    private JTable table;
    public Sejururi sj;
    public JFrame jf;

 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListaStatiuni window = new ListaStatiuni();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

 

    public void initSejururi(){
        this.sj = new Sejururi(10);
        this.sj.addSejur(new Sejur("Jungfrau Region", "Grindelwald, Elvetia", "07-01-2021", "10-01-2021", 4));
        this.sj.addSejur(new Sejur("Boemia Centrala", "Praga, Cehia", "07-01-2021", "10-01-2021",4));
        this.sj.addSejur(new Sejur("Silver Mountain", "Poiana Brasov, Romania", "29-12-2020", "03-01-2021",6));

 

    }
    /**
     * Create the application.
     */
    public ListaStatiuni() {
        initSejururi();
        initialize();
    }
    public ListaStatiuni(Sejururi sj) {
        this.sj = sj;
        initialize();
        
    }
    public ListaStatiuni(Sejururi sj,JFrame jf) {
        this.jf = jf;
        this.sj = sj;
        initialize();
        
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Image image = new ImageIcon(this.getClass().getResource("/Maps-Globe-Earth-icon.png")).getImage();

 

        this.setTitle("Lista statiunilor disponibile");
        this.setIconImage(image);
        this.setBounds(100, 100, 892, 564);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        ImageIcon bg = new ImageIcon(this.getClass().getResource("kisspng-travel-itinerary-computer-software-design-illustra-tripcreator-travel-itinerary-software-features-5d2c4e86315e99.8619362515631847742022.png"));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(162, 285, 542, 181);
        scrollPane.setViewportView(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        
        
        
        
        JLabel lblNewLabel = new JLabel("LISTA SEJURURILOR DISPONIBILE LA DATA CURENTA");
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
                "<html><b> <center>Nume statiune</center></b></html>", "<html><b> <center>Locatie</center></b></html>", "<html><b> <center>Data plecare</center></b></html>", "<html><b> <center>Data intoarcere</center></b></html>", "<html><b> <center>Prioada <br> (zile)</center></b></html>"
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(102);
        table.getColumnModel().getColumn(1).setPreferredWidth(108);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(89);
        table.getColumnModel().getColumn(4).setPreferredWidth(54);
        table.setRowHeight(35);
        table.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel tModel = (DefaultTableModel)  table.getModel();
        
        for(Sejur s : this.sj.sejururiAgentie) {
            tModel.addRow(new Object[] {s.getNumeStatiune(), s.getLocatie(),s.getDataPlecare(),s.getDataIntoarcere(),String.valueOf(s.getPrioada()) + " zile"});
        }
        
        JButton btnNewButton = new JButton("Sort\r\n");
        btnNewButton.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent arg0) {
                tModel.getDataVector().removeAllElements();
                
                  Collections.sort(sj.sejururiAgentie); 
                  for(Sejur s : sj.sejururiAgentie) {
                  tModel.addRow(new Object[] {s.getNumeStatiune(),
                  s.getLocatie(),s.getDataPlecare(),s.getDataIntoarcere(),String.valueOf(s.
                  getPrioada()) + " zile"}); }
                  for(Sejur s : sj.sejururiAgentie) {
                        System.out.println(s.getNumeStatiune() +" " + s.getLocatie() + " "+ s.getDataPlecare() + " "+ s.getDataIntoarcere() + " "+ String.valueOf(s.getPrioada()) + " zile");
                    }
                 
            }
        });
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(165, 42, 42));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(623, 247, 81, 25);
        getContentPane().add(btnNewButton);
        
        
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
    }

 

    public JTable getTable() {
        return table;
    }

 

    public void setTable(JTable table) {
        this.table = table;
    }
}
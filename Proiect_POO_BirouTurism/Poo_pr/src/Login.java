import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(new Color(144, 238, 144));
		
		setTitle("SpheraTravel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 532);
		
		
		 contentPane = new JPanel() ;
	
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(442, 284, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(442, 328, 94, 14);
		contentPane.add(lblPassword);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(553, 282, 200, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(553, 323, 200, 25);
		contentPane.add(tfPassword);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             String email=tfEmail.getText();
             String password=tfPassword.getText();
             if (email.isBlank() || password.isBlank())
             {
            	 JOptionPane.showMessageDialog(null,"Incorrect password or email adress. Please try again. ","Log in ERROR",JOptionPane.ERROR_MESSAGE) ; 
              tfEmail.setText(null);
              tfPassword.setText(null);
             }
             else
             {
            	
         	 PaginaPrincipala.main(null);
             dispose();
             }
			}
		});
		
		btnSignIn.setForeground(new Color(255, 255, 240));
		btnSignIn.setBackground(new Color(95, 158, 160));
		btnSignIn.setBounds(432, 434, 150, 25);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel_3 = new JLabel("Create a new account");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(656, 410, 176, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignUp.setBackground(new Color(95, 158, 160));
		btnSignUp.setForeground(new Color(255, 0, 0));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContNou_angajat.main(null);
				dispose();
			}
		});
		btnSignUp.setBounds(670, 434, 150, 25);
		contentPane.add(btnSignUp);
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				dispose();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(431, 388, 425, 2);
		contentPane.add(separator);
		
		JLabel lblLogo = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/imageonline-co-transparentimage.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 42));
		lblLogo.setBounds(388, 10, 505, 274);
		contentPane.add(lblLogo);
		
		JPanel panel = new JPanel() {  
			 public void paintComponent(Graphics g) {  
			 Image img = Toolkit.getDefaultToolkit().getImage( Login.class.getResource("/imageonline-co-cropped-image.jpg"));  
			 g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		           }  
	    }; 
		panel.setBounds(0, 0, 386, 495);
		contentPane.add(panel);
	}
}

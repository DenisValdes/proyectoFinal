package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Conn;
import persistencia.ManejadorBD;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField mLogin;
	private JPasswordField pLogin;
	private JButton botonLogin;
	private ManejadorBD manBD = new ManejadorBD();

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
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pLogin = new JPasswordField();
	
		pLogin.setBounds(333, 328, 274, 32);
		contentPane.add(pLogin);
		
		mLogin = new JTextField();
		mLogin.setBounds(333, 244, 274, 32);
		contentPane.add(mLogin);
		mLogin.setColumns(10);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Login.class.getResource("/user.png")));
		button.setBounds(272, 244, 38, 32);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Login.class.getResource("/padlock.png")));
		button_1.setBounds(272, 328, 38, 32);
		contentPane.add(button_1);
		
		botonLogin = new JButton("Ingresar");

		botonLogin.setFont(new Font("Alef", Font.PLAIN, 20));
		botonLogin.setBounds(383, 394, 138, 32);
		contentPane.add(botonLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/login-biblAnima.png")));
		label.setBounds(0, 0, 884, 561);
		contentPane.add(label);
		
		//Acciones

		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = manBD.Login(mLogin.getText(), pLogin.getText());
				
				if(i == 1) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
					Login.this.dispose();
					Interface vistaBibliotecario = new Interface();
					vistaBibliotecario.setVisible(true);
					
				}else if(i > 1) {
					JOptionPane.showMessageDialog(null, "Mail y password duplicados en la base de datos");
				
				}else {
					JOptionPane.showMessageDialog(null, "Mail y/o password incorrectos. Intente de nuevo...");
				
				}						
				
			}
		});  
	}
}

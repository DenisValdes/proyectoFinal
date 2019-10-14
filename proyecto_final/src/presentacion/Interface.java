package presentacion;

import logica.Manejador;
import logica.Orientacion;
import logica.TipoUsuario;
import persistencia.Conn;
import persistencia.ManejadorBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 58957044995731644L;
	public JPanel princialPanel;
	public JTextField inputNombre;
	public JTextField inputSearch;
	public JTextField inputApellido;
	public JTextField inputMail;
	public JTextField inputCI;
	public JPasswordField inputPassword;
	private JTextField emailLogin;
	private JPasswordField passwordLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		Manejador man = Manejador.getInstance();
		ManejadorBD manBD = new ManejadorBD();
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu usuariosContent = new JMenu("Usuarios");
				menuBar.add(usuariosContent);
				
				JMenuItem btnAltaUsuario = new JMenuItem("Dar de alta");
				
				
				usuariosContent.add(btnAltaUsuario);
				
				JMenuItem btnListarUsuariosExistentes = new JMenuItem("Listar Usuarios Existentes");
				
				usuariosContent.add(btnListarUsuariosExistentes);
				
				JMenuItem menuItem = new JMenuItem(" ");
				usuariosContent.add(menuItem);
				
		JMenu librosContent = new JMenu("Libros");
				menuBar.add(librosContent);
				
				JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dar de alta un libro ");
				librosContent.add(mntmNewMenuItem_3);
				
		JMenu prestamosContent = new JMenu("Prestamos");
				menuBar.add(prestamosContent);
				
				JMenuItem mntmNewMenuItem = new JMenuItem("Dar de alta un prestamo");
				prestamosContent.add(mntmNewMenuItem);
				
				JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar Prestamos");
				prestamosContent.add(mntmNewMenuItem_2);
				
				JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar prestamos");
				prestamosContent.add(mntmNewMenuItem_1);
				
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Dar de baja un Prestamo");
				prestamosContent.add(mntmNewMenuItem_4);
				
				princialPanel = new JPanel();
				princialPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(princialPanel);
				princialPanel.setLayout(null);
		
		//Vista login
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setBackground(Color.WHITE);
		login.setBounds(0, 0, 884, 540);
		princialPanel.add(login);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n");
		lblInicioDeSesin.setFont(new Font("Alef", Font.PLAIN, 40));
		lblInicioDeSesin.setBounds(559, 85, 285, 32);
		login.add(lblInicioDeSesin);
		
		emailLogin = new JTextField();
		emailLogin.setBackground(SystemColor.info);
		emailLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLogin.setText("Ej. usuario@anima.edu.uy");
		emailLogin.setBounds(601, 172, 204, 32);
		login.add(emailLogin);
		emailLogin.setColumns(10);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBackground(SystemColor.info);
		passwordLogin.setBounds(601, 237, 204, 32);
		login.add(passwordLogin);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Alef", Font.PLAIN, 15));
		btnRegistrar.setBounds(581, 350, 102, 23);
		login.add(btnRegistrar);
		
		JButton btnIniciar = new JButton("Ingresar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Conn connect = new Conn();
					Connection con = connect.conectarMySQL();
					String query = "SELECT * FROM usuarios WHERE mail='"+ emailLogin.getText()+"' AND pass='"+passwordLogin.getPassword().toString()+"'";
  
				    Statement st = con.createStatement();

					st.executeQuery(query);
					
						JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso...");
						login.setVisible(false);
						usuariosContent.setEnabled(true);
						librosContent.setEnabled(true);
						prestamosContent.setEnabled(true);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		});
		btnIniciar.setFont(new Font("Alef", Font.PLAIN, 15));
		btnIniciar.setBounds(701, 350, 102, 23);
		login.add(btnIniciar);
		
		JCheckBox mostrar_password = new JCheckBox("Mostrar password");
		mostrar_password.setFont(new Font("Alef", Font.PLAIN, 15));
		mostrar_password.setBounds(611, 276, 147, 23);
		login.add(mostrar_password);
		
				JLabel userIcon = new JLabel("");
				userIcon.setIcon(new ImageIcon(Interface.class.getResource("/user.png")));
				userIcon.setBounds(559, 172, 32, 32);
				login.add(userIcon);
				
				JLabel passIcon = new JLabel("");
				passIcon.setIcon(new ImageIcon(Interface.class.getResource("/padlock.png")));
				passIcon.setBounds(559, 237, 32, 32);
				login.add(passIcon);
				
				JLabel backgroundLogin = new JLabel("");
				backgroundLogin.setBounds(0, 0, 884, 540);
				login.add(backgroundLogin);
				backgroundLogin.setIcon(new ImageIcon(Interface.class.getResource("/fondo-biblAnima.png")));		
				
				
			
				
		//Panel alta usuario
		JPanel altaUsuario = new JPanel();
		altaUsuario.setBackground(SystemColor.text);
		altaUsuario.setBounds(0, 0, 884, 540);
		princialPanel.add(altaUsuario);
		altaUsuario.setVisible(false);
		altaUsuario.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese aqu\u00ED los datos solicitados");
		lblNewLabel_1.setBounds(526, 45, 328, 32);
		lblNewLabel_1.setFont(new Font("Alef", Font.PLAIN, 22));
		altaUsuario.add(lblNewLabel_1);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(526, 109, 157, 23);
		inputNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputNombre.setText("Nombre");
		altaUsuario.add(inputNombre);
		inputNombre.setColumns(10);
		
		inputApellido = new JTextField();
		inputApellido.setBounds(697, 109, 157, 23);
		inputApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputApellido.setText("Apellido");
		inputApellido.setColumns(10);
		altaUsuario.add(inputApellido);
		
		inputMail = new JTextField();
		inputMail.setBounds(526, 217, 328, 23);
		
		inputMail.setText("Ej. usuario@anima.edu.uy");
		inputMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputMail.setColumns(10);
		altaUsuario.add(inputMail);
		
		inputCI = new JTextField();
		inputCI.setBounds(526, 158, 328, 23);
		inputCI.setText("CI del usuario");
		inputCI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputCI.setColumns(10);
		altaUsuario.add(inputCI);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(526, 194, 46, 23);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		altaUsuario.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(526, 251, 74, 32);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		altaUsuario.add(lblPassword);
		
		JCheckBox mostrarPassword = new JCheckBox("Mostrar password");
		mostrarPassword.setBounds(526, 305, 137, 23);
		altaUsuario.add(mostrarPassword);
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(526, 278, 328, 20);
		altaUsuario.add(inputPassword);
		
		JComboBox<String> tipoUsuario = new JComboBox<String>();
		tipoUsuario.setBounds(526, 372, 118, 23);
		altaUsuario.add(tipoUsuario);
		
		JLabel lblOrientacion = new JLabel("Orientacion a la que pertenece el usuario");
		lblOrientacion.setBounds(526, 389, 328, 44);
		lblOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		altaUsuario.add(lblOrientacion);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTipoDeUsuario.setBounds(526, 334, 328, 44);
		altaUsuario.add(lblTipoDeUsuario);
		
		JComboBox<String> orientUsuario = new JComboBox<String>();
		orientUsuario.setBounds(526, 432, 118, 23);
		altaUsuario.add(orientUsuario);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Alef", Font.PLAIN, 15));
		btnAceptar.setBounds(724, 477, 89, 23);
		altaUsuario.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		
		btnCancelar.setFont(new Font("Alef", Font.PLAIN, 14));
		btnCancelar.setBounds(579, 477, 89, 23);
		altaUsuario.add(btnCancelar);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 884, 540);
		background.setIcon(new ImageIcon(Interface.class.getResource("/fondo-biblAnima.png")));
		altaUsuario.add(background);
		//Panel listado de usuarios
		JPanel listadoUsuario = new JPanel();
		listadoUsuario.setToolTipText("");
		listadoUsuario.setBackground(SystemColor.activeCaption);
		listadoUsuario.setBounds(0, 0, 884, 540);
		princialPanel.add(listadoUsuario);
				listadoUsuario.setVisible(false);
				listadoUsuario.setLayout(null);
						
				JLabel lblNewLabel_2 = new JLabel("Listado de usuarios");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_2.setBounds(26, 17, 242, 34);
				listadoUsuario.add(lblNewLabel_2);
								
				inputSearch = new JTextField();
				inputSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
				inputSearch.setText("Ingrese CI de usuario...");
				inputSearch.setToolTipText("");
				inputSearch.setBounds(640, 23, 183, 31);
				listadoUsuario.add(inputSearch);
				inputSearch.setColumns(10);
								
				JButton btnNewButton = new JButton("");
								
								
				btnNewButton.setIcon(new ImageIcon("/search.png"));
				btnNewButton.setBounds(821, 23, 41, 31);
				listadoUsuario.add(btnNewButton);
					usuariosContent.setEnabled(false);
					librosContent.setEnabled(false);
					prestamosContent.setEnabled(false);
			
					//Actions
					
					//Login
					mostrar_password.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if( mostrar_password.isSelected()) {
								passwordLogin.setEchoChar((char)0);
							}else {
								passwordLogin.setEchoChar('●');
							}
						}
					});
					
					emailLogin.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if(emailLogin.getText().equals("Ej. usuario@anima.edu.uy")) {
							emailLogin.setText("");
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(emailLogin.getText().equals("")) {
							emailLogin.setText("Ej. usuario@anima.edu.uy");
						}
					}
					});
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							login.setVisible(false);
							altaUsuario.setVisible(true);
						}
					});	
			
			//Menu
						
				
				btnAltaUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						altaUsuario.setVisible(true);
						listadoUsuario.setVisible(false);
					}
				});
			
				btnListarUsuariosExistentes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						listadoUsuario.setVisible(true);
						altaUsuario.setVisible(false);
					}
				});
			
			//Listado de usuarios
				inputSearch.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if(inputSearch.getText().equals("Ingrese CI de usuario...")) {
							inputSearch.setText("");
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(inputSearch.getText().equals("")) {
							inputSearch.setText("Ingrese CI de usuario");
						}
					}
				});
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputSearch.setText("Ingrese CI de usuario...");
						
					}
				});
				

			//Alta usuario
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Orientacion orient = null;
						
						switch(orientUsuario.getSelectedItem().toString()) {
							case "TIC":
								orient = Orientacion.TIC;
								break;
							case "ADM":
								orient = Orientacion.ADM;
								break;
							case "TICYADM":
								orient = Orientacion.ADMYTIC;
								break;
						}

						TipoUsuario tipo = null;
						
						switch(tipoUsuario.getSelectedItem().toString()) {
							case "ESTUDIANTE":
								tipo = TipoUsuario.ESTUDIANTE;
								break;
							case "PROFESOR":
								tipo = TipoUsuario.PROFESOR;
								break;
							case "BIBLIOTECARIO":
								tipo = TipoUsuario.BIBLIOTECARIO;
								break;
						}
						
						int ci = Integer.parseInt(inputCI.getText());
						
						//Java
						try {							
							man.altaUsuario(ci, inputNombre.getText(), inputApellido.getText(), inputMail.getText(), inputPassword.getPassword().toString(), tipo, orient);
							JOptionPane.showMessageDialog(null, "Usuario creado correctamente.");
							
						}catch (Exception a) {
							JOptionPane.showMessageDialog(null, "Error al intentar crear usuario, error del programa.");
							System.out.println("error crear user" + a);
						}
						
						//SQL
						try {
							manBD.altaUsuarioDB(ci, inputNombre.getText(), inputApellido.getText(), inputMail.getText(), inputPassword.getPassword().toString(), String.valueOf(tipoUsuario.getSelectedItem()));
							JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente a la base de datos.");
							
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Error al intentar guardar usuario en la base de datos.");
							System.out.println("error insert db" + e1);
						}
						
						inputNombre.setText("Nombre");
						inputApellido.setText("Apellido");
						inputCI.setText("CI del usuario");
						inputMail.setText("Ej. usuario@anima.edu.uy");
						inputPassword.setText("");
					}
				});
				
				inputNombre.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if( inputNombre.getText().equals("Nombre")) {
							inputNombre.setText("");						
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						if( inputNombre.getText().equals("")) {
							inputNombre.setText("Nombre");						
						}
					}
				});
				
				inputApellido.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if( inputApellido.getText().equals("Apellido")) {
							inputApellido.setText("");						
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						if( inputApellido.getText().equals("")) {
							inputApellido.setText("Apellido");						
						}
					}
				});
				
				inputCI.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if( inputCI.getText().equals("CI del usuario")) {
							inputCI.setText("");						
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						if( inputCI.getText().equals("")) {
							inputCI.setText("CI del usuario");						
						}
					}
				});
				
				inputMail.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if( inputMail.getText().equals("Ej. usuario@anima.edu.uy")) {
							inputMail.setText("");						
						}
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						if( inputMail.getText().equals("")) {
							inputMail.setText("Ej. usuario@anima.edu.uy");						
						}
					}
				});
				
				mostrarPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if( mostrarPassword.isSelected()) {
							inputPassword.setEchoChar((char)0);
						}else {
							inputPassword.setEchoChar('●');
						}
					}
				});
				
				tipoUsuario.addItem("Estudiante");
				tipoUsuario.addItem("Profesor");
				tipoUsuario.addItem("Bibliotecario");
				
				orientUsuario.addItem("TIC");
				orientUsuario.addItem("ADM");
				orientUsuario.addItem("TICYADM");
				
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(usuariosContent.isEnabled() == false && librosContent.isEnabled() == false && prestamosContent.isEnabled() == false) {
							altaUsuario.setVisible(false);
							login.setVisible(true);
						}else if(usuariosContent.isEnabled() == true && librosContent.isEnabled() == true && prestamosContent.isEnabled() == true) {
							
						}
					
					}
				});
		
	}
}


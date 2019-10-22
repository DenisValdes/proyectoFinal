package presentacion;

import logica.Manejador;

import logica.Orientacion;
import logica.TipoUsuario;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

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
	private JPasswordField pAlta;

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
				
				JButton Logout = new JButton("Desconectar");
				Logout.setBackground(Color.WHITE);
				
				menuBar.add(Logout);
				
				princialPanel = new JPanel();
				princialPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(princialPanel);
				princialPanel.setLayout(null);
		
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
				lblNewLabel_2.setBounds(26, 23, 242, 34);
				listadoUsuario.add(lblNewLabel_2);
				
				inputSearch = new JTextField();
				inputSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				inputSearch.setText("Ingrese CI de usuario...");
				inputSearch.setToolTipText("");
				inputSearch.setBounds(640, 23, 183, 31);
				listadoUsuario.add(inputSearch);
				inputSearch.setColumns(10);
				
				JButton searchUser = new JButton("");
				
				
				searchUser.setIcon(new ImageIcon("/search.png"));
				searchUser.setBounds(821, 23, 41, 31);
				listadoUsuario.add(searchUser);
				
				JList<?> list = new JList<Object>();
				list.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				list.setBounds(26, 153, 302, 342);
				listadoUsuario.add(list);
				
				JButton refrescarLista = new JButton("Refrescar lista");
				
				refrescarLista.setBounds(90, 119, 144, 23);
				listadoUsuario.add(refrescarLista);
				
				JPanel infoUser = new JPanel();
				infoUser.setBounds(394, 153, 453, 342);
				listadoUsuario.add(infoUser);
				infoUser.setLayout(null);
				
				JLabel nombreInfo = new JLabel("user name");
				nombreInfo.setBackground(Color.WHITE);
				nombreInfo.setBounds(10, 26, 215, 37);
				infoUser.add(nombreInfo);
				
				JLabel lblRestoDeLa = new JLabel("resto de la info");
				lblRestoDeLa.setBounds(10, 89, 222, 153);
				infoUser.add(lblRestoDeLa);
	
		//Panel alta usuario
		JPanel altaUsuario = new JPanel();
		altaUsuario.setBackground(SystemColor.text);
		altaUsuario.setBounds(0, 0, 884, 540);
		princialPanel.add(altaUsuario);
		altaUsuario.setLayout(null);
		altaUsuario.setVisible(false);
		
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
		
		pAlta = new JPasswordField();
		pAlta.setBounds(526, 278, 328, 23);
		altaUsuario.add(pAlta);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 884, 540);
		background.setIcon(new ImageIcon(Interface.class.getResource("/fondo-biblAnima.png")));
		altaUsuario.add(background);		
	
		//Alta usuario
		
		btnAceptar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String nombre = inputNombre.getText();
			String apellido = inputApellido.getText();
			String mail = inputMail.getText();
			String pass = pAlta.getText();
			
			int ci = Integer.parseInt(inputCI.getText());
			int id = manBD.generarId();
										
			//SQL
			try {
				manBD.altaUsuarioDB(id, ci, nombre, apellido, mail, pass, String.valueOf(tipoUsuario.getSelectedItem()), String.valueOf(orientUsuario.getSelectedItem()));
				JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente a la base de datos.");
				
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Error al intentar guardar usuario en la base de datos.");
				System.out.println("error insert db" + e1);
			}
				
			inputNombre.setText("Nombre");
			inputApellido.setText("Apellido");
			inputCI.setText("CI del usuario");
			inputMail.setText("Ej. usuario@anima.edu.uy");
			pAlta.setText("");
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
		
		
		
		tipoUsuario.addItem("Estudiante");
		tipoUsuario.addItem("Profesor");
		tipoUsuario.addItem("Bibliotecario");
		
		orientUsuario.addItem("TIC");
		orientUsuario.addItem("ADM");
		orientUsuario.addItem("TICYADM");
								
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
												
				mostrarPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(mostrarPassword.isSelected() == true) {
							pAlta.setEchoChar((char) 0);
						}else if(mostrarPassword.isSelected() == false) {
							pAlta.setEchoChar('●');
						}
					}
				});
	
				Logout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Interface.this.dispose();
						Login frame = new Login();
						frame.setVisible(true);
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
				
				searchUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputSearch.setText("Ingrese CI de usuario...");
						
					}
				});
				listadoUsuario.setVisible(true);
				refrescarLista.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						DefaultListModel modelo = manBD.listarUsuarios();
						
						list.setModel(modelo);
					
					}
				});
				
				manBD.traeUsuarios();
				
				infoUser.setVisible(false);
				
				list.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent evt) {
				        evt.getSource();
				        if (evt.getClickCount() == 2) {
				        	String mail = list.getSelectedValue().toString();
				        	String nombre = manBD.nombreBD(mail);
				        	
				        	infoUser.setVisible(true);      	
				            nombreInfo.setText(nombre);
				        }
				    }
				});
	}
}


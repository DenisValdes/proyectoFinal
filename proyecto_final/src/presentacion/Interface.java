package presentacion;

import logica.Libro;
import logica.Manejador;

import logica.Usuario;
import persistencia.ManejadorBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
import java.io.DataOutput;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Interface extends JFrame {

	private static final long serialVersionUID = 58957044995731644L;
	public JPanel princialPanel;
	public JTextField inputNombre;
	public JTextField inputSearch;
	public JTextField inputApellido;
	public JTextField inputMail;
	public JTextField inputCI;
	private JPasswordField pAlta;
	private JList<String> list;

	DefaultListModel<String> listModel;
	DefaultTableModel listlibros;

	ArrayList<Usuario> usuarios;
	private JTextField updateNombre;
	private JTextField updateApellido;
	private JTextField updateCi;
	private JTextField updateMail;
	private JTextField updatePass;
	private JTable table;

	// Launch the application
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

	// Create the frame
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 664);

		Manejador man = Manejador.getInstance();
		ManejadorBD manBD = new ManejadorBD();

		// Menu
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
		
		JMenuItem mntmListaDeLibros = new JMenuItem("Lista de libros");
		
		librosContent.add(mntmListaDeLibros);

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

		JPanel libros = new JPanel();
		libros.setBounds(0, 0, 900, 600);
		princialPanel.add(libros);
		libros.setLayout(null);
		libros.setVisible(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(27, 146, 844, 379);
		libros.add(scrollPane_1);

	    JTable table = new JTable();
	    table.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(23, 54, 184, 59);
		libros.add(btnNewButton);

		// Vista listado de usuarios
		JPanel listadoUsuario = new JPanel();
		listadoUsuario.setToolTipText("");
		listadoUsuario.setBackground(SystemColor.activeCaption);
		listadoUsuario.setBounds(0, 0, 900, 600);
		princialPanel.add(listadoUsuario);
		listadoUsuario.setVisible(false);
		listadoUsuario.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Listado de usuarios");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(326, 11, 242, 34);
		listadoUsuario.add(lblNewLabel_2);

		inputSearch = new JTextField();
		inputSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));

		inputSearch.setText("Ingrese CI de usuario...");
		inputSearch.setToolTipText("");
		inputSearch.setBounds(26, 94, 183, 31);
		listadoUsuario.add(inputSearch);
		inputSearch.setColumns(10);

		JButton searchUser = new JButton("");
		searchUser.setIcon(new ImageIcon(Interface.class.getResource("/search.png")));

		searchUser.setBounds(219, 94, 41, 31);
		listadoUsuario.add(searchUser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 136, 302, 342);
		listadoUsuario.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton refrescarLista = new JButton("Refrescar lista");
		refrescarLista.setFont(new Font("Tahoma", Font.PLAIN, 15));

		refrescarLista.setBounds(64, 489, 167, 26);
		listadoUsuario.add(refrescarLista);

		// Panel donde se mostrara la consulta de usuario
		JPanel infoUser = new JPanel();
		infoUser.setBackground(SystemColor.info);
		infoUser.setBounds(453, 136, 406, 342);
		listadoUsuario.add(infoUser);
		infoUser.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(21, 11, 72, 37);
		infoUser.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(21, 54, 72, 37);
		infoUser.add(lblApellido);

		JLabel lblCedulaDeIdentidad = new JLabel("C.I:");
		lblCedulaDeIdentidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCedulaDeIdentidad.setBackground(Color.WHITE);
		lblCedulaDeIdentidad.setBounds(21, 102, 27, 37);
		infoUser.add(lblCedulaDeIdentidad);

		JLabel lblEmail_1 = new JLabel("E-mail:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail_1.setBackground(Color.WHITE);
		lblEmail_1.setBounds(21, 143, 52, 37);
		infoUser.add(lblEmail_1);

		JLabel lblPrestamosActivos = new JLabel("Prestamos activos:");
		lblPrestamosActivos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrestamosActivos.setBackground(Color.WHITE);
		lblPrestamosActivos.setBounds(21, 191, 156, 37);
		infoUser.add(lblPrestamosActivos);

		JLabel nombreInfo = new JLabel("user name");
		nombreInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreInfo.setBackground(Color.WHITE);
		nombreInfo.setBounds(103, 20, 147, 19);
		infoUser.add(nombreInfo);

		JLabel apellidoInfo = new JLabel("last name");
		apellidoInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apellidoInfo.setBackground(Color.WHITE);
		apellidoInfo.setBounds(103, 62, 147, 20);
		infoUser.add(apellidoInfo);

		JLabel ciInfo = new JLabel("ci");
		ciInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ciInfo.setBackground(Color.WHITE);
		ciInfo.setBounds(58, 111, 147, 19);
		infoUser.add(ciInfo);

		JLabel mailInfo = new JLabel("mail");
		mailInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mailInfo.setBackground(Color.WHITE);
		mailInfo.setBounds(83, 153, 167, 18);
		infoUser.add(mailInfo);

		JLabel prestamosInfo = new JLabel("p");
		prestamosInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prestamosInfo.setBackground(Color.WHITE);
		prestamosInfo.setBounds(173, 190, 42, 39);
		infoUser.add(prestamosInfo);

		JButton updateInfo = new JButton("Modificar datos usuarios");

		updateInfo.setBounds(199, 294, 156, 37);
		infoUser.add(updateInfo);

		JButton eliminarUsuario = new JButton("Eliminar ususario");
		eliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		eliminarUsuario.setBackground(Color.LIGHT_GRAY);
		eliminarUsuario.setBounds(57, 294, 120, 37);
		infoUser.add(eliminarUsuario);

		// Inputs para modificar info de ususario
		updateNombre = new JTextField();
		updateNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateNombre.setBounds(103, 21, 147, 20);
		infoUser.add(updateNombre);
		updateNombre.setColumns(10);
		updateNombre.setVisible(false);

		updateApellido = new JTextField();
		updateApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateApellido.setColumns(10);
		updateApellido.setBounds(103, 64, 147, 20);
		infoUser.add(updateApellido);
		updateApellido.setVisible(false);

		updateCi = new JTextField();
		updateCi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateCi.setColumns(10);
		updateCi.setBounds(58, 112, 147, 20);
		infoUser.add(updateCi);
		updateCi.setVisible(false);

		updateMail = new JTextField();
		updateMail.setColumns(10);
		updateMail.setBounds(83, 153, 167, 20);
		infoUser.add(updateMail);
		updateMail.setVisible(false);

		updatePass = new JTextField();
		updatePass.setColumns(10);
		updatePass.setBounds(83, 201, 126, 20);
		infoUser.add(updatePass);
		updatePass.setVisible(false);

		JLabel lblPassword_1 = new JLabel("Pass:");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1.setBackground(Color.WHITE);
		lblPassword_1.setBounds(21, 191, 52, 37);
		infoUser.add(lblPassword_1);
		lblPassword_1.setVisible(false);

		JButton cancelarUpdate = new JButton("Cancelar");
		cancelarUpdate.setVisible(false);

		cancelarUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		cancelarUpdate.setBounds(94, 246, 83, 23);
		infoUser.add(cancelarUpdate);

		JButton aceptarUpdate = new JButton("Aceptar");

		aceptarUpdate.setVisible(false);

		aceptarUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		aceptarUpdate.setBounds(199, 246, 83, 23);
		infoUser.add(aceptarUpdate);

		// Listado de usuarios
		// El programa inicia con esta vista
		listadoUsuario.setVisible(true);

		inputSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				if (inputSearch.getText().equals("Ingrese CI de usuario...")) {
					inputSearch.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (inputSearch.getText().equals("")) {
					inputSearch.setText("Ingrese CI de usuario...");
				}
			}
		});

		// Llama al metodo que busca a usuario segun ci
		searchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Usuario usuario = man.buscarUsuario(Integer.valueOf(inputSearch.getText()));

					listModel = new DefaultListModel<>();
					list.setModel(listModel);

					String mail;

					mail = usuario.getMail();
					listModel.add(0, mail);

					list.setModel(listModel);

					JOptionPane.showMessageDialog(null, "Usuario encontrado!", "Mensaje del sistema",
							JOptionPane.PLAIN_MESSAGE);
				} catch (Exception p) {
					System.out.println(p);
					JOptionPane.showMessageDialog(null, "Usuario no encotrado. Verifique la C.I", "Mensaje del sistema",
							JOptionPane.ERROR_MESSAGE);
				}
				inputSearch.setText("Ingrese CI de usuario...");

			}
		});

		// Refresaca el listado de usuarios
		refrescarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				man.altaUsuario();

				listModel = new DefaultListModel<>();
				list.setModel(listModel);

				ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
				String mail;

				for (int i = 0; i < usuarios.size(); i++) {
					mail = usuarios.get(i).getMail();
					listModel.add(i, mail);
				}

				list.setModel(listModel);

			}
		});

		infoUser.setVisible(false);

		// Update user

		// Muestra campos para modificar info
		updateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombreInfo.setVisible(false);
				updateNombre.setVisible(true);
				updateNombre.setText(nombreInfo.getText());

				apellidoInfo.setVisible(false);
				updateApellido.setVisible(true);
				updateApellido.setText(apellidoInfo.getText());

				ciInfo.setVisible(false);
				updateCi.setVisible(true);
				updateCi.setText(ciInfo.getText());

				mailInfo.setVisible(false);
				updateMail.setVisible(true);
				updateMail.setText(mailInfo.getText());

				prestamosInfo.setVisible(false);

				lblPassword_1.setVisible(true);
				updatePass.setVisible(true);
				updatePass.setText(manBD.traerPass(mailInfo.getText()));

				lblPrestamosActivos.setVisible(false);
				prestamosInfo.setVisible(false);

				aceptarUpdate.setVisible(true);
				cancelarUpdate.setVisible(true);
			}
		});

		// Oculta los campos para modificar info
		cancelarUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nombreInfo.setVisible(true);
				updateNombre.setVisible(false);

				apellidoInfo.setVisible(true);
				updateApellido.setVisible(false);

				ciInfo.setVisible(true);
				updateCi.setVisible(false);

				mailInfo.setVisible(true);
				updateMail.setVisible(false);

				prestamosInfo.setVisible(true);

				lblPassword_1.setVisible(false);
				updatePass.setVisible(false);

				lblPrestamosActivos.setVisible(true);
				prestamosInfo.setVisible(true);

				aceptarUpdate.setVisible(false);
				cancelarUpdate.setVisible(false);
			}
		});

		// Acepta el update
		aceptarUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String mail = list.getSelectedValue();

					Usuario usuario = man.consultaUsuario(mail);

					man.modificarDatosUsuarios(usuario.getId(), Integer.valueOf(updateCi.getText()),
							updateNombre.getText(), updateApellido.getText(), updateMail.getText(),
							updatePass.getText());

					JOptionPane.showMessageDialog(null, "Datos modificados correctamente", "Mensaje del sistema",
							JOptionPane.PLAIN_MESSAGE);

					infoUser.setVisible(false);

					listModel = new DefaultListModel<>();
					list.setModel(listModel);

					ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
					String mailRefresh;

					for (int i = 0; usuarios.size() > i; i++) {
						mailRefresh = usuarios.get(i).getMail();
						listModel.add(i, mailRefresh);
					}

					list.setModel(listModel);

					nombreInfo.setVisible(true);
					updateNombre.setVisible(false);

					apellidoInfo.setVisible(true);
					updateApellido.setVisible(false);

					ciInfo.setVisible(true);
					updateCi.setVisible(false);

					mailInfo.setVisible(true);
					updateMail.setVisible(false);

					prestamosInfo.setVisible(true);

					lblPassword_1.setVisible(false);
					updatePass.setVisible(false);

					lblPrestamosActivos.setVisible(true);
					prestamosInfo.setVisible(true);

					aceptarUpdate.setVisible(false);
					cancelarUpdate.setVisible(false);

				} catch (Exception l) {
					JOptionPane.showMessageDialog(null, "Error al intentar modificar los datos. Verifique los campos.",
							"Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
					System.out.println(l);
				}

			}
		});

		// Panel alta usuario
		JPanel altaUsuario = new JPanel();
		altaUsuario.setBackground(SystemColor.text);
		altaUsuario.setBounds(0, 0, 900, 600);
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
		background.setBounds(0, 0, 900, 600);
		background.setIcon(new ImageIcon(Interface.class.getResource("/fondo-biblAnima.png")));
		altaUsuario.add(background);

		// Alta usuario
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = inputNombre.getText();
				String apellido = inputApellido.getText();
				String mail = inputMail.getText();
				@SuppressWarnings("deprecation")
				String pass = pAlta.getText();

				int ci = Integer.parseInt(inputCI.getText());
				int id = manBD.generarId();

				// SQL
				try {
					manBD.altaUsuarioDB(id, ci, nombre, apellido, mail, pass,
							String.valueOf(tipoUsuario.getSelectedItem()),
							String.valueOf(orientUsuario.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente a la base de datos.");

				} catch (Exception e1) {
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

		// Quitar o aniadir holder
		inputNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (inputNombre.getText().equals("Nombre")) {
					inputNombre.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (inputNombre.getText().equals("")) {
					inputNombre.setText("Nombre");
				}
			}
		});

		inputApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (inputApellido.getText().equals("Apellido")) {
					inputApellido.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (inputApellido.getText().equals("")) {
					inputApellido.setText("Apellido");
				}
			}
		});

		inputCI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (inputCI.getText().equals("CI del usuario")) {
					inputCI.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (inputCI.getText().equals("")) {
					inputCI.setText("CI del usuario");
				}
			}
		});

		inputMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (inputMail.getText().equals("Ej. usuario@anima.edu.uy")) {
					inputMail.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (inputMail.getText().equals("")) {
					inputMail.setText("Ej. usuario@anima.edu.uy");
				}
			}
		});

		// Switch para ver o no password
		mostrarPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mostrarPassword.isSelected() == true) {
					pAlta.setEchoChar((char) 0);
				} else if (mostrarPassword.isSelected() == false) {
					pAlta.setEchoChar('●');
				}
			}
		});

		// Elementos jcombobox de altausuario
		tipoUsuario.addItem("Estudiante");
		tipoUsuario.addItem("Profesor");
		tipoUsuario.addItem("Bibliotecario");

		orientUsuario.addItem("TIC");
		orientUsuario.addItem("ADM");
		orientUsuario.addItem("TICYADM");

		// Acciones

		// Menu
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(true);
				listadoUsuario.setVisible(false);
				libros.setVisible(false);

			}
		});

		btnListarUsuariosExistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoUsuario.setVisible(true);
				altaUsuario.setVisible(false);
				libros.setVisible(false);

				man.altaUsuario();

				listModel = new DefaultListModel<>();
				list.setModel(listModel);

				ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
				String mail;

				for (int i = 0; usuarios.size() > i; i++) {
					mail = usuarios.get(i).getMail();
					listModel.add(i, mail);
				}

				list.setModel(listModel);
			}
		});

		mntmListaDeLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				listadoUsuario.setVisible(false);
				altaUsuario.setVisible(false);
				libros.setVisible(true);
				
			}
		});
		
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface.this.dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});


		

		// Muestra info de usuario seleccionado
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getClickCount() == 1) {

					String mail = list.getSelectedValue();
					Usuario usuario = man.consultaUsuario(mail);

					infoUser.setVisible(true);
					nombreInfo.setText(usuario.getNombre());
					apellidoInfo.setText(usuario.getApellido());
					ciInfo.setText(String.valueOf(usuario.getCI()));
					mailInfo.setText(usuario.getMail());

				}
			}
		});

		// Se cargan todos los datos al iniciar el programa: usuarios, libros y prestamos.
			man.altaUsuario();
	
			listModel = new DefaultListModel<>();
	
			ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
			String mail;	
			
			for (int i = 0; usuarios.size() > i; i++) {
				mail = usuarios.get(i).getMail();
				listModel.add(i, mail);
			}
			
			man.traerLibrosBd();
			
			ArrayList<Libro> librosList = man.listarLibros();	
			
			listlibros = new DefaultTableModel();
			
			Object[] columns = {"Titulo", "Autor", "Edicion", "Ejemplares disponibles", "Codigo"};
			listlibros.setColumnIdentifiers(columns);
			table.setModel(listlibros);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			
			for(int i = 0; i < librosList.size(); i++) {
				Object [] row = new Object[5];
				
				row[0] = librosList.get(i).getTitulo();
				row[1] = librosList.get(i).getAutor();
				row[2] = librosList.get(i).getNroEdicion();
				row[3] = librosList.get(i).getHayEjemplarDisponible();
				row[4] = librosList.get(i).getAniCode();
				
				listlibros.addRow(row);
			} 
	}
}

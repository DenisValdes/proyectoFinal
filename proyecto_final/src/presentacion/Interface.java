package presentacion;

import logica.Libro;
import logica.Manejador;
import logica.Prestamo;
import logica.Usuario;
import persistencia.ManejadorBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;

public class Interface extends JFrame {

	private static final long serialVersionUID = 58957044995731644L;
	public JPanel princialPanel;
	public JTextField inputNombre;
	public JTextField inputSearch;
	public JTextField inputApellido;
	public JTextField inputMail;
	public JTextField inputCI;
	private JPasswordField pAlta;
	private JList<String> listUsers;

	DefaultListModel<String> listModel;
	DefaultTableModel listlibros;

	ArrayList<Usuario> usuarios;
	private JTextField updateNombre;
	private JTextField updateApellido;
	private JTextField updateCi;
	private JTextField updateMail;
	private JTextField updatePass;
	private JTable table;
	private JTextField searchLibro;
	private JTextField searchUsers;
	private JTable tablePrestamos;
	private JTextField textField;

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

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado de libros");

		librosContent.add(mntmNewMenuItem_3);

		JMenuItem mntmListaDeLibros = new JMenuItem("Crear libro");

		librosContent.add(mntmListaDeLibros);

		JMenu prestamosContent = new JMenu("Prestamos");
		menuBar.add(prestamosContent);

		JMenuItem altaPrestamo = new JMenuItem("Dar de alta un prestamo");

		prestamosContent.add(altaPrestamo);

		JMenuItem listadoPrestamos = new JMenuItem("Historial de prestamos");

		prestamosContent.add(listadoPrestamos);

		JButton Logout = new JButton("Desconectar");
		Logout.setBackground(Color.WHITE);

		menuBar.add(Logout);

		// Panel Content
		princialPanel = new JPanel();
		princialPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(princialPanel);
		princialPanel.setLayout(null);

		// Alta prestamos
		JPanel altaPrestamos = new JPanel();
		altaPrestamos.setBounds(0, 0, 900, 600);
		princialPanel.add(altaPrestamos);
		altaPrestamos.setLayout(null);
		altaPrestamos.setVisible(false);

		JScrollPane scrollbar = new JScrollPane();
		scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar.setBounds(40, 197, 380, 357);
		altaPrestamos.add(scrollbar);

		JList<String> userPrestamos = new JList<String>();
		scrollbar.setViewportView(userPrestamos);

		searchUsers = new JTextField();

		searchUsers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUsers.setText("Ingrese CI del usuario...");
		searchUsers.setBounds(627, 37, 192, 33);
		altaPrestamos.add(searchUsers);
		searchUsers.setColumns(10);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Interface.class.getResource("/search.png")));
		button.setBounds(829, 37, 36, 33);
		altaPrestamos.add(button);

		JPanel prestamoInfo = new JPanel();
		prestamoInfo.setBorder(UIManager.getBorder("ComboBox.border"));
		prestamoInfo.setBounds(479, 197, 386, 357);
		altaPrestamos.add(prestamoInfo);
		prestamoInfo.setLayout(null);
		prestamoInfo.setVisible(false);

		JDateChooser fechaPrestamo = new JDateChooser();
		fechaPrestamo.setBounds(68, 134, 231, 28);
		prestamoInfo.add(fechaPrestamo);

		JDateChooser fechaDevolucion = new JDateChooser();
		fechaDevolucion.setBounds(68, 204, 231, 28);
		prestamoInfo.add(fechaDevolucion);

		JComboBox<String> librosPrestamo = new JComboBox<String>();
		librosPrestamo.setBounds(68, 273, 231, 28);
		prestamoInfo.add(librosPrestamo);

		JLabel lblInformacionDelPrestamo = new JLabel("Informacion del prestamo");
		lblInformacionDelPrestamo.setFont(new Font("Alef", Font.PLAIN, 25));
		lblInformacionDelPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionDelPrestamo.setBounds(47, 42, 303, 22);
		prestamoInfo.add(lblInformacionDelPrestamo);

		JButton aceptarPrestamo = new JButton("Aceptar");

		aceptarPrestamo.setBounds(137, 324, 102, 22);
		prestamoInfo.add(aceptarPrestamo);

		JLabel lblSeleccioneLibro = new JLabel("Seleccione libro");
		lblSeleccioneLibro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneLibro.setBounds(55, 248, 119, 14);
		prestamoInfo.add(lblSeleccioneLibro);

		JLabel lblSeleccioneFechaDe = new JLabel("Seleccione fecha de devolucion");
		lblSeleccioneFechaDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneFechaDe.setBounds(55, 179, 201, 14);
		prestamoInfo.add(lblSeleccioneFechaDe);

		JLabel lblSeleccioneFechaDe_1 = new JLabel("Seleccione fecha de solicitud");
		lblSeleccioneFechaDe_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneFechaDe_1.setBounds(55, 109, 201, 14);
		prestamoInfo.add(lblSeleccioneFechaDe_1);

		JLabel lblAltaDePrestamos = new JLabel("Alta de prestamos");
		lblAltaDePrestamos.setFont(new Font("Alef", Font.BOLD, 20));
		lblAltaDePrestamos.setBounds(351, 39, 192, 27);
		altaPrestamos.add(lblAltaDePrestamos);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Interface.class.getResource("/listadoU.png")));
		label_2.setBounds(0, 0, 900, 600);
		altaPrestamos.add(label_2);
		

		// Historial de prestamos
		JPanel historialPrestamos = new JPanel();
		historialPrestamos.setBounds(0, 0, 900, 600);
		princialPanel.add(historialPrestamos);
		historialPrestamos.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(45, 182, 813, 381);
		historialPrestamos.add(scrollPane_2);

		tablePrestamos = new JTable();
		scrollPane_2.setViewportView(tablePrestamos);
		historialPrestamos.setVisible(false);

		JLabel lblHistorialDePrestamos = new JLabel("Historial de prestamos");
		lblHistorialDePrestamos.setFont(new Font("Alef", Font.BOLD, 25));
		lblHistorialDePrestamos.setBounds(302, 117, 288, 54);
		historialPrestamos.add(lblHistorialDePrestamos);

		textField = new JTextField();
		textField.setBounds(628, 40, 196, 28);
		historialPrestamos.add(textField);
		textField.setColumns(10);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Interface.class.getResource("/search.png")));
		button_1.setBounds(829, 40, 39, 28);
		historialPrestamos.add(button_1);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Interface.class.getResource("/listaLibros.png")));
		label_3.setBounds(0, 0, 900, 600);
		historialPrestamos.add(label_3);

		// Lista de libros
		JPanel libros = new JPanel();
		libros.setBounds(0, 0, 900, 600);
		princialPanel.add(libros);
		libros.setLayout(null);
		libros.setVisible(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(38, 209, 825, 365);
		libros.add(scrollPane_1);

		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table);

		JButton refrescarLibros = new JButton("Listar todo");

		refrescarLibros.setBounds(38, 179, 184, 30);
		libros.add(refrescarLibros);
		table.setBackground(Color.WHITE);
		table.setRowHeight(30);

		searchLibro = new JTextField();
		searchLibro.setBounds(635, 39, 176, 30);
		libros.add(searchLibro);
		searchLibro.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Interface.class.getResource("/search.png")));
		btnNewButton.setBounds(826, 39, 30, 30);
		libros.add(btnNewButton);

		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibros.setBounds(38, 133, 58, 35);
		libros.add(lblLibros);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Interface.class.getResource("/listaLibros.png")));
		label_1.setBounds(0, 0, 900, 600);
		libros.add(label_1);

		// Vista listado de usuarios
		JPanel listadoUsuario = new JPanel();
		listadoUsuario.setToolTipText("");
		listadoUsuario.setBackground(Color.WHITE);
		listadoUsuario.setBounds(0, 0, 900, 600);
		princialPanel.add(listadoUsuario);
		listadoUsuario.setVisible(false);
		listadoUsuario.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Listado de usuarios");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(332, 32, 242, 34);
		listadoUsuario.add(lblNewLabel_2);

		inputSearch = new JTextField();
		inputSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));

		inputSearch.setText("Ingrese CI de usuario...");
		inputSearch.setToolTipText("");
		inputSearch.setBounds(631, 41, 183, 25);
		listadoUsuario.add(inputSearch);
		inputSearch.setColumns(10);

		JButton searchUser = new JButton("");
		searchUser.setIcon(new ImageIcon(Interface.class.getResource("/search.png")));

		searchUser.setBounds(824, 35, 34, 31);
		listadoUsuario.add(searchUser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(42, 194, 378, 358);
		listadoUsuario.add(scrollPane);

		listUsers = new JList<String>();
		scrollPane.setViewportView(listUsers);
		listUsers.setFont(new Font("Tahoma", Font.PLAIN, 15));

		listUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton refrescarLista = new JButton("Refrescar lista");
		refrescarLista.setFont(new Font("Tahoma", Font.PLAIN, 15));

		refrescarLista.setBounds(42, 563, 167, 26);
		listadoUsuario.add(refrescarLista);

		JPanel infoUser = new JPanel();
		infoUser.setBackground(SystemColor.info);
		infoUser.setBounds(483, 194, 378, 358);
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
		mailInfo.setBounds(83, 153, 244, 18);
		infoUser.add(mailInfo);

		JLabel prestamosInfo = new JLabel("");
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
		updateMail.setBounds(83, 153, 199, 20);
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

		JLabel lblMails = new JLabel("Mails");
		lblMails.setHorizontalAlignment(SwingConstants.LEFT);
		lblMails.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMails.setBounds(42, 149, 242, 34);
		listadoUsuario.add(lblMails);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Interface.class.getResource("/listadoU.png")));
		label.setBounds(0, 0, 900, 600);
		listadoUsuario.add(label);

		// Panel alta usuario
		JPanel altaUsuario = new JPanel();
		altaUsuario.setBackground(SystemColor.text);
		altaUsuario.setBounds(0, 0, 900, 600);
		princialPanel.add(altaUsuario);
		altaUsuario.setLayout(null);
		altaUsuario.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Ingrese aqu\u00ED los datos solicitados");
		lblNewLabel_1.setBounds(526, 76, 328, 32);
		lblNewLabel_1.setFont(new Font("Alef", Font.PLAIN, 22));
		altaUsuario.add(lblNewLabel_1);

		inputNombre = new JTextField();
		inputNombre.setBounds(526, 144, 157, 23);
		inputNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputNombre.setText("Nombre");
		altaUsuario.add(inputNombre);
		inputNombre.setColumns(10);

		inputApellido = new JTextField();
		inputApellido.setBounds(697, 144, 157, 23);
		inputApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputApellido.setText("Apellido");
		inputApellido.setColumns(10);
		altaUsuario.add(inputApellido);

		inputMail = new JTextField();
		inputMail.setBounds(526, 234, 328, 23);

		inputMail.setText("Ej. usuario@anima.edu.uy");
		inputMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputMail.setColumns(10);
		altaUsuario.add(inputMail);

		inputCI = new JTextField();
		inputCI.setBounds(526, 178, 328, 23);
		inputCI.setText("CI del usuario");
		inputCI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputCI.setColumns(10);
		altaUsuario.add(inputCI);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(526, 212, 46, 23);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		altaUsuario.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(526, 268, 74, 32);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		altaUsuario.add(lblPassword);

		JCheckBox mostrarPassword = new JCheckBox("Mostrar password");

		mostrarPassword.setBounds(526, 331, 137, 23);
		altaUsuario.add(mostrarPassword);

		JComboBox<String> tipoUsuario = new JComboBox<String>();
		tipoUsuario.setBounds(526, 386, 118, 23);
		altaUsuario.add(tipoUsuario);

		JLabel lblOrientacion = new JLabel("Orientacion a la que pertenece el usuario");
		lblOrientacion.setBounds(526, 429, 328, 23);
		lblOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		altaUsuario.add(lblOrientacion);

		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTipoDeUsuario.setBounds(526, 361, 328, 23);
		altaUsuario.add(lblTipoDeUsuario);

		JComboBox<String> orientUsuario = new JComboBox<String>();
		orientUsuario.setBounds(526, 453, 118, 23);
		altaUsuario.add(orientUsuario);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Alef", Font.PLAIN, 15));
		btnAceptar.setBounds(709, 503, 89, 23);
		altaUsuario.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.setFont(new Font("Alef", Font.PLAIN, 14));
		btnCancelar.setBounds(583, 503, 89, 23);
		altaUsuario.add(btnCancelar);

		pAlta = new JPasswordField();
		pAlta.setBounds(526, 301, 328, 23);
		altaUsuario.add(pAlta);

		JLabel background = new JLabel("");
		background.setBounds(0, 0, 900, 600);
		background.setIcon(new ImageIcon(Interface.class.getResource("/fondo-biblAnima.png")));
		altaUsuario.add(background);

		// Acciones

		// Menu
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(true);
				listadoUsuario.setVisible(false);
				libros.setVisible(false);
				historialPrestamos.setVisible(false);
				altaPrestamos.setVisible(false);
			}
		});

		btnListarUsuariosExistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoUsuario.setVisible(true);
				altaUsuario.setVisible(false);
				libros.setVisible(false);
				historialPrestamos.setVisible(false);
				altaPrestamos.setVisible(false);

				man.altaUsuario();

				listModel = new DefaultListModel<>();
				listUsers.setModel(listModel);

				ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
				String mail;

				for (int i = 0; usuarios.size() > i; i++) {
					mail = usuarios.get(i).getMail();
					listModel.add(i, mail);
				}

				listUsers.setModel(listModel);
			}
		});

		mntmListaDeLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listadoUsuario.setVisible(false);
				altaUsuario.setVisible(false);
				libros.setVisible(true);
				altaPrestamos.setVisible(false);
				historialPrestamos.setVisible(false);

			}
		});

		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface.this.dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});

		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				altaPrestamo.setVisible(false);
				altaUsuario.setVisible(false);
				libros.setVisible(true);
				historialPrestamos.setVisible(false);
				listadoUsuario.setVisible(false);
			}
		});

		// Listado usuarios
		// El programa inicia con esta vista
		listadoUsuario.setVisible(true);

		man.altaUsuario();

		listModel = new DefaultListModel<>();
		listUsers.setModel(listModel);

		ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
		String mail;

		for (int i = 0; usuarios.size() > i; i++) {
			mail = usuarios.get(i).getMail();
			listModel.add(i, mail);
		}

		listUsers.setModel(listModel);

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
					listUsers.setModel(listModel);

					String mail;

					mail = usuario.getMail();
					listModel.add(0, mail);

					listUsers.setModel(listModel);

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
				listUsers.setModel(listModel);

				ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
				String mail;

				for (int i = 0; i < usuarios.size(); i++) {
					mail = usuarios.get(i).getMail();
					listModel.add(i, mail);
				}

				listUsers.setModel(listModel);

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

					String mail = listUsers.getSelectedValue();

					Usuario usuario = man.consultaUsuario(mail);

					man.modificarDatosUsuarios(usuario.getId(), Integer.valueOf(updateCi.getText()),
							updateNombre.getText(), updateApellido.getText(), updateMail.getText(),
							updatePass.getText());

					JOptionPane.showMessageDialog(null, "Datos modificados correctamente", "Mensaje del sistema",
							JOptionPane.PLAIN_MESSAGE);

					infoUser.setVisible(false);

					listModel = new DefaultListModel<>();
					listUsers.setModel(listModel);

					ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
					String mailRefresh;

					for (int i = 0; usuarios.size() > i; i++) {
						mailRefresh = usuarios.get(i).getMail();
						listModel.add(i, mailRefresh);
					}

					listUsers.setModel(listModel);

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

		// Muestra info de usuario seleccionado
		listUsers.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getClickCount() == 1) {

					String mail = listUsers.getSelectedValue();
					Usuario usuario = man.consultaUsuario(mail);

					int prestamos = man.devolverPrestamos(usuario.getId());

					infoUser.setVisible(true);
					nombreInfo.setText(usuario.getNombre());
					apellidoInfo.setText(usuario.getApellido());
					ciInfo.setText(String.valueOf(usuario.getCI()));
					mailInfo.setText(usuario.getMail());
					prestamosInfo.setText(String.valueOf(prestamos));

				}
			}
		});

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

		// Se cargan todos los datos al iniciar el programa: usuarios, libros y
		// prestamos.

		// Usuarios
		man.altaUsuario();

		listModel = new DefaultListModel<>();

		ArrayList<Usuario> usuarios1 = man.listarUsuariosExistentes();
		String mail1;

		for (int i = 0; usuarios1.size() > i; i++) {
			mail1 = usuarios1.get(i).getMail();
			listModel.add(i, mail1);
		}

		// Libros

		man.traerLibrosBd();

		ArrayList<Libro> librosList = man.listarLibros();

		DefaultTableModel listlibros = new DefaultTableModel();

		Object[] columns = { "Titulo", "Autor", "Edicion", "Ejemplares disponibles", "Codigo" };
		listlibros.setColumnIdentifiers(columns);

		for (int i = 0; i < librosList.size(); i++) {
			Object[] row = new Object[5];

			row[0] = librosList.get(i).getTitulo();
			row[1] = librosList.get(i).getAutor();
			row[2] = librosList.get(i).getNroEdicion();
			row[3] = librosList.get(i).getHayEjemplarDisponible();
			row[4] = librosList.get(i).getAniCode();

			listlibros.addRow(row);
		}

		// Se cargan los libros al JComboBox de prestamos
		for (int i = 0; i < librosList.size(); i++) {
			librosPrestamo.addItem(librosList.get(i).getAniCode());
		}

		// Listar prestamos
		listadoPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoUsuario.setVisible(false);
				altaUsuario.setVisible(false);
				altaPrestamos.setVisible(false);
				libros.setVisible(false);
				historialPrestamos.setVisible(true);

				man.altaPrestamo();

				ArrayList<Prestamo> prestamos = man.listarPrestamos();

				DefaultTableModel prestamoModel = new DefaultTableModel();

				Object[] columnsP = { "Fecha de solicitu", "Fecha de devolucion", "Estado", "Usuario",
						"Codigo del libro" };
				prestamoModel.setColumnIdentifiers(columnsP);

				for (int i = 0; i < prestamos.size(); i++) {
					Object[] row = new Object[5];

					row[0] = prestamos.get(i).getFechaSolicitado();
					row[1] = prestamos.get(i).getFechaDevolucion();

					if (prestamos.get(i).getDevuelto() == true) {
						row[2] = "Devuelto";
					}
					if (prestamos.get(i).getDevuelto() == false) {
						row[2] = "Sin devolver";
					}

					Usuario user = man.consultaUsuarioID(prestamos.get(i).getId_user());
					row[3] = user.getMail();
					row[4] = prestamos.get(i).getAniCode();

					prestamoModel.addRow(row);
				}
			}
		});

		man.altaPrestamo();

		ArrayList<Prestamo> prestamos = man.listarPrestamos();

		DefaultTableModel prestamoModel = new DefaultTableModel();

		Object[] columnsP = { "Fecha de solicitu", "Fecha de devolucion", "Estado", "Usuario", "Codigo del libro" };
		prestamoModel.setColumnIdentifiers(columnsP);

		for (int i = 0; i < prestamos.size(); i++) {
			Object[] row = new Object[5];

			row[0] = prestamos.get(i).getFechaSolicitado();
			row[1] = prestamos.get(i).getFechaDevolucion();

			if (prestamos.get(i).getDevuelto() == true) {
				row[2] = "Devuelto";
			}
			if (prestamos.get(i).getDevuelto() == false) {
				row[2] = "Sin devolver";
			}

			Usuario user = man.consultaUsuarioID(prestamos.get(i).getId_user());
			row[3] = user.getMail();
			row[4] = prestamos.get(i).getAniCode();

			prestamoModel.addRow(row);
		}
		altaPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPrestamos.setVisible(true);
				listadoUsuario.setVisible(false);
				libros.setVisible(false);
				historialPrestamos.setVisible(false);
				altaUsuario.setVisible(false);

			}
		});
		tablePrestamos.setModel(prestamoModel);
		table.setModel(listlibros);
		
		
		// buscar user en altaprestamos
				searchUsers.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if (searchUsers.getText().equals("Ingrese CI del usuario...")) {
							searchUsers.setText("");
						} else if (searchUsers.getText().equals("")) {
							searchUsers.setText("Ingrese CI del usuario...");
						}
					}
				});

				// Aceptar prestamo

				aceptarPrestamo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Usuario usuario = man.consultaUsuario(userPrestamos.getSelectedValue());

						System.out.println(man.devolverPrestamos(usuario.getId()));

						if (man.devolverPrestamos(usuario.getId()) > 3) {

							System.out.println(man.devolverPrestamos(usuario.getId()));
							JOptionPane.showMessageDialog(null, "Limite de prestamos en paralelo alcanzado",
									"Mensaje del sistema", JOptionPane.ERROR_MESSAGE);

						} else {

							try {
								int id = manBD.generarIdPrestamo();
								String fecha_solicitud = fechaPrestamo.getDate().toString();
								String fecha_devolucion = fechaDevolucion.getDate().toString();

								int id_usuario = usuario.getId();
								Libro libro = man.consultaLibro(librosPrestamo.getSelectedItem().toString());
								String codigo_libro = libro.getAniCode();

								manBD.altaPrestamoDB(id, false, fecha_solicitud, fecha_devolucion, id_usuario, codigo_libro);
								JOptionPane.showMessageDialog(null, "Prestamo dado de alta", "Mensaje del sistema",
										JOptionPane.PLAIN_MESSAGE);
								prestamoInfo.setVisible(false);

								int incremento_prestamo = man.devolverPrestamos(id_usuario) + 1;
								manBD.incrementarPrestamo(id_usuario, incremento_prestamo);
							} catch (Exception r) {
								System.out.println(r);
							}
						}

					}
				});

				userPrestamos.setModel(listModel);

				userPrestamos.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						evt.getSource();
						if (evt.getClickCount() == 1) {

							prestamoInfo.setVisible(true);

						}
					}
				});
		
	}
}

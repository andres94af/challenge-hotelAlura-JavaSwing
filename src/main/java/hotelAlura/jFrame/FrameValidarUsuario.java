package hotelAlura.jFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelAlura.controllers.Controllers;
import hotelAlura.dao.UsuarioDAO;
import hotelAlura.factory.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Toolkit;


public class FrameValidarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private Connection con = null;

	public FrameValidarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Cursos\\Alura Latam\\05-JAVA\\eclipse-workspace\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\aH-40px.png"));
		con = new ConnectionFactory().recibeConeccion();
		UsuarioDAO usuarioDao = new UsuarioDAO(con);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Hotel Alura - Inicio de sesión");
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Bienvenido al Hotel Alura");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 419, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Logueese por favor");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 48, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 81, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 419, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 13, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 84, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 122, SpringLayout.NORTH, contentPane);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);

		txtUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -1, SpringLayout.WEST, txtUsuario);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtUsuario, 13, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsuario, 173, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtUsuario, 41, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtUsuario, 334, SpringLayout.WEST, contentPane);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setLabelFor(txtUsuario);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Contraseña:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 22, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 65, SpringLayout.WEST, contentPane);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2_1);

		txtContraseña = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -11, SpringLayout.WEST, txtContraseña);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtContraseña, 90, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtContraseña, 60, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtContraseña, 173, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtContraseña, 334, SpringLayout.WEST, contentPane);
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setLabelFor(txtContraseña);
		contentPane.add(txtContraseña);

		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -41, SpringLayout.NORTH, btnIniciarSesion);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnIniciarSesion, 208, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnIniciarSesion, 161, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnIniciarSesion, -30, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnIniciarSesion, -149, SpringLayout.EAST, contentPane);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String contraseña = new String(txtContraseña.getPassword());
				if (usuarioDao.validarUsuario(usuario, contraseña)) {
					Controllers controllers = new Controllers();
					dispose();
					controllers.verOpciones();
				}
				txtUsuario.setText("");
				txtContraseña.setText("");
			}
		});
		contentPane.add(btnIniciarSesion);
	}
	
}

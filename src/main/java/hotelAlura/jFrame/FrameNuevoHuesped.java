package hotelAlura.jFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelAlura.dao.HuespedDAO;
import hotelAlura.dao.ReservaDAO;
import hotelAlura.factory.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Toolkit;

public class FrameNuevoHuesped extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre, txtApellido, txtFechaNacimiento, txtNacionalidad, txtTelefono;
	private Connection con = null;

	public FrameNuevoHuesped() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Cursos\\Alura Latam\\05-JAVA\\eclipse-workspace\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\aH-40px.png"));
		con = new ConnectionFactory().recibeConeccion();
		setResizable(false);
		setTitle("Hotel Alura - Nuevo huesped");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Datos del huesped");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 424, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 196, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 386, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 83, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 108, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 196, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellido = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtApellido, 81, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtApellido, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtApellido, 108, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtApellido, 386, SpringLayout.WEST, contentPane);
		txtApellido.setColumns(10);
		contentPane.add(txtApellido);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha de nacimiento:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 121, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, 146, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, 196, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_2);
		
		txtFechaNacimiento = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFechaNacimiento, 119, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFechaNacimiento, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFechaNacimiento, 146, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFechaNacimiento, 386, SpringLayout.WEST, contentPane);
		txtFechaNacimiento.setColumns(10);
		contentPane.add(txtFechaNacimiento);
		
		JLabel lblNewLabel_2 = new JLabel(" (AAAA-MM-DD)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 143, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 157, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 314, SpringLayout.WEST, contentPane);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nacionalidad:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 159, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3, 184, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3, 196, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_3);
		
		txtNacionalidad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNacionalidad, 157, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNacionalidad, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNacionalidad, 184, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNacionalidad, 386, SpringLayout.WEST, contentPane);
		txtNacionalidad.setColumns(10);
		contentPane.add(txtNacionalidad);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_4, 197, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_4, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_4, 222, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_4, 196, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_4);
		
		txtTelefono = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTelefono, 195, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelefono, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtTelefono, 222, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelefono, 386, SpringLayout.WEST, contentPane);
		txtTelefono.setColumns(10);
		contentPane.add(txtTelefono);
		
		JButton btnSiguiente = new JButton("Siguiente");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSiguiente, 242, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSiguiente, 157, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSiguiente, 267, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSiguiente, 271, SpringLayout.WEST, contentPane);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuespedDAO huesped = new HuespedDAO(con);
				int id = huesped.nuevoHuesped(txtNombre, txtApellido, txtFechaNacimiento, txtNacionalidad, txtTelefono);
				dispose();
				ReservaDAO reserva = new ReservaDAO(con);
				reserva.abrirFrameReserva(id);
			}
		});
		contentPane.add(btnSiguiente);

	}
}

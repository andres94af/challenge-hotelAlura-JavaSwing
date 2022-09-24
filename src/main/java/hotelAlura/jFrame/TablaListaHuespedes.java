package hotelAlura.jFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelAlura.controllers.Controllers;
import hotelAlura.dao.HuespedDAO;
import hotelAlura.factory.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.SpringLayout;

public class TablaListaHuespedes extends JFrame {

	private static final long serialVersionUID = 1L;
	private Connection con = new ConnectionFactory().recibeConeccion();
	private JScrollPane scrollPane = new JScrollPane();
	private JTable tabla = new JTable();
	private JPanel contentPane;
	private JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5;
	private JTextField txtNombre, txtApellido, txtNacimiento, txtNacionalidad, txtTelefono;
	private JButton btnActualizar, btnModificar, btnCerrar, btnFiltrar;


	public TablaListaHuespedes() {
		HuespedDAO huesped = new HuespedDAO(con);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Cursos\\Alura Latam\\05-JAVA\\eclipse-workspace\\HotelAlura-Swing\\src\\imagenes\\aH-40px.png"));
		setTitle("Hotel Alura - Huespedes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 161, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 674, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("LISTADO DE HUESPEDES");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 684, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		contentPane.add(scrollPane);

		huesped.verListadoDeHuespedes(tabla, scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 284, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblNewLabel_2 = new JLabel("Apellido:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 222, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);

		txtApellido = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtApellido, 198, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtApellido, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtApellido, 221, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtApellido, 284, SpringLayout.WEST, contentPane);
		txtApellido.setColumns(10);
		contentPane.add(txtApellido);

		lblNewLabel_3 = new JLabel("Fecha de nacimiento:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 233, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 255, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 139, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);

		txtNacimiento = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNacimiento, 232, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNacimiento, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNacimiento, 255, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNacimiento, 284, SpringLayout.WEST, contentPane);
		txtNacimiento.setColumns(10);
		contentPane.add(txtNacimiento);

		lblNewLabel_4 = new JLabel("Nacionalidad:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 266, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 288, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);

		txtNacionalidad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNacionalidad, 265, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNacionalidad, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNacionalidad, 288, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNacionalidad, 284, SpringLayout.WEST, contentPane);
		txtNacionalidad.setColumns(10);
		contentPane.add(txtNacionalidad);

		lblNewLabel_5 = new JLabel("Telefono:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_5);

		txtTelefono = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTelefono, 299, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTelefono, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtTelefono, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTelefono, 284, SpringLayout.WEST, contentPane);
		txtTelefono.setColumns(10);
		contentPane.add(txtTelefono);

		btnFiltrar = new JButton("Filtrar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFiltrar, 213, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFiltrar, 356, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFiltrar, 466, SpringLayout.WEST, contentPane);
		btnFiltrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				huesped.filtrarHuespedes(txtNombre, txtApellido, txtNacimiento, txtNacionalidad, txtTelefono, tabla,
						scrollPane);
			}
		});
		contentPane.add(btnFiltrar);

		btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 247, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 356, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 466, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				huesped.modificarHuesped(txtNombre, txtApellido, txtNacimiento, txtNacionalidad, txtTelefono, tabla,
						scrollPane);
				tabla.addMouseListener(rellenarConClick);
			}
		});
		contentPane.add(btnModificar);

		btnActualizar = new JButton("Limpiar filtros");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnActualizar, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnActualizar, 557, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnActualizar, 674, SpringLayout.WEST, contentPane);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huesped.verListadoDeHuespedes(tabla, scrollPane);
			}
		});
		contentPane.add(btnActualizar);

		btnCerrar = new JButton("Cerrar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCerrar, 299, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCerrar, 587, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCerrar, 674, SpringLayout.WEST, contentPane);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers controllers = new Controllers();
				dispose();
				controllers.verOpciones();
			}
		});
		contentPane.add(btnCerrar);

		tabla.addMouseListener(rellenarConClick);
	}

	MouseAdapter rellenarConClick = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int fila = tabla.getSelectedRow();
			txtNombre.setText(tabla.getValueAt(fila, 1).toString());
			txtApellido.setText(tabla.getValueAt(fila, 2).toString());
			txtNacimiento.setText(tabla.getValueAt(fila, 3).toString());
			txtNacionalidad.setText(tabla.getValueAt(fila, 4).toString());
			txtTelefono.setText(tabla.getValueAt(fila, 5).toString());
		}
	};
}

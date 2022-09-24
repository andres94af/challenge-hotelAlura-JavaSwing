package hotelAlura.jFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelAlura.controllers.Controllers;
import hotelAlura.dao.ReservaDAO;
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

public class TablaListaReservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private Connection con = new ConnectionFactory().recibeConeccion();
	private JScrollPane scrollPane = new JScrollPane();
	private JTable tabla = new JTable();
	private JPanel contentPane;
	private JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,lblNewLabel_5,lblNewLabel_6;
	private JTextField txtIdReserva, txtIdHuesped, txtFechaEntrada, txtFechaSalida, txtValor, txtFormaPago;
	private JButton btnActualizar, btnModificar, btnEliminar, btnCerrar, btnFiltrar;

	public TablaListaReservas() {
		ReservaDAO reserva = new ReservaDAO(con);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Cursos\\Alura Latam\\05-JAVA\\eclipse-workspace\\HotelAlura-Swing\\src\\imagenes\\aH-40px.png"));
		setTitle("Hotel Alura - Reservas");
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

		JLabel lblNewLabel = new JLabel("LISTADO DE RESERVAS");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 684, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		contentPane.add(scrollPane);

		reserva.verListadoDeReservas(tabla, scrollPane);

		JLabel lblNewLabel_1 = new JLabel("ID Reserva:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		txtIdReserva = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIdReserva, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIdReserva, 117, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtIdReserva, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtIdReserva, 236, SpringLayout.WEST, contentPane);
		contentPane.add(txtIdReserva);
		txtIdReserva.setColumns(10);

		lblNewLabel_2 = new JLabel("ID Huesped:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 222, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);

		txtIdHuesped = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIdHuesped, 198, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIdHuesped, 117, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtIdHuesped, 221, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtIdHuesped, 236, SpringLayout.WEST, contentPane);
		txtIdHuesped.setColumns(10);
		contentPane.add(txtIdHuesped);

		lblNewLabel_3 = new JLabel("Fecha de entrada:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 233, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 255, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 139, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);

		txtFechaEntrada = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFechaEntrada, 232, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFechaEntrada, 117, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFechaEntrada, 255, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFechaEntrada, 236, SpringLayout.WEST, contentPane);
		txtFechaEntrada.setColumns(10);
		contentPane.add(txtFechaEntrada);

		lblNewLabel_4 = new JLabel("Fecha de salida:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 266, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 288, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 127, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);

		txtFechaSalida = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFechaSalida, 265, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFechaSalida, 117, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFechaSalida, 288, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFechaSalida, 236, SpringLayout.WEST, contentPane);
		txtFechaSalida.setColumns(10);
		contentPane.add(txtFechaSalida);

		lblNewLabel_5 = new JLabel("Valor:                 €");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 120, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_5);

		txtValor = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtValor, 299, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtValor, 117, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtValor, 322, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtValor, 236, SpringLayout.WEST, contentPane);
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		contentPane.add(txtValor);

		lblNewLabel_6 = new JLabel("Forma de pago:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 270, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 357, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_6);

		txtFormaPago = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFormaPago, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFormaPago, 365, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFormaPago, 189, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFormaPago, 484, SpringLayout.WEST, contentPane);
		txtFormaPago.setColumns(10);
		contentPane.add(txtFormaPago);

		btnFiltrar = new JButton("Filtrar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFiltrar, 374, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFiltrar, -91, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFiltrar, 0, SpringLayout.EAST, txtFormaPago);
		btnFiltrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reserva.filtrarReservas(txtIdReserva, txtIdHuesped, txtFechaEntrada, txtFechaSalida, txtValor, txtFormaPago, tabla, scrollPane);
				}
		});
		contentPane.add(btnFiltrar);

		btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 374, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnModificar, -57, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 0, SpringLayout.EAST, txtFormaPago);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reserva.modificarReserva(txtIdReserva, txtIdHuesped, txtFechaEntrada, txtFechaSalida, txtValor, txtFormaPago, tabla, scrollPane);
				tabla.addMouseListener(rellenarConClick);
			}
		});
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 374, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 0, SpringLayout.EAST, txtFormaPago);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reserva.eliminarReserva(tabla);
				reserva.verListadoDeReservas(tabla, scrollPane);
			}
		});
		contentPane.add(btnEliminar);

		btnActualizar = new JButton("Limpiar filtros");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnActualizar, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnActualizar, 557, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnActualizar, 674, SpringLayout.WEST, contentPane);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserva.verListadoDeReservas(tabla, scrollPane);
				txtIdReserva.setText("");
				txtIdHuesped.setText("");
				txtFechaEntrada.setText("");
				txtFechaSalida.setText("");
				txtValor.setText("");
				txtFormaPago.setText("");
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
			txtIdReserva.setText(tabla.getValueAt(fila, 0).toString());
			txtIdHuesped.setText(tabla.getValueAt(fila, 1).toString());
			txtFechaEntrada.setText(tabla.getValueAt(fila, 2).toString());
			txtFechaSalida.setText(tabla.getValueAt(fila, 3).toString());
			txtValor.setText(tabla.getValueAt(fila, 4).toString());
			txtFormaPago.setText(tabla.getValueAt(fila, 5).toString());
		}
	};

}
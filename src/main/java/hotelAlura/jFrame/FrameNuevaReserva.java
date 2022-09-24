package hotelAlura.jFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelAlura.controllers.Controllers;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpringLayout;
import java.awt.Toolkit;

public class FrameNuevaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaSalida;
	private Connection con;
	private JTextField txtFechaEntrada;

	public FrameNuevaReserva(int id) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Cursos\\Alura Latam\\05-JAVA\\eclipse-workspace\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\aH-40px.png"));
		con = new ConnectionFactory().recibeConeccion();
		ReservaDAO reservaDAO = new ReservaDAO(con);
		setTitle("Hotel Alura - Nueva reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Datos de la reserva");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, -5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 419, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha de entrada:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1, 184, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtFechaEntrada = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFechaEntrada, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFechaEntrada, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFechaEntrada, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFechaEntrada, 374, SpringLayout.WEST, contentPane);
		txtFechaEntrada.setColumns(10);
		contentPane.add(txtFechaEntrada);
		
		JLabel lblNewLabel_2 = new JLabel(" (AAAA-MM-DD)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 122, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 302, SpringLayout.WEST, contentPane);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha de salida:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, 184, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1_2);
		
		txtFechaSalida = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFechaSalida, 98, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFechaSalida, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtFechaSalida, 374, SpringLayout.WEST, contentPane);
		txtFechaSalida.setColumns(10);
		contentPane.add(txtFechaSalida);
		
		JLabel lblNewLabel_2_1 = new JLabel(" (AAAA-MM-DD)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 67, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, 81, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, 302, SpringLayout.WEST, contentPane);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Forma de pago:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 16, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_3, 0, SpringLayout.EAST, txtFechaEntrada);
		contentPane.add(lblNewLabel_1_3);
		
		JComboBox comboFormaPago = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboFormaPago, 150, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboFormaPago, 187, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboFormaPago, -50, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -14, SpringLayout.NORTH, comboFormaPago);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, -25, SpringLayout.NORTH, comboFormaPago);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtFechaSalida, -25, SpringLayout.NORTH, comboFormaPago);
		comboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Transferencia", "Débito", "Crédito"}));
		comboFormaPago.setSelectedIndex(0);
		contentPane.add(comboFormaPago);
		
		JButton btnFinalizar = new JButton("Finalizar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboFormaPago, -40, SpringLayout.NORTH, btnFinalizar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3, -40, SpringLayout.NORTH, btnFinalizar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFinalizar, 212, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFinalizar, 154, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFinalizar, -25, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFinalizar, -156, SpringLayout.EAST, contentPane);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaDAO.nuevaReserva(id, txtFechaEntrada, txtFechaSalida, comboFormaPago);
				dispose();
				Controllers contr = new Controllers();
				contr.verOpciones();
			}
		});
		contentPane.add(btnFinalizar);
	}
}

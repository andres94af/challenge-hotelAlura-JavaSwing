package hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hotelAlura.jFrame.FrameNuevaReserva;

public class ReservaDAO {

	private final Connection con;
	private static int valorPorDia = 30;

	// CONTRUCTOR INICIALIZA CONECCION
	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void abrirFrameReserva(int id) {
		JOptionPane.showMessageDialog(null, "Ahora, los datos para su reserva", "Hotel Alura",
				JOptionPane.INFORMATION_MESSAGE);
		FrameNuevaReserva reserva = new FrameNuevaReserva(id);
		reserva.setVisible(true);
	}
	
	public void nuevaReserva(int id, JTextField txtFechaEntrada, JTextField txtFechaSalida, JComboBox comboFormaPago) {
		try {
			final PreparedStatement st = con
					.prepareStatement("INSERT INTO RESERVAS(HUESPED, FECHA_ENTRADA,FECHA_SALIDA, VALOR, FORMA_PAGO) "
							+ "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, id);
			String fechaIngreso = txtFechaEntrada.getText();
			LocalDate fecha1 = LocalDate.parse(fechaIngreso);
			st.setString(2, fechaIngreso);

			String fechaSalida = txtFechaSalida.getText();
			LocalDate fecha2 = LocalDate.parse(fechaSalida);
			st.setString(3, fechaSalida);

			int dif = (int) ChronoUnit.DAYS.between(fecha1, fecha2);
			st.setInt(4, dif * valorPorDia);

			st.setString(5, comboFormaPago.getSelectedItem().toString());

			try (st) {
				st.execute();
				ResultSet resultSet = st.getGeneratedKeys();
				while (resultSet.next()) {
					int int1 = resultSet.getInt(1);
					JOptionPane.showMessageDialog(null, "Se creo correctamente su reserva con el ID nº: " + int1,
							"Hotel Alura", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void filtrarReservas(JTextField txtIdReserva, JTextField txtIdHuesped, JTextField txtFechaEntrada,
			JTextField txtFechaSalida, JTextField txtValor, JTextField txtFormaPago, JTable tabla, JScrollPane scrollPane) {
		String campoIdReserva = txtIdReserva.getText();
		String campoIdHuesped = txtIdHuesped.getText();
		String campoFechaEntrada = txtFechaEntrada.getText();
		String entrada = "";
		String campoFechaSalida = txtFechaSalida.getText();
		String salida = "";
		String campoValor = txtValor.getText();
		String campoFormaPago = txtFormaPago.getText();
		String where = "";

		if (!campoFechaEntrada.equals("")) {
			entrada = " or fecha_entrada=" + campoFechaEntrada.replace("-", "");
		}

		if (!campoFechaSalida.equals("")) {
			salida = " or fecha_salida=" + campoFechaSalida.replace("-", "");
		}

		if (!campoIdReserva.equals("") || !campoIdHuesped.equals("") || !campoFechaEntrada.equals("")
				|| !campoFechaSalida.equals("") || !campoValor.equals("") || !campoFormaPago.equals("")) {
			where = "WHERE id='" + campoIdReserva + "' or huesped='" + campoIdHuesped + "'" + entrada + "" + salida
					+ " or valor='" + campoValor + "' or forma_pago='" + campoFormaPago + "'";
		}

		String sql = "SELECT ID, HUESPED, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS " + where;

		try {
			DefaultTableModel modelo = new DefaultTableModel();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();

			modelo.addColumn("ID RESERVA");
			modelo.addColumn("HUESPED");
			modelo.addColumn("FECHA DE INGRESO");
			modelo.addColumn("FECHA DE SALIDA");
			modelo.addColumn("VALOR");
			modelo.addColumn("FORMA DE PAGO");

			int[] anchos = { 60, 50, 125, 125, 50, 80 };

			java.sql.ResultSetMetaData rsMd = rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();
			while (rs.next()) {
				Object[] filas = new Object[cantidadColumnas];
				for (int i = 0; i < cantidadColumnas; i++) {
					filas[i] = rs.getObject(i + 1);
				}
				modelo.addRow(filas);
			}
			tabla.setModel(modelo);
			for (int x = 0; x < modelo.getColumnCount(); x++) {
				tabla.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
				Class<?> col_class = tabla.getColumnClass(x);
				tabla.setDefaultEditor(col_class, null);
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		scrollPane.setViewportView(tabla);
		txtIdReserva.setText("");
		txtIdHuesped.setText("");
		txtFechaEntrada.setText("");
		txtFechaSalida.setText("");
		txtValor.setText("");
		txtFormaPago.setText("");

	}
	
	public void verListadoDeReservas(JTable tabla, JScrollPane scrollPane) {
		try {
			DefaultTableModel modelo = new DefaultTableModel();
			PreparedStatement ps = con.prepareStatement(
					"SELECT ID, HUESPED, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS ");
			ps.execute();
			ResultSet rs = ps.getResultSet();

			modelo.addColumn("ID RESERVA");
			modelo.addColumn("HUESPED");
			modelo.addColumn("FECHA DE INGRESO");
			modelo.addColumn("FECHA DE SALIDA");
			modelo.addColumn("VALOR");
			modelo.addColumn("FORMA DE PAGO");

			int[] anchos = { 60, 50, 125, 125, 50, 80 };

			java.sql.ResultSetMetaData rsMd = rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();
			while (rs.next()) {
				Object[] filas = new Object[cantidadColumnas];
				for (int i = 0; i < cantidadColumnas; i++) {
					filas[i] = rs.getObject(i + 1);
				}
				modelo.addRow(filas);
			}
			tabla.setModel(modelo);
			for (int x = 0; x < modelo.getColumnCount(); x++) {
				tabla.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
				Class<?> col_class = tabla.getColumnClass(x);
				tabla.setDefaultEditor(col_class, null);
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

		scrollPane.setViewportView(tabla);
	}

	public void eliminarReserva(JTable tabla) {
		
		int fila = tabla.getSelectedRow();
		if(fila==-1)return;
		
		Object valor = tabla.getValueAt(fila, 1);
		int id = (int) valor;
	
		int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro ode eliminar la reserva " + id + "?");
		if (JOptionPane.OK_OPTION == resp) {
			try {
				final PreparedStatement st = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID= ?");
				try (st) {
					st.setInt(1, id);
					st.execute();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar la reserva con ID: " + id, "Hotel Alura",
						JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
			JOptionPane.showMessageDialog(null,
					"Se elimino correctamente la reserva con ID: " + id + " y su huesped correspondiente",
					"Hotel Alura", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private int valorActualizadoReserva(int id) {
		int valor;
		try {
			final PreparedStatement st = con
					.prepareStatement("SELECT FECHA_ENTRADA, FECHA_SALIDA FROM RESERVAS WHERE ID =" + id);
			try (st) {
				st.execute();
				ResultSet resultSet = st.getResultSet();
				String fechaIngreso = "";
				String fechaSalida = "";
				while (resultSet.next()) {
					fechaIngreso = resultSet.getString("FECHA_ENTRADA");
					fechaSalida = resultSet.getString("FECHA_SALIDA");
				}
				LocalDate fecha1 = LocalDate.parse(fechaIngreso);
				LocalDate fecha2 = LocalDate.parse(fechaSalida);
				int dif = (int) ChronoUnit.DAYS.between(fecha1, fecha2);
				valor = dif * valorPorDia;

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return valor;
	}

	public void modificarReserva(JTextField txtIdReserva, JTextField txtIdHuesped, JTextField txtFechaEntrada,
			JTextField txtFechaSalida, JTextField txtValor,JTextField txtFormaPago ,JTable tabla, JScrollPane scrollPane) {

		int fila = tabla.getSelectedRow();
		if(fila==-1) {
			JOptionPane.showMessageDialog(null, "No selecciono ninguna fila para modificar", "Hotel Alura",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		Object valor = tabla.getValueAt(fila, 1);
		int id = (int) valor;
		String campoFormaPago = txtFormaPago.getText();
		String campoFechaEntrada = txtFechaEntrada.getText();
		String campoFechaSalida = txtFechaSalida.getText();
		String where = "";

		if (!campoFechaEntrada.equals("")|| !campoFechaSalida.equals("") || !campoFormaPago.equals("")) {
			where = "WHERE ID = " + id;
			String sql = "UPDATE RESERVAS SET FECHA_ENTRADA=?, FECHA_SALIDA=?, FORMA_PAGO= ? " + where;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, campoFechaEntrada);
				ps.setString(2, campoFechaSalida);
				ps.setString(3, ""+campoFormaPago+"");
				ps.execute();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "No se pudo modificar la reserva con ID: "+ id, "Hotel Alura",
						JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(ex);
			}
		}

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE RESERVAS SET VALOR=? " + where);
			ps.setInt(1, valorActualizadoReserva(id));
			ps.execute();		
		}catch(SQLException ex) {
			System.out.println("No se pudo actualizar el valor");
			throw new RuntimeException(ex);
		}

		JOptionPane.showMessageDialog(null, "Se modifico correctamente la reserva con ID: " + id, "Hotel Alura",
				JOptionPane.INFORMATION_MESSAGE);
		
		scrollPane.setViewportView(tabla);
		txtIdReserva.setText("");
		txtIdHuesped.setText("");
		txtFechaEntrada.setText("");
		txtFechaSalida.setText("");
		txtValor.setText("");
		txtFormaPago.setText("");

		verListadoDeReservas(tabla, scrollPane);
	}
}

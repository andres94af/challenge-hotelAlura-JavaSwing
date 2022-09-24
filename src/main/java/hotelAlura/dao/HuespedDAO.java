package hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HuespedDAO {

	private final Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public int nuevoHuesped(JTextField txtNombre, JTextField txtApellido, JTextField txtFechaNacimiento,
			JTextField txtNacionalidad, JTextField txtTelefono) {
		int resultado = 0;
		try {
			final PreparedStatement st = con
					.prepareStatement("INSERT INTO HUESPEDES(NOMBRE,APELLIDO,FECHA_NACIMIENTO,NACIONALIDAD,TELEFONO) "
							+ "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, txtNombre.getText());
			st.setString(2, txtApellido.getText());
			st.setString(3, txtFechaNacimiento.getText());
			st.setString(4, txtNacionalidad.getText());
			st.setString(5, txtTelefono.getText());

			try (st) {
				st.execute();
				ResultSet resultSet = st.getGeneratedKeys();
				while (resultSet.next()) {
					int int1 = resultSet.getInt(1);
					return resultado = int1;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

	public void verListadoDeHuespedes(JTable tabla, JScrollPane scrollPane) {
		try {
			DefaultTableModel modelo = new DefaultTableModel();
			PreparedStatement ps = con.prepareStatement(
					"SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO FROM HUESPEDES ");
			ps.execute();
			ResultSet rs = ps.getResultSet();

			modelo.addColumn("ID");
			modelo.addColumn("NOMBRE");
			modelo.addColumn("APELLIDO");
			modelo.addColumn("FECHA DE NACIMIENTO");
			modelo.addColumn("NACIONALIDAD");
			modelo.addColumn("TELEFONO");

			int[] anchos = { 25, 100, 100, 125, 95, 80 };

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

	public void filtrarHuespedes(JTextField txtNombre, JTextField txtApellido, JTextField txtNacimiento,
			JTextField txtNacionalidad, JTextField txtTelefono, JTable tabla, JScrollPane scrollPane) {
		String campoNombre = txtNombre.getText();
		String campoApellido = txtApellido.getText();
		String campoNacimiento = txtNacimiento.getText();
		String nac = "";
		String campoNacionalidad = txtNacionalidad.getText();
		String campoTelefono = txtTelefono.getText();
		String where = "";

		if (!campoNacimiento.equals("")) {
			nac = " or fecha_nacimiento=" + campoNacimiento.replace("-", "");
		}

		if (!campoNombre.equals("") || !campoApellido.equals("") || !campoNacimiento.equals("")
				|| !campoNacionalidad.equals("") || !campoTelefono.equals("")) {
			where = "WHERE nombre='" + campoNombre + "' or apellido='" + campoApellido + "'" + nac
					+ " or nacionalidad='" + campoNacionalidad + "' or telefono='" + campoTelefono + "'";
		}

		String sql = "SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO FROM HUESPEDES " + where;

		try {
			DefaultTableModel modelo = new DefaultTableModel();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();

			modelo.addColumn("ID");
			modelo.addColumn("NOMBRE");
			modelo.addColumn("APELLIDO");
			modelo.addColumn("FECHA DE NACIMIENTO");
			modelo.addColumn("NACIONALIDAD");
			modelo.addColumn("TELEFONO");

			int[] anchos = { 25, 100, 100, 125, 95, 80 };

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
		txtNombre.setText("");
		txtApellido.setText("");
		txtNacimiento.setText("");
		txtNacionalidad.setText("");
		txtTelefono.setText("");
	}

	public void modificarHuesped(JTextField txtNombre, JTextField txtApellido, JTextField txtNacimiento,
			JTextField txtNacionalidad, JTextField txtTelefono, JTable tabla, JScrollPane scrollPane) {
		int fila = tabla.getSelectedRow();
		Object id = tabla.getValueAt(fila, 0);
		String campoNombre = txtNombre.getText();
		String campoApellido = txtApellido.getText();
		String campoNacimiento = txtNacimiento.getText();
		String campoNacionalidad = txtNacionalidad.getText();
		String campoTelefono = txtTelefono.getText();
		String where = "";

		if (!campoNombre.equals("") || !campoApellido.equals("") || !campoNacimiento.equals("")
				|| !campoNacionalidad.equals("") || !campoTelefono.equals("")) {
			where = "WHERE ID = " + id;
			String sql = "UPDATE HUESPEDES SET NOMBRE=?, APELLIDO=?, FECHA_NACIMIENTO=?, NACIONALIDAD=?, TELEFONO=? "
					+ where;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "" + campoNombre + "");
				ps.setString(2, "" + campoApellido + "");
				ps.setString(3, campoNacimiento);
				ps.setString(4, "" + campoNacionalidad + "");
				ps.setString(5, "" + campoTelefono + "");
				ps.execute();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No selecciono ningun huesped a eliminar", "Hotel Alura",
					JOptionPane.ERROR_MESSAGE);
		}
		scrollPane.setViewportView(tabla);
		txtNombre.setText("");
		txtApellido.setText("");
		txtNacimiento.setText("");
		txtNacionalidad.setText("");
		txtTelefono.setText("");

		JOptionPane.showMessageDialog(null, "Se modifico correctamente el huesped con ID: " + id, "Hotel Alura",
				JOptionPane.INFORMATION_MESSAGE);

		verListadoDeHuespedes(tabla, scrollPane);

		scrollPane.setViewportView(tabla);
		txtNombre.setText("");
		txtApellido.setText("");
		txtNacimiento.setText("");
		txtNacionalidad.setText("");
		txtTelefono.setText("");
	}
}

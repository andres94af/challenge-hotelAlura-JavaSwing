package hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDAO {

	private Connection con;
	static int intentos = 0;

	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public boolean validarUsuario(String usuario, String contraseña) {
		try {
			final PreparedStatement st = con.prepareStatement("SELECT NOMBRE_USUARIO, CONTRASEÑA FROM USUARIOS");
			try (st) {
				st.execute();
				ResultSet resultSet = st.getResultSet();

				while (resultSet.next()) {
					String user = resultSet.getString("NOMBRE_USUARIO");
					String pass = resultSet.getString("CONTRASEÑA");

					if (usuario.equals(user) && contraseña.equals(pass)) {
						JOptionPane.showMessageDialog(null, "Se logueo correctamente!",
								  "Hotel Alura", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}
				}
				if (intentos == 2) {
					JOptionPane.showMessageDialog(null, "No puede seguir intentando.\n    Se cerrara el programa",
							  "Hotel Alura", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos. Intente de nuevo.","Hotel Alura", JOptionPane.WARNING_MESSAGE);
					intentos++;
					//valida de nuevo
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

}

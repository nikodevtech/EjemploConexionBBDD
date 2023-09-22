import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		final String url = "jdbc:postgresql://localhost/gestorBibliotecaPersonal";
		final String user = "postgres";
		final String password = "Ladepostgre0$";

		try {
		
			
			Properties p = new Properties();
			p.put("user", user);
			p.put("password",password);
			
			//Creamos el objeto connecion con la conexión a la BBDD con ayuda de Driver
			Connection con = DriverManager.getConnection(url, p);
			//Objeto Statement para poder ejecutar query a la BBDD
			Statement stmt = con.createStatement();
			//Preparamos la query
			String query = "SELECT * FROM gbp_almacen.gbp_alm_cat_libros";
			//Ejecutamos la query 
			ResultSet resultadoQuery = stmt.executeQuery(query); //La query devuelve un ResultSet (similar a un array)

			int id_libro = 0;
			String titulo = "";
			String autor = "";
			String isbn = "";
			int edicion = 0;

			//Mientras el ResultSet contenga algún resultado iteramos para mostrar los datos
			while (resultadoQuery.next()) { 

				id_libro = resultadoQuery.getInt("id_libro");
				titulo = resultadoQuery.getString("titulo");
				autor = resultadoQuery.getString("autor");
				isbn = resultadoQuery.getString("isbn");
				edicion = resultadoQuery.getInt("edicion");

			}

			//Mostramos por pantalla el resultado de la consulta
			JOptionPane.showMessageDialog(null,
					"---- Resultado Query ----\n" + "\nid_libro: " + id_libro + "\nTitulo del libro: " + titulo
							+ "\nAutor del libro: " + autor + "\nISBN del libro: " + isbn + "\nEdición: " + edicion);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

package ejemplo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {
	static SqlMapClient sqlMap;

	public static SqlMapClient getSqlMap() {
		return sqlMap;
	}

	public static void setSqlMap(SqlMapClient sqlMap) {
		Main.sqlMap = sqlMap;
	}

	public static void conexion() throws IOException {
		try {
			String resource = "ConfiguracionIBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			setSqlMap(SqlMapClientBuilder.buildSqlMapClient(reader));
		} catch (Exception e) {
			System.out.println("Error conexión BD: " + e);
		}
	}

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);

			int opcion;
			do {
				System.out.println("\n\n\t========================");
				System.out.println("\t|||| MENÚ PRINCIPAL ||||");
				System.out.println("\t========================\n");

				System.out.println("CAMPO.");
				System.out.println("\t1. Insertar campo.");
				System.out.println("\t2. Borrar campo.");
				System.out.println("\t3. Actualizar campo");
				System.out.println("\t4. Mostrar campos");

				System.out.println("\nTIPOS DE DEPORTES.");
				System.out.println("\t5. Insertar deporte.");
				System.out.println("\t6. Borrar deporte.");
				System.out.println("\t7. Actualizar deporte");
				System.out.println("\t8. Mostrar campos");

				System.out.println("\nRESERVAS.");
				System.out.println("\t9. Insertar reserva.");
				System.out.println("\t10. Ver reservas.");

				System.out.println("\n\t0.Salir del programa");

				System.out.print("\nEscribe el número de la opción (0-10): ");

				opcion = Integer.parseInt(s.nextLine());

				switch (opcion) {
				case 0:
					System.out.println("FIN DEL PROGRAMA.");
					break;
				case 1:
					insertarCampo();
					break;
				case 2:
					borrarCampo();
					break;
				case 3:
					actualizarCampo();
					break;
				case 4:
					mostrarCampo();
					break;
				case 5:
					insertarTipoDeporte();
					break;
				case 6:
					borrarTipoDeporte();
					break;
				case 7:
					actualizarTipoDeporte();
					break;
				case 8:
					mostrarTipoDeporte();
					break;
				case 9:
					insertarReserva();
					break;
				case 10:
					selectReservas();
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
					break;
				}

			} while (opcion != 0);

		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
	}

	// MÉTODOS DE CAMPO
	public static void insertarCampo() throws IOException, SQLException {
		try {
			conexion();
			Scanner s3 = new Scanner(System.in);
			// INSERTAR
			System.out.print("Introduce el nombre del campo: ");
			String nombre = s3.nextLine();
			System.out.print("Introduce el número de aforo: ");
			int aforo = s3.nextInt();

			Campo campo = new Campo();
			campo.setNombre(nombre);
			campo.setAforo(aforo);
			getSqlMap().insert("insertCampo", campo);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void borrarCampo() throws IOException, SQLException {
		try {
			conexion();
			Scanner s4 = new Scanner(System.in);

			List<Campo> campo = sqlMap.queryForList("getCampos", null);
			for (Campo c : campo) {
				System.out.println(c);
			}

			System.out.print("\nId del campo a borrar: ");
			int aforo = s4.nextInt();
			getSqlMap().delete("removeCampo", aforo);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede borrar, existe una reserva en este campo.");
		}

	}

	public static void actualizarCampo() throws IOException, SQLException {
		try {
			conexion();
			Scanner s7 = new Scanner(System.in);
			List<Campo> campo = sqlMap.queryForList("getCampos", null);
			for (Campo c : campo) {
				System.out.println(c);
			}
			System.out.print("\nId del campo a cambiar: ");
			int idCampo = Integer.parseInt(s7.nextLine());

			Integer claveCampo = new Integer(idCampo);
			Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);

			System.out.print("Introduce el nuevo nombre del campo: ");
			String nombre = s7.nextLine();
			System.out.print("Introduce el nuevo aforo del campo: ");
			int aforo = s7.nextInt();
			campoModif.setNombre(nombre);
			campoModif.setAforo(aforo);
			getSqlMap().update("updateCampo", campoModif);

			System.out.println("Campo Actualizado");

		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e);
		}
	}

	private static void mostrarCampo() throws SQLException, IOException {
		conexion();

		List<Campo> campo = sqlMap.queryForList("getCampos", null);
		for (Campo c : campo) {
			System.out.println(c);
		}
	}

	// MÉTODOS DE TIPODEPORTE
	public static void insertarTipoDeporte() throws IOException, SQLException {
		try {
			conexion();
			Scanner s4 = new Scanner(System.in);
			// INSERTAR
			System.out.print("Introduce el nombre del deporte: ");
			String nombre = s4.nextLine();

			TipoDeporte deporte = new TipoDeporte();
			deporte.setNombre(nombre);
			getSqlMap().insert("insertTipoDeporte", deporte);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void borrarTipoDeporte() throws IOException, SQLException {
		try {
			conexion();
			Scanner s5 = new Scanner(System.in);

			List<TipoDeporte> tipoDeporte = sqlMap.queryForList("getTipoDeportes", null);
			for (TipoDeporte t : tipoDeporte) {
				System.out.println(t);
			}

			System.out.print("\nId del deporte a borrar: ");
			int idDeporte = s5.nextInt();
			getSqlMap().delete("removeTipoDeporte", idDeporte);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: No se puede borrar, existe una reserva con este deporte!.");
		}
	}

	public static void actualizarTipoDeporte() throws IOException, SQLException {
		try {
			conexion();

			Scanner s6 = new Scanner(System.in);

			List<TipoDeporte> tipoDeporte = sqlMap.queryForList("getTipoDeportes", null);
			for (TipoDeporte t : tipoDeporte) {
				System.out.println(t);
			}

			System.out.print("\nId del deporte a cambiar: ");
			int idDeporte = Integer.parseInt(s6.nextLine());

			Integer claveDeporte = new Integer(idDeporte);
			TipoDeporte deporteModif = (TipoDeporte) sqlMap.queryForObject("getTipoDeporte", claveDeporte);

			System.out.print("Introduce el nuevo nombre del deporte: ");
			String nombre = s6.nextLine();
			deporteModif.setNombre(nombre);

			getSqlMap().update("updateTipoDeporte", deporteModif);

			System.out.println("Deporte Actualizado");

		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e);
		}
	}

	private static void mostrarTipoDeporte() throws SQLException, IOException {
		conexion();

		List<TipoDeporte> tipoDeporte = sqlMap.queryForList("getTipoDeportes", null);
		for (TipoDeporte t : tipoDeporte) {
			System.out.println(t);
		}
	}

	// MÉTODOS DE RESERVAS
	public static void insertarReserva() throws IOException, SQLException {
		try {
			conexion();
			Scanner s8 = new Scanner(System.in);
			// INSERTAR
			System.out.print("Introduce el nombre de la reserva: ");
			String nombre = s8.nextLine();

			System.out.print("Introduce la fecha de la reserva: ");
			String fecha = s8.nextLine();

			System.out.print("Hora Inicio: ");
			String horaIncio = s8.nextLine();

			System.out.print("Hora Fin: ");
			String horaFin = s8.nextLine();

			System.out.print("Id del deporte: ");
			int idDeporte = Integer.parseInt(s8.nextLine());

			System.out.print("Id del campo: ");
			int idCampo = Integer.parseInt(s8.nextLine());

			Reserva reserva = new Reserva();
			reserva.setNombre(nombre);
			reserva.setFecha(fecha);
			reserva.setHoraInicio(horaIncio);
			reserva.setHoraFin(horaFin);
			reserva.setIdCampo(idCampo);
			reserva.setIdDeporte(idDeporte);

			getSqlMap().insert("insertReserva", reserva);

		} catch (Exception e) {
			System.out.println("ERROR, intentelo de nuevo.");
		}
	}

	// SELECT
	private static void selectReservas() throws SQLException, IOException {
		conexion();

		List<Reserva> reserva = sqlMap.queryForList("getReservas", null);
		String mostrarReservas = "";
		for (Reserva r : reserva) {
			mostrarReservas += r + "\n";
		}
		JOptionPane.showMessageDialog(null, mostrarReservas);
	}
}

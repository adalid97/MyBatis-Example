package ejemplo;

public class Reserva {
	private int idReserva;
	private String nombre;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	private int idCampo;
	private int idDeporte;

	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombre, String fecha, String horaInicio, String horaFin, int idCampo,
			int idDeporte) {
		super();
		this.idReserva = idReserva;
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idCampo = idCampo;
		this.idDeporte = idDeporte;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Reserva Número " + idReserva + "\n\tnombre = " + nombre + "\n\tfecha = " + fecha + "\n\thoraInicio = "
				+ horaInicio + "\n\thoraFin = " + horaFin + "\n\tidCampo = " + idCampo + "\n\tidDeporte = " + idDeporte;
	}

}

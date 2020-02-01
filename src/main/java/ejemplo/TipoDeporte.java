package ejemplo;

public class TipoDeporte {

	private int idDeporte;
	private String nombre;

	public TipoDeporte() {

	}

	public TipoDeporte(int idDeporte, String nombre) {
		super();
		this.idDeporte = idDeporte;
		this.nombre = nombre;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "idDeporte = " + idDeporte + "\n\tnombre = " + nombre;
	}

}

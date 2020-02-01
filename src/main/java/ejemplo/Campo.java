package ejemplo;

public class Campo {
	private int idCampo;
	private String nombre;
	private int aforo;

	public Campo() {
	}

	public Campo(int idCampo, String nombre, int aforo) {
		this.idCampo = idCampo;
		this.nombre = nombre;
		this.aforo = aforo;
	}

	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	@Override
	public String toString() {
		return "idCampo = " + idCampo + "\n\tnombre = " + nombre + "\n\taforo = " + aforo;
	}

}

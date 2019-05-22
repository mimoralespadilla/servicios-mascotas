package tutorial.ejemplo.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mascotas")
public class MascotasModelo {
	@Id
	public ObjectId _id;

	public String nombre;
	public String especie;
	public String mezcla;
	public int edad;
	public String venta;

	// Constructores

	public MascotasModelo() {
	}

	public MascotasModelo(ObjectId _id, String nombre, String especie, String mezcla, int edad, String venta) {

		this._id = _id;
		this.nombre = nombre;
		this.especie = especie;
		this.mezcla = mezcla;
		this.edad = edad;
		this.venta = venta;
	}

	public String get_Id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspcie(String especie) {
		this.especie = especie;
	}

	public String getMezcla() {
		return mezcla;
	}

	public void setMezcla(String mezcla) {
		this.mezcla = mezcla;
	}

	public int getEdad() {
		return edad;
	}

	public String getVenta() {
		return venta;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setVenta(String venta) {
		this.venta = venta;
	}

}

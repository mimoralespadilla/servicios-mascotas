package tutorial.ejemplo.servicio;

import java.util.List;

import org.bson.types.ObjectId;
import tutorial.ejemplo.bean.MascotasModelo;

public interface MascotasService {
	MascotasModelo findById(ObjectId _id);

	List<MascotasModelo> findAll();

	List<MascotasModelo> findByNombre(String nombre);

	List<MascotasModelo> findByNombreAndEspecie(String especie, String mezcla);

	MascotasModelo createMascota(MascotasModelo mascota);

	void deleteMascota(ObjectId _id);

	String comprobarNombre(String nombre);
}

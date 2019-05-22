package tutorial.ejemplo.repositorio;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.ejemplo.bean.MascotasModelo;

public interface MascotasRepositorio extends MongoRepository<MascotasModelo, String> {

	MascotasModelo findBy_id(ObjectId _id);
	List<MascotasModelo> findBynombre(String nombre);
	List<MascotasModelo> findByespecie(String especie);
	List<MascotasModelo> findBymezcla(String mezcla);
	List<MascotasModelo> findByEspecieAndMezcla(String especie,String mezcla);
}

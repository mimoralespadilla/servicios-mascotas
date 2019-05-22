package tutorial.ejemplo.controlador;

import java.util.List;

import javax.validation.Valid;

//import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoException;

import tutorial.ejemplo.bean.MascotasModelo;
import tutorial.ejemplo.servicio.MascotasService;

@RestController
@RequestMapping("/mascotas")
public class MascotasControlador {

	@Autowired
	private MascotasService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody MascotasModelo getPetById(@PathVariable("id") ObjectId id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<MascotasModelo> getAllMascotas() {
		return service.findAll();
	}

	@RequestMapping(value = "/nombre/{nombre}", method = RequestMethod.GET)
	public List<MascotasModelo> getMascotaByName(@PathVariable("nombre") String nombre) {
		return service.findByNombre(nombre);
	}

	@RequestMapping(value = "/nombre y especie/{especie} y {mezcla}", method = RequestMethod.GET)
	public List<MascotasModelo> findByNombreAndEspecie(@PathVariable("especie") String especie,
			@PathVariable("mezcla") String mezcla) {
		try {
			return service.findByNombreAndEspecie(especie, mezcla);
		} catch (MongoException e) {
			throw new MongoException("Error al insertar una especie/mezcla.");
		}
	}

	@RequestMapping(value = "/crear mascota/", method = RequestMethod.POST)
	public MascotasModelo createMascota(@Valid @RequestBody MascotasModelo mascota) {
		service.createMascota(mascota);
		return mascota;
	}

	@RequestMapping(value = "/Borrar mascota/{id}", method = RequestMethod.DELETE)
	public void deleteMascota(@PathVariable ObjectId id) {
	

			service.deleteMascota(id);
	}
}
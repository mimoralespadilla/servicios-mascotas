package tutorial.ejemplo.servicio;

import org.bson.types.ObjectId;

import tutorial.ejemplo.bean.MascotasModelo;

public interface Mascotas2Service {
		MascotasModelo comprobarId(ObjectId _id);
		void comprobarBorrarMascota(ObjectId _id);
		MascotasModelo comprobarExistencia(MascotasModelo mascota);
}

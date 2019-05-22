package tutorial.ejemplo.servicio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import tutorial.ejemplo.bean.MascotasModelo;
import tutorial.ejemplo.repositorio.MascotasRepositorio;

public class MascotasServiceImpleTest {
	@InjectMocks
	MascotasServiceImple mascotasServiceImple;
	
	@Mock
	MascotasRepositorio mascotasRepositorio;
	
	@Before
    public void init()  {
		MockitoAnnotations.initMocks(this);
    } 
	@Test
	public void comprobarNombreTest() {
		mascotasServiceImple.comprobarNombre("spoot");
	}

	
	@Test
	public void comprobarNombreTest2() {
		MascotasModelo mascotasModelo = new MascotasModelo();
		mascotasModelo.setName("spoot");
		List<MascotasModelo> listaMascotas = new ArrayList<>();
		listaMascotas.add(mascotasModelo);
		mascotasServiceImple.comprobarNombre("spoot");
	}
	@Test
	public void comprobarNombreTest3() {
		MascotasModelo mascotasModelo = new MascotasModelo();
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		List<MascotasModelo> listaMascotas = new ArrayList<>();
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		mascotasServiceImple.comprobarNombre("spoot");
	}
	
	
	@Test
	public void comprobarNombreTest4() {
		MascotasModelo mascotasModelo = new MascotasModelo();
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		mascotasModelo.setName("spoot");
		List<MascotasModelo> listaMascotas = new ArrayList<>();
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		listaMascotas.add(mascotasModelo);
		Mockito.when(mascotasRepositorio.findBynombre(Mockito.anyString())).thenReturn(listaMascotas);
		mascotasServiceImple.comprobarNombre("spoot");
		
	}
}

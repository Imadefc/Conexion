package g2.conexion.Eventos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import g2.conexion.repository.EventoRepository;
import g2.conexion.service.EventoService;
import g2.conexion.model.*;

/**ParticiparEventoTest
 *  La entrada de datos es desde un desplegable
 * 	Testear el estado del evento/usuario al alistarse ==> participantes y 
 */
public class SeleccionEventosTests {
	private List<Evento> eventosPrueba;
    @BeforeEach
	public void init() {
		//eventosPrueba = EventoService.getAll();//Los métodos de los servicios han de ser estáticos para por usarlos en los test
	}
	
	@AfterEach
	public void terminate() {
        
    }
	
}

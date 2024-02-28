package g2.conexion.Eventos;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import g2.conexion.model.Evento;

/**
 * Al crear evento los participantes tienen que estar vacíos o nulos
 * El id es el nombre: si no hay fallo, si hay correcto
 */
public class CrearEventoTests {
    private Evento eventoPrueba;
    @BeforeEach
    public void init(){
        eventoPrueba = new Evento();
    }

    @AfterEach
    public void terminate(){
        
    }
}
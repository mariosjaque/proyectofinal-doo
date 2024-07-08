package doo.sistemaBuses.logicaNegocio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.jupiter.api.Assertions.*;

class terminalBusTest {
    private terminalBus terminaltest;
    private Instant horarioSalida;
    @BeforeEach
    void setUp() {
        Date testDate = new Date("2001-08-12");
        terminaltest = new terminalBus(testDate);
        horarioSalida = testDate.toInstant();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test Genera Numero de Buses itinerario")
    public void testGeneraBus(){
        System.out.println("generaBusItinerario");
        assertEquals(itinerario.values().length,terminaltest.getNumeroBuses());

    }

    @Test
    @DisplayName("Test Horario Salida correcto")
    public void horarioSalidaCorrecto() {
        System.out.println("horarioSalidaCorrecto");
        for(int i=0;i<itinerario.values().length;i++) {
            horarioSalida = horarioSalida.plus(itinerario.values()[i].getHoras(), HOURS);
            horarioSalida = horarioSalida.plus(itinerario.values()[i].getMinutos(), MINUTES);
            assertEquals(horarioSalida, terminaltest.getBuses(i).getHorarioBus());
        }
    }

}
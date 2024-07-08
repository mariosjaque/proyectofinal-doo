package doo.sistemaBuses.logicaNegocio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorPagoTest {

    private ValidadorPago validatest;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test Tarjeta valida")
    public void testTarjetaValida(){
        System.out.println("testTarjetaValida");
        Long cardNumber = 4120030334339912L;
        validatest = new ValidadorPago("Débito",cardNumber,111,"Valid");
        assertTrue(validatest.validar());

    }

    @Test
    @DisplayName("Test Tarjeta invalida")
    public void testTarjetaInvalida(){
        System.out.println("testTarjetaInvalida");
        validatest = new ValidadorPago("Débito",4444,1,"");
        assertFalse(validatest.validar());

    }
}
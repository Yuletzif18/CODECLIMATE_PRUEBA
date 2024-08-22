import org.junit.Assert.assertEquals;
import org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class PruebasCodigoTest {

    private PruebasCodigo pc;

    @Before
    public void setUp() {
        pc = new PruebasCodigo();
    }

    @Test
    public void testSumar() {
        double resultado = pc.realizarOperacion("sumar", 5, 3);
        assertEquals(8, resultado, 0.001);
    }

    @Test
    public void testRestar() {
        double resultado = pc.realizarOperacion("restar", 5, 3);
        assertEquals(2, resultado, 0.001);
    }

    @Test
    public void testMultiplicar() {
        double resultado = pc.realizarOperacion("multiplicar", 5, 3);
        assertEquals(15, resultado, 0.001);
    }

    @Test
    public void testRaizCuadrada() {
        double resultado = pc.realizarOperacion("raizCuadrada", 16, 0);
        assertEquals(4, resultado, 0.001);
    }

    @Test
    public void testCuadrado() {
        double resultado = pc.realizarOperacion("cuadrado", 5, 0);
        assertEquals(25, resultado, 0.001);
    }

    @Test
    public void testRaizCuadradaNumeroNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            pc.realizarOperacion("raizCuadrada", -4, 0);
        });
    }

    @Test
    public void testSumarConNegativos() {
        double resultado = pc.realizarOperacion("sumar", -5, -3);
        assertEquals(-8, resultado, 0.001);
    }
}


import static org.junit.jupiter.api.Assertions.*;

import org.example.Palindromo;
import org.junit.jupiter.api.Test;

class PalindromoTest {

    private final Palindromo palindromo = new Palindromo();

    @Test
    void testEsPalindromo() {
        assertTrue(palindromo.esPalindromo("Ana lleva al oso la avellana."));
        assertTrue(palindromo.esPalindromo("Anita lava la tina"));
        assertTrue(palindromo.esPalindromo("A mamá Roma le aviva el amor a mamá"));
        assertFalse(palindromo.esPalindromo("Esto no es un palindromo"));
        assertTrue(palindromo.esPalindromo("¿Acaso hubo búhos acá?"));
    }
}

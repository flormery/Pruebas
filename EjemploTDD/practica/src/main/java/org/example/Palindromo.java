package org.example;

import java.text.Normalizer;

public class Palindromo {

    public boolean esPalindromo(String texto) {
        if (texto == null) {
            return false;
        }

        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        String reverso = new StringBuilder(normalizado).reverse().toString();

        return normalizado.equals(reverso);
    }
}

package org.punto12;

public class ComparadorHashtableHashMap {

    public static void mostrarDiferencias() {
        System.out.println("\n=== DIFERENCIA ENTRE HASHTABLE Y HASHMAP ===");
        System.out.println("Hashtable:");
        System.out.println("- ✓ Es thread-safe (sincronizado)");
        System.out.println("- ✓ Todos los métodos están sincronizados");
        System.out.println("- ✗ No permite claves o valores null");
        System.out.println("- ⚠️  Más lento en entornos de un solo hilo");

        System.out.println("\nHashMap:");
        System.out.println("- ✗ No es thread-safe (no sincronizado)");
        System.out.println("- ✓ Más rápido en entornos de un solo hilo");
        System.out.println("- ✓ Permite una clave null y múltiples valores null");
        System.out.println("- ⚠️  Para concurrencia, usar ConcurrentHashMap es mejor opción");

        System.out.println("\nRecomendación para concurrencia moderna:");
        System.out.println("- Use ConcurrentHashMap para mejor rendimiento");
        System.out.println("- Hashtable es legacy pero aún funciona");
    }
}

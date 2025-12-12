package com.ivancorrales.streams.strings;

import java.util.List;

/**
 * KATA: Streams con Strings (nivel progresivo, SIN flatMap)
 *
 * Normas:
 * - No uses for / while.
 * - Resuelve cada método encadenando operaciones de Stream.
 * - Lee el enunciado como si fuera una “receta”: seleccionar → transformar → ordenar → resultado final.
 *
 * Operaciones que vas a usar:
 * - Seleccionar elementos: filter(...)
 * - Transformar elementos: map(...)
 * - Quitar repetidos: distinct()
 * - Ordenar: sorted()
 * - Pasar a números: mapToInt(...)
 *
 * Nota:
 * - En esta versión NO extraemos hashtags de frases con split/flatMap.
 *   En su lugar trabajamos con una lista "tokens" ya preparada.
 */
public class StringStreamsKata {

    private final List<String> paises = List.of("Italia", "España", "Portugal", "Irlanda", "Noruega", "Francia");
    private final List<String> usuarios = List.of("  noa  ", "LEO", "ana", "Noa", "   Leo ", "mario", "ANA");

    private final List<String> tokens = List.of(
            "Hoy", "toca", "#java", "y", "#streams",
            "Me", "flipa", "#dam", "#java",
            "Probando", "#Streams", "#JAVA", "#java",
            "sin", "hashtags", "aquí",
            "#dam", "#fp", "#java"
    );
    private final List<List<String>> comentariosPorPost = List.of(
            List.of("Brutal", "Me sirve", "  "),
            List.of("Buenísimo", "me sirve", "Gracias!"),
            List.of("brutal", "TOP", ""),
            List.of("Sin comentarios", "  ", "Gracias!")
    );

    private final List<String> hashtagsPorPost = List.of(
            "#java,#streams",
            "#dam,#java",
            "#streams,#JAVA,#java",
            "",
            "#fp,#dam,#java"
    );

    /**
     * NIVEL 1 (1 paso intermedio)
     * Devuelve los países cuyo nombre termina en "a".
     *
     * Requisitos:
     * - Conserva el orden original de la lista.
     */
    public List<String> paisesQueTerminanEnA() {
    	return paises.stream()
                .filter(p -> p.endsWith("a"))
                .toList();
    }

    /**
     * NIVEL 2 (2 pasos intermedios)
     * Devuelve los países cuyo nombre termina en "a" y después ordénalos alfabéticamente.
     * 
     *
     * Requisitos:
     * - El resultado debe estar ordenado (A→Z).
     */
    public List<String> paisesQueTerminanEnAOrdenadoss(){
    	return paises.stream()
    			.filter(p -> p.endsWith("a"))
    			.sorted()
    			.toList();
    }
    
    
    public List<String> paisesQueTerminanEnAOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 3 (3 pasos intermedios)
     * Devuelve TODOS los países:
     * - convertidos a minúsculas
     * - sin repetidos
     * - ordenados alfabéticamente
     */
    
    public List<String> paisesMinusculasUnicosOrdenadoss(){
    	return paises.stream()
    	.map(s->s.toLowerCase())
    	.distinct()
    	.sorted()
    	.toList();
    }
    
    public List<String> paisesMinusculasUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 4 (3-4 pasos intermedios)
     * Devuelve usuarios “limpios” y sin duplicados.
     *
     * Normalización (en este orden):
     * 1) trim(): elimina espacios al principio y final
     * 2) toLowerCase(): pasa a minúsculas
     *
     * Eliminación de duplicados:
     * - Elimina repetidos DESPUÉS de normalizar.
     *
     * Orden:
     * - Mantén el orden de primera aparición tras normalizar.
     */
    
    public List<String> usuariosNormalizadosSinRepetirr(){
    	return paises.stream()
    	.map(s->s.toLowerCase().trim())
    	.distinct()
    	.sorted()
    	.toList();
    }
    
    public List<String> usuariosNormalizadosSinRepetir() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 5 (4+ pasos intermedios, SIN flatMap)
     * Devuelve la lista de hashtags únicos a partir de la lista "tokens".
     *
     * Definición de hashtag:
     * - Un token que empieza por '#'
     *
     * Requisitos del resultado:
     * - recorta espacios (trim) por si hubiera
     * - en minúsculas
     * - sin repetidos
     * - ordenados alfabéticamente
     *
     * Pista:
     * - Aquí NO hace falta split ni flatMap: ya trabajas con palabras sueltas.
     */
    
    public List<String> hashtagsUnicosOrdenadoss(){
    	return tokens.stream()
    	.map(s->s.toLowerCase().trim())
    	.distinct()
    	.toList();
    }
    
    public List<String> hashtagsUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 6 (paso a IntStream)
     * Devuelve la suma total de letras de los países que terminan en "a".
     *
     * Requisitos:
     * - Antes de contar letras, convierte el país a minúsculas.
     * - Cuenta letras con length().
     * - Convierte a IntStream con mapToInt(...) y termina con sum().
     */
    public int sumaLetrasPaisesEnA() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 7 (IntStream + average)
     * Devuelve la media (double) de la longitud de los hashtags únicos.
     *
     * Requisitos:
     * - Usa hashtags únicos (mismo criterio que en hashtagsUnicosOrdenados()).
     * - Convierte a IntStream con mapToInt(String::length).
     * - Usa average().
     * - Si no hay hashtags, devuelve 0.0.
     */
    public double mediaLongitudHashtagsUnicos() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 8 (IntStream + max)
     * Devuelve la longitud del hashtag más largo (entre los hashtags únicos).
     *
     * Requisitos:
     * - Usa hashtags únicos (mismo criterio que antes).
     * - Convierte a IntStream con mapToInt(String::length).
     * - Usa max().
     * - Si no hay hashtags, devuelve 0.
     */
    public int longitudMaximaHashtag() {
        throw new UnsupportedOperationException("TODO");
    }
    
    /**
     * NIVEL 9 (primer flatMap “visual”)
     * Devuelve una lista con TODOS los comentarios en una sola lista.
     *
     * Requisitos del resultado:
     * - Aplana (une) todas las listas de comentarios en una única lista
     * - trim() a cada comentario
     * - quédate solo con los no vacíos
     * - pasa todo a minúsculas
     * - elimina duplicados
     * - ordena alfabéticamente
     *
     * Pista:
     * - Empiezas con List<List<String>> (comentariosPorPost)
     * - Necesitas flatMap para convertirlo en Stream<String>
     */
    public List<String> comentariosUnicosLimpiosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 10 (flatMap + split sencillo)
     * A partir de la lista hashtagsPorPost (cada string contiene hashtags separados por comas),
     * devuelve TODOS los hashtags únicos.
     *
     * Requisitos del resultado:
     * - Cada elemento puede traer "varios hashtags" separados por coma
     * - Convierte todo a minúsculas
     * - Quita espacios si los hubiera (trim)
     * - Elimina elementos vacíos
     * - Sin repetidos
     * - Ordenados alfabéticamente
     *
     * Pista:
     * - Para cada string, usa split(",") para obtener un array de hashtags
     * - Luego une todos esos arrays en un único stream (flatMap)
     */
    public List<String> hashtagsUnicosDesdeComas() {
        throw new UnsupportedOperationException("TODO");
    }
}
package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
	public List<String> getValoresComoLista() 
	{
		// Creammos una lista con los valores del mapa usando pues, values()
		List<String> lista = new java.util.ArrayList<>(mapaCadenas.values());

		// Ordenamos lexicográficamente
		java.util.Collections.sort(lista);

		return lista;
	}

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> lista = new java.util.ArrayList<>(mapaCadenas.keySet());
        
        java.util.Collections.sort(lista, java.util.Collections.reverseOrder());
        
        return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	 if (mapaCadenas.isEmpty()) {
    	        return null; // No hay nada en el mapa
    	    }

    	    // Crear una lista con todas las llaves
    	    java.util.List<String> llaves = new java.util.ArrayList<>(mapaCadenas.keySet());
    	    java.util.Collections.sort(llaves); // Ordenarlas de menor a mayor

    	    return llaves.get(0); // Retornar la primera
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if (mapaCadenas.isEmpty()) {
            return null; // No hay nada en el mapa
        }

        // Crear una lista con todos los valores
        java.util.List<String> valores = new java.util.ArrayList<>(mapaCadenas.values());
        java.util.Collections.sort(valores); // Ordenarlos de menor a mayor

        return valores.get(valores.size() - 1); // Retornar el último (el más grande)
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	// Creamos una lista nueva donde guardaremos las llaves en mayúsculas
        Collection<String> llavesMayusculas = new java.util.ArrayList<>();

        // Recorremos todas las llaves originales del mapa
        for (String llave : mapaCadenas.keySet()) {
            // Convertimos cada llave a mayúsculas y la agregamos a la lista
            llavesMayusculas.add(llave.toUpperCase());
        }

        // Retornamos la lista con las llaves en mayúsculas
        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	return new java.util.HashSet<>(mapaCadenas.values()).size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    
    public void agregarCadena( String cadena )
    {
    	// invertimos la cadena recibida
        String claveInvertida = new StringBuilder(cadena).reverse().toString();
        // guardamos en el mapa: clave invertida -> valor original
        mapaCadenas.put(claveInvertida, cadena);
    }

    

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
	public void eliminarCadenaConLLave(String llave) 
	{
		mapaCadenas.remove(llave);
	}

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
	
    public void eliminarCadenaConValor( String valor )
    {
    	// Recorremos las llaves y valores para encontrar la que tenga ese valor
        String llaveAEliminar = null;

        for (Map.Entry<String, String> entrada : mapaCadenas.entrySet()) {
            if (entrada.getValue().equals(valor)) {
                llaveAEliminar = entrada.getKey();
                break; // Lo encontramos, podemos salir
            }
        }

        // Si encontramos una llaveEliminar cambio es decir entro al if es decir la encontramos la borramos
        if (llaveAEliminar != null) {
            mapaCadenas.remove(llaveAEliminar);
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	// Limpio el mapa actual
        mapaCadenas.clear();

        // Recorro lista de objetos
        for (Object obj : objetos) {
            String cadena = obj.toString(); // convierto a String
            String llaveInvertida = new StringBuilder(cadena).reverse().toString();
            
            // Agrego al mapa
            mapaCadenas.put(llaveInvertida, cadena);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	 // Creo un nuevo mapa temporal para guardar las llaves en mayúsculas
        Map<String, String> nuevoMapa = new HashMap<>();

        // Recorro el mapa original y transformo cada llave a mayúsculas
        
        for (Map.Entry<String, String> entrada : mapaCadenas.entrySet()) {
            String llaveMayus = entrada.getKey().toUpperCase();
            nuevoMapa.put(llaveMayus, entrada.getValue());
        }

        // Reemplazar el mapa original con el nuevo
        mapaCadenas = nuevoMapa;
    	
    	

    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
	public boolean compararValores(String[] otroArreglo) {

		// Obtenemos la colección de valores actuales del mapa
		Collection<String> valoresMapa = mapaCadenas.values();

		// Verificamos que cada valor del arreglo esté dentro de esos valores
		
		for (String val : otroArreglo) {
			if (!valoresMapa.contains(val)) {
				return false; // Si falta alguno, devuelve false
			}
		}
		return true; // Si todos están
	}

}

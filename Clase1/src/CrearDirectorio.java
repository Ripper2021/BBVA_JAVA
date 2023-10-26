import java.io.File;

// La clase File en Java es fundamental ya que es
//la que utilizamos para interactuar con arvhivos y directorios
//Proporciona una interfaz para crear, leer, escribir, mover, eliminar y administrar archivos y directorios.
// Operaciones comunes:
// Creacion de archivos y directorios
// Lectura de información sobre archivos y directorios.
// Comprobar la existencia de archivos y directorios
// Cambio el nombre 
// Comprobación de permisos de lectura, escritura y ejecución.
public class CrearDirectorio 
{
//Crear una carpeta
	public static void main (String [] args)
	{
		String directorio = "C:\\Users\\Gusta\\OneDrive\\Documentos\\Prueba\\";
		File directorioFile = new File(directorio);
		boolean creado = directorioFile.mkdir(); //El metodo pertenece a la clase java.io.File que se utiliza
												 // para intentar crear un directorio en el sistema de archivos.
												 // Si se genera con exito devuelve TRUE, sino, FALSE. 
		if(creado) 
		{
			System.out.println("El directorio fue creado");
		}
		else
		{
			System.out.println("No se pudo crear el directorio");
		}	
	}
}

/*
 Se utiliza cuando queremos escribir datos de tipo texto O datos BINARIOS. 
 Es bastante simple de utilizar porque no necesita flujos de trabajo. 
 Es utilizado para escribir datos de forma CONCISA. 
 
Files.write tiene 3 parametros 
Path: Especifica la ubicación del archivo donde se escribiran los datos.
byte[] bytes: Es un array de bytes que contiene los datos que se escribiran en el archivo. 
OpenOption options: Es una lista variable de opciones que controla el comportamiento de la operación de escritura
WRITE: Se va a escribir el archivo
CREATE: Para crear un archivo si no existe
TRUNCATE_EXISTING: Trunca (borra) el contenido del archivo si ya existe
APPEND: Adicionar información al archivo, EN LUGAR de sobreescribir su contenido.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscribirFichero2 {
	public static void main (String [] args)
	{
		String contenido = "Hola hola manola, que tal como te va!";
		try {
			Files.write(Paths.get("archivito.txt"), contenido.getBytes());
			System.out.println("Se escribe el archivo");
			//Files.Write se encarga de declarar la accion
			//Paths.get es el metodo que construye la interfaz Path
			//Path representa la ubicación de un archivos y proporciona metodos de manipulación. 
			//Si no existe el archivo LO CREA. 	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

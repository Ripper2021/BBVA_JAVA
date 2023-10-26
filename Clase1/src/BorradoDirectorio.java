import java.io.File;
public class BorradoDirectorio 
{
	public static void main (String [] args)
	{
		String directorioAEliminar = "C:\\Users\\Gusta\\OneDrive\\Documentos\\Prueba\\";
		File directorio = new File (directorioAEliminar);
		if (directorio.exists()) //Pregunto si existe el directorio
		{
			BorrarDirectorio(directorio); //Elimino el directorio
		}
		else
		{
			System.out.println("El directorio no existe.");
		}
	}
	
	public static void BorrarDirectorio(File directory) //creo una funcion que elimina los archivos del directorio
	{
		if(directory.isDirectory()) //Pregunto si es un directorio
		{
			File[] files = directory.listFiles(); //Enliste los archivos que contiene el directorio
			if(files != null) //Tiene archivos
			{
				for(File file: files) //Por cada archivo que tenga los borro
				{
					BorrarDirectorio(file);
				}
			}
		}
	if (directory.exists()) //Aviso por consola si se pudo eliminar o no 
	{
		if (directory.delete())
		{
			System.out.println("Directorio eliminado " + directory.getAbsolutePath()); //getAbsolutePath() devuelve la ruta completa del directorio. 
		}
		else
		{
		 System.out.println("No se pudo eliminar el directorio " + directory.getAbsolutePath());
		}
	}
}	
}
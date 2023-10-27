import java.io.File;
import java.util.Scanner;


public class Ejemplo2  extends Thread
{
		private String directorioAEliminar;
		
		public Ejemplo2(String directorioAEliminar)
		{
			this.directorioAEliminar = directorioAEliminar;
		}
		
		
		public void run()
		{
			//Tarea en segundo plano
			File directorio = new File(directorioAEliminar);
			if (directorio.exists() && directorio.isDirectory())
			{
				borrarDirectorio(directorio);
			}
			System.out.println("Tarea de borrado de directorio en segundo plano");
		}
		
		public void borrarDirectorio(File directorio)
		{
			File[] archivos = directorio.listFiles();
			if(archivos != null)
			{
				for(File archivo: archivos)
				{
					if(archivo.isDirectory())
					{
						borrarDirectorio(archivo);
					}
					else {
						archivo.delete();
					}
					}
				}
					
			}
	public static void main (String [] args)
	{
		System.out.println("Tarea en primer plano: Iniciando la aplicación");
		String directorioAeliminar = "C:\\Users\\Gusta\\OneDrive\\Documentos\\Prueba";
		Ejemplo2 tareaBorrar = new Ejemplo2(directorioAeliminar);
		tareaBorrar.start();
		System.out.println("Haciendo otras tareas en primer plano: ingresa tu nombre");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Su nombre es: " + nombre);
	}

}

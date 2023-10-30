/*
Hilo Demonio (Daemon Threads): Estos son los hilos que se ejecutan en SEGUNDO plano
y estan destinados a proporcionar servicio o realizar tareas de apoyo. La diferencia
clave es que, si todos los hilos no demonio han terminado su ejecución, el programa
se detendra inmediatamente, independientemente de si hay hilos demonio en ejecución o no.
Los hilos demonio se utilizan para realizar tareas que no deben mantener al programa en ejecución
despues de que todos los hilos no demonio hayan terminado.
Hilos No Demonios: Son los hilos regulares y son la categoria
mas comun de hilos en Java. El programa principal no se detendra hasta que todos los hilos
NO demonio hayan terminado su ejecución. Esto significa que, si tenes al menos un hilo 
no demonio en ejecución, el prgograma seguira ejecutandose incluso si el hilo principal ha terminado.
*/
public class EjemploHiloDemonio 
{
	public static void main (String [] args )
	{
		Thread hiloNoDemonio = new Thread(new Tarea("Hilo No Demonio"));
		Thread hiloDemonio = new Thread(new Tarea("Hilo Demonio"));
		hiloNoDemonio.setPriority(Thread.MAX_PRIORITY);
		hiloDemonio.setDaemon(true);
		hiloNoDemonio.start();
		hiloDemonio.start();
		System.out.println("Hilo principal: Los Hilos estan en ejecución");
	}
static class Tarea implements Runnable
{
	private String nombre;
	
	public Tarea(String nombre)
	{
		this.nombre = nombre;
	}
@Override
public void run()
{
	for (int i = 1; i<=5; i++)
	{
		System.out.println(nombre + ": Mensaje" + i);
		try
		{
			Thread.sleep(100);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
}
}

/* Los Hilos (Threads) son una forma de lograr la CONCURRENCIA y ejecución paralela
 * de tareas en un programa.Los hilos permiten al programa realizar multiples tareas.
 * Java proporciona soporte paral os hilos a traves de su paquete
 * java.lang.Thread
 * Cuando ejecutamos un hilo lo hacemos con el metodo start(), java invoca el metodo run() en ese hilo.
 * Multihilos: Podemos crear multiples hilos y ejecutarlos de forma concurrente.
 * Java se encarga de administrar la asignación de CPU a cada hilo.
 * 
 * Control de hilos: 
 * Podemos controlar la ejecución de los hilos mediante metodos como
 * sleep(), join(), yield(), interrupt(). Esto nos permite pausar, esperar a que otros hilos finalicen,
 * ceder el tiempo de CPU a otro hilo, detener un hilo.
 * 
 * Prioridades de hilos: 
 * Puedes establecer prioridades para los hilos para influir en la asignación de tiempo de CPU.
 * Sin embargo, la asignación de prioridades exacta no esta garantizada y depende de cada plataforma.
 */
public class MiHilo extends Thread
{
  public void run()
  {
	  for (int i = 0; i < 10; i++) 
	  {
		 try
		 {
			 Thread.sleep(1000); //Simula una operación larga
		 }
		 catch (InterruptedException e)
		 {
			 e.printStackTrace();
		 }
		 System.out.println("Tarea en segundo plano: " + i);
	  }
  }
  
  public static void main (String [] args)
  {
	  MiHilo miHilo = new MiHilo();
	  miHilo.start();
	  
	  //Simulamos la tarea principal en primer plano
	  for (int i = 0; i<5; i++)
	  {
		  try
		  {
			  Thread.sleep(1000);
		  }
		  catch(InterruptedException e)
		  {
			  e.printStackTrace();
		  }
		  System.out.println("Tarea en primer plano: " + i);
	  }
  }
}
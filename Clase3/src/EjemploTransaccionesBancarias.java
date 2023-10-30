import java.util.concurrent.locks.ReentrantLock;

public class EjemploTransaccionesBancarias 
{
	public static void main (String [] args)
	{
	CuentaBancaria cuenta1 = new CuentaBancaria(1, 1000); //Declaro una nueva Cuenta Bancaria
	CuentaBancaria cuenta2 = new CuentaBancaria (2, 5000); //Declaro una nueva Cuenta Bancaria
	CuentaBancaria cuenta3 = new CuentaBancaria (3, 10000); //Declaro una nueva Cuenta Bancaria
	Thread hilo1 = new Thread(new Transferencia(cuenta1, cuenta2, 200)); //Declaro una nueva Transferencia
	Thread hilo2 = new Thread(new Transferencia(cuenta2, cuenta3, 300)); //Declaro una nueva Transferencia
	Thread hilo3 = new Thread(new Transferencia(cuenta3, cuenta1, 100)); //Declaro una nueva Transferencia
	hilo3.setPriority(Thread.MAX_PRIORITY);
	hilo1.start(); //Inicio hilo1
	hilo2.start(); //Inicio hilo2
	hilo3.start(); //Inicio hilo3
	try
	{
		hilo1.join(); 
		hilo2.join(); //Lo que intento hacer con los joins dentro de un try-catch es garantizar que el programa
		 		      //Principal no CONTINUE hasta que todos los hilos hayan completado sus transferencias.
		hilo3.join();
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	System.out.println("Saldo de cuenta1: "+ cuenta1.getSaldo()); //Muestro por pantalla los saldos
	System.out.println("Saldo de cuenta2: "+ cuenta2.getSaldo());
	System.out.println("Saldo de cuenta3: "+ cuenta3.getSaldo());	
	}
}
class CuentaBancaria //Declaro la clase CuentaBancaria
{
	private int numeroCuenta; //Declaro la variable privada numeroCuenta
	private int saldo; //declaro la variable privada saldo
	private ReentrantLock lock = new ReentrantLock(); //¿Que es ReentrantLock?
	/* Es una clase de java que proporciona una implementación mas avanzada de bloqueo
	 * que se puede utilizar para controlar el acceso a secciones criticas de codig
	 * en aplicaciones multihilo. Se llama "reentrant" porque permite que un hilo adquiera
	   el bloqueo mas de una vez, siempre y cuando lo libere un numero igual de veces. 
	 *
	 *
	 *
	 */
	
	public CuentaBancaria (int numeroCuenta, int saldo) //declaro la funcion de la calse
	{
		this.numeroCuenta= numeroCuenta;
		this.saldo = saldo;
	}
	
	public int getSaldo() //Declaro el metodo getSaldo
	{
		return saldo;
	}
	
	public int getNumeroCuenta() //Declaro el metodo getNumeroCuenta
	{
		return numeroCuenta;
	}
	
	public void depositar (int cantidad) //Declaro el metodo Depositar
	{
		lock.lock(); //Bloqueo el hilo para garantizar la ejecución de una sección CRITICA de codigo.
		try
		{
			saldo += cantidad; //Sección critica de codigo a ejecutar
		}
		finally
		{
			lock.unlock(); //Libero el hilo. 
		}
	}
	
	public void retirar (int cantidad) //Funcion de retirar
	{
		lock.lock(); //Bloqueo el hilo para garantizar la ejecución del codigo CRITICO
		try
		{
			saldo -= cantidad;
		}
		finally
		{
			lock.unlock(); //Libero el hilo. 
		}
	}	
}

class Transferencia implements Runnable //Declaro la clase Transferencia que implementa el Runnable
{
	private CuentaBancaria origen;
	private CuentaBancaria destino;
	private int cantidad;
	
	public Transferencia(CuentaBancaria origen, CuentaBancaria destino, int cantidad)
	{
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
	}

@Override
public void run()
{
		System.out.println("Transferencia iniciada: " + origen.getNumeroCuenta() + " -> " + destino.getNumeroCuenta());
		origen.retirar(cantidad);
		destino.depositar(cantidad);
		System.out.println("Transferencia completada: " + origen.getNumeroCuenta() + " ->" + destino.getNumeroCuenta());
}
}
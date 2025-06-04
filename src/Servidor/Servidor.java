package Servidor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.swing.JTextPane;

public class Servidor extends Thread
{
	private ServerSocket server;
	private LinkedList<ConexionCliente> conexiones;
	private JTextPane memo;
	
	public Servidor(JTextPane controlMemo, int puerto)
	{
		try
		{
			server = new ServerSocket(puerto);
			conexiones = new LinkedList<ConexionCliente>();
			memo = controlMemo;
		}
		catch (IOException ie)
		{
			System.out.println("Error! No se pudo abrir el socket del servidor.");
			System.exit(1);
		}
		
		try
		{
			//Retorna la direccin IP remota a la cual est conectado el socket. 
		    InetAddress addr = InetAddress.getLocalHost();

		    // Get IP Address
		    String ipAddr = addr.getHostAddress().toString();
		    memo.setText("Direccin IP local: " + ipAddr);
		    
		    // Get hostname
		    String hostname = addr.getHostName();
		    memo.setText(memo.getText() + "\nHostname: " + hostname);
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Socket client = server.accept();
				ConexionCliente conexion = new ConexionCliente(this, memo, client);
				conexiones.add(conexion);
				conexion.start();
			}
			catch (IOException ie)
			{
				break;
			}
		}
	}
	
	public void detener()
	{
		try
		{
			server.close();
		}
		catch (Exception e)
		{
		}
	}
	
	public void mensajeRecibido(String ip, String mensaje)
	{
		for(ConexionCliente cc: conexiones)
			cc.enviar(ip + ": " + mensaje);
				
		String anteriores = memo.getText();
		memo.setText(anteriores + "\n" + ip + ": " + mensaje);
	}
}


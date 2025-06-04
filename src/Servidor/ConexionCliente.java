package Servidor;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JTextPane;

public class ConexionCliente extends Thread
{
	private Servidor servidor;
	private Socket socket;
	private DataOutputStream clientOut;
	private DataInputStream clientIn;
	private JTextPane memo;
	
	public ConexionCliente(Servidor serv, JTextPane controlMemo, Socket s)
	{
		servidor = serv;
		socket = s;
		memo = controlMemo;
	}

	public void run()
	{
		try
		{
			String anteriores = memo.getText();
			memo.setText( anteriores + "\n" + socket.getInetAddress() + " conectado!");
			
			clientOut = new DataOutputStream(socket.getOutputStream());
			clientIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));			
			
			while(true)
			{
				try
				{
					String linea = clientIn.readUTF();
					servidor.mensajeRecibido(socket.getInetAddress().toString(), linea);
				}
				catch(Exception e)
				{
				}
			}
		}
		catch(Exception e)
		{
		}
	}
	
	public void enviar(String mensaje)
	{
		try
		{
			clientOut.writeUTF(mensaje);
		}
		catch(Exception ex)
		{
		}
	}
}


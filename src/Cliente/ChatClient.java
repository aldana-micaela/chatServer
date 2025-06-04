package Cliente;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JTextPane;

public class ChatClient
{
	private Socket client;
	private DataOutputStream streamOut;
	private DataInputStream streamIn;
	private ChatThread thread;
	
	public ChatClient(String host, int puerto, JTextPane textPane)
	{
		try
		{
			client = new Socket(host, puerto);
			streamOut = new DataOutputStream(client.getOutputStream());
			streamIn = new DataInputStream(new BufferedInputStream(client.getInputStream()));
			
			thread = new ChatThread(streamIn, textPane);
			thread.start();
		}
		catch(Exception ex)
		{
			textPane.setText(textPane.getText() + "\n\nFall la conexin: " + ex.getMessage());
		}
	}
	
	public boolean enviar(String texto)
	{
		try
		{
			streamOut.writeUTF(" dice: " + texto);
		}
		catch(Exception ex)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean desconectar()
	{
		try
		{
			streamOut.writeUTF(client.getInetAddress().getHostName() + " desconectado!");
			client.close();
		}
		catch(Exception ex)
		{
			return false;
		}
		
		return true;
	}
}

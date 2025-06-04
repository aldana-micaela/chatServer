package Cliente;

import java.io.DataInputStream;
import javax.swing.JTextPane;

public class ChatThread extends Thread
{
	private DataInputStream streamIn;
	private JTextPane textPane;
	
	public ChatThread(DataInputStream is, JTextPane tp)
	{
		streamIn = is;
		textPane = tp;
	}
	
	public void run()
	{
		textPane.setText("Thread cliente corriendo");
		while(true)
		{
			try
			{
				String str = streamIn.readUTF();
				textPane.setText(textPane.getText() + "\n" + str);
			}
			catch(Exception ex)
			{
			}
		}		
	}
}

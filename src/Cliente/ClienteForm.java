package Cliente;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ClienteForm 
{
	private ChatClient client;
	private JFrame frmClienteChat;
	private JTextField txServidor;
	private JTextField txMensaje;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ClienteForm window = new ClienteForm();
					window.frmClienteChat.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public ClienteForm()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		initialize();
	}

	private void initialize()
	{
		frmClienteChat = new JFrame();
		frmClienteChat.setTitle("Chat Client");
		frmClienteChat.setBounds(100, 100, 409, 431);
		frmClienteChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClienteChat.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 379, 298);
		frmClienteChat.getContentPane().add(scrollPane);
		
		final JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
		
		JLabel lblServidor = new JLabel("Servidor:");
		lblServidor.setBounds(24, 25, 46, 14);
		frmClienteChat.getContentPane().add(lblServidor);
		
		txServidor = new JTextField();
		txServidor.setBounds(80, 23, 99, 20);
		frmClienteChat.getContentPane().add(txServidor);
		txServidor.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//creo un cliente nuevo de chat, parmetros: servidor, puerto y textPane
				client = new ChatClient(txServidor.getText(), 1234, textPane);
			}
		});
		btnConectar.setBounds(189, 21, 89, 23);
		frmClienteChat.getContentPane().add(btnConectar);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//cierra la conexion
				client.desconectar();
			}
		});
		btnDesconectar.setBounds(288, 21, 101, 23);
		frmClienteChat.getContentPane().add(btnDesconectar);
		
		txMensaje = new JTextField();
		txMensaje.setBounds(10, 369, 268, 20);
		frmClienteChat.getContentPane().add(txMensaje);
		txMensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// rescata el texto y lo envia
				String elTexto = txMensaje.getText();
				if (!elTexto.isEmpty())
				{	
					client.enviar(elTexto);
					txMensaje.setText("");
				}
			}	
		});
		btnEnviar.setBounds(300, 369, 89, 23);
		frmClienteChat.getContentPane().add(btnEnviar);
	}
}

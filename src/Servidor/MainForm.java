package Servidor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MainForm 
{
	private JFrame frmChatServer;
	private JTextPane memo;
	private Servidor servidor;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					MainForm window = new MainForm();
					window.frmChatServer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainForm()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
		}

		initialize();
	}

	private void initialize() 
	{
		frmChatServer = new JFrame();
		frmChatServer.setTitle("Chat Server");
		frmChatServer.setBounds(100, 100, 450, 491);
		frmChatServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatServer.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 401);
		frmChatServer.getContentPane().add(scrollPane);
		
		memo = new JTextPane();
		scrollPane.setViewportView(memo);
		
		JButton iniciarBtn = new JButton("Iniciar");
		iniciarBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (!servidorIniciado())
				{	
					servidor = new Servidor(memo, 1234);
					servidor.start();
					memo.setText( memo.getText() + "\n\nServidor iniciado." );
				}	
				else
				{
					memo.setText( memo.getText() + "\nEl servidor ya se encuentra iniciado." );
				}
			}

		});
		iniciarBtn.setBounds(244, 423, 89, 23);
		frmChatServer.getContentPane().add(iniciarBtn);
		
		JButton detenerBtn = new JButton("Detener");
		detenerBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (servidorIniciado())
				{
					servidor.detener();
					servidor = null;
					memo.setText( memo.getText() + "\nServidor detenido." );
				}
				else
					memo.setText( memo.getText() + "\nNo ha iniciado el servidor." );
			}
		});
		detenerBtn.setBounds(343, 423, 89, 23);
		frmChatServer.getContentPane().add(detenerBtn);
	}
	
	private boolean servidorIniciado() 
	{
		return servidor!=null;
	}
}

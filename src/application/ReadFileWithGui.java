package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ReadFileWithGui {

	private JFrame frame;

	// launch the application

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadFileWithGui window = new ReadFileWithGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// create the application
	public ReadFileWithGui() {
		initialize();

	}

	// initialize the contents of the Frame

	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 550, 400);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setForeground(Color.RED);
		textArea.setEditable(false);
		
		textArea.setPreferredSize(new Dimension(550, 400));

		textArea.setBounds(1, 1, 400, 250);

		frame.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("Get File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile of = new OpenFile();

				try {
					of.PickMe();
				} catch (Exception e) {
					e.printStackTrace();
				}
				textArea.setText(of.sb.toString());
			}
		});
		btnNewButton.setBounds(220, 260, 100, 20);
		frame.getContentPane().add(btnNewButton);
	}

}

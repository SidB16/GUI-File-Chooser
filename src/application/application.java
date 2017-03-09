package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;

public class application {

	JFrame jFrame;
	MenuBar menuBar;
	Menu file, edit, help;
	MenuItem loadItem, newItem, closeItem, exitItem, cutItem, copyItem, pasteItem, divideItem;
	TextArea textArea;
	JFileChooser jFileChooser;

	public application() {
		jFrame = new JFrame("Menu window");

		textArea = new TextArea();
		menuBar = new MenuBar();
		jFileChooser = new JFileChooser();

		file = new Menu("File");
		edit = new Menu("Edit");
		help = new Menu("Help");

		loadItem = new MenuItem("Load");
		newItem = new MenuItem("New");
		closeItem = new MenuItem("Close");
		exitItem = new MenuItem("Exit");
		cutItem = new MenuItem("Cut");
		copyItem = new MenuItem("Copy");
		pasteItem = new MenuItem("Paste");
		divideItem = new MenuItem("-------");
	}

	public static void main(String[] args) {
		application t = new application();
		t.showFrame();
	}

	public void showFrame() {
		file.add(loadItem);
		loadItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// load a file from file system
					jFileChooser.showOpenDialog(jFrame);
					FileReader fr = new FileReader(jFileChooser.getSelectedFile());
					// FileReader fr = new FileReader("javacode/gui/in.txt");

					// read bytes from the file
					int s = fr.read();
					String a = "";
					while (s != -1) {
						a += (char) s;
						s = fr.read();
					}

					// a = a.replaceAll("\\s+", " ");

					textArea.setText(a);

				} catch (Exception e1) {
					textArea.setText("Error Loading File");
					e1.printStackTrace();
				}
			}
		});

		file.add(newItem);
		file.add(closeItem);
		file.add(divideItem);
		file.add(exitItem);

		edit.add(cutItem);
		edit.add(copyItem);
		edit.add(pasteItem);

		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);

		textArea.setPreferredSize(new Dimension(380, 300));
		textArea.repaint();
		jFrame.add(textArea);

		jFrame.setLayout(new FlowLayout());
		jFrame.setSize(new Dimension(400, 400));

		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		jFrame.setVisible(true);

		jFrame.setMenuBar(menuBar);
	}

}
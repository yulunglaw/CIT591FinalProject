import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.*;

public class UserInterface implements Runnable {

	private JFrame frame = new JFrame("PhillyOpenData Analyzer");
	
	/**
	 * This will be the top-level container for the GUI. 
	 * This panel will have multiple sub-panels and buttons embedded
	 * within it, but will serve as the main housing for all those
	 * that will drive functionality
	 * @return
	 */
	public JPanel topLevel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		
		
		JPanel inputsPanel = new JPanel();
		inputsPanel.setLayout(new BorderLayout());
		
		JPanel slicerPanel = new JPanel();
		slicerPanel.setLayout(new GridLayout());
		
		// Could store the buttons/event listeners in a HashMap
		HashMap<String, EventListener> slicers = new HashMap<>();
		slicers.put("test", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hit the test");
			}
		});
	
		slicers.put("second one", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hit the second one");
			}
		});
		
		// Adding in the actual stuff from the HashMap
		for (String str : slicers.keySet()) {
			Checkbox temp = new Checkbox(str);
			slicerPanel.add(temp);
		}
		
		
		
//		JButton button2 = new JButton("test");
//		panel.add(button2);
		
		panel.add(inputsPanel);
		panel.add(slicerPanel);
		
		JButton button1 = new JButton("test");
		panel.add(button1);
		
		return panel;
	};
	
	// Run method. This will be called to generate the GUI
	public void run() {
		frame.add(topLevel());
		
//		frame.setPreferredSize(new Dimension(745, 375));
//		frame.setMaximumSize(frame.getPreferredSize());
//		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Main method. Funtion TBD 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new UserInterface());
	}

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mainMenu extends app implements ActionListener {
	// UI Objects
	private JButton newDeck;
	private static JButton deckButton_1;
	private static JButton deckButton_2;
	private static JButton deckButton_3;
	private static JButton deckButton_4;
	private JButton trash_1;
	private JButton trash_2;
	private JButton trash_3;
	private JButton trash_4;
	private JButton decrementPage;
	private JButton incrementPage;
	private JButton fileBrowser;

	// Variable Declaration
	static int currentDeckIndex;

	public mainMenu() {
		updateDeckArray();

		// Construct components, sets command names, and sets their styles
		deckButton_1 = new JButton("No Deck Found");
		deckButton_1.setActionCommand("deckButton_1");
		deckButton_1.setForeground(fontColor);
		deckButton_1.setBackground(buttonColor);
		deckButton_1.setFocusPainted(false);
		deckButton_1.setBorderPainted(false);

		deckButton_2 = new JButton("No Deck Found");
		deckButton_2.setActionCommand("deckButton_2");
		deckButton_2.setForeground(fontColor);
		deckButton_2.setBackground(buttonColor);
		deckButton_2.setFocusPainted(false);
		deckButton_2.setBorderPainted(false);

		deckButton_3 = new JButton("No Deck Found");
		deckButton_3.setActionCommand("deckButton_3");
		deckButton_3.setForeground(fontColor);
		deckButton_3.setBackground(buttonColor);
		deckButton_3.setFocusPainted(false);
		deckButton_3.setBorderPainted(false);

		deckButton_4 = new JButton("No Deck Found");
		deckButton_4.setActionCommand("deckButton_4");
		deckButton_4.setForeground(fontColor);
		deckButton_4.setBackground(buttonColor);
		deckButton_4.setFocusPainted(false);
		deckButton_4.setBorderPainted(false);

		newDeck = new JButton("+");
		newDeck.setActionCommand("new_deck");
		newDeck.setForeground(fontColor);
		newDeck.setBackground(buttonColor);
		newDeck.setFocusPainted(false);
		newDeck.setBorderPainted(false);

		trash_1 = new JButton("X");
		trash_1.setActionCommand("trash_1");
		trash_1.setForeground(fontColor);
		trash_1.setBackground(buttonColor);
		trash_1.setFocusPainted(false);
		trash_1.setBorderPainted(false);

		trash_2 = new JButton("X");
		trash_2.setActionCommand("trash_2");
		trash_2.setForeground(fontColor);
		trash_2.setBackground(buttonColor);
		trash_2.setFocusPainted(false);
		trash_2.setBorderPainted(false);

		trash_3 = new JButton("X");
		trash_3.setActionCommand("trash_3");
		trash_3.setForeground(fontColor);
		trash_3.setBackground(buttonColor);
		trash_3.setFocusPainted(false);
		trash_3.setBorderPainted(false);

		trash_4 = new JButton("X");
		trash_4.setActionCommand("trash_4");
		trash_4.setForeground(fontColor);
		trash_4.setBackground(buttonColor);
		trash_4.setFocusPainted(false);
		trash_4.setBorderPainted(false);

		decrementPage = new JButton("<<");
		decrementPage.setActionCommand("");
		decrementPage.setForeground(fontColor);
		decrementPage.setBackground(buttonColor);
		decrementPage.setFocusPainted(false);
		decrementPage.setBorderPainted(false);
		decrementPage.setEnabled(false);

		incrementPage = new JButton(">>");
		incrementPage.setActionCommand("");
		incrementPage.setForeground(fontColor);
		incrementPage.setBackground(buttonColor);
		incrementPage.setFocusPainted(false);
		incrementPage.setBorderPainted(false);
		incrementPage.setEnabled(false);

		fileBrowser = new JButton("📁");
		fileBrowser.setActionCommand("file_browser");
		fileBrowser.setForeground(fontColor);
		fileBrowser.setBackground(buttonColor);
		fileBrowser.setFocusPainted(false);
		fileBrowser.setBorderPainted(false);

		// Adjusts size and sets layout
		setPreferredSize(new Dimension(919, 333));
		setBackground(backgroundColor);
		setLayout(null);

		// Adds components
		add(deckButton_1);
		add(deckButton_2);
		add(deckButton_3);
		add(deckButton_4);
		add(newDeck);
		add(trash_1);
		add(trash_2);
		add(trash_3);
		add(trash_4);
		add(decrementPage);
		add(incrementPage);
		add(fileBrowser);

		// Creates event listeners for buttons
		deckButton_1.addActionListener(this);
		deckButton_2.addActionListener(this);
		deckButton_3.addActionListener(this);
		deckButton_4.addActionListener(this);
		newDeck.addActionListener(this);
		trash_1.addActionListener(this);
		trash_2.addActionListener(this);
		trash_3.addActionListener(this);
		trash_4.addActionListener(this);
		decrementPage.addActionListener(this);
		incrementPage.addActionListener(this);
		fileBrowser.addActionListener(this);

		// Sets component bounds
		deckButton_1.setBounds(190, 40, 495, 52);
		newDeck.setBounds(855, 10, 50, 50);
		deckButton_2.setBounds(190, 100, 495, 52);
		deckButton_3.setBounds(190, 160, 495, 52);
		deckButton_4.setBounds(190, 220, 495, 52);
		trash_1.setBounds(690, 40, 55, 52);
		trash_2.setBounds(690, 100, 55, 53);
		trash_3.setBounds(690, 160, 55, 52);
		trash_4.setBounds(690, 220, 55, 52);
		decrementPage.setBounds(190, 280, 100, 25);
		incrementPage.setBounds(645, 280, 100, 25);
		fileBrowser.setBounds(855, 70, 50, 50);

		populateDeckButtons();
	}

	// Updates the array storing the names of all files in the /decks folder
	public static void updateDeckArray() {
		File folder = new File("decks/");
		decks = folder.list();
		for (int i = 0; i<decks.length; i++) {
			System.out.println("Loaded File: " + decks[i]);
		}
	}

	// Updates the rendered text on buttons
	public static void populateDeckButtons() {
		try {
			deckButton_1.setText(decks[0].substring(5, decks[0].length() - 4));
		} catch (Exception e) {
			deckButton_1.setText("No Deck Found");
		}

		try {
			deckButton_2.setText(decks[1].substring(5, decks[1].length() - 4));
		} catch (Exception e) {
			deckButton_2.setText("No Deck Found");
		}

		try {
			deckButton_3.setText(decks[2].substring(5, decks[2].length() - 4));
		} catch (Exception e) {
			deckButton_3.setText("No Deck Found");
		}

		try {
			deckButton_4.setText(decks[3].substring(5, decks[3].length() - 4));
		} catch (Exception e) {
			deckButton_4.setText("No Deck Found");
		}
	}

	// This is where the flashcards call their functions
	public void actionPerformed(ActionEvent e) {
		if ("deckButton_1".equals(e.getActionCommand())) {
			System.out.println("Opening Deck Index 1...");
			try {
				openDeckIndex1();
			} catch (IOException e1) {
				inputErrorMessage();
			}
		} else if ("deckButton_2".equals(e.getActionCommand())) {
			System.out.println("Opening Deck Index 2...");
			try {
				openDeckIndex2();
			} catch (IOException e1) {
				inputErrorMessage();
			}
		} else if ("deckButton_3".equals(e.getActionCommand())) {
			System.out.println("Opening Deck Index 3...");
			try {
				openDeckIndex3();
			} catch (IOException e1) {
				inputErrorMessage();
			}
		} else if ("deckButton_4".equals(e.getActionCommand())) {
			System.out.println("Opening Deck Index 4...");
			try {
				openDeckIndex4();
			} catch (IOException e1) {
				inputErrorMessage();
			}
		} else if ("new_deck".equals(e.getActionCommand())) {
			System.out.println("Opening new deck UI...");
			String deckName = JOptionPane.showInputDialog("Name of new deck:");
			if (deckName != null) {
				createNewDeck(deckName);
			}
		} else if ("file_browser".equals(e.getActionCommand())) {
			try {
				Runtime.getRuntime().exec("explorer.exe /select, decks");
			} catch (IOException IOException) {
				inputErrorMessage();
			}
		} else if ("trash_1".equals(e.getActionCommand())) {
			try {
				Files.deleteIfExists(
					Paths.get("decks/" + decks[0]));
				updateDeckArray();
				populateDeckButtons();
			} catch (ArrayIndexOutOfBoundsException | IOException ej) {
				inputErrorMessage();
			}
		} else if ("trash_2".equals(e.getActionCommand())) {
			try {
				Files.deleteIfExists(
					Paths.get("decks/" + decks[1]));
				updateDeckArray();
				populateDeckButtons();
			} catch (ArrayIndexOutOfBoundsException | IOException ej) {
				inputErrorMessage();
			}
		} else if ("trash_3".equals(e.getActionCommand())) {
			try {
				Files.deleteIfExists(
					Paths.get("decks/" + decks[2]));
				updateDeckArray();
				populateDeckButtons();
			} catch (ArrayIndexOutOfBoundsException | IOException ej) {
				inputErrorMessage();
			}
		} else if ("trash_4".equals(e.getActionCommand())) {
			try {
				Files.deleteIfExists(
					Paths.get("decks/" + decks[3]));
				updateDeckArray();
				populateDeckButtons();
			} catch (ArrayIndexOutOfBoundsException | IOException ej) {
				inputErrorMessage();
			}
		} else {
			System.out.println("Input error...");
			inputErrorMessage();
		}
	}

	static void openDeckIndex1() throws IOException {
		try {
			selectedDeckFileName = decks[0];
			displayFlashcards(frame);
		} catch (ArrayIndexOutOfBoundsException e) {
			inputErrorMessage();
		}
	}

	static void openDeckIndex2() throws IOException {
		try {
			selectedDeckFileName = decks[1];
			displayFlashcards(frame);
		} catch (ArrayIndexOutOfBoundsException e) {
			inputErrorMessage();
		}
	}

	static void openDeckIndex3() throws IOException {
		try {
			selectedDeckFileName = decks[2];
			displayFlashcards(frame);
		} catch (ArrayIndexOutOfBoundsException e) {
			inputErrorMessage();
		}
	}

	static void openDeckIndex4() throws IOException {
		try {
			selectedDeckFileName = decks[3];
			displayFlashcards(frame);
		} catch (ArrayIndexOutOfBoundsException e) {
			inputErrorMessage();
		}
	}

	static void createNewDeck(String deckFileName) {
		fileCreator.newFile(deckFileName);
	}

	static void inputErrorMessage() {
		JOptionPane.showMessageDialog(null, "Invalid input...", "Flash Cards | INPUT ERROR", 0);
	}
}
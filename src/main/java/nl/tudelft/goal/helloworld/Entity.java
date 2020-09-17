package nl.tudelft.goal.helloworld;

import javax.swing.JTextArea;

import eis.eis2java.annotation.AsAction;
import eis.eis2java.annotation.AsPercept;

/**
 * An entity in the hello world environment which is capable of printing text to
 * the system.out.
 */
public class Entity {
	private int printedTextAmount = 0;
	private String lastPrinted = "";
	private final JTextArea textArea;

	public Entity(final JTextArea area) {
		this.textArea = area;
	}

	/**
	 * @return the amount of times a text has been printed.
	 */
	@AsPercept(name = "printedText")
	public int getPrintedTextAmount() {
		return this.printedTextAmount;
	}

	/**
	 * Prints a new line of text.
	 * 
	 * @param text the text to print.
	 */
	@AsAction(name = "printText")
	public void printText(final String text) {
		this.textArea.append(text + "\n");
		this.lastPrinted = text;
		this.printedTextAmount++;
	}

	/**
	 * @return The line of text that was last printed.
	 */
	@AsPercept(name = "lastPrintedText")
	public String getLastPrinted() {
		return this.lastPrinted;
	}
}

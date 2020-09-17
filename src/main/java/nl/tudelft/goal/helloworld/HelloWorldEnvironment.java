package nl.tudelft.goal.helloworld;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import eis.eis2java.environment.AbstractEnvironment;
import eis.exceptions.EntityException;
import eis.exceptions.ManagementException;
import eis.iilang.Action;
import eis.iilang.EnvironmentState;
import eis.iilang.Parameter;

/**
 * Simple Hello World environment which launches a single entity upon
 * initialization.
 */
public class HelloWorldEnvironment extends AbstractEnvironment {
	private static final long serialVersionUID = 1L;
	private JFrame outputWindow; // kill resets this to null.

	@Override
	public void init(final Map<String, Parameter> parameters) throws ManagementException {
		super.init(parameters);
		final JTextArea area = initWindow();
		setState(EnvironmentState.PAUSED);

		try {
			registerEntity("entity1", new Entity(area));
		} catch (final EntityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the "world": an output text window.
	 */
	private JTextArea initWindow() {
		this.outputWindow = new JFrame();
		this.outputWindow.setLayout(new BorderLayout());
		this.outputWindow.setSize(HelloWorldSettings.getWidth(), HelloWorldSettings.getHeight());
		this.outputWindow.setLocation(HelloWorldSettings.getX(), HelloWorldSettings.getY());
		this.outputWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		final JTextArea textArea = new JTextArea();
		textArea.setFont(textArea.getFont().deriveFont(12f));
		this.outputWindow.add(new JScrollPane(textArea));

		this.outputWindow.setVisible(true);
		return textArea;
	}

	@Override
	public void kill() throws ManagementException {
		super.kill();
		HelloWorldSettings.setWindowParams(this.outputWindow.getX(), this.outputWindow.getY(),
				this.outputWindow.getWidth(), this.outputWindow.getHeight());
		this.outputWindow.setVisible(false);
		this.outputWindow = null;
	}

	@Override
	public boolean isStateTransitionValid(final EnvironmentState oldState, final EnvironmentState newState) {
		return true;
	}

	@Override
	protected boolean isSupportedByEnvironment(final Action action) {
		return (getState() == EnvironmentState.RUNNING);
	}

	@Override
	protected boolean isSupportedByType(final Action action, final String type) {
		return true;
	}
}

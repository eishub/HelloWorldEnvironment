package nl.tudelft.goal.helloworld;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import eis.eis2java.environment.AbstractEnvironment;
import eis.exceptions.EntityException;
import eis.exceptions.ManagementException;
import eis.iilang.Action;
import eis.iilang.EnvironmentState;
import eis.iilang.Parameter;

/**
 * Simple Hello World environment which launches a single entity upon
 * initialization.
 * 
 * @author Lennard de Rijk
 */
public class HelloWorldEnvironment extends AbstractEnvironment {

  private static final long serialVersionUID = 1L;
  private JFrame outputWindow; // kill resets this to null.

  @Override
  public void init(Map<String, Parameter> parameters) throws ManagementException {
    super.init(parameters);
    JTextArea area = initWindow();
    setState(EnvironmentState.PAUSED);

    try {
      registerEntity("entity1", new Entity(area));
    } catch (EntityException e) {
      e.printStackTrace();
    }

  }

  /**
   * Initialize the "world": an output text window.
   */
  private JTextArea initWindow() {
    JTextArea textArea;

    outputWindow = new JFrame();
    outputWindow.setLayout(new BorderLayout());
    textArea = new JTextArea();
    outputWindow.add(new JScrollPane(textArea));
    outputWindow.setSize(HelloWorldSettings.getWidth(), HelloWorldSettings.getHeight());
    outputWindow.setLocation(HelloWorldSettings.getX(), HelloWorldSettings.getY());
    outputWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    outputWindow.setVisible(true);
    return textArea;
  }

  @Override
  public void kill() throws ManagementException {
    super.kill();
    HelloWorldSettings.setWindowParams(outputWindow.getX(), outputWindow.getY(),
        outputWindow.getWidth(), outputWindow.getHeight());
    outputWindow.setVisible(false);
    outputWindow = null;

  }

  @Override
  public boolean isStateTransitionValid(EnvironmentState oldState, EnvironmentState newState) {
    return true;
  }

  @Override
  protected boolean isSupportedByEnvironment(Action action) {
    return getState() == EnvironmentState.RUNNING;
  }

  @Override
  protected boolean isSupportedByType(Action action, String type) {
    return true;
  }


}

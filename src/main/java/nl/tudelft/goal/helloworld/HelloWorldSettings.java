package nl.tudelft.goal.helloworld;

import java.util.prefs.Preferences;

/**
 * Static object to store settings
 * 
 * @author W.Pasman 27jan2014
 */
public class HelloWorldSettings {
  /**
   * Use the global preference store for this user to store the settings.
   */
  static public Preferences prefs = Preferences.userNodeForPackage(HelloWorldSettings.class);

  /**
   * get preferred x position of top left corner of the window.
   * 
   * @return preferred x pos of top left corner set by user, or 0 by default
   */
  public static int getX() {
    return HelloWorldSettings.prefs.getInt("x", 0);
  }

  /**
   * get preferred y position of top left corner of the window.
   * 
   * @return preferred y pos of top left corner set by user, or 0 by default
   */
  public static int getY() {
    return HelloWorldSettings.prefs.getInt("y", 0);
  }

  /**
   * save the window settings
   * 
   * @param x :x pos of top left corner
   * @param y :y pos of top left corner
   * @param width :width of the window
   * @param height :height of the window
   */
  public static void setWindowParams(int x, int y, int width, int height) {
    HelloWorldSettings.prefs.putInt("x", x);
    HelloWorldSettings.prefs.putInt("y", y);
    HelloWorldSettings.prefs.putInt("width", width);
    HelloWorldSettings.prefs.putInt("height", height);
  }

  /**
   * get the window width. Defaults to 600
   * 
   * @return the window width. Defaults to 600. Minimum 300.
   */
  public static int getWidth() {
    return Math.max(300, HelloWorldSettings.prefs.getInt("width", 600));
  }

  /**
   * get the window height. Defaults to 600
   * 
   * @return the window height. Defaults to 400. Minumum 200
   */

  public static int getHeight() {
    return Math.max(200, HelloWorldSettings.prefs.getInt("height", 400));
  }
}

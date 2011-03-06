package bean_test;

import javax.swing.UIManager;
import java.awt.*;
import sgt.util.EPICSystem;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class BeanTestApp {
  private boolean packFrame = false;

  //Construct the application
  public BeanTestApp() {
    if(EPICSystem.getJavaMajorVersion() == 1 &&
       EPICSystem.getJavaMinorVersion() < 4) {
      System.out.println("Java version must be 1.4 or greater.\n" +
                         "Current version is " +
                         System.getProperty("java.version"));
      System.exit(1);
    }
    BeanTestFrame frame = new BeanTestFrame();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }
  //Main method
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new BeanTestApp();
  }
}
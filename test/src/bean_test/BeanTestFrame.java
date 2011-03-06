/*
 * This software is provided by NOAA for full, free and open release.  It is
 * understood by the recipient/user that NOAA assumes no liability for any
 * errors contained in the code.  Although this software is released without
 * conditions or restrictions in its use, it is expected that appropriate
 * credit be given to its author and to the National Oceanic and Atmospheric
 * Administration should the software be included by the recipient as an
 * element in other product development.
 */
package bean_test;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import sgt.beans.*;
import sgt.AbstractPane;
import sgt.JPane;
import sgt.swing.util.*;
import sgt.swing.JClassTree;
import sgt.geom.SimpleFileFilter;

/**
 *
 * @author Donald Denbo
 * @version $Revision: 1.17 $, $Date: 2003/09/16 19:05:41 $
 * @since 3.0
 * @stereotype bean
 **/
public class BeanTestFrame extends JFrame {
    private JPanel contentPane;
    private BorderLayout borderLayout1 = new BorderLayout();
    private Page page = new Page();
    private PanelModel pModel = new PanelModel();
    private DataModel dModel = new DataModel();
    private JPanel buttonPanel = new JPanel();
    private JButton panelModelButton = new JButton();
    private JButton addDataButton = new JButton();
    private JPanel pagePanel = new JPanel();
    private BorderLayout borderLayout2 = new BorderLayout();
    private JButton treeButton = new JButton();
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenu fileMenu = new JMenu();
    private JMenuItem newMI = new JMenuItem();
    private JMenuItem saveMI = new JMenuItem();
    private JMenuItem loadMI = new JMenuItem();
    private JMenuItem exitMI = new JMenuItem();
    private JMenu helpMenu = new JMenu();
    private JMenuItem aboutMI = new JMenuItem();

    private JFileChooser fileChooser_ = null;
    private JMenu editMenu = new JMenu();
    private JMenuItem panelModelMI = new JMenuItem();
    private JMenuItem addDataMI = new JMenuItem();
    private JMenu viewMenu = new JMenu();
    private JMenuItem classTreeMI = new JMenuItem();
    private JMenuItem printMI = new JMenuItem();
    private JMenuItem pageMI = new JMenuItem();

    private PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();

    //Construct the frame
    public BeanTestFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        //    page.getJPane().setBackground(Color.lightGray);
        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //Component initialization
    private void jbInit() throws Exception  {
        //setIconImage(Toolkit.getDefaultToolkit().createImage(BeanTestFrame.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        this.setJMenuBar(jMenuBar1);
        contentPane.setLayout(borderLayout1);
        this.setSize(new Dimension(500, 430));
        this.setTitle("SGT Bean Test");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    this_windowClosed(e);
                }
            });
        page.setDataModel(dModel);
        page.setPanelModel(pModel);
        panelModelButton.setText("Edit PanelModel");
        panelModelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelModelButton_actionPerformed(e);
                }
            });
        addDataButton.setText("Add Data...");
        addDataButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addDataButton_actionPerformed(e);
                }
            });
        pagePanel.setBorder(BorderFactory.createEtchedBorder());
        pagePanel.setLayout(borderLayout2);
        treeButton.setText("Tree...");
        treeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    treeButton_actionPerformed(e);
                }
            });
        fileMenu.setText("File");
        newMI.setText("New");
        newMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    newMI_actionPerformed(e);
                }
            });
        saveMI.setText("Save...");
        saveMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saveMI_actionPerformed(e);
                }
            });
        loadMI.setText("Load...");
        loadMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadMI_actionPerformed(e);
                }
            });
        exitMI.setText("Exit");
        exitMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exitMI_actionPerformed(e);
                }
            });
        helpMenu.setText("Help");
        aboutMI.setText("About...");
        aboutMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aboutMI_actionPerformed(e);
                }
            });
        editMenu.setText("Edit");
        panelModelMI.setText("PanelModel...");
        panelModelMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelModelMI_actionPerformed(e);
                }
            });
        addDataMI.setText("add Data...");
        addDataMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addDataMI_actionPerformed(e);
                }
            });
        viewMenu.setText("View");
        classTreeMI.setText("Class Tree...");
        classTreeMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    classTreeMI_actionPerformed(e);
                }
            });
        printMI.setText("Print...");
        printMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printMI_actionPerformed(e);
                }
            });
        pageMI.setText("Page Layout...");
        pageMI.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    pageMI_actionPerformed(e);
                }
            });
        contentPane.add(pagePanel,  BorderLayout.CENTER);
        pagePanel.add(page, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(panelModelButton, null);
        buttonPanel.add(addDataButton, null);
        buttonPanel.add(treeButton, null);
        jMenuBar1.add(fileMenu);
        jMenuBar1.add(editMenu);
        jMenuBar1.add(viewMenu);
        jMenuBar1.add(helpMenu);
        fileMenu.add(newMI);
        fileMenu.addSeparator();
        fileMenu.add(loadMI);
        fileMenu.add(saveMI);
        fileMenu.addSeparator();
        fileMenu.add(pageMI);
        fileMenu.add(printMI);
        fileMenu.addSeparator();
        fileMenu.add(exitMI);
        helpMenu.add(aboutMI);
        editMenu.add(panelModelMI);
        editMenu.add(addDataMI);
        viewMenu.add(classTreeMI);
    }
    //Overridden so we can exit when window is closed
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    void panelModelButton_actionPerformed(ActionEvent e) {
        PanelModelEditor pme = new PanelModelEditor(pModel);
        pme.setVisible(true);
    }

    void addDataButton_actionPerformed(ActionEvent e) {
        AddDataFrame adf = new AddDataFrame(page);
        adf.setVisible(true);
    }

    void this_windowClosed(WindowEvent e) {

    }

    void treeButton_actionPerformed(ActionEvent e) {
        JClassTree ct = new JClassTree();
        ct.setModal(false);
        ct.setJPane(page.getJPane());
        ct.setVisible(true);
    }

    void newMI_actionPerformed(ActionEvent e) {

    }

    void saveMI_actionPerformed(ActionEvent e) {
        File file;
        FileFilter filt;
        String ext;
        String outpath;
        String[] xmlFile = new String[]{".xml"};
        SimpleFileFilter xmlFilt = new SimpleFileFilter(xmlFile, "XML Serialized Bean");

        if(fileChooser_ == null) {
            fileChooser_ = new JFileChooser();
        }
        fileChooser_.setFileFilter(fileChooser_.getAcceptAllFileFilter());
        fileChooser_.resetChoosableFileFilters();
        fileChooser_.addChoosableFileFilter(xmlFilt);
        fileChooser_.setFileFilter(xmlFilt);

        int result = fileChooser_.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser_.getSelectedFile();
            filt = fileChooser_.getFileFilter();
            outpath = file.getPath();
            if(filt instanceof SimpleFileFilter) {
                ext = ((SimpleFileFilter)filt).getExtension();
                String name = file.getName().toLowerCase();
                if(!name.endsWith(ext)) {
                    outpath += ext;
                }
            }
            try {
                pModel.saveToXML(new BufferedOutputStream(
                                                          new FileOutputStream(outpath, false)));
            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(this, "Error creating file, rename and try again",
                                              "File Save Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    void loadMI_actionPerformed(ActionEvent e) {
        File file;
        //    FileFilter filt;
        String ext;
        String outpath;
        String[] xmlFile = new String[]{".xml"};
        SimpleFileFilter xmlFilt = new SimpleFileFilter(xmlFile, "XML Serialized Bean");

        if(fileChooser_ == null) {
            fileChooser_ = new JFileChooser();
        }
        fileChooser_.setFileFilter(fileChooser_.getAcceptAllFileFilter());
        fileChooser_.resetChoosableFileFilters();
        fileChooser_.addChoosableFileFilter(xmlFilt);
        fileChooser_.setFileFilter(xmlFilt);

        int result = fileChooser_.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser_.getSelectedFile();
            outpath = file.getPath();
            try {
                pModel = PanelModel.loadFromXML(new BufferedInputStream(
                                                                        new FileInputStream(outpath)));
                page.setPanelModel(pModel);
            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(this, "Error openning file",
                                              "File Open Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidObjectException ioe) {
                JOptionPane.showMessageDialog(this, "File does not contain a PanelModel",
                                              "PanelModel Not Found",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void exitMI_actionPerformed(ActionEvent e) {
        dispose();
        System.exit(0);
    }

    void aboutMI_actionPerformed(ActionEvent e) {

    }

    void addDataMI_actionPerformed(ActionEvent e) {
        AddDataFrame adf = new AddDataFrame(page);
        adf.setVisible(true);
    }

    void panelModelMI_actionPerformed(ActionEvent e) {
        PanelModelEditor pme = new PanelModelEditor(pModel);
        pme.setVisible(true);
    }

    void classTreeMI_actionPerformed(ActionEvent e) {
        JClassTree ct = new JClassTree();
        ct.setModal(false);
        ct.setJPane(page.getJPane());
        ct.setVisible(true);
    }

    void printMI_actionPerformed(ActionEvent e) {
        Color saveColor;
        JPane pane = page.getJPane();

        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(page, pageFormat);
        printJob.setJobName("BeanDemo");
        if(printJob.printDialog()) {
            try {
                RepaintManager currentManager = RepaintManager.currentManager(pane);
                currentManager.setDoubleBufferingEnabled(false);
                printJob.print();
                currentManager.setDoubleBufferingEnabled(true);
            } catch (PrinterException pe) {
                System.out.println("Error printing: " + pe);
            }
        }

    }

    void pageMI_actionPerformed(ActionEvent e) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        pageFormat = printJob.pageDialog(pageFormat);
    }
}
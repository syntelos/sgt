/*
 * $Id: JLogLogDemo.java,v 1.2 2003/08/22 23:02:38 dwd Exp $
 *
 * This software is provided by NOAA for full, free and open release.  It is
 * understood by the recipient/user that NOAA assumes no liability for any
 * errors contained in the code.  Although this software is released without
 * conditions or restrictions in its use, it is expected that appropriate
 * credit be given to its author and to the National Oceanic and Atmospheric
 * Administration should the software be included by the recipient as an
 * element in other product development.
 */
package sgt.demo;

import sgt.sgt.JPane;
import sgt.sgt.Layer;
//import sgt.sgt.PlainAxis;
import sgt.sgt.LogAxis;
import sgt.sgt.LineKey;
//import sgt.sgt.LinearTransform;
import sgt.sgt.LogTransform;
import sgt.sgt.Graph;
import sgt.sgt.CartesianGraph;
import sgt.sgt.SGLabel;
//import sgt.sgt.PointAttribute;
import sgt.sgt.LineAttribute;
import sgt.sgt.LineCartesianRenderer;
import sgt.sgt.StackedLayout;
import sgt.sgt.Axis;
import sgt.swing.JClassTree;
//import sgt.sgt.Logo;

//import sgt.sgt.dm.Collection;
import sgt.sgt.dm.SGTData;

import sgt.geom.Point2D;
import sgt.geom.Range2D;
import sgt.geom.SoTRange;
import sgt.geom.SoTValue;
import sgt.geom.SoTPoint;
import sgt.geom.Dimension2D;

import java.awt.*;
import javax.swing.*;

/**
 * Example demonstrating the creation of a simple
 * graph using LogAxis.
 *
 * @author Donald Denbo
 * @version $Revision: 1.2 $, $Date: 2003/08/22 23:02:38 $
 * @since 3.0
 */

public class JLogLogDemo extends JApplet {
    JButton tree_;
    JButton space_;
    JPane mainPane_;

  public void init() {
    setLayout(new BorderLayout(0,0));
    setSize(553,438);

    add(makeGraph(), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    JLogLogDemo pd = new JLogLogDemo();
    JFrame frame = new JFrame("Log-Log Demo");
    JPanel button = new JPanel();
    JPane graph;
    button.setLayout(new FlowLayout());
    pd.tree_ = new JButton("Tree View");
    MyAction myAction = pd. new MyAction();
    pd.tree_.addActionListener(myAction);
    button.add(pd.tree_);
    pd.space_ = new JButton("Add Mark");
    pd.space_.addActionListener(myAction);
    button.add(pd.space_);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent event) {
	JFrame fr = (JFrame)event.getSource();
	fr.setVisible(false);
	fr.dispose();
	System.exit(0);
      }
    });
    frame.setSize(553,438);
    graph = pd.makeGraph();
    graph.setBatch(true);
    frame.getContentPane().add(graph, BorderLayout.CENTER);
    frame.getContentPane().add(button, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
    graph.setBatch(false);
  }

  JPane makeGraph() {
    /*
     * This example creates a very simple plot from
     * scratch (not using one of the sgt.awt classes)
     * to display log-log line.
     */
    /*
     * Create a Pane, place in the center of the Applet
     * and set the layout to be StackedLayout.
     */
    mainPane_ = new JPane("Point Plot Demo", new Dimension(553,438));
    mainPane_.setLayout(new StackedLayout());
    mainPane_.setBackground(Color.white);
    /*
     * Create a line using the TestData class.
     */
    Range2D xrange;
    SoTRange yrange;
    TestData td;
    SGTData data;
    xrange = new Range2D(50.0, 150000., 1.25);
    td = new TestData(TestData.LOG_LOG, xrange, TestData.RANDOM, 10000.0f, 1.0f, 10.0f);
    data = td.getSGTData();
    yrange = data.getYRange();
    /*
     * xsize, ysize are the width and height in physical units
     * of the Layer graphics region.
     *
     * xstart, xend are the start and end points for the X axis
     * ystart, yend are the start and end points for the Y axis
     */
    double xsize = 4.0;
    double xstart = 0.6;
    double xend = 3.5;
    double ysize = 3.0;
    double ystart = 0.6;
    double yend = 2.75;
    /*
     * Create the layer and add it to the Pane.
     */
    Layer layer;

    layer = new Layer("Layer 1", new Dimension2D(xsize, ysize));
    mainPane_.add(layer);
    /*
     * Create a CartesianGraph and transforms.
     */
    CartesianGraph graph;
    LogTransform xt, yt;

    graph = new CartesianGraph("Log-Log Graph");
    layer.setGraph(graph);
    xt = new LogTransform(xstart, xend, xrange.start, xrange.end);
    yt = new LogTransform(new Range2D(ystart, yend), yrange);
    graph.setXTransform(xt);
    graph.setYTransform(yt);
    /*
     * Create the bottom axis, set its range in user units
     * and its origin. Add the axis to the graph.
     */
    LogAxis xbot;
    String xLabel = "X Label";

    xbot = new LogAxis("Botton Axis");
    xbot.setRangeU(xrange);
    xbot.setLocationU(new SoTPoint(new SoTValue.Double(xrange.start), yrange.getStart()));
    Font xbfont = new Font("Helvetica", Font.ITALIC, 14);
    xbot.setLabelFont(xbfont);
    SGLabel xtitle = new SGLabel("xaxis title", xLabel,
                                 new Point2D.Double(0.0, 0.0));
    Font xtfont = new Font("Helvetica", Font.PLAIN, 14);
    xtitle.setFont(xtfont);
    xtitle.setHeightP(0.2);
    xbot.setTitle(xtitle);
    graph.addXAxis(xbot);
    /*
     * Create the left axis, set its range in user units
     * and its origin. Add the axis to the graph.
     */
    LogAxis yleft;
    String yLabel = "Y Label";

    yleft = new LogAxis("Left Axis");
    yleft.setRangeU(yrange);
    yleft.setLocationU(new SoTPoint(new SoTValue.Double(xrange.start), yrange.getStart()));
    yleft.setLabelFont(xbfont);
    SGLabel ytitle = new SGLabel("yaxis title", yLabel,
                                 new Point2D.Double(0.0, 0.0));
    Font ytfont = new Font("Helvetica", Font.PLAIN, 14);
    ytitle.setFont(ytfont);
    ytitle.setHeightP(0.2);
    yleft.setTitle(ytitle);
    graph.addYAxis(yleft);
    /*
     * Create a LineAttribute for the display of the
     * line.
     */
    LineAttribute lattr;
    lattr = new LineAttribute(LineAttribute.SOLID, Color.red);
    /*
     * Associate the attribute and the line
     * with the graph.
     */
    graph.setData(data, lattr);

    return mainPane_;
  }

    void tree_actionPerformed(java.awt.event.ActionEvent e) {
        JClassTree ct = new JClassTree();
        ct.setModal(false);
        ct.setJPane(mainPane_);
        ct.show();
    }

  class MyAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
           Object obj = event.getSource();
	   if(obj == space_) {
	     System.out.println("  <<Mark>>");
	   }
	   if(obj == tree_)
	       tree_actionPerformed(event);
        }
    }

}

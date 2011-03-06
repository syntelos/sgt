/*
 * This software is provided by NOAA for full, free and open release.  It is
 * understood by the recipient/user that NOAA assumes no liability for any
 * errors contained in the code.  Although this software is released without
 * conditions or restrictions in its use, it is expected that appropriate
 * credit be given to its author and to the National Oceanic and Atmospheric
 * Administration should the software be included by the recipient as an
 * element in other product development.
 */
 
package sgt.geom;

/**
 * A class to encapsulate a <code>double</code> width and a height.
 *
 * @author Donald Denbo
 * @version $Revision: 1.3 $, $Date: 2001/02/09 18:42:30 $
 * @since sgt 1.0
 */
public class Dimension2D
    extends java.awt.geom.Dimension2D
{

    public double height;
    public double width;


    public Dimension2D() {
	super();
	width = 0.0;
	height = 0.0;
    }
    public Dimension2D(double width, double height) {
	super();
	this.width = width;
	this.height = height;
    }


    @Override
    public double getWidth() {
	return width;
    }
    @Override
    public double getHeight() {
	return height;
    }
    @Override  
    public void setSize(double width, double height) {
	this.width = width;
	this.height = height;
    }
    @Override
    public void setSize(java.awt.geom.Dimension2D d) {
	setSize(d.getWidth(), d.getHeight());
    }
    @Override
    public String toString() {
	return getClass().getName() + "[width=" + width + ",height=" + height +
	    "]";
    }
    public boolean equals(Object that){
	if (this == that)
	    return true;
	else if (that instanceof java.awt.geom.Dimension2D)
	    return this.equals( (java.awt.geom.Dimension2D)that);
	else
	    return false;
    }
    public boolean equals(java.awt.geom.Dimension2D d) {
	return (this.width == d.getWidth() && this.height == d.getHeight());
    }
}

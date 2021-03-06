/*
 * This software is provided by NOAA for full, free and open release.  It is
 * understood by the recipient/user that NOAA assumes no liability for any
 * errors contained in the code.  Although this software is released without
 * conditions or restrictions in its use, it is expected that appropriate
 * credit be given to its author and to the National Oceanic and Atmospheric
 * Administration should the software be included by the recipient as an
 * element in other product development.
 */
 
package sgt.plot;

import sgt.Layer;
/**
 * @since 2.x
 */
public class PlotLayer extends Layer {
    public PlotLayerHints getPlotLayerHints(){
        return plotLayerHints_;
    }

    public void setPlotLayerHints(PlotLayerHints plotLayerHints){
        this.plotLayerHints_ = plotLayerHints;
    }

    /**
     * @link aggregation
     * @undirected
     * @label plotLayerHints 
     */
    private PlotLayerHints plotLayerHints_;
}

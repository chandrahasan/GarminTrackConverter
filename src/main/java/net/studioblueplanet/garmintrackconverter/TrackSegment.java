/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.studioblueplanet.garmintrackconverter;


import hirondelle.date4j.DateTime;
import net.studioblueplanet.logger.DebugLogger;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jorgen
 */
public class TrackSegment
{
    private DateTime                startTime;
    private DateTime                endTime;
    private double                  elapsedTime;
    private ArrayList<TrackPoint>   trackPoints;
    
    /**
     * Constructor. Sets the parameters that defines the lap
     * @param startTime Start time of the lap
     * @param endTime End time of the lap
     * @param elapsedTime Elapsed time in seconds
     */
    public TrackSegment(DateTime startTime, DateTime endTime, double elapsedTime)
    {
        this.startTime  =startTime;
        this.endTime    =endTime;
        this.elapsedTime=elapsedTime;
        trackPoints     =new ArrayList<TrackPoint>();
    }
    
    /**
     * This method returns whether the indicated timestamp lies within the lap.
     * @param time Timestamp to check
     * @return True if the timestamp is within the lap, false if not.
     */
    public boolean isInLap(DateTime time)
    {
        boolean inLap;
        
        inLap=false;
        
        if (time.gteq(startTime) && time.lt(endTime))
        {
            inLap=true;
        }
        return inLap;
    }
    
    /**
     * Add a track point to the segment
     * @param trackPoint Track point to add
     */
    public void addTrackPoint(TrackPoint trackPoint)
    {
        trackPoints.add(trackPoint);
    }

    /**
     * Return the track point at given index
     * @param index The index
     * @return The track point or null if not found
     */
    public TrackPoint getTrackPoint(int index)
    {
        TrackPoint point;
        
        if (index>=0 && index<trackPoints.size())
        {
            point=trackPoints.get(index);
        }
        else
        {
            point=null;
        }
        return point;
    }
    
    /**
     * Get the array list with track points belonging to this segment
     * @return The array list with track points
     */
    public ArrayList<TrackPoint> getTrackPoints()
    {
        return this.trackPoints;
    }
    
    /**
     * Returns the number of track points in this segment
     * @return Number of points.
     */
    public int getNumberOfTrackPoints()
    {
        return this.trackPoints.size();
    }
}

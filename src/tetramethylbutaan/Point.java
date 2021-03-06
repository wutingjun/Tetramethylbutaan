package tetramethylbutaan;

import java.util.HashMap;

public class Point
{
	public static int nrDimensions = 400;
    public static HashMap<Integer, Integer> classesToIndex;
    public static int[] classes;
	protected double[] features;
	protected int classification = 0;

	public Point()
	{
		features = new double[nrDimensions];
		for(int i = 0; i< features.length; i++)
			features[i] = 0;
	}
	
	public Point(double[] features)
	{
		this.features = features;
	}
	
	public Point(double[] features, int c)
	{
		this(features);
		setClassification(c);
	}

    public static void setClasses(int[] classes)
    {
        Point.classes = classes;
        int i = 0;
        classesToIndex = new HashMap<Integer, Integer>();
        for (int c : classes)
        {
            classesToIndex.put(c, i);
            i++;
        }
    }

    public static int getClassIndex(int classification)
    {
        return classesToIndex.get(classification);
    }

    public double[] getFeatures()
    {
        return features;
    }
	
	public double euclideanDistance2(Point p)
	{
		double distance = 0;
		for (int i = 0; i < nrDimensions; i++)
		{
			double featureDistance2 = features[i] - p.features[i];
			featureDistance2 *= featureDistance2;
			distance += featureDistance2;
		}
		return distance;
	}
	
	public void setClassification(int c)
	{
		classification = c;
	}
	
	public boolean equals(Point p)
	{
		for (int i = 0; i < nrDimensions; i++)
		{
			if (features[i] != p.features[i])
				return false;
		}
		return true;
	}
	
	public int getClassification()
	{
		return classification;
	}
}

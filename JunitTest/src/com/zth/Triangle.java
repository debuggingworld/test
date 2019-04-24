package com.zth;

public class Triangle
{
    protected long lborderA = 0;
    protected long lborderB = 0;
    protected long lborderC = 0;

    public Triangle(long lborderA, long lborderB, long lborderC)
    {
        this.lborderA = lborderA;
        this.lborderB = lborderB;
        this.lborderC = lborderC;
    }

    public boolean isTriangle(Triangle triangle)
    {
        boolean isTriangle = false;
        if((triangle.lborderA > 0 && triangle.lborderA <= Long.MAX_VALUE)
                && (triangle.lborderB > 0 && triangle.lborderB <= Long.MAX_VALUE)
                && (triangle.lborderC > 0 && triangle.lborderC <= Long.MAX_VALUE))
        {
            if(diffOfBorders(triangle.lborderA, triangle.lborderB) < triangle.lborderC
                    && diffOfBorders(triangle.lborderB, triangle.lborderC) < triangle.lborderA
                    && diffOfBorders(triangle.lborderC, triangle.lborderA) < triangle.lborderB)
            {
                isTriangle = true;
            }
        }
        return isTriangle;
    }

    public String getType(Triangle triangle)
    {
        String strType = "Illegal";
        if(isTriangle(triangle))
        {
            if(triangle.lborderA == triangle.lborderB && triangle.lborderB == triangle.lborderC)
            {
                strType = "Regular";
            }
            else
                if((triangle.lborderA != triangle.lborderB)
                        && (triangle.lborderB != triangle.lborderC)
                        && (triangle.lborderA != triangle.lborderC))
                {
                    strType = "Scalene";
                }
                else
                {
                    strType = "Isosceles";
                }
        }
        return strType;
    }

    public long diffOfBorders(long a, long b)
    {
        return (a > b) ? (a - b) : (b - a);
    }

    public long[] getBorders()
    {
        long[] borders = new long[3];
        borders[0] = this.lborderA;
        borders[1] = this.lborderB;
        borders[2] = this.lborderC;
        return borders;
    }
}
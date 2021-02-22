package edu.temple.cis3515_assignment3;

public class Cat
{
    private String name, desc;
    private int imageID;

    public Cat(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setImgID(int id)
    {
        this.imageID = id;
    }

    public int getImgID()
    {
        return this.imageID;
    }
}

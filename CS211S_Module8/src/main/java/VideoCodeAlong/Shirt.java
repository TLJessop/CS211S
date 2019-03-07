package VideoCodeAlong;

import java.awt.*;

public class Shirt extends Clothing {

    //Instance data
    private Color color;

    //Constructor
    public Shirt(String name, Size size, Color color){
        super(name, size);
        this.color = color;
    }

    @Override
    public String toString(){
        return super.toString() + " Color = R " + color.getRed() + " G " + color.getGreen() + " B " + color.getBlue();
    }

}//Shirt

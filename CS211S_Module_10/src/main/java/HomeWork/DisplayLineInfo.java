package HomeWork;

import javafx.scene.shape.Line;

import java.text.DecimalFormat;

@FunctionalInterface
public interface DisplayLineInfo {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ, ANGLE;
    }

    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {

        DecimalFormat format = new DecimalFormat("#.##");

        if (type ==  InfoType.MIDPOINT){
            return line -> {
                double xCenter = (line.getStartX() + line.getEndX()) / 2;
                double yCenter = (line.getStartY() + line.getEndY() ) / 2;

               return "The midpoint of the line is at " + xCenter + " x and  " + yCenter + " y" ;
            };
        }

        if ( type == InfoType.DISTANCE){
            return line -> {
                return "The distance of the line is " + format.format(Math.hypot(Math.abs(line.getEndY() - line.getStartY()), Math.abs(line.getEndX() - line.getStartX())));
            };
        }

        if (type == InfoType.VERTHORZ){
            return line -> {
                if (Double.compare(line.getStartX(),line.getEndX()) == 0){
                    return "The line is horizontal";
                }

                if (Double.compare(line.getStartY(),line.getEndY()) == 0){
                    return "The line is vertical";
                }

                return "The line is neither perfectly vertical or horizontal";
            };
        }

        if (type == InfoType.ANGLE){
            return line -> {
                return "The angle of the line is " + format.format( Math.toDegrees(Math.atan2((line.getEndY() - line.getStartX()),(line.getEndX() - line.getStartX()))));
            };
        }
      return null;
    }

}

package defaultmethod;

public interface Shape {

    void draw();

    default void setColor(String color){
        System.out.println("Draw shpe with color: " + color);
    }

}

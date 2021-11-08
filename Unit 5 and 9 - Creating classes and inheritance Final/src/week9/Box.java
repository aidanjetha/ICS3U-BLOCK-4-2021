package week9;

public class Box extends Rectangle {
    /**
     * If you do not explicitly write a constructor then Java will explicitly write one for you 
       that takes NO ARGUMENTS and calls the parent class' no argument constructor.
     */
    
    
    /**
     * public Box() {
        super(); // Super refers to the parent class
    }
     */

     private int height;

    public Box(int l, int w, int h){
        /**
        // We do not get to directly access the parent class's private attributes and methods
        length = l;
        width = w;
        */
        
        // First statement of a constructor MUST be a call to the classes parent constructor
        //If you do not explicitly do it then Java will implicitly do it by calling the - 
        // - no-arg parent constructor

        super(l,w);
        height = h;
    }

    public Box(int side){
        super(side);
        height = side;
    }

    public int getArea(){
        return 2 *  super.getArea() + 2 * getWidth() * height + 2 * getLength() * height;
    }

    public int getPerimeter() {
        return 2 * super.getPerimeter() + 4 * height;
    }

    public boolean equals(Object obj){
    if (super.equals(obj)) {
        if (obj instanceof Box){
            return height == ((Box) obj).height;
        }
    }
    return false;
}
}

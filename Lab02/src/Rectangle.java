public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    private int area;

    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;

    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setX(int x) {this.x = x; }
    public void setY(int y) {this.y = y; }
    public void setWidth(int width) {
        if (width <= 0){
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }
    public void setHeight(int height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }
    public boolean equals(Rectangle r) {
        return r.width == this.width && r.height == this.height;
    }
    public int getArea(){
        this.area = this.width * this.height;
        return this.area;
    }
    public boolean contains(Rectangle innerRectangle){
        return innerRectangle.x >= this.x && innerRectangle.y >= this.y && innerRectangle.x + innerRectangle.width <= this.x + this.width && innerRectangle.y + innerRectangle.height <= this.y + this.height;
    }

}

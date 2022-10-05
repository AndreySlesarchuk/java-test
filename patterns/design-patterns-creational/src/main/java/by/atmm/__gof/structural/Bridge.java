package by.atmm.__gof.structural;

public class Bridge {
    public static void main(String[] args) {
        Shape square = new Square(new Red()); //a square with red color
        System.out.println(square.draw());

        Shape triangle = new Triangle(new Green()); //a triangle with green color
        System.out.println(triangle.draw());
    }
}

// Shapes
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public String draw();
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}

class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Triangle drawn. " + color.fill();
    }
}

// Colors
interface Color {
    String fill();
}

class Green implements Color {
    @Override
    public String fill() {
        return "Color is Green";
    }
}

class Red implements Color {
    @Override
    public String fill() {
        return "Color is Red";
    }
}


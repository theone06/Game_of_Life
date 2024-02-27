abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {
    protected double sideA;
    protected double sideB;
    protected double sideC;

    Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    double getArea() {
       double s = sideA + sideB + sideB / 2;
       double A = s * (s - sideA) * (s - sideB) * (s - sideC);
       return Math.sqrt(A);
    }
}
class Rectangle extends Shape {
    protected double length;
    protected double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    double getArea() {
        return length * width;
    }
}
class Circle extends Shape {
    protected double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
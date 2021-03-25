package schoolTest;

interface Shape{
    double size();
}
class Triangle implements Shape{
    double x,y;
    Triangle(double a,double b){
      x=a;
      y=b;
    }
    public double size(){
        return x*y;
    }
}
class Circle implements Shape{
    double r;
    Circle(double a){
        r=a;
    }
    public double size(){
        return 3.14*r*r;
    }
}
class Cylinder implements Shape{
    double h,r;
    Cylinder(double a,double b){
        h=a;
        r=b;
    }
    public double size(){
        return h*2*3.14*r;
    }
}
public class t8_3_2 {
    public static void main(String[] args) {
        Shape s[] = new Shape[3];
        s[0] = new Triangle(1,2);
        s[1] = new Circle(2);
        s[2] = new Cylinder(2,2);
        System.out.println(s[0].size());
        System.out.println(s[1].size());
        System.out.println(s[2].size());
    }
}

package schoolTest;
abstract class Fruit{
    abstract String getWeight();
    double weight;
}
class Apple extends Fruit{
    Apple(double a){
        weight = a;
    }
    public String getWeight(){
        return "重量："+weight;
    }
}
class Peach extends Fruit{
    Peach(double a){
        weight = a;
    }
    public String getWeight(){
        return "重量："+weight;
    }
}
class Orange extends Fruit{
    Orange(double a){
        weight = a;
    }
    public String getWeight(){
        return "重量："+weight;
    }
}
public class t8_3_3 {
    public static void main(String[] args) {
        Fruit f[] = new Fruit[3];
        f[0] = new Apple(3);
        f[1] = new Peach(4);
        f[2] = new Orange(5);
        for (int i=0;i<f.length;i++){
            System.out.println(f[i].getClass().getName()+f[i].getWeight());
        }
    }
}

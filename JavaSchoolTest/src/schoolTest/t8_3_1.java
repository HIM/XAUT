package schoolTest;

interface Show{
    String display();
}
class Notice implements Show{
    public String display() {
        return "通知信息";
    }
}
class Car implements Show{
    public String display() {
        return "汽车油量";
    }
}
class Advertising implements Show{
    public String display() {
        return "广告消息";
    }
}

public class t8_3_1 {
    public static void main(String[] args) {
        Show s[] = new Show[3];
        s[0] = new Notice();
        s[1] = new Car();
        s[2] = new Advertising();
        System.out.println(s[0].display());
        System.out.println(s[1].display());
        System.out.println(s[2].display());
    }
}

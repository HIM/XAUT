package schoolTest;
import java.util.*;
public class t14_3_1 {
    public static void main(String[] args) {
        LinkedList<Stu> stu = new LinkedList<Stu>();
        stu.add(new Stu("318001","ZhangSan",21,"Man"));
        stu.add(new Stu("318002","LiSi",20,"Man"));
        stu.add(new Stu("318003","WangMaZi",21,"Man"));
        System.out.println("原学生名单：");
        for(int i=0;i<stu.size();i++){
            System.out.println(stu.get(i).Show());
        }
        int k = 0,kk=0,agee;
        String noo,namee,sexx;
        Scanner in = new Scanner(System.in);
        while(kk==0){
            System.out.println("展示所有学生输入1，增加学生输入2，删除学生输入3：");
            k = in.nextInt();
            switch (k){
                case 1:
                    System.out.println("  学号  姓名  年龄  性别  ");
                    for(int i=0;i<stu.size();i++){
                        System.out.println(stu.get(i).Show());
                    }
                    System.out.println("继续，输入0；退出，输入1：");
                    kk=in.nextInt();
                    break;
                case 2:
                    System.out.println("请按顺序输入学号，姓名，年龄，性别：");
                    noo = in.next();
                    namee = in.next();
                    agee = in.nextInt();
                    sexx = in.next();
                    stu.add(new Stu(noo,namee,agee,sexx));
                    System.out.println("新增后学生名单：");
                    for(int i=0;i<stu.size();i++){
                         System.out.println(stu.get(i).Show());
                    }
                    System.out.println("继续，输入0；退出，输入1：");
                    kk=in.nextInt();
                    break;
                case 3:
                    System.out.println("输入要删除的学号：");
                    String no = in.next();
                    for(int i=0;i<stu.size();i++){
                        if(no.equals(stu.get(i).getNo())){
                            stu.remove(i);
                        }
                    }
                    System.out.println("删除后学生名单：");
                    for(int i=0;i<stu.size();i++){
                        System.out.println(stu.get(i).Show());
                    }
                    System.out.println("继续，输入0；退出，输入1：");
                    kk=in.nextInt();
                    break;
            }
        }
    }
}

class Stu{
    String No;
    String Name;
    int age;
    String sex;
    Stu(String No,String Name,int age,String sex){
        this.No = No;
        this.Name = Name;
        this.age = age;
        this.sex = sex;
    }
    String Show(){
        return No+" "+Name+" "+age+" "+sex;
    }
    String getNo(){
        return No;
    }
}
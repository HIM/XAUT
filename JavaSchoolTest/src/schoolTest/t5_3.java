package schoolTest;

public class t5_3 {
    public static void main(String[] args) {
        Studen s1 = new Studen("Rui","w",20);
        s1.childen = new Perso[3];
        s1.childen[0] = new Perso("q");
        s1.childen[1] = new Perso("w");
        s1.childen[2] = new Perso("e");
        System.out.println(s1.getChilden());


    }
}

class Studen{
    String name;
    String sex;
    int age;
    Perso[] childen;
    Studen(String n,String s,int a){
        name = n;sex = s;age = a;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    String getSex(){
        return sex;
    }
    String getChilden(){
        int n = childen.length;
        return childen[0].name;
//        for(int i=1;i<n;i++){
//
//        }
    }
}

class Perso{
    String name;
    Perso(String n){
        name = n;
    }
    String getName(){
        return name;
    }
}
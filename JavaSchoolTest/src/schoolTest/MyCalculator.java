package schoolTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalculator extends JFrame {

    String result;

    String str = "";

    JFrame frame = new JFrame("Calculator");    //主窗口
    JTextField textField = new JTextField(result,20);        //文本框
    JButton clear_Button = new JButton("C");     //清除按钮

    JButton button0 = new JButton("0");         //数字按钮
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");

    JButton button_Point = new JButton(".");        //运算按钮
    JButton button_Plus = new JButton("+");
    JButton button_Minus = new JButton("-");
    JButton button_Multiply = new JButton("*");
    JButton button_Division = new JButton("/");
    JButton button_Equal = new JButton("=");

    public MyCalculator(){
        textField.setHorizontalAlignment(JTextField.RIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button_Division);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button_Multiply);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button_Plus);
        panel.add(button_Point);
        panel.add(button0);
        panel.add(button_Equal);
        panel.add(button_Minus);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(textField,BorderLayout.WEST);
        panel2.add(clear_Button,BorderLayout.EAST);

        frame.setLocation(800,400);
        frame.setResizable(true);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel2,BorderLayout.NORTH);
        frame.getContentPane().add(panel,BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        int[] sub = new int[10];                    //sub[]存 运算符的下标

        class Listener_Clear implements ActionListener{             //clear清除按钮
            public void actionPerformed(ActionEvent e){
                str = "";
                textField.setText(str);
                for(int i=0;i<10;i++){
                    sub[i] = 0;
                }
            }
        }

        class Listener_Number implements ActionListener{            //123数字按钮
            public void actionPerformed(ActionEvent e){
                String s = ((JButton) e.getSource()).getText();
                str = str + s;
                textField.setText(str);
            }
        }


        class Listener_Point implements ActionListener{             //小数点按钮
            public void actionPerformed(ActionEvent e){
                String s = ((JButton) e.getSource()).getText();

                int j = 0;
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                        sub[j] = i;
                        j++;
                    }
                }

                int t = 0;  //标记是否末尾数字有小数点

                if(str==""){
                    str = "0.";
                    textField.setText(str);
                }else if(str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/")){
                    str += "0.";
                    textField.setText(str);
                }else if(j==0){           //目前只有一个数字
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)=='.'){
                            t++;
                        }
                    }
                    if(t==0){       //t==0代表第一个数无小数点
                        str += '.';
                        textField.setText(str);
                        t=0;
                    }
                }else  if(j==1){       //目前考察的是第二个数字
                    for(int i=sub[0];i<str.length();i++){
                        if(str.charAt(i)=='.'){
                            t++;
                        }
                    }
                    if(t==0){       //t==0代表第二个数无小数点
                        str += '.';
                        textField.setText(str);
                        t=0;
                    }
                }else  if(j==2){       //目前考察的是第三个数字
                    for(int i=sub[1];i<str.length();i++){
                        if(str.charAt(i)=='.'){
                            t++;
                        }
                    }
                    if(t==0){       //t==0代表第二个数无小数点
                        str += '.';
                        textField.setText(str);
                        t=0;
                    }
                }
                else {
                    str += s;
                    textField.setText(str);
                }
            }
        }

        class Listener_Signal implements ActionListener{             //运算符按钮
            public void actionPerformed(ActionEvent e){
                String s = ((JButton) e.getSource()).getText();
                if(!str.endsWith("+")&&!str.endsWith("-")&&!str.endsWith("*")&&!str.endsWith("/")){
                    str = str + s;
                    textField.setText(str);
                }
            }
        }

        class Listener_Equal implements ActionListener{             //等号按钮
            public void actionPerformed(ActionEvent e){

                int j = 0;
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                        sub[j] = i;
                        j++;
                    }
                }
                if(sub[1]==0){                                              //只有一个运算符
                    String str1 = str.substring(0,sub[0]);
                    String str2 = str.substring(sub[0]+1,str.length());
                    double num1 = Double.parseDouble(str1);
                    double num2 = Double.parseDouble(str2);
                    if(str.charAt(sub[0])=='+'){
                        num1 += num2;
                        str = "" + num1;
                        textField.setText(str);
                    }
                    if(str.charAt(sub[0])=='-'){
                        num1 -= num2;
                        str = "" + num1;
                        textField.setText(str);
                    }
                    if(str.charAt(sub[0])=='*'){
                        num1 *= num2;
                        str = "" + num1;
                        textField.setText(str);
                    }
                    if(str.charAt(sub[0])=='/'){
                        num1 /= num2;
                        str = "" + num1;
                        textField.setText(str);
                    }
                }
                if(sub[2]==0){
                    String str1 = str.substring(0,sub[0]);
                    String str2 = str.substring(sub[0]+1,sub[1]);
                    String str3 = str.substring(sub[1]+1,str.length());
                    double num1 = Double.parseDouble(str1);
                    double num2 = Double.parseDouble(str2);
                    double num3 = Double.parseDouble(str3);
                    if(str.charAt(sub[0])=='*'){
                        num1 *= num2;
                        if(str.charAt(sub[1])=='+'){
                            num1 += num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='-'){
                            num1 -= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='*'){
                            num1 *= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='/'){
                            num1 /= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                    }
                    if(str.charAt(sub[0])=='/'){
                        num1 /= num2;
                        if(str.charAt(sub[1])=='+'){
                            num1 += num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='-'){
                            num1 -= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='*'){
                            num1 *= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='/'){
                            num1 /= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                    }
                    if(str.charAt(sub[0])=='+'){
                        if(str.charAt(sub[1])=='*'){
                            num2 *= num3;
                            num1 += num2;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='/'){
                            num2 /= num3;
                            num1 += num2;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='+'){
                            num1 += num2;
                            num1 += num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='-'){
                            num1 += num2;
                            num1 -= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                    }
                    if(str.charAt(sub[0])=='-'){
                        if(str.charAt(sub[1])=='*'){
                            num2 *= num3;
                            num1 -= num2;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='/'){
                            num2 /= num3;
                            num1 -= num2;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='+'){
                            num1 -= num2;
                            num1 += num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                        if(str.charAt(sub[1])=='-'){
                            num1 -= num2;
                            num1 -= num3;
                            str = "" + num1;
                            textField.setText(str);
                        }
                    }
                }

            }
        }



        // 监听等于键
        Listener_Equal listener_equal = new Listener_Equal();
        Listener_Signal listener_signal = new Listener_Signal();
        Listener_Clear listener_clear = new Listener_Clear();
        Listener_Point listener_point = new Listener_Point();
        Listener_Number listener_number = new Listener_Number();

        button7.addActionListener(listener_number);
        button8.addActionListener(listener_number);
        button9.addActionListener(listener_number);
        button_Division.addActionListener(listener_signal);
        button4.addActionListener(listener_number);
        button5.addActionListener(listener_number);
        button6.addActionListener(listener_number);
        button_Multiply.addActionListener(listener_signal);
        button1.addActionListener(listener_number);
        button2.addActionListener(listener_number);
        button3.addActionListener(listener_number);
        button_Minus.addActionListener(listener_signal);
        button_Point.addActionListener(listener_point);
        button0.addActionListener(listener_number);
        button_Equal.addActionListener(listener_equal);
        button_Plus.addActionListener(listener_signal);
        clear_Button.addActionListener(listener_clear);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new MyCalculator();
    }
}

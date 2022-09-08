import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

class windowApp{
    private int random;
    JFrame win,row1,row2,row3;
    Label lbl1,lbl2,result;
    TextField inputnum1,textinputnum2;
    JButton btnSubmit;
    windowApp(int random){
        this.random=random;
        win=new JFrame("Guess the Number !");
        lbl1=new Label("Enter Your Guess : ");
        lbl1.setPreferredSize(new Dimension(220,26));
        inputnum1=new TextField("Enter yoru guess here");
        inputnum1.setPreferredSize(new Dimension(220,26));
        lbl2=new Label("Result");
        lbl2.setPreferredSize(new Dimension(220,26));
        result=new Label("Make your first guess");
        result.setPreferredSize(new Dimension(220,26));
        btnSubmit=new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(100,50));

        win.add(lbl1);
        win.add(inputnum1);
        win.add(lbl2);
        win.add(result);
        win.add(btnSubmit);
        
        win.setLayout(new FlowLayout());
        win.setSize(600,250);
        win.setVisible(true);
        win.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                win.dispose();
            }
        });
        btnSubmit.addActionListener(new ButtonClickListener(win,inputnum1,result,random));

    }
    
    public void numberCheck(int userval){
        if(random<userval){
            System.out.println("Your guess was higher than the number");
        }
        else if(random>userval){
            System.out.println("Your guess was lower than the number");
        }
        else if(random==userval){
            System.out.println("Correct Guess");
        }
    }
}
class ButtonClickListener extends Exception implements ActionListener{
    JFrame win;
    Label result;
    TextField inputnum1,textinputnum2;
    int random;
    ButtonClickListener(JFrame win, TextField inputnum1, Label result, int random){
        this.win = win;
        this.inputnum1=inputnum1;
        this.result=result;
        this.random=random;
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String num=inputnum1.getText();
        int n1=0;
        try{
            n1=Integer.parseInt(num);
        }
        catch(Exception ex){
            System.out.println("Please enter a valid number");
        }
        if(command.equals("Submit")){
            if(random<n1){
                System.out.println("Your guess was higher than the number");
                result.setText("Your guess was higher than the number");

            }
            else if(random>n1){
                System.out.println("Your guess was lower than the number");
                result.setText("Your guess was lower than the number");
            }
            else if(random==n1){
                System.out.println("Correct Guess");
                result.setText("Correct Guess You Won!👍");
                win.getContentPane().setBackground(Color.BLUE);
                // win.removeAll();
            }
        }
    }
}

public class mainfunction {
    public static void main(String[] args) {
        Random randomobj = new Random(); 
        int random=randomobj.nextInt(100);
        System.out.println(random);
        windowApp obj=new windowApp(random);
        obj.getClass();
    }
}

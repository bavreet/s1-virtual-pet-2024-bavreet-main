/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
public class VirtualPet {
    int sick = 0;
    VirtualPetFace face;
    int hunger = 5;   // how hungry the pet is.
    int mood = 5; 
    boolean diaperChanged = true;
    boolean sleep = false;
    int Age = 0;
    boolean play = false;
    boolean mean = false;
    boolean gentle = false;
    Component frame;
    boolean Glutton = false;
    boolean Anorexia = false;
    



    // Object[] options = {"Mean",
    //                 "Gentle",
    //                 "Neither"};
    // private Component frame;
// int n = JOptionPane.showOptionDialog(frame,
//     "Would you like your pet to be Mean, Gentle or Neither?",
//     "A Silly Question",
//     JOptionPane.YES_NO_CANCEL_OPTION,
//     JOptionPane.QUESTION_MESSAGE,
//     null,
//     options,
//     options[2]);{
//     if (n = ){
//         mean = true;
//     }else if (n.equals("Gentle")){
//         gentle = true;
//     }
// }
    

    public void Mood(){
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Would you like your pet to be Glutton, Anorexia or \n                                      Neither",
                    "Trait Question",
                    JOptionPane.PLAIN_MESSAGE
);{
if(s.equals("Glutton")){
    sick += 50;
    Glutton = true;
}
if(s.equals("Anorexia")){
    sick += 50;
    Anorexia = true;
}
if(s.equals("Neither")){
    sick += 10;
}
}
        if (sick >= 70){
            face.setImage("verysick");
            face.setMessage("Very Sick");
            JOptionPane.showMessageDialog(frame,"your pet is very sick because of its eating habits \n if this keeps up your pet will die!");
            waitAMomemnt(2);
        }else if (sick > 40 && sick < 70){
            face.setImage("sick");
            face.setMessage("Sick");
            JOptionPane.showMessageDialog(frame,"   Your pet is prone to sickness because of its eating habbit  \n make sure to keep it exercising and moniter how much it eats");
            waitAMomemnt(2);
        }else if (sick < 40){
            face.setImage("ecstatic");
            waitAMomemnt(2);
            JOptionPane.showMessageDialog(frame,"Your pet eating habbits are Great! \n                  keep it up!");
        }
        JOptionPane.showMessageDialog(frame,"your starting hunger is " + hunger + "try to keep your hunger between 4 and 7");
    }

    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
    }
    
    public void waitAMomemnt(int seconds){
        try {
            Thread.sleep(1000); //milliseconds
        } catch(Exception e){

        }
}
    public void feed() {
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "How much food can i eat?",
                    "Food question",
                    JOptionPane.PLAIN_MESSAGE
);{
// if(s.equals("mean")){
//     mood = 1;
// }
int test = 0;
try{
    test = Integer.parseInt(s);
}catch(Exception e){
    s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Pls answer in a number",
                    "Food question",
                    JOptionPane.PLAIN_MESSAGE
);{
}
}
        hunger -= test;
        JOptionPane.showMessageDialog(frame,"your hunger is " + hunger );
        if (hunger >= 10){
            face.setMessage("UHGGG NOO!!! I didn't eat enough");
            face.setImage("dead");
        }else if (hunger > 7){

            if ((Glutton || Anorexia) || sick > 50){
                JOptionPane.showMessageDialog(frame,"Your pet eating habbits are terrible!");
                sick +=15;
            }
            else{
                sick += 15;
            }

            face.setMessage("UUHgG I am Starving!!");
            face.setImage("starving");
        }else if (hunger >= 4){
            face.setImage("normal");

            if ((Glutton || Anorexia) || sick > 50){
                sick -= 15;
                JOptionPane.showMessageDialog(frame,"Your pet eating habbits are Great! \n                  keep it up!");
            }else{
                sick -=15;
            }
            face.setMessage("I ate the perfect amount :!");
        }else if (hunger > 0 && hunger < 4){
            JOptionPane.showMessageDialog(frame,"Your pet eating habbits are terrible!");
                sick +=15;
            face.setMessage("I am way too full!!");
            face.setImage("sick");
        }else if (hunger <= 0){
            face.setMessage("AGH I ate to death");
            face.setImage("dead");
        }
        
        
    }
}


    
    public void exercise() {
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "How much should i exersise?",
                    "Workout question",
                    JOptionPane.PLAIN_MESSAGE
);{
int test = 0;
try{
    test = Integer.parseInt(s);
}catch(Exception e){
    s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Pls answer in a nummber",
                    "Workout question",
                    JOptionPane.PLAIN_MESSAGE
);{
}
}
hunger = hunger + test;
}
        face.setMessage("Whew!");
        face.setImage("exercise");
    }
    
    public void sleep() {
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Would you like your pet to be Mean, Gentle or Neither",
                    "Personality question",
                    JOptionPane.PLAIN_MESSAGE
);{
if(s.equals("mean")){
    mood = 1;
}
}
        hunger = hunger + 1;
        sleep = true;
        face.setImage("asleep");
    }

    public void play(){
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Would you like your pet to be Mean, Gentle or Neither",
                    "Personality question",
                    JOptionPane.PLAIN_MESSAGE
);{
if(s.equals("mean")){
    mood = 1;
}
}
        hunger = hunger -2;
        mood = mood + 1;
        play = true;
        face.setMessage("That was fun!");
        face.setImage("ecstatic");
    }

    public void diaperChanged(){
        face.setImage("astonished");
        diaperChanged = true;
    }

    
} // end Virtual Pet

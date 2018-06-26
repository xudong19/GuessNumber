/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessnumber;

import java.lang.Math;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;




public class myTextFieldF extends JFrame {
    private final JTextField textField1; // text field with set size
    private final JLabel label1; // JLabel with just text
    private final JLabel label2; // JLabel with just text
    private final JLabel label3; // JLabel with just text
    private final JButton resetJButton; // JLabel with just text
    public int randomNumber;
    
    public myTextFieldF (){
 
      super("This is a guess number game ^_^");
      getContentPane().setBackground(Color.WHITE);
      setRandomNumber((int)(Math.random()*(1000-1)) + 1); 
      
      
      setLayout(new FlowLayout());
      textField1 = new JTextField(10); 
      add(textField1); // add textField1 to JFrame
      
      
      setLayout(new FlowLayout()); // set frame layout
      // JLabel constructor with a string argument
      label1 = new JLabel("Enter your guess here");
      add(label1); // add label1 to JFrame
      
      setLayout(new FlowLayout()); // set frame layout
      // JLabel constructor with a string argument
      label2 = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
      add(label2); // add label1 to JFrame
      
      setLayout(new FlowLayout()); // set frame layout
      // JLabel constructor with a string argument
      label3 = new JLabel("Please enter your first guess");
      add(label3); // add label1 to JFrame
      
      
      setLayout(new FlowLayout());
      resetJButton = new JButton("Reset");
      add(resetJButton);

      
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      
      ButtonHandler handler2 = new ButtonHandler();
      resetJButton.addActionListener(handler2);
 
        
    }
    
    void setRandomNumber(int randonumber){  
        randomNumber = randonumber;     
    }
    
    int getRandomNumber(){
        return(randomNumber);
    }
    
   private class ButtonHandler implements ActionListener{
      // handle button event
      @Override
      public void actionPerformed(ActionEvent event){ 
          setRandomNumber((int)(Math.random()*(1000-1)) + 1);
          getContentPane().setBackground(Color.WHITE);
          label1.setText("Enter your guess here");
          label2.setText("The random number was successfully reset!\n");
          label3.setText("Please eneter your first guess");
          textField1.setEditable(true);
          
          
      }
   }
    
   private class TextFieldHandler implements ActionListener{
      // process textfield events
      @Override
      public void actionPerformed(ActionEvent event)
      {
         
          int randomnum = getRandomNumber();
          int guessnumber = Integer.parseInt(event.getActionCommand());

          
          if(guessnumber > randomnum){
              label1.setText("Too high!");
              label2.setText("");
              label3.setText("");
              getContentPane().setBackground(Color.red);
          }
          else if(guessnumber < randomnum){
              label1.setText("Too low!");
              label2.setText("");
              label3.setText("");
              getContentPane().setBackground(Color.blue);
          }
          else{
              label1.setText("Correct!!!\n");
              label2.setText("Congratulations!!\n");
              label3.setText("Click the Reset button if you want to continue");
              getContentPane().setBackground(Color.LIGHT_GRAY);
              textField1.setEditable(false);
              
          }
          
          
          
      } 
   } // end private inner class TextFieldHandler
    
    
    
}
    
    
    
    
    


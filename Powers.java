/**
 * Created by Shane Bishop
 * on October 9, 2015
 * as an assignment (12 U1A7) for Mr. Koivisto
 * to calculate the results of raising a base to a given exponent.
 */
package powers;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Powers extends JFrame {
    // Creates new JLables
    JLabel titleLabel = new JLabel(); // Creates new JLabel titleLabel
    JLabel baseLabel = new JLabel();  // Creates new JLabel baseLabel
    JLabel expLabel = new JLabel();   // Creates new JLabel expLabel
    
    // Creates new JTextFields
    JTextField baseField = new JTextField(); // Creates new JTextField baseField
    JTextField expField = new JTextField();  // Creates new JTextField expField
    
    // Creates new JButtons
    JButton calcButton = new JButton(); // Creates new JButton calcButton
    JButton exitButton = new JButton(); // Creates new JButton exitButton
    
    JScrollPane outputPane = new JScrollPane(); // Creates new JScrollPane outputPane
    JTextArea outputArea = new JTextArea();     // Creates new JTextArea outputArea
    
    /**
     * Constructor to set up the GUI
     */
    public Powers () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handles the CLOSE button
        setTitle("Powers"); // Sets the title of the JFrame to "Powers"
        
        // Sets the text of the JLabels
        titleLabel.setText("Power!");            // Displays "Power!"
        baseLabel.setText("Enter the Base:");    // Displays "Enter the Base:"
        expLabel.setText("Enter the Exponent:"); // Displays "Enter the Exponent:"
        
        // Formats the text of titleLabel
        titleLabel.setFont(new Font("Arial", 0, 24));     // Sets the font to Arial 24 Plain
        titleLabel.setForeground(new Color(51, 51, 255)); // Sets the text color to a blue
        
        // Sets the text of the JButtons
        calcButton.setText("Calculate"); // Displays "Calculate"
        exitButton.setText("Exit");      // Displays "Exit"
        
        outputArea.setColumns(20); // Sets the number of columns to 20
        outputArea.setRows(5);     // Sets the number of rows to 5
        outputPane.setViewportView(outputArea); // Sets the viewport view to outputArea
        
        // Performs magic
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(baseLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(baseField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(expLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(expField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(calcButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(outputPane)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(titleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baseLabel)
                    .addComponent(baseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expLabel)
                    .addComponent(expField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPane, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        pack();
        
        setVisible(true); // Shows the JFrame
        requestFocus();   // Sets the focus to the JFrame
        
        calcButton.addActionListener(new ActionListener () {
           @Override
           public void actionPerformed (ActionEvent evt) {
               outputArea.setText(""); // Resets outputArea to ""

               try {
                   // Gets the input base
                   int int_base = Integer.parseInt(baseField.getText()); // Sets int_base to the base entered
                   double doub_base = (double) int_base;                 // Casts int_base as a double
                   
                   // Gets the input exponent
                   int int_exp = Integer.parseInt(expField.getText());   // Sets int_exp to the exponent entered
                   if (int_exp < 0) throw new NumberFormatException();   // Ensures the entered exponent was greater than 0
                   double doub_exp = (double) int_exp;                   // Casts int_exp as a double
                   
                   // Declares some variables for the for loop below
                   double doub_result;                                   // Declares the double doub_result
                   int int_result;                                       // Declares the int int_result

                   for (int int_i = 0; int_i <= doub_exp; int_i++) {
                       doub_result = Math.pow(doub_base, int_i); // Calculates doub_base ^ int_1
                       int_result = (int) doub_result;           // Casts doub_result as an int
                       
                       // Outputs the result calculated above
                       outputArea.append("" + int_base + " to the exponent " + int_i + " = " + int_result + ".\n");
                   }
               }
               catch (NumberFormatException nfe) {
                   // Asks the user to use an integer for both the base and exponent
                   outputArea.setText("Please enter an integer for both your base and your exponent.");
               }
            }
        });
        
        exitButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent evt) {
                System.exit(0); // Closes Powers
            }
        });
    }

    /**
     * The entry main() method
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        // Run GUI codes on the Event-Dispatcher Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Powers powers = new Powers(); // Let the constructor do the job
            }
        });
    }
}

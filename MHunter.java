/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhunter;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * MWatkins Jan 29, 2014
 */
public class MHunter {
    
    static int counter1 = 0;
    static boolean counter2 = false;
    static Scanner keyboard;
    static final int frameWidth = 1300;
    static final int frameHeight = 800;
    static final int canvasWidth = 1292;
    static final int canvasHeight = 770;
    static menuPanel canvas;
    static JFrame frame;

    public static void main(String[] args) throws IOException {
        keyboard = new Scanner(System.in);
        init();
        menu();
        System.exit(0);
    }

    private static void menu() throws IOException {
        int selection = -1;
        init();
        canvasControl();
        /*
         while(selection!=4){
         System.out.println("Menu:");
         System.out.println("Build Characters: 1");
         System.out.println("Enter Shop: 2");
         System.out.println("Hunt: 3");
         System.out.println("Quit: 4");
         selection=keyboard.nextInt();
         if(selection==1){
         characterInit();
         } else if(selection==2){
         shopInit();
         } else if(selection==3){
         roundInit();
         }
            
         }*/
        while (true) {
            //System.out.println("Selection was: " + selection);
        }
    }

    private static void init() {
        buildMenuCanvas();
    }

    private static void characterInit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void shopInit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void roundInit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void buildMenuCanvas() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);//lock game resolution
        frame.setVisible(true);
        canvas = new menuPanel();
        frame.getContentPane().add(canvas);
        canvas.requestFocusInWindow();

    }

    private static void canvasControl() {
        while (true) {
            pause();
           
            canvas.repaint();
        }

    }

    private static void pause() {
        try {
            Thread.sleep(12); // wait 5ms
            counter2 = !counter2;
            if (counter2) {
                counter1++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

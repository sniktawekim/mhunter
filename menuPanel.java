package mhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author MWatkins
 */
public class menuPanel extends JPanel {

    final int canvasWidth = 1292;
    final int canvasHeight = 770;
    final int backgroundWidth = 1300;
    IClick myClick;//mouse listener, useful for menu options
    ArrayList<OnScreenObject> objects;
    private ImageIcon graphic;
    private Image gr;

    menuPanel() {
        objects = new ArrayList();
        setBorder(BorderFactory.createLineBorder(Color.black));
        objects = new ArrayList<>();
        myClick = new IClick();
        this.addMouseListener(myClick);
        makeButtons();
        System.out.println("here");
    }

@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBackground(g);
        paintObjects(g);
        checkClick();
        
    }

    private void checkClick() {
        if (!myClick.getClicked()) {
            return;
        }
        for (int i = 0; i < objects.size(); i++) {
            OnScreenObject current = objects.get(i);
            if (current.isClicked(myClick.getX(), myClick.getY())) {
                System.out.println("CLICKED");
            }

        }
    }

    public boolean update() {

        return false;
    }

    private void paintBackground(Graphics g) {
        try {//try to paint background image
            int bgWidthLimit = -backgroundWidth + MHunter.canvasWidth;
            boolean wrap = false;

            graphic = new ImageIcon(this.getClass().getResource("pics/Backgrounds/testBg.png"));
            gr = graphic.getImage();
            g.drawImage(gr, 0, 0, this);
            

        } catch (Exception e) {//if it fails, paint a blue rectangle
            g.setColor(Color.blue);
            g.fillRect(0, 0, getWidth(), getHeight());
            System.out.println("BG Error: " + e);
        }

    }

    private void paintObjects(Graphics g) {

        for (int i = 0; i < objects.size(); i++) {
            OnScreenObject current = objects.get(i);
            g.setColor(current.getColor());
            if (current.getGraphic() != null) {//try to paint the object's image
                g.drawImage(current.getGraphic(), current.getXMin(), current.getYMin(), this);
            } else {//if it fails to load the image, paint it as a default color
                g.fillOval(current.getXMin(), current.getYMin(), current.getXSize(), current.getYSize());
            }
        }
    }

    private void makeButtons() {
        for(int i = 0; i<5; i++){
            Tile toadd = new Tile(400+(i*60), 400+(i*30));
            objects.add(toadd);
        }
        
    }
}

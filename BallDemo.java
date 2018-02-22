import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int n)
    {
        int ground = 400;   // position of the ground line
        Random random = new Random();
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        int i=0;

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // make them bounce
        boolean finished =  false;

        for(i=0;i < n; i++){
            // crate and show the balls
            bolas.add(new BouncingBall(random.nextInt(150), random.nextInt(150), 16, Color.getHSBColor(random.nextFloat(),random.nextFloat(),random.nextFloat()), ground, myCanvas));
            bolas.get(i).draw();
        }
        while(!finished) {
            for(i=0;i < bolas.size(); i++){
                myCanvas.wait(25);           // small delay
                bolas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if(bolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}

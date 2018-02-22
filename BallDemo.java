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
        ArrayList<BouncingBall> bolas = new ArrayList<>(); //ArrayList donde meteremos el numero total de bolas que creemos
        int i=0;

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // make them bounce
        boolean finished =  false;
        //Bucle donde crearemos el numero de bolas pasado por parametro, las almacenaremos en la ArrayList y las crearemos
        for(i=0;i < n; i++){
            // crearemos y mostraremos las bolas con caracteristicas de posicion, tamaño y color aleatorio
            bolas.add(new BouncingBall(random.nextInt(150), random.nextInt(150), random.nextInt(50), 
            Color.getHSBColor(random.nextFloat(),random.nextFloat(),random.nextFloat()), ground, myCanvas));
            bolas.get(i).draw();
        }
        //Bucle con el que moveremos todas las bolas y pararemos la ejecucion cuando una llegue al final de la pantalla
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

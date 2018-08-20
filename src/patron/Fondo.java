package patron;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

class Fondo extends DatosJuego {
    private ImageIcon imgFondo = new ImageIcon(getClass().getResource("/recursos/fondo.png"));
    Fondo() {
        super();
        setFps(1000 / 1);
    }
  
    @Override
    public void run() {
        // TODO Implement this method
        super.run();
        do {
            try {
                //Implementar todo el código necesario para animar el fondo
                Thread.sleep(getFps());
            } catch (InterruptedException e) {
            }
        }while(true);
    }
    
    Image getImgFondo() {
        return imgFondo.getImage();
    }


    @Override
    public void pintarPolimorfismo(Graphics2D g2DMiLienzo) {
        // TODO Implement this method
        //super.pintarPolimorfismo(g2DMiLienzo); //la superclase ha renunciado
        g2DMiLienzo.drawImage(getImgFondo(), 0, 0, 400, 400, null);
    }
}

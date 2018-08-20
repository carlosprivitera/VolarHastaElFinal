package patron;

import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Rectangle;

import java.util.Random;

import javax.swing.ImageIcon;

class Nubes extends DatosJuego {
    private int n = 0;
    private ImageIcon nube = null;
    private Image nubeImage = null;
    private Random aleatorio = new Random();
    
    Nubes(int n) {
        super();
        this.n = n; 
        super.setFps(1000 / 30);
        super.setAncho(260/2);
        super.setAltura(175/2); 
        super.setX(400);
        super.setY(aleatorio.nextInt(250) + 50);
        if(n==1) {
          nube = new ImageIcon(getClass().getResource("/recursos/nubeBuena.png"));
        }else{ 
          nube = new ImageIcon(getClass().getResource("/recursos/nubeMala.png"));
        }
        nubeImage = nube.getImage();
    }

    @Override
    public void run() {
        // TODO Implement this method
        super.run();
        do {
            setX(getX() - 2);
            if(getX() < -150){
                setX(450);
                setY((aleatorio.nextInt(250)+50));
            }
            try {
                Thread.sleep(getFps());
            } catch (InterruptedException e) {
            }
        }while(true);
    }

    @Override
    public int getAltura() {
        // TODO Implement this method
        return super.getAltura();
    }

    @Override
    public int getAncho() {
        // TODO Implement this method
        return super.getAncho();
    }

    @Override
    public int getFps() {
        // TODO Implement this method
        return super.getFps();
    }

    @Override
    public int getX() {
        // TODO Implement this method
        return super.getX();
    }

    @Override
    public int getY() {
        // TODO Implement this method
        return super.getY();
    }

    @Override
    public void setAltura(int altura) {
        // TODO Implement this method
        super.setAltura(altura);
    }

    @Override
    public void setAncho(int ancho) {
        // TODO Implement this method
        super.setAncho(ancho);
    }

    @Override
    public void setX(int x) {
        // TODO Implement this method
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        // TODO Implement this method
        super.setY(y);
    }

    @Override
    public void setFps(int fps) {
        // TODO Implement this method
        super.setFps(fps);
    }

    @Override
    public Rectangle getRectangulo() {
        // TODO Implement this method
        return super.getRectangulo(30);
    }

    @Override
    public void pintarPolimorfismo(Graphics2D g2DMiLienzo) {
        // TODO Implement this method
        //super.pintarPolimorfismo(g2DMiLienzo); //la superclase ha renunciado
        g2DMiLienzo.drawImage(nubeImage, getX(), getY(), getAncho(), getAltura(), null);
    }
}

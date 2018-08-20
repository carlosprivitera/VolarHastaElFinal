package patron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.Random;

class Pilares extends DatosJuego {
    private int n = 0;
    private Color color = null;
    private Random aleatorio = new Random();
    
    Pilares(int n) {
        super();
        this.n=n;
        setFps(1000 / (aleatorio.nextInt(30) + 30));
        setAncho(aleatorio.nextInt(25)+25);
        setAltura(aleatorio.nextInt(75)+100); 
        setX(aleatorio.nextInt(400)+400);
        setY(aleatorio.nextInt(2) * (400-getAltura()));
        color = new Color(aleatorio.nextInt(255),aleatorio.nextInt(255),aleatorio.nextInt(255));
    }

    @Override
    public void run() {
        // TODO Implement this method
        super.run();
        do {
            try {
                setX(getX()-2);
                if(getX()<-50) {
                    setX(450);
                    setAltura(aleatorio.nextInt(75)+100);
                    setY(aleatorio.nextInt(2) * (400-getAltura()));
                    setX(aleatorio.nextInt(400)+400);
                }
                Thread.sleep(getFps());
            } catch (InterruptedException e) {
            }
        }while(true);
    }

    @Override
    public int getY() {
        // TODO Implement this method
        return super.getY();
    }

    @Override
    public int getX() {
        // TODO Implement this method
        return super.getX();
    }

    @Override
    public int getAltura() {
        // TODO Implement this method
        return super.getAltura();
    }

    @Override
    public void setX(int x) {
        // TODO Implement this method
        super.setX(x);
    }

    @Override
    public int getAncho() {
        // TODO Implement this method
        return super.getAncho();
    }
    @Override
    public Rectangle getRectangulo() {
        // TODO Implement this method
        return super.getRectangulo(5);
    }

    @Override
    public void pintarPolimorfismo(Graphics2D g2DMiLienzo) {
        // TODO Implement this method
        //super.pintarPolimorfismo(g2DMiLienzo); //la superclase ha renunciado
        g2DMiLienzo.setColor(color);  
        g2DMiLienzo.fill3DRect(getX(), getY(), getAncho(), getAltura(), true);

    }
}

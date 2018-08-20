package patron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class Personaje extends DatosJuego {
    private int  z = 4, salto = 4; int tope = 50;
    private int vidas = 10;
    Personaje() {
        super();
        setFps(1000 / 25);
        setX(50);
        setY(50);
        setAltura(25);
        setAncho(25);
    }

    @Override
    public void run() {
        // TODO Implement this method
        super.run();
        do {
            try {
                if(getY()<tope){
                    tope=50;
                    z=salto;
                    setY(getY()+salto);
                }
                if(getY()<=50) {
                    setY(55);
                    z=salto;
                }       
                if(getY()>300){
                    z=0;//z=-salto;
                    setY(getY()-2);
                }
                setY(getY()+z);
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
    public void saltar(int clicks) {
        if(clicks <= 0)tope = getY() - 20; //error en la cantidad de click 
        if(clicks == 1)tope = getY() - 20; 
        if(clicks >= 2)tope = getY() - 30;
        z=salto * (-1);
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
    public int getX() {
        // TODO Implement this method
        return super.getX();
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
        //Pintar personaje
        g2DMiLienzo.setColor(new Color(Color.orange.getRGB()));
        g2DMiLienzo.fillOval(45, getY(), getAltura(), getAncho());
        g2DMiLienzo.setColor(new Color(Color.white.getRGB()));
        g2DMiLienzo.drawOval(45, getY(), getAltura(), getAncho());
        g2DMiLienzo.setColor(new Color(Color.blue.getRGB()));
        g2DMiLienzo.fillOval(60, getY()+3, 10, 10);
        g2DMiLienzo.setColor(new Color(Color.white.getRGB()));
        g2DMiLienzo.fillOval(65, getY()+6, 4, 4);
        //Pintar puntuación 
        g2DMiLienzo.setColor(new Color(Color.white.getRGB()));
        g2DMiLienzo.drawString("  Vidas = " + vidas, 11, 26);
        g2DMiLienzo.setColor(new Color(Color.black.getRGB()));
        g2DMiLienzo.drawString("  Vidas = " + vidas, 10, 25); 
    }
    public int finJuego(Graphics2D g2DMiLienzo) {
        if(vidas==0){
            vidas=10;
            g2DMiLienzo.setColor(new Color(Color.red.getRGB()));
            g2DMiLienzo.drawString("(:|} !Juego terminado!" , 50, 175);
            return 5000;
        }
        return 0;
    }

    @Override
    public void colision() {
        // TODO Implement this method
        //super.colision(); //la superclase ha renunciado
        vidas--;
    }
}

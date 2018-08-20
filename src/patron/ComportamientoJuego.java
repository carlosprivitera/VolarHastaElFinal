package patron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

interface ComportamientoJuego {
    //Estos m�todos ser�n implementados por la superclase
    void setX(int x);
    int getX();
    void setY(int y);
    int getY();
    void setAltura(int altura);
    int getAltura();
    void setAncho(int ancho);
    int getAncho();
    void setFps(int fps);
    int getFps();
    Rectangle getRectangulo(int reducir);
    Rectangle getRectangulo() ;

    //Estos m�todos ser�n implementados por las subclases que lo necesiten
    //Estos m�todos son obcionales, ser�n implementados por las clases que lo necesiten
    public void saltar(int clicks); //la superclase renuncia a este comportamiento  
    public void colision();
//    public void setVidas(int vidas); //la superclase renuncia a este comportamiento
//    public int getVidas(); //la superclase renuncia a este comportamiento    
//    void setColisiones(int colisiones); //la superclase renuncia a este comportamiento
//    int getColisiones(); //la superclase renuncia a este comportamiento
    void pintarPolimorfismo(Graphics2D g2DMiLienzo); //la superclase renuncia a este comportamiento
    public int finJuego(Graphics2D g2DMiLienzo);//la superclase renuncia a este comportamiento
}
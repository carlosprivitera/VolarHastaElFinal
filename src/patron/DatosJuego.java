package patron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

class DatosJuego extends Thread implements ComportamientoJuego {
    private int x=0, y=0, altura=0, ancho=0, fps=0;
    private Rectangle rectangulo = null;
    private String miNombre = null;
    private String nombreSubclase = null;
    DatosJuego() {
        super(); //Ejecuta el constructor de la clase Thread{}
        //Cuidado! El nombre de la instancia será el nombre del constructor de la subclase
        //  al momneto de crear un objeto usando una referencia creada con la superclase DatosJuego{}.
        //Las instancias de objetos tienen el nombre del método constructor que las crea.
        miNombre = this.getClass().getName(); //Tomará el nombre del constructor de la subclase
    }
    @Override
    public void run() {
        // TODO Implement this method
        super.run();
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setAltura(int altura) {
        this.altura = altura;
    }
    @Override
    public int getAltura() {
        return altura;
    }
    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    @Override
    public int getAncho() {
        return ancho;
    }
    @Override
    public void setFps(int fps) {
        this.fps = fps;
    }
    @Override
    public int getFps() {
        return fps;
    }
    @Override
    public Rectangle getRectangulo(int reducir) {
        // TODO Implement this method
        rectangulo = new Rectangle(x + reducir, y + reducir, ancho - reducir, altura - reducir);
        return rectangulo;
    }
    @Override
    public Rectangle getRectangulo() {
        // TODO Implement this method
        rectangulo = new Rectangle(x, y, ancho, altura);
        return rectangulo;
    }
    
    //La superclase renuncia a implementar estos métodos
    //Estos métodos serán implementados por las subclases
/*    
    @Override
    public int getColisiones() {
        // TODO Implement this method
        return 0; //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }

    @Override
    public void setColisiones(int colisiones) {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }

    @Override
    public int getVidas() {
        // TODO Implement this method
        return 0; //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }

    @Override
    public void saltar(int clicks) {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }

    @Override
    public void setVidas(int vidas) {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }
*/
    @Override
    public void colision() {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }
    //Este método puede ser ejecutado por cada subclase, para que exista polimorfismo hay que
    //  garantizar mensajes únicos para cada subclase, en este caso la superclase obliga 
    //  a las subclases a sobrescribir el método pintarPolimorfismo(Graphics2D g2DMiLienzo).
    //Cada subclase implementará un algoritmo diferente para pintar en un único lienzo.
    //Las instancias creadas usan los algoritmos de las subclases, pero si el programador quiere puede
    //  migrar el algoritmo especializado desde la subclase a la superclase.
    @Override
    public void pintarPolimorfismo(Graphics2D g2DMiLienzo) {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
        //Un programador puede escribir código para cada subclase si lo desea
        nombreSubclase = Fondo.class.getName();
        if(miNombre.equals(nombreSubclase)){
          //programar para la clase Fondo{}
            
        }
        nombreSubclase = Nubes.class.getName();
        if(miNombre.equals(nombreSubclase)){
          //programar para la clase Nubes{}
            
        }
        nombreSubclase = Personaje.class.getName();
        if(miNombre.equals(nombreSubclase)){
          //programar para la clase Personaje{}
            
        }
        nombreSubclase = Pilares.class.getName();
        if(miNombre.equals(nombreSubclase)){
          //programar para la clase Pilares{}
            
        }        
    }

    @Override
    public int finJuego(Graphics2D g2DMiLienzo) {
        // TODO Implement this method
        return 0; //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }

    @Override
    public void saltar(int clicks) {
        // TODO Implement this method
        //yo renuncio, se tiene que hacer cargo del comportamiento la subclase
    }
}

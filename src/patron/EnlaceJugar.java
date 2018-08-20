package patron;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class EnlaceJugar extends Thread {
    private int fps = 0, esperarFinJuego = 0, i = 0;
    private int boton = 0, clicks = 0;
    //Crear muchas referencias de un único tipo, DatosJuego{} 
    private DatosJuego personaje = null;
    private DatosJuego[] pilares= new Pilares[8];
    private DatosJuego nubeBuena = null;
    private DatosJuego nubeMala = null;
    private DatosJuego fondo = null;
    
    private JPanel jPanel1EnlaceVista=null;
    private Graphics2D g2DjPanel1EnlaceVista = null;
    
    private BufferedImage miLienzo = null;
    private Graphics2D g2DMiLienzo = null;
    private Font fuenteLienzo = null; 
    
    public EnlaceJugar(JPanel jPanel1Vista) {
        super();
        fps = 1000 / 70; esperarFinJuego = 0;
        //Creando un lienzo personalizado
        miLienzo = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB);
        g2DMiLienzo = miLienzo.createGraphics();
        fuenteLienzo = new  Font("Courier", Font.BOLD, 20);
        g2DMiLienzo.setFont(fuenteLienzo);
        //Obtener el lienzo desde la vista
        jPanel1EnlaceVista = jPanel1Vista;
        g2DjPanel1EnlaceVista = (Graphics2D) jPanel1EnlaceVista.getGraphics();
        
        //Full anti-alias
        g2DMiLienzo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 

        //Anti-alias para el texto
        //g2DMiLienzo.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        //Crear los objetos que deben ser pintados en el lienzo personalizado
        fondo = new Fondo(); //Crear un objeto del tipo Fondo{} usando la referencia del tipo DatosJuego{}
        fondo.start();//Lanzar un hilo personalizado para el objeto fondo
        personaje = new Personaje();//Crear un objeto del tipo Personaje{} usando la referencia del tipo DatosJuego{}
        personaje.start();//Lanzar un hilo personalizado para el objeto personaje
        for(int i=0; i<pilares.length;i++){
            pilares[i] = new Pilares(i);//Crear un objeto del tipo Pilares{} usando la referencia del tipo DatosJuego{}
            pilares[i].start();//Lanzar un hilo personalizado para el objeto pilar
        }
        nubeBuena = new Nubes(1);//Crear un objeto del tipo Nubes{} usando la referencia del tipo DatosJuego{}
        nubeBuena.start();//Lanzar un hilo personalizado para el objeto nube
        nubeMala = new Nubes(2);//Crear un objeto del tipo Nubes{} usando la referencia del tipo DatosJuego{}
        nubeMala.start();//Lanzar un hilo personalizado para el objeto nube
    }

    @Override
    public void run() {
        // TODO Implement this method
        super.run();
        do {
            try {
                //pintar el fondo
                pintarPolimorfismo(fondo);
                //pintar las nubes
                pintarPolimorfismo(nubeBuena);
                pintarPolimorfismo(nubeMala);
                //pintar los pilares
                for(i=0; i<pilares.length;i++) {
                    pintarPolimorfismo(pilares[i]);
                }
                //pintar el personaje
                pintarPolimorfismo(personaje);
                //detectar colisiones del personaje con los pilares
                for(i=0; i<pilares.length; i++) {
                    if(colisionPolimorfismo(pilares[i]) == true) {
                        break;
                    }
                }
                //detectar colisión del personaje con la nube mala
                colisionPolimorfismo(nubeMala);
                //Preguntar si hay vidas 
                esperarFinJuego = personaje.finJuego(g2DMiLienzo);
                //pintar el lienzo personalizado en el lienzo de la vista
                g2DjPanel1EnlaceVista.drawImage(miLienzo,0,0,null);
                Thread.sleep(fps + esperarFinJuego);
                esperarFinJuego = 0;
            } catch (InterruptedException e) {
            }
        }while(true);
    }
    //Método polimórfico dinámico
    public boolean colisionPolimorfismo(DatosJuego quienColisiona) {
        //Algoritmo polimórfico dinámico
        if(personaje.getRectangulo().intersects(quienColisiona.getRectangulo())) {
            //personaje.setColisiones(personaje.getColisiones()+1); //aumentar colisiones
            //personaje.setVidas(personaje.getVidas()-1); //disminuir una vida
            personaje.colision();
            quienColisiona.setX(450); //poner objeto que colisiona en la largada
            return true;
        }
        return false;
    }
    //Método polimórfico dinámico, la clase EnlaceJuego{} envía el mismo mensaje  a la referencia de la 
    //  superclase DatosJuego{} para pintar elementos en pantalla, la referencia del tipo superclase 
    //  apuntará a un objeto del tipo subclase. 
    //El parámetro es del tipo DatosJuego{} y el argumento puede ser del tipo: Fondo{}, Nubes{}, Personaje{} o Pilares{}
    //Cada subclase recibe el mismo mensaje pero implementa un comportamiento diferente para pintar.
    //La JVM decide en tiempo de ejecución qué método ejecutar dependiendo del tipo de argumento en el parámetro  
    private void pintarPolimorfismo(DatosJuego queObjeto){
        //Línea de código polimórfica dinámica, puede ser del tipo: Fondo{}, Nubes{}, Personaje{} o Pilares{}
        //Se envía el mismo mensaje sin importar que tipo es, la JVM se encargará de saber que tipo es.
        queObjeto.pintarPolimorfismo(g2DMiLienzo);
        
        //Los programadores pueden optar por escribir código en el método run() o en el 
        //  método pintarPolimorfismo(...) para enviar mensajes al patrón de diseño.

        //Pregunta si el objeto datosJuego es del tipo Personaje{}
        if(queObjeto.getClass().getName().equals(Personaje.class.getName())) {

        }
        //Pregunta si el objeto datosJuego es del tipo Pilares{}
        if(queObjeto.getClass().getName().equals(Pilares.class.getName())) {

        }
        //Pregunta si el objeto datosJuego es del tipo Nubes{}
        if(queObjeto.getClass().getName().equals(Nubes.class.getName())) {

        }
        //Pregunta si el objeto datosJuego es del tipo Fondo{}
        if(queObjeto.getClass().getName().equals(Fondo.class.getName())) {

        }
    }
    //Este método es llamado desde la vista con la información del ratón
    public void MouseClicked(java.awt.event.MouseEvent evt) {
        boton = evt.getButton();
        clicks = evt.getClickCount();
        if(boton == 1) {
              personaje.saltar(clicks);
        }
    }
    //Este método es llamado desde la vista con la información del teclado
    public void KeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == evt.VK_SPACE) {
          personaje.saltar(2);
        }  
    }    
}

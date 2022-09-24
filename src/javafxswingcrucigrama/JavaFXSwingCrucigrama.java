/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXSwingMain.java to edit this template
 */


/**/
package javafxswingcrucigrama;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Abel Gallart Bonome
 */

public class JavaFXSwingCrucigrama extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 1400;
    
    private static final int JFXPANEL_HEIGHT_INT = 800;
    
    private static JFXPanel fxContainer;
    
    static JFrame frame;
    
    static JApplet applet;
    
    Media mediaganar,mediamarcar,mediaclick;
    
    boolean horizontal=true;
    
    JEditorPane area;
    
    JButton jButton1, jButton3;
    
    JLabel jLabel1;
    
    JPanel jPanel1;
    
    JScrollPane jScrollPane1;
    
    JSlider jSlider1;
    
    int l=0;  
    
    String [][]tabla;
    
    Timer timer;
    
    TimerTask rele;
   
    Hashtable diccionario=new Hashtable();
    
    ArrayList DICCIONARIO=new ArrayList();
    
    Random random=new Random();
          
       ArrayList Da=new ArrayList();
       
       ArrayList Db=new ArrayList();
       
       ArrayList Dc=new ArrayList();
       
       ArrayList Dd=new ArrayList();
       
       ArrayList De=new ArrayList();
       
       ArrayList Df=new ArrayList();
       
       ArrayList Dg=new ArrayList();
       
       ArrayList Dh=new ArrayList();
       
       ArrayList Di=new ArrayList();
       
       ArrayList Dj=new ArrayList();
       
       ArrayList Dk=new ArrayList();
       
       ArrayList Dl=new ArrayList();
       
       ArrayList Dm=new ArrayList();
       
       ArrayList Dn=new ArrayList();
       
       ArrayList Dñ=new ArrayList();
       
       ArrayList Do=new ArrayList();
       
       ArrayList Dp=new ArrayList();
       
       ArrayList Dq=new ArrayList();
       
       ArrayList Dr=new ArrayList();
       
       ArrayList Ds=new ArrayList();
       
       ArrayList Dt=new ArrayList();
       
       ArrayList Du=new ArrayList();
       
       ArrayList Dv=new ArrayList();
       
       ArrayList Dw=new ArrayList();
       
       ArrayList Dx=new ArrayList();
       
       ArrayList Dy=new ArrayList();
       
       ArrayList Dz=new ArrayList();
       
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> 
        {
            
            try {
                
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
            } 
            
            catch (Exception e) {e.printStackTrace();}
            
            frame = new JFrame("Crucigrama");
        
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.setUndecorated(true);
            
            applet = new JavaFXSwingCrucigrama();
            
            applet.init();
            
            frame.setContentPane(applet.getContentPane());
            
            frame.pack();
            
            frame.setLocationRelativeTo(null);
            
            frame.setVisible(true);
            
            applet.start();
        });
    }
    
    
    
    @Override
    public void init() {
        
        jPanel1 = new JPanel();
        
        jButton1 = new JButton();
        
        jScrollPane1 = new JScrollPane();
        
        area = new JEditorPane();
        
        area.setFont( new Font(Font.MONOSPACED,Font.BOLD,20));
        
        jSlider1 = new JSlider();
        
        jLabel1 = new JLabel();
        
        jButton3 = new JButton();

        jPanel1.setBackground(Color.black);
        
        setLayout(new AbsoluteLayout());

        jPanel1.setLayout(new GridLayout(6, 6));
        
        add(jPanel1, new AbsoluteConstraints(0, 10, 820, 770));

        jButton1.setText("Generar");
        
        jButton1.addActionListener(
                
                (ActionEvent evt) -> 
                {
            
                    jButton1ActionPerformed();
        
                }
        );
        
        add(jButton1, new AbsoluteConstraints(830, 10, -1, -1));

        area.setEditable(false);
        
        jScrollPane1.setViewportView(area);

        add(jScrollPane1, new AbsoluteConstraints(830, 40, 500, 750));

        jSlider1.setMaximum(15);
        
        jSlider1.setMinimum(4);
        
        jSlider1.setPaintLabels(true);
        
        jSlider1.setPaintTicks(true);
        
        jSlider1.setSnapToTicks(true);
        
        jSlider1.setToolTipText("");
        
        jSlider1.addChangeListener(
                
                (ChangeEvent evt) -> 
                {
            
                    jSlider1StateChanged();
       
                }
        );
        
        add(jSlider1, new AbsoluteConstraints(910, 10, 130, -1));
        
        add(jLabel1, new AbsoluteConstraints(1050, 10, 30, 20));

        jButton3.setText("Resolver");
        
        jButton3.addActionListener(
        
                (ActionEvent evt) -> 
                {
                    
                    jButton3ActionPerformed();
        
                }
        );
        
        add(jButton3, new AbsoluteConstraints(1170, 10, -1, -1));
        
        Scanner scanner=null;
        
        while(scanner==null){
        
            try {
                scanner = 
                        new Scanner(
                        
                                new BufferedReader(
                                
                                        new FileReader(
                                                
                                                new File("./Diccionario Español.txt")
                                        )
                                )
                        );
          
                } 
            
            catch (Exception ex) {ex.printStackTrace();}
           
        }
                 
        
        while (scanner.hasNextLine()) {
        
            String aux = scanner.nextLine();
          
            aux=aux.replaceAll("ó", "o");
          
            aux=aux.replaceAll("á","a");
         
            aux=aux.replaceAll("é","e");
          
            aux=aux.replaceAll("í","i");
         
            aux=aux.replaceAll("ú","u");
         
            aux=aux.replaceAll("�","ñ");
         
            aux=aux.replace("-", " ");
          
         
          if (!aux.equals(""))   
              
            {
               String[] arr = aux.split(". ",2);
             
               String  aux1=""; 
               
               for(int i=1;i<arr.length;i++) 
                   
                   aux1+=arr[i];
              
               arr[0]=arr[0].replace("1", "");
              
               arr[0]=arr[0].replace("2", "");    
    
               arr[0]=arr[0].replace(" ", "");
              
               if (arr.length!=0) diccionario.put(arr[0], aux1);
              
            }
        
        }
         
         Enumeration en=diccionario.keys();
         
         while(en.hasMoreElements()){
         
             String aux=(String)en.nextElement();
         
             if (aux.startsWith("a")) Da.add(aux);
         
             if (aux.startsWith("b")) Db.add(aux);             
        
             if (aux.startsWith("c")) Dc.add(aux);             
         
             if (aux.startsWith("d")) Dd.add(aux);             
         
             if (aux.startsWith("e")) De.add(aux);             
         
             if (aux.startsWith("f")) Df.add(aux);             
         
             if (aux.startsWith("g")) Dg.add(aux);             
         
             if (aux.startsWith("h")) Dh.add(aux);             
        
             if (aux.startsWith("i")) Di.add(aux);             
       
             if (aux.startsWith("j")) Dj.add(aux);             
      
             if (aux.startsWith("k")) Dk.add(aux);             
         
             if (aux.startsWith("l")) Dl.add(aux);  
         
             if (aux.startsWith("m")) Dm.add(aux);             
         
             if (aux.startsWith("n")) Dn.add(aux);             
         
             if (aux.startsWith("ñ")) Dñ.add(aux);             
         
             if (aux.startsWith("o")) Do.add(aux);             
    
             if (aux.startsWith("p")) Dp.add(aux);             
         
             if (aux.startsWith("q")) Dq.add(aux);             
        
             if (aux.startsWith("r")) Dr.add(aux);             
        
             if (aux.startsWith("s")) Ds.add(aux);             
        
             if (aux.startsWith("t")) Dt.add(aux);             
         
             if (aux.startsWith("u")) Du.add(aux);             
        
             if (aux.startsWith("v")) Dv.add(aux);             
         
             if (aux.startsWith("w")) Dw.add(aux);             
        
             if (aux.startsWith("x")) Dx.add(aux);             
         
             if (aux.startsWith("y")) Dy.add(aux);             
        
             if (aux.startsWith("z")) Dz.add(aux);             
         
         }
         
         DICCIONARIO.add(Da);
         
         DICCIONARIO.add(Db);
         
         DICCIONARIO.add(Dc);
         
         DICCIONARIO.add(Dd);
         
         DICCIONARIO.add(De);
         
         DICCIONARIO.add(Df);
         
         DICCIONARIO.add(Dg);
         
         DICCIONARIO.add(Dh);
         
         DICCIONARIO.add(Di);
         
         DICCIONARIO.add(Dj);
         
         DICCIONARIO.add(Dk);
         
         DICCIONARIO.add(Dl);
         
         DICCIONARIO.add(Dm);
         
         DICCIONARIO.add(Dn);
         
         DICCIONARIO.add(Dñ);
         
         DICCIONARIO.add(Do);
         
         DICCIONARIO.add(Dp);
         
         DICCIONARIO.add(Dq);
         
         DICCIONARIO.add(Dr);
         
         DICCIONARIO.add(Ds);
         
         DICCIONARIO.add(Dt);
         
         DICCIONARIO.add(Du);
         
         DICCIONARIO.add(Dv);
         
         DICCIONARIO.add(Dw);
         
         DICCIONARIO.add(Dx);
         
         DICCIONARIO.add(Dy);
         
         DICCIONARIO.add(Dz);
       
         fxContainer = new JFXPanel();
    
         fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
    
         add(fxContainer, new AbsoluteConstraints(0,0,JFXPANEL_WIDTH_INT,JFXPANEL_HEIGHT_INT));
       
         Platform.runLater(() -> {
            
            createScene();
     
         });
        
     File filemarcar=new File("./marcar.mp3");
     
     mediamarcar=new Media(filemarcar.toURI().toString());
                
     File fileclick=new File("./click.mp3");
     
     mediaclick=new Media(fileclick.toURI().toString());
      
     File fileganar=new File("./ganar.mp3");
     
     mediaganar=new Media(fileganar.toURI().toString());
      
     timer=new Timer(5000, (e) -> {
    
     
                boolean correcto=true;                                  
               
                Component []comp=(Component[])jPanel1.getComponents();
        
                for (int i=1;i<comp.length;i++) 
     
                    if (comp[i].isEnabled()
                            
                            &&
                
                            !((JTextField)comp[i]).getText().equals(tabla[i/l][i%l])) 
                     
                        correcto=false;
                 
                if (correcto){  
                                MediaPlayer efectoganar=new MediaPlayer(mediaganar);
                    
                                efectoganar.setVolume(0.7);
                    
                                efectoganar.play();
            
                                JOptionPane.showMessageDialog(frame,"Has completado el crucigrama"
                
                                         ,"Fin del juego",javax.swing.JOptionPane.OK_OPTION);   
            
                                generar();
                
                }
            
     });
    
     timer.start();
     
     generar(); 
    
    }
    
    private void createScene() {
       
       StackPane root = new StackPane();
      
       fxContainer.setScene(new Scene(root));
       
    }
    
    private void generar(){
        
        l=jSlider1.getValue();       
        
        jLabel1.setText(l+"");
        
        jPanel1.removeAll();
        
        jPanel1.setLayout(new GridLayout(l, l)); 
       
        jPanel1.setSize(820,770);
        
        busca(l);
        
        int cont=1; 
    
        for(int f=0;f<l;f++) 
            
            for(int c=0;c<l;c++) 
                         { 
                           JTextField tf=new JTextField(" ");
                           
                           tf.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
                           
                           tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                           
                           jPanel1.add(tf);
                                                                        
                           if (tabla[f][c].equals("*"))   tabla[f][c]=" ";
                                                          
                           if (tabla[f][c].equals(" ")||tabla[f][c].equals("$"))
                                                      
                                                         tf.setEnabled(false);
                                    
                           else{
        
                               tf.setVisible(true);
                             
                               tf.setBackground(Color.BLUE);
                             
                               tf.addKeyListener(new KeyAdapter(){
                             
                                   @Override
                            
                                   public void keyPressed(KeyEvent evt) {
                                  
                                       jTextFieldKeyPressed(tf);}});
                             
                             tf.addKeyListener(new KeyAdapter() {
                                  
                                 @Override
                                 
                                 public void keyReleased(KeyEvent evt) {
                                 
                                     jTextFieldKeyReleased(tf);}});
    
                           
                             tf.addMouseListener(new MouseAdapter() {
                                 
                                 @Override
                                 
                                 public void mouseClicked(MouseEvent evt) {
                                 
                                     jTextFieldMouseClicked(tf);}}); 
                               
                           }
                           
                           
                           if (tabla[f][c].equals("$")) {
                                                          tf.setText(cont+"");
                                                          
                                                          cont++;
                                                         } 
    
                            }

        jPanel1.validate();
       
        this.validate();
        
        String text="Horizontal:\n";
        
        for (int f=1;f<l;f+=2)
        
        { 
            String aux=""; 
          
            for(int c=0;c<l;c++)
            
            {
                if (tabla[f][c].equals("$")||f==1)
              
                {
                    aux=""; 

                    if (f!=1) while(tabla[f][c].equals("$")) c++;
               
                    String contH=((JTextField)jPanel1.getComponent(f*l+c-1)).getText();
                              
               
                    while(c<l&&(!tabla[f][c].equals(" ")&&!tabla[f][c].equals("$")))
                    
                    {aux+=tabla[f][c];c++;}
               
                    if (!aux.equals("")) 
                    
                    {text+=contH+" "+aux+" ."+aux+diccionario.get(aux)+"\n\n";}
            
              
                }
            
            }
        
        }
       
        text+="\n"+"Vertical:\n";
        
        for (int f=1;f<l;f+=6)
        {
            String aux=""; 
          
            for(int c=0;c<l;c++)
             
            {
                if (tabla[c][f].equals("$"))
                        {
                            aux=""; 
                       
                            while(tabla[c][f].equals("$")) c++;
            
                            String contV=((JTextField)jPanel1.getComponent((c-1)*l+f)).getText();
                
                            while(c<l&&(!tabla[c][f].equals(" ")&&!tabla[c][f].equals("$")))
                
                            {aux+=tabla[c][f];c++;}
                
                            if (!aux.equals(""))
                    
                            {text+=contV+" "+aux+" ."+aux+diccionario.get(aux)+"\n\n";}
                        
                        }
            }
         
        }
        
        String temp="";
        
        for(int i=0;i<text.length()-40;i+=40)
        
          temp+=(String)text.subSequence(i, i+40)+"\n";
           
        area.setText(temp);
       
    }
    
   private void jButton1ActionPerformed() {generar();}                                        
   
   private void jSlider1StateChanged() {jLabel1.setText(jSlider1.getValue()+"");}                                     

   private void jButton3ActionPerformed() {                                         
 
        Component []comp=(Component[])jPanel1.getComponents();
        
        for(int i=0;i<comp.length;i++) 
            
            if (comp[i].isEnabled())   
            
                ((JTextField)comp[i]).setText(tabla[i/l][i%l]);
     
    }                                        


   private void jTextFieldMouseClicked(JTextField tf) {                                         
      
     MediaPlayer efectomarcar=new MediaPlayer(mediamarcar);
               
     efectomarcar.setVolume(0.7);
     
     efectomarcar.play();    
  
     int index=0;

     horizontal=!horizontal;
       
     Component []comp=jPanel1.getComponents();
      
     for(int i=0;i<comp.length;i++) 
                 { 
                     comp[i].setBackground(Color.white);
                   
                     if (comp[i].equals(tf)) index=i; 
                   
                     if (comp[i].isEnabled()) comp[i].setBackground(Color.BLUE);
                  }
       
       if (index+1<comp.length&&index-1>0&&horizontal
               
               &&
          
               (comp[index+1].isEnabled()||comp[index-1].isEnabled()))
   
       {  
           while(index<comp.length&&comp[index].isEnabled())
               
           {
               comp[index].setBackground(Color.yellow);
          
           
               index++;
           
           }
           
           index--;
           
           while(index>0&&comp[index].isEnabled())
                                         
           {
               comp[index].setBackground(Color.yellow); 
           
               index--;
           }
           
           return;
       }
      
       if (index+l<comp.length&&index-l>0&&!horizontal
           
               &&
               
               (comp[index+l].isEnabled()||comp[index-l].isEnabled()))
       
       {  
           while(index<comp.length&&comp[index].isEnabled())
                                         
           { 
               comp[index].setBackground(Color.yellow);
           
               index+=l;
           }
           
           index-=l;
           
           while(index>0&&comp[index].isEnabled())
                                         
           {
               comp[index].setBackground(Color.yellow); 
               
               index-=l;
           }
        
       }
      
}


private void jTextFieldKeyPressed(JTextField tf){
                
     MediaPlayer efectoclick=new MediaPlayer(mediaclick);
               
     efectoclick.setVolume(0.7);
     
     efectoclick.play();    
    
     tf.setText("");
    
     for(int f=1;f<l;f++)                         
    
        for(int c=1;c<l;c++)
        
        {   JTextField aux=(JTextField)jPanel1.getComponent(f*l+c);
                                       
        
        if(tabla[f][c].equals(aux.getText()))
        
            aux.setBackground(Color.white);
            
        else if  (!aux.getText().equals(" ")
        
                &&
                
                !aux.getText().equals(""))
                                                 
                
            aux.setBackground(Color.red);
            
        else aux.setBackground(Color.BLUE);
                                    
        }  
                              
        
    
    
}

    
    private void jTextFieldKeyReleased(JTextField tf) {                                       
         
       if (horizontal)tf.transferFocus();
    
       else {
                Component []comp=jPanel1.getComponents();
                  
                for(int i=0;i+l<comp.length;i++)
                { 
                    if(comp[i].equals(tf))
                    {
                    
                    ((JTextField)comp[i+l]).setText(" ");
                    
                    for (int j=0;j<l;j++) comp[i+j].transferFocus();
                    
                    return;
                   
                    }
                 
                }
                          
             }
    }                                      
    

public void busca(int l){
   
    tabla=new String[l][l];
   
    String aux=""; 
  
   
    while(aux.length()<l )
    {
        ArrayList arraux=((ArrayList)(DICCIONARIO.get((int)(DICCIONARIO.size()*random.nextFloat()))));
                               
        aux+=((String)(arraux.get((int)(arraux.size()*random.nextFloat()))))+"$";
                               
        if (aux.length()>l) aux="";
                              
    }
              
         
    for(int f=0;f<l;f++) for(int c=0;c<l;c++) tabla[f][c]=" ";
             
    for(int i=0;i<aux.length();i++) tabla[0][i]=aux.charAt(i)+"";
                        
    for(int i=0;i<l;i+=6){
            
          String s=(String)tabla[0][i];
    
          String aux2="";
                    
                     
    while(aux2.length()!=l){
                          
                     do {
                         aux2="";
                         
                         switch (s) {
                         
                             case "a":
                                 
                                 aux2=""+Da.get((int)(Da.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "b":
                             
                                 aux2=""+Db.get((int)(Db.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "c":
                             
                                 aux2=""+Dc.get((int)(Dc.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "d":
                             
                                 aux2=""+Dd.get((int)(Dd.size()*random.nextFloat()));
                                 
                                 break;
                            
                             case "e":
                             
                                 aux2=""+De.get((int)(De.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "f":
                             
                                 aux2=""+Df.get((int)(Df.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "g":
                             
                                 aux2=""+Dg.get((int)(Dg.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "h":
                             
                                 aux2=""+Dh.get((int)(Dh.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "i":
                             
                                 aux2=""+Di.get((int)(Di.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "j":
                             
                                 aux2=""+Dj.get((int)(Dj.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "k":
                             
                                 aux2=""+Dk.get((int)(Dk.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "l":
                             
                                 aux2=""+Dl.get((int)(Dl.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "m":
                             
                                 aux2=""+Dm.get((int)(Dm.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "n":
                             
                                 aux2=""+Dn.get((int)(Dn.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "ñ":
                             
                                 aux2=""+Dñ.get((int)(Dñ.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "o":
                             
                                 aux2=""+Do.get((int)(Do.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "p":
                             
                                 aux2=""+Dp.get((int)(Dp.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "q":
                             
                                 aux2=""+Dq.get((int)(Dq.size()*random.nextFloat()));
                                 
                                 break;
                           
                             case "r":
                             
                                 aux2=""+Dr.get((int)(Dr.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "s":
                             
                                 aux2=""+Ds.get((int)(Ds.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "t":
                             
                                 aux2=""+Dt.get((int)(Dt.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "u":
                             
                                 aux2=""+Du.get((int)(Du.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "v":
                             
                                 aux2=""+Dv.get((int)(Dv.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "w":
                             
                                 aux2=""+Dw.get((int)(Dw.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "x":
                             
                                 aux2=""+Dx.get((int)(Dx.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "y":
                             
                                 aux2=""+Dy.get((int)(Dy.size()*random.nextFloat()));
                                 
                                 break;
                             
                             case "z":
                             
                                 aux2=""+Dz.get((int)(Dz.size()*random.nextFloat()));
                                 
                                 break;
                             
                             default:
                             
                                 break;
                         }
    
                         aux2+="*";
                                           
                         } while(aux2.length()>=l&&!s.equals(" "));
                         
                  
                 int ran=(int)(10*random.nextFloat());
                         
                 if (ran==0||ran==2||ran==4)  aux2+=" ";
                 
                 else if (ran==1||ran==3||ran==5) aux2+="  ";
                 
                 String aux3="";                        
                         
                                             
                 while (aux2.length()+aux3.length()<l)
                 {
                     ArrayList arraux=((ArrayList)(DICCIONARIO.get((int)(DICCIONARIO.size()*random.nextFloat()))));
                         
                     String aux6=((String)(arraux.get((int)(arraux.size()*random.nextFloat()))));

                     
                     if (aux6.length()==1) aux6=" ";
                     
                     int ran1=(int)(10*random.nextFloat());
                         
                     if (ran1==0||ran1==2||ran1==4)  aux3+="$"+aux6+"*";
                         
                     else  aux3+="$"+aux6+"* ";
                     
                 }
                 
                 aux2+=aux3;
                             
            }
                      
        
    for(int x=0;x<l;x++) tabla[x][i]=aux2.charAt(x)+"";
    
    }      //vertircal

  
     /////////////////////////////////////////////////////////
    
    for(int i=2;i<l;i+=2)
    
    {    
        
        String s=(String)tabla[i][0];
                    
        String aux2="";
                     
        while(aux2.length()!=l){
                          
                     do {
                         aux2="";
                         
                         switch (s) {
                         
                             case "a":
                                 
                                 aux2=""+Da.get((int)(Da.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "b":
                             
                                 aux2=""+Db.get((int)(Db.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "c":
                             
                                 aux2=""+Dc.get((int)(Dc.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "d":
                             
                                 aux2=""+Dd.get((int)(Dd.size()*random.nextFloat()))+"*";
                                 
                                 break;
                          
                             case "e":
                             
                                 aux2=""+De.get((int)(De.size()*random.nextFloat()))+"*";
                                 
                                 break;
                            
                             case "f":
                             
                                 aux2=""+Df.get((int)(Df.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "g":
                             
                                 aux2=""+Dg.get((int)(Dg.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "h":
                             
                                 aux2=""+Dh.get((int)(Dh.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "i":
                             
                                 aux2=""+Di.get((int)(Di.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "j":
                             
                                 aux2=""+Dj.get((int)(Dj.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "k":
                             
                                 aux2=""+Dk.get((int)(Dk.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "l":
                             
                                 aux2=""+Dl.get((int)(Dl.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "m":
                             
                                 aux2=""+Dm.get((int)(Dm.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "n":
                                 
                                 aux2=""+Dn.get((int)(Dn.size()*random.nextFloat()))+"*";
                             
                                 break;
                           
                             case "ñ":
                             
                                 aux2=""+Dñ.get((int)(Dñ.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "o":
                             
                                 aux2=""+Do.get((int)(Do.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "p":
                             
                                 aux2=""+Dp.get((int)(Dp.size()*random.nextFloat()))+"*";
                                 
                                 break;
                          
                             case "q":
                             
                                 aux2=""+Dq.get((int)(Dq.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "r":
                             
                                 aux2=""+Dr.get((int)(Dr.size()*random.nextFloat()))+"*";
                                 
                                 break;
                            
                             case "s":
                             
                                 aux2=""+Ds.get((int)(Ds.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "t":
                             
                                 aux2=""+Dt.get((int)(Dt.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "u":
                             
                                 aux2=""+Du.get((int)(Du.size()*random.nextFloat()))+"*";
                                 
                                 break;
                         
                             case "v":
                             
                                 aux2=""+Dv.get((int)(Dv.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "w":
                             
                                 aux2=""+Dw.get((int)(Dw.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "x":
                             
                                 aux2=""+Dx.get((int)(Dx.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "y":
                             
                                 aux2=""+Dy.get((int)(Dy.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "z":
                             
                                 aux2=""+Dz.get((int)(Dz.size()*random.nextFloat()))+"*";
                                 
                                 break;
                             
                             case "$":
                             
                                 aux2="";
                                 
                                 break;
                             
                             case "*":
                             
                                 aux2="*";
                                 
                                 break;
                             
                             default:
                             
                                 break;
                         }
                                          
                         } while(aux2.length()>=l&&!s.equals(" "));
                         
                    int ran=(int)(10*random.nextFloat());
                         
                    if (ran==0||ran==2||ran==4)  aux2+=" ";
                    
                    else if (ran==1||ran==3||ran==5) aux2+="  ";                            
                    
                    String aux3="";                        
                         
                                            
                 while (aux2.length()+aux3.length()<l){
                         
                     ArrayList arraux=((ArrayList)(DICCIONARIO.get((int)(DICCIONARIO.size()*random.nextFloat()))));
                         
                         int ran1=(int)(10*random.nextFloat());
                        
                         String aux6=((String)(arraux.get((int)(arraux.size()*random.nextFloat()))));
                         
                         
                         switch (ran1) {
                             
                             case 0:
                             
                             case 2:
                             
                             case 4:
                             
                                 aux3+="$"+aux6+"*";
                                 
                                 break;
                          
                             case 1:
                             
                             case 3:
                             
                             case 5:
                             
                                 aux3+="$"+aux6+"* ";
                                 
                                 break;
                            
                             default:
                             
                                 aux3+="$"+aux6+"*  ";
                                 
                                 break;
                         }
                                                
                         }
                     
                 aux2+=aux3;
                             
       
                if (aux2.length()==l){                 
                
                    for(int x=0;x<l;x++) 
                          {  
                              String aux5="";
                              
                              for(int p=0;p<aux2.length();p++)
                                {  
                                 if (aux2.charAt(p)!=' ') aux5+=aux2.charAt(p)+"";
                                 
                                 else aux5+=tabla[i][p];
                                }            
          
                              aux2=aux5; 
                              
                              if (!tabla[i][x].equals(aux2.charAt(x)+"")
                                 
                                      &&
                                  
                                      !tabla[i][x].equals(" ")) {aux2="";break;}
                          }
               }             
            }//while
  
        for(int x=0;x<l;x++) tabla[i][x]=aux2.charAt(x)+"";
     }     //horizontal
    
     /////////////////////////////////////////////////////////      
      
    String [][]tablaX=new String[l+1][l+1];
     
    for(int f=0;f<l+1;f++) for(int c=0;c<l+1;c++) tablaX[f][c]=" ";
     
    for(int f=0;f<l;f++) System.arraycopy(tabla[f], 0, tablaX[f+1], 1, l); 
                         //for(int c=0;c<l;c++) tablaX[f+1][c+1]=tabla[f][c];
        
    
    tabla=tablaX;
     
    for(int i=1;i<l;i+=6) 
       
        if (!tabla[1][i].equals(" ")&&!tabla[1][i].equals("*")
                
                &&
                                                       
                !tabla[1][i].equals("$")) tabla[0][i]="$";
    
    for(int i=1;i<l;i+=2) 
        if (!tabla[i][1].equals(" ")
                
                &&
                
                !tabla[i][1].equals("*")
                
                &&
                                                        
                !tabla[i][1].equals("$")) tabla[i][0]="$";
    }    
}
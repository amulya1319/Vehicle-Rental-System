 package comvechicleRentalsystem;
 
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.Vector;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JComboBox;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 
 public class view_vechicle_avialabe
   extends JFrame implements ActionListener {
   JLabel jl1;
   JLabel jl2;
   JLabel jl3;
   JLabel background;
   JButton jb5;
   JComboBox jcb;
   JComboBox jcb1;
   Vector vname = new Vector();
   Vector vprice = new Vector();
   Vector vstaus = new Vector();
   
   Vector v1name = new Vector();
   Vector v1price = new Vector();
   Vector v1status = new Vector();
   String email;
   String selectedType = "";
   
   public view_vechicle_avialabe(String email) {
     this.email = email;
     this.jl1 = new JLabel("VechicleName");
     this.jl2 = new JLabel("vechicleprice");
     this.jl3 = new JLabel("staus");
     
     this.jb5 = new JButton("RENT");
     
     ImageIcon icon = new ImageIcon("C:\\Users\\Amulya\\Pictures\\in.jpg");
     
     Image image = icon.getImage();
     
     Image newImage = image.getScaledInstance(800, 800, 4);
     
     icon = new ImageIcon(newImage);
     
     this.background = new JLabel(icon);
 
     
     this.vname.add("BMW");
     this.vprice.add("10000");
     this.vstaus.add("Available");
     
     this.vname.add("Mercedes-Benz");
     this.vprice.add("12000");
     this.vstaus.add("Rented");
     
     this.vname.add("Audi");
     this.vprice.add("11000");
     this.vstaus.add("Available");
     
     this.vname.add("Range Rover");
     this.vprice.add("15000");
     this.vstaus.add("Rented");
     
     this.vname.add("Toyota Fortuner");
     this.vprice.add("8000");
     this.vstaus.add("Available");
     
     this.vname.add("Hyundai Creta");
     this.vprice.add("6000");
     this.vstaus.add("Available");
     
     this.vname.add("Mahindra Thar");
     this.vprice.add("7000");
     this.vstaus.add("Rented");
     
     this.vname.add("Tata Harrier");
     this.vprice.add("6500");
     this.vstaus.add("Available");
     
     this.vname.add("Kia Seltos");
     this.vprice.add("6000");
     this.vstaus.add("Available");
     
     this.vname.add("Honda City");
     this.vprice.add("5500");
     this.vstaus.add("Rented");
     
     this.jcb = new JComboBox(this.vname);
 
 
     
     this.v1name.add("Royal Enfield Classic 350");
     this.v1price.add("800");
     this.v1status.add("Available");
     
     this.v1name.add("Royal Enfield Bullet 350");
     this.v1price.add("750");
     this.v1status.add("Rented");
     
     this.v1name.add("Hero Splendor Plus");
     this.v1price.add("500");
     this.v1status.add("Available");
     
     this.v1name.add("Hero Xpulse 200");
     this.v1price.add("700");
     this.v1status.add("Available");
     
     this.v1name.add("Honda Activa 6G");
     this.v1price.add("450");
     this.v1status.add("Rented");
     
     this.v1name.add("Honda Shine");
     this.v1price.add("500");
     this.v1status.add("Available");
     
     this.v1name.add("Yamaha R15");
     this.v1price.add("900");
     this.v1status.add("Available");
     
     this.v1name.add("Yamaha MT-15");
     this.v1price.add("850");
     this.v1status.add("Rented");
     
     this.v1name.add("Bajaj Pulsar 150");
     this.v1price.add("600");
     this.v1status.add("Available");
     
     this.v1name.add("TVS Apache RTR 160");
     this.v1price.add("650");
     this.v1status.add("Available");
     
     this.jcb1 = new JComboBox(this.v1name);
     
     add(this.jl1);
     add(this.jl2);
     add(this.jl3);
     add(this.jcb);
     add(this.jcb1);
     add(this.jb5);
     add(this.background);
 
     
     this.jcb.addActionListener(this);
     this.jcb1.addActionListener(this);
     this.jb5.addActionListener(this);
     
     setLayout((LayoutManager)null);
     
     this.jl1.setBounds(50, 100, 120, 40);
     this.jl2.setBounds(50, 200, 120, 40);
     this.jl3.setBounds(50, 300, 120, 40);
     
     this.jcb.setBounds(150, 100, 120, 40);
     this.jcb1.setBounds(300, 100, 120, 40);
     this.jb5.setBounds(200, 400, 120, 40);
     this.background.setBounds(0, 0, 800, 800);
   }
 
 
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jcb) {
       this.selectedType = "Car";
       int i = this.jcb.getSelectedIndex();
       
       this.jl1.setText("Vehicle: " + String.valueOf(this.vname.get(i)));
       this.jl2.setText("Price: " + String.valueOf(this.vprice.get(i)));
       this.jl3.setText("Status: " + String.valueOf(this.vstaus.get(i)));
     } 
     
     if (e.getSource() == this.jcb1) {
       this.selectedType = "Bike";
       
       int i = this.jcb1.getSelectedIndex();
       
       this.jl1.setText("Vehicle: " + String.valueOf(this.v1name.get(i)));
       this.jl2.setText("Price: " + String.valueOf(this.v1price.get(i)));
       this.jl3.setText("Status: " + String.valueOf(this.v1status.get(i)));
     } 
     if (e.getSource() == this.jb5)
     {
       if (this.selectedType.equals("Car")) {
         
         int i = this.jcb.getSelectedIndex();
         
         String vehicleName = this.vname.get(i).toString();
         String price = this.vprice.get(i).toString();
         String status = this.vstaus.get(i).toString();
         
         if (status.equals("Available"))
         {
           RentalPage r = new RentalPage(vehicleName, price, this.email, "Car");
           r.setVisible(true);
         }
         else
         {
           JOptionPane.showMessageDialog(
               this, 
               "This car is already rented.");
         }
       
       }
       else if (this.selectedType.equals("Bike")) {
         
         int i = this.jcb1.getSelectedIndex();
         
         String vehicleName = this.v1name.get(i).toString();
         String price = this.v1price.get(i).toString();
         String status = this.v1status.get(i).toString();
         
         if (status.equals("Available")) {
           
           RentalPage r = new RentalPage(vehicleName, price, this.email, "Bike");
           r.setVisible(true);
         }
         else {
           
           JOptionPane.showMessageDialog(
               this, 
               "This bike is already rented.");
         } 
       } 
     }
   }
 }




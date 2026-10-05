 package comvechicleRentalsystem;
 
 import java.awt.Component;
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.time.Duration;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
 import java.time.LocalTime;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JComboBox;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JTextField;
 
 public class RentalPage extends JFrame implements ActionListener {
   JLabel jl1;
   JLabel jl2;
   JLabel jl3;
   JLabel jl4;
   JLabel jl5;
   JLabel jl6;
   JLabel background;
   JTextField jt1;
   JTextField jt2;
   JTextField jt3;
   JTextField jt4;
   JComboBox<String> jc1;
   JComboBox<String> jc2;
   JButton jb1;
   String vehicleName;
   String price;
   String email;
   String vehicleType;
   
   public RentalPage(String vehicleName, String price, String email, String vehicleType) {
     this.vehicleName = vehicleName;
     this.price = price;
     this.email = email;
     this.vehicleType = vehicleType;
 
     
     ImageIcon icon = new ImageIcon(
         "C:\\Users\\Amulya\\Pictures\\in.jpg");
 
     
     Image image = icon.getImage();
     
     Image newImage = image.getScaledInstance(
         800, 
         800, 
         4);
 
     
     icon = new ImageIcon(newImage);
     
     this.background = new JLabel(icon);
 
 
     
     this.jl1 = new JLabel("Pickup Date");
     
     this.jl2 = new JLabel("Pickup Time");
     
     this.jl3 = new JLabel("Return Date");
     
     this.jl4 = new JLabel("Return Time");
     
     this.jl5 = new JLabel("Pickup Location");
     
     this.jl6 = new JLabel("Return Location");
 
 
     
     this.jt1 = new JTextField();
     
     this.jt2 = new JTextField();
     
     this.jt3 = new JTextField();
     
     this.jt4 = new JTextField();
 
 
     
     this.jc1 = new JComboBox<>();
     
     this.jc1.addItem("Hyderabad");
     this.jc1.addItem("Secunderabad");
     this.jc1.addItem("Kukatpally");
     this.jc1.addItem("Madhapur");
     this.jc1.addItem("Gachibowli");
     
     this.jc2 = new JComboBox<>();
     
     this.jc2.addItem("Hyderabad");
     this.jc2.addItem("Secunderabad");
     this.jc2.addItem("Kukatpally");
     this.jc2.addItem("Madhapur");
     this.jc2.addItem("Gachibowli");
 
 
     
     this.jb1 = new JButton("CONTINUE TO PAYMENT");
 
 
     
     setLayout((LayoutManager)null);
     
     this.jl1.setBounds(40, 40, 130, 40);
     this.jt1.setBounds(180, 40, 180, 40);
     
     this.jl2.setBounds(40, 100, 130, 40);
     this.jt2.setBounds(180, 100, 180, 40);
     
     this.jl3.setBounds(40, 160, 130, 40);
     this.jt3.setBounds(180, 160, 180, 40);
     
     this.jl4.setBounds(40, 220, 130, 40);
     this.jt4.setBounds(180, 220, 180, 40);
     
     this.jl5.setBounds(40, 280, 130, 40);
     this.jc1.setBounds(180, 280, 180, 40);
     
     this.jl6.setBounds(40, 340, 130, 40);
     this.jc2.setBounds(180, 340, 180, 40);
     
     this.jb1.setBounds(100, 410, 240, 45);
     
     this.background.setBounds(0, 0, 800, 800);
 
 
     
     add(this.jl1);
     add(this.jt1);
     
     add(this.jl2);
     add(this.jt2);
     
     add(this.jl3);
     add(this.jt3);
     
     add(this.jl4);
     add(this.jt4);
     
     add(this.jl5);
     add(this.jc1);
     
     add(this.jl6);
     add(this.jc2);
     
     add(this.jb1);
     
     add(this.background);
     
     this.jb1.addActionListener(this);
     
     setSize(500, 520);
     
     setLocationRelativeTo((Component)null);
     
     setDefaultCloseOperation(
         2);
 
     
     setVisible(true);
   }
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1) {
       
       String pickupDate = this.jt1.getText().trim();
       
       String pickupTime = this.jt2.getText().trim();
       
       String returnDate = this.jt3.getText().trim();
       
       String returnTime = this.jt4.getText().trim();
       
       String pickupLocation = 
         this.jc1.getSelectedItem().toString();
       
       String returnLocation = 
         this.jc2.getSelectedItem().toString();
 
 
       
       if (pickupDate.isEmpty() || 
         pickupTime.isEmpty() || 
         returnDate.isEmpty() || 
         returnTime.isEmpty()) {
         
         JOptionPane.showMessageDialog(
             this, 
             "Please enter all date and time details");
 
 
         
         return;
       } 
 
 
       
       try {
         LocalDate pd = 
           LocalDate.parse(pickupDate);
         
         LocalDate rd = 
           LocalDate.parse(returnDate);
 
 
         
         LocalTime pt = 
           LocalTime.parse(pickupTime);
         
         LocalTime rt = 
           LocalTime.parse(returnTime);
 
 
         
         LocalDateTime pickupDateTime = 
           LocalDateTime.of(pd, pt);
         
         LocalDateTime returnDateTime = 
           LocalDateTime.of(rd, rt);
 
 
         
         if (!returnDateTime.isAfter(
             pickupDateTime)) {
           
           JOptionPane.showMessageDialog(
               this, 
               "Return date/time must be after pickup date/time");
 
 
           
           return;
         } 
 
         
         long totalHours = 
           Duration.between(
             pickupDateTime, 
             returnDateTime)
           .toHours();
 
 
         
         long totalDays = 
           totalHours / 24L;
 
 
         
         long extraHours = 
           totalHours % 24L;
 
 
         
         double pricePerHour = 
           Double.parseDouble(this.price);
 
 
         
         double totalAmount = 
           totalHours * pricePerHour;
 
 
         
         JOptionPane.showMessageDialog(
             this, "Rental Duration: " + 
             
             totalDays + " Days " + 
             
             extraHours + " Hours\n\nTotal Hours: " + 
 
             
             totalHours + "\n\nTotal Amount: ₹" + 
 
             
             totalAmount);
 
 
 
         
         PaymentPage p = 
           new PaymentPage(
             this.vehicleName, 
             this.vehicleType, 
             this.price, 
             this.email, 
             
             pickupDate, 
             pickupTime, 
             
             returnDate, 
             returnTime, 
             
             pickupLocation, 
             returnLocation, 
             
             totalHours, 
             totalDays, 
             extraHours, 
             
             totalAmount);
 
         
         p.setTitle("Payment");
         
         p.setSize(800, 800);
         
         p.setLocationRelativeTo((Component)null);
         
         p.setVisible(true);
 
 
         
         dispose();
       }
       catch (Exception ex) {
         
         JOptionPane.showMessageDialog(
             this, 
             "Invalid date/time format.\n\nDate format: YYYY-MM-DD\nTime format: HH:MM:SS");
 
 
 
         
         ex.printStackTrace();
       } 
     } 
   }
 }




 package comvechicleRentalsystem;
 
 import java.awt.Component;
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.Connection;
 import java.sql.Date;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.Time;
 import javax.swing.ButtonGroup;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JRadioButton;
 
 
 
 
 
 
 public class PaymentPage
   extends JFrame
   implements ActionListener
 {
   JLabel jl1;
   JLabel jl2;
   JLabel jl3;
   JLabel jl4;
   JLabel jl5;
   JLabel jl6;
   JLabel jl7;
   JLabel jl8;
   JLabel jl9;
   JLabel jl10;
   JLabel jl11;
   JLabel background;
   JRadioButton jr1;
   JRadioButton jr2;
   JRadioButton jr3;
   JButton jb1;
   String vehicleName;
   String vehicleType;
   String price;
   String email;
   String pickupDate;
   String pickupTime;
   String returnDate;
   String returnTime;
   String pickupLocation;
   String returnLocation;
   long totalHours;
   long totalDays;
   long extraHours;
   double totalAmount;
   
   public PaymentPage(String vehicleName, String vehicleType, String price, String email, String pickupDate, String pickupTime, String returnDate, String returnTime, String pickupLocation, String returnLocation, long totalHours, long totalDays, long extraHours, double totalAmount) {
     this.vehicleName = vehicleName;
     this.vehicleType = vehicleType;
     this.price = price;
     this.email = email;
     
     this.pickupDate = pickupDate;
     this.pickupTime = pickupTime;
     
     this.returnDate = returnDate;
     this.returnTime = returnTime;
     
     this.pickupLocation = pickupLocation;
     this.returnLocation = returnLocation;
     
     this.totalHours = totalHours;
     this.totalDays = totalDays;
     this.extraHours = extraHours;
     
     this.totalAmount = totalAmount;
 
 
     
     this.jl1 = new JLabel("Vehicle: " + vehicleName);
     
     this.jl2 = new JLabel("Vehicle Type: " + vehicleType);
     
     this.jl3 = new JLabel("Price Per Hour: Rs." + price);
     
     this.jl4 = new JLabel("Pickup: " + 
         pickupDate + " " + pickupTime);
     
     this.jl5 = new JLabel("Return: " + 
         returnDate + " " + returnTime);
     
     this.jl6 = new JLabel("Pickup Location: " + 
         pickupLocation);
     
     this.jl7 = new JLabel("Return Location: " + 
         returnLocation);
     
     this.jl8 = new JLabel("Duration: " + 
         totalDays + " Days " + 
         extraHours + " Hours");
     
     this.jl9 = new JLabel("Total Hours: " + 
         totalHours);
     
     this.jl10 = new JLabel("TOTAL AMOUNT: Rs." + 
         totalAmount);
     
     this.jl11 = new JLabel("SELECT PAYMENT METHOD");
 
 
     
     this.jr1 = new JRadioButton("UPI");
     this.jr2 = new JRadioButton("CARD");
     this.jr3 = new JRadioButton("CASH");
     
     ButtonGroup bg = new ButtonGroup();
     
     bg.add(this.jr1);
     bg.add(this.jr2);
     bg.add(this.jr3);
     
     this.jb1 = new JButton("PAY NOW");
 
 
     
     ImageIcon icon = new ImageIcon(
         "C:\\Users\\Amulya\\Pictures\\in.jpg");
     
     Image image = icon.getImage();
     
     Image newImage = image.getScaledInstance(
         800, 
         800, 
         4);
     
     icon = new ImageIcon(newImage);
     
     this.background = new JLabel(icon);
 
 
     
     setLayout((LayoutManager)null);
     
     this.jl1.setBounds(60, 30, 400, 30);
     this.jl2.setBounds(60, 65, 400, 30);
     this.jl3.setBounds(60, 100, 400, 30);
     
     this.jl4.setBounds(60, 140, 500, 30);
     this.jl5.setBounds(60, 175, 500, 30);
     
     this.jl6.setBounds(60, 210, 500, 30);
     this.jl7.setBounds(60, 245, 500, 30);
     
     this.jl8.setBounds(60, 280, 450, 30);
     this.jl9.setBounds(60, 315, 400, 30);
     
     this.jl10.setBounds(60, 355, 450, 40);
     
     this.jl11.setBounds(60, 415, 250, 30);
     
     this.jr1.setBounds(60, 455, 100, 30);
     this.jr2.setBounds(170, 455, 100, 30);
     this.jr3.setBounds(280, 455, 100, 30);
     
     this.jb1.setBounds(130, 510, 180, 45);
     
     this.background.setBounds(0, 0, 800, 800);
 
 
     
     add(this.jl1);
     add(this.jl2);
     add(this.jl3);
     add(this.jl4);
     add(this.jl5);
     add(this.jl6);
     add(this.jl7);
     add(this.jl8);
     add(this.jl9);
     add(this.jl10);
     add(this.jl11);
     
     add(this.jr1);
     add(this.jr2);
     add(this.jr3);
     
     add(this.jb1);
     
     add(this.background);
     
     this.jb1.addActionListener(this);
     
     setSize(500, 620);
     
     setLocationRelativeTo((Component)null);
     
     setDefaultCloseOperation(2);
     
     setVisible(true);
   }
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1) {
       
       String paymentMethod = "";
       
       if (this.jr1.isSelected()) {
         
         paymentMethod = "UPI";
       }
       else if (this.jr2.isSelected()) {
         
         paymentMethod = "CARD";
       }
       else if (this.jr3.isSelected()) {
         
         paymentMethod = "CASH";
       }
       else {
         
         JOptionPane.showMessageDialog(
             this, 
             "Please select a payment method");
 
         
         return;
       } 
       
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/company2", 
             "root", 
             "root");
         
         String sql = 
           "INSERT INTO vehicle_rentals (email, vehicle_name, vehicle_type, price, rent_date, return_date, payment_method, payment_status, pickup_location, return_location, pickup_time, return_time, total_hours, total_days, extra_hours, price_per_hour, total_amount, booking_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
 
 
 
 
 
 
 
 
 
         
         PreparedStatement pst = 
           con.prepareStatement(sql);
         
         pst.setString(1, this.email);
         pst.setString(2, this.vehicleName);
         pst.setString(3, this.vehicleType);
         pst.setString(4, this.price);
         
         pst.setDate(
             5, 
             Date.valueOf(this.pickupDate));
         
         pst.setDate(
             6, 
             Date.valueOf(this.returnDate));
         
         pst.setString(7, paymentMethod);
         
         pst.setString(8, "Paid");
         
         pst.setString(9, this.pickupLocation);
         
         pst.setString(10, this.returnLocation);
         
         pst.setTime(
             11, 
             Time.valueOf(this.pickupTime));
         
         pst.setTime(
             12, 
             Time.valueOf(this.returnTime));
         
         pst.setLong(13, this.totalHours);
         
         pst.setLong(14, this.totalDays);
         
         pst.setLong(15, this.extraHours);
         
         pst.setDouble(
             16, 
             Double.parseDouble(this.price));
         
         pst.setDouble(
             17, 
             this.totalAmount);
         
         pst.setString(
             18, 
             "CONFIRMED");
         
         pst.executeUpdate();
         
         JOptionPane.showMessageDialog(
             this, 
             "PAYMENT SUCCESSFUL!\n\nBOOKING CONFIRMED!");
 
         
         pst.close();
         con.close();
 
 
         
         BookingConfirmationPage b = 
           new BookingConfirmationPage(
             this.email, 
             this.vehicleName, 
             this.vehicleType, 
             this.price, 
             this.pickupDate, 
             this.pickupTime, 
             this.returnDate, 
             this.returnTime, 
             this.pickupLocation, 
             this.returnLocation, 
             this.totalHours, 
             this.totalDays, 
             this.extraHours, 
             this.totalAmount, 
             paymentMethod);
         
         b.setTitle("Booking Confirmation");
         
         b.setSize(800, 800);
         
         b.setLocationRelativeTo((Component)null);
         
         b.setVisible(true);
         
         dispose();
       }
       catch (Exception ex) {
         
         ex.printStackTrace();
         
         JOptionPane.showMessageDialog(
             this, "Payment / Booking Error:\n" + 
             
             ex.getMessage());
       } 
     } 
   }
 }




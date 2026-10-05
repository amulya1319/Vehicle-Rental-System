 package comvechicleRentalsystem;
 
 import java.awt.Component;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 
 
 
 
 
 public class BookingConfirmationPage
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
   JLabel jl12;
   JButton jb1;
   JButton jb2;
   String email;
   
   public BookingConfirmationPage(String email, String vehicleName, String vehicleType, String price, String pickupDate, String pickupTime, String returnDate, String returnTime, String pickupLocation, String returnLocation, long totalHours, long totalDays, long extraHours, double totalAmount, String paymentMethod) {
     this.email = email;
     
     this.jl1 = new JLabel("BOOKING CONFIRMED");
     
     this.jl2 = new JLabel("Vehicle: " + vehicleName);
     
     this.jl3 = new JLabel("Vehicle Type: " + vehicleType);
     
     this.jl4 = new JLabel("Price Per Hour: Rs." + price);
     
     this.jl5 = new JLabel("Pickup: " + 
         pickupDate + " " + pickupTime);
     
     this.jl6 = new JLabel("Return: " + 
         returnDate + " " + returnTime);
     
     this.jl7 = new JLabel("Pickup Location: " + 
         pickupLocation);
     
     this.jl8 = new JLabel("Return Location: " + 
         returnLocation);
     
     this.jl9 = new JLabel("Duration: " + 
         totalDays + " Days " + 
         extraHours + " Hours");
     
     this.jl10 = new JLabel("Total Hours: " + 
         totalHours);
     
     this.jl11 = new JLabel("Total Amount: Rs." + 
         totalAmount);
     
     this.jl12 = new JLabel("Payment Method: " + 
         paymentMethod);
     
     this.jb1 = new JButton("MY BOOKINGS");
     
     this.jb2 = new JButton("CLOSE");
     
     setLayout((LayoutManager)null);
     
     this.jl1.setBounds(250, 40, 300, 40);
     
     this.jl2.setBounds(100, 100, 400, 35);
     
     this.jl3.setBounds(100, 145, 400, 35);
     
     this.jl4.setBounds(100, 190, 400, 35);
     
     this.jl5.setBounds(100, 235, 500, 35);
     
     this.jl6.setBounds(100, 280, 500, 35);
     
     this.jl7.setBounds(100, 325, 500, 35);
     
     this.jl8.setBounds(100, 370, 500, 35);
     
     this.jl9.setBounds(100, 415, 500, 35);
     
     this.jl10.setBounds(100, 460, 400, 35);
     
     this.jl11.setBounds(100, 505, 400, 35);
     
     this.jl12.setBounds(100, 550, 400, 35);
     
     this.jb1.setBounds(150, 620, 150, 40);
     
     this.jb2.setBounds(350, 620, 120, 40);
     
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
     add(this.jl12);
     
     add(this.jb1);
     add(this.jb2);
     
     this.jb1.addActionListener(this);
     this.jb2.addActionListener(this);
     
     setDefaultCloseOperation(2);
   }
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1) {
       
       MyBookingsPage m = 
         new MyBookingsPage(this.email);
       
       m.setTitle("My Bookings");
       
       m.setSize(800, 700);
       
       m.setLocationRelativeTo((Component)null);
       
       m.setVisible(true);
       
       dispose();
     } 
     
     if (e.getSource() == this.jb2)
     {
       dispose();
     }
   }
 }




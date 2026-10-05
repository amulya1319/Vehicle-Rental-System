 package comvechicleRentalsystem;
 
 import java.awt.Component;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 
 public class VehicleLocationPage
   extends JFrame
   implements ActionListener {
   JLabel jl1;
   JLabel jl2;
   JLabel jl3;
   JLabel jl4;
   JLabel jl5;
   
   public VehicleLocationPage(String email, int rentalId) {
     this.email = email;
     this.rentalId = rentalId;
     
     this.jl1 = new JLabel("VEHICLE LOCATION");
     
     this.jl2 = new JLabel();
     
     this.jl3 = new JLabel();
     
     this.jl4 = new JLabel();
     
     this.jl5 = new JLabel();
     
     this.jl6 = new JLabel();
     
     this.jl7 = new JLabel();
     
     this.jl8 = new JLabel();
     
     this.jb1 = new JButton("BACK");
     
     setLayout((LayoutManager)null);
     
     this.jl1.setBounds(250, 50, 300, 40);
     
     this.jl2.setBounds(120, 120, 450, 40);
     
     this.jl3.setBounds(120, 170, 450, 40);
     
     this.jl4.setBounds(120, 220, 450, 40);
     
     this.jl5.setBounds(120, 270, 450, 40);
     
     this.jl6.setBounds(120, 320, 450, 40);
     
     this.jl7.setBounds(120, 370, 450, 40);
     
     this.jl8.setBounds(120, 420, 450, 40);
     
     this.jb1.setBounds(280, 480, 120, 40);
     
     add(this.jl1);
     
     add(this.jl2);
     
     add(this.jl3);
     
     add(this.jl4);
     
     add(this.jl5);
     
     add(this.jl6);
     
     add(this.jl7);
     
     add(this.jl8);
     
     add(this.jb1);
     
     this.jb1.addActionListener(this);
     
     loadVehicleDetails();
     
     setSize(700, 600);
     
     setLocationRelativeTo((Component)null);
     
     setDefaultCloseOperation(2);
   }
   JLabel jl6; JLabel jl7; JLabel jl8; JButton jb1; String email;
   int rentalId;
   
   private void loadVehicleDetails() {
     try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       
       Connection con = DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/company2", 
           "root", 
           "root");
 
       
       String sql = 
         "SELECT vehicle_name, vehicle_type, pickup_location, return_location, pickup_time, return_time, booking_status FROM vehicle_rentals WHERE rental_id = ? AND email = ?";
 
 
 
 
       
       PreparedStatement pst = 
         con.prepareStatement(sql);
       
       pst.setInt(1, this.rentalId);
       
       pst.setString(2, this.email);
       
       ResultSet rs = pst.executeQuery();
       
       if (rs.next()) {
         
         this.jl2.setText("Vehicle: " + 
             
             rs.getString("vehicle_name"));
 
         
         this.jl3.setText("Type: " + 
             
             rs.getString("vehicle_type"));
 
         
         this.jl4.setText("Pickup Location: " + 
             
             rs.getString("pickup_location"));
 
         
         this.jl5.setText("Return Location: " + 
             
             rs.getString("return_location"));
 
         
         this.jl6.setText("Pickup Time: " + 
             String.valueOf(
               rs.getTime("pickup_time")));
 
         
         this.jl7.setText("Return Time: " + 
             String.valueOf(
               rs.getTime("return_time")));
 
         
         this.jl8.setText("Booking Status: " + 
             
             rs.getString("booking_status"));
       
       }
       else {
         
         JOptionPane.showMessageDialog(
             this, 
             "Booking details not found.");
       } 
 
       
       rs.close();
       
       pst.close();
       
       con.close();
     }
     catch (Exception ex) {
       
       ex.printStackTrace();
       
       JOptionPane.showMessageDialog(
           this, "Error loading vehicle details:\n" + 
           
           ex.getMessage());
     } 
   }
 
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1) {
       
       MyBookingsPage m = 
         new MyBookingsPage(this.email);
       
       m.setTitle("My Bookings");
       
       m.setSize(1200, 600);
       
       m.setLocationRelativeTo((Component)null);
       
       m.setVisible(true);
       
       dispose();
     } 
   }
 }




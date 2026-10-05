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
 import javax.swing.JScrollPane;
 import javax.swing.JTable;
 
 public class MyBookingsPage
   extends JFrame
   implements ActionListener {
   JTable table;
   JButton jb1;
   String email;
   
   public MyBookingsPage(String email) {
     this.email = email;
     
     String[] columns = { 
         "ID", 
         "Vehicle", 
         "Type", 
         "Pickup Date", 
         "Pickup Time", 
         "Return Date", 
         "Return Time", 
         "Pickup Location", 
         "Return Location", 
         "Total Hours", 
         "Total Days", 
         "Extra Hours", 
         "Total Amount", 
         "Payment", 
         "Status" };
 
     
     Object[][] data = new Object[50][15];
     
     int row = 0;
 
     
     try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       
       Connection con = DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/company2", 
           "root", 
           "root");
 
       
       String sql = 
         "SELECT rental_id, vehicle_name, vehicle_type, rent_date, pickup_time, return_date, return_time, pickup_location, return_location, total_hours, total_days, extra_hours, total_amount, payment_status, booking_status FROM vehicle_rentals WHERE email = ?";
 
 
 
 
 
 
       
       PreparedStatement pst = 
         con.prepareStatement(sql);
       
       pst.setString(1, email);
       
       ResultSet rs = pst.executeQuery();
       
       while (rs.next()) {
         
         data[row][0] = Integer.valueOf(rs.getInt("rental_id"));
         
         data[row][1] = rs.getString("vehicle_name");
         
         data[row][2] = rs.getString("vehicle_type");
         
         data[row][3] = rs.getDate("rent_date");
         
         data[row][4] = rs.getTime("pickup_time");
         
         data[row][5] = rs.getDate("return_date");
         
         data[row][6] = rs.getTime("return_time");
         
         data[row][7] = 
           rs.getString("pickup_location");
         
         data[row][8] = 
           rs.getString("return_location");
         
         data[row][9] = 
           rs.getObject("total_hours");
         
         data[row][10] = 
           rs.getObject("total_days");
         
         data[row][11] = 
           rs.getObject("extra_hours");
         
         data[row][12] = 
           rs.getObject("total_amount");
         
         data[row][13] = 
           rs.getString("payment_status");
         
         data[row][14] = 
           rs.getString("booking_status");
         
         row++;
       } 
       
       rs.close();
       pst.close();
       con.close();
     }
     catch (Exception ex) {
       
       ex.printStackTrace();
     } 
     
     this.table = new JTable(data, (Object[])columns);
     
     JScrollPane sp = 
       new JScrollPane(this.table);
     
     sp.setBounds(10, 20, 1160, 400);
     
     this.jb1 = new JButton("CLOSE");
     
     this.jb1.setBounds(500, 450, 120, 40);
     
     setLayout((LayoutManager)null);
     
     add(sp);
     add(this.jb1);
     
     this.jb1.addActionListener(this);
     
     setSize(1200, 550);
     
     setLocationRelativeTo((Component)null);
     
     setDefaultCloseOperation(
         2);
   }
 
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1)
     {
       dispose();
     }
   }
 }




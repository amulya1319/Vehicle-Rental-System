 package comvechicleRentalsystem;
 
 import java.awt.Font;
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JTextField;
 
 public class LoginPage
   extends JFrame
   implements ActionListener {
   JLabel ji;
   JLabel jl1;
   JLabel jl2;
   JLabel background;
   
   public LoginPage() {
     this.ji = new JLabel("VEHICLES RENTAL SYSTEM");
     this.ji.setFont(new Font("Arial", 1, 30));
     
     this.jl1 = new JLabel("Email");
     
     this.jl2 = new JLabel("Pass");
 
 
     
     this.jt1 = new JTextField();
     this.jt2 = new JTextField();
     
     this.jb = new JButton("LOGIN");
     this.jb1 = new JButton("Register");
     this.jb4 = new JButton("Clear");
     
     ImageIcon icon = new ImageIcon("C:\\Users\\Amulya\\Pictures\\in.jpg");
     
     Image image = icon.getImage();
     
     Image newImage = image.getScaledInstance(
         800, 800, 4);
 
     
     icon = new ImageIcon(newImage);
     
     this.background = new JLabel(icon);
     
     setLayout((LayoutManager)null);
     
     this.ji.setBounds(150, 100, 480, 40);
     this.jl1.setBounds(150, 250, 120, 40);
     this.jl2.setBounds(150, 300, 120, 40);
     
     this.jt1.setBounds(200, 250, 180, 40);
     this.jt2.setBounds(200, 300, 180, 40);
     
     this.jb.setBounds(100, 400, 120, 40);
     this.jb1.setBounds(350, 400, 120, 40);
     this.jb4.setBounds(200, 500, 120, 40);
 
     
     this.background.setBounds(0, 0, 800, 800);
     
     add(this.ji);
     add(this.jl1);
     add(this.jl2);
     
     add(this.jt1);
     add(this.jt2);
     
     add(this.jb);
     add(this.jb1);
     add(this.jb4);
     
     add(this.background);
 
     
     this.jb1.addActionListener(this);
 
     
     this.jb.addActionListener(this);
     this.jb4.addActionListener(this);
   }
   JTextField jt1; JTextField jt2; JButton jb; JButton jb1;
   JButton jb4;
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb1) {
       
       RegisterPage r1 = new RegisterPage();
       
       r1.setTitle("REGISTER");
       r1.setSize(800, 800);
       r1.setVisible(true);
       
       dispose();
     } 
 
 
     
     if (e.getSource() == this.jb) {
       
       String email = this.jt1.getText().trim();
       String password = this.jt2.getText().trim();
       System.out.println("Email = [" + email + "]");
       System.out.println("Password = [" + password + "]");
 
 
       
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/company2", 
             "root", 
             "root");
 
         
         PreparedStatement pst = con.prepareStatement(
             "SELECT * FROM proj8 WHERE email=? AND password=?");
 
         
         pst.setString(1, email);
         pst.setString(2, password);
         
         ResultSet rs = pst.executeQuery();
         
         if (rs.next()) {
 
 
           
           JOptionPane.showMessageDialog(
               this, 
               "Login Successful");
 
           
           view_vechicle_avialabe v = new view_vechicle_avialabe(email);
           
           v.setTitle("Vehicle Available");
           v.setSize(800, 800);
           v.setVisible(true);
           
           dispose();
         
         }
         else {
 
           
           JOptionPane.showMessageDialog(
               this, 
               "Invalid Email or Password");
 
           
           RegisterPage r1 = new RegisterPage();
           
           r1.setTitle("REGISTER");
           r1.setSize(800, 800);
           r1.setVisible(true);
           
           dispose();
         } 
         
         rs.close();
         pst.close();
         con.close();
       }
       catch (Exception ex) {
         
         ex.printStackTrace();
         
         JOptionPane.showMessageDialog(
             this, 
             ex.getMessage());
       } 
     } 
     
     if (e.getSource() == this.jb4) {
       this.jt1.setText("");
       this.jt2.setText("");
     } 
   }
 }




 package comvechicleRentalsystem;
 
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.util.Vector;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JComboBox;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JRadioButton;
 import javax.swing.JTextField;
 
 
 
 
 
 
 public class RegisterPage
   extends JFrame
   implements ActionListener
 {
   JLabel jl1 = new JLabel("Name");
   JLabel jl2 = new JLabel("Email");
   JLabel jl3 = new JLabel("pass");
   JLabel jl4 = new JLabel("age");
   JLabel jl5 = new JLabel("adress");
   JLabel jl6 = new JLabel("Gender");
   JLabel background;
   JTextField jt1 = new JTextField();
   JTextField jt2 = new JTextField();
   JTextField jt3 = new JTextField();
   JTextField jt4 = new JTextField();
   JTextField jt5;
   JButton jb3 = new JButton("Submit");
   JButton jb4 = new JButton("SingUp");
   JComboBox jcb;
   JRadioButton jr1 = new JRadioButton("Female");
   JRadioButton jr2 = new JRadioButton("male");
   JRadioButton jr3 = new JRadioButton("others");
   
   public RegisterPage() {
     ImageIcon icon = new ImageIcon("C:\\Users\\Amulya\\Pictures\\in.jpg");
     
     Image image = icon.getImage();
     Image newImage = image.getScaledInstance(800, 800, 4);
     icon = new ImageIcon(newImage);
     
     this.background = new JLabel(icon);
     
     Vector<String> v = new Vector();
     v.add("Hyderabad");
     v.add("Nirmal");
     v.add("Nizamabad");
     v.add("vizag");
     
     this.jcb = new JComboBox<>(v);
     
     setLayout((LayoutManager)null);
     this.jl1.setBounds(50, 100, 120, 40);
     this.jl2.setBounds(50, 150, 120, 40);
     this.jl3.setBounds(50, 200, 120, 40);
     this.jl4.setBounds(50, 250, 120, 40);
     this.jl5.setBounds(50, 300, 120, 40);
     this.jl6.setBounds(50, 400, 120, 40);
 
 
     
     this.jt1.setBounds(110, 100, 180, 40);
     this.jt2.setBounds(110, 150, 180, 40);
     this.jt3.setBounds(110, 200, 180, 40);
     this.jt4.setBounds(110, 250, 180, 40);
 
     
     this.jr1.setBounds(100, 400, 120, 40);
     this.jr2.setBounds(200, 400, 120, 40);
     this.jr3.setBounds(300, 400, 120, 40);
 
     
     this.jb3.setBounds(100, 500, 120, 40);
     this.jb4.setBounds(250, 500, 120, 40);
     
     this.jcb.setBounds(110, 300, 120, 40);
     
     this.background.setBounds(0, 0, 800, 800);
     
     add(this.jl1);
     add(this.jl2);
     add(this.jl3);
     add(this.jl4);
     add(this.jl5);
     add(this.jl6);
     add(this.jt1);
     add(this.jt2);
     add(this.jt3);
     add(this.jt4);
     add(this.jr1);
     add(this.jr2);
     add(this.jr3);
     add(this.jb3);
     add(this.jcb);
     add(this.jb4);
     add(this.background);
     
     this.jb3.addActionListener(this);
     this.jr1.addActionListener(this);
     this.jr2.addActionListener(this);
     this.jr3.addActionListener(this);
   }
 
 
 
   
   String gender;
 
 
   
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.jb3) {
       
       String name = this.jt1.getText();
       String email = this.jt2.getText();
       String password = this.jt3.getText();
       int age = Integer.parseInt(this.jt4.getText());
       String address = this.jcb.getSelectedItem().toString();
 
       
       if (this.jr1.isSelected()) {
         this.gender = "Female";
         this.jr2.setSelected(false);
         this.jr3.setSelected(false);
       } 
       
       if (this.jr2.isSelected()) {
         this.gender = "Male";
         this.jr1.setSelected(false);
         this.jr3.setSelected(false);
       } 
       
       if (this.jr3.isSelected()) {
         this.gender = "Others";
         this.jr1.setSelected(false);
         this.jr2.setSelected(false);
       } 
 
       
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection con = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/company2", 
             "root", 
             "root");
 
         
         PreparedStatement pst = con.prepareStatement(
             "insert into proj8(name,email,password,age,address,gender) values(?,?,?,?,?,?)");
 
         
         pst.setString(1, name);
         pst.setString(2, email);
         pst.setString(3, password);
         pst.setInt(4, age);
         pst.setString(5, address);
         pst.setString(6, this.gender);
         
         pst.executeUpdate();
         
         JOptionPane.showMessageDialog(this, "Registration Successful");
         view_vechicle_avialabe v = new view_vechicle_avialabe(email);
         
         v.setTitle("Vehicle Available");
         v.setSize(800, 800);
         v.setVisible(true);
         dispose();
         
         pst.close();
         con.close();
       }
       catch (Exception ex) {
         ex.printStackTrace();
         JOptionPane.showMessageDialog(this, ex.getMessage());
       } 
     } 
   }
 }




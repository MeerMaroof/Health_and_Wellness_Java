import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Exercise{
       public static void main(String[] args){
              JFrame frame = new JFrame();
              frame.setSize(500,400);
              frame.setLayout(new GridLayout(5,1));
              frame.getContentPane().setBackground(new Color(30, 30, 30));
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setLocationRelativeTo(null);
              frame.setVisible(true);

              JLabel heading = new JLabel("EXERSICE PLAN",JLabel.CENTER);
              heading.setFont(new Font("Arial", Font.BOLD, 22));
              heading.setBounds(130,30,200,30);
              heading.setForeground(Color.WHITE);

              JButton uw = new JButton("UNDERWEIGHT");
              uw.setBackground(Color.decode("#455A64"));
              uw.setForeground(Color.WHITE);
              uw.setFont(new Font("Arial", Font.BOLD, 16));

              JButton normal = new JButton("NORMAL");
              normal.setBackground(Color.decode("#B71C1C"));
              normal.setForeground(Color.WHITE);
              normal.setFont(new Font("Arial", Font.BOLD, 16));

              JButton obese = new JButton("Overweight");
              obese.setBackground(Color.decode("#388E3C"));
              obese.setForeground(Color.WHITE);
              obese.setFont(new Font("Arial", Font.BOLD, 16));

//second frame
              normal.addActionListener(e->{
                     JFrame frame3 = new JFrame();
                     frame.dispose();
                     frame3.setSize(400,500);
                     frame3.setLayout(null);
                     frame3.getContentPane().setBackground(new Color(30, 30, 30));
                     frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     frame3.setLocationRelativeTo(null);
                     JLabel head = new JLabel("Normal Weight");
                     head.setFont(new Font("Arial", Font.BOLD, 18));
                     head.setForeground(Color.WHITE);
                     head.setBounds(125, 8, 150, 30);
                     JLabel cal = new JLabel("BMI = 18.5-24.9");
                     cal.setFont(new Font("Arial", Font.BOLD, 18));
                     cal.setForeground(Color.WHITE);
                     cal.setBounds(110, 400, 190, 30);//(140, 300, 70, 70);

                     JPanel p1 = new JPanel();
                     p1.setBounds(40,60,140,100);
                     p1.setBackground(new Color(173,216,230));
                     p1.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     p1.setLayout(null); // Add this line!

                     JLabel l1 = new JLabel("Push_ups");
                     l1.setBounds(20, 10, 100, 20); // ✅ Add this!
                     l1.setFont(new Font("Arial", Font.BOLD, 18));

                     p1.add(l1);
                     ImageIcon icon = new ImageIcon("pushups5.png"); // image path
                     Image img = icon.getImage();
                     JLabel imgLabel = new JLabel(new ImageIcon(img));
                     imgLabel.setBounds(55, 30, 70, 70); // center of panel
                     // bottom-right corner
                     p1.add(imgLabel);
                     JPanel p2 = new JPanel();
                     p2.setBounds(200,60,140,100);
                     p2.setBackground(new Color(173,216,230));
                     p1.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel l2 = new JLabel("Squats");
                     l2.setBounds(20, 10, 100, 20); // ✅ Add this!
                     l2.setFont(new Font("Arial", Font.BOLD, 18));

                     p2.add(l2);
                     ImageIcon icon2 = new ImageIcon("squats1.png"); // image path
                     Image img2 = icon2.getImage();
                     JLabel imgLabel2 = new JLabel(new ImageIcon(img2));
                     imgLabel2.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     p2.add(imgLabel2);

                     JPanel p3 = new JPanel();
                     p3.setBounds(40,180,140,100);
                     p3.setBackground(new Color(173,216,230));
                     p1.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel l3 = new JLabel("Yoga");
                     l3.setBounds(20, 10, 100, 20); // ✅ Add this!
                     l3.setFont(new Font("Arial", Font.BOLD, 18));

                     p3.add(l3);
                     ImageIcon icon3 = new ImageIcon("yoga.png"); // image path
                     Image img3 = icon3.getImage();
                     JLabel imgLabel3 = new JLabel(new ImageIcon(img3));
                     imgLabel3.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     p3.add(imgLabel3);

                     JPanel p4 = new JPanel();
                     p4.setBounds(200,180,140,100);
                     p4.setBackground(new Color(173,216,230));
                     p1.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel l4 = new JLabel("Plank");
                     l4.setBounds(20, 10, 100, 20); // ✅ Add this!
                     l4.setFont(new Font("Arial", Font.BOLD, 18));

                     p4.add(l4);
                     ImageIcon icon4 = new ImageIcon("plank.png"); // image path
                     Image img4 = icon4.getImage();
                     JLabel imgLabel4 = new JLabel(new ImageIcon(img4));
                     imgLabel4.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     p4.add(imgLabel4);


                     // First image
                     JLabel imga = new JLabel(new ImageIcon("jumping-rope1.png"));
                     imga.setBounds(40, 300, 70, 70);
                     frame3.add(imga);

                     // Second image
                     JLabel imgb = new JLabel(new ImageIcon("mattress1.png"));
                     imgb.setBounds(120, 300, 70, 70);
                     frame3.add(imgb);

                     // Third image
                     JLabel imgc = new JLabel(new ImageIcon("dumbell3.png"));
                     imgc.setBounds(190, 290, 70, 100);
                     frame3.add(imgc);
// fourth image
                     JLabel imgd = new JLabel(new ImageIcon("wei.png"));
                     imgd.setBounds(270, 310, 70, 65);
                     frame3.add(imgd);
                     frame3.add(head);
                     frame3.add(cal);
                     frame3.add(p1);
                     frame3.add(p2);
                     frame3.add(p3);
                     frame3.add(p4);
                     frame3.add(imga);
                     frame3.add(imgb);
                     frame3.add(imgc);
                     frame3.add(imgd);
                     JButton back = new JButton("Back");
                     back.setBounds(10, 10, 80, 30);
                     back.setBackground(Color.BLACK);
                     back.setForeground(Color.WHITE);
                     back.addActionListener(ev -> {
                            Exercise.main(new String[]{}); // reopen main Exercise
                            frame3.dispose(); // close current window
                     });
                     frame3.add(back);
                     frame3.setResizable(false);
                     frame3.setLocationRelativeTo(null);
                     frame3.setVisible(true);
              });

//third frame
              uw.addActionListener(e->{
                     JFrame frame4 = new JFrame();
                     frame.dispose();
                     frame4.setSize(400,600);
                     frame4.setLayout(null);
                     frame4.getContentPane().setBackground(new Color(30, 30, 30));
                     frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     frame4.setLocationRelativeTo(null);
//heading
                     JLabel head2 = new JLabel("UnderWeight");
                     head2.setFont(new Font("Arial", Font.BOLD, 16));
                     head2.setForeground(Color.WHITE);
                     head2.setBounds(125, 8, 150, 30);
//calories
                     JLabel calo = new JLabel("BMI = <18.5");
                     calo.setFont(new Font("Arial", Font.BOLD, 16));
                     calo.setForeground(Color.WHITE);
                     calo.setBounds(110, 420, 180, 30);
//panel1
                     JPanel pa = new JPanel();
                     pa.setBounds(40,60,140,100);
                     pa.setBackground(new Color(173,216,230));
                     pa.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     pa.setLayout(null); // Add this line!

                     JLabel la = new JLabel("Push_ups");
                     la.setBounds(20, 10, 100, 20); // ✅ Add this!
                     la.setFont(new Font("Arial", Font.BOLD, 18));

                     pa.add(la);
                     ImageIcon icon = new ImageIcon("pushups5.png"); // image path
                     Image img = icon.getImage();
                     JLabel imgLabel = new JLabel(new ImageIcon(img));
                     imgLabel.setBounds(55, 30, 70, 70); // center of panel
                     // bottom-right corner
                     pa.add(imgLabel);

//panel2
                     JPanel pb = new JPanel();
                     pb.setBounds(200,60,140,100);
                     pb.setBackground(new Color(173,216,230));
                     pb.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lb = new JLabel("Squats");
                     lb.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lb.setFont(new Font("Arial", Font.BOLD, 18));

                     pb.add(lb);
                     ImageIcon icon2 = new ImageIcon("squats1.png"); // image path
                     Image img2 = icon2.getImage();
                     JLabel imgLabel2 = new JLabel(new ImageIcon(img2));
                     imgLabel2.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pb.add(imgLabel2);
//panel3
                     JPanel pc = new JPanel();
                     pc.setBounds(40,180,140,100);
                     pc.setBackground(new Color(173,216,230));
                     pc.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lc = new JLabel("Yoga");
                     lc.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lc.setFont(new Font("Arial", Font.BOLD, 18));

                     pc.add(lc);
                     ImageIcon icon3 = new ImageIcon("yoga.png"); // image path
                     Image img3 = icon3.getImage();
                     JLabel imgLabel3 = new JLabel(new ImageIcon(img3));
                     imgLabel3.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pc.add(imgLabel3);

//panel4
                     JPanel pd = new JPanel();
                     pd.setBounds(200,180,140,100);
                     pd.setBackground(new Color(173,216,230));
                     pd.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel ld = new JLabel("Pull_up");
                     ld.setBounds(20, 10, 100, 20); // ✅ Add this!
                     ld.setFont(new Font("Arial", Font.BOLD, 18));
                     pd.setLayout(null); // Must have this

                     pd.add(ld);
                     ImageIcon icon4 = new ImageIcon("pull-up1.png"); // image path
                     Image img4 = icon4.getImage();
                     JLabel imgLabel4 = new JLabel(new ImageIcon(img4));
                     imgLabel4.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pd.add(imgLabel4);

                     pd.add(ld);

//panel5
                     JPanel pe = new JPanel();
                     pe.setBounds(40, 300, 140, 100);
                     pe.setBackground(new Color(173,216,230));
                     pe.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     pe.setLayout(null); // Add this line!

                     JLabel le = new JLabel("Jogging");
                     le.setBounds(20, 10, 100, 20); // ✅ Add this!
                     le.setFont(new Font("Arial", Font.BOLD, 18));

                     pe.add(le);
                     ImageIcon icon5 = new ImageIcon("exercise.png"); // image path
                     Image img5 = icon5.getImage();
                     JLabel imgLabel5 = new JLabel(new ImageIcon(img5));
                     imgLabel5.setBounds(35, 30, 70, 70); // center of panel
                     // bottom-right corner
                     pe.add(imgLabel5);

//panel6
                     JPanel pf = new JPanel();
                     pf.setBounds(200, 300, 140, 100);
                     pf.setBackground(new Color(173,216,230));
                     pf.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lf = new JLabel("Bench_press");
                     lf.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lf.setFont(new Font("Arial", Font.BOLD, 18));

                     pf.add(lf);
                     ImageIcon icon6 = new ImageIcon("benchpress.png"); // image path
                     Image img6 = icon6.getImage();
                     JLabel imgLabel6 = new JLabel(new ImageIcon(img6));
                     imgLabel6.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pf.add(imgLabel6);
                     // First image
                     JLabel imga = new JLabel(new ImageIcon("jumping-rope1.png"));
                     imga.setBounds(40, 450, 70, 70);
                     frame4.add(imga);

                     // Second image
                     JLabel imgb = new JLabel(new ImageIcon("mattress1.png"));
                     imgb.setBounds(120, 450, 70, 70);
                     frame4.add(imgb);

                     // Third image
                     JLabel imgc = new JLabel(new ImageIcon("dumbell3.png"));
                     imgc.setBounds(200, 450, 70, 70);
                     frame4.add(imgc);
// fourth image
                     JLabel imgd = new JLabel(new ImageIcon("wei.png"));
                     imgd.setBounds(280, 450, 70, 70);
                     frame4.add(imgd);
                     frame4.add(head2);
                     frame4.add(calo);
                     frame4.add(pa);
                     frame4.add(pb);
                     frame4.add(pc);
                     frame4.add(pd);
                     frame4.add(pe);
                     frame4.add(pf);
                     frame4.add(imga);
                     frame4.add(imgb);
                     frame4.add(imgc);
                     frame4.add(imgd);
                     JButton back = new JButton("Back");
                     back.setBounds(10, 10, 80, 30);
                     back.setBackground(Color.BLACK);
                     back.setForeground(Color.WHITE);
                     back.addActionListener(ev -> {
                            Exercise.main(new String[]{});
                            frame4.dispose();
                     });
                     frame4.add(back);
                     frame4.setResizable(false);
                     frame4.setLocationRelativeTo(null);
                     frame4.setVisible(true);
              });

//frame 5
              obese.addActionListener(e->{
                     JFrame frame5 = new JFrame();
                     frame.dispose();
                     frame5.setSize(400,750);
                     frame5.setLayout(null);
                     frame5.getContentPane().setBackground(new Color(30, 30, 30));
                     frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     frame5.setLocationRelativeTo(null);
//heading
                     JLabel head3 = new JLabel("OVERWEIGHT/OBESE");
                     head3.setFont(new Font("Arial", Font.BOLD, 14));
                     head3.setForeground(Color.WHITE);
                     head3.setBounds(125, 8, 150, 30);
//calories
                     JLabel calor = new JLabel("BMI = 25-29.9/<29.9");
                     calor.setFont(new Font("Arial", Font.BOLD, 16));
                     calor.setForeground(Color.WHITE);
                     calor.setBounds(110, 530, 180, 30);
//panel1
                     JPanel paa = new JPanel();
                     paa.setBounds(40,60,140,100);
                     paa.setBackground(new Color(173,216,230));
                     paa.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     paa.setLayout(null); // Add this line!

                     JLabel laa = new JLabel("Push_ups");
                     laa.setBounds(20, 10, 100, 20); // ✅ Add this!
                     laa.setFont(new Font("Arial", Font.BOLD, 18));

                     paa.add(laa);
                     ImageIcon iconaa = new ImageIcon("pushups5.png"); // image path
                     Image imgaa = iconaa.getImage();
                     JLabel imgLabelaa = new JLabel(new ImageIcon(imgaa));
                     imgLabelaa.setBounds(55, 30, 70, 70); // center of panel
                     // bottom-right corner
                     paa.add(imgLabelaa);

//panel2
                     JPanel pbb = new JPanel();
                     pbb.setBounds(200,60,140,100);
                     pbb.setBackground(new Color(173,216,230));
                     pbb.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lbb = new JLabel("Squats");
                     lbb.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lbb.setFont(new Font("Arial", Font.BOLD, 18));

                     pbb.add(lbb);
                     ImageIcon iconbb = new ImageIcon("squats1.png"); // image path
                     Image imgbb = iconbb.getImage();
                     JLabel imgLabelbb = new JLabel(new ImageIcon(imgbb));
                     imgLabelbb.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pbb.add(imgLabelbb);
//panel3
                     JPanel pcc = new JPanel();
                     pcc.setBounds(40,180,140,100);
                     pcc.setBackground(new Color(173,216,230));
                     pcc.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lcc = new JLabel("Yoga");
                     lcc.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lcc.setFont(new Font("Arial", Font.BOLD, 18));

                     pcc.add(lcc);
                     ImageIcon iconcc = new ImageIcon("yoga3.png"); // image path
                     Image imgcc = iconcc.getImage();
                     JLabel imgLabelcc = new JLabel(new ImageIcon(imgcc));
                     imgLabelcc.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pcc.add(imgLabelcc);

//panel4
                     JPanel pdd = new JPanel();
                     pdd.setBounds(200,180,140,100);
                     pdd.setBackground(new Color(173,216,230));
                     pdd.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel ldd = new JLabel("Walking");
                     ldd.setBounds(20, 10, 100, 20); // ✅ Add this!
                     ldd.setFont(new Font("Arial", Font.BOLD, 16));
                     pdd.setLayout(null); // Must have this

                     pdd.add(ldd);
                     ImageIcon icondd = new ImageIcon("walk.png"); // image path
                     Image imgdd = icondd.getImage();
                     JLabel imgLabeldd = new JLabel(new ImageIcon(imgdd));
                     imgLabeldd.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pdd.add(imgLabeldd);

                     pdd.add(ldd);

//panel5
                     JPanel pee = new JPanel();
                     pee.setBounds(40, 300, 140, 100);
                     pee.setBackground(new Color(173,216,230));
                     pee.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     pee.setLayout(null); // Add this line!

                     JLabel lee = new JLabel("Cycling");
                     lee.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lee.setFont(new Font("Arial", Font.BOLD, 18));

                     pee.add(lee);
                     ImageIcon iconee = new ImageIcon("workout.png"); // image path
                     Image imgee = iconee.getImage();
                     JLabel imgLabelee = new JLabel(new ImageIcon(imgee));
                     imgLabelee.setBounds(35, 30, 70, 70); // center of panel
                     // bottom-right corner
                     pee.add(imgLabelee);

//panel6
                     JPanel pff = new JPanel();
                     pff.setBounds(200, 300, 140, 100);
                     pff.setBackground(new Color(173,216,230));
                     pff.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lff = new JLabel("Step_ups");
                     lff.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lff.setFont(new Font("Arial", Font.BOLD, 18));

                     pff.add(lff);
                     ImageIcon iconff = new ImageIcon("step.png"); // image path
                     Image imgff = iconff.getImage();
                     JLabel imgLabelff = new JLabel(new ImageIcon(imgff));
                     imgLabelff.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     pff.add(imgLabelff);

//panel 7
                     JPanel pgg = new JPanel();
                     pgg.setBounds(40, 420, 140, 100);;
                     pgg.setBackground(new Color(173,216,230));
                     pgg.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     pgg.setLayout(null); // Add this line!

                     JLabel lgg = new JLabel("leg shift");
                     lgg.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lgg.setFont(new Font("Arial", Font.BOLD, 18));

                     pgg.add(lgg);
                     ImageIcon icongg = new ImageIcon("leg2.png"); // image path
                     Image imggg = icongg.getImage();
                     JLabel imgLabelgg = new JLabel(new ImageIcon(imggg));
                     imgLabelgg.setBounds(35, 30, 70, 70); // center of panel
                     // bottom-right corner
                     pgg.add(imgLabelgg);

//panel8
                     JPanel phh = new JPanel();
                     phh.setBounds(200, 420, 140, 100);
                     phh.setBackground(new Color(173,216,230));
                     phh.setBorder(new LineBorder(new Color(173, 216, 230), 4, true));

                     JLabel lhh = new JLabel("bench_press");
                     lhh.setBounds(20, 10, 100, 20); // ✅ Add this!
                     lhh.setFont(new Font("Arial", Font.BOLD, 18));

                     phh.add(lhh);
                     ImageIcon iconhh = new ImageIcon("benchpress.png"); // image path
                     Image imghh = iconhh.getImage();
                     JLabel imgLabelhh = new JLabel(new ImageIcon(imghh));
                     imgLabelhh.setBounds(55, 25, 70, 70); // center of panel
                     // bottom-right corner
                     phh.add(imgLabelhh);


                     // First image
                     JLabel imga1 = new JLabel(new ImageIcon("jumping-rope1.png"));
                     imga1.setBounds(40, 570, 70, 70);
                     frame5.add(imga1);

                     // Second image
                     JLabel imgb2 = new JLabel(new ImageIcon("mattress1.png"));
                     imgb2.setBounds(120, 570, 70, 70);
                     frame5.add(imgb2);

                     // Third image
                     JLabel imgc3 = new JLabel(new ImageIcon("dumbell3.png"));
                     imgc3.setBounds(200, 570, 70, 70);
                     frame5.add(imgc3);

                     // fourth image
                     JLabel imgd4 = new JLabel(new ImageIcon("wei.png"));
                     imgd4.setBounds(280, 570, 70, 70);
                     frame5.add(imgd4);

                     frame5.add(imgd4);
                     frame5.add(head3);
                     frame5.add(calor);
                     frame5.add(paa);
                     frame5.add(pbb);
                     frame5.add(pcc);
                     frame5.add(pdd);
                     frame5.add(pee);
                     frame5.add(pff);
                     frame5.add(pgg);
                     frame5.add(phh);
                     frame5.add(imga1);
                     frame5.add(imgb2);
                     frame5.add(imgc3);
                     frame5.add(imgd4);
                     JButton back = new JButton("Back");
                     back.setBounds(10, 10, 80, 30);
                     back.setBackground(Color.BLACK);
                     back.setForeground(Color.WHITE);
                     back.addActionListener(ev -> {
                            Exercise.main(new String[]{});
                            frame5.dispose();
                     });
                     frame5.add(back);
                     frame5.setResizable(false);
                     frame5.setLocationRelativeTo(null);
                     frame5.setVisible(true);
              });




              frame.add(heading);
// frame.add(uw,FlowLayout.LEFT);
// frame.add(normal,FlowLayout.CENTER);
// frame.add(obese,FlowLayout.RIGHT);
              frame.add(uw);
              frame.add(normal);
              frame.add(obese);

              JButton back = new JButton("Back");
              back.setBackground(Color.BLACK);
              back.setForeground(Color.WHITE);
              back.setFont(new Font("Arial", Font.BOLD, 14));
              back.setPreferredSize(new Dimension(100, 30)); // for FlowLayout
              back.addActionListener(ev -> {
                     Dashboard.main(new String[]{}); // open Dashboard
                     frame.dispose(); // close Exercise window
              });
              frame.add(back);

// Make sure the frame is visible
              frame.setResizable(false);
              frame.setLocationRelativeTo(null);
              frame.setVisible(true);

       }
}




import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Game{
    public static void main(String[] args){


        JFrame gf = new JFrame("Game");
        gf.setSize(400,400);
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setLayout(null);
        gf.getContentPane().setBackground(Color.BLACK);

        //Score ko store karne ka liye
        int[] score ={0};


        ImageIcon icc = new ImageIcon("front.png");
        JLabel ill = new JLabel(icc);
        ill.setBounds(120,20,150,150);
        gf.add(ill);

        ImageIcon icc1 = new ImageIcon("front3.png");
        JLabel ill1 = new JLabel(icc1);
        ill1.setBounds(120,220,150,150);
        gf.add(ill1);

        JLabel gl = new JLabel("Unhealthy Food");
        gl.setBounds(100,150,200,40);
        gl.setFont(new Font("Arial", Font.BOLD, 24));
        gl.setForeground(Color.WHITE);
        gf.add(gl);

        JButton gb  = new JButton("Start Game");
        gb.setBounds(120,200,140,40);
        gb.setBackground(Color.BLACK);
        gb.setForeground(Color.WHITE);
        gb.setFont(new Font("Arial", Font.PLAIN, 15));
        gf.add(gb);

        //question 1
        gb.addActionListener(e->{
            JFrame nf = new JFrame("Start");
            nf.setSize(400,600);
            nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nf.setLayout(null);
            nf.getContentPane().setBackground(Color.BLACK);

            JLabel nl = new JLabel("Swap this Food");
            nl.setBounds(110,30,200,40);
            nl.setFont(new Font("Arial", Font.BOLD, 18));
            nl.setForeground(Color.WHITE);
            nf.add(nl);

            ImageIcon ic = new ImageIcon("burger.png");
            JLabel il = new JLabel(ic);
            il.setBounds(120,70,150,150);
            nf.add(il);

            JLabel bl = new JLabel("Burger");
            bl.setBounds(150,220,100,40);
            bl.setFont(new Font("Arial", Font.BOLD, 20));
            bl.setForeground(Color.WHITE);
            nf.add(bl);

            //score label
            JLabel sl = new JLabel("Score = " +score[0] +"/8");
            sl.setBounds(50,460,120,40);
            sl.setFont(new Font("Arial", Font.BOLD, 17));
            sl.setForeground(Color.WHITE);
            nf.add(sl);

            JButton ib  = new JButton("Popcorn");
            ib.setBounds(40,280,100,40);
            ib.setBackground(Color.BLACK);
            ib.setForeground(Color.WHITE);
            ib.setFont(new Font("Arial", Font.PLAIN, 15));
            nf.add(ib);

            JButton ib1  = new JButton("Fries");
            ib1.setBounds(40,340,100,40);
            ib1.setBackground(Color.BLACK);
            ib1.setForeground(Color.WHITE);
            ib1.setFont(new Font("Arial", Font.PLAIN, 15));
            nf.add(ib1);

            JButton ib2  = new JButton("Samosa");
            ib2.setBounds(40,400,100,40);
            ib2.setBackground(Color.BLACK);
            ib2.setForeground(Color.WHITE);
            ib2.setFont(new Font("Arial", Font.PLAIN, 15));
            nf.add(ib2);

            ib1.addActionListener(bbe->{
                JOptionPane.showMessageDialog(null,"Wrong Answer");




            });

            ib2.addActionListener(bee->{
                JOptionPane.showMessageDialog(null,"Wrong Answer");
            });

            nf.setResizable(false);
            nf.setLocationRelativeTo(null);
            nf.setVisible(true);
            gf.dispose();

            //question 2
            ib.addActionListener(nbb->{
                JOptionPane.showMessageDialog(null,"Correct Answer");
                score[0]++;
                sl.setText("Score = " +score[0] +"/8");

                JFrame nf1 = new JFrame("Start");
                nf1.setSize(400,600);
                nf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nf1.setLayout(null);
                nf1.getContentPane().setBackground(Color.BLACK);

                JLabel nl1 = new JLabel("Swap this Food");
                nl1.setBounds(110,30,200,40);
                nl1.setFont(new Font("Arial", Font.BOLD, 18));
                nl1.setForeground(Color.WHITE);
                nf1.add(nl1);

                ImageIcon ic1 = new ImageIcon("nuggets.png");
                JLabel il1 = new JLabel(ic1);
                il1.setBounds(120,70,150,150);
                nf1.add(il1);

                JLabel bl1 = new JLabel("Nuggets");
                bl1.setBounds(150,220,150,40);
                bl1.setFont(new Font("Arial", Font.BOLD, 20));
                bl1.setForeground(Color.WHITE);
                nf1.add(bl1);

                //score label
                JLabel sl1 = new JLabel("Score = " +score[0] +"/8");
                sl1.setBounds(50,460,120,40);
                sl1.setFont(new Font("Arial", Font.BOLD, 17));
                sl1.setForeground(Color.WHITE);
                nf1.add(sl1);

                JButton ibb  = new JButton("Chips");
                ibb.setBounds(40,280,100,40);
                ibb.setBackground(Color.BLACK);
                ibb.setForeground(Color.WHITE);
                ibb.setFont(new Font("Arial", Font.PLAIN, 15));
                nf1.add(ibb);

                JButton ibs  = new JButton("Grilled Chicken");
                ibs.setBounds(40,340,150,40);
                ibs.setBackground(Color.BLACK);
                ibs.setForeground(Color.WHITE);
                ibs.setFont(new Font("Arial", Font.PLAIN, 15));
                nf1.add(ibs);

                JButton iba  = new JButton("Pakora");
                iba.setBounds(40,400,100,40);
                iba.setBackground(Color.BLACK);
                iba.setForeground(Color.WHITE);
                iba.setFont(new Font("Arial", Font.PLAIN, 15));
                nf1.add(iba);

                ibb.addActionListener(bbe->{
                    JOptionPane.showMessageDialog(null,"Wrong Answer");
                });

                iba.addActionListener(bee->{
                    JOptionPane.showMessageDialog(null,"Wrong Answer");
                });

                nf1.setResizable(false);
                nf1.setLocationRelativeTo(null);
                nf1.setVisible(true);
                nf.dispose();

                //question 3
                ibs.addActionListener(nbb1->{
                    JOptionPane.showMessageDialog(null,"Correct Answer");
                    score[0]++;
                    sl1.setText("Score = " +score[0] +"/8");
                    JFrame nf2 = new JFrame("Start");
                    nf2.setSize(400,600);
                    nf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    nf2.setLayout(null);
                    nf2.getContentPane().setBackground(Color.BLACK);

                    JLabel nl2 = new JLabel("Swap this Food");
                    nl2.setBounds(110,30,200,40);
                    nl2.setFont(new Font("Arial", Font.BOLD, 18));
                    nl2.setForeground(Color.WHITE);
                    nf2.add(nl2);

                    ImageIcon ic2 = new ImageIcon("pizza.png");
                    JLabel il2 = new JLabel(ic2);
                    il2.setBounds(120,70,150,150);
                    nf2.add(il2);

                    JLabel bl2 = new JLabel("Pizza");
                    bl2.setBounds(150,220,150,40);
                    bl2.setFont(new Font("Arial", Font.BOLD, 20));
                    bl2.setForeground(Color.WHITE);
                    nf2.add(bl2);

                    //score label
                    JLabel sl2 = new JLabel("Score = " +score[0] +"/8");
                    sl2.setBounds(50,460,120,40);
                    sl2.setFont(new Font("Arial", Font.BOLD, 17));
                    sl2.setForeground(Color.WHITE);
                    nf2.add(sl2);

                    JButton ibb1  = new JButton("Donut");
                    ibb1.setBounds(40,280,100,40);
                    ibb1.setBackground(Color.BLACK);
                    ibb1.setForeground(Color.WHITE);
                    ibb1.setFont(new Font("Arial", Font.PLAIN, 15));
                    nf2.add(ibb1);

                    JButton ibs1  = new JButton("Garlic bread");
                    ibs1.setBounds(40,340,150,40);
                    ibs1.setBackground(Color.BLACK);
                    ibs1.setForeground(Color.WHITE);
                    ibs1.setFont(new Font("Arial", Font.PLAIN, 15));
                    nf2.add(ibs1);

                    JButton iba1  = new JButton("Yougurt");
                    iba1.setBounds(40,400,100,40);
                    iba1.setBackground(Color.BLACK);
                    iba1.setForeground(Color.WHITE);
                    iba1.setFont(new Font("Arial", Font.PLAIN, 15));
                    nf2.add(iba1);

                    ibb1.addActionListener(bbe->{
                        JOptionPane.showMessageDialog(null,"Wrong Answer");
                    });

                    ibs1.addActionListener(bee->{
                        JOptionPane.showMessageDialog(null,"Wrong Answer");
                    });

                    nf2.setResizable(false);
                    nf2.setLocationRelativeTo(null);
                    nf2.setVisible(true);
                    nf1.dispose();

                    //question 4
                    iba1.addActionListener(nbb2->{
                        JOptionPane.showMessageDialog(null,"Correct Answer");
                        score[0]++;
                        sl2.setText("Score = " +score[0] +"/8");
                        JFrame nf3 = new JFrame("Start");
                        nf3.setSize(400,600);
                        nf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        nf3.setLayout(null);
                        nf3.getContentPane().setBackground(Color.BLACK);

                        JLabel nl3 = new JLabel("Swap this Food");
                        nl3.setBounds(110,30,200,40);
                        nl3.setFont(new Font("Arial", Font.BOLD, 18));
                        nl3.setForeground(Color.WHITE);
                        nf3.add(nl3);

                        ImageIcon ic3 = new ImageIcon("soda.png");
                        JLabel il3 = new JLabel(ic3);
                        il3.setBounds(120,70,150,150);
                        nf3.add(il3);

                        JLabel bl3 = new JLabel("Soda");
                        bl3.setBounds(160,220,150,40);
                        bl3.setFont(new Font("Arial", Font.BOLD, 21));
                        bl3.setForeground(Color.WHITE);
                        nf3.add(bl3);

                        //score label
                        JLabel sl3 = new JLabel("Score = " +score[0] +"/8");
                        sl3.setBounds(50,460,120,40);
                        sl3.setFont(new Font("Arial", Font.BOLD, 17));
                        sl3.setForeground(Color.WHITE);
                        nf3.add(sl3);

                        JButton ibb2 = new JButton("Pepsi");
                        ibb2.setBounds(40,280,100,40);
                        ibb2.setBackground(Color.BLACK);
                        ibb2.setForeground(Color.WHITE);
                        ibb2.setFont(new Font("Arial", Font.PLAIN, 15));
                        nf3.add(ibb2);

                        JButton ibs2  = new JButton("Shake");
                        ibs2.setBounds(40,340,100,40);
                        ibs2.setBackground(Color.BLACK);
                        ibs2.setForeground(Color.WHITE);
                        ibs2.setFont(new Font("Arial", Font.PLAIN, 15));
                        nf3.add(ibs2);

                        JButton iba2  = new JButton("Lemonade");
                        iba2.setBounds(40,400,120,40);
                        iba2.setBackground(Color.BLACK);
                        iba2.setForeground(Color.WHITE);
                        iba2.setFont(new Font("Arial", Font.PLAIN, 15));
                        nf3.add(iba2);

                        ibb2.addActionListener(bbe->{
                            JOptionPane.showMessageDialog(null,"Wrong Answer");
                        });

                        ibs2.addActionListener(bee->{
                            JOptionPane.showMessageDialog(null,"Wrong Answer");
                        });

                        nf3.setResizable(false);
                        nf3.setLocationRelativeTo(null);
                        nf3.setVisible(true);
                        nf2.dispose();


                        //question 5
                        iba2.addActionListener(nbb3->{
                            JOptionPane.showMessageDialog(null,"Correct Answer");
                            score[0]++;
                            sl3.setText("Score = " +score[0] +"/8");
                            JFrame nf4 = new JFrame("Start");
                            nf4.setSize(400,600);
                            nf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            nf4.setLayout(null);
                            nf4.getContentPane().setBackground(Color.BLACK);

                            JLabel nl4 = new JLabel("Swap this Food");
                            nl4.setBounds(110,30,200,40);
                            nl4.setFont(new Font("Arial", Font.BOLD, 18));
                            nl4.setForeground(Color.WHITE);
                            nf4.add(nl4);

                            ImageIcon ic4 = new ImageIcon("cake.png");
                            JLabel il4 = new JLabel(ic4);
                            il4.setBounds(120,70,150,150);
                            nf4.add(il4);

                            JLabel bl4 = new JLabel("Cake");
                            bl4.setBounds(160,220,150,40);
                            bl4.setFont(new Font("Arial", Font.BOLD, 21));
                            bl4.setForeground(Color.WHITE);
                            nf4.add(bl4);

                            //score label
                            JLabel sl4 = new JLabel("Score = " +score[0] +"/8");
                            sl4.setBounds(50,460,120,40);
                            sl4.setFont(new Font("Arial", Font.BOLD, 17));
                            sl4.setForeground(Color.WHITE);
                            nf4.add(sl4);

                            JButton ibb3 = new JButton("Ice-Cream");
                            ibb3.setBounds(40,280,120,40);
                            ibb3.setBackground(Color.BLACK);
                            ibb3.setForeground(Color.WHITE);
                            ibb3.setFont(new Font("Arial", Font.PLAIN, 15));
                            nf4.add(ibb3);

                            JButton ibs3  = new JButton("Brown Bread");
                            ibs3.setBounds(40,340,150,40);
                            ibs3.setBackground(Color.BLACK);
                            ibs3.setForeground(Color.WHITE);
                            ibs3.setFont(new Font("Arial", Font.PLAIN, 13));
                            nf4.add(ibs3);

                            JButton iba3  = new JButton("Bread");
                            iba3.setBounds(40,400,100,40);
                            iba3.setBackground(Color.BLACK);
                            iba3.setForeground(Color.WHITE);
                            iba3.setFont(new Font("Arial", Font.PLAIN, 15));
                            nf4.add(iba3);

                            ibb3.addActionListener(bbe->{
                                JOptionPane.showMessageDialog(null,"Wrong Answer");
                            });

                            iba3.addActionListener(bee->{
                                JOptionPane.showMessageDialog(null,"Wrong Answer");
                            });

                            nf4.setResizable(false);
                            nf4.setLocationRelativeTo(null);
                            nf4.setVisible(true);
                            nf3.dispose();

                            //question 6
                            ibs3.addActionListener(nbb4->{
                                JOptionPane.showMessageDialog(null,"Correct Answer");
                                score[0]++;
                                sl4.setText("Score = " +score[0] +"/8");
                                JFrame nf5 = new JFrame("Start");
                                nf5.setSize(400,600);
                                nf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                nf5.setLayout(null);
                                nf5.getContentPane().setBackground(Color.BLACK);

                                JLabel nl5 = new JLabel("Swap this Food");
                                nl5.setBounds(110,30,200,40);
                                nl5.setFont(new Font("Arial", Font.BOLD, 18));
                                nl5.setForeground(Color.WHITE);
                                nf5.add(nl5);

                                ImageIcon ic5 = new ImageIcon("chips.png");
                                JLabel il5 = new JLabel(ic5);
                                il5.setBounds(120,70,150,150);
                                nf5.add(il5);

                                JLabel bl5 = new JLabel("Chips");
                                bl5.setBounds(160,220,150,40);
                                bl5.setFont(new Font("Arial", Font.BOLD, 21));
                                bl5.setForeground(Color.WHITE);
                                nf5.add(bl5);

                                //score label
                                JLabel sl5 = new JLabel("Score = " +score[0] +"/8");
                                sl5.setBounds(50,460,120,40);
                                sl5.setFont(new Font("Arial", Font.BOLD, 17));
                                sl5.setForeground(Color.WHITE);
                                nf5.add(sl5);

                                JButton ibb4 = new JButton("Dark Choclate");
                                ibb4.setBounds(40,280,150,40);
                                ibb4.setBackground(Color.BLACK);
                                ibb4.setForeground(Color.WHITE);
                                ibb4.setFont(new Font("Arial", Font.PLAIN, 15));
                                nf5.add(ibb4);

                                JButton ibs4  = new JButton("Pasta");
                                ibs4.setBounds(40,340,120,40);
                                ibs4.setBackground(Color.BLACK);
                                ibs4.setForeground(Color.WHITE);
                                ibs4.setFont(new Font("Arial", Font.PLAIN, 13));
                                nf5.add(ibs4);

                                JButton iba4  = new JButton("Roll");
                                iba4.setBounds(40,400,100,40);
                                iba4.setBackground(Color.BLACK);
                                iba4.setForeground(Color.WHITE);
                                iba4.setFont(new Font("Arial", Font.PLAIN, 15));
                                nf5.add(iba4);

                                ibs4.addActionListener(bbe->{
                                    JOptionPane.showMessageDialog(null,"Wrong Answer");
                                });

                                iba4.addActionListener(bee->{
                                    JOptionPane.showMessageDialog(null,"Wrong Answer");
                                });

                                nf5.setResizable(false);
                                nf5.setLocationRelativeTo(null);
                                nf5.setVisible(true);
                                nf4.dispose();

                                //question 7
                                ibb4.addActionListener(nbb5->{
                                    JOptionPane.showMessageDialog(null,"Correct Answer");
                                    score[0]++;
                                    sl5.setText("Score = " +score[0] +"/8");
                                    JFrame nf6 = new JFrame("Start");
                                    nf6.setSize(400,600);
                                    nf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    nf6.setLayout(null);
                                    nf6.getContentPane().setBackground(Color.BLACK);

                                    JLabel nl6 = new JLabel("Swap this Food");
                                    nl6.setBounds(110,30,200,40);
                                    nl6.setFont(new Font("Arial", Font.BOLD, 18));
                                    nl6.setForeground(Color.WHITE);
                                    nf6.add(nl6);

                                    ImageIcon ic6 = new ImageIcon("pudding.png");
                                    JLabel il6 = new JLabel(ic6);
                                    il6.setBounds(120,70,150,150);
                                    nf6.add(il6);

                                    JLabel bl6 = new JLabel("Pudding");
                                    bl6.setBounds(150,220,170,40);
                                    bl6.setFont(new Font("Arial", Font.BOLD, 21));
                                    bl6.setForeground(Color.WHITE);
                                    nf6.add(bl6);

                                    //score label
                                    JLabel sl6 = new JLabel("Score = " +score[0] +"/8");
                                    sl6.setBounds(50,460,120,40);
                                    sl6.setFont(new Font("Arial", Font.BOLD, 17));
                                    sl6.setForeground(Color.WHITE);
                                    nf6.add(sl6);

                                    JButton ibb5 = new JButton("Ooats");
                                    ibb5.setBounds(40,280,100,40);
                                    ibb5.setBackground(Color.BLACK);
                                    ibb5.setForeground(Color.WHITE);
                                    ibb5.setFont(new Font("Arial", Font.PLAIN, 15));
                                    nf6.add(ibb5);

                                    JButton ibs5  = new JButton("Maggi");
                                    ibs5.setBounds(40,340,120,40);
                                    ibs5.setBackground(Color.BLACK);
                                    ibs5.setForeground(Color.WHITE);
                                    ibs5.setFont(new Font("Arial", Font.PLAIN, 13));
                                    nf6.add(ibs5);

                                    JButton iba5  = new JButton("Cheesy Sandwich");
                                    iba5.setBounds(40,400,160,40);
                                    iba5.setBackground(Color.BLACK);
                                    iba5.setForeground(Color.WHITE);
                                    iba5.setFont(new Font("Arial", Font.PLAIN, 15));
                                    nf6.add(iba5);

                                    ibs5.addActionListener(bbe->{
                                        JOptionPane.showMessageDialog(null,"Wrong Answer");
                                    });

                                    iba5.addActionListener(bee->{
                                        JOptionPane.showMessageDialog(null,"Wrong Answer");
                                    });

                                    nf6.setResizable(false);
                                    nf6.setLocationRelativeTo(null);
                                    nf6.setVisible(true);
                                    nf5.dispose();

                                    //question 8
                                    ibb5.addActionListener(nbb6->{
                                        JOptionPane.showMessageDialog(null,"Correct Answer");
                                        score[0]++;
                                        sl6.setText("Score = " +score[0] +"/8");
                                        JFrame nf7 = new JFrame("Start");
                                        nf7.setSize(400,600);
                                        nf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        nf7.setLayout(null);
                                        nf7.getContentPane().setBackground(Color.BLACK);

                                        JLabel nl7 = new JLabel("Swap this Food");
                                        nl7.setBounds(110,30,200,40);
                                        nl7.setFont(new Font("Arial", Font.BOLD, 18));
                                        nl7.setForeground(Color.WHITE);
                                        nf7.add(nl7);

                                        ImageIcon ic7 = new ImageIcon("tea.png");
                                        JLabel il7 = new JLabel(ic7);
                                        il7.setBounds(120,70,150,150);
                                        nf7.add(il7);

                                        JLabel bl7 = new JLabel("Tea");
                                        bl7.setBounds(150,220,170,40);
                                        bl7.setFont(new Font("Arial", Font.BOLD, 22));
                                        bl7.setForeground(Color.WHITE);
                                        nf7.add(bl7);

                                        //score label
                                        JLabel sl7 = new JLabel("Score = " +score[0] +"/8");
                                        sl7.setBounds(50,460,120,40);
                                        sl7.setFont(new Font("Arial", Font.BOLD, 17));
                                        sl7.setForeground(Color.WHITE);
                                        nf7.add(sl7);

                                        JButton ibb6 = new JButton("Coffee");
                                        ibb6.setBounds(40,280,100,40);
                                        ibb6.setBackground(Color.BLACK);
                                        ibb6.setForeground(Color.WHITE);
                                        ibb6.setFont(new Font("Arial", Font.PLAIN, 15));
                                        nf7.add(ibb6);

                                        JButton ibs6  = new JButton("Coconut Water");
                                        ibs6.setBounds(40,340,150,40);
                                        ibs6.setBackground(Color.BLACK);
                                        ibs6.setForeground(Color.WHITE);
                                        ibs6.setFont(new Font("Arial", Font.PLAIN, 13));
                                        nf7.add(ibs6);

                                        JButton iba6  = new JButton("Flavour Milkshake");
                                        iba6.setBounds(40,400,170,40);
                                        iba6.setBackground(Color.BLACK);
                                        iba6.setForeground(Color.WHITE);
                                        iba6.setFont(new Font("Arial", Font.PLAIN, 15));
                                        nf7.add(iba6);

                                        ibb6.addActionListener(bbe->{
                                            JOptionPane.showMessageDialog(null,"Wrong Answer");
                                        });

                                        iba6.addActionListener(bee->{
                                            JOptionPane.showMessageDialog(null,"Wrong Answer");
                                        });

                                        nf7.setResizable(false);
                                        nf7.setLocationRelativeTo(null);
                                        nf7.setVisible(true);
                                        nf6.dispose();

                                        ibs6.addActionListener(eb->{
                                            JOptionPane.showMessageDialog(null,"Correct Answer");
                                            score[0]++;
                                            sl7.setText("Score = " +score[0] +"/8");
                                            JFrame rf = new JFrame("Start");
                                            rf.setSize(400,500);
                                            rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            rf.setLayout(null);
                                            rf.getContentPane().setBackground(Color.BLACK);

                                            JLabel rl = new JLabel("Game Over!!");
                                            rl.setBounds(110,30,200,40);
                                            rl.setFont(new Font("Arial", Font.BOLD, 18));
                                            rl.setForeground(Color.WHITE);
                                            rf.add(rl);

                                            JLabel rl1 = new JLabel("Your Score :" +score[0] +" / 8");
                                            rl1.setBounds(100,90,200,40);
                                            rl1.setFont(new Font("Arial", Font.BOLD, 18));
                                            rl1.setForeground(Color.WHITE);
                                            rf.add(rl1);


                                            JLabel rl2 = new JLabel("Tip: Follow Healthy Life Style");
                                            rl2.setBounds(80,170,300,40);
                                            rl2.setFont(new Font("Arial", Font.BOLD, 14));
                                            rl2.setForeground(Color.WHITE);
                                            rf.add(rl2);

                                            JLabel rl3 = new JLabel("Because HEALTH IS WEALTH");
                                            rl3.setBounds(60,220,300,40);
                                            rl3.setFont(new Font("Arial", Font.BOLD, 16));
                                            rl3.setForeground(Color.WHITE);
                                            rf.add(rl3);


                                            JButton rb4 = new JButton("Play Again");
                                            rb4.setBounds(100,300,150,40);
                                            rb4.setBackground(Color.BLACK);
                                            rb4.setForeground(Color.WHITE);
                                            rb4.setFont(new Font("Arial", Font.PLAIN, 17));
                                            rf.add(rb4);

                                            ImageIcon rb5 = new ImageIcon("Thankyou.png");
                                            JLabel rb6 = new JLabel(rb5);
                                            rb6.setBounds(120,330,150,150);
                                            rf.add(rb6);

                                            rf.setResizable(false);
                                            rf.setLocationRelativeTo(null);
                                            rf.setVisible(true);
                                            nf7.dispose();

                                            rb4.addActionListener(rbb->{

                                                gf.setResizable(false);
                                                gf.setLocationRelativeTo(null);
                                                gf.setVisible(true);
                                                rf.dispose();
                                            });

                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });

        JButton back = new JButton("Back");
        back.setBounds(20, 20, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.addActionListener(ev -> {
            Dashboard.main(new String[]{});
            gf.dispose();
        });

        gf.add(back);
        gf.setResizable(false);
        gf.setLocationRelativeTo(null);
        gf.setVisible(true);
    }
}
























//import java.util.*;
//import java.awt.*;
//import javax.swing.*;
//
//public class Game{
//    public static void main(String[] args){
//
//
//        JFrame gf = new JFrame("Game");
//        gf.setSize(400,400);
//        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gf.setLayout(null);
//        gf.getContentPane().setBackground(Color.BLACK);
//
//        //Score ko store karne ka liye
//        int[] score ={0};
//
//
//        ImageIcon icc = new ImageIcon("front.png");
//        JLabel ill = new JLabel(icc);
//        ill.setBounds(120,20,150,150);
//        gf.add(ill);
//
//        ImageIcon icc1 = new ImageIcon("front3.png");
//        JLabel ill1 = new JLabel(icc1);
//        ill1.setBounds(120,220,150,150);
//        gf.add(ill1);
//
//        JLabel gl = new JLabel("Unhealthy Food");
//        gl.setBounds(100,150,200,40);
//        gl.setFont(new Font("Arial", Font.BOLD, 24));
//        gl.setForeground(Color.WHITE);
//        gf.add(gl);
//
//        JButton gb  = new JButton("Start Game");
//        gb.setBounds(120,200,140,40);
//        gb.setBackground(Color.BLACK);
//        gb.setForeground(Color.WHITE);
//        gb.setFont(new Font("Arial", Font.PLAIN, 15));
//        gf.add(gb);
//
//        //question 1
//        gb.addActionListener(e->{
//            JFrame nf = new JFrame("Start");
//            nf.setSize(400,600);
//            nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            nf.setLayout(null);
//            nf.getContentPane().setBackground(Color.BLACK);
//
//            JLabel nl = new JLabel("Swap this Food");
//            nl.setBounds(110,30,200,40);
//            nl.setFont(new Font("Arial", Font.BOLD, 18));
//            nl.setForeground(Color.WHITE);
//            nf.add(nl);
//
//            ImageIcon ic = new ImageIcon("burger.png");
//            JLabel il = new JLabel(ic);
//            il.setBounds(120,70,150,150);
//            nf.add(il);
//
//            JLabel bl = new JLabel("Burger");
//            bl.setBounds(150,220,100,40);
//            bl.setFont(new Font("Arial", Font.BOLD, 20));
//            bl.setForeground(Color.WHITE);
//            nf.add(bl);
//
//            //score label
//            JLabel sl = new JLabel("Score = " +score[0] +"/8");
//            sl.setBounds(50,460,120,40);
//            sl.setFont(new Font("Arial", Font.BOLD, 17));
//            sl.setForeground(Color.WHITE);
//            nf.add(sl);
//
//            JButton ib  = new JButton("Popcorn");
//            ib.setBounds(40,280,100,40);
//            ib.setBackground(Color.BLACK);
//            ib.setForeground(Color.WHITE);
//            ib.setFont(new Font("Arial", Font.PLAIN, 15));
//            nf.add(ib);
//
//            JButton ib1  = new JButton("Fries");
//            ib1.setBounds(40,340,100,40);
//            ib1.setBackground(Color.BLACK);
//            ib1.setForeground(Color.WHITE);
//            ib1.setFont(new Font("Arial", Font.PLAIN, 15));
//            nf.add(ib1);
//
//            JButton ib2  = new JButton("Samosa");
//            ib2.setBounds(40,400,100,40);
//            ib2.setBackground(Color.BLACK);
//            ib2.setForeground(Color.WHITE);
//            ib2.setFont(new Font("Arial", Font.PLAIN, 15));
//            nf.add(ib2);
//
//            ib1.addActionListener(bbe->{
//                JOptionPane.showMessageDialog(null,"Wrong Answer");
//            });
//
//            ib2.addActionListener(bee->{
//                JOptionPane.showMessageDialog(null,"Wrong Answer");
//            });
//
//            nf.setResizable(false);
//            nf.setLocationRelativeTo(null);
//            nf.setVisible(true);
//            gf.dispose();
//
//            //question 2
//            ib.addActionListener(nbb->{
//                JOptionPane.showMessageDialog(null,"Correct Answer");
//                score[0]++;
//                sl.setText("Score = " +score[0] +"/8");
//
//                JFrame nf1 = new JFrame("Start");
//                nf1.setSize(400,600);
//                nf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                nf1.setLayout(null);
//                nf1.getContentPane().setBackground(Color.BLACK);
//
//                JLabel nl1 = new JLabel("Swap this Food");
//                nl1.setBounds(110,30,200,40);
//                nl1.setFont(new Font("Arial", Font.BOLD, 18));
//                nl1.setForeground(Color.WHITE);
//                nf1.add(nl1);
//
//                ImageIcon ic1 = new ImageIcon("nuggets.png");
//                JLabel il1 = new JLabel(ic1);
//                il1.setBounds(120,70,150,150);
//                nf1.add(il1);
//
//                JLabel bl1 = new JLabel("Nuggets");
//                bl1.setBounds(150,220,150,40);
//                bl1.setFont(new Font("Arial", Font.BOLD, 20));
//                bl1.setForeground(Color.WHITE);
//                nf1.add(bl1);
//
//                //score label
//                JLabel sl1 = new JLabel("Score = " +score[0] +"/8");
//                sl1.setBounds(50,460,120,40);
//                sl1.setFont(new Font("Arial", Font.BOLD, 17));
//                sl1.setForeground(Color.WHITE);
//                nf1.add(sl1);
//
//                JButton ibb  = new JButton("Chips");
//                ibb.setBounds(40,280,100,40);
//                ibb.setBackground(Color.BLACK);
//                ibb.setForeground(Color.WHITE);
//                ibb.setFont(new Font("Arial", Font.PLAIN, 15));
//                nf1.add(ibb);
//
//                JButton ibs  = new JButton("Grilled Chicken");
//                ibs.setBounds(40,340,150,40);
//                ibs.setBackground(Color.BLACK);
//                ibs.setForeground(Color.WHITE);
//                ibs.setFont(new Font("Arial", Font.PLAIN, 15));
//                nf1.add(ibs);
//
//                JButton iba  = new JButton("Pakora");
//                iba.setBounds(40,400,100,40);
//                iba.setBackground(Color.BLACK);
//                iba.setForeground(Color.WHITE);
//                iba.setFont(new Font("Arial", Font.PLAIN, 15));
//                nf1.add(iba);
//
//                ibb.addActionListener(bbe->{
//                    JOptionPane.showMessageDialog(null,"Wrong Answer");
//                });
//
//                iba.addActionListener(bee->{
//                    JOptionPane.showMessageDialog(null,"Wrong Answer");
//                });
//
//                nf1.setResizable(false);
//                nf1.setLocationRelativeTo(null);
//                nf1.setVisible(true);
//                nf.dispose();
//
//                //question 3
//                ibs.addActionListener(nbb1->{
//                    JOptionPane.showMessageDialog(null,"Correct Answer");
//                    score[0]++;
//                    sl1.setText("Score = " +score[0] +"/8");
//                    JFrame nf2 = new JFrame("Start");
//                    nf2.setSize(400,600);
//                    nf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    nf2.setLayout(null);
//                    nf2.getContentPane().setBackground(Color.BLACK);
//
//                    JLabel nl2 = new JLabel("Swap this Food");
//                    nl2.setBounds(110,30,200,40);
//                    nl2.setFont(new Font("Arial", Font.BOLD, 18));
//                    nl2.setForeground(Color.WHITE);
//                    nf2.add(nl2);
//
//                    ImageIcon ic2 = new ImageIcon("pizza.png");
//                    JLabel il2 = new JLabel(ic2);
//                    il2.setBounds(120,70,150,150);
//                    nf2.add(il2);
//
//                    JLabel bl2 = new JLabel("Pizza");
//                    bl2.setBounds(150,220,150,40);
//                    bl2.setFont(new Font("Arial", Font.BOLD, 20));
//                    bl2.setForeground(Color.WHITE);
//                    nf2.add(bl2);
//
//                    //score label
//                    JLabel sl2 = new JLabel("Score = " +score[0] +"/8");
//                    sl2.setBounds(50,460,120,40);
//                    sl2.setFont(new Font("Arial", Font.BOLD, 17));
//                    sl2.setForeground(Color.WHITE);
//                    nf2.add(sl2);
//
//                    JButton ibb1  = new JButton("Donut");
//                    ibb1.setBounds(40,280,100,40);
//                    ibb1.setBackground(Color.BLACK);
//                    ibb1.setForeground(Color.WHITE);
//                    ibb1.setFont(new Font("Arial", Font.PLAIN, 15));
//                    nf2.add(ibb1);
//
//                    JButton ibs1  = new JButton("Garlic bread");
//                    ibs1.setBounds(40,340,150,40);
//                    ibs1.setBackground(Color.BLACK);
//                    ibs1.setForeground(Color.WHITE);
//                    ibs1.setFont(new Font("Arial", Font.PLAIN, 15));
//                    nf2.add(ibs1);
//
//                    JButton iba1  = new JButton("Yougurt");
//                    iba1.setBounds(40,400,100,40);
//                    iba1.setBackground(Color.BLACK);
//                    iba1.setForeground(Color.WHITE);
//                    iba1.setFont(new Font("Arial", Font.PLAIN, 15));
//                    nf2.add(iba1);
//
//                    ibb1.addActionListener(bbe->{
//                        JOptionPane.showMessageDialog(null,"Wrong Answer");
//                    });
//
//                    ibs1.addActionListener(bee->{
//                        JOptionPane.showMessageDialog(null,"Wrong Answer");
//                    });
//
//                    nf2.setResizable(false);
//                    nf2.setLocationRelativeTo(null);
//                    nf2.setVisible(true);
//                    nf1.dispose();
//
//                    //question 4
//                    iba1.addActionListener(nbb2->{
//                        JOptionPane.showMessageDialog(null,"Correct Answer");
//                        score[0]++;
//                        sl2.setText("Score = " +score[0] +"/8");
//                        JFrame nf3 = new JFrame("Start");
//                        nf3.setSize(400,600);
//                        nf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        nf3.setLayout(null);
//                        nf3.getContentPane().setBackground(Color.BLACK);
//
//                        JLabel nl3 = new JLabel("Swap this Food");
//                        nl3.setBounds(110,30,200,40);
//                        nl3.setFont(new Font("Arial", Font.BOLD, 18));
//                        nl3.setForeground(Color.WHITE);
//                        nf3.add(nl3);
//
//                        ImageIcon ic3 = new ImageIcon("soda.png");
//                        JLabel il3 = new JLabel(ic3);
//                        il3.setBounds(120,70,150,150);
//                        nf3.add(il3);
//
//                        JLabel bl3 = new JLabel("Soda");
//                        bl3.setBounds(160,220,150,40);
//                        bl3.setFont(new Font("Arial", Font.BOLD, 21));
//                        bl3.setForeground(Color.WHITE);
//                        nf3.add(bl3);
//
//                        //score label
//                        JLabel sl3 = new JLabel("Score = " +score[0] +"/8");
//                        sl3.setBounds(50,460,120,40);
//                        sl3.setFont(new Font("Arial", Font.BOLD, 17));
//                        sl3.setForeground(Color.WHITE);
//                        nf3.add(sl3);
//
//                        JButton ibb2 = new JButton("Pepsi");
//                        ibb2.setBounds(40,280,100,40);
//                        ibb2.setBackground(Color.BLACK);
//                        ibb2.setForeground(Color.WHITE);
//                        ibb2.setFont(new Font("Arial", Font.PLAIN, 15));
//                        nf3.add(ibb2);
//
//                        JButton ibs2  = new JButton("Shake");
//                        ibs2.setBounds(40,340,100,40);
//                        ibs2.setBackground(Color.BLACK);
//                        ibs2.setForeground(Color.WHITE);
//                        ibs2.setFont(new Font("Arial", Font.PLAIN, 15));
//                        nf3.add(ibs2);
//
//                        JButton iba2  = new JButton("Lemonade");
//                        iba2.setBounds(40,400,120,40);
//                        iba2.setBackground(Color.BLACK);
//                        iba2.setForeground(Color.WHITE);
//                        iba2.setFont(new Font("Arial", Font.PLAIN, 15));
//                        nf3.add(iba2);
//
//                        ibb2.addActionListener(bbe->{
//                            JOptionPane.showMessageDialog(null,"Wrong Answer");
//                        });
//
//                        ibs2.addActionListener(bee->{
//                            JOptionPane.showMessageDialog(null,"Wrong Answer");
//                        });
//
//                        nf3.setResizable(false);
//                        nf3.setLocationRelativeTo(null);
//                        nf3.setVisible(true);
//                        nf2.dispose();
//
//
//                        //question 5
//                        iba2.addActionListener(nbb3->{
//                            JOptionPane.showMessageDialog(null,"Correct Answer");
//                            score[0]++;
//                            sl3.setText("Score = " +score[0] +"/8");
//                            JFrame nf4 = new JFrame("Start");
//                            nf4.setSize(400,600);
//                            nf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            nf4.setLayout(null);
//                            nf4.getContentPane().setBackground(Color.BLACK);
//
//                            JLabel nl4 = new JLabel("Swap this Food");
//                            nl4.setBounds(110,30,200,40);
//                            nl4.setFont(new Font("Arial", Font.BOLD, 18));
//                            nl4.setForeground(Color.WHITE);
//                            nf4.add(nl4);
//
//                            ImageIcon ic4 = new ImageIcon("cake.png");
//                            JLabel il4 = new JLabel(ic4);
//                            il4.setBounds(120,70,150,150);
//                            nf4.add(il4);
//
//                            JLabel bl4 = new JLabel("Cake");
//                            bl4.setBounds(160,220,150,40);
//                            bl4.setFont(new Font("Arial", Font.BOLD, 21));
//                            bl4.setForeground(Color.WHITE);
//                            nf4.add(bl4);
//
//                            //score label
//                            JLabel sl4 = new JLabel("Score = " +score[0] +"/8");
//                            sl4.setBounds(50,460,120,40);
//                            sl4.setFont(new Font("Arial", Font.BOLD, 17));
//                            sl4.setForeground(Color.WHITE);
//                            nf4.add(sl4);
//
//                            JButton ibb3 = new JButton("Ice-Cream");
//                            ibb3.setBounds(40,280,120,40);
//                            ibb3.setBackground(Color.BLACK);
//                            ibb3.setForeground(Color.WHITE);
//                            ibb3.setFont(new Font("Arial", Font.PLAIN, 15));
//                            nf4.add(ibb3);
//
//                            JButton ibs3  = new JButton("Brown Bread");
//                            ibs3.setBounds(40,340,150,40);
//                            ibs3.setBackground(Color.BLACK);
//                            ibs3.setForeground(Color.WHITE);
//                            ibs3.setFont(new Font("Arial", Font.PLAIN, 13));
//                            nf4.add(ibs3);
//
//                            JButton iba3  = new JButton("Bread");
//                            iba3.setBounds(40,400,100,40);
//                            iba3.setBackground(Color.BLACK);
//                            iba3.setForeground(Color.WHITE);
//                            iba3.setFont(new Font("Arial", Font.PLAIN, 15));
//                            nf4.add(iba3);
//
//                            ibb3.addActionListener(bbe->{
//                                JOptionPane.showMessageDialog(null,"Wrong Answer");
//                            });
//
//                            iba3.addActionListener(bee->{
//                                JOptionPane.showMessageDialog(null,"Wrong Answer");
//                            });
//
//                            nf4.setResizable(false);
//                            nf4.setLocationRelativeTo(null);
//                            nf4.setVisible(true);
//                            nf3.dispose();
//
//                            //question 6
//                            ibs3.addActionListener(nbb4->{
//                                JOptionPane.showMessageDialog(null,"Correct Answer");
//                                score[0]++;
//                                sl4.setText("Score = " +score[0] +"/8");
//                                JFrame nf5 = new JFrame("Start");
//                                nf5.setSize(400,600);
//                                nf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                nf5.setLayout(null);
//                                nf5.getContentPane().setBackground(Color.BLACK);
//
//                                JLabel nl5 = new JLabel("Swap this Food");
//                                nl5.setBounds(110,30,200,40);
//                                nl5.setFont(new Font("Arial", Font.BOLD, 18));
//                                nl5.setForeground(Color.WHITE);
//                                nf5.add(nl5);
//
//                                ImageIcon ic5 = new ImageIcon("chips.png");
//                                JLabel il5 = new JLabel(ic5);
//                                il5.setBounds(120,70,150,150);
//                                nf5.add(il5);
//
//                                JLabel bl5 = new JLabel("Chips");
//                                bl5.setBounds(160,220,150,40);
//                                bl5.setFont(new Font("Arial", Font.BOLD, 21));
//                                bl5.setForeground(Color.WHITE);
//                                nf5.add(bl5);
//
//                                //score label
//                                JLabel sl5 = new JLabel("Score = " +score[0] +"/8");
//                                sl5.setBounds(50,460,120,40);
//                                sl5.setFont(new Font("Arial", Font.BOLD, 17));
//                                sl5.setForeground(Color.WHITE);
//                                nf5.add(sl5);
//
//                                JButton ibb4 = new JButton("Dark Choclate");
//                                ibb4.setBounds(40,280,150,40);
//                                ibb4.setBackground(Color.BLACK);
//                                ibb4.setForeground(Color.WHITE);
//                                ibb4.setFont(new Font("Arial", Font.PLAIN, 15));
//                                nf5.add(ibb4);
//
//                                JButton ibs4  = new JButton("Pasta");
//                                ibs4.setBounds(40,340,120,40);
//                                ibs4.setBackground(Color.BLACK);
//                                ibs4.setForeground(Color.WHITE);
//                                ibs4.setFont(new Font("Arial", Font.PLAIN, 13));
//                                nf5.add(ibs4);
//
//                                JButton iba4  = new JButton("Roll");
//                                iba4.setBounds(40,400,100,40);
//                                iba4.setBackground(Color.BLACK);
//                                iba4.setForeground(Color.WHITE);
//                                iba4.setFont(new Font("Arial", Font.PLAIN, 15));
//                                nf5.add(iba4);
//
//                                ibs4.addActionListener(bbe->{
//                                    JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                });
//
//                                iba4.addActionListener(bee->{
//                                    JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                });
//
//                                nf5.setResizable(false);
//                                nf5.setLocationRelativeTo(null);
//                                nf5.setVisible(true);
//                                nf4.dispose();
//
//                                //question 7
//                                ibb4.addActionListener(nbb5->{
//                                    JOptionPane.showMessageDialog(null,"Correct Answer");
//                                    score[0]++;
//                                    sl5.setText("Score = " +score[0] +"/8");
//                                    JFrame nf6 = new JFrame("Start");
//                                    nf6.setSize(400,600);
//                                    nf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                    nf6.setLayout(null);
//                                    nf6.getContentPane().setBackground(Color.BLACK);
//
//                                    JLabel nl6 = new JLabel("Swap this Food");
//                                    nl6.setBounds(110,30,200,40);
//                                    nl6.setFont(new Font("Arial", Font.BOLD, 18));
//                                    nl6.setForeground(Color.WHITE);
//                                    nf6.add(nl6);
//
//                                    ImageIcon ic6 = new ImageIcon("pudding.png");
//                                    JLabel il6 = new JLabel(ic6);
//                                    il6.setBounds(120,70,150,150);
//                                    nf6.add(il6);
//
//                                    JLabel bl6 = new JLabel("Pudding");
//                                    bl6.setBounds(150,220,170,40);
//                                    bl6.setFont(new Font("Arial", Font.BOLD, 21));
//                                    bl6.setForeground(Color.WHITE);
//                                    nf6.add(bl6);
//
//                                    //score label
//                                    JLabel sl6 = new JLabel("Score = " +score[0] +"/8");
//                                    sl6.setBounds(50,460,120,40);
//                                    sl6.setFont(new Font("Arial", Font.BOLD, 17));
//                                    sl6.setForeground(Color.WHITE);
//                                    nf6.add(sl6);
//
//                                    JButton ibb5 = new JButton("Ooats");
//                                    ibb5.setBounds(40,280,100,40);
//                                    ibb5.setBackground(Color.BLACK);
//                                    ibb5.setForeground(Color.WHITE);
//                                    ibb5.setFont(new Font("Arial", Font.PLAIN, 15));
//                                    nf6.add(ibb5);
//
//                                    JButton ibs5  = new JButton("Maggi");
//                                    ibs5.setBounds(40,340,120,40);
//                                    ibs5.setBackground(Color.BLACK);
//                                    ibs5.setForeground(Color.WHITE);
//                                    ibs5.setFont(new Font("Arial", Font.PLAIN, 13));
//                                    nf6.add(ibs5);
//
//                                    JButton iba5  = new JButton("Cheesy Sandwich");
//                                    iba5.setBounds(40,400,160,40);
//                                    iba5.setBackground(Color.BLACK);
//                                    iba5.setForeground(Color.WHITE);
//                                    iba5.setFont(new Font("Arial", Font.PLAIN, 15));
//                                    nf6.add(iba5);
//
//                                    ibs5.addActionListener(bbe->{
//                                        JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                    });
//
//                                    iba5.addActionListener(bee->{
//                                        JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                    });
//
//                                    nf6.setResizable(false);
//                                    nf6.setLocationRelativeTo(null);
//                                    nf6.setVisible(true);
//                                    nf5.dispose();
//
//                                    //question 8
//                                    ibb5.addActionListener(nbb6->{
//                                        JOptionPane.showMessageDialog(null,"Correct Answer");
//                                        score[0]++;
//                                        sl6.setText("Score = " +score[0] +"/8");
//                                        JFrame nf7 = new JFrame("Start");
//                                        nf7.setSize(400,600);
//                                        nf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                        nf7.setLayout(null);
//                                        nf7.getContentPane().setBackground(Color.BLACK);
//
//                                        JLabel nl7 = new JLabel("Swap this Food");
//                                        nl7.setBounds(110,30,200,40);
//                                        nl7.setFont(new Font("Arial", Font.BOLD, 18));
//                                        nl7.setForeground(Color.WHITE);
//                                        nf7.add(nl7);
//
//                                        ImageIcon ic7 = new ImageIcon("tea.png");
//                                        JLabel il7 = new JLabel(ic7);
//                                        il7.setBounds(120,70,150,150);
//                                        nf7.add(il7);
//
//                                        JLabel bl7 = new JLabel("Tea");
//                                        bl7.setBounds(150,220,170,40);
//                                        bl7.setFont(new Font("Arial", Font.BOLD, 22));
//                                        bl7.setForeground(Color.WHITE);
//                                        nf7.add(bl7);
//
//                                        //score label
//                                        JLabel sl7 = new JLabel("Score = " +score[0] +"/8");
//                                        sl7.setBounds(50,460,120,40);
//                                        sl7.setFont(new Font("Arial", Font.BOLD, 17));
//                                        sl7.setForeground(Color.WHITE);
//                                        nf7.add(sl7);
//
//                                        JButton ibb6 = new JButton("Coffee");
//                                        ibb6.setBounds(40,280,100,40);
//                                        ibb6.setBackground(Color.BLACK);
//                                        ibb6.setForeground(Color.WHITE);
//                                        ibb6.setFont(new Font("Arial", Font.PLAIN, 15));
//                                        nf7.add(ibb6);
//
//                                        JButton ibs6  = new JButton("Coconut Water");
//                                        ibs6.setBounds(40,340,150,40);
//                                        ibs6.setBackground(Color.BLACK);
//                                        ibs6.setForeground(Color.WHITE);
//                                        ibs6.setFont(new Font("Arial", Font.PLAIN, 13));
//                                        nf7.add(ibs6);
//
//                                        JButton iba6  = new JButton("Flavour Milkshake");
//                                        iba6.setBounds(40,400,170,40);
//                                        iba6.setBackground(Color.BLACK);
//                                        iba6.setForeground(Color.WHITE);
//                                        iba6.setFont(new Font("Arial", Font.PLAIN, 15));
//                                        nf7.add(iba6);
//
//                                        ibb6.addActionListener(bbe->{
//                                            JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                        });
//
//                                        iba6.addActionListener(bee->{
//                                            JOptionPane.showMessageDialog(null,"Wrong Answer");
//                                        });
//
//                                        nf7.setResizable(false);
//                                        nf7.setLocationRelativeTo(null);
//                                        nf7.setVisible(true);
//                                        nf6.dispose();
//
//                                        ibs6.addActionListener(eb->{
//                                            JOptionPane.showMessageDialog(null,"Correct Answer");
//                                            score[0]++;
//                                            sl7.setText("Score = " +score[0] +"/8");
//                                            JFrame rf = new JFrame("Start");
//                                            rf.setSize(400,500);
//                                            rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                            rf.setLayout(null);
//                                            rf.getContentPane().setBackground(Color.BLACK);
//
//                                            JLabel rl = new JLabel("Game Over!!");
//                                            rl.setBounds(110,30,200,40);
//                                            rl.setFont(new Font("Arial", Font.BOLD, 18));
//                                            rl.setForeground(Color.WHITE);
//                                            rf.add(rl);
//
//                                            JLabel rl1 = new JLabel("Your Score :" +score[0] +" / 8");
//                                            rl1.setBounds(100,90,200,40);
//                                            rl1.setFont(new Font("Arial", Font.BOLD, 18));
//                                            rl1.setForeground(Color.WHITE);
//                                            rf.add(rl1);
//
//
//                                            JLabel rl2 = new JLabel("Tip: Follow Healthy Life Style");
//                                            rl2.setBounds(80,170,300,40);
//                                            rl2.setFont(new Font("Arial", Font.BOLD, 14));
//                                            rl2.setForeground(Color.WHITE);
//                                            rf.add(rl2);
//
//                                            JLabel rl3 = new JLabel("Because HEALTH IS WEALTH");
//                                            rl3.setBounds(60,220,300,40);
//                                            rl3.setFont(new Font("Arial", Font.BOLD, 16));
//                                            rl3.setForeground(Color.WHITE);
//                                            rf.add(rl3);
//
//
//                                            JButton rb4 = new JButton("Play Again");
//                                            rb4.setBounds(100,300,150,40);
//                                            rb4.setBackground(Color.BLACK);
//                                            rb4.setForeground(Color.WHITE);
//                                            rb4.setFont(new Font("Arial", Font.PLAIN, 17));
//                                            rf.add(rb4);
//
//                                            ImageIcon rb5 = new ImageIcon("Thankyou.png");
//                                            JLabel rb6 = new JLabel(rb5);
//                                            rb6.setBounds(120,330,150,150);
//                                            rf.add(rb6);
//
//                                            rf.setResizable(false);
//                                            rf.setLocationRelativeTo(null);
//                                            rf.setVisible(true);
//                                            nf7.dispose();
//
//                                            rb4.addActionListener(rbb->{
//
//                                                gf.setResizable(false);
//                                                gf.setLocationRelativeTo(null);
//                                                gf.setVisible(true);
//                                                rf.dispose();
//                                            });
//
//                                        });
//                                    });
//                                });
//                            });
//                        });
//                    });
//                });
//            });
//        });
//
//        gf.setResizable(false);
//        gf.setLocationRelativeTo(null);
//        gf.setVisible(true);
//    }
//}
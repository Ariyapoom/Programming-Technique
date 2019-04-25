import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * MonsterSelect
 */
public class MonsterSelect extends JFrame{

    public MonsterSelect(Player player){
        super("NoNameGame_SelectMonster");
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,3));
        JPanel mon1 = new JPanel();
        JPanel mon2 = new JPanel();
        JPanel mon3 = new JPanel();
        JPanel mon4 = new JPanel();
        JPanel mon5 = new JPanel();
        JPanel mon6 = new JPanel();
        mon1.setLayout(new GridLayout(2,1));
        mon2.setLayout(new GridLayout(2,1));
        mon3.setLayout(new GridLayout(2,1));
        mon4.setLayout(new GridLayout(2,1));
        mon5.setLayout(new GridLayout(2,1));
        mon6.setLayout(new GridLayout(2,1));
        container.add(mon1);
        container.add(mon2);
        container.add(mon3);
        container.add(mon4);
        container.add(mon5);
        container.add(mon6);
        mon1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mon2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mon3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mon4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mon5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mon6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        ImageIcon icon1 =new ImageIcon("greenslime.png");
        ImageIcon icon2 =new ImageIcon("blueslime.png");
        ImageIcon icon3 =new ImageIcon("redslime.png");
        ImageIcon icon4 =new ImageIcon("goldenslime.png");
        ImageIcon icon5 =new ImageIcon("blackslime.png");
        ImageIcon icon6 =new ImageIcon("nekoslime.png");
        JLabel label1 =new JLabel(icon1);
        JLabel label2 =new JLabel(icon2);
        JLabel label3 =new JLabel(icon3);
        JLabel label4 =new JLabel(icon4);
        JLabel label5 =new JLabel(icon5);
        JLabel label6 =new JLabel(icon6);
        mon1.add(label1);
        mon2.add(label2);
        mon3.add(label3);
        mon4.add(label4);
        mon5.add(label5);
        mon6.add(label6);
        JButton button1 =new JButton("GreenSlime Lv.1");
        JButton button2 =new JButton("BlueSlime Lv.5");
        JButton button3 =new JButton("RedSlime LV.10");
        JButton button4 =new JButton("GoldenSlime lv.15");
        JButton button5 =new JButton("BlackBowSlime lv.20");
        JButton button6 =new JButton("NekoSlime lv.25");
        JPanel set1 =new JPanel();
        JPanel set2 =new JPanel();
        JPanel set3 =new JPanel();
        JPanel set4 =new JPanel();
        JPanel set5 =new JPanel();
        JPanel set6 =new JPanel();
        set1.add(button1);
        set2.add(button2);
        set3.add(button3);
        set4.add(button4);
        set5.add(button5);
        set6.add(button6);
        mon1.add(set1);
        mon2.add(set2);
        mon3.add(set3);
        mon4.add(set4);
        mon5.add(set5);
        mon6.add(set6);
        button1.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new GreenSlime());
                dispose();
            }
        });
        button2.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new BlueSlime());
                dispose();
            }
        });
        button3.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new RedSlime());
                dispose();
            }
        });
        button4.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new GoldenSlime());
                dispose();
            }
        });
        button5.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new BlackBowSlime());
                dispose();
            }
        });
        button6.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BattleArena(player, new NekoSlime());
                dispose();
            }
        });

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
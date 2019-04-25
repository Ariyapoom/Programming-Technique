import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PlayerGUI
 */
public class PlayerGUI extends JFrame{

    public PlayerGUI(Player player){
        super("NoNameGame_Main");
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel status = new JPanel();
        status.setLayout(new BoxLayout(status,BoxLayout.Y_AXIS));
        JLabel playerLabel =new JLabel("Name : " + player.getName());
        JLabel playerclass = new JLabel("Class : " + player.getJobClass());
        JLabel playerLV = new JLabel("Level : " + player.getlvl() + "  EXP : " + player.getexp());
        JLabel playerHP = new JLabel("HP : " + player.gethp() + " / " + player.getmaxHp());
        JLabel playerMp = new JLabel("MP : " + player.getMp() + " / " + player.getMaxMp());
        JLabel killCount = new JLabel("Kill Count : " + player.getKillCount());
        status.add(playerLabel);
        status.add(playerclass);
        status.add(playerLV);
        status.add(playerHP);
        status.add(playerMp);
        status.add(killCount);
        JPanel northJPanel = new JPanel();
        northJPanel.setLayout(new GridLayout(1,2));
        northJPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        ImageIcon iconlogo =new ImageIcon("Logo.png");
        JLabel logo = new JLabel(iconlogo);
        northJPanel.add(logo);
        northJPanel.add(status);
        container.add(northJPanel, BorderLayout.NORTH);
        ImageIcon iconcha = new ImageIcon(player.getPic());
        JLabel chaPic = new JLabel(iconcha);
        container.add(chaPic, BorderLayout.CENTER);
        JButton goFight = new JButton("Go Fight");
        JButton bag = new JButton("Bag");
        JButton changeClass =new JButton("Change Class");
        JPanel select = new JPanel();
        select.setLayout(new FlowLayout());
        select.add(goFight);
        select.add(bag);
        select.add(changeClass);
        changeClass.setVisible(false);
        container.add(select,BorderLayout.SOUTH);
        if(player.getlvl()>=10 && player.getJobClass().equals("Novice")){
            changeClass.setVisible(true);
        }
        goFight.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new MonsterSelect(player);
                dispose();
            }
        });
        bag.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new BagGUI(player,1);
                dispose();
            }
        });
        changeClass.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassChangeGUI(player);
                dispose();
            }
        });
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
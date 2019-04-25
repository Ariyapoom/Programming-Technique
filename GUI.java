import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * GUI
 */
public class GUI extends JFrame{
    
    private Player player;
    private Monster monster;
    private String name;
    private JTextField jField;
    MonsterGUI monsterGUI;
    public GUI(String name){
        super("NoNameGame");
        player = new Novice(name);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel playerLabel =new JLabel("Name : " + player.getName());
        JLabel playerclass = new JLabel("Class : " + player.getJobClass());
        JLabel playerLV = new JLabel("Level : " + player.getlvl() + "  EXP : " + player.getexp());
        JLabel playerHP = new JLabel("HP : " + player.gethp() + "/" + player.getmaxHp());
        JLabel playerMp = new JLabel("MP : " + player.getMp() + "/" + player.getMaxMp());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.add(playerLabel);
        panel1.add(playerclass);
        panel1.add(playerLV);
        panel1.add(playerHP);
        panel1.add(playerMp);
        container.add(panel1,BorderLayout.WEST);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));        
        JButton goFight = new JButton("Go fight");
        panel2.add(goFight);
        JButton attack =new JButton("Attack");
        panel2.add(attack);
        attack.setVisible(false);
        JButton skill = new JButton("UseSkill");
        panel2.add(skill);
        skill.setVisible(false);
        JButton bag = new JButton("Bag");
        panel2.add(bag);
        container.add(panel2,BorderLayout.EAST);
        
        goFight.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                monster = new GreenSlime();
                monsterGUI =  new MonsterGUI(monster,player,attack);
                attack.setVisible(true);
                skill.setVisible(true);
                goFight.setVisible(false);
            }
        });
        attack.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if(monster.getHp() <= 0){
                    attack.setVisible(false);
                    skill.setVisible(false);
                    goFight.setVisible(true);
                    monsterGUI.dispose();
                    player.expgain(monster.getExp());
                }
                else{
                    player.dmgToHp(monster.getDmg());
                }
                playerLV.setText("Level : " + player.getlvl() + "  EXP : " + player.getexp());
                playerHP.setText("HP : " + player.gethp() + "/" + player.getmaxHp());
            }
        });
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
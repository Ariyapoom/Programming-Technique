import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * MonsterGUI
 */
public class MonsterGUI extends JFrame{
    JLabel monsterHP;
    Monster monster;
    public MonsterGUI(Monster monster,Player player,JButton attack){
        super(monster.getName());
        this.monster = monster;
        Container container = getContentPane();
        container.setLayout(new GridLayout(1,2));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        container.add(new JLabel("hello"));
        container.add(panel);
        JLabel monsterLabel =new JLabel("Name : " + monster.getName());
        JLabel monsterLV = new JLabel("Level : " + monster.getlvl());
        monsterHP = new JLabel("HP : " + monster.getHp() + "/" + monster.getMaxHp());
        panel.add(monsterLabel);
        panel.add(monsterLV);
        panel.add(monsterHP);
        setLocationRelativeTo(null);
        attack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monster.takingDmg(player.getDmg());
                monsterHP.setText("HP : " + monster.getHp() + "/" + monster.getMaxHp());
            }
        });
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
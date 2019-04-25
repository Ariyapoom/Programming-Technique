import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * BattleArena
 */
public class BattleArena extends JFrame{
    JPanel panel;
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    JLabel playerHP;
    JLabel playerMp;
    JLabel monsterHP;
    JPanel skillPanel;
    Container container;
    public BattleArena(Player player,Monster monster){
        super("NoNameGame_BattleArena");
        container = getContentPane();
        container.setLayout(new GridLayout(3,1));
        JPanel status = new JPanel();
        JPanel pic = new JPanel();
        JPanel select = new JPanel();
        status.setLayout(new GridLayout(1,2));
        pic.setLayout(new GridLayout(1,2));
        select.setLayout(new FlowLayout());
        status.setBorder(BorderFactory.createEmptyBorder(10,50,0,50));
        pic.setBorder(BorderFactory.createEmptyBorder(0,50,10,50));
        select.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel playerstatus =new JPanel();
        playerstatus.setLayout(new BoxLayout(playerstatus, BoxLayout.Y_AXIS));
        JLabel label1 =new JLabel("Player Status");
        JLabel playerLabel =new JLabel("Name : " + player.getName());
        JLabel playerclass = new JLabel("Class : " + player.getJobClass());
        JLabel playerLV = new JLabel("Level : " + player.getlvl() + "  EXP : " + player.getexp());
        playerHP = new JLabel("HP : " + player.gethp() + " / " + player.getmaxHp());
        playerMp = new JLabel("MP : " + player.getMp() + " / " + player.getMaxMp());
        playerstatus.add(label1);
        playerstatus.add(playerLabel);
        playerstatus.add(playerclass);
        playerstatus.add(playerLV);
        playerstatus.add(playerHP);
        playerstatus.add(playerMp);
        status.add(playerstatus);
        JPanel monsterstatus =new JPanel();
        monsterstatus.setLayout(new BoxLayout(monsterstatus, BoxLayout.Y_AXIS));
        JLabel label2 =new JLabel("Monster Status");
        JLabel monsterLabel =new JLabel("Name : " + monster.getName());
        JLabel monsterLV = new JLabel("Level : " + monster.getlvl());
        monsterHP = new JLabel("HP : " + monster.getHp() + " / " + monster.getMaxHp());
        monsterstatus.add(label2);
        monsterstatus.add(monsterLabel);
        monsterstatus.add(monsterLV);
        monsterstatus.add(monsterHP);
        status.add(monsterstatus);
        ImageIcon iconcha = new ImageIcon(player.getPic());
        JLabel chaPic = new JLabel(iconcha);
        pic.add(chaPic);
        ImageIcon monIcon = new ImageIcon(monster.getPic());
        JLabel monpic = new JLabel(monIcon);
        pic.add(monpic);
        JButton attack = new JButton("Attack");
        JButton skill = new JButton("Skill");
        JButton bag = new JButton("Bag");
        JButton run =new JButton("Run");
        JPanel allButton =new JPanel();
        allButton.setLayout(new FlowLayout());
        skillPanel = new JPanel();
        JPanel skilllist = new JPanel();
        skilllist.setLayout(new BoxLayout(skilllist, BoxLayout.Y_AXIS));
        ArrayList<JButton> buttonskill = new ArrayList<JButton>();
        for(int i = 0 ; i < player.getnumberskill() ; i++){
            buttonskill.add(new JButton(player.getSkill(i).getSkillName()+" "+player.getSkill(i).getSkillDamage()+" DMG"));
            skilllist.add(buttonskill.get(i));
            buttonskill.get(i).addActionListener(new SkillUsed(i, player, monster));
        }
        skillPanel.add(skilllist);
        allButton.add(skillPanel);
        skillPanel.setVisible(false);
        select.add(attack);
        select.add(skill);
        select.add(bag);
        select.add(run);
        allButton.add(select);
        Bag bagplayer = player.myBag;
        panel = new JPanel();
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        panel.add(itemPanel);
        for(int i=0 ; i < bagplayer.getNumberItem(); i++){
            buttons.add(new JButton(bagplayer.getItem(i).getItemName()));
            itemPanel.add(buttons.get(i));
            buttons.get(i).addActionListener(new InnerBagGUI(i,player,itemPanel));
        }
        allButton.add(panel);
        panel.setVisible(false);
        container.add(status);
        container.add(pic);
        container.add(allButton);
        attack.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                monster.takingDmg(player.getDmg());
                monsterHP.setText("HP : " + monster.getHp() + " / " + monster.getMaxHp());
                if(monster.getHp() <= 0){
                    player.expgain(monster.getExp());
                    Item itemdrop = monster.DropItem();
                    if(itemdrop != null){
                        player.myBag.addItem(itemdrop);
                    }
                    dispose();
                    new PlayerGUI(player);
                }
                else{
                    player.dmgToHp(monster.getDmg());
                    playerHP.setText("HP : " + player.gethp() + " / " + player.getmaxHp());
                    if(player.isPlayerDie()){
                        player.resurrection();
                        dispose();
                        new PlayerGUI(player);
                    }
                }
            }
        });
        bag.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(panel.isShowing()){
                    panel.setVisible(false);
                }
                else{
                    panel.setVisible(true);
                }
                
            }
        });
        skill.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if(skillPanel.isShowing()){
                    skillPanel.setVisible(false);
                }
                else{
                    skillPanel.setVisible(true);
                }

            }
        });
        run.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PlayerGUI(player);
            }
        });
        setSize(1060,720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public class InnerBagGUI implements ActionListener{
        int i;
        Player player;
        JPanel itemJPanel;
        public InnerBagGUI(int index,Player player,JPanel itemJPanel){
            i = index;
            this.player = player; 
            this.itemJPanel = itemJPanel;
        }
        
        public void actionPerformed(ActionEvent e){
            player.usePotion(player.myBag.getItem(0));
            player.myBag.removeItem(0); 
            panel.setVisible(false);
            itemJPanel.remove(0);
            playerHP.setText("HP : " + player.gethp() + " / " + player.getmaxHp());
            playerMp.setText("MP : " + player.getMp() + " / " + player.getMaxMp());
        }
    }

    public class SkillUsed implements ActionListener{
        int i;
        Player player;
        Monster monster;
        public SkillUsed(int index,Player player,Monster monster){
            i = index;
            this.player = player; 
            this.monster = monster;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(player.getMp() >= player.getSkill(i).getSkillMpUse()){
                monster.takingDmg(player.getSkill(i).getSkillDamage());
                player.useMp(player.getSkill(i).getSkillMpUse());
                playerMp.setText("MP : " + player.getMp() + " / " + player.getMaxMp());
                monsterHP.setText("HP : " + monster.getHp() + " / " + monster.getMaxHp());
                if(monster.getHp() <= 0){
                    player.expgain(monster.getExp());
                    Item itemdrop = monster.DropItem();
                    if(itemdrop != null){
                        player.myBag.addItem(itemdrop);
                    }
                    dispose();
                    new PlayerGUI(player);
                }
                else{
                    player.dmgToHp(monster.getDmg());
                    playerHP.setText("HP : " + player.gethp() + " / " + player.getmaxHp());
                
                    if(player.isPlayerDie()){
                        player.resurrection();
                        dispose();
                        new PlayerGUI(player);
                    }
                    skillPanel.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(container, "Not Enough Mana");
            }
        }
    }

}
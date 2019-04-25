import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ClassChangeGUI
 */
public class ClassChangeGUI extends JFrame{
    Player player;
    public ClassChangeGUI(Player player){
        super("NoNameGame_ChangeClass");
        this.player = player;
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,1));
        JPanel p1 = new JPanel();
        container.add(p1);
        JPanel classPic =new JPanel();
        classPic.setLayout(new GridLayout(1,2));
        ImageIcon swordmanPic = new ImageIcon("SwordmanPic2.png");
        JLabel swordmanLabel = new JLabel(swordmanPic);
        classPic.add(swordmanLabel);
        ImageIcon magicianPic = new ImageIcon("MagicianPic.png");
        JLabel magicianLabel = new JLabel(magicianPic);
        classPic.add(magicianLabel);
        p1.add(classPic);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));
        JPanel picClass =new JPanel();
        p2.add(picClass);
        JPanel classButton = new JPanel();
        classButton.setLayout(new GridLayout(1,2));
        JPanel swordmanPanel = new JPanel();
        JButton swordmanButton =new JButton("Change To SwordMan");
        swordmanPanel.add(swordmanButton);
        JPanel magicianPanel = new JPanel();
        JButton magicianButton = new JButton("Change To Magician");
        magicianPanel.add(magicianButton);
        classButton.add(swordmanPanel);
        classButton.add(magicianPanel);
        p2.add(classButton);
        container.add(p2);
        swordmanButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerGUI(new SwordMan(player));
                dispose();
            }
        });
        magicianButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerGUI(new Magician(player));
                dispose();
            }
        });
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
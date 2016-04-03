/**
 *  Class MLInterface
 *
 *  Console interface, might evolve into a GUI.
 *
 *  @author Jules Pénuchot
 */

package human_interface;

import image.ImageDB;
import image.ImageDisplay;
import io.CSVContiguous;
import io.IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Vector;

public class MLInterface extends JFrame{
    private JFileChooser file_chooser;
    private JTextField path_text;
    private JButton path_choose;
    private JButton stat;
    private JButton display;
    private File fichier;
    private ImageDB imgdb;

    public MLInterface(int width,int height){
        setTitle("Image loader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0,0));
        initComponent();
        setVisible(true);
        setResizable(false);
    }

    private void initComponent(){
        JPanel top_panel = new JPanel();
        file_chooser = new JFileChooser();
        stat = new JButton("Afficher les stats");
        display = new JButton("Afficher l'image");

        path_text = new JTextField("Select a file");
        path_text.setEditable(false);
        path_text.setPreferredSize(new Dimension(300,18));
        path_choose = new JButton("...");
        path_choose.setPreferredSize(new Dimension(30,18));

        //Action Listener
        path_choose.addActionListener(e -> {
            file_chooser.showOpenDialog(path_choose);
            if (file_chooser.getSelectedFile() != null) {
                try {
                    fichier = file_chooser.getSelectedFile();
                    path_text.setText(fichier.getAbsolutePath());
                    IO imLoader = new CSVContiguous();
                    imgdb = imLoader.readDB(fichier.getAbsolutePath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        stat.addActionListener(e -> {
            if (imgdb != null) {
                StatInterface si = new StatInterface(imgdb);
            }
        });

        display.addActionListener(e -> {
            if (imgdb != null) {
                ChooseNumberImage cni = new ChooseNumberImage(imgdb);
            }
        });

        // Add to Frame and Panel
        top_panel.add(path_text, BorderLayout.WEST);
        top_panel.add(path_choose, BorderLayout.EAST);
        add(top_panel, BorderLayout.NORTH);
        add(display,BorderLayout.WEST);
        add(stat,BorderLayout.EAST);
        pack();
    }

}

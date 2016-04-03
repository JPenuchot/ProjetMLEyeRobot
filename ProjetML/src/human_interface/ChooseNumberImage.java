package human_interface;

import image.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ChooseNumberImage extends JFrame {
    private JComboBox comboBox;
    private ImageDB imgs;
    private JButton show_picture;

    ChooseNumberImage(ImageDB imgdb){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        imgs = imgdb;
        setTitle("Select image number");
        initComponent();
        setVisible(true);
        setResizable(false);
    }

    private void initComponent(){
        Vector<Integer> v = new Vector<>();
        for (int i = 0 ; i < imgs.size(); i++) v.add(i);
        comboBox = new JComboBox(new DefaultComboBoxModel<>(v));

        show_picture = new JButton("Show picture");
        show_picture.addActionListener(e -> {
            ImageDisplay id = new ImageDisplay(imgs.get((Integer) comboBox.getSelectedItem()));
            id.setVisible(true);
        });

        add(new JLabel("Select number of picture :"), BorderLayout.WEST);
        add(comboBox, BorderLayout.EAST);
        add(show_picture, BorderLayout.SOUTH);
        pack();
    }
}

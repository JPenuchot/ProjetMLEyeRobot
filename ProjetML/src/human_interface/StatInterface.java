package human_interface;

import image.*;
import statistics.DBStats;

import javax.swing.*;
import java.awt.*;

public class StatInterface extends JFrame {
    private ImageDB img;
    private JLabel sparsity;
    private JLabel lblEffectives;
    private JButton close;

    public StatInterface(ImageDB img){
        this.img = img;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponent();
        setVisible(true);
    }

    private void initComponent(){
        close = new JButton("Close");
        close.addActionListener(e -> dispose());
        sparsity = new JLabel("Sparsity : " + DBStats.sparsity(img));
        lblEffectives = new JLabel("Effectives : ");
        int[] iEffective = DBStats.labelEffectives(img);
        for (int anIEffective : iEffective) lblEffectives.setText(lblEffectives.getText() + anIEffective + " ");
        add(sparsity, BorderLayout.NORTH);
        add(lblEffectives, BorderLayout.CENTER);
        add(close, BorderLayout.SOUTH);
        pack();
    }
}

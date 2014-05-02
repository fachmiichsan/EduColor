/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educolor.educolor;

import org.jhotdraw.draw.tool.DelegationSelectionTool; //Memanggil agar bisa drag atau selection tool
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 *
 * @author Maghfirandy
 */
public class TestJhot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(initApp());

    }

    public static Runnable initApp() {
        return new Runnable() {

            @Override
            public void run() {
                GraphicalCompositeFigure comp = new GraphicalCompositeFigure(); // Buat Figure

                Drawing drawing = new DefaultDrawing(); // Buat Canvas
                drawing.add(comp);

                comp.add(new TextFigure("Hello Guys")); // Menulis Text di Canvas


                // Buat Frame

                JFrame f = new JFrame("JhotTesOOT");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(500, 500);
                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.getContentPane().add(view.getComponent());
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);
                editor.setTool(new DelegationSelectionTool());
                f.setVisible(true);
            }
        };

    }
}

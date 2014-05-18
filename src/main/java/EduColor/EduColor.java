package EduColor;

import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.util.*;
import static org.jhotdraw.draw.AttributeKeys.*;


public class EduColor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

                
                DrawingView view = new DefaultDrawingView();
                DefaultDrawing drawing = new DefaultDrawing();
                drawing.addInputFormat(new SerializationInputOutputFormat());
                drawing.addOutputFormat(new SerializationInputOutputFormat());
                GraphicalCompositeFigure comp = new GraphicalCompositeFigure();
                 GraphicalCompositeFigure comp1 = new GraphicalCompositeFigure();
                 GraphicalCompositeFigure comp2 = new GraphicalCompositeFigure();
                view.setDrawing(drawing);
                drawing.add(comp);
                drawing.add(comp1);
                drawing.add(comp2);
                comp.add(new TextFigure("Kotak Biru"));
                comp1.add(new TextFigure("Diamond Kuning"));
                comp2.add(new TextFigure("Segitiga Abu"));

                
                DrawingEditor editor = new DefaultDrawingEditor(); //Membuat Drawing editor
                editor.add(view);

                
                JToolBar tb = new JToolBar(); //Membuat Toolbar

             
                ButtonFactory.addSelectionToolTo(tb, editor);   //Menambahkan selection tool


             

                // Add a creation tool for green rectangles to the toolbar.
                HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
                HashMap<AttributeKey, Object> b = new HashMap<AttributeKey, Object>();
                 HashMap<AttributeKey, Object> c = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(a, Color.BLUE);
                FILL_COLOR.put(b, Color.YELLOW);
                FILL_COLOR.put(c, Color.LIGHT_GRAY);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure(), a),
                        "edit.createRectangle",
                        labels);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new DiamondFigure(), b),
                        "edit.createDiamond",
                        labels);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure(), c),
                        "edit.createTriangle",
                        labels);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextAreaFigure()),
                        "edit.createText",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);

                // Put all together into a JFrame
                JFrame f = new JFrame("Tugas Besar RPL OOT");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(600, 600);

                // Set up the content pane
                // Place the toolbar on the left
                f.getContentPane().add(tb, BorderLayout.WEST);

                // Place the drawing view inside a scroll pane in the center
                JScrollPane sp = new JScrollPane(view.getComponent());
                sp.setPreferredSize(new Dimension(200, 200));
                f.getContentPane().add(sp, BorderLayout.CENTER);

                f.setVisible(true);
            }
        });
    }
}

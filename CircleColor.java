import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleColor extends JFrame {

    private Color circleColor = Color.WHITE; // Circle color set to white

    public CircleColor() {  // Set the title and size of the application window
        setTitle("Circle Color Change");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 50;
                g.setColor(circleColor);  // Set the color of the circle and draw it
                g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Changes circle color to black when mouse button is pressed
                circleColor = Color.BLACK;
                panel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Changes circle color back to white when mouse button is released
                circleColor = Color.WHITE;
                panel.repaint();
            }
        });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CircleColor app = new CircleColor();
            app.setVisible(true);
        });
    }
}

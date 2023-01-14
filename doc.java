import javax.swing.*;
import java.awt.*;

public class doc extends JFrame{

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    private JButton cancelButton;
    private JButton okButton;

    public static void main(String[] args) {
        doc frame = new doc();
        frame.setVisible(true);
    }

    public doc(){
        Container contentPane = getContentPane();

        //set the frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle("Program Doc");
        setLocation(FRAME_X_ORIGIN,FRAME_Y_ORIGIN);

        //set the layout manager
        contentPane.setLayout(new FlowLayout());

        //create anf place two button on the frame content pane
        okButton = new JButton("OK");
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        contentPane.add(cancelButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}

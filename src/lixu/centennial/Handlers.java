package lixu.centennial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Thinkpad on 6/27/2015.
 */
public class Handlers extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel contentPanel;
    private JTextField dispalyTextField;
    private JRadioButton plainFontRadioButton;
    private JRadioButton boldFontRadioButton;
    private JRadioButton italicFontRadioButton;
    private JCheckBox boldCheckBox;
    private JComboBox colorsComboBox;
    private JCheckBox italicCheckBox;
    private JList leftList;
    private JScrollPane leftScrollpane;
    private JButton copyToRightButton;
    private JList rightList;
    private JScrollPane rightScrollPane;
    private JTextArea distextArea;
    //set radio button to be one group
    private final ButtonGroup radioButtonGroup = new ButtonGroup();
//    //declare a color array variable
//    private static final String colors[] = {
//        "RED", "GREEN", "BLUE"
//    };
    //declare copy string list
    private final String copyList[] = {
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
    };


    //constructor
    public Handlers() {
        super("Handlers and keyListeners");
        //set radio button to be one group
        radioButtonGroup.add(plainFontRadioButton);
        radioButtonGroup.add(boldFontRadioButton);
        radioButtonGroup.add(italicFontRadioButton);

        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        plainFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                dispalyTextField.setText("Plain Font");
                dispalyTextField.setFont(new Font("PLAINFont",Font.PLAIN,12));
                rightList.setFont(new Font("PLAINFont",Font.PLAIN,12));
            }
        });
        boldFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                dispalyTextField.setText("Bold Font");
                dispalyTextField.setFont(new Font("BoldFont",Font.BOLD,12));
                rightList.setFont(new Font("BoldFont",Font.BOLD,12));
            }
        });
        italicFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                dispalyTextField.setText("Italic Font");
                dispalyTextField.setFont(new Font("ItalicFont",Font.ITALIC,12));
                rightList.setFont(new Font("ItalicFont",Font.ITALIC,12));
            }
        });
        boldCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                dispalyTextField.setText("Bold Font CheckBox");
                dispalyTextField.setFont(new Font("BoldCheckBox",Font.BOLD,12));
                rightList.setFont(new Font("Bold",Font.BOLD,12));
            }
        });
        italicCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                dispalyTextField.setText("Italic Font CheckBox");
                dispalyTextField.setFont(new Font("ItalicCheckBox",Font.ITALIC,12));
                rightList.setFont(new Font("Italic",Font.ITALIC,12));
            }
        });
        colorsComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                //dispalyTextField.setText(colors[colorsComboBox.getSelectedIndex()]);
                dispalyTextField.setFont(new Font("ItalicCheckBox", Font.BOLD, 12));
                //set selected font color
                dispalyTextField.setSelectedTextColor(Color.orange);
                //set font color
                if (colorsComboBox.getSelectedIndex()==0) {
                    dispalyTextField.setForeground(Color.RED);
                    rightList.setForeground(Color.RED);
                }
                else if (colorsComboBox.getSelectedIndex()==1) {
                    dispalyTextField.setForeground(Color.green);
                    rightList.setForeground(Color.green);
                }
                else {
                    dispalyTextField.setForeground(Color.blue);
                    rightList.setForeground(Color.blue);
                }
            }
        });
        copyToRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispalyTextField.setText("\"Copy Button\" pressed");
                rightList.setListData(leftList.getSelectedValuesList().toArray(new String[0]));

                //set font of right list
                if (italicFontRadioButton.isSelected()==true) {
                    rightList.setFont(new Font("Italic", Font.ITALIC, 14));
                }
                else if (plainFontRadioButton.isSelected()) {
                    rightList.setFont(new Font("Plain", Font.PLAIN, 22));
                }
                else {
                    rightList.setFont(new Font("Plain", Font.BOLD, 12));
                }
            }
        });

        //mouse handler area
        MouseHandler mouseHandler = new MouseHandler();
        mainPanel.addMouseListener(mouseHandler);
        mainPanel.addMouseMotionListener(mouseHandler);
        copyToRightButton.addMouseListener(mouseHandler);
        copyToRightButton.addMouseMotionListener(mouseHandler);

    }

    //class MouseHandler
    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseClicked at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mousePressed at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseReleased at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseEntered at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseExited at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseDragged at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            distextArea.setText(String.format("mouseMoved at [ %d, %d ]",mouseEvent.getX(),mouseEvent.getY()));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Handlers");
        frame.setContentPane(new Handlers().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

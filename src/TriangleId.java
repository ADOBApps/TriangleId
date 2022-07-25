/**
 *
 * date: 24/07/2022
 * @author [Acxel Orozco (ADOB Apps)]
 * 
 */

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.*;

//re-use our class made at CheckMake
import mycontrollers.MyVerifier;

class TriangleId implements ActionListener{

    Border btitle1, btitle2;
    Container contentPane;
    GridBagConstraints gbctts;
    JButton jb_calc, jb_type;
    JFrame frame1;
    JLabel jl_part1, jl_part2, jl_part3;
    JLabel jl_area, jl_type;
    JPanel jp_info, jp_control, jp_result;
    JTextField jtf_part1, jtf_part2, jtf_part3;

    public TriangleId(){
        btitle1 = BorderFactory.createTitledBorder("Dimensiones del triangulo");
        btitle2 = BorderFactory.createTitledBorder("Info del triangulo");
        gbctts = new GridBagConstraints();

        jb_calc = new JButton("Area");
        jb_calc.addActionListener(this);
        jb_type = new JButton("Tipo");
        jb_type.addActionListener(this);

        frame1 = new JFrame();
        frame1.setTitle("TriangleId");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = frame1.getContentPane();

        jl_part1 = new JLabel();
        jl_part1.setText("Longitud del lado A");
        jl_part2 = new JLabel();
        jl_part2.setText("Longitud del lado B");
        jl_part3 = new JLabel();
        jl_part3.setText("Longitud del lado C");

        jl_area = new JLabel();
        jl_area.setText("Area del triangulo: ");

        jl_type = new JLabel();
        jl_type.setText("Tipo de triangulo: ");

        jp_info = new JPanel();
        jp_info.setLayout(new GridBagLayout());
        jp_info.setBorder(btitle1); //set bordertitle

        jp_result = new JPanel();
        jp_result.setLayout(new GridBagLayout());
        jp_result.setBorder(btitle2); //set bordertitle

        jp_control = new JPanel();

        jtf_part1 = new JTextField(10);
        jtf_part1.setInputVerifier(new MyVerifier());
        jtf_part2 = new JTextField(10);
        jtf_part2.setInputVerifier(new MyVerifier());
        jtf_part3 = new JTextField(10);
        jtf_part3.setInputVerifier(new MyVerifier());

        makeGraph();
    }

    public static void main(String arg[]){
        System.out.println("test");
        TriangleId ti = new TriangleId();
    }

    public void makeGraph(){
        //length A
        gbctts.gridx=0;//column
        gbctts.gridy=0;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jl_part1, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore

        gbctts.gridx=0;//column
        gbctts.gridy=1;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jtf_part1, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore
        
        //length B
        gbctts.gridx=3;//column
        gbctts.gridy=0;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jl_part2, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore

        gbctts.gridx=3;//column
        gbctts.gridy=1;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jtf_part2, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore

        //length C
        gbctts.gridx=5;//column
        gbctts.gridy=0;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jl_part3, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore

        gbctts.gridx=5;//column
        gbctts.gridy=1;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        gbctts.weightx=2.0;
        gbctts.fill = GridBagConstraints.HORIZONTAL; //expand
        jp_info.add(jtf_part3, gbctts);
        gbctts.fill = GridBagConstraints.NONE; //restore
        gbctts.weightx=1.0; //restore

        //Labels to panel result
        gbctts.gridx=0;//column
        gbctts.gridy=0;//row
        gbctts.gridwidth=1;
        gbctts.gridheight=1;
        jp_result.add(jl_type, gbctts);
        gbctts.gridx=0;//column
        gbctts.gridy=1;//row
        gbctts.gridwidth=2;
        gbctts.gridheight=1;
        jp_result.add(jl_area, gbctts);

        //Buttons to panel control
        jp_control.add(jb_type);
        jp_control.add(jb_calc);

        contentPane.add(jp_info, BorderLayout.NORTH);
        contentPane.add(jp_result, BorderLayout.CENTER);
        contentPane.add(jp_control, BorderLayout.SOUTH);
        frame1.pack(); //adaptable content size
        //frame1.setSize(600, 300);
        frame1.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == jb_calc){
            System.out.println("Calculando");
        } else if ( ae.getSource() == jb_type ){
            System.out.println("Tipo de triangulo");
        }
    }

}

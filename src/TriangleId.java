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
	JLabel jl_area, jl_type, jl_angles;
	JPanel jp_info, jp_control, jp_result;
	JTextField jtf_part1, jtf_part2, jtf_part3;
	double a, b, c, p, sp, area;
	double degrees, radians, radiansAux;
	double a_cos, b_cos, c_cos;
	int type_tri;

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
		jl_part1.setText("Longitud del lado A (cm)  ");
		jl_part2 = new JLabel();
		jl_part2.setText("Longitud del lado B (cm)  ");
		jl_part3 = new JLabel();
		jl_part3.setText("Longitud del lado C (cm)  ");

		jl_area = new JLabel();
		jl_area.setText("Area del triangulo: ");

		jl_type = new JLabel();
		jl_type.setText("Tipo de triangulo: ");

		jl_angles = new JLabel();
		jl_angles.setText("Angulos: ");

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
		a = 1.0;
		b = 1.0;
		c = 1.0;
		p = 0.0;
		sp = 0.0;
		area = 0.0;
		type_tri = 0;

		makeGraph();
	}

	public static void main(String arg[]){
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
		gbctts.gridwidth=1;
		gbctts.gridheight=2;
		gbctts.weighty=2.0;
		jp_result.add(jl_angles, gbctts);
		gbctts.weighty=1.0;//restore

		gbctts.gridx=0;//column
		gbctts.gridy=3;//row
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
		if(ae.getSource() == jb_calc){
			a = Double.parseDouble(jtf_part1.getText()); //get A-length
			b = Double.parseDouble(jtf_part2.getText()); //get B-length
			c = Double.parseDouble(jtf_part3.getText()); //get C-length
			//Perimeter
			p = a+b+c;
			//Calculate area using perimeter and length
			sp = (p/2);
			//Also round
			area = Math.round( Math.sqrt(sp*(sp-a)*(sp-b)*(sp-c)) );

			//Verify if float is number
			if(Double.isNaN(area)){
				jl_area.setText("El area no pudo ser calculada");
			} else {
				jl_area.setText("Area del triangulo: "+((String)Double.toString(area))+" cm^2");
				System.out.println( ((String)Double.toString(area)) );
			}
		}
		else if ( ae.getSource() == jb_type ){
			a = Double.parseDouble(jtf_part1.getText()); //get A-length
			b = Double.parseDouble(jtf_part2.getText()); //get B-length
			c = Double.parseDouble(jtf_part3.getText()); //get C-length

			//case equilatero
			if( a == b && a == c){
				jl_type.setText("Tipo de triangulo: equilatero");
				System.out.println("Tipo de triangulo: equilatero");
				type_tri = 1;
			} 
			//case isósceles
			else if( (a == b || a == c || b == c) ){
				System.out.println("Tipo de triangulo: isosceles");
				jl_type.setText("Tipo de triangulo: isosceles");
				type_tri = 2;
			}
			//case escaleno
			else if( a != b && a != c && b != c){
				System.out.println("Tipo de triangulo: escaleno");
				jl_type.setText("Tipo de triangulo: escaleno");
				type_tri = 3;
			}

			switch(type_tri){
				//case equilatero
				case 1:
					jl_angles.setText("A = B = C = 60 grados");
				break;

				//case isósceles
				case 2:
					if( a == b ){
						//C value by cosin lay
						c_cos = ((a*a)+(b*b)-(c*c))/(2*a*b);
						//angle in radians
						radiansAux = Math.acos(c_cos);
						//radians to degree and round
						degrees = Math.round( Math.toDegrees(radiansAux) );
						//Force string conversion
						String s_c = ((String)Double.toString(degrees));
						String s_ab = ((String)Double.toString( (180-degrees)/2 ));
						jl_angles.setText("Angulos: C=" +s_c+ " grados, A = B = "+s_ab+" grados");
					}
					else if( a == c ){
						//B value by cosin lay
						b_cos = ((a*a)+(c*c)-(b*b))/(2*a*c);
						//angle in radians
						radiansAux = Math.acos(b_cos);
						//radians to degree and round
						degrees = Math.round( Math.toDegrees(radiansAux) );
						//Force string conversion
						String s_b = ((String)Double.toString(degrees));
						String s_ac = ((String)Double.toString( (180-degrees)/2 ));
						jl_angles.setText("Angulos: B=" +s_b+ " grados, A=C="+s_ac+" grados");
					}
					else if( c == b ){
						//A value by cosin lay
						a_cos = ((b*b)+(c*c)-(a*a))/(2*b*c);
						//angle in radians
						radiansAux = Math.acos(a_cos);
						//radians to degree and round
						degrees = Math.round( Math.toDegrees(radiansAux) );
						//Force string conversion
						String s_a = ((String)Double.toString(degrees));
						String s_bc = ((String)Double.toString( (180-degrees)/2 ));
						jl_angles.setText("Angulos: A=" +s_a+ " grados, B=C="+s_bc+" grados");
					}
				break;

				//case escaleno
				case 3:
					//A value by cosin lay
					a_cos = ((b*b)+(c*c)-(a*a))/(2*b*c);
					//B value by cosin lay
					b_cos = ((a*a)+(c*c)-(b*b))/(2*a*c);
					//C value by cosin lay
					c_cos = ((a*a)+(b*b)-(c*c))/(2*a*b);

					//radians to degree and round
					double degrees_a = Math.round( Math.toDegrees(Math.acos(a_cos)) );
					double degrees_b = Math.round( Math.toDegrees(Math.acos(b_cos)) );
					double degrees_c = Math.round( Math.toDegrees(Math.acos(c_cos)) );

					//Force string conversion
					String s_a = ((String)Double.toString(degrees_a));
					String s_b = ((String)Double.toString(degrees_b));
					String s_c = ((String)Double.toString(degrees_c));
					jl_angles.setText("Angulos: A="+s_a+" grados, B="+s_b+" grados, C="+s_c+" grados");

				break;

				default:
					jl_angles.setText("No se pudieron calcular los angulos");
				break; 
			}
		}
	}

}

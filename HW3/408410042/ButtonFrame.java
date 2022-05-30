import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import java.text.DecimalFormat;
import java.lang.*;

public class ButtonFrame extends JFrame implements KeyListener{
	private JButton[] plainJButton;
	private JTextArea textArea;
	public ButtonFrame(){
		super("typing tutor");
		textArea = new JTextArea(5,60);
		textArea.setText("");
		textArea.setDisabledTextColor(Color.black);
		add(textArea);
		plainJButton = new JButton[1024];
		setLayout(new FlowLayout());
		
		btn(192,"~");
		btn(49,"1");
		btn(50,"2");
		btn(51,"3");
		btn(52,"4");
		btn(53,"5");
		btn(54,"6");
		btn(55,"7");
		btn(56,"8");
		btn(57,"9");
		btn(48,"0");
		btn(45,"-");
		btn(61,"+");
		btn(8,"backspace");
		btn(1023,"tab");
		btn(81,"Q");
		btn(87,"W");
		btn(69,"E");
		btn(82,"R");
		btn(84,"T");
		btn(89,"Y");
		btn(85,"U");
		btn(73,"I");
		btn(79,"O");
		btn(80,"P");
		btn(91,"[");
		btn(93,"]");
		btn(92,"\\");
		btn(20,"caps lock");
		btn(65,"A");
		btn(83,"S");
		btn(68,"D");
		btn(70,"F");
		btn(71,"G");
		btn(72,"H");
		btn(74,"J");
		btn(75,"K");
		btn(76,"L");
		btn(59,";");
		btn(222,"'");
		btn(10,"enter");
		btn(16,"shift");
		btn(90,"Z");
		btn(88,"X");
		btn(67,"C");
		btn(86,"V");
		btn(66,"B");
		btn(78,"N");
		btn(77,"M");
		btn(44,"<");
		btn(46,">");
		btn(47,"?");
		btn(32,"        space        ");
		btn(38,"↑");
		btn(37,"←");
		btn(40,"↓");
		btn(39,"→");
		//plainJButton[77].setBackground(Color.white);
		this.addKeyListener(this);
		this.setFocusable(true);
		//this.requestFocusInWindow();
	}
	@Override
	public void keyPressed(KeyEvent event){
		int i = event.getKeyCode();
		//System.out.println(i);
		plainJButton[i].setBackground(Color.pink);
		plainJButton[i].setForeground(Color.pink);
		
		if((event.getKeyCode()>=48 && event.getKeyCode()<=57) || (event.getKeyCode()>=65 && event.getKeyCode()<=90) || event.getKeyCode()==44 || event.getKeyCode()==46 || event.getKeyCode()==47 || event.getKeyCode()==59 || event.getKeyCode()==222 || event.getKeyCode()==45 || event.getKeyCode()==64 || event.getKeyCode()==91 || event.getKeyCode()==93 || event.getKeyCode()==92 || event.getKeyCode()==32 || event.getKeyCode()==192){
			textArea.setText(textArea.getText()+ (char)event.getKeyCode());
		}
		else if (event.getKeyCode()==8){
			if(textArea.getText().length() != 0) textArea.setText(textArea.getText().substring(0,textArea.getText().length()-1));
		}
	}
	@Override
	public void keyReleased(KeyEvent event){
	
		plainJButton[event.getKeyCode()].setBackground(Color.white);
		plainJButton[event.getKeyCode()].setForeground(Color.black);
	}
	@Override
	public void keyTyped(KeyEvent event){
		
	}
	
	public void btn(int x,String str){
		plainJButton[x]=new JButton(str);
		plainJButton[x].setBackground(Color.black);
		if(x==32){
			plainJButton[32].setBounds(0,0,350,35);
		}
		//plainJButton[x].setOpaque(true);
		plainJButton[x].setEnabled(false);
		//plainJButton[x].setBorderPainted(false);
		add(plainJButton[x]);
	}
	
}


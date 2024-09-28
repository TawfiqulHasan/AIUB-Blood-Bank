import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contribution extends JFrame implements ActionListener
{
	private JPanel panel;
    private ImageIcon icon, image;
	private JLabel imgLabel, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
    private Font f1,f2,f3,f4,f5,f6,f7,f8,f9;
    private JButton btn1,btn2,btn3;
    private Color color1,color2,color3,color4,color5,color6,color7,color8,color9;
	
    public Contribution()
    {
        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(700, 633);//W,H
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
		
				
	lb2=new JLabel("TAWFIQUL HASAN");
	lb2.setBounds(50,220,180,30);
	color1 = new Color (0,128,0);
	lb2.setForeground(color1);
	lb2.setBackground(Color.WHITE);
	f2 = new Font("Cambria",Font.BOLD, 20); 
	lb2.setFont(f2);
	lb2.setOpaque(true);
	panel.add(lb2);
	
				
	lb3=new JLabel("ID: 23-54422-23");
	lb3.setBounds(50,250,180,30);
	color2 = new Color (0,128,0);
	lb3.setForeground(color2);
	lb3.setBackground(Color.WHITE);
	f3 = new Font("Cambria",Font.BOLD, 20); 
	lb3.setFont(f3);
	lb3.setOpaque(true);
	panel.add(lb3);
	
				
	lb4=new JLabel("MD MOBARAK HOSSAIN ");
	lb4.setBounds(440,220,180,30);
	color3 = new Color (0,128,0);
	lb4.setForeground(color3);
	lb4.setBackground(Color.WHITE);
	f4 = new Font("Cambria",Font.BOLD, 16); 
	lb4.setFont(f4);
	lb4.setOpaque(true);
	panel.add(lb4);
	
				
	lb5=new JLabel("ID: 23-54427-3 ");
	lb5.setBounds(440,250,180,30);
	color4 = new Color (0,128,0);
	lb5.setForeground(color4);
	lb5.setBackground(Color.WHITE);
	f5 = new Font("Cambria",Font.BOLD, 20); 
	lb5.setFont(f5);
	lb5.setOpaque(true);
	panel.add(lb5);
	
				
	lb6=new JLabel("ISTIAK AHMED EMON");
	lb6.setBounds(50,460,180,30);
	color5 = new Color (0,128,0);
	lb6.setForeground(color5);
	lb6.setBackground(Color.WHITE);
	f6 = new Font("Cambria",Font.BOLD, 16); 
	lb6.setFont(f6);
	lb6.setOpaque(true);
	panel.add(lb6);
	
				
	lb7=new JLabel("ID: 23-51957-2 ");
	lb7.setBounds(50,490,180,30);
	color6 = new Color (0,128,0);
	lb7.setForeground(color6);
	lb7.setBackground(Color.WHITE);
	f7 = new Font("Cambria",Font.BOLD, 20); 
	lb7.setFont(f7);
	lb7.setOpaque(true);
	panel.add(lb7);
	
				
	lb8=new JLabel("JANNATE AJMIN TANHA");
	lb8.setBounds(440,460,180,30);
	color7 = new Color (0,128,0);
	lb8.setForeground(color7);
	lb8.setBackground(Color.WHITE);
	f8 = new Font("Cambria",Font.BOLD, 16); 
	lb8.setFont(f8);
	lb8.setOpaque(true);
	panel.add(lb8);
	
				
	lb9=new JLabel("ID: 23-54420-3 ");
	lb9.setBounds(440,490,180,30);
	color8 = new Color (0,128,0);
	lb9.setForeground(color8);
	lb9.setBackground(Color.WHITE);
	f9 = new Font("Cambria",Font.BOLD, 20); 
	lb9.setFont(f9);
	lb9.setOpaque(true);
	panel.add(lb9);
		
		
		icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());
		
		
		f1 = new Font("Segoe UI Black", Font.BOLD, 25);
		
		btn1 = new JButton("OK");
        btn1.setBounds(250, 520, 180, 50);
        btn1.setFont(f1);
        panel.add(btn1);
		btn1.addActionListener(this);
	    image = new ImageIcon("cc2.JPG ");
		lb1 = new JLabel(image);
		lb1.setBounds(0, 0, 700, 633);
		panel.add(lb1);
		lb1.setOpaque(true);
	
		this.add(panel);
		

}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btn1) 
		{
			setVisible(false);
		}
	}

}

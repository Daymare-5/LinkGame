package pro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Help helpInstance = new Help();
	//����һ������
	Container ct;
	//����������塣
	BackgroundPanel bgp;
	
	JButton rButton,eButton;
	
	private Help() {
		ct = this.getContentPane();
		bgp = new BackgroundPanel((new ImageIcon("src/im/hbk.png")).getImage());
		bgp.setBounds(0,0,500,500);
		ct.add(bgp);
		
		setSize(500, 500);
		setResizable(false); 
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		
		rButton = new JButton("����");
		eButton = new JButton("�˳�");
		rButton.setFont(new Font("��������", Font.PLAIN, 20));
		eButton.setFont(new Font("��������", Font.PLAIN, 20));
		rButton.addActionListener(this);
      	eButton.addActionListener(this);
		this.add(rButton);
      	this.add(eButton);
      	rButton.setBounds(100, 390, 100, 30);
      	eButton.setBounds(260, 390, 100, 30);
	}
	
	public static Help getInstance() {
		return helpInstance;
	}
//	class HelpJPanel extends JPanel {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		
//		public HelpJPanel(){
//			
//		}
//		
//		public void paintComponent(Graphics g){
//			
//			ImageIcon bk = new ImageIcon("src/im/bk20.jpg");
//			g.drawImage(bk.getImage(), 0, 0, this);
//			Font font1 = new Font("��������",Font.PLAIN,20);
//			Font font2 = new Font("��������",Font.BOLD,36);
//			Font font3 = new Font("��������",Font.BOLD,24);
//			g.setFont(font2);
//			g.setColor(Color.BLACK);
//			g.drawString("��Ϸ˵��",280,30);
//			g.drawString("�����淨",280,260);
//			g.setFont(font3);
//			g.setColor(Color.BLACK);
//			g.drawString("һ������ģʽ��",30,60);
//			g.drawString("��������ģʽ��",30,150);
//			g.setFont(font1);
//			g.setColor(Color.BLACK);
//	      	g.drawString("        ��ģʽ������ϲ��ѭ�򽥽�����ҡ�",30,80);
//	      	g.drawString("        �ڸ�ģʽ�£�����ʱ��̶�����Ϸ�Ѷ����׵��ѣ�ÿ����Զ�����һ",30,100);
//	      	g.drawString("���Ѷȣ�����Ϊ����ͼƬ��������ӣ���",30,120);
//	      	g.drawString("        ��ģʽ������ϲ��������ս����ҡ�",30,170);
//	      	g.drawString("        �ڸ�ģʽ�£���ҿ���ѡ��ʼ���ѳ̶ȣ�����ͼƬ���ཫ�̶�������",30,190);
//	      	g.drawString("�Źؿ�����ߣ�����ʱ�佫��Ӧ���١�",30,210);
//	      	g.drawString("        ���ε����ͬ������ͼƬ��ע�⣬������ͬͼƬ֮��Ӧ���������ϰ���",30,285);
//	      	g.drawString("����ҳ��������ͼƬ������ʱ����Ϸ������",30,305);   	
//	      	
//	   }  
//	}
	
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		if (jb == rButton) {
			this.setVisible(false);
			this.dispose();
			new MenuFrame().setVisible(true);
		}
		else if (jb == eButton) {
			this.setVisible(false);
			this.dispose();
		}
	}
}  
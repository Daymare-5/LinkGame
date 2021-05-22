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
	//创建一个容器
	Container ct;
	//创建背景面板。
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
		
		rButton = new JButton("返回");
		eButton = new JButton("退出");
		rButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		eButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
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
//			Font font1 = new Font("方正舒体",Font.PLAIN,20);
//			Font font2 = new Font("方正舒体",Font.BOLD,36);
//			Font font3 = new Font("方正舒体",Font.BOLD,24);
//			g.setFont(font2);
//			g.setColor(Color.BLACK);
//			g.drawString("游戏说明",280,30);
//			g.drawString("关于玩法",280,260);
//			g.setFont(font3);
//			g.setColor(Color.BLACK);
//			g.drawString("一、闯关模式：",30,60);
//			g.drawString("二、手速模式：",30,150);
//			g.setFont(font1);
//			g.setColor(Color.BLACK);
//	      	g.drawString("        该模式适用于喜欢循序渐进的玩家。",30,80);
//	      	g.drawString("        在该模式下，闯关时间固定，游戏难度由易到难，每五关自动提升一",30,100);
//	      	g.drawString("个难度（体现为消除图片种类的增加）。",30,120);
//	      	g.drawString("        该模式适用于喜欢自我挑战的玩家。",30,170);
//	      	g.drawString("        在该模式下，玩家可自选初始困难程度（消除图片种类将固定），随",30,190);
//	      	g.drawString("着关卡的提高，闯关时间将相应减少。",30,210);
//	      	g.drawString("        依次点击相同的两张图片，注意，两张相同图片之间应该无其他障碍，",30,285);
//	      	g.drawString("当将页面上所有图片消除完时，游戏结束。",30,305);   	
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
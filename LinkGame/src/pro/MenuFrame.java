package pro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//创建一个容器
	Container ct;
	//创建背景面板。
	BackgroundPanel bgp;
	
	JButton cButton, sButton, hButton, aButton, eButton;
	public static int pattern;
	
	final int    X  = 150;
	final int    Y  = 160;
    String Title = "高 校 版 连 连 看";
	
	public MenuFrame() {
		ct = this.getContentPane();
		bgp = new BackgroundPanel((new ImageIcon("src/im/mbk.jpg")).getImage());
		bgp.setBounds(0,0,640,500);
		ct.add(bgp);
		
		setTitle("连连看游戏菜单");
		setSize(640,500);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		
		cButton = new JButton("闯关模式");
		cButton.addActionListener(this);
		cButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		sButton = new JButton("手速模式");
		sButton.addActionListener(this);
		sButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		hButton = new JButton("帮助说明");
		hButton.addActionListener(this);
		hButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		aButton = new JButton("关于作者");
		aButton.addActionListener(this);
		aButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		eButton = new JButton("退出游戏");
		eButton.addActionListener(this);
		eButton.setFont(new Font("方正舒体", Font.PLAIN, 20));

		this.add(cButton);
		this.add(sButton);
		this.add(hButton);
		this.add(aButton);
		this.add(eButton);

		cButton.setBounds(240, 200, 150, 30);
		sButton.setBounds(240, 240, 150, 30);
		hButton.setBounds(240, 280, 150, 30);
		aButton.setBounds(240, 320, 150, 30);
		eButton.setBounds(240, 360, 150, 30);
	
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Font font2 = new Font("方正舒体",Font.BOLD,46);
		g.setFont(font2);
		g.setColor(Color.BLACK);
		g.drawString(Title,X, Y);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		if (jb == cButton) {
			this.setVisible(false);
			this.dispose();
			pattern = 1;
			CLinkGame frame = new CLinkGame();
			frame.setTitle("高校版连连看");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1200, 900);
			frame.setLocationRelativeTo(null);
	        frame.setVisible(true); 
	        frame.setResizable(false); 
		} 
		else if (jb == sButton) {
			this.setVisible(false);
			this.dispose();
			pattern = 2;
			SLinkGame frame = new SLinkGame();
			frame.setTitle("高校版连连看");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1200, 900);
			frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        frame.setResizable(false); 
		} 
		else if (jb == hButton) {
			this.setVisible(false);
			this.dispose();
			Help.getInstance();
		}

		else if (jb == aButton) {
			this.setVisible(false);
			this.dispose();
			AboutTheAuthor.getInstance();
		}
		else if (jb == eButton) {
			this.dispose();
		}
	}
	
	public static void main(String[] args) {

		new MenuFrame();
		
	}
}
package pro;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class AboutTheAuthor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static AboutTheAuthor aTAInstance = new AboutTheAuthor();
	
	//创建一个容器
	Container ct;
	//创建背景面板。
	BackgroundPanel bgp;
	
	JButton rButton,eButton;
	private AboutTheAuthor() {
		
		ct = this.getContentPane();
		bgp = new BackgroundPanel((new ImageIcon("src/im/abk.jpg")).getImage());
		bgp.setBounds(0,0,540,460);
		ct.add(bgp);
		
		setTitle("作者——莫欣文，魏心怡");
		setSize(540, 460);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		
		rButton = new JButton("返回");
		rButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		rButton.addActionListener(this);
		eButton = new JButton("退出");
		eButton.setFont(new Font("方正舒体", Font.PLAIN, 20));
		eButton.addActionListener(this);	

		this.add(eButton);
		this.add(rButton);
		rButton.setBounds(170, 300, 150, 30);
		eButton.setBounds(170, 360, 150, 30);
	}
	
	public static AboutTheAuthor getInstance() {
		return aTAInstance;
	}
	
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

package pro;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SandClock extends JPanel implements Runnable{
		private static final long serialVersionUID = 1L;
		private int levelCount;
		int remainTime = 0; // ʱ��
		int x1 = 0;
		int y1 = 10;
		int x2 = 60;
		int y2 = 130;
		Thread nThread1;//�߳�
		JLabel overJLabel = new JLabel();
		JDialog dialog = new JDialog();
		
		protected Music music;
		Sound player1 = Link.sound;
		//Sound player1 = new Sound("src/��֮ʫ.wav");
		Sound player2 = new Sound("src/��.wav");
		int control = 0;

		public SandClock() {
			nThread1 = new Thread(this);				
			nThread1.start();
			this.setLayout(null);
			this.add(overJLabel);
			overJLabel.setBounds(0, 0, 200, 11);
			overJLabel.setForeground(Color.white);
			
			player2.start(true);
			player2.stop();
			
			if( Link.mc == 1 )
				music = KMusic.getMusicInstance();
			else if( Link.mc == 2 )
				music = (NMusic.getMusicInstance());
			else if( Link.mc == 3 )
				music = (TMusic.getMusicInstance());
			
			
		}// end sandClock()

		public void setLevelCount(int x) {
			this.levelCount = x;
		}

		//����ɳ©
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
							
			g.setColor(Color.white);
			for (int i = 0; i < 56; i++) {
				g.drawLine(x1 + i / 2 + 2, y1 + i, x2 - i / 2 - 2, y1 + i);
			}//������
			
			if (remainTime < 55) {
				for (int i = 0; i < remainTime; i++) {
					g.drawLine(x1 + i / 2 + 2, y2 - i - 1, x2 - i / 2 - 2, y2 - i
							- 1);
				}//�������ϻ�������
				g.drawLine((x1 + x2) / 2, y1 +55, (x1 + x2) / 2, y2 - 2);
				g.drawLine((x1 + x2) / 2 + 1, y1 +55 , (x1 + x2) / 2 + 1,y2 - 2);//��������
				g.setColor(getBackground());
				for (int i = 0; i < remainTime; i++) {
					g.drawLine(x1 + i / 2 + 2, y1 + i, x2 - i / 2 - 2, y1 + i);//�����ϱߵĵ�����
				}
			}
			if (remainTime >= 0 && remainTime <= 55)
				overJLabel.setText(55-remainTime +"unit");
			
			if (remainTime == 56) 
				overJLabel.setText("OVER");
		} // end paintComponent(Graphics g)

		public void setTime(int x) {
			this.remainTime = x;
		}

		public int getTime() {
			return remainTime;
		}

		public void run() {
			
			while (levelCount < 20) {
				if(levelCount == 0 && control == 0) {
					if (remainTime == 0) {
						int c = JOptionPane.showConfirmDialog
								(null, "\n�Ƿ���Ϸ��ʼ��", "������", JOptionPane.YES_NO_OPTION);
						if(c == JOptionPane.YES_OPTION) {
							player1.start(true);
							control = 1;
						}
						else {
							System.exit(1);
						}
					}
					if ( remainTime == 45) {
						player1.stop();
						player2.continues();
					}
					if (remainTime == 56) {
						player2.stop();
						JOptionPane.showMessageDialog(null, "ʱ�䵽����Ϸ������\n������һ������"+ levelCount
								+ "�ء�\n�ܵ÷�Ϊ" + (Link.getScore()+1) + "������~");
					}
				}
				else {
					if (remainTime == 0) {
						player1.stop();
						player2.stop();
						int c = JOptionPane.showConfirmDialog
							(null, "\n�Ƿ���Ϸ��ʼ��", "������", JOptionPane.YES_NO_OPTION);
						if(c == JOptionPane.YES_OPTION) {
							music.musicPlayer(player1);
						}
						else {
							JOptionPane.showMessageDialog(null, "�ðɣ���Ϸ������\n������һ������"+ levelCount
									+ "�ء�\n�ܵ÷�Ϊ" + (Link.getScore()+1) + "������~");
							System.exit(1);
						}	
					}
					if (remainTime == 45) {
						player1.stop();
						player2.continues();
					}
					if (remainTime == 56) {
						player2.stop();
						JOptionPane.showMessageDialog(null, "ʱ�䵽����Ϸ������\n������һ������"+ levelCount
														+ "�ء�\n�ܵ÷�Ϊ" + (Link.getScore()+1) + "������~");
					}
				}
				remainTime++;
				repaint();
				
				try {
					if(MenuFrame.pattern == 1)
						Thread.sleep(1000);
					if(MenuFrame.pattern == 2)
						Thread.sleep(1000-levelCount*20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}// end run()
}//end class CSandClock	


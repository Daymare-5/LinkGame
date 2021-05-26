package pro;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

	
public abstract	class Link extends JPanel implements ActionListener{
		
		private static final long serialVersionUID = 1L;
		protected int[][] map = new int[8][8];//8*8的正方形
		private int randomKind, randomx, randomy, randomx1, randomy1;
		protected int kinds = 5;
		private int remainingQuantity;//刷新时未消除图案的数量
		private static int score;
		protected int levelCount = 0;
		private Point lineStart = new Point(0, 0);
		private int clicktimes;
		private int coordinatex,  coordinatey,
					coordinatex1, coordinatey1; // 点击点的坐标
		static Sound sound;
		static int mc = 0 ;//用于判断用户选择的bgm 
		
		//SandClock sc = new SandClock();// 沙漏
		SandClock sc;
		JButton BlockButton[][] = new JButton[8][8];//
		JButton newgameButton = new JButton("重新开始");
		JButton reLoadButton = new JButton("刷新");
		//JButton nextLevelButton = new JButton("下一关");
		
		JButton musicButton;
		
		ImageIcon bk1 = new ImageIcon("src/im/bk1.jpg");
		ImageIcon bk2 = new ImageIcon("src/im/bk2.jpg");
		ImageIcon bk3 = new ImageIcon("src/im/bk3.jpg");
		ImageIcon bk4 = new ImageIcon("src/im/bk4.jpg");
		ImageIcon bk5 = new ImageIcon("src/im/bk5.jpg");
		ImageIcon bk6 = new ImageIcon("src/im/bk6.jpg");
		ImageIcon bk7 = new ImageIcon("src/im/bk7.jpg");
		ImageIcon bk8 = new ImageIcon("src/im/bk8.jpg");
		ImageIcon bk9 = new ImageIcon("src/im/bk9.jpg");
		ImageIcon bk10 = new ImageIcon("src/im/bk10.jpg");
		ImageIcon bk11 = new ImageIcon("src/im/bk11.jpg");
		ImageIcon bk12 = new ImageIcon("src/im/bk12.jpg");
		ImageIcon bk13 = new ImageIcon("src/im/bk13.jpg");
		ImageIcon bk14 = new ImageIcon("src/im/bk14.jpg");
		ImageIcon bk15 = new ImageIcon("src/im/bk15.jpg");
		ImageIcon bk16 = new ImageIcon("src/im/bk16.jpg");
		ImageIcon bk17 = new ImageIcon("src/im/bk17.jpg");
		ImageIcon bk18 = new ImageIcon("src/im/bk18.jpg");
		ImageIcon bk19 = new ImageIcon("src/im/bk19.jpg");
		ImageIcon bk20 = new ImageIcon("src/im/bk20.jpg");
		ImageIcon aIcon = new ImageIcon("src/im/1.jpg");
		ImageIcon bIcon = new ImageIcon("src/im/2.jpg");
		ImageIcon cIcon = new ImageIcon("src/im/3.jpg");
		ImageIcon dIcon = new ImageIcon("src/im/4.jpg");
		ImageIcon eIcon = new ImageIcon("src/im/5.jpg");
		ImageIcon fIcon = new ImageIcon("src/im/6.jpg");
		ImageIcon gIcon = new ImageIcon("src/im/7.jpg");
		ImageIcon hIcon = new ImageIcon("src/im/8.jpg");
		ImageIcon iIcon = new ImageIcon("src/im/9.jpg");
		ImageIcon jIcon = new ImageIcon("src/im/10.jpg");
		ImageIcon kIcon = new ImageIcon("src/im/11.jpg");
		ImageIcon lIcon = new ImageIcon("src/im/12.jpg");
		ImageIcon mIcon = new ImageIcon("src/im/13.jpg");
		ImageIcon nIcon = new ImageIcon("src/im/14.jpg");
		ImageIcon oIcon = new ImageIcon("src/im/15.jpg");
		ImageIcon ii = bk1;
		
		public Link() {
			
			this.setLayout(null);

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					BlockButton[i][j] = new JButton();
					add(BlockButton[i][j]);
					BlockButton[i][j].addActionListener((ActionListener) this);//监听器
					BlockButton[i][j].setBounds(50 + j * 60, 50 + i * 60, 50,50);
				}
			}

			newgameButton.setBounds(720, 80, 200, 30);
			newgameButton.setBackground(Color.white);
			newgameButton.setBorderPainted(true); //去边框
			reLoadButton.setBounds(720, 120, 200, 30);
			reLoadButton.setBackground(Color.white);
			reLoadButton.setBorderPainted(true);
			//nextLevelButton.setBounds(map[0].length * 40 + 400, 350, 200, 20);
			//nextLevelButton.addActionListener(this);//
			newgameButton.addActionListener(this);
			reLoadButton.addActionListener(this);

			this.add(newgameButton);
			this.add(reLoadButton);
			//this.add(nextLevelButton);
			
			Object[] possibleValues = { "卡农(八音盒版)", "鸟之诗(八音盒版)", "天空之城(八音盒版)" }; 
			Object selectedValue = JOptionPane.showInputDialog(null, "请选择你喜欢的BGM。", "背景音乐", 
			JOptionPane.INFORMATION_MESSAGE, null,  possibleValues, possibleValues[0]);
			if(selectedValue == "卡农(八音盒版)") {
				mc = 1;
				musicButton = new JButton("BGM:"+selectedValue);
				musicButton.setBounds(720, 255, 200, 25);
				musicButton.setBackground(getBackground());
				musicButton.setBorderPainted(true);
				this.add(musicButton);
				sound = KMusic.getSoundInstance();				
			}
			else if(selectedValue == "鸟之诗(八音盒版)") {
				mc = 2;
				musicButton = new JButton("BGM:"+selectedValue);
				musicButton.setBounds(720, 255, 200, 25);
				musicButton.setBackground(getBackground());
				musicButton.setBorderPainted(true);
				this.add(musicButton);
				sound = NMusic.getSoundInstance();			
			}
			else if(selectedValue == "天空之城(八音盒版)") {
				mc = 3;
				musicButton = new JButton("BGM:"+selectedValue);
				musicButton.setBounds(720, 255, 200, 25);
				musicButton.setBackground(getBackground());
				musicButton.setBorderPainted(true);
				this.add(musicButton);
				sound = TMusic.getSoundInstance();
			}
			else
				System.exit(0);
			
			//沙漏
			sc = new SandClock();
			sc.setBounds(1040, 140, 60, 130);
			Color cl=new Color(247,185,175); 
			sc.setBackground(cl);
			this.add(sc);
			
			newGame();
			
		}	
		
		//重新开始
		public void newGame() {
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					BlockButton[i][j].setEnabled(true);
					BlockButton[i][j].setVisible(true);
				}
			}
			kinds = 5;
			
			nextLevel();

			sc.setTime(0);
			score = 0;
			levelCount = 0;
			//setLevelCount(levelCount);//重新设置
		}
		
		//下一关(生成随机排列的成对图标)
		public abstract void nextLevel() ;
		

		//事件处理
		public void actionPerformed(ActionEvent e) {
			
			if (sc.getTime() >56) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						BlockButton[j][i].setEnabled(false);
					}
				}
			}
			
			if (e.getSource() == reLoadButton) {
				reLoad();
				reLoadButton.setEnabled(false);
			}
			if (e.getSource() == newgameButton) {
				newGame();
				reLoadButton.setEnabled(true);
				sound.stop();
			}
			/*if (e.getSource() == nextLevelButton) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						map[i][j] = 0;
					}
				}
				pass();
				reLoadButton.setEnabled(true);
			}测试用
			*/
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (e.getSource() == BlockButton[j][i]) {
						clicktimes++; // 点击的次数
						lineStart.move(i, j);
						if (clicktimes % 2 == 1) {
							coordinatex1 = i;
							coordinatey1 = j;
							BlockButton[coordinatey1][coordinatex1].setEnabled(false);
							BlockButton[coordinatey][coordinatex].setEnabled(true);

						//	BlockButton[j][i].setEnabled(false);
						}
						if (clicktimes % 2 == 0) {
							
							coordinatex = i;
							coordinatey = j;
							BlockButton[coordinatey][coordinatex].setEnabled(false);
							BlockButton[coordinatey1][coordinatex1].setEnabled(true);
						}
					}

				} // end for(j)
			} // end for(i)
			
			this.requestFocus();
			clearBlock();
			repaint();
			
		} // end actionPerformed(ActionEvent)
		
		public void clearBlock() {
			if (clicktimes >=2) {
			
				if (map[coordinatey1][coordinatex1] == map[coordinatey][coordinatex]
						&& !((coordinatex1 == coordinatex) && (coordinatey1 == coordinatey))) {
					
					if (ifCanLink(coordinatey1, coordinatex1, coordinatey,
							coordinatex)) {
						
						if (map[coordinatey1][coordinatex1] > 0)
							score = score + kinds*2;
						
						map[coordinatey1][coordinatex1] = 0;
						map[coordinatey][coordinatex] = 0;
						pass();
					}
				}
			} //end if (clicktimes >=2)
		}

		//画图
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//是父类JPanel里的方法,会把整个面板用背景色重画一遍,起到清屏的作用			
			
			//绘制背景
			g.drawImage(ii.getImage(), 0, 0, this);
			
			//绘制关数与得分
			int x,y1,y2;
		    x=720;
		    y1=180;
		    y2=215;
			g.setColor(new Color(185,240,200)); 
			    g.fillRect(x,y1-6,200,25);
			    Font font2 = new Font("楷体",Font.PLAIN,14);
				g.setFont(font2);
			    g.setColor(Color.black);
			    g.drawString("      当前你正在第 " + (levelCount + 1) + " 关",x,y1+g.getFontMetrics().getAscent()); 
			    
			   
			    g.setColor(new Color(255,220,200)); 
			    g.fillRect(x,y2-6,200,25);
				g.setFont(font2);
			    g.setColor(Color.black);
			    g.drawString("      [ 共计得分 ]: "+ getScore(),x,y2+g.getFontMetrics().getAscent());
			    
			//绘制图案
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					
					switch (map[i][j]) {
					case 0:
						BlockButton[i][j].setVisible(false);
						break;
					case 1:
						BlockButton[i][j].setIcon(aIcon);
						break;
					case 2:
						BlockButton[i][j].setIcon(bIcon);
						break;
					case 3:
						BlockButton[i][j].setIcon(cIcon);
						break;
					case 4:
						BlockButton[i][j].setIcon(dIcon);
						break;
					case 5:
						BlockButton[i][j].setIcon(eIcon);
						break;
					case 6:
						BlockButton[i][j].setIcon(fIcon);
						break;
					case 7:
						BlockButton[i][j].setIcon(gIcon);
						break;
					case 8:
						BlockButton[i][j].setIcon(hIcon);
						break;
					case 9:
						BlockButton[i][j].setIcon(iIcon);
						break;
					case 10:
						BlockButton[i][j].setIcon(jIcon);
						break;
					case 11:
						BlockButton[i][j].setIcon(kIcon);
						break;
					case 12:
						BlockButton[i][j].setIcon(lIcon);
						break;
					case 13:
						BlockButton[i][j].setIcon(mIcon);
						break;
					case 14:
						BlockButton[i][j].setIcon(nIcon);
						break;
					case 15:
						BlockButton[i][j].setIcon(oIcon);
						break;
					default:
						break;
					}
				}
			}
		}
		
		//刷新
		public void reLoad() {  
					
			remainingQuantity = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (map[i][j] > 0) {
						remainingQuantity++;
					}
				}
			}		
			int[][] map1 = new int[8][8];
			this.map = map1;
			Random random = new Random();
			
			for (int i = 0; i < remainingQuantity / 2; i++) {
				randomKind = random.nextInt(kinds) + 1;
				do {				
					randomx1 = random.nextInt(8);//0-7随机数
					randomy1 = random.nextInt(8);
				} while (map[randomy1][randomx1] > 0);

				map[randomy1][randomx1] = randomKind;
				
				do {
					randomx = random.nextInt(8);
					randomy = random.nextInt(8);
				} while (map[randomy][randomx] > 0);

				map[randomy][randomx] = randomKind;
				
			}
										
			repaint();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {		
					BlockButton[i][j].setVisible(true);
				}
			}
					
		}
		
		
		public void setLevelCount(int x) {
			levelCount = x;
		}
		
		public void setScore(int x) {
			Link.score = x;
		}

		//过关
		public void pass() {
			int newRemainingQuantity = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (map[i][j] > 0) {
						newRemainingQuantity++;
					}
				}
			}
			
			if (newRemainingQuantity == 0) {
				score = getScore() + (56-sc.getTime())*(1+levelCount);
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						BlockButton[i][j].setEnabled(true);
						BlockButton[i][j].setVisible(true);
					}
				}
				int[][] map = new int[8][8];
				this.map = map;
				
				levelCount++;
				sc.setLevelCount(levelCount);
				nextLevel();
				sc.setTime(0);
				reLoadButton.setEnabled(true);
			} // end if
		}//end pass()
		
		


	// --------------------------------------------------------------------------
	// 判断在一列之内两图片之间是否全部是空白或直接相邻
	private boolean AllZeroInColumn(int posX1, int posY1,
			int posX2, int posY2) {
		// 直接相连,因而不包含空白
		if (Math.abs(posY1 - posY2) == 1) {
			return true;
		}
		int a = posY1 < posY2 ? posY1 : posY2;
		int b = posY1 < posY2 ? posY2 : posY1;//y值:a小 b大
		for (int j = a + 1; j < b; j++) {
			if (map[posX1][j] != 0) {
				return false;
			}
		}
		return true;
	}
	
	// 判断在一行之内两图片之间是否全部是空白或直接相邻
	private boolean AllZeroInRow(int posX1, int posY1,
			int posX2, int posY2) {
		// 直接相连,因而不包含空白
		if (Math.abs(posX1 - posX2) == 1) {
			return true;
		}
		int a = posX1 < posX2 ? posX1 : posX2;
		int b = posX1 < posX2 ? posX2 : posX1;
		for (int i = a + 1; i < b; i++) {
			if (map[i][posY1] != 0) {
				return false;
			}
		}
		return true;
	}

	// 是否可以一直线相连
	private boolean isLinkByOneLine(int posX1, int posY1, int posX2,
			int posY2) {

		if (posX1 != posX2 && posY1 != posY2) //不同行不同列
		{
			return false;
		}
		if (posX1 == posX2) //同列不同行
		{
			if (AllZeroInColumn(posX1, posY1, posX2, posY2)) {
				return true;
			}
		}
		if (posY1 == posY2) //同行不同列
		{
			if (AllZeroInRow(posX1, posY1, posX2, posY2)) {
				return true;
			}
		}
		return false;
	}

	// 是否可以两直线相连
	private boolean isLinkByTwoLines(int posX1, int posY1, int posX2,
			int posY2) {
		if (posX1 != posX2 && posY1 != posY2) // 不同行不同列
		{
			// (x1,y1) -> (x2,y1) -> (x2,y2)
			if ( AllZeroInRow(posX1, posY1, posX2, posY1)
					&& map[posX2][posY1] == 0
					&& AllZeroInColumn(posX2, posY1, posX2,
							posY2)) {
				return true;
			}
			// (x1,y1) -> (x1,y2) -> (x2,y2)
			if (AllZeroInColumn(posX1, posY1, posX1, posY2)
					&& map[posX1][posY2] == 0
					&& AllZeroInRow(posX1, posY2, posX2,
							posY2)) {
				return true;
			}

		} // end if
		return false;
	}

	// 是否可以三直线相连
	private boolean isLinkByThreeLines(int posX1, int posY1, int posX2,
			int posY2) {
		if (isOnSameEdge(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnThreeLinesLikeArc(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnThreeLinesLikeZigzag(posX1, posY1, posX2, posY2)) {
			return true;
		}
		return false;
	}

	// 是否可以三直线相连,似U形
	private boolean isOnThreeLinesLikeArc(int posX1, int posY1, int posX2,
			int posY2) {
		if (isOnUpArc(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnDownArc(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnLeftArc(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnRightArc(posX1, posY1, posX2, posY2)) {
			return true;
		}
		return false;
	}

	// n
	private boolean isOnUpArc(int posX1, int posY1, int posX2, int posY2) {

		int y = posY1 < posY2 ? posY1 : posY2;
		for (int j = y - 1; j >= 0; j--) // y!=0
		{
			if (AllZeroInRow(posX1, j, posX2, j)
					&& AllZeroInColumn(posX1, posY1, posX1, j)
					&& AllZeroInColumn(posX2, posY2, posX2, j)
					&& map[posX1][j] == 0 && map[posX2][j] == 0) {
				return true;
			}
		}

		if ( AllZeroInColumn(posX1, posY1, posX1, 0)
				&& AllZeroInColumn(posX2, posY2, posX2, 0)
				&&((map[posX1][0]==0 && map[posX2][0]==0)
				||(map[posX1][0]==0 && posY2==0)
				||(map[posX2][0]==0 && posY1==0)) ) 
		{
			return true;
		}

		return false;
	} //end

	// u
	private boolean isOnDownArc(int posX1, int posY1, int posX2, int posY2) {
		int Y = posY1 < posY2 ? posY2 : posY1;
		for (int j = Y + 1; j <= 8 - 1; j++) {
			if (AllZeroInRow(posX1, j, posX2, j)
					&& AllZeroInColumn(posX1, posY1, posX1, j)
					&& AllZeroInColumn(posX2, posY2, posX2, j)
					&& map[posX1][j] == 0 && map[posX2][j] == 0) {
				return true;
			}
		}
		if (AllZeroInColumn(posX1, posY1, posX1, 8 - 1)
				&& AllZeroInColumn(posX2, posY2, posX2, 8 - 1)
				&& ((map[posX1][8-1]==0 && map[posX2][8-1]==0)
				||(map[posX1][8-1]==0 && posY2==8-1)
				||(map[posX2][8-1]==0 && posY1==8-1)) ){
			return true;
		}
		return false;
	}

	// [
	private boolean isOnLeftArc(int posX1, int posY1, int posX2, int posY2) {
		int x = posX1 < posX2 ? posX1 : posX2;
		for (int i = x - 1; i >= 0; i--) {
			if (AllZeroInColumn(i, posY1, i, posY2)
					&& AllZeroInRow(i, posY1, posX1, posY1)
					&& AllZeroInRow(i, posY2, posX2, posY2)
					&& map[i][posY1] == 0 && map[i][posY2] == 0) {
				return true;
			}
		}

		if (AllZeroInRow(0, posY1, posX1, posY1)
				&& AllZeroInRow(0, posY2, posX2, posY2)
				&& ((map[0][posY1]==0 && map[0][posY2]==0)
				||(map[0][posY1]==0 && posX2==0)
				||(map[0][posY2]==0 && posX1==0)) ) {
			return true;
		}

		return false;
	}

	// ]
	private boolean isOnRightArc(int posX1, int posY1, int posX2, int posY2) {
		int moreX = posX1 < posX2 ? posX2 : posX1;
		for (int i = moreX + 1; i <= 8 - 1; i++) {
			if (AllZeroInColumn(i, posY1, i, posY2)
					&& AllZeroInRow(i, posY1, posX1, posY1)
					&& AllZeroInRow(i, posY2, posX2, posY2)
					&& map[i][posY1] == 0 && map[i][posY2] == 0) {
				return true;
			}
		}

		if (AllZeroInRow(posX1, posY1, 8 - 1, posY1)
				&& AllZeroInRow(posX2, posY2, 8 - 1, posY2)
				&&((map[8-1][posY1]==0 && map[8-1][posY2]==0)
						||(map[8-1][posY1]==0 && posX2==8-1)
						||(map[8-1][posY2]==0 && posX1==8-1)) ) {
			return true;
		}

		return false;
	}

	// 是否可以三直线相连,似之字形
	private boolean isOnThreeLinesLikeZigzag(int posX1, int posY1,
			int posX2, int posY2) {
		if (isOnZigzagWith1Row2Cols(posX1, posY1, posX2, posY2)) {
			return true;
		}
		if (isOnZigzagWith2Rows1Col(posX1, posY1, posX2, posY2)) {
			return true;
		}

		return false;
	}

	// 是否可以三直线相连,似之字形, 两行一列 Z
	private boolean isOnZigzagWith2Rows1Col(int posX1, int posY1,
			int posX2, int posY2) {
		int X = posX1 < posX2 ? posX2 : posX1;
		int x = posX1 < posX2 ? posX1 : posX2;
		for (int i = x + 1; i < X; i++) {
			if (AllZeroInColumn(i, posY1, i, posY2)
					&& AllZeroInRow(i, posY1, posX1, posY1)
					&& AllZeroInRow(i, posY2, posX2, posY2)
					&& map[i][posY1] == 0 && map[i][posY2] == 0) {
				return true;
			}
		}
		return false;
	}

	// 是否可以三直线相连,似之字形, 一行两列 N
	private boolean isOnZigzagWith1Row2Cols(int posX1, int posY1,
			int posX2, int posY2) {
		int Y = posY1 < posY2 ? posY2 : posY1;
		int y = posY1 < posY2 ? posY1 : posY2;
		for (int j = y + 1; j < Y; j++) {
			if (AllZeroInRow(posX1, j, posX2, j)
					&& AllZeroInColumn(posX1, posY1, posX1, j)
					&& AllZeroInColumn(posX2, posY2, posX2, j)
					&& map[posX1][j] == 0 && map[posX2][j] == 0) {
				return true;
			}
		}
		return false;
	}

	// 是否处于游戏区域的4条边的同一边上
	private boolean isOnSameEdge(int posX1, int posY1, int posX2, int posY2) {
		if ((posY1 == posY2 && posY2 == 0)
				|| (posY1 == posY2 && posY2 == 8 - 1)
				|| (posX1 == posX2 && posX2 == 0)
				|| (posX1 == posX2 && posX2 == 8 - 1)) {
			return true;
		}

		return false;
	}

	// --------------------------------------------------------------------------
	public boolean ifCanLink(int posX1, int posY1, int posX2, int posY2) {

		if (isLinkByOneLine(posX1, posY1, posX2, posY2)) {
			return true;
		}
		// 是否可以两直线相连
		if (isLinkByTwoLines(posX1, posY1, posX2, posY2)) {
			return true;
		}
		// 是否可以三直线相连
		if (isLinkByThreeLines(posX1, posY1, posX2, posY2)) {
			return true;
		}

		return false;

	}

	public static int getScore() {
		return score;
	}
	
}

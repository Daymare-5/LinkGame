package pro;

import java.util.*;
import javax.swing.*;

public class CLinkGame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public CLinkGame() {
		CLinkGameJPanel llk = new CLinkGameJPanel();
		add(llk);
	}
	class CLinkGameJPanel extends Link {
		private static final long serialVersionUID = 1L;

		public CLinkGameJPanel() {
		}

		//��һ��(����������еĳɶ�ͼ��)
		public void nextLevel() {
			
			if(levelCount == 20) {
				JOptionPane.showMessageDialog(null, "��ϲ��ͨ����������");
				System.exit(0);
			}		
			else {
				if(levelCount%2 == 0)
					kinds ++;
			ArrayList<Integer> numbers = new ArrayList<Integer>();//����
			repaint();
			Random random = new Random();
			int temp = 0;
			for (int i = 0; i < 32; i++) {
				temp = random.nextInt(kinds) + 1;//0~kinds-1֮���������ڼ�1
				numbers.add(temp);
				numbers.add(temp);
			}
				
			Collections.shuffle(numbers);//�������ԭ����˳��
				
			map = new int[8][8];
			temp = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					map[i][j] = numbers.get(temp++).intValue();//get�������ص�i��Ԫ�أ�������ת��Ϊint��
				}
			}
			
			switch(levelCount) {
			case 1:ii=bk1;
					break;
			case 2:ii=bk2;
					break;
			case 3:ii=bk3;
					break;
			case 4:ii=bk4;
					break;
			case 5:ii=bk5;
					break;
			case 6:ii=bk6;
					break;
			case 7:ii=bk7;
					break;
			case 8:ii=bk8;
					break;
			case 9:ii=bk9;
					break;
			case 10:ii=bk10;
					break;
			case 11:ii=bk11;
					break;
			case 12:ii=bk12;
					break;
			case 13:ii=bk13;
					break;
			case 14:ii=bk14;
					break;
			case 15:ii=bk15;
					break;
			case 16:ii=bk16;
					break;
			case 17:ii=bk17;
					break;
			case 18:ii=bk18;
					break;
			case 19:ii=bk19;
					break;
			case 0:ii=bk20;
					break;
			default :break;
			}//ÿ�ػ�����
			
			sc.setTime(0);
			sc.setLevelCount(levelCount);
			}	
		}	
	}
	
}
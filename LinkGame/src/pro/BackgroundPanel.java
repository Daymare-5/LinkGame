package pro;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		Image im;
		public BackgroundPanel(Image im)
		{
			this.im=im;
			this.setOpaque(true);
			setLayout(null);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponents(g);
			g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		}
	}

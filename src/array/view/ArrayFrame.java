package array.view;

import javax.swing.JFrame;

import array.controller.ArrayController;

public class ArrayFrame extends JFrame
	{
		private ArrayController baseController;
		private ArrayPanel basePanel;
		
		public ArrayFrame(ArrayController baseController)
		{
			this.baseController = baseController;
			basePanel = new ArrayPanel(baseController);
			buildFrame();
		}
		
		private void buildFrame()
		{
			setContentPane(basePanel);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400,300);
			setTitle("NAH FAM");
			setVisible(true);
		}
		
	}

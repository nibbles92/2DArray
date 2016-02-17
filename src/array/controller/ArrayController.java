package array.controller;

import array.model.BackPack;
import array.view.ArrayFrame;

public class ArrayController
	{
		private ArrayFrame baseFrame;
		private BackPack backPack;
		private String[][] pack;
		
		public ArrayController()
		{
			baseFrame = new ArrayFrame(this);
			backPack = new BackPack();
		}
		
		public void start()
		{
		
		}
		
		public void setPos(int x, int y, String content)
		{
			backPack.addStuff(x, y, content);
		}
		
		public void removeContent(int x, int y)
		{
			backPack.removeStuff(x, y);
		}

		public BackPack getBackPack()
			{
				return backPack;
			}


	}
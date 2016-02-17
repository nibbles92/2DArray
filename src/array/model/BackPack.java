package array.model;

public class BackPack
	{
		private String[][] insideBackPack;
		private int x;
		private int y;
		
		public BackPack()
		{
			insideBackPack = new String[5][5];
		}
		public void addStuff(int x, int y, String content)
		{
			this.x = x;	this.y = y;
			insideBackPack[x][y] = content;
		}
		public String getContents()
			{
				return insideBackPack[x][y];
			}
		public void removeStuff(int x, int y)
		{
			this.x = x;	this.y = y;

			insideBackPack[x][y] = "";
		}
	}

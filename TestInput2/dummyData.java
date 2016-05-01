public class dummyData
{
	public static void main(String[] args)
	{
		int create;
		for(int i=0; i<50; i++)
		{
			create =(int) Math.floor(Math.random() * 3); // produce number between 0 and 3
			switch(create)
			{
				case 0: 
				{
					createCircle();
					break;
				}
				case 1:
				{
					createPoly();
					break;
				}
				case 2: 
				{
					createSemiCirc();
					break;
				}
				case 3:
				{
					createSemiCirc();
					break;
				}
			}
		}
	}

	public static String spaces()
	{
		String c =" ";
		for(int i=0; i<Math.ceil(Math.random() * 10);i++)
		{
			c+=" ";
		}
		return c;
	}

	public static double randomNum(int num)
	{
		return (Math.random() * num);
	}

	public static void createCircle()
	{
		String c="C ";
		c += spaces();
		c += String.format("%.2f", randomNum(100));				// double
		c += spaces();
		c += String.format("%.2f", randomNum(100));				// double
		c += spaces();
		c += String.format("%.2f", randomNum(40));
		System.out.println(c);
	}

	public static void createSemiCirc()
	{
		String sc = "S ";
		sc+= spaces();
		sc += String.format("%.2f", randomNum(100));
		sc+= spaces();
		sc += String.format("%.2f", randomNum(100)); // point 1
		sc+= spaces();
		sc += String.format("%.2f", randomNum(100));
		sc+= spaces();
		sc += String.format("%.2f", randomNum(100)); // point 2
		sc+= spaces();
		System.out.println(sc);
	}

	public static void createPoly()
	{
		String p = "P ";
		p+= spaces();
		int i =(int) Math.ceil((Math.random() * 10));
		p += i;
		p += spaces();
		for(int j=0; j<i;j++)
		{
			p += String.format("%.2f", randomNum(100));
			p+= spaces();
			p += String.format("%.2f", randomNum(100)); // point 1
			p+= spaces();
		}
		System.out.println(p);
	}
}
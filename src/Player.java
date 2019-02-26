import java.awt.Color;
import java.util.ArrayList;

public class Player 
{	
	protected String name;
	protected Color color;
	protected int count;
	
	public Player(Color color, String name, int count)
	{
		this.name = name;
		this.color = color;
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}

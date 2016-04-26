public abstract class PlanarShape
{
	public abstract String toString();

	public abstract double area();

	public abstract double originDistance();

	public abstract void modifyArray(int index, Point point);

	public abstract Point[] getArray();

}
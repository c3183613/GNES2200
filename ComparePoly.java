	//	SENG2200 Interface
// 
//
// Interface we were given to implement
public interface ComparePoly<T> {

	public boolean ComesBefore(T object); // true if this < param

}


/*

The Planar Shapes have an ordering based on area( ) and
originDistance( ) as previously was the case for polygons. If any two PlanarShape
objects have areas within 0.05% of each other, then they are assumed to have equal area,
in which case, the planar shape with the lower originDistance( ) takes precedence (comes
first in the ordering). Because we need to be able to compare planar shapes, we also need
to use the standard Comparable<T> interface, using the specification implements
Comparable<PlanarShape>.

*/
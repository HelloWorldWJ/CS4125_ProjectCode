package Driver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Vehicle.Vehicle;

public class DriverTest {

	private IrritableDriver IrritableDr = new IrritableDriver("Tom", new Vehicle());
	private NormalDriver NormalDr = new NormalDriver("J.J", new Vehicle());
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetDriverTemperType() {
		
		assertEquals("Irritable", IrritableDr.getDriverTemperType());
		assertEquals("Normal", NormalDr.getDriverTemperType());
		
		//fail("Not yet implemented");
	}

	@Test
	public void testgetLimitedSpeed() {
		assertEquals(4.0, IrritableDr.getMaxLimitedSpeed(), 0.01);
		assertEquals(2.0, IrritableDr.getMinLimitedSpeed(), 0.01);
		assertEquals(2.0, NormalDr.getMaxLimitedSpeed(), 0.01);
		assertEquals(1.0, NormalDr.getMinLimitedSpeed(), 0.01);
	}


}



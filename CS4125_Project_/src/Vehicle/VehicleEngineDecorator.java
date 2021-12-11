package Vehicle;

public abstract class VehicleEngineDecorator implements VehicleType{
	protected VehicleType decoratedVehicleType;
	
	public VehicleEngineDecorator(VehicleType decoratedVehicleType) {
		this.decoratedVehicleType = decoratedVehicleType;
	
	}
}

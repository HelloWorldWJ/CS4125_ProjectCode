package Vehicle;

public abstract class EngineDecorator implements VehicleType{
	protected VehicleType decoratedVehicleType;
	
	public EngineDecorator(VehicleType decoratedVehicleType) {
		this.decoratedVehicleType = decoratedVehicleType;
	}
}

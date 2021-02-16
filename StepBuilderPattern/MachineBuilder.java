
public class Main{
	public static void main(String[] args) {
		Machine car = Machine.builder().withType("car").withMobile(true).withMobileType("driving").build();
		
		System.out.println("Model 1:"+ car.getType() +":"+ car.isMobile()+":"+car.getMobileType());
		
        Machine boat = Machine.builder().withType("boat").withMobile(true).withMobileType("driving").build();
		
		System.out.println("Model 2:"+ boat.getType() +":"+ boat.isMobile()+":"+boat.getMobileType());
	}
}

class Machine {
	private String type;
	private boolean isMobile;
	private String mobileType;

	public static TypeStep builder(){
		return new MachineBuilder();
	}
	
	public interface TypeStep{
		IsMobileStep withType(String type);
	}
	
	public interface IsMobileStep{
		MobileTypeStep withMobile(boolean isMobile);
		
	}
	
	public interface MobileTypeStep{
		Build withMobileType(String mobileType);
	}
	
	public interface Build{
		Machine build();
	}
	
	
	public static class MachineBuilder implements TypeStep, IsMobileStep, MobileTypeStep, Build {
		private String type;
		private boolean isMobile;
		private String mobileType;
		
		@Override
		public IsMobileStep withType(String type) {
			this.type = type;
			return this;
		}

		@Override
		public MobileTypeStep withMobile(boolean isMobile) {
			this.isMobile = isMobile;
			return this;
		}

		@Override
		public Build withMobileType(String mobileType) {
			this.mobileType = mobileType;
			return this;
		}

		@Override
		public Machine build() {
			return new Machine(this);
		}
		
	}
	
	private Machine(MachineBuilder machineBuilder) {
		this.type = machineBuilder.type;
		this.isMobile = machineBuilder.isMobile;
		this.mobileType = machineBuilder.mobileType;
	}

	public String getType() {
		return type;
	}

	public boolean isMobile() {
		return isMobile;
	}

	public String getMobileType() {
		return mobileType;
	}
}

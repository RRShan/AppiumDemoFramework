package javaConcept;

public class GetterAndSetter {
	private String model;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	
	public static void main(String[] args)
    {
		GetterAndSetter gt = new GetterAndSetter();
		gt.setModel("Audi");
		System.out.println(gt.getModel());
		gt.setPrice(20000);
		System.out.println(gt.getPrice());
    }

}

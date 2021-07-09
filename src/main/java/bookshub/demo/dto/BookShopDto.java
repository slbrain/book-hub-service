package bookshub.demo.dto;

public class BookShopDto {
	
	private Integer id;
	private String location;
	
	
	public BookShopDto(Integer id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}

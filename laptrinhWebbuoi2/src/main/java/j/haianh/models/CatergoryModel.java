package j.haianh.models;

import java.io.Serializable;

public class CatergoryModel  implements Serializable{

	private static final long serialVersionUID = 1L;
	private int catergory_id;
	private String catergory_name;
	private String image;
	private int status;
	public CatergoryModel(int catergory_id, String catergory_name, String image, int status) {
		super();
		this.catergory_id = catergory_id;
		this.catergory_name = catergory_name;
		this.image = image;
		this.status = status;
	}
	public CatergoryModel() {
		// TODO Auto-generated constructor stub
	}
	public int getCatergory_id() {
		return catergory_id;
	}
	public void setCatergory_id(int catergory_id) {
		this.catergory_id = catergory_id;
	}
	public String getCatergory_name() {
		return catergory_name;
	}
	public void setCatergory_name(String catergory_name) {
		this.catergory_name = catergory_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CatergoryModel [catergory_id=" + catergory_id + ", catergory_name=" + catergory_name + ", image="
				+ image + ", status=" + status + "]";
	}
	
	

}

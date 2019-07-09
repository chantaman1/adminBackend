package backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IntegranteOrganigrama {
	@Id
	private String _id;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private String position;
	private int parent;
	private int child;

	public IntegranteOrganigrama(String firstName, String lastName, String photoUrl, String position, int parent, int child) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.photoUrl = photoUrl;
		this.position = position;
		this.parent = parent;
		this.child = child;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}
}

package backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IntegranteOrganigrama {
	@Id
	public String _id;
	public String firstName;
	public String fatherLastName;
	public String motherLastName;
	public String photoUrl;
	public String position;
	public int parent;
	public int child;
	
	public IntegranteOrganigrama(String firstName, String fatherLastName, String motherLastName, String photoUrl, String position, int parent, int child) {
		this.firstName = firstName;
		this.fatherLastName = fatherLastName;
		this.motherLastName = motherLastName;
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

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
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

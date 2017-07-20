package com.sapient.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product extends AuditEntity {

	@Id
	private long productID;
	private String productName;
	private String productDescription;
	private String brand;
	private String os;
	private String ram;
	private String storage;
	private String screensize;

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getScreensize() {
		return screensize;
	}

	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + (int) (productID ^ (productID >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((ram == null) ? 0 : ram.hashCode());
		result = prime * result + ((screensize == null) ? 0 : screensize.hashCode());
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productID != other.productID)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (ram == null) {
			if (other.ram != null)
				return false;
		} else if (!ram.equals(other.ram))
			return false;
		if (screensize == null) {
			if (other.screensize != null)
				return false;
		} else if (!screensize.equals(other.screensize))
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productDescription="
				+ productDescription + ", brand=" + brand + ", os=" + os + ", ram=" + ram + ", storage=" + storage
				+ ", screensize=" + screensize + "]";
	}

}

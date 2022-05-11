package com.startup.servicemanagement.model;

public class ImageInfo {
	
	private String id;
	private String filePath;
	private String fileName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "ImageInfo [id=" + id + ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}
	
	
	
	
	
	

}

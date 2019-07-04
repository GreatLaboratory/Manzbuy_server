package tk.manzbuy.admin.dto;

public class ImageInfo {
	private Long id;
	private String filename;
	private String imgurl;
	private Long size;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ImageInfo [id=" + id + ", filename=" + filename + ", imgurl=" + imgurl + ", size=" + size + "]";
	}
	
	
	
	
}

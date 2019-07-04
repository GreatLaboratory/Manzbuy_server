package tk.manzbuy.admin.controller;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tk.manzbuy.admin.dto.ImageInfo;
import tk.manzbuy.admin.service.ImageInfoService;

@Controller
public class FileController {
	
	@Autowired
	ImageInfoService imageInfoService;
	
	@GetMapping(path = "/uploadform")
	public String uploadform() {
		return "uploadform";
	}

	@PostMapping(path = "/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		// 사용자가 업로드하려고 선택한 파일은 위에 있는 MultipartFile 객체로 전달이 된다.
		
		// 여기서부턴 업로드한 파일정보를 mysql db에다가 저장
		ImageInfo imageInfo = new ImageInfo();
		
		String imgurl = "/home/ubuntu/test-image/" + file.getOriginalFilename();
		
		imageInfo.setFilename(file.getOriginalFilename());
		imageInfo.setSize(file.getSize());
		imageInfo.setImgurl(imgurl);
		

		try (InputStream is = file.getInputStream();
				FileOutputStream fos = new FileOutputStream(imgurl)) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception e) {
			throw new RuntimeException("file save error");
		}
		
		imageInfoService.addImageInfo(imageInfo);
		
		// 여기서부턴 db에 저장된 정보를 json파일로 변환해서 페이지에 올려야함.
		
		return "uploadok";
	}
}

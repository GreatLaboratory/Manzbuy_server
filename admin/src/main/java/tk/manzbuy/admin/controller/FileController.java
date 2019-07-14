package tk.manzbuy.admin.controller;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tk.manzbuy.admin.dto.ImageInfo;
import tk.manzbuy.admin.service.ImageInfoService;

@Controller
public class FileController {

	@Autowired
	ImageInfoService imageInfoService;

	
	@PostMapping(path = "/upload")
	public ModelAndView upload(@RequestParam("files") MultipartFile file) {
		// 사용자가 업로드하려고 선택한 파일은 위에 있는 MultipartFile 객체로 전달이 된다.
		
		ModelAndView mv = new ModelAndView("/uploadok");
		
		// 업로드한 파일 정보를 ImageInfo dto에다가 넣고
		ImageInfo imageInfo = new ImageInfo();
		
		//로그인세션 문자열값으로 저장 디렉토리나눠서 저장하도록 하자 **
		//"/home/ubuntu/test-image/" 이건 정말 바보같은 url셋팅이다.....
		
//		<EC2서버에서의 설정코드>
//		String saveFolder = "/var/lib/tomcat8/webapps/admin/img/" + file.getOriginalFilename();
//		String imgurl = "www.manzbuy.tk/admin/img/" + file.getOriginalFilename();
		
		// <로컬에서의 테스트코드>
		String imgurl = "http://manzbuy.tk/admin/img/" + file.getOriginalFilename();
		String saveFolder = "C:/Users/GreatLaboratory/git/Manzbuy_server/admin/src/main/webapp/img/" + file.getOriginalFilename();
		
		imageInfo.setFilename(file.getOriginalFilename());
		imageInfo.setSize(file.getSize());
		imageInfo.setImgurl(imgurl);

		
		// 해당경로에 파일업로드
		try (InputStream is = file.getInputStream(); FileOutputStream fos = new FileOutputStream(saveFolder)) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception e) {
			throw new RuntimeException("file save error");
		}

		// 여기서 dto에 잘 넣어져 있는 필드값들을 똑같은 컬럼명으로 되어있는 테이블에 저장
		imageInfoService.addImageInfo(imageInfo);

		mv.addObject("imageInfo", imageInfo);
		
		
		
		return mv;
	}
}

package tk.manzbuy.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tk.manzbuy.admin.dto.AdminInfo;
import tk.manzbuy.admin.service.AdminInfoService;

@Controller
public class AdminController {

	@Autowired
	private AdminInfoService adminInfoService;

	@GetMapping(path = "/loginform")
	public String loginform() {
		// 따로 수행하는 메소드처리는 없고 그저 /loginform 이라고 url이 들어오면 loginform.jsp파일로 view정보를 보내주는 역할
		return "loginform";
	}

	@PostMapping(path = "/login")
	public String login(@RequestParam(name = "id", required = true) String id, // login페이지에서 id입력하면 넘어오는 입력값
			@RequestParam(name = "passwd", required = true) String passwd, // login페이지에서 password입력하면 넘어오는 입력값
			HttpSession session,
			RedirectAttributes redirectAttr) {

		List<AdminInfo> list = adminInfoService.getAdminInfos();
		// db에 있는 admininfo테이블에서 admin관리자들의 로그인정보를 dto형태로 전부 불러오기
		
		String view = "redirect:/loginform";
		
		for (int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getId().equals(id) && list.get(i).getPasswd().equals(passwd)) {
				// 로그인 성공했을 때
				session.setAttribute("adminWho", id);
				view = "uploadform";
				break;
			} 
			
			// 로그인 실패했을 때
			if(!list.get(i).getId().equals(id)) {
				redirectAttr.addFlashAttribute("errorMessage", "존재하지않는 아이디입니다.");
			} else if (list.get(i).getId().equals(id) && !list.get(i).getPasswd().equals(passwd)) {
				redirectAttr.addFlashAttribute("errorMessage", "비밀번호가 일치하지않습니다..");
				break;
			}
		}
		return view;
	}
}

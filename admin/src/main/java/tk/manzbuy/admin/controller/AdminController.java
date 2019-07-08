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
	AdminInfoService adminInfoService;

	@GetMapping(path = "/loginform")
	public String loginform() {
		// 따로 수행하는 메소드처리는 없고 그저 /loginform 이라고 url이 들어오면 loginform.jsp파일로 view정보를 보내주는
		// 역할
		return "loginform";
	}

	@PostMapping(path = "/login")
	public String login(@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "passwd", required = true) String passwd, HttpSession session,
			RedirectAttributes redirectAttr) {

		List<AdminInfo> list = adminInfoService.getAdminInfos();

		String view = "redirect:/loginform";
		
		for (int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getId().equals(id) && list.get(i).getPasswd().equals(passwd)) {
				session.setAttribute("adminWho", id);
				view = "uploadform";
				break;
			} 
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

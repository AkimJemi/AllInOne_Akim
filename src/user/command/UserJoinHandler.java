package user.command;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import pom.personnel.service.PersonnelService;
import user.model.License;
import user.model.User;
import user.service.UserService;

public class UserJoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/userForm.jsp";
	private UserService userService = new UserService();
	private PersonnelService personnelService = new PersonnelService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {

		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(rq, rp);

		} else if (rq.getMethod().equalsIgnoreCase("GET")) {
			return processForm(rq, rp);
		} else
			return rq.getParameter("");

	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {

		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		/*
		 * C:\Users\i\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\
		 * tmp0\wtpwebapps\POM \ upload
		 */

		Boolean reg_numCheck = userService.Reg_NumCheck(Integer.parseInt(rq.getParameter("reg_num")));
		try {
			if (!reg_numCheck) {
				rp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = rp.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('이미 등록된 회원입니다');");
				out.println("history.back();");
				out.println("</script>");
				return null;
			}
		} catch (Exception e) {
			System.out.println("error : UserJoinHandler.processSubmit()");
			System.out.println(e.getMessage());
		}

		String uploadPath = rq.getRealPath("upload/2022_상반기_증명사진");
		int size = 10 * 1024 * 1024; // byte
		String filename = "";
		String origfilename = "";
		Date disabled_day = null;
		Date school_out = null;
		int disabled_grade = 0;
		try {
//			MultipartRequest multi = new MultipartRequest(rq, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
//			Enumeration<String> files = multi.getFileNames();
//			String file = files.nextElement();
//			filename = multi.getFilesystemName(file);
//			origfilename = multi.getOriginalFileName(file);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			school_out = Datering(rq.getParameter("school_out"));
			if (rq.getParameter("disabled").trim().equals("Y")){
				disabled_grade = Integer.parseInt(rq.getParameter("disabled_grade"));
				String disabled_day_init = rq.getParameter("disabled_day");
				disabled_day = new Date(sdf.parse(disabled_day_init).getTime());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : UserJoinHandler.processSubmit()");
		}
		User user = new User(0, filename, origfilename, rq.getParameter("name"),
				Integer.parseInt(rq.getParameter("reg_num")), rq.getParameter("phone"), rq.getParameter("addr"),
				rq.getParameter("email"), rq.getParameter("school_name"), rq.getParameter("school_major"), school_out,
				Integer.parseInt(rq.getParameter("tall")), Integer.parseInt(rq.getParameter("weight")),
				rq.getParameter("eye_l"), rq.getParameter("eye_r"), rq.getParameter("gender"), rq.getParameter("marry"),
				rq.getParameter("disabled"), disabled_grade, disabled_day);

		Date license_day = null;
		Boolean result = userService.UserJoin(user);
		if (result) {
			user = userService.getUser(user, user.getReg_num());
			rq.setAttribute("readonly", Boolean.TRUE);
			rq.setAttribute("user", user);
			rq.setAttribute("img", filename);
			personnelService.AddPersonnel(user);
			ArrayList<License> licList = new ArrayList<License>();
			
			if (!rq.getParameter("license" + 1).equals("")) {
				for (int i = 1; i <= 5; i++) {
					if (rq.getParameter("license" + i) != null && !rq.getParameter("license" + i).equals("undefined")
							&& !rq.getParameter("license" + i).equals("")) {
						license_day = Datering(rq.getParameter("license_day" + i));
						licList.add(new License(user.getNo(), Integer.parseInt(rq.getParameter("lic_no" + i)),
								rq.getParameter("license" + i), license_day));
					}
				}
				licList = userService.InsertAllLic(licList);
				rq.setAttribute("license", licList);
			}
		} else {
			rq.setAttribute("insertError", Boolean.TRUE);
			return FORM_VIEW;
		}
		return FORM_VIEW;
	}

	private Date Datering( Object value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dating = null;
		try {
			String param = (String) value;
			dating = new Date(sdf.parse(param).getTime());
		} catch (Exception e) {
			System.out.println("error : Datering");
			System.out.println(e.getMessage());
		}
		return dating;
	}

}

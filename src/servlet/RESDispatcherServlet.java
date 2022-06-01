package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import res.container.Container;
import res.controller.AdminBookListHandler;
import res.dto.Member;

public class RESDispatcherServlet extends DispatcherServlet {
	@Override
	protected String doAction(HttpServletRequest rq, HttpServletResponse rp, String controllerName,
			String actionMethodName) {
		String rqUrl = rq.getRequestURI();
		String jspPath = null;
		System.out.println("controllerName : " + controllerName);
		System.out.println("actionMethodName : " + actionMethodName);
		String[] rqUrlBites = rqUrl.split("/");
		// project [1]
		// Controller [2]
		// method [3]
///res/login.do=res.admin.book.command.AdminBookHandler
///res/admin/main.do=res.admin.main.command.AdminMainHandler
///res/admin/member/list.do=res.admin.member.command.AdminMemberListHandler
///res/admin/   member/detail.do=res.admin.member.command.AdminMemberDetailHandler
///res/admin/book/insert.do=res.admin.book.command.AdminBookInsertHandler
///res/admin/book/list.do=res.admin.book.command.AdminBookListHandler
///res/admin/book/check_res/update.do=res.admin.book.command.AdminBookCheckResUpdateHandler
///mysql.do=mvc.command.MySQLHandler
		System.out.println(rqUrl);
		System.out.println("rqUrlBites.length : " + rqUrlBites.length);
//		System.out.println("rqUrlBites[0] : " + rqUrlBites[0]);
//		System.out.println("rqUrlBites[1] : " + rqUrlBites[1]);
//		System.out.println("rqUrlBites[2] : " + rqUrlBites[2]);
//		System.out.println("rqUrlBites[3] : " + rqUrlBites[3]);
		for (int i = 0; i < rqUrlBites.length; i++) {
			System.out.println(String.format("rqUrlBites[%s] : " + rqUrlBites[i], i));
		}

		if (rqUrlBites[3].equals("login.do")) {
			if (rq.getMethod().equalsIgnoreCase("GET")) {
				if (rq.getParameter("id") != null && rq.getParameter("password") != null)
					if (rq.getParameter("id").equals("admin") && rq.getParameter("password").equals("admin"))
						return "init/main";

				System.out.println("init/login");
				return "init/login";
			} else if (rq.getMethod().equalsIgnoreCase("POST")) {
				Member member = Container.loginService.login(rq.getParameter("id"), rq.getParameter("password"));
				HttpSession sesson = rq.getSession();
				sesson.setAttribute("logindedMember", member);
				return "init/main";
			}
		}
		System.out.println("test");
		if (rqUrlBites[2].equals("res")) {
			if (rqUrlBites[3].equals("main"))
				return "res/main";
			else if (rqUrlBites[3].equals("admin")) {
				if (rqUrlBites[4].equals("main"))
					return "res/admin/main";
				else if (rqUrlBites[4].equals("book"))
					if (rqUrlBites[5].equals("list")) {
						AdminBookListHandler adminBookListHandler = new AdminBookListHandler();
						jspPath = Container.adminBookListHandler.process(rq,rp);
						return jspPath;
					}
				if (rqUrlBites[4].equals("update"))
					System.out.println("update");
				else if (rqUrlBites[5].equals("delete.do"))
					System.out.println("delete");
				else if (rqUrlBites[5].equals("select.do"))
					System.out.println("select");
				else if (rqUrlBites[5].equals("detail.do"))
					System.out.println("detail");
				else if (rqUrlBites[5].equals("insert.do"))
					System.out.println("insert");

			} else if (rqUrlBites[3].equals("member")) {
				if (rqUrlBites[4].equals("book")) {

				}
				if (rqUrlBites[4].equals("member")) {

				}
			}
			if (rqUrlBites[4].equals("member")) {
			}
			return jspPath;
		}
		return jspPath;
	}
}

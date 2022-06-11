package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.container.Container;

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
		for (int i = 1; i < rqUrlBites.length; i++) {
			System.out.println(String.format("rqUrlBites[%s] : " + rqUrlBites[i], i));
		}

		if (rqUrlBites[3].equals("login.do")) {
			return Container.loginHandler.process(rq, rp);
		}
		if (rqUrlBites[2].equals("res")) {
			if (rqUrlBites[3].equals("main"))
				return "main";
			else if (rqUrlBites[3].equals("admin")) {
				if (rqUrlBites[4].equals("main"))
					return "admin/main";

				else if (rqUrlBites[4].equals("book")) {
					if (rqUrlBites[5].equals("list")) {
						return Container.adminBookListHandler.process(rq, rp);
					} else if (rqUrlBites[5].equals("check_res")) {
						if (rqUrlBites[6].equals("update.do"))
							return Container.adminBookCheckResUpdateHandler.process(rq, rp);
					}
				} else if (rqUrlBites[4].equals("member")) {
					if (rqUrlBites[5].equals("list")) {
						if (rqUrlBites.length == 6) {
							return Container.adminMemberListHandler.process(rq, rp);
						} else if (rqUrlBites[6].equals("check_res")) {
							if (rqUrlBites[7].equals("update.do")) {
								return Container.adminBookCheckResUpdateHandler.process(rq, rp);
							}
						}
					} else if (rqUrlBites[5].equals("insert")) {
						return Container.adminMemberInsertHandler.process(rq, rp);
					} else {
						return Container.adminMemberListHandler.process(rq, rp);
					}
				}
			} else if (rqUrlBites[3].equals("member")) {
				if (rqUrlBites[4].equals("login")) {
					return null;
				} else if (rqUrlBites[4].equals("main")) {
					if (rqUrlBites.length == 5)
						return Container.memberMainHandler.process(rq, rp);

				} else if (rqUrlBites[4].equals("product")) {
					if (rqUrlBites[5].equals("list"))
						return Container.memberProductListHandler.process(rq, rp);
				}
			}
		}
		return null;
	}
}

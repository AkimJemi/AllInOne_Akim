package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RESDispatcherServlet extends DispatcherServlet {

	@Override
	protected String doAction(HttpServletRequest rq, HttpServletResponse resp, String controllerName,
			String actionMethodName) {
		String rqUrl = rq.getRequestURI();

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
		System.out.println("rqUrlBites[0] : " + rqUrlBites[0]);
		System.out.println("rqUrlBites[1] : " +rqUrlBites[1]);
		System.out.println("rqUrlBites[2] : " +rqUrlBites[2]);
		System.out.println("rqUrlBites[3] : " +rqUrlBites[3]);

		if (rqUrlBites[3].equals("login.do")) {
			System.out.println("test");
			return "init/login";
			
		}
		
			
		if (rqUrlBites[3].equals("admin")) {
			if (rqUrlBites[4].equals("book")) {
				if (rqUrlBites[5].equals("list.do"))
					System.out.println("insert");
				else if (rqUrlBites[5].equals("update.do"))
					System.out.println("insert");
				else if (rqUrlBites[5].equals("delete.do"))
					System.out.println("insert");
				else if (rqUrlBites[5].equals("select.do"))
					System.out.println("insert");
				else if (rqUrlBites[5].equals("detail.do"))
					System.out.println("insert");
				else if (rqUrlBites[5].equals("insert.do"))
					System.out.println("insert");
			}
			if (rqUrlBites[4].equals("member")) {

			}
		} else if (rqUrlBites[3].equals("member")) {
			if (rqUrlBites[4].equals("book")) {

			}
			if (rqUrlBites[4].equals("member")) {

			}
		}
		return null;
	}
}

package res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class AdminBookHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {
		String rqUrl = rq.getRequestURI();

		String[] rqUrlBites = rqUrl.split("/");
		// project [1]
		// Controller [1]
		// method [2]
		System.out.println(rqUrl);
		System.out.println(rqUrlBites);

		System.out.println(rqUrlBites[0]);
		System.out.println(rqUrlBites[1]);
		System.out.println(rqUrlBites[2]);
		System.out.println(rqUrlBites[3]);

		if (rqUrlBites[3].equals("login.do"))
			System.out.println("login");
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

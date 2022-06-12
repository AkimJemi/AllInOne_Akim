package servlet;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import jdbc.Util;

public abstract class DispatcherServlet extends HttpServlet {
	static String jdbcUrl;

	@Override
	public void init() throws ServletException {
		RESDBCPInitListener();
	}

	@Override
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		run(rq, rp);
	}

	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		doGet(rq, rp);
	}

	public void run(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		Map<String, Object> doBeforeActionRs = doBeforeAction(rq, rp);

		if (doBeforeActionRs == null) {
			return;
		}

		String jspPath = doAction(rq, rp, (String) doBeforeActionRs.get("controllerName"),
				(String) doBeforeActionRs.get("actionMethodName"));

		if (jspPath == null) {
			jspPath = "/common/jspNullPath.jsp";
//			rp.getWriter().append("jsp 정보가 없습니다.");
//			return "NullJspPath.jsp";

		}

		doAfterAction(rq, rp, jspPath);
	}

	private Map<String, Object> doBeforeAction(HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		rq.setCharacterEncoding("UTF-8");
		rp.setContentType("text/html; charset=UTF-8");

		if (!Util.getJdbcUrl().contains("akim_res")) {
			RESDBCPInitListener();
		}

		String rquestUri = rq.getRequestURI();
		String[] rquestUriBits = rquestUri.split("/");

		int minBitsCount = 4;
//
//		if (App.isProductMode()) {
//			minBitsCount = 4;
//		}

		if (rquestUriBits.length < minBitsCount) {
			rp.getWriter().append("올바른 요청이 아닙니다.");
			return null;
		}

//		if (App.isProductMode()) {
//			MysqlUtil.setDBInfo("127.0.0.1", "root", "", "jspCommunityReal");
//		} else {
//			MysqlUtil.setDBInfo("127.0.0.1", "root", "", "jspCommunity");
//			MysqlUtil.setDevMode(true);
//		}
//
		int controllerTypeNameIndex = 1;
		int controllerNameIndex = 2;
		int actionMethodNameIndex = 3;
//
//		if (App.isProductMode()) {
//			controllerTypeNameIndex = 1;
//			controllerNameIndex = 2;
//			actionMethodNameIndex = 3;
//		}

		String controllerTypeName = rquestUriBits[controllerTypeNameIndex];
		String controllerName = rquestUriBits[controllerNameIndex];
		String actionMethodName = rquestUriBits[actionMethodNameIndex];
//
		String actionUrl = "/" + controllerTypeName + "/" + controllerName + "/" + actionMethodName;
//
//		// 데이터 추가 인터셉터 시작
//		boolean isLogined = false;
//		int loginedMemberId = 0;
//		Member loginedMember = null;
//
//		HttpSession session = rq.getSession();
//
//		if (session.getAttribute("loginedMemberId") != null) {
//			isLogined = true;
//			loginedMemberId = (int) session.getAttribute("loginedMemberId");
//			loginedMember = Container.memberService.getMemberById(loginedMemberId);
//		}
//
//		rq.setAttribute("isLogined", isLogined);
//		rq.setAttribute("loginedMemberId", loginedMemberId);
//		rq.setAttribute("loginedMember", loginedMember);
//
//		String currentUrl = rq.getRequestURI();
//
//		if (rq.getQueryString() != null) {
//			currentUrl += "?" + rq.getQueryString();
//		}

//		String encodedCurrentUrl = Util.getUrlEncoded(currentUrl);
//
//		rq.setAttribute("currentUrl", currentUrl);
//		rq.setAttribute("encodedCurrentUrl", encodedCurrentUrl);
//		
//		Map<String, Object> param = Util.getParamMap(rq);
//		String paramJson = Util.getJsonText(param);
//		
//		rq.setAttribute("paramMap", param);
//		rq.setAttribute("paramJson", paramJson);

		// 데이터 추가 인터셉터 끝

		// 로그인 필요 필터링 인터셉터 시작
		List<String> needToLoginActionUrls = new ArrayList<>();

		needToLoginActionUrls.add("/usr/member/doLogout");
		needToLoginActionUrls.add("/usr/member/modify");
		needToLoginActionUrls.add("/usr/member/doModify");
		needToLoginActionUrls.add("/usr/article/write");
		needToLoginActionUrls.add("/usr/article/doWrite");
		needToLoginActionUrls.add("/usr/article/modify");
		needToLoginActionUrls.add("/usr/article/doModify");
		needToLoginActionUrls.add("/usr/article/doDelete");

		needToLoginActionUrls.add("/usr/reply/doWrite");
		needToLoginActionUrls.add("/usr/reply/modify");
		needToLoginActionUrls.add("/usr/reply/doModify");
		needToLoginActionUrls.add("/usr/reply/doDelete");

//		if (needToLoginActionUrls.contains(actionUrl)) {
//			if ((boolean) rq.getAttribute("isLogined") == false) {
//				rq.setAttribute("alertMsg", "로그인 후 이용해주세요.");
//				rq.setAttribute("replaceUrl", "../member/login?afterLoginUrl=" + encodedCurrentUrl);
//
//				RequestDispatcher rd = rq.getRequestDispatcher(getJspDirPath() + "/common/redirect.jsp");
//				rd.forward(rq, rp);
//			}
//		}
		// 로그인 필요 필터링 인터셉터 끝

		// 로그아웃 필요 필터링 인터셉터 시작
		List<String> needToLogoutActionUrls = new ArrayList<>();

		needToLogoutActionUrls.add("/usr/member/login");
		needToLogoutActionUrls.add("/usr/member/doLogin");
		needToLogoutActionUrls.add("/usr/member/join");
		needToLogoutActionUrls.add("/usr/member/doJoin");
		needToLogoutActionUrls.add("/usr/member/findLoginId");
		needToLogoutActionUrls.add("/usr/member/doFindLoginId");
		needToLogoutActionUrls.add("/usr/member/findLoginPw");
		needToLogoutActionUrls.add("/usr/member/doFindLoginPw");

		if (needToLogoutActionUrls.contains(actionUrl)) {
			if ((boolean) rq.getAttribute("isLogined")) {
				rq.setAttribute("alertMsg", "로그아웃 후 이용해주세요.");
				rq.setAttribute("historyBack", true);

				RequestDispatcher rd = rq.getRequestDispatcher(prefix() + "/common/redirect.jsp");
				rd.forward(rq, rp);
			}
		}

		// 로그아웃 필요 필터링 인터셉터 끝
		Map<String, Object> rs = new HashMap<>();
		rs.put("controllerName", controllerName);
		rs.put("actionMethodName", actionMethodName);

		return rs;
	}

	protected abstract String doAction(HttpServletRequest rq, HttpServletResponse rp, String controllerName,
			String actionMethodName);

	private void doAfterAction(HttpServletRequest rq, HttpServletResponse rp, String jspPath)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (jspPath.contains("init"))
			rd = rq.getRequestDispatcher(initPrefix() + jspPath + suffix());
		else if (jspPath.contains("common"))
			rd = rq.getRequestDispatcher(jspPath);
		else
			rd = rq.getRequestDispatcher(prefix() + jspPath + suffix());

		rd.forward(rq, rp);
	}

	private String prefix() {
		return "/WEB-INF/res/";
	}

	private String initPrefix() {
		return "/WEB-INF/";
	}

	private String suffix() {
		return ".jsp";
	}

	protected void RESDBCPInitListener() {
		ServletContextEvent sce = new ServletContextEvent(getServletContext());
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException("config load fail", e);
		}
		loadJDBCDriver(prop);
		initConnection(prop);
	}

	private void loadJDBCDriver(Properties prop) {
		String driverClass = prop.getProperty("jdbcdriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnection(Properties prop) {
		try {
			jdbcUrl = prop.getProperty("jdbcUrl");
			Util.setJdbcUrl(jdbcUrl);
			String username = prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");

			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactroy = new PoolableConnectionFactory(connFactory, null);
			String validationQuery = prop.getProperty("validationQuery");
			if (validationQuery != null && !validationQuery.isEmpty()) {
				poolableConnFactroy.setValidationQuery(validationQuery);
			}

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(10001 * 601 * 5L);
			poolConfig.setTestWhileIdle(true);
			int minIdle = getIntProperty(prop, "minIdle", 5);
			poolConfig.setMinIdle(minIdle);
			int maxTotal = getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);

			GenericObjectPool<PoolableConnection> connentionPool = new GenericObjectPool<>(poolableConnFactroy,
					poolConfig);
			poolableConnFactroy.setPool(connentionPool);

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

			String poolName = prop.getProperty("poolName");
			driver.registerPool(poolName, connentionPool);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	private int getIntProperty(Properties prop, String propName, int defaultValue) {
		String value = prop.getProperty(propName);
		if (value == null)
			return defaultValue;
		return Integer.parseInt(value);
	}

}

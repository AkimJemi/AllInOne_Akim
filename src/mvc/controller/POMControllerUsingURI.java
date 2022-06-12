package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;
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
import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class POMControllerUsingURI extends HttpServlet {
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	private String viewPage;
	static String jdbcUrl;

	@Override
	public void init() throws ServletException {
		POMDBCPInitListener();
		String configFile = getInitParameter("configFile"); // /WEB-INF/commandHandlerURI.properties
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		System.out.println("configFilePath : " + configFilePath);
		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			System.out.println("command : " + command);
			String handlerClassName = prop.getProperty(command);
			System.out.println("handlerClassName : " + handlerClassName);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				System.out.println("handlerClass : " + handlerClass);
				CommandHandler handlerinstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerinstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}

		}
		
	}

	@Override
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		run(rq, rp);

	}

	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		run(rq, rp);
	}

	private void run(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		beforeProcess(rq, rp);
		if (process(rq, rp) != null)
			afterProcess(rq, rp);
	}

	private void beforeProcess(HttpServletRequest rq, HttpServletResponse rp) {
		if(!Util.getJdbcUrl().contains("pom")) {
			POMDBCPInitListener();
		}
		
	}

	private void afterProcess(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		viewPage = viewPage + ".jsp";
		if (viewPage.contains("init"))
			viewPage = pathInit() + viewPage;
		else if (viewPage.contains("common/redirect")) {
		} else
			viewPage = path() + viewPage;

		dispatcher = rq.getRequestDispatcher(viewPage);
		dispatcher.forward(rq, rp);

	}

	private String path() {
		String path = "/WEB-INF/pom/";
		return path;
	}

	private String pathInit() {
		String path = "/WEB-INF/";
		return path;
	}

	private String process(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String command = rq.getRequestURI();
		if (command.indexOf(rq.getContextPath()) == 0)
			command = command.substring(rq.getContextPath().length());

		CommandHandler handler = commandHandlerMap.get(command);

		if (handler == null)
			handler = new NullHandler();

		try {
			viewPage = handler.process(rq, rp);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		if (viewPage != null)
			return viewPage;
		else
			return null;
	}

	private void POMDBCPInitListener() {
		ServletContextEvent sce = new ServletContextEvent(getServletContext());
		String poolConfig = sce.getServletContext().getInitParameter("POM_poolConfig");
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
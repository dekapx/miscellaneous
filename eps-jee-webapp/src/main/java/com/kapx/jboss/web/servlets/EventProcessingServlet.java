package com.kapx.jboss.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kapx.jboss.web.beans.EventInputHandler;
import com.kapx.jboss.web.manager.CdiJeeInstanceManager;
import com.kapx.jboss.web.util.EventInputHandlerCdiUtil;

@WebServlet(name = "EventProcessingServlet", urlPatterns = { "/EventProcessingServlet" })
public class EventProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CdiJeeInstanceManager cdiInstanceManager;

	@Inject
	private Event<Object> events;

	public EventProcessingServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.write("TestServlet");

		EventInputHandlerCdiUtil cdiUtil = cdiInstanceManager.getBeanInstanceByClass(EventInputHandlerCdiUtil.class);

		EventInputHandler handler = null;
		handler = cdiUtil.getBeanByName("splitter");
		writer.write("\nbean instance for id splitter = " + handler);
		handler.onEvent("test event - 1");

		handler = cdiUtil.getBeanByName("batch");
		writer.write("\nbean instance for id batch = " + handler);
		handler.onEvent("test event - 2");

		events.fire("test-event for observers...");

		writer.close();
	}

}

package com.angular_vs_aurelia.ngular_vs_aurelia.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.angular_vs_aurelia.ngular_vs_aurelia.ui.utils.CookiesUtils;

@Controller
public abstract class BaseController {

	@ModelAttribute
	protected void putReferenceData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> getRootUrl(request): " +  getRootUrl(request));
		model.put("contextPath", getRootUrl(request) + "/");
		model.put("staticPath", getRootUrl(request) + "/s/");
		model.put("scriptsPath", "s/js/" + CookiesUtils.getScriptsPath(request));
	}
	
	private String getRootUrl(HttpServletRequest request){
		int index = request.getRequestURL().indexOf(request.getContextPath());
		return request.getRequestURL().substring(0, index) + request.getContextPath();
	}
}

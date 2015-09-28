package com.angular_vs_aurelia.ngular_vs_aurelia.ui.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class CookiesUtils {

	public static Cookie getCookie(String cookieName, Cookie[] cookies) {
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(cookieName)){
				return cookie;
			}
		}
		return null;
	}

	public static ModelAndView getModelAndView(HttpServletRequest request) {
		return (ModelAndView) performIfCookieMatch(request, new ExactCookieFactory(){

			@Override
			public Object performIfNg1(HttpServletRequest request) {
				return new ModelAndView("angular1");
			}

			@Override
			public Object performIfNg2(HttpServletRequest request) {
				return new ModelAndView("angular2");
			}

			@Override
			public Object performIfAur(HttpServletRequest request) {
				return new ModelAndView("aurelia");
			}
		});
	}
	
	public static String getScriptsPath(HttpServletRequest request) {
		return (String) performIfCookieMatch(request, new ExactCookieFactory(){

			@Override
			public Object performIfNg1(HttpServletRequest request) {
				return "ng1/";
			}

			@Override
			public Object performIfNg2(HttpServletRequest request) {
				return "ng2/";
			}

			@Override
			public Object performIfAur(HttpServletRequest request) {
				return "aur/";
			}
		});
	}
	
	private static Object performIfCookieMatch(HttpServletRequest request, ExactCookieFactory exactCookieFactory) {
		Cookie frameTypeCookie = CookiesUtils.getCookie("framework_type", request.getCookies());
		if (frameTypeCookie != null && frameTypeCookie.getValue() != null) {
			if (frameTypeCookie.getValue().equals("angular2")) {
				return exactCookieFactory.performIfNg2(request);  
			} else if (frameTypeCookie.getValue().equals("angular1")) {
				return exactCookieFactory.performIfNg1(request);  
			} else if (frameTypeCookie.getValue().equals("aurelia")) {
				return exactCookieFactory.performIfAur(request);  
			} else {
				return new ModelAndView("home");
			}
		} else {
			return new ModelAndView("home");			
		}
	}
}

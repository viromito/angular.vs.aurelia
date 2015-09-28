package com.angular_vs_aurelia.ngular_vs_aurelia.ui.utils;

import javax.servlet.http.HttpServletRequest;

public interface ExactCookieFactory {

	public Object performIfNg1(HttpServletRequest request);
	
	public Object performIfNg2(HttpServletRequest request);
	
	public Object performIfAur(HttpServletRequest request);
}

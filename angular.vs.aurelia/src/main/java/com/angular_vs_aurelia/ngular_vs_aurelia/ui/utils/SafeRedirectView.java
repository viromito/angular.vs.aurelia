package com.angular_vs_aurelia.ngular_vs_aurelia.ui.utils;

import org.springframework.web.servlet.view.RedirectView;

public class SafeRedirectView extends RedirectView{

	/**
	 * Create a new RedirectView with the given URL.
	 * <p>
	 * The given URL will be considered as relative to the web server, not as
	 * relative to the current ServletContext.
	 * 
	 * @param url
	 *            the URL to redirect to
	 */
	public SafeRedirectView(String url) {
		super(url, false, true, false);
	}

	/**
	 * Create a new RedirectView with the given URL.
	 * 
	 * @param url
	 *            the URL to redirect to
	 * @param contextRelative
	 *            whether to interpret the given URL as relative to the current
	 *            ServletContext
	 */
	public SafeRedirectView(String url, boolean contextRelative) {
		super(url, contextRelative, true, false);
	}
}

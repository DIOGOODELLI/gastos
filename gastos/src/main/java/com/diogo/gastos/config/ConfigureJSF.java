package com.diogo.gastos.config;

import java.util.Locale;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ConfigureJSF implements ServletContextInitializer {

	private static final String LANGUAGE = "language";
	private static final String XHTML = "*.xhtml";
	private static final String FACES_SERVLET = "FacesServlet";
	private static final String PRIME_FACES_FILE_UPLOAD_FILTER = "PrimeFaces FileUpload Filter";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
		servletContext.setInitParameter("primefaces.UPLOADER", "commons");
	}

	@Bean
	public FilterRegistrationBean<FileUploadFilter> FileUploadFilter() {
		FilterRegistrationBean<FileUploadFilter> registration = new FilterRegistrationBean<FileUploadFilter>();
		registration.setFilter(new org.primefaces.webapp.filter.FileUploadFilter());
		registration.setName(PRIME_FACES_FILE_UPLOAD_FILTER);
		return registration;
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> facesServlet() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>(servlet, XHTML);
		registration.setName(FACES_SERVLET);
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.getDefault());
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName(LANGUAGE);
		return localeChangeInterceptor;
	}

}
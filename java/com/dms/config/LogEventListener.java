/*
 * package com.dms.config;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.ApplicationEvent; import
 * org.springframework.context.ApplicationListener; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class LogEventListener implements
 * ApplicationListener<ApplicationEvent> {
 * 
 * @Value("app.name") private String appName;
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(LogEventListener.class);
 * 
 * @Override public void onApplicationEvent(ApplicationEvent event) {
 * 
 * Object enventObj = event.getSource(); // Check if the event is a Logback //
 * Perform actions based on the log event
 * logger.info("Received a log event: {} ", event.toString()); } }
 */
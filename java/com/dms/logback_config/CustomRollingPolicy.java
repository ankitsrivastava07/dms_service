/*
 * package com.dms.logback_config;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import ch.qos.logback.core.rolling.RollingFileAppender; import
 * ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
 * 
 * @Component public class CustomRollingPolicy<E> extends
 * TimeBasedRollingPolicy<E> {
 * 
 * @Autowired private RollingFileAppender<E> appender;
 * 
 * Logger logger = LoggerFactory.getLogger("");
 * 
 * @Override public void rollover() {
 * 
 * logger.info("" + appender.getFile());
 * 
 * // Custom logic before rollover System.out.println("Before rollover event");
 * 
 * // Call the base class rollover method super.rollover();
 * 
 * // Custom logic after rollover System.out.println("After rollover event");
 * 
 * // You can also access the appender and perform additional actions if
 * (appender != null) { // Example: appender.getFile(); } } }
 */
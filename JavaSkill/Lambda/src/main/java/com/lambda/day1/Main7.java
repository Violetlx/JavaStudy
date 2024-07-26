package com.lambda.day1;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

/**
 * 03-函数对象-延迟执行
 * @author lixuan
 * @Date 2024/7/18 10:52
 */
public class Main7 {
    static Logger logger = init(Level.INFO);

    public static void main(String[] args) {
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", expensive());
        }*/

        // expensive() 立刻执行
        //logger.debug("{}", expensive());

        // 函数对象使得 expensive 延迟执行
        logger.debug("{}", () -> expensive());

    }

    static String expensive() {
        System.out.println("执行耗时操作...");
        return "日志";
    }

    static Logger init(Level level) {
        System.out.println("初始化日志...");
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        // 设置全局日志级别
        builder.setStatusLevel(level);

        // 定义控制台输出 appender
        AppenderComponentBuilder consoleAppender = builder.newAppender("Stdout", "CONSOLE")
                .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        // 定义日志格式
        consoleAppender.add(builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));

        // 添加 appender 到配置
        builder.add(consoleAppender);

        // 设置 root logger
        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(level)
                .add(builder.newAppenderRef("Stdout"));

        builder.add(rootLogger);

        // 初始化配置
        Configurator.initialize(builder.build());

        // 获取 Logger 实例
        return LogManager.getLogger();
    }
}

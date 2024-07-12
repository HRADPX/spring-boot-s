package com.kuaishou.springboot.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-18
 */
public class TomcatTest {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        Connector connector = new Connector("HTTP/1.1");
        connector.setPort(8080);
        tomcat.setConnector(connector);

        tomcat.start();
        tomcat.getServer().await();
    }
}

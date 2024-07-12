package com.kuaishou.springboot.runner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.value.ValueImport;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-19
 */
@Component
public class ValueRunner implements CommandLineRunner, EnvironmentAware {

    @Autowired
    private ValueImport valueImport;

    private Environment environment;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ValueImport.type);
        System.out.println("applicationName:" + environment.getProperty("spring.application.name"));

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {


        String s = "${background-replace-11}";

        System.out.println(StringUtils.substring(s, 2, s.length() - 1));

        System.out.println(getBlobStoreFromCdnUrl("https://blobstore-nginx.staging.kuaishou"
                + ".com/bs2/growth-material/8050cfbced11006301d69fbe6e4bf57b.jpg"));
    }

    public static String getBlobStoreFromCdnUrl(String cdnUrl) {
        if (StringUtils.isEmpty(cdnUrl)) {
            return StringUtils.EMPTY;
        }
        int index = StringUtils.lastIndexOf(cdnUrl, "/");
        if (index == -1) {
            return StringUtils.EMPTY;
        }
        return StringUtils.substring(cdnUrl, index + 1);
    }
}

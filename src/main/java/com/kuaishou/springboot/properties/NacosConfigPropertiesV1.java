package com.kuaishou.springboot.properties;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-10-13
 */
public class NacosConfigPropertiesV1 {

    private String name;

    private boolean useCluster;

    private int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUseCluster() {
        return useCluster;
    }

    public void setUseCluster(boolean useCluster) {
        this.useCluster = useCluster;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "NacosConfigProperties{" +
                "name='" + name + '\'' +
                ", useCluster=" + useCluster +
                ", port=" + port +
                '}';
    }
}

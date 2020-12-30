package com.jachs.database.config.multiple;

import java.util.concurrent.CopyOnWriteArrayList;

/***
 *  DataSourceType
 *  @author zhanchaohan
 */
public enum  DataSourceType {

    READ("SLAVE", "从库"),
    WRITE("MASTER", "主库");

    public static final  String SLAVE = "c3p0";
    public static final  String SLAVE_0 = "dbcpSource";
    public static final  String MASTER = "druidDataSource";

    // 存放多个从库　key  用于做负载均衡
    public static CopyOnWriteArrayList<String> slaveDataSources = new CopyOnWriteArrayList<>();

    static {
        slaveDataSources.add(SLAVE);
        slaveDataSources.add(SLAVE_0);
    }

    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 　获取从库　数据源信息
     * @param number
     */
   public static String getSlave(Integer number){
       return slaveDataSources.get(number);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
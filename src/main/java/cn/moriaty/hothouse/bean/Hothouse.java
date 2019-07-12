package cn.moriaty.hothouse.bean;

import java.util.List;

/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/20 9:04
 * @Description TODO
 *   温室表 Bean
 */
public class Hothouse {
    private String ID;
    private String name;
    private String user;
    private String time;
    private String desc;
    private List<HothouseData> data;

    @Override
    public String toString() {
        return "Hothouse{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", time='" + time + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<HothouseData> getData() {
        return data;
    }

    public void setData(List<HothouseData> data) {
        this.data = data;
    }
}

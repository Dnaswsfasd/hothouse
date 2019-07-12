package cn.moriaty.hothouse.bean;
/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/20 9:04
 * @Description TODO
 *   用户表 Bean
 */
public class User {
    private String account;
    private String name;
    private Integer sex;
    private String phone;
    private String mailbox;

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}

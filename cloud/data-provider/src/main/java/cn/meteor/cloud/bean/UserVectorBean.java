package cn.meteor.cloud.bean;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.bean
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 15:59
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 15:59
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
/**
 * User实体类
 * @author Administrator
 *
 */
public class UserVectorBean {

    private int id;
    private int userid;
    private String stablevector;
    private String currentvector;
    private String intendedvector;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStablevector() {
        return stablevector;
    }

    public void setStablevector(String stablevector) {
        this.stablevector = stablevector;
    }

    public String getCurrentvector() {
        return currentvector;
    }

    public void setCurrentvector(String currentvector) {
        this.currentvector = currentvector;
    }

    public String getIntendedvector() {
        return intendedvector;
    }

    public void setIntendedvector(String intendedvector) {
        this.intendedvector = intendedvector;
    }

    @Override
    public String toString() {
        return "UserVectorBean{" +
                "id=" + id +
                ", userid=" + userid +
                ", stablevector='" + stablevector + '\'' +
                ", currentvector='" + currentvector + '\'' +
                ", intendedvector='" + intendedvector + '\'' +
                '}';
    }
}
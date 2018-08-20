package cn.meteor.cloud.bean;

/**
 * @ProjectName: crawler-provider
 * @Description: 新闻分类类
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 15:59
 * @Version: 1.0.0
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * 新闻类型类
 * @author David Zhang
 *
 */
public class CategoryBean implements Serializable {

    private long id;
    private String categoryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
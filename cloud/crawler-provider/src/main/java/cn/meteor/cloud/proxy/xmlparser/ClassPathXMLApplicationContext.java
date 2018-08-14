package cn.meteor.cloud.proxy.xmlparser;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClassPathXMLApplicationContext {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    List<CrawlerDefine> beanList = new ArrayList<CrawlerDefine>();

    /**
     * 读取Bean配置文件
     * @param fileName
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<CrawlerDefine> readXML(String fileName) {
        Document document = null;
        SAXReader saxReader = new SAXReader();
        try {
            ClassLoader classLoader =
                    Thread.currentThread().getContextClassLoader();
            document = saxReader.read(classLoader.getResourceAsStream(fileName));
            Element beans = document.getRootElement();
            for (Iterator<Element> beansList = beans.elementIterator();
                 beansList.hasNext();) {
                CrawlerDefine bean = new CrawlerDefine();
                Element element = beansList.next();
                for (Iterator<Element> paramURLList = element.elementIterator();
                     paramURLList.hasNext();) {
                    Element paramURL = paramURLList.next();
                    LOG.info("url:{}",paramURL.attributeValue("url"));
                    String regx = "@[A-Za-z]+_[A-Za-z]+_[A-Za-z]+@";
                    Pattern pattern = Pattern.compile(regx);
                    // 现在创建 matcher 对象
                    String url = paramURL.attributeValue("url");
                    bean.setUrl(url);
                    Matcher matcher = pattern.matcher(url);
                    Map<String,String> keys = new HashMap<>();
                    while (matcher.find( )) {
                        System.out.println("Found value: " + matcher.group(0) );
                        String originVal = matcher.group(0);
                        String[] val = originVal.substring(1,matcher.group(0).length()-1).split("_");
                        keys.put(val[0],originVal);
                    }
                    List<Map<String,String>> paramsList = new ArrayList<>();
                    for (Iterator<Element> paramList = paramURL.elementIterator();
                         paramList.hasNext();) {
                        Element param = paramList.next();
                        Map<String,String> paramMap = new HashMap<>();
                        for(Map.Entry<String,String> key:keys.entrySet()){
                            if(!key.getValue().contains("_str_")){
                                paramMap.put(key.getValue(),null);
                                continue;
                            }
                            String val = param.attributeValue(key.getKey());
                            paramMap.put(key.getValue(),val);
                            LOG.info("paramkey:{},val:{}",key.getKey(),val);
                        }
                        paramsList.add(paramMap);
                    }
                    bean.setParamList(paramsList);
                    break;
                }
                bean.setClassName(element.attributeValue("class"));
                bean.setId(element.attributeValue("id"));
                beanList.add(bean);
            }
        } catch (DocumentException e) {
            LOG.error("读取配置文件出错....{}",fileName);
            e.printStackTrace();
        }
        return beanList;
    }

}
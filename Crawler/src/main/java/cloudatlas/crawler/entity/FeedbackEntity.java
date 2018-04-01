package cloudatlas.crawler.entity;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @author zhangqi
 * @date 2017年12月11日 下午1:39:45
 * @version V1.0
 * @说明:
 */
public class FeedbackEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1169473819794792722L;

	private Long id;

	private String crawlTime;
	private String publishDate;
	private String status;
	private String title;
	private String otherStatus;
	private String nickname;

	private String href;
	private String phoneModel;
	private String version;
	private String UIversion;
	private String module;
	private String typeOfFeedback;
	private String typeOfDemand;
	private String demandDescription;
	private String demandScene;
	private String demandValue;

	private String infoSource;

	private String md5;
	
	@Override
    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put("id", this.id);
        obj.put("publishDate", this.publishDate);
        obj.put("status", this.status);
        obj.put("title", this.title);
        obj.put("otherStatus", this.otherStatus);
        obj.put("nickname", this.nickname);
        obj.put("href", this.href);
        obj.put("phoneModel", this.phoneModel);
        obj.put("version", this.version);
        obj.put("UIversion", this.UIversion);
        obj.put("module", this.module);
        obj.put("typeOfFeedback", this.typeOfFeedback);
        obj.put("typeOfDemand", this.typeOfDemand);
        obj.put("demandDescription", this.demandDescription);
        obj.put("demandScene", this.demandScene);
        obj.put("demandValue", this.demandValue);
        obj.put("infoSource", this.infoSource);
        return obj.toString();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCrawlTime() {
		return crawlTime;
	}

	public void setCrawlTime(String crawlTime) {
		this.crawlTime = crawlTime;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOtherStatus() {
		return otherStatus;
	}

	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUIversion() {
		return UIversion;
	}

	public void setUIversion(String uIversion) {
		UIversion = uIversion;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getTypeOfFeedback() {
		return typeOfFeedback;
	}

	public void setTypeOfFeedback(String typeOfFeedback) {
		this.typeOfFeedback = typeOfFeedback;
	}

	public String getTypeOfDemand() {
		return typeOfDemand;
	}

	public void setTypeOfDemand(String typeOfDemand) {
		this.typeOfDemand = typeOfDemand;
	}

	public String getDemandDescription() {
		return demandDescription;
	}

	public void setDemandDescription(String demandDescription) {
		this.demandDescription = demandDescription;
	}

	public String getDemandScene() {
		return demandScene;
	}

	public void setDemandScene(String demandScene) {
		this.demandScene = demandScene;
	}

	public String getDemandValue() {
		return demandValue;
	}

	public void setDemandValue(String demandValue) {
		this.demandValue = demandValue;
	}

	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	
}
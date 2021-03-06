package cn.meteor.centauri.alpha.returnmsg;

/**
 * @ProjectName: data-provider
 * @Description: 返回消息统一定义
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 15:35
 * @Version: 1.0.0
 */
public class ReturnMsg {
    private String errorMsg;
    private double accuracy;
    private String modelName;
    public static class Builder {
        private String errorMsg;
        private double accuracy;
        private String modelName;

        public Builder setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }
        public Builder setAccuracy(double accuracy) {
            this.accuracy = accuracy;
            return this;
        }
        public Builder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }
        public ReturnMsg build(){
            return new ReturnMsg(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "errorMsg:'" + errorMsg + '\'' +
                ", accuracy:" + accuracy +
                ", modelName:'" + modelName + '\'' +
                '}';
    }

    public ReturnMsg(Builder builder){
        this.errorMsg = builder.errorMsg;
        this.accuracy = builder.accuracy;
        this.modelName = builder.modelName;
    }
    enum ResultEnum{
        SUCCESS("success",0),
        ERROR("error",1);

        public String value;
        private int index;
        private ResultEnum(String value, int index) {
            this.value = value;
            this.index = index;
        }

        public static String getValue(int index) {
            for (ResultEnum c : ResultEnum.values()) {
                if (c.getIndex() == index) {
                    return c.value;
                }
            }
            return null;
        }

        public static ResultEnum getEnum(String value){
            for (ResultEnum c : ResultEnum.values()) {
                if (c.value.equals(value)) {
                    return c;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }
        }
}

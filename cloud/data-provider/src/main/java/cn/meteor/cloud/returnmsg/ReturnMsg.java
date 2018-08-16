package cn.meteor.cloud.returnmsg;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.returnmsg
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 15:35
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 15:35
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ReturnMsg {
    private String errorMsg;
    private double accuracy;
    public static class Builder {
        private String errorMsg;
        private double accuracy;

        public Builder setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }
        public Builder setAccuracy(double accuracy) {
            this.accuracy = accuracy;
            return this;
        }
        public ReturnMsg build(){
            return new ReturnMsg(this);
        }
    }

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public ReturnMsg(Builder builder){
        this.errorMsg = builder.errorMsg;
        this.accuracy = builder.accuracy;
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

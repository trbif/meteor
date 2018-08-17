package cn.meteor.cloud.train;

import java.util.Objects;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:11
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 16:11
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class W2VParams {
    private int vectorDim;
    public static class Builder {
        private int vectorDim = 50;

        public Builder setVectorDim(int vectorDim) {
            this.vectorDim = vectorDim;
            return this;
        }
        public W2VParams build(){
            return new W2VParams(this);
        }
    }


    public W2VParams(Builder builder){
        this.vectorDim = builder.vectorDim;
    }

    public int getVectorDim() {
        return vectorDim;
    }

    @Override
    public String toString() {
        return "W2VParams{" +
                "vectorDim=" + vectorDim +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof W2VParams)) return false;
        W2VParams params = (W2VParams) o;
        return vectorDim == params.vectorDim;
    }

    @Override
    public int hashCode() {

        return Objects.hash(vectorDim);
    }
}

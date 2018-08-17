package cn.meteor.cloud.train;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 13:59
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 13:59
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class W2VCalculator {

    public static void vectorPlus(float[] vector1,float[] vector2){
        for(int i=0;i<vector1.length;i++){
            vector1[i] += vector2[i];
        }
        toOne(vector1);
    }

    //精度要求不高
    public static void toOne(float[] vector){
        float div = 0.0f;
        for(int i=0;i<vector.length;i++){
            div += vector[i]*vector[i];
        }
        for(int i=0;i<vector.length;i++){
            vector[i] /= div;
        }
    }

    public static float similarity(float[] vector1,float[] vector2){
        float dividend = 0.0f;
        double helper1 = 0.0d;
        double helper2 = 0.0d;
        for(int i=0;i<vector1.length;i++){
            dividend += vector1[i]*vector2[i];
            helper1 += vector1[i]*vector1[i];
            helper2 += vector2[i]*vector2[i];
        }
        return dividend/(float) (Math.sqrt(helper1)*Math.sqrt(helper2));
    }

    public static float similarity(Float[] vector1,float[] vector2){
        float dividend = 0.0f;
        double helper1 = 0.0d;
        double helper2 = 0.0d;
        for(int i=0;i<vector1.length;i++){
            dividend += vector1[i]*vector2[i];
            helper1 += vector1[i]*vector1[i];
            helper2 += vector2[i]*vector2[i];
        }
        return dividend/(float) (Math.sqrt(helper1)*Math.sqrt(helper2));
    }

    public static float similarity(float[] vector1,Float[] vector2){
        float dividend = 0.0f;
        double helper1 = 0.0d;
        double helper2 = 0.0d;
        for(int i=0;i<vector1.length;i++){
            dividend += vector1[i]*vector2[i];
            helper1 += vector1[i]*vector1[i];
            helper2 += vector2[i]*vector2[i];
        }
        return dividend/(float) (Math.sqrt(helper1)*Math.sqrt(helper2));
    }

    public static float similarity(Float[] vector1,Float[] vector2){
        float dividend = 0.0f;
        double helper1 = 0.0d;
        double helper2 = 0.0d;
        for(int i=0;i<vector1.length;i++){
            dividend += vector1[i]*vector2[i];
            helper1 += vector1[i]*vector1[i];
            helper2 += vector2[i]*vector2[i];
        }
        return dividend/(float) (Math.sqrt(helper1)*Math.sqrt(helper2));
    }
}

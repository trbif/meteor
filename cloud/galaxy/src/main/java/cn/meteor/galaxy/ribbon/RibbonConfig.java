package cn.meteor.galaxy.ribbon;

import cn.meteor.galaxy.annotation.Exclude;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: galaxy
 * @Description: 采用随机负载
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/29 15:32
 * @Version: 1.0.0
 */
@Configuration
@Exclude
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}

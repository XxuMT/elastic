package com.elastic.job;

/**
 * Created by XxuMT on 2018/8/23.
 */

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @auth XxuMT
 * @Description: 实践
 * @date 2018/8/23
 */
public class ElasticJobDemo {

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("10.112.11.139:2181","dd-job"));
        registryCenter.init();
        return registryCenter;
    }

    private static LiteJobConfiguration createJobConfiguration() {
        // 创建作业配置 //定义作业核心配置
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("ElasticJob" , "0/10 * * * * ?", 4).build();
        //定义simple类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfig, ElasticJob.class.getCanonicalName());
        //定义Lite作业根配置
        return LiteJobConfiguration.newBuilder(simpleJobConfig).build();

    }

    public static void main(String[] args){
        new JobScheduler(createRegistryCenter(), createJobConfiguration()).init();
    }

}

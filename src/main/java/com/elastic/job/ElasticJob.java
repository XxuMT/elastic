package com.elastic.job; /**
 * Created by XxuMT on 2018/8/23.
 */

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @auth XxuMT
 * @Description: elastic作业任务
 * @date 2018/8/23
 */
public class ElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        /*System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, 当前分片项: %s, time: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem(), System.currentTimeMillis()));
*/
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("doing sharding 0...job name is "+shardingContext.getJobName());
                break;
            case 1:
                System.out.println("doing sharding 1...job name is "+shardingContext.getJobName());
                break;
            case 2:
                System.out.println("doing sharding 2...job name is "+shardingContext.getJobName());
                break;
            case 3:
                System.out.println("doing sharding 3...job name is "+shardingContext.getJobName());
                break;
            default:
                break;
        }
    }


}

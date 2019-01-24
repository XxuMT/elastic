package com.elastic.job.stratege;
/**
 * Created by XxuMT on 2018/8/27.
 */

import com.dangdang.ddframe.job.lite.api.strategy.JobInstance;
import com.dangdang.ddframe.job.lite.api.strategy.JobShardingStrategy;

import java.util.List;
import java.util.Map;

/**
 * @author  XxuMT
 * @Description: 分片策略
 * @date 2018/8/27
 */
public class ElasticJobShardingStrategy implements JobShardingStrategy {

    @Override
    public Map<JobInstance, List<Integer>> sharding(List<JobInstance> list, String s, int i) {
        return null;
    }
}

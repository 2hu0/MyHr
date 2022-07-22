package com.vhr.service;

import com.vhr.model.bean.JobLevel;
import com.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;
    public List<JobLevel> getAllJobLevels(){
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer deleteManyJobLevels(Integer[] ids) {
//        System.out.println(Arrays.toString(ids));
        return jobLevelMapper.deleteManyJobLevels(ids);
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }
}

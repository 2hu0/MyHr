package com.vhr.controller.system.basic;

import com.vhr.model.bean.JobLevel;
import com.vhr.model.bean.RespBean;
import com.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 2hu0
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {

        if (jobLevelService.addJobLevel(jobLevel)==1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败！");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteManyJobLevels(Integer[] ids) {
//        System.out.println(Arrays.toString(ids));
        if (jobLevelService.deleteManyJobLevels(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel)==1) {
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败！");
    }
}

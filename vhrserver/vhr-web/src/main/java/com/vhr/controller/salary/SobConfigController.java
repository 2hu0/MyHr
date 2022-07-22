package com.vhr.controller.salary;

import com.vhr.model.bean.Employee;
import com.vhr.model.bean.RespBean;
import com.vhr.model.bean.RespPageBean;
import com.vhr.model.bean.Salary;
import com.vhr.service.EmployService;
import com.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployService employService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }
@PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
    Integer integer = employService.updateEmployeeSalaryById(eid, sid);
    if (integer == 1 || integer == 2){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}

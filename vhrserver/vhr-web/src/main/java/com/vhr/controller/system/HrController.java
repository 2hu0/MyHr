package com.vhr.controller.system;

import com.vhr.model.bean.Hr;
import com.vhr.model.bean.RespBean;
import com.vhr.model.bean.Role;
import com.vhr.service.HrService;
import com.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }
@PutMapping("/")
    public RespBean updateHr(@RequestBody  Hr hr) {
        if (hrService.updateHr(hr) == 1){
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败！");
    }
@GetMapping("/roles")
    public List<Role> getAllRoles(){
       return  roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids){
        if (hrService.updateHrRole(hrid,rids)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
@DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable  Integer id){
        if(hrService.deleteHrById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
}
}

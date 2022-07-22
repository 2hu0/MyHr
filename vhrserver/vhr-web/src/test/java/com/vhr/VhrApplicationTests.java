package com.vhr;

import com.vhr.model.bean.Hr;
import com.vhr.model.bean.JobLevel;
import com.vhr.model.bean.Menu;
import com.vhr.mapper.HrMapper;
import com.vhr.mapper.JobLevelMapper;
import com.vhr.mapper.MenuMapper;
import com.vhr.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;


@SpringBootTest
class VhrApplicationTests {
    @Resource
    HrMapper hrMapper;

    @Resource
    MenuMapper menuMapper;

    @Resource
    PositionMapper positionMapper;
    @Resource
    JobLevelMapper jobLevelMapper;

    @Test
    void contextLoads() {
//        Hr admin = hrMapper.loadUserByUsername("admin");
//        System.out.println(admin.toString());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches("123", "$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
        System.out.println(matches);
    }

    @Test
    void test1() {
        Hr admin = hrMapper.loadUserByUsername("lisi");
        System.out.println(admin.toString());
    }

    @Test
    void test2() {
        List<Menu> menu = menuMapper.getMenuByHrId(5);
        menu.forEach(System.out::println);
    }

    @Test
    void test3() {
        Integer[] integers = new Integer[2];
        Integer integer = positionMapper.deletePositionByIds(integers);
        System.out.println(integer);

    }

    @Test
    void test4() {
        List<JobLevel> allJobLevels = jobLevelMapper.getAllJobLevels();
        allJobLevels.forEach(System.out::println);
    }

    public static <T,R> R   fun(Function<T,R> fun, T t){
        System.out.println(t.getClass());
        return fun.apply(t);
    }
    public static void main(String[] args) {
        System.out.println("!23");
        fun((s)->Integer.parseInt(s),"123");
    }
    @Test
    void test6(){
        fun((String s)->Integer.parseInt(s),"123");
    }

}

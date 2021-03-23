package com.example.newboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.newboot.entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao extends BaseMapper<Student> {

}

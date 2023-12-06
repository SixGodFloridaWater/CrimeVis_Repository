package com.system.conttoller;

import com.system.VO.DataVO;
import com.system.mapper.CrimedataMapper;
import com.system.pojo.Crimedata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crimedata")
public class CrimedataController {

    private final CrimedataMapper crimedataMapper;

    @Autowired
    public CrimedataController(CrimedataMapper crimedataMapper) {
        this.crimedataMapper = crimedataMapper;
    }

    @PostMapping("/groupByMonth")
    public DataVO getCrimedataByMonth(@RequestParam String month) {
        // 调用CrimedataMapper中的groupByMonth方法按照月份查询数据
        List<Crimedata> result = crimedataMapper.groupByMonth(month);
        return DataVO.success("0", result);

    }
}
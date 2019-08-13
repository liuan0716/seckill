package com.example.controller;

import com.example.bean.Seckill;
import com.example.bean.StatusEnum;
import com.example.dto.Exposer;
import com.example.dto.SeckillExcution;
import com.example.dto.SeckillResult;
import com.example.service.ISeckillService;
import com.example.service.ex.RepeatKillExcption;
import com.example.service.ex.SeckillCloseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seckill")//restful设计思想   模块
@Controller
public class SeckillController {

@Autowired
ISeckillService seckillService;

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String list(ModelMap mp){
        List<Seckill> list=seckillService.getSeckillList();
        mp.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(value="/{seckillId}/detail",method =RequestMethod.GET )
    public String detail(@PathVariable("seckillId") Long seckillId, ModelMap mp){

        if(seckillId == null){
            return "redirect:/seckill/list";
        }
        Seckill sec=seckillService.getById(seckillId);
        if(sec==null){
            return "redirect:/seckill/list";
        }
        mp.addAttribute("seckill",sec);
        return "detail";
    }

    @RequestMapping(value="/exposer",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public SeckillResult exposer(@RequestParam("seckillId") Long seckillId){

        try{
            Exposer exposer=seckillService.ExportSeckillUrl(seckillId);
            SeckillResult result=new SeckillResult(true,exposer);
            return result;
        }catch(Exception e){
            e.getMessage();
        }

        return null;
    }

    @RequestMapping(value="/execute",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public SeckillResult<SeckillExcution> execute(@RequestParam("seckillId") Long seckillId,@RequestParam("md5") String md5,@CookieValue(value="phone",required = false) Long phone){
        System.out.println("seckillId:"+seckillId+",md5:"+md5+",phone:"+phone);
        if(phone==null){
            return new SeckillResult<SeckillExcution>(false,"未注册");
        }
        try {
            SeckillExcution execution=seckillService.executeSeckill(seckillId,phone,md5);
            return new SeckillResult<SeckillExcution>(true,execution);
        }catch (SeckillCloseException e1){
            SeckillExcution execution=new SeckillExcution(seckillId,StatusEnum.SECKILL_ENDED);
            return new SeckillResult<SeckillExcution>(false,execution);
        }catch(RepeatKillExcption e2){
            SeckillExcution execution=new SeckillExcution(seckillId,StatusEnum.SECKILL_REPEAT);
            return new SeckillResult<SeckillExcution>(false,execution);
        }catch(Exception e3){
            SeckillExcution execution=new SeckillExcution(seckillId,StatusEnum.INNER_ERROR);
            System.out.println(e3.getMessage());
            return new SeckillResult<SeckillExcution>(false,execution);
        }

    }

}

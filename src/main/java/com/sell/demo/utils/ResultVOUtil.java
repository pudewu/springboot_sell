package com.sell.demo.utils;

import com.sell.demo.VO.ResultVO;
//封装ResultVO
public class ResultVOUtil {
    public static ResultVO succes(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);

        return resultVO;
    }

    //什么参数都没有的情况
    public static ResultVO succes(){
        return succes(null);
    }

    //失败情况
    public static ResultVO erro(Integer code,String msg){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}

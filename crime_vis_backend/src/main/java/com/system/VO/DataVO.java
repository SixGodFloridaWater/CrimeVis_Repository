package com.system.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.system.VO.Constants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVO<T> {
    private Integer code;   //返回码，0成功
    private String msg;     //返回描述
    private String count;     //分页查询总记录数
    private T data;         //返回数据


    public DataVO(Integer code, String msg, T data, String count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public DataVO(String count, T data) {
        this.count = count;
        this.data = data;
    }

    //操作成功返回信息
    public static DataVO<Object> success(){
        return new DataVO(0,OK_MSG, (Object) null,null);
    }
    public static DataVO<Object> success(String msg){
        return new DataVO(0,msg, (Object) null,null);
    }
    public static DataVO<Object> success(String count,Object data){
        return new DataVO(0,OK_MSG,count,data);
    }
    //操作失败返回信息
    public static DataVO<Object> fail(){
        return new DataVO(-1,FAIL_MSG, (Object) null,null);
    }
    public static DataVO<Object> fail(String msg){
        return new DataVO(-1,msg, (Object) null,null);
    }
}

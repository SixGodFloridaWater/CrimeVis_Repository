package com.system.pojo;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Genderdata implements Serializable {
    private String DATEOCC;
    private String VictSex;
    private int OccurrenceCount;
    public void formatDateTime() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = dateFormat.parse(this.DATEOCC);
            this.DATEOCC = dateFormat.format(date);
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
    }
}

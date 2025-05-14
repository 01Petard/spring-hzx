package com.hzx.lesson;

import com.hzx.lesson.common.utils.CSVUtils;

/**
 * @author zexiao.huang
 * @since 2025/5/14 17:11
 */
public class TestCsvUtils {
    public static void main(String[] args) {
        // 准备模拟输入数据
        String input = "in,LINE01,LOCATION01,AGV01,SEAT01,OK,2025-05-14 17:30:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n" +
                "out,LINE02,LOCATION02,AGV02,SEAT02,ERROR,2025-05-14 17:35:00\n";

        // API 名称可以是任意字符串，这里简单地使用 "enter_out_event_" 作为前缀
        String apiName = "enter_out_event_";

        // 调用工具类方法写入数据
        CSVUtils.writeAgvEventEnterOutToCSV(apiName, input);

        System.out.println("数据已成功写入CSV文件！");
    }
}

package com.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author chh
 * @date 2022/3/1 21:45
 */
public class Zconvert {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        List<StringBuilder> builderList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builderList.add(new StringBuilder());
        }
        
        // 若为true 向下打印
        boolean changeFlag = true;
        int curRowNum = 0;
        for (char c : s.toCharArray()) {
            if (curRowNum == 0) {
                changeFlag = true;
            }
            if (curRowNum == numRows - 1) {
                changeFlag = false;
            }

            StringBuilder stringBuilder = builderList.get(curRowNum);
            stringBuilder.append(c);

            if (changeFlag) {
                curRowNum++;
            } else {
                curRowNum--;
            }
        }

        return String.join("", builderList);
    }

    public static void main(String[] args) {
        Zconvert zconvert = new Zconvert();
        System.out.println(zconvert.convert("PAYPALISHIRING", 3));
    }
}

package com.lc.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 当 n == 1 ，返回 [0,1] .
 * 当 n == 2 ，返回 [0,1,3,2] .
 * 当 n == 3 ，返回 [0,1,3,2,6,7,5,4] .
 * 当 n == …… ，返回 [0,1,3,2,6,7,5,4,……] .
 *
 * @author chanhaoheng
 * @date 2022/12/23
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);

        for (int i = 0; i < n - 1; i++) {
            int pow = (int) Math.pow(2, (i + 1));
            for (int j = result.size() - 1; j >= 0; j--) {
                Integer code = result.get(j) + pow;
                result.add(code);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(2));
        System.out.println(grayCode.grayCode(3));
    }
}

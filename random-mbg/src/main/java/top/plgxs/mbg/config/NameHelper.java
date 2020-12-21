package top.plgxs.mbg.config;

/**
 * 名称辅助类
 * @author whw
 * @date 2019/12/30 17:37
 */
public class NameHelper {

    public static String getName(String name,boolean isTableName) {
        String result = name;
        if (name.contains("_")) {
            String[] strs = name.split("_");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    continue;
                }
                if(isTableName)
                {
                    sb.append(toUpperCase(strs[i]));
                }
                else {
                    if (i == 1) {
                        sb.append(toLowerCase(strs[i]));
                    } else {
                        sb.append(toUpperCase(strs[i]));
                    }
                }
            }
            result = sb.toString();
        }
        return result;
    }

    /**
     * 首字母大写
     *
     * @param letter
     * @return
     */
    private static String toUpperCase(String letter) {
        return letter.substring(0, 1).toUpperCase() + letter.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param letter
     * @return
     */
    private static String toLowerCase(String letter) {
        return letter.substring(0, 1).toLowerCase() + letter.substring(1);
    }
}

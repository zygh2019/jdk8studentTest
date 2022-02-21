package util;

import entity.AdminUser;
import entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liushengbin
 * @date 2022/2/21
 */
public class FunctionUtil {

    public static void main(String[] args) {
        //创建 不同对象 不同值名字的对象
        List<User> users = Arrays.asList(User.builder().role(1).build(), User.builder().role(2).build());
        //创建 不同对象 不同值名字的对象
        List<AdminUser> adminUsers = Arrays.asList(AdminUser.builder().roleValue(3).build(), AdminUser.builder().roleValue(4).build());

        // 对象不同转换的字段名字不同 但是要用一个方法
        System.out.println(roleNameCovered(users, User::getRole,FunctionUtil::getRoleId2Name));
        System.out.println(roleNameCovered(adminUsers, AdminUser::getRoleValue,o->getAdminRoleId2Name(o)));
    }


    /**
     * 公共角色名字转换
     *
     * @param list
     * @param roleId
     * @param <T>
     * @return
     */
    private static <T> String roleNameCovered(List<T> list, Function<T, Integer> roleId, Function<Integer, String> getRoleFunction) {
        return list.stream().map(roleId)
                .collect(Collectors.toList())
                .stream()
                .map(getRoleFunction)
                .collect(Collectors.joining(","));

    }

    /**
     * role码表方法
     *
     * @param roleId
     * @return
     */
    private static String getRoleId2Name(Integer roleId) {
        if (roleId == 1) {
            return "老师";
        } else if (roleId == 2) {
            return "管理员";
        } else if (roleId == 3) {
            return "高级管理员";
        } else if (roleId == 4) {
            return "助教";
        }
        return "无";
    }
    /**
     * role码表方法2
     *
     * @param roleId
     * @return
     */
    private static String getAdminRoleId2Name(Integer roleId) {
        if (roleId == 1) {
            return "老师";
        } else if (roleId == 2) {
            return "管理员";
        } else if (roleId == 3) {
            return "高级管理员";
        } else if (roleId == 5) {
            return "助教";
        }
        return "无";
    }
}

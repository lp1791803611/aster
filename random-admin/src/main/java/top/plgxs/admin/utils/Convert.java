package top.plgxs.admin.utils;

import top.plgxs.common.enums.StatusEnum;
import top.plgxs.common.node.LayuiTreeNode;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysPosition;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/13 1:41
 */
public class Convert {
    /**
     * 将position转为LayuiTreeNode
     * @param positions
     * @return java.util.List<top.plgxs.common.node.LayuiTreeNode>
     * @author Stranger。
     * @since 2021/2/13
     */
    public static List<LayuiTreeNode> ConvertLayuiTreeByPosition(List<SysPosition> positions){
        List<LayuiTreeNode> list = new ArrayList<>();
        if (positions != null && positions.size() > 0) {
            for (SysPosition position : positions) {
                boolean disabled = StatusEnum.DISABLE.getCode().equals(position.getStatus());
                list.add(new LayuiTreeNode(position.getId(), position.getPositionName(), false, disabled));
            }
        }
        return list;
    }

    /**
     * 将UserDto转为user
     * @param userDto
     * @return
     */
    public static SysUser convertDtoToUser(UserDto userDto) {
        SysUser user = new SysUser();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setNickname(userDto.getNickname());
        user.setMobile(userDto.getMobile());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setHeadUrl(userDto.getHeadUrl());
        user.setRealname(userDto.getRealname());
        user.setIdNumber(userDto.getIdNumber());
        user.setDeptId(userDto.getDeptId());
        user.setStatus(userDto.getStatus());
        return user;
    }

    public static UserDto convertUserToDto(SysUser sysUser) {
        UserDto user = new UserDto();
        user.setId(sysUser.getId());
        user.setUsername(sysUser.getUsername());
        user.setPassword(sysUser.getPassword());
        user.setNickname(sysUser.getNickname());
        user.setMobile(sysUser.getMobile());
        user.setEmail(sysUser.getEmail());
        user.setGender(sysUser.getGender());
        user.setHeadUrl(sysUser.getHeadUrl());
        user.setRealname(sysUser.getRealname());
        user.setIdNumber(sysUser.getIdNumber());
        user.setDeptId(sysUser.getDeptId());
        user.setStatus(sysUser.getStatus());
        return user;
    }
}

package com.zinqx.zinaicode.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.zinqx.zinaicode.model.dto.app.AppAddRequest;
import com.zinqx.zinaicode.model.dto.app.AppAdminUpdateRequest;
import com.zinqx.zinaicode.model.dto.app.AppQueryRequest;
import com.zinqx.zinaicode.model.dto.app.AppUpdateRequest;
import com.zinqx.zinaicode.model.entity.App;
import com.zinqx.zinaicode.model.entity.User;
import com.zinqx.zinaicode.model.vo.AppVO;
import jakarta.servlet.http.HttpServletRequest;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/Zin-QX">程序员果粒</a>
 */
public interface AppService extends IService<App> {


    Flux<String> chatToGenCode(Long appId, String message, User loginUser);


    /**
     * 获取应用脱敏信息
     *
     * @param app 应用
     * @return 脱敏视图对象
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用脱敏信息列表
     *
     * @param appList 应用列表
     * @return 脱敏视图对象列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 拼接查询条件
     *
     * @param appQueryRequest 查询请求
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取应用脱敏信息
     *
     * @param app      应用
     * @param loginUser 登录用户
     * @return 脱敏视图对象
     */
    AppVO getAppVOWithChatHistory(App app, User loginUser);

    /**
     * 获取应用脱敏信息列表
     *
     * @param loginUser 登录用户
     * @return 脱敏视图对象列表
     */
    String deployApp(Long appId, User loginUser);
}

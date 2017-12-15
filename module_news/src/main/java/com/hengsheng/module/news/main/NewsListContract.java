package com.hengsheng.module.news.main;


import com.hengsheng.module.news.data.bean.StoryList;
import com.hengsheng.module.core.base.BasePresenter;
import com.hengsheng.module.core.base.BaseView;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/22 20:33
 * @version V1.2.0
 * @name NewsContract
 */
public interface NewsListContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showNewsList(StoryList info);

    }

    interface Presenter extends BasePresenter {

        /**
         * 获取最新列表
         *
         * @param date
         */
        void getNewMessages(int page, int size, String date);

    }

}

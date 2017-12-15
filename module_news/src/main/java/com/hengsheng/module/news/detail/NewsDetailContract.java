package com.hengsheng.module.news.detail;


import com.hengsheng.module.news.data.bean.MessageDetail;
import com.hengsheng.module.core.base.BasePresenter;
import com.hengsheng.module.core.base.BaseView;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/22 20:33
 * @version V1.2.0
 * @name NewsContract
 */
public interface NewsDetailContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showNewsDetail(MessageDetail detail);

    }

    interface Presenter extends BasePresenter {

        /**
         * 获取最新列表
         *
         * @param newsId 新闻id
         */
        void getNewsDetail(String newsId);

    }

}

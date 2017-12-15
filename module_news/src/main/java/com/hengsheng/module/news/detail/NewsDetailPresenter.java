package com.hengsheng.module.news.detail;


import com.hengsheng.module.news.data.NewsDataSource;
import com.hengsheng.module.news.data.bean.MessageDetail;
import com.hengsheng.module.news.data.source.RemoteNewsDataSource;
import com.hengsheng.module.core.base.InfoCallback;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/22 20:33
 * @version V1.2.0
 * @name GirlsPresenter
 */
public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.View mView;
    private NewsDataSource mDataSource;

    public NewsDetailPresenter(NewsDetailContract.View view) {
        mView = view;
        mDataSource = new RemoteNewsDataSource();
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getNewsDetail(String newsId) {
        mDataSource.getNewsDetail(newsId, new InfoCallback<MessageDetail>() {
            @Override
            public void onSuccess(MessageDetail detail) {
                if (mView.isActive()) {
                    mView.showNewsDetail(detail);
                }
            }

            @Override
            public void onError(int code, String message) {

            }
        });
    }

}

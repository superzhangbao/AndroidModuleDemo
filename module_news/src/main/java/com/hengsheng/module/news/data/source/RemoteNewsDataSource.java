package com.hengsheng.module.news.data.source;


import com.hengsheng.module.news.Constants;
import com.hengsheng.module.news.data.NewsDataSource;
import com.hengsheng.module.news.data.bean.MessageDetail;
import com.hengsheng.module.news.data.bean.StoryList;
import com.hengsheng.module.core.base.InfoCallback;
import com.hengsheng.module.core.http.DataType;
import com.hengsheng.module.core.http.HttpClient;
import com.hengsheng.module.core.http.OnResultListener;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/4/20 23:32
 * @version V1.2.0
 * @name RemoteNewsDataSource
 */
public class RemoteNewsDataSource implements NewsDataSource {

    @Override
    public void getNewsList(String date, final InfoCallback<StoryList> callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
                .url(date)
                .bodyType(DataType.JSON_OBJECT, StoryList.class)
                .build();
        client.get(new OnResultListener<StoryList>() {

            @Override
            public void onSuccess(StoryList result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onError(code, message);
            }

            @Override
            public void onFailure(String message) {
                callback.onError(0, message);
            }
        });
    }


    @Override
    public void getNewsDetail(String id, final InfoCallback<MessageDetail> callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE_DETAIL)
                .url(id)
                .bodyType(DataType.JSON_OBJECT, MessageDetail.class)
                .build();
        client.get(new OnResultListener<MessageDetail>() {

            @Override
            public void onSuccess(MessageDetail result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onError(code, message);
            }

            @Override
            public void onFailure(String message) {
                callback.onError(0, message);
            }
        });
    }


}

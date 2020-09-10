package com.developer.ditmar.clonespotify.ApiResfull;

import com.developer.ditmar.clonespotify.utils.EndPoints;
import com.developer.ditmar.clonespotify.utils.UserDataServer;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.HttpClient;

public class MusicApi {
    private onLoadData interfaceevent;
    private AsyncHttpClient client;
    public MusicApi(onLoadData interfaceevent) {
        this.interfaceevent = interfaceevent;
        client = new AsyncHttpClient();
    }
    public void loadMusic() {
        client.addHeader("authorization", UserDataServer.TOKEN);
        client.get(EndPoints.LISTMP3_SERVICE, new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                interfaceevent.onJsonArrayLoad(response);
            }
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                interfaceevent.onFailure(statusCode, headers, throwable, errorResponse);
            }

        });
    }

}

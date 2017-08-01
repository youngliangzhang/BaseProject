package com.dmsoft.prizetech.api;

import com.dmsoft.prizetech.api.response.ServerErrorResponse;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.dmsoft.prizetech.api.ServerConfig.SERVER_ADDRESS_PROD;
import static com.dmsoft.prizetech.api.ServerConfig.SERVER_RESPONSE_ERROR_CODE;
import static com.dmsoft.prizetech.api.ServerConfig.SERVER_RESPONSE_ERROR_CODE_FORBIDDEN;
import static com.dmsoft.prizetech.api.ServerConfig.SERVER_RESPONSE_ERROR_CODE_INTERNAL_ERROR;
import static com.dmsoft.prizetech.api.ServerConfig.SERVER_RESPONSE_ERROR_CODE_NOT_FOUND;
import static com.dmsoft.prizetech.api.ServerConfig.SERVER_RESPONSE_ERROR_CODE_TOKEN;

public class ServiceApi {

    private static final String TAG = ServiceApi.class.getSimpleName();
    private static ServiceApi instance = null;
    private PrezetechService service;

    public static ServiceApi newInstance(){
        if (instance == null){
            instance = new ServiceApi(false);
        }

        return instance;
    }

    public ServiceApi(boolean isRxJava){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_ADDRESS_PROD)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(PrezetechService.class);
    }

    public ServerErrorResponse getServerErrorResponse(Response response){

        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();

        switch (response.code()){
            case SERVER_RESPONSE_ERROR_CODE:
            case SERVER_RESPONSE_ERROR_CODE_FORBIDDEN:
            case SERVER_RESPONSE_ERROR_CODE_NOT_FOUND:
                try {
                    ServerErrorResponse sr = new Gson().fromJson(response.errorBody().string(), ServerErrorResponse.class);
                    serverErrorResponse = sr;
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case SERVER_RESPONSE_ERROR_CODE_TOKEN:
                break;
            case SERVER_RESPONSE_ERROR_CODE_INTERNAL_ERROR:
                try {
                    ServerErrorResponse sr = new Gson().fromJson(response.errorBody().string(), ServerErrorResponse.class);
                    serverErrorResponse = sr;
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

        return serverErrorResponse;
    }

    private String getAuthToken() {

        return null;
    }

}

package com.example.llyods_project.rf_network;


import com.example.llyods_project.model.Pixabay_Res;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_Interface {


    @GET("api/?")
    Single<Pixabay_Res> getpixabay(@Query("key") String strkey,
                                         @Query("q") String str_Search, @Query("image_type") String str_type,
                                         @Query("orientation") String strOrientation, @Query("page") int page_no,
                                         @Query("per_page") int per_page);
}

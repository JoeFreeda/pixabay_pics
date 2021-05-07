package com.example.llyods_project.viewmodels;

import android.widget.Toast;

import com.example.llyods_project.model.Pixabay_Res;
import com.example.llyods_project.rf_network.API_Interface;
import com.example.llyods_project.views.MainActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PicViewModel extends ViewModel {

    MutableLiveData<Pixabay_Res> userLiveData;
    Pixabay_Res userArrayList;
    public static String API_KEY = "21482080-c9061d0b10f18205c047af6e7";
    private String myVariable = "yellow+flowers";


    public PicViewModel() {
        userLiveData = new MutableLiveData<>();

    }

    private void getSearchresult(String myVariable, API_Interface service, MainActivity mainActivity, int n_page) {

        service.getpixabay(API_KEY,myVariable,"photo","vertical",n_page,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Pixabay_Res>() {
                    @Override
                    public void onSuccess(@NonNull Pixabay_Res pixabay_res) {
                        userArrayList  = pixabay_res;
                        setdata();
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(mainActivity,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void setdata() {
        userLiveData.setValue(userArrayList);
    }

    public MutableLiveData<Pixabay_Res> getUserMutableLiveData() {
        return userLiveData;
    }

    public LiveData<Pixabay_Res> callapi(String input, API_Interface service, MainActivity mainActivity, int n_page) {
        //if(userLiveData == null || !myVariable.equals(input)){
            myVariable = input;
            getSearchresult(myVariable,service,mainActivity,n_page);

       // }
        return userLiveData;
    }
}

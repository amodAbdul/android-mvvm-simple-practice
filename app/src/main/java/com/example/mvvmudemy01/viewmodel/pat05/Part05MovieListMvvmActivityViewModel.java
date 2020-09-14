package com.example.mvvmudemy01.viewmodel.pat05;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmudemy01.model.part05.Movie;
import com.example.mvvmudemy01.model.part05.MovieMvvm;
import com.example.mvvmudemy01.model.part05.MovieRepositoryMVVM;

import java.util.List;

public class Part05MovieListMvvmActivityViewModel extends AndroidViewModel {
    private MovieRepositoryMVVM movieRepository;


    public Part05MovieListMvvmActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepository=new MovieRepositoryMVVM(application);
    }

    public LiveData<List<MovieMvvm>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }

}

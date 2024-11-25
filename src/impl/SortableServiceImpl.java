package impl;

import database.Database;
import interfaces.FindableService;
import interfaces.SortableService;
import models.Movie;
import models.Producer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortableServiceImpl implements SortableService {

    @Override
    public void sortMovieByName(String ascOrDesk) {
        Database.movies.sort(Comparator.comparing(Movie::getName));
        if (ascOrDesk.equalsIgnoreCase("asc")){
            System.out.println(Database.movies);
        }else if(ascOrDesk.equalsIgnoreCase("desc")){
            System.out.println(Database.movies.reversed());
        }else {
            System.out.println("Error!");
        }
    }

    @Override
    public void sortByYear(String ascOrDesk) {
       Database.movies.sort(Comparator.comparing(Movie::getYear));
       if (ascOrDesk.equalsIgnoreCase("asc")){
           System.out.println(Database.movies);
       }else if(ascOrDesk.equalsIgnoreCase("desc")){
           System.out.println(Database.movies.reversed());
       }else {
           System.out.println("Error!");
       }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        for (Movie movie: Database.movies){
            if (movie.getProducer().getFirstName().equals("name")){
//                Database.movies.sort(Comparator.comparing(Movie::getProducer));
            }
        }

    }
}

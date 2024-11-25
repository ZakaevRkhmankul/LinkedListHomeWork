import database.Database;
import enums.Genre;
import impl.FindableServiceImpl;
import impl.SortableServiceImpl;
import interfaces.FindableService;
import interfaces.SortableService;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FindableService findableService = new FindableServiceImpl();
        SortableService sortableService = new SortableServiceImpl();

        List<Actor> actors1 = new LinkedList<>(List.of(
                new Actor("Kit Harington", "Jon Snow"),
                new Actor("Emili Klark", "Targarian")));

        List<Actor> actors2 = new LinkedList<>(List.of(
                new Actor("Djeki Chan", "Comedia")));

        List<Actor> actors3 = new LinkedList<>(List.of(
                new Actor("Andrew Garfield", "test")));


        LinkedList<Movie> movies = new LinkedList<>(Arrays.asList(
                new Movie("Карате пацан", LocalDate.of(2010, 6, 12), Genre.DRAMA, new Producer("Toni", "Skot"), actors2),
                new Movie("Игра престолов", LocalDate.of(2009, 4, 12), Genre.FANTASY, new Producer("David", "Benioff"), actors1),
                new Movie("Человек паук", LocalDate.of(2014, 4, 12), Genre.COMEDY, new Producer("Laura", "Avi Arad Matt Tolma"), actors3)));

        System.out.println("Sort by name:");
        Scanner scanner1 = new Scanner(System.in);
        sortableService.sortMovieByName("asc");
        Database.movies.addAll(movies);
        while (true) {


            System.out.println("""
                    Methods:
                    1.get all movies,
                    2.find movie by full name or part name,
                    3.find movie by actor name,
                    4.find movie by year,
                    5.find movie by producer,
                    6.find movie by genre,
                    7.find movie by role,
                    8.sort movie by name,
                    9. sort movie by year,
                    10. sort movie by producer.
                    Write options:
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println(findableService.getAllMovies());
                }
                case 2 -> {
                    System.out.print("write name: ");
                    System.out.println(findableService.findMovieByFullNameOrPartName(scanner1.nextLine()));
                }case 3 -> {
                    System.out.print("Write actor name: ");
                    System.out.println(findableService.findMovieByActorName(scanner1.nextLine()));
                }case 4 ->{
                    System.out.println(findableService.findMovieByYear(LocalDate.of(2014,4,12)));
                }case 5 ->{
                    System.out.print("Write producer name: ");
                    System.out.println(findableService.findMovieByProducer(scanner1.nextLine()));
                }case 6 ->{
                    System.out.println(findableService.findMovieByGenre(Genre.FANTASY));
                }case 7 ->{
                    System.out.print("Write actors role: ");
                    System.out.println(findableService.findMovieByRole(scanner1.nextLine()));
                }case 8 ->{
                    System.out.print("Write asc or desc: ");
                    sortableService.sortMovieByName(scanner1.nextLine());
                }case 9 ->{
                    System.out.print("Write asc or desc: ");
                    sortableService.sortByYear(scanner1.nextLine());
                }case 10->{
                    System.out.print("Write name or last name: ");
                    sortableService.sortByProducer(scanner1.nextLine());
                }
            }

        }
    }
}
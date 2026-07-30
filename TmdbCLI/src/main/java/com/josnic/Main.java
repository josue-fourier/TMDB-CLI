package com.josnic;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2){
            System.err.println("Missing parameter --type.");
            printUsage();
            return;
        }

        /* Menu options:
            playing: 1
            popular: 2
            top: 3
            upcoming: 4
         */
        int menuOption = 0; // TODO: Change this given the CLI parameter.

        if (Objects.equals(args[0], "--type")){
            if(Objects.equals(args[1], "playing")){
                menuOption = 1;
            }
            else if (Objects.equals(args[1], "popular")){
                menuOption = 2;
            }
            else if (Objects.equals(args[1], "top")){
                menuOption = 3;
            }
            else if (Objects.equals(args[1], "upcoming")){
                menuOption = 4;
            }
            else{
                System.err.println("Invalid option.\n");
                printUsage();
                return;
            }
        }
        else{
            System.err.println("Unknown verb.");
            printUsage();
            return;
        }

        String uriString = "https://api.themoviedb.org/3/movie/11";
        String TMDB_KEY = System.getenv("TMDB_KEY");
        String API_KEY = "Bearer " + TMDB_KEY;

        if (TMDB_KEY == null){
            System.err.println("No TMDB_KEY defined. Please define TMDB_KEY in the environment.");
            return;
        }

        // Now Playing feature
        // TODO: Make Page dynamic. For now fixed to 1 (same as default).

        String nowPlayingStringURI = "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1";
        String popularStringURI = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1";
        String topStringURI = "https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1";
        String upcomingStringURI = "https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1";

        String theUri;

        switch (menuOption){
            case 1: // playing feature.
                theUri = nowPlayingStringURI;
                break;
            case 2:
                theUri = popularStringURI;
                break;
            case 3:
                theUri = topStringURI;
                break;
            case 4:
                theUri = upcomingStringURI;
                break;
            default:
                System.err.println("Uknown option. Quitting.");
                return;
        }

        String jsonResponse;

        try {
            HttpClient myClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(theUri))
                    .header("Authorization", API_KEY)
                    .header("accept", "application/json")
                    .GET()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpResponse response = myClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response status, HTTP:" + response.statusCode());
            System.out.println("Reponse: " + response.body());

            jsonResponse = response.body().toString();
        }
        catch (NullPointerException e){
            System.err.println("No URI defined: " + e.getMessage());
            return;
        }
        catch (IllegalArgumentException e){
            System.err.println("Malformed URI: " + e.getMessage());
            return;
        }
        catch (IOException e){
            System.out.println("IO Error: " + e.getMessage());
            return;
        } catch (InterruptedException e) {
            System.out.println("InterruptedException" + e.getMessage());
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        TMDBResponse tmdbResult = mapper.readValue(jsonResponse, TMDBResponse.class);

        System.out.println(tmdbResult);
    }

    public static void printUsage(){
        System.err.println("Usage: --type [TYPE]");
        System.err.println("TYPE: playing: Now playing movies." +
                "\npopular: Popular movies." +
                "\ntop: Top rated movies." +
                "\nupcoming: Upcoming movies.");
    }
}

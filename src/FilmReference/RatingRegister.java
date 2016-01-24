package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class RatingRegister {

    Map<Film, List<Rating>> ratings;
    Map<Person, Map<Film,Rating>> reviewers;
    
    public RatingRegister(){
        ratings = new HashMap<Film, List<Rating>>();
        reviewers = new HashMap<Person, Map<Film,Rating>>();
    }
    
    public void addRating(Film film, Rating rating){
        if(ratings.containsKey(film)){
            List<Rating> list = ratings.get(film);
            list.add(rating);
            ratings.put(film, list);
        }
        else {
            List<Rating> list = new ArrayList<Rating>();
            list.add(rating);
            ratings.put(film, list);
        }
    }
    
    public List<Rating> getRatings(Film film){
        return ratings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings(){
        return ratings;
    }
    
    public void addRating(Person person, Film film, Rating rating){
        if(!reviewers.containsKey(person)){
            Map<Film, Rating> map = new HashMap<Film, Rating>();
            map.put(film, rating);
            addRating(film,rating);
            reviewers.put(person, map);
        }
        if(!reviewers.get(person).containsKey(film)){
            Map<Film, Rating> map = reviewers.get(person);
            map.put(film,rating);
            addRating(film,rating);
            reviewers.put(person, map);
        }
    }
    
    public Rating getRating(Person person, Film film){
        if(reviewers.get(person).containsKey(film)){
            return reviewers.get(person).get(film);
        } else return Rating.NOT_WATCHED;
            
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person){
        if(!reviewers.containsKey(person)){
            return new HashMap<Film, Rating>();
        } else {
            Map<Film, Rating> map = reviewers.get(person);
            return map;
        }
    }
    
    public List<Person> reviewers(){
        List<Person> list = new ArrayList<Person>();
        for(Person person:this.reviewers.keySet()){
            list.add(person);
        }
        return list;
    }
}

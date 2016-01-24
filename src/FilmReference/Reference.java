package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class Reference {
    
    private RatingRegister register;
    
    public Reference (RatingRegister register){
        this.register = register;
    }
    
    public Film recommendFilm(Person person){
        FilmComparator comp = new FilmComparator(register.ratings);
        Set<Film> films = register.ratings.keySet();
        
        if(!register.reviewers.containsKey(person)){
            Iterator<Film> iterator = films.iterator();
            Film best = iterator.next();
            while(iterator.hasNext()){
                Film temp = iterator.next();
                int i = comp.compare(best, temp);
                if(i==1){
                    best = temp;
                }
            }
            return best;
        }
        else {
            Set<Person> ppl = register.reviewers.keySet();
            Iterator<Person> iteratorPpl = ppl.iterator();
            Map<Person, Integer> similarities = new HashMap<Person, Integer>();
            while(iteratorPpl.hasNext()){
                Person tempPpl = iteratorPpl.next();
                if(person.equals(tempPpl)){
                    continue;
                }
                int similarity = 0;
                Iterator<Film> iterator = films.iterator();
                while(iterator.hasNext()){
                    Film tempFilm = iterator.next();
                    Map<Film, Rating> map1 = register.reviewers.get(person);
                    Map<Film, Rating> map2 =  register.reviewers.get(tempPpl);
                    if(map1.containsKey(tempFilm) && map2.containsKey(tempFilm)){
                        similarity += (map1.get(tempFilm).getValue() * map2.get(tempFilm).getValue());
                    }
                }
                similarities.put(tempPpl, similarity);
            }
            int biggest = -1000000;
            Person twin = null;
            for(Person tempPerson:similarities.keySet()){
                int tempInt = similarities.get(tempPerson);
                if(tempInt>biggest){
                    biggest = tempInt;
                    twin = tempPerson;
                }
            }
            Map<Film, Rating> twinMap = register.reviewers.get(twin);
            Map<Film, Rating> ourMap = register.reviewers.get(person);
            List<Film> notWatched = new ArrayList<Film>();
            for(Film film:twinMap.keySet()){
                if(!ourMap.containsKey(film)){
                    notWatched.add(film);
                }
            }
            Film best;
            best = null;
            biggest = -1;
            for(Film film:notWatched){
                int i = register.reviewers.get(twin).get(film).getValue();
                if(i>biggest){
                    biggest = i;
                    best = film;
                }
            }
            return best;
        }
    }
}

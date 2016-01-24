package reference.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

public class FilmComparator implements Comparator<Film>{
    
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        List<Rating> list = ratings.get(o1);
        Iterator<Rating> iterator = list.iterator();
        int av1 = 0;
        while(iterator.hasNext()){
            av1 += iterator.next().getValue();
        }
        list = ratings.get(o2);
        iterator = list.iterator();
        int av2 = 0;
        while(iterator.hasNext()){
            av2 += iterator.next().getValue();
        }
        if(av1 > av2){
            return -1;
        } else return 1;
    }

    
}

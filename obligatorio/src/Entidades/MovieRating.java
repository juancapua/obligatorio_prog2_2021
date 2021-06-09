package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;

public class MovieRating {

    private float weightedAverage;
    private int totalVotes;
    private float meanVote;
    private float medianVote;
    private MyList<Integer> votesRating;
    private Rating allgenders_0age;
    private Rating allgenders_18age;
    private Rating allgenders_30age;
    private Rating allgenders_45age;
    private Rating males_allages;
    private Rating males_0age;
    private Rating males_18age;
    private Rating males_30age;
    private Rating males_45age;
    private Rating females_allages;
    private Rating females_0age;
    private Rating female_18age;
    private Rating female_30age;
    private Rating female_45age;
    private Rating top1000;
    private Rating us_rating;
    private Rating non_us_rating;

    public MovieRating(float weightedAverage, int totalVotes, float meanVote, float medianVote, MyList<Integer> votesRating, Rating ratingTop1000_us, Rating ratingTop1000_nonUs, Rating ratingAllGenders, Rating allgenders_18age, Rating allgenders_30age, Rating allgenders_45age, Rating males_allages, Rating males_0age, Rating males_18age, Rating males_30age, Rating males_45age, Rating females_allages, Rating females_0age, Rating female_18age, Rating fenale_30age, Rating female_45age, Rating top1000, Rating us_rating, Rating non_us_rating, Rating ratingMales, Rating ratingFemales) {
        this.weightedAverage = weightedAverage;
        this.totalVotes = totalVotes;
        this.meanVote = meanVote;
        this.medianVote = medianVote;
        this.votesRating = votesRating;
        this.allgenders_0age = ratingAllGenders;
        this.allgenders_18age = allgenders_18age;
        this.allgenders_30age = allgenders_30age;
        this.allgenders_45age = allgenders_45age;
        this.males_allages = males_allages;
        this.males_0age = males_0age;
        this.males_18age = males_18age;
        this.males_30age = males_30age;
        this.males_45age = males_45age;
        this.females_allages = females_allages;
        this.females_0age = females_0age;
        this.female_18age = female_18age;
        this.female_30age = fenale_30age;
        this.female_45age = female_45age;
        this.top1000 = top1000;
        this.us_rating = us_rating;
        this.non_us_rating = non_us_rating;


    }

    public MovieRating(String[] lectura){

        if(lectura[1].length() != 0) {
            this.weightedAverage = Float.parseFloat(lectura[1]);
        }else this.weightedAverage = Float.parseFloat(null);
        if(lectura[2].length() != 0) {
            this.totalVotes = Integer.parseInt(lectura[2]);
        }else this.totalVotes = Integer.parseInt(null);
        if(lectura[3].length() != 0) {
            this.meanVote = Float.parseFloat(lectura[3]);
        }else this.meanVote = Float.parseFloat(null);
        if(lectura[4].length() != 0) {
            this.medianVote = Float.parseFloat(lectura[4]);
        }else this.medianVote = Float.parseFloat(null);
        this.votesRating = new MyLinkedListimpl();
        if(lectura[5].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[5]));
        }else this.votesRating.add(null);
        if(lectura[6].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[6]));
        }else this.votesRating.add(null);
        if(lectura[7].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[7]));
        }else this.votesRating.add(null);
        if(lectura[8].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[8]));
        }else this.votesRating.add(null);
        if(lectura[9].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[9]));
        }else this.votesRating.add(null);
        if(lectura[10].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[10]));
        }else this.votesRating.add(null);
        if(lectura[11].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[11]));
        }else this.votesRating.add(null);
        if(lectura[12].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[12]));
        }else this.votesRating.add(null);
        if(lectura[13].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[13]));
        }else this.votesRating.add(null);
        if(lectura[14].length() != 0) {
            this.votesRating.add(Integer.parseInt(lectura[14]));
        }else this.votesRating.add(null);
        if(lectura[16].length() != 0) {
            this.allgenders_0age = new Rating(Float.parseFloat(lectura[16]), Float.parseFloat(lectura[15]));
        }else this.allgenders_0age = null;
        if(lectura[18].length() != 0) {
            this.allgenders_18age = new Rating(Float.parseFloat(lectura[18]), Float.parseFloat(lectura[17]));
        }else this.allgenders_18age = null;
        if(lectura[20].length() != 0) {
            this.allgenders_30age = new Rating(Float.parseFloat(lectura[20]), Float.parseFloat(lectura[19]));
        }else this.allgenders_30age = null;
        if(lectura[22].length() != 0) {
            this.allgenders_45age = new Rating(Float.parseFloat(lectura[22]), Float.parseFloat(lectura[21]));
        }else this.allgenders_45age = null;
        if(lectura[24].length() != 0) {
            this.males_allages = new Rating(Float.parseFloat(lectura[24]), Float.parseFloat(lectura[23]));
        }else this.males_allages = null;
        if(lectura[26].length() != 0) {
            this.males_0age = new Rating(Float.parseFloat(lectura[26]), Float.parseFloat(lectura[25]));
        }else this.males_0age = null;
        if(lectura[28].length() != 0) {
            this.males_18age = new Rating(Float.parseFloat(lectura[28]), Float.parseFloat(lectura[27]));
        }else this.males_18age = null;
        if(lectura[30].length() != 0) {
            this.males_30age = new Rating(Float.parseFloat(lectura[30]), Float.parseFloat(lectura[29]));
        }else this.males_30age = null;
        if(lectura[32].length() != 0) {
            this.males_45age = new Rating(Float.parseFloat(lectura[32]), Float.parseFloat(lectura[31]));
        }else this.males_45age = null;
        if(lectura[34].length() != 0) {
            this.females_allages = new Rating(Float.parseFloat(lectura[34]), Float.parseFloat(lectura[33]));
        }else this.females_allages = null;
        if(lectura[36].length() != 0) {
            this.females_0age = new Rating(Float.parseFloat(lectura[36]), Float.parseFloat(lectura[35]));
        }else this.females_0age = null;
        if(lectura[38].length() != 0) {
            this.female_18age = new Rating(Float.parseFloat(lectura[38]), Float.parseFloat(lectura[37]));
        }else this.female_18age = null;
        if(lectura[40].length() != 0) {
            this.female_30age = new Rating(Float.parseFloat(lectura[40]), Float.parseFloat(lectura[39]));
        }else this.female_30age = null;
        if(lectura[42].length() != 0) {
            this.female_45age = new Rating(Float.parseFloat(lectura[42]), Float.parseFloat(lectura[41]));
        }else this.female_45age = null;
        if(lectura[44].length() != 0) {
            this.top1000 = new Rating(Float.parseFloat(lectura[44]), Float.parseFloat(lectura[43]));
        }else this.top1000 = null;
        if(lectura[46].length() != 0) {
            this.us_rating = new Rating(Float.parseFloat(lectura[46]), Float.parseFloat(lectura[45]));
        }else this.us_rating = null;
        if(lectura[48].length() != 0) {
            this.non_us_rating = new Rating(Float.parseFloat(lectura[48]), Float.parseFloat(lectura[47]));
        }else this.non_us_rating = null;


    }

    public float getWeightedAverage() {
        return weightedAverage;
    }

    public void setWeightedAverage(float weightedAverage) {
        this.weightedAverage = weightedAverage;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public float getMeanVote() {
        return meanVote;
    }

    public void setMeanVote(float meanVote) {
        this.meanVote = meanVote;
    }

    public float getMedianVote() {
        return medianVote;
    }

    public void setMedianVote(float medianVote) {
        this.medianVote = medianVote;
    }


    public void setVotesRating(MyList<Integer> votesRating) {
        this.votesRating = votesRating;
    }

    public Rating getAllgenders_0age() {
        return allgenders_0age;
    }

    public void setAllgenders_0age(Rating allgenders_0age) {
        this.allgenders_0age = allgenders_0age;
    }

    public Rating getAllgenders_18age() {
        return allgenders_18age;
    }

    public void setAllgenders_18age(Rating allgenders_18age) {
        this.allgenders_18age = allgenders_18age;
    }

    public Rating getAllgenders_30age() {
        return allgenders_30age;
    }

    public void setAllgenders_30age(Rating allgenders_30age) {
        this.allgenders_30age = allgenders_30age;
    }

    public Rating getAllgenders_45age() {
        return allgenders_45age;
    }

    public void setAllgenders_45age(Rating allgenders_45age) {
        this.allgenders_45age = allgenders_45age;
    }

    public Rating getMales_allages() {
        return males_allages;
    }

    public void setMales_allages(Rating males_allages) {
        this.males_allages = males_allages;
    }

    public Rating getMales_0age() {
        return males_0age;
    }

    public void setMales_0age(Rating males_0age) {
        this.males_0age = males_0age;
    }

    public Rating getMales_18age() {
        return males_18age;
    }

    public void setMales_18age(Rating males_18age) {
        this.males_18age = males_18age;
    }

    public Rating getMales_30age() {
        return males_30age;
    }

    public void setMales_30age(Rating males_30age) {
        this.males_30age = males_30age;
    }

    public Rating getMales_45age() {
        return males_45age;
    }

    public void setMales_45age(Rating males_45age) {
        this.males_45age = males_45age;
    }

    public Rating getFemales_allages() {
        return females_allages;
    }

    public void setFemales_allages(Rating females_allages) {
        this.females_allages = females_allages;
    }

    public Rating getFemales_0age() {
        return females_0age;
    }

    public void setFemales_0age(Rating females_0age) {
        this.females_0age = females_0age;
    }

    public Rating getFemale_18age() {
        return female_18age;
    }

    public void setFemale_18age(Rating female_18age) {
        this.female_18age = female_18age;
    }

    public Rating getFemale_30age() {
        return female_30age;
    }

    public void setFemale_30age(Rating female_30age) {
        this.female_30age = female_30age;
    }

    public Rating getFemale_45age() {
        return female_45age;
    }

    public void setFemale_45age(Rating female_45age) {
        this.female_45age = female_45age;
    }

    public Rating getTop1000() {
        return top1000;
    }

    public void setTop1000(Rating top1000) {
        this.top1000 = top1000;
    }

    public Rating getUs_rating() {
        return us_rating;
    }

    public void setUs_rating(Rating us_rating) {
        this.us_rating = us_rating;
    }

    public Rating getNon_us_rating() {
        return non_us_rating;
    }

    public void setNon_us_rating(Rating non_us_rating) {
        this.non_us_rating = non_us_rating;
    }
}

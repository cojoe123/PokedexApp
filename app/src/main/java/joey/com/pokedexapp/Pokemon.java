package joey.com.pokedexapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon { 

    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("weight")
    @Expose
    private int weight;
    private String mCategory;

    public Pokemon() {

    }

    public Pokemon(int height, String name, List<Stat> stats, int weight) {
        this.height = height;
        this.name = name;
        this.stats = stats;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public class Stat {
        @SerializedName("base_stat")
        @Expose
        private Integer baseStat;
        @SerializedName("stat")
        @Expose
        private Stat_ stat;


        public Integer getBaseStat() {
            return baseStat;
        }

        public void setBaseStat(Integer baseStat) {
            this.baseStat = baseStat;
        }

        public Stat_ getStat() {
            return stat;
        }

        public void setStat(Stat_ stat) {
            this.stat = stat;
        }

    }

    public class Stat_ {

        @SerializedName("name")
        @Expose
        private String statName;

        public String getStatName() { return statName; }

        public void setStatName(String statName) {
            this.statName = statName;
        }

    }

}



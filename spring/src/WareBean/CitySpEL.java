package WareBean;

public class CitySpEL {
    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    private String name;
    private String state;
    private int population;

    public void setChosenCity(CitySpEL chosenCity) {
        this.chosenCity = chosenCity;
    }

    public void setBigCities(CitySpEL[] bigCities) {
        this.bigCities = bigCities;
    }

    public void setaBigCity(CitySpEL aBigCity) {
        this.aBigCity = aBigCity;
    }

    public void setCityNames(String[] cityNames) {
        this.cityNames = cityNames;
    }

    public CitySpEL chosenCity;
    private CitySpEL[] bigCities;
    private CitySpEL aBigCity;
    private String[] cityNames;
}

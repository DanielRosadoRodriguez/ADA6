import java.lang.reflect.Field;

/**
 * Clase mamattora italiannis wine
 */

public class Wine {
    private float fixedAcidity;
    private float volatileAcidity;
    private float citricAcid;
    private float residualSugar;
    private float chlorides;
    private float freeSulfurDioxide;
    private float totalSulfurDioxide;
    private float density;
    private float pH;
    private float sulphates;
    private float alcohol;
    private float quality;
    private String color;
    private Object valueToCompare;
    public Wine(float fixedAcidity, float volatileAcidity, float citricAcid, float residualSugar, float chlorides,
            float freeSulfurDioxide, float totalSulfurDioxide, float density, float pH, float sulphates, float alcohol,
            float quality, String color, String valueToCompare) throws NoSuchFieldException, SecurityException {
        this.fixedAcidity = fixedAcidity;
        this.volatileAcidity = volatileAcidity;
        this.citricAcid = citricAcid;
        this.residualSugar = residualSugar;
        this.chlorides = chlorides;
        this.freeSulfurDioxide = freeSulfurDioxide;
        this.totalSulfurDioxide = totalSulfurDioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
        this.quality = quality;
        this.color = color;
        this.valueToCompare = getValueToCompare(valueToCompare);
    }

    public Object getValueToCompare(String colName) throws NoSuchFieldException, SecurityException{
        switch(colName){
            case "fixedAcidity":
                return fixedAcidity;
            case "volatileAcidity":
                return volatileAcidity;
            case "citricAcid":
                return citricAcid;
            case "residualSugar":
                return residualSugar;
            case "chlorides":
                return chlorides;
            case "freeSulfurDioxide":
                return freeSulfurDioxide;
            case "totalSulfurDioxide":
                return totalSulfurDioxide;
            case "density":
                return density;
            case "pH":
                return pH;
            case "sulphates":
                return sulphates;
            case "alcohol":
                return alcohol;
            case "quality":
                return quality;
            case "color":
                return color;
            default:
                return false;
        }
    }

    public float getFixedAcidity() {
        return fixedAcidity;
    }
    public void setFixedAcidity(float fixedAcidity) {
        this.fixedAcidity = fixedAcidity;
    }
    public float getVolatileAcidity() {
        return volatileAcidity;
    }
    public void setVolatileAcidity(float volatileAcidity) {
        this.volatileAcidity = volatileAcidity;
    }
    public float getCitricAcid() {
        return citricAcid;
    }
    public void setCitricAcid(float citricAcid) {
        this.citricAcid = citricAcid;
    }
    public float getResidualSugar() {
        return residualSugar;
    }
    public void setResidualSugar(float residualSugar) {
        this.residualSugar = residualSugar;
    }
    public float getChlorides() {
        return chlorides;
    }
    public void setChlorides(float chlorides) {
        this.chlorides = chlorides;
    }
    public float getFreeSulfurDioxide() {
        return freeSulfurDioxide;
    }
    public void setFreeSulfurDioxide(float freeSulfurDioxide) {
        this.freeSulfurDioxide = freeSulfurDioxide;
    }
    public float getTotalSulfurDioxide() {
        return totalSulfurDioxide;
    }
    public void setTotalSulfurDioxide(float totalSulfurDioxide) {
        this.totalSulfurDioxide = totalSulfurDioxide;
    }
    public float getDensity() {
        return density;
    }
    public void setDensity(float density) {
        this.density = density;
    }
    public float getpH() {
        return pH;
    }
    public void setpH(float pH) {
        this.pH = pH;
    }
    public float getSulphates() {
        return sulphates;
    }
    public void setSulphates(float sulphates) {
        this.sulphates = sulphates;
    }
    public float getAlcohol() {
        return alcohol;
    }
    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }
    public float getQuality() {
        return quality;
    }
    public void setQuality(float quality) {
        this.quality = quality;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
}

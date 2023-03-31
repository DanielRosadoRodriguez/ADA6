/**
 * 
 * Clase para representar un vino.
 */
public class Wine {

    /**
     * 
     * La acidez fija del vino.
     */
    private float fixedAcidity;
    /**
     * 
     * La acidez volátil del vino.
     */
    private float volatileAcidity;
    /**
     * 
     * La cantidad de ácido cítrico del vino.
     */
    private float citricAcid;
    /**
     * 
     * El nivel de azúcar residual del vino.
     */
    private float residualSugar;
    /**
     * 
     * La cantidad de cloruros en el vino.
     */
    private float chlorides;
    /**
     * 
     * La cantidad de dióxido de azufre libre en el vino.
     */
    private float freeSulfurDioxide;
    /**
     * 
     * La cantidad total de dióxido de azufre en el vino.
     */
    private float totalSulfurDioxide;
    /**
     * 
     * La densidad del vino.
     */
    private float density;
    /**
     * 
     * El pH del vino.
     */
    private float pH;
    /**
     * 
     * La cantidad de sulfatos en el vino.
     */
    private float sulphates;
    /**
     * 
     * El contenido de alcohol del vino.
     */
    private float alcohol;
    /**
     * 
     * La calidad del vino.
     */
    private float quality;
    /**
     * 
     * El color del vino.
     */
    private String color;
    /**
     * 
     * El valor a utilizar para la comparación en los algoritmos de ordenamiento.
     */
    private Object valueToCompare;

    /**
     * 
     * Constructor para la clase Wine.
     * 
     * @param fixedAcidity       La acidez fija del vino.
     * @param volatileAcidity    La acidez volátil del vino.
     * @param citricAcid         La cantidad de ácido cítrico del vino.
     * @param residualSugar      El nivel de azúcar residual del vino.
     * @param chlorides          La cantidad de cloruros en el vino.
     * @param freeSulfurDioxide  La cantidad de dióxido de azufre libre en el vino.
     * @param totalSulfurDioxide La cantidad total de dióxido de azufre en el vino.
     * @param density            La densidad del vino.
     * @param pH                 El pH del vino.
     * @param sulphates          La cantidad de sulfatos en el vino.
     * @param alcohol            El contenido de alcohol del vino.
     * @param quality            La calidad del vino.
     * @param color              El color del vino.
     * @throws NoSuchFieldException Si el campo valueToCompare no existe.
     * @throws SecurityException    Si hay un problema de seguridad.
     */
    public Wine(float fixedAcidity, float volatileAcidity, float citricAcid, float residualSugar, float chlorides,
            float freeSulfurDioxide, float totalSulfurDioxide, float density, float pH, float sulphates, float alcohol,
            float quality, String color) throws NoSuchFieldException, SecurityException {
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
    }

    /**
     * Método para obtener el valor a utilizar para la comparación en los algoritmos
     * de ordenamiento.
     * @return El valor a utilizar para la comparación en los algoritmos de ordenamiento.
     */
    public Object getValueToCompare() {
        return this.valueToCompare;
    }

    /**
     * Método para establecer el valor a utilizar para la comparación en los
     * algoritmos de ordenamiento.
     * 
     * @param columnToCompare El nombre de la columna a utilizar para el ordenamiento
     */
    public void setValueToCompare(String columnToCompare) {
        switch (columnToCompare) {
            case "fixedAcidity":
                this.valueToCompare = this.fixedAcidity;
                break;
            case "volatileAcidity":
                this.valueToCompare = this.volatileAcidity;
                break;
            case "citricAcid":
                this.valueToCompare = this.citricAcid;
                break;
            case "residualSugar":
                this.valueToCompare = this.residualSugar;
                break;
            case "chlorides":
                this.valueToCompare = this.chlorides;
                break;
            case "freeSulfurDioxide":
                this.valueToCompare = this.freeSulfurDioxide;
                break;
            case "totalSulfurDioxide":
                this.valueToCompare = this.totalSulfurDioxide;
                break;
            case "density":
                this.valueToCompare = this.density;
                break;
            case "pH":
                this.valueToCompare = this.pH;
                break;
            case "sulphates":
                this.valueToCompare = this.sulphates;
                break;
            case "alcohol":
                this.valueToCompare = this.alcohol;
                break;
            case "quality":
                this.valueToCompare = this.quality;
                break;
            case "color":
                this.valueToCompare = (float) (this.color.hashCode());
                break;
            default:
                System.out.println("column not found");
                break;
        }
    }

    /**
     * Método para obtener el color del vino.
     * 
     * @return El color del vino.
     */
    public float getFixedAcidity() {
        return fixedAcidity;
    }

    /**
     * Método para establecer el color del vino.
     * 
     * @param fixedAcidity El color del vino.
     */
    public void setFixedAcidity(float fixedAcidity) {
        this.fixedAcidity = fixedAcidity;
    }

    /**
     * Método para obtener la acidez volátil del vino.
     * 
     * @return La acidez volátil del vino.
     */
    public float getVolatileAcidity() {
        return volatileAcidity;
    }

    /**
     * Método para establecer la acidez volátil del vino.
     * 
     * @param volatileAcidity La acidez volátil del vino.
     */
    public void setVolatileAcidity(float volatileAcidity) {
        this.volatileAcidity = volatileAcidity;
    }

    /**
     * Método para obtener la cantidad de ácido cítrico del vino.
     * 
     * @return La cantidad de ácido cítrico del vino.
     */
    public float getCitricAcid() {
        return citricAcid;
    }

    /**
     * Método para establecer la cantidad de ácido cítrico del vino.
     * 
     * @param citricAcid La cantidad de ácido cítrico del vino.
     */
    public void setCitricAcid(float citricAcid) {
        this.citricAcid = citricAcid;
    }

    /**
     * Método para obtener la cantidad de azúcar residual del vino.
     * 
     * @return La cantidad de azúcar residual del vino.
     */
    public float getResidualSugar() {
        return residualSugar;
    }

    /**
     * Método para establecer la cantidad de azúcar residual del vino.
     * 
     * @param residualSugar La cantidad de azúcar residual del vino.
     */
    public void setResidualSugar(float residualSugar) {
        this.residualSugar = residualSugar;
    }

    /**
     * Método para obtener la cantidad de cloruros del vino.
     * 
     * @return La cantidad de cloruros del vino.
     */
    public float getChlorides() {
        return chlorides;
    }

    /**
     * Método para establecer la cantidad de cloruros del vino.
     * 
     * @param chlorides La cantidad de cloruros del vino.
     */
    public void setChlorides(float chlorides) {
        this.chlorides = chlorides;
    }

    /**
     * Método para obtener la cantidad de dióxido de azufre libre del vino.
     * 
     * @return La cantidad de dióxido de azufre libre del vino.
     */
    public float getFreeSulfurDioxide() {
        return freeSulfurDioxide;
    }

    /**
     * Método para establecer la cantidad de dióxido de azufre libre del vino.
     * 
     * @param freeSulfurDioxide La cantidad de dióxido de azufre libre del vino.
     */
    public void setFreeSulfurDioxide(float freeSulfurDioxide) {
        this.freeSulfurDioxide = freeSulfurDioxide;
    }

    /**
     * Método para obtener la cantidad de dióxido de azufre total del vino.
     * 
     * @return La cantidad de dióxido de azufre total del vino.
     */
    public float getTotalSulfurDioxide() {
        return totalSulfurDioxide;
    }

    /**
     * Método para establecer la cantidad de dióxido de azufre total del vino.
     * 
     * @param totalSulfurDioxide La cantidad de dióxido de azufre total del vino.
     */
    public void setTotalSulfurDioxide(float totalSulfurDioxide) {
        this.totalSulfurDioxide = totalSulfurDioxide;
    }

    /**
     * Método para obtener la densidad del vino.
     * 
     * @return La densidad del vino.
     */
    public float getDensity() {
        return density;
    }

    /**
     * Método para establecer la densidad del vino.
     * 
     * @param density La densidad del vino.
     */
    public void setDensity(float density) {
        this.density = density;
    }

    /**
     * Método para obtener el pH del vino.
     * 
     * @return El pH del vino.
     */
    public float getpH() {
        return pH;
    }

    /**
     * Método para establecer el pH del vino.
     * 
     * @param pH El pH del vino.
     */
    public void setpH(float pH) {
        this.pH = pH;
    }

    /**
     * Método para obtener la cantidad de sulfatos del vino.
     * 
     * @return La cantidad de sulfatos del vino.
     */
    public float getSulphates() {
        return sulphates;
    }

    /**
     * Método para establecer la cantidad de sulfatos del vino.
     * 
     * @param sulphates La cantidad de sulfatos del vino.
     */
    public void setSulphates(float sulphates) {
        this.sulphates = sulphates;
    }

    /**
     * Método para obtener la cantidad de alcohol del vino.
     * 
     * @return La cantidad de alcohol del vino.
     */
    public float getAlcohol() {
        return alcohol;
    }

    /**
     * Método para establecer la cantidad de alcohol del vino.
     * 
     * @param alcohol La cantidad de alcohol del vino.
     */
    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    /**
     * Método para obtener la calidad del vino.
     * 
     * @return La calidad del vino.
     */
    public float getQuality() {
        return quality;
    }

    /**
     * Método para establecer la calidad del vino.
     * 
     * @param quality La calidad del vino.
     */
    public void setQuality(float quality) {
        this.quality = quality;
    }

    /**
     * Método para obtener el color del vino.
     * 
     * @return El color del vino.
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para establecer el color del vino.
     * 
     * @param color El color del vino.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método para obtener el tipo de vino.
     * 
     * @param newValue el valor que se usa para ordenar la lista
     */
    public void modifyValueToCompare(Float newValue) {
        this.valueToCompare = newValue;
    }

}

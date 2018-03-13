class Thermometer extends Meter {
  private float minTemp;
  private float maxTemp;

  public Thermometer (String ID, float min, float max) {
    super(ID);
    minTemp = min;
    maxTemp = max;
  }

  public float getMinValue () { return minTemp; }
  public float getMaxValue () { return maxTemp; }
  public String getUnit    () { return "Celcius"; }
}

class Thermometer extends Meter {
  private float minTemp;
  private float maxTemp;

  public Thermometer (float min, float max) {
    minTemp = min;
    maxTemp = max;
  }

  public float getMinValue () { return minTemp; }
  public float getMaxValue () { return maxTemp; }
  public String getUnit    () { return "Celcius"; }
}

class Thermometer extends Meter {
  private float minTemp;
  private float maxTemp;

  public Thermometer (String reg, String pos, float min, float max) {
    super(reg, pos);
    minTemp = min;
    maxTemp = max;
  }

  public float getMinValue () { return minTemp; }
  public float getMaxValue () { return maxTemp; }
  public String getUnit    () { return "Celcius"; }
}

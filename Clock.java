class Clock extends Meter {
  private float minSecs;

  public Clock (float min) {
    minSecs = min;
  }

  public float  getMinValue () { return minSecs; }
  public float  getMaxValue () { return Float.MAX_VALUE; }
  public String getUnit     () { return "Seconds"; }
}

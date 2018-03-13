class Clock extends Meter {
  private float minSecs;

  public Clock (String reg, String pos, float min) {
    super(reg, pos);
    minSecs = min;
  }

  public float  getMinValue () { return minSecs; }
  public float  getMaxValue () { return Float.MAX_VALUE; }
  public String getUnit     () { return "Seconds"; }
}

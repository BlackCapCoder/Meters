class Scale extends Meter {
  private float minWeight;
  private float maxWeight;

  public Scale (String reg, String pos, float min, float max) {
    super(reg, pos);
    minWeight = min;
    maxWeight = max;
  }

  public float getMinValue () { return minWeight; }
  public float getMaxValue () { return maxWeight; }
  public String getUnit    () { return "Grams"; }
}

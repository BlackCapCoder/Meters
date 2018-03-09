class Scale extends Meter {
  private float minWeight;
  private float maxWeight;

  public Scale (float min, float max) {
    minWeight = min;
    maxWeight = max;
  }

  public float getMinValue () { return minWeight; }
  public float getMaxValue () { return maxWeight; }
  public String getUnit    () { return "Grams"; }
}

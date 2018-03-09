abstract class Meter {
  private Boolean broken = false;

  public abstract float  getMinValue ();
  public abstract float  getMaxValue ();
  public abstract String getUnit     ();

  public void    setBroken (Boolean b) { broken = b; }
  public Boolean getBroken (         ) { return broken; }
  public void toggleBroken (         ) { broken = !broken; }

  public Boolean equals (Meter b) {
    Meter a = this;

    if (a.getClass() != b.getClass()) return false;

    return a.getMinValue() == b.getMinValue()
        && a.getMaxValue() == b.getMaxValue()
         ;
  }

  public String toString () {
    String name = this.getClass().getName();

    return name + ", measures "
         + Float.toString(this.getMinValue()) + "-"
         + Float.toString(this.getMaxValue()) + " "
         + this.getUnit().toLowerCase()
         + (this.getBroken() ? ", broken" : "")
         ;
  }
}
